package department.crud;

import authentication.entity.User;
import department.entity.Department;
import positions.entity.Position;
import positions.account.service.PositionAccount;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

public class DepartmentCRUDOperation {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DbConnect");

    public void insertDepartment(String departmentName, String description, User director, int createdBy, Timestamp createdOn){

        //obtaining entity manager from the entity manager factory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //create entity transaction object and begin transaction
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        try{
            Department department = new Department();
            department.setDepartmentName(departmentName);
            department.setDepartmentDescription(description);
            department.setCreatedBy(createdBy);
            department.setCreatedOn(createdOn);
            department.setDirector(director);

            //persist the user instance
            entityManager.persist(department);

            //commit transaction
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        entityManager.close();

    }

    public Department findDepartment(String departmentName){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT d FROM Department d WHERE d.departmentName = :departmentName");
        query.setParameter("departmentName",departmentName);

        List<Department> departments = query.getResultList();


        if (!departments.isEmpty()) {

            for (Department department: departments){
                return department;
            }


        }
        return  null;
    }
    public static void main(String[] args){
        positions.crud.PositionCRUIDOperation positionCRUIDOperation = new positions.crud.PositionCRUIDOperation();
        System.out.println(positionCRUIDOperation.findPosition("Support"));

    }
}
