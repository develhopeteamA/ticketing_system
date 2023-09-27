package TicketingSystem.User;



import TicketingSystem.DatabaseConnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

 class UserAccount {
    private String workEmail;
    private String password;

    Scanner scanner = new Scanner(System.in);

    DatabaseConnection databaseConnection = new DatabaseConnection();
    Connection con = databaseConnection.connectToDataBase();

        public void createAccount() {
        //userData = new ArrayList<>();

        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter your Surname: ");
        String surname = scanner.nextLine();

        System.out.println("Enter your department: ");
        String department = scanner.nextLine();

        System.out.println("Enter your role in this system: ");
        String userRoleInTheSystem = scanner.nextLine();

        System.out.println("Enter your work Position: ");
        String userWorkPosition = scanner.nextLine();

        System.out.println("Enter your Work Email: ");
        String workEmail = scanner.nextLine();
        boolean operate = true;
        while (operate) {
            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
            if (isPasswordValid(password)) {

                System.out.println("Confirm password: ");
                String confirmPassword = scanner.nextLine();
                User newUserAccount = new User(firstName,surname,department,userRoleInTheSystem,userWorkPosition,workEmail,password);

                //to check if user exist
                User user = getUserAccountByWorkEmail(workEmail);

                if (user != null) {
                    System.err.println("The account exist");
                } else {
                    if (newUserAccount.getPassword().equals(confirmPassword)) {
                       //Code for Creating account by inserting user into the database
                    }
                    else{
                        System.err.println("Passwords do not match");
                    }


                }


            } else {
                System.err.println("Kindly enter a valid password with: ");
                System.err.println("atleast an uppercase,lowercase,digit, special character and of length greater than 8");
            }
        }


    }

    public void login() {

        System.out.println("Fill in your details to login or enter 'CANCEL' to quit");

        boolean loginStatus = true;
        while (loginStatus) {
            System.out.println("Enter your work Email/enter cancel to quit: ");
            String workEmailInput = scanner.nextLine();

            if (workEmailInput.equalsIgnoreCase("Cancel")) {
                System.out.println("Quitting the login process..");
                break;
            }
            //cheking if user exist by getUserAccountByWorkEmail method
            User user = getUserAccountByWorkEmail(workEmailInput);
            if (user != null) {

            System.out.println("Enter your password: ");
            String passwordInput = scanner.nextLine();
            if (user.getPassword().equals(passwordInput)) {
                String name = user.getFirstName();

                System.out.println("Logged in successfully as " + name);
                break;
            } else {
                if (passwordInput.equalsIgnoreCase("cancel")){
                    loginStatus=false;
                }else {
                    System.err.println("Invalid details");
                }
            }
        } else {
                System.err.println("User not found");
            }
        }

    }

    public void logout() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Would you like to log out?(yes/No): ");
            String logoutState = scanner.nextLine();

            if (logoutState.equalsIgnoreCase("yes")) {
                System.out.println("You have been logged out, see you soon");
                break;
            } else {
                System.out.println("You are still logged in  ");
            }
        }

    }

    public void resetPassword() {
        boolean operate = true;

        while (operate) {
            System.out.println("Enter your work email or CANCEL to quit:");
            String workEmailInput = scanner.nextLine();

            User user = getUserAccountByWorkEmail(workEmailInput);
            if (user != null) {
                System.out.println("Enter the current password or CANCEL to quit: ");
                String currentPasswordInput = scanner.nextLine();

                if (user.getPassword().equals(currentPasswordInput)) {
                    System.out.println("Enter the new password or CANCEL to quit: ");
                    String newPasswordInput = scanner.nextLine();

                    if (isPasswordValid(newPasswordInput)) {
                        //code for updating the password field in the database
                    } else {
                        if (newPasswordInput.equalsIgnoreCase("cancel")) {
                            operate = false;
                        } else {
                            System.err.println("Enter a valid password: with atleast 8 characters with atleast a digit, a lowercase, an uppercase and a special character");
                        }
                    }

                } else {
                    if (currentPasswordInput.equalsIgnoreCase("cancel")) {
                        operate = false;
                    } else {
                        System.err.println("Password do not match");
                    }
                }

            } else {
                if (workEmailInput.equalsIgnoreCase("cancel")){
                    operate=false;
                }
                else {
                    System.err.println("No such user");
                }
            }

        }
    }




    public void deleteUserAccount(){
        boolean operate = true;

        while (operate) {
            System.out.println("Enter the work email of the user's account you wanna delete or CANCEL to quit: ");

                String userAccountToBeDeletedWorkEmail = scanner.nextLine();
                if(getUserAccountByWorkEmail(userAccountToBeDeletedWorkEmail) != null){
                    //code for deleting the user account from the database
                }
                else{
                    if (userAccountToBeDeletedWorkEmail.equalsIgnoreCase("cancel")){
                        operate=false;
                    }else {
                        System.err.println("No such user");
                    }
                }
        }



    }




//method for cheking if user account exist
    public User getUserAccountByWorkEmail(String workEmail) {
        String sql = "SELECT * FROM users WHERE email=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,workEmail);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int userIDb = resultSet.getInt(1);
                String firstNameDb = resultSet.getString(2);
                String surnameDb = resultSet.getString(3);
                String workEmailDb = resultSet.getString(4);
                String departmentDb = resultSet.getString(5);
                String userRoleDb = resultSet.getString(6);
                String workPositionDb = resultSet.getString(7);
                String passwordDb = resultSet.getString(8);

                User user = new User();
                    user.setUserId(userIDb);
                    user.setFirstName(firstNameDb);
                    user.setSurname(surnameDb);
                    user.setDepartment(departmentDb);
                    user.setUserRoleInTheSystem(userRoleDb);
                    user.setUserWorkPosition(workPositionDb);
                    user.setWorkEmail(workEmailDb);
                    user.setPassword(passwordDb);
                return user;
            }


            }
        catch (SQLException e){
            e.printStackTrace();
        }
        return  null;
    }


     //method for checking if password is valid
    public static boolean isPasswordValid(String newPassword){

        boolean hasLowercase = !newPassword.equals(newPassword.toUpperCase());
        boolean hasUpperCase = !newPassword.equals(newPassword.toLowerCase());
        boolean hasDigit = newPassword.matches(".*\\d.*");
        boolean isLengthValid = newPassword.length() >= 8;
        boolean hasSpecialCharacter = newPassword.matches(".*[^a-zA-Z0-9].*");

        return hasLowercase && hasUpperCase && hasDigit && hasSpecialCharacter && isLengthValid;

    }
}
