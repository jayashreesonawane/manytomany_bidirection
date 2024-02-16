package manytomany_bidirection.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_bidirection.dto.App;
import manytomany_bidirection.dto.User;

public class UdserDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void fetchStudent(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("Student with given id is not found");
        }
    }
	
}
