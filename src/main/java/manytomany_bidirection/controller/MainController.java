package manytomany_bidirection.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_bidirection.dto.App;
import manytomany_bidirection.dto.User;

public class MainController {

	public static void main(String[] args) {

		User user1 = new User();
		user1.setName("Jayashree");
		user1.setPhone(7896541230l);
		user1.setAddress("Nashik");

		User user2 = new User();
		user2.setName("Manisha");
		user2.setPhone(9865473210l);
		user2.setAddress("Pune");

		User user3 = new User();
		user3.setName("Aakanksha");
		user3.setPhone(9876543210l);
		user3.setAddress("Nagpur");

		App app1 = new App();
		app1.setName("Facebook");
		app1.setCompany("Meta");

		App app2 = new App();
		app2.setName("WhatsApp");
		app2.setCompany("Meta");

		App app3 = new App();
		app3.setName("Instagram");
		app3.setCompany("Meta");

		App app4 = new App();
		app4.setName("Snapchat");
		app4.setCompany("Thomas");

		List<App> list = new ArrayList<App>();
		list.add(app1);
		list.add(app2);
		list.add(app3);
		list.add(app4);

		List<User> list2 = new ArrayList<User>();
		list2.add(user1);
		list2.add(user2);
		list2.add(user3);

		user1.setApps(list);
		user2.setApps(list);
		user3.setApps(list);

		app1.setUsers(list2);
		app2.setUsers(list2);
		app2.setUsers(list2);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shree");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		entityTransaction.begin();
//		entityManager.persist(user1);
//		entityManager.persist(user2);
//		entityManager.persist(user3);
//		entityManager.persist(app1);
//		entityManager.persist(app2);
//		entityManager.persist(app3);
//		entityManager.persist(app4);
//		entityTransaction.commit();
		
		User user = entityManager.find(User.class, 3);
		System.out.println(user2);
		user.setName("JAYA");
		entityTransaction.begin();
		entityManager.merge(user);
//		entityManager.remove(user3);
		entityTransaction.commit();
	}
}
