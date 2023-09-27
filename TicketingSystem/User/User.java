package TicketingSystem.User;

import java.util.List;


public class User {
    int userId;
    String firstName;
    String surname;

    String department;

    String userRoleInTheSystem;
    String userWorkPosition;
    String workEmail;
    String password;

    public User(){

    }

    public User(String firstName, String surname, String department, String userRoleInTheSystem, String userWorkPosition, String workEmail, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.workEmail = workEmail;
        this.password = password;
        this.department = department;
        this.userRoleInTheSystem = userRoleInTheSystem;
        this.userWorkPosition = userWorkPosition;

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserRoleInTheSystem() {
        return userRoleInTheSystem;
    }

    public void setUserRoleInTheSystem(String userRoleInTheSystem) {
        this.userRoleInTheSystem = userRoleInTheSystem;
    }

    public String getUserWorkPosition() {
        return userWorkPosition;
    }

    public void setUserWorkPosition(String userWorkPosition) {
        this.userWorkPosition = userWorkPosition;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", userRoleInTheSystem='" + userRoleInTheSystem + '\'' +
                ", userWorkPosition='" + userWorkPosition + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
