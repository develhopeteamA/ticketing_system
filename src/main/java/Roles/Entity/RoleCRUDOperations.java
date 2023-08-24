package Roles.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class RoleCRUDOperations {
    //Creating entity manager factory object
    EntityManagerFactory entityManagerFactory = createEntityManagerFactory("DbConnect");

    public void insertRole(String RoleName, int createdBy, Timestamp createdOn) {

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try {
            Role role = new Role();
            role.setRoleName(RoleName);
            role.setCreatedOn(createdOn);
            role.setCreatedBy(createdBy);

            //persist the user instance
            entityManager.persist(role);
            //  commit transaction;
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        entityManager.close();
    }
    public static void main (String[] args){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp createdOn = Timestamp.valueOf(localDateTime.format(formatDate));
        RoleCRUDOperations RoleCRUDOperation = new RoleCRUDOperations();
        RoleCRUDOperation.insertRole("Customer care", 90, createdOn);
    }
}
