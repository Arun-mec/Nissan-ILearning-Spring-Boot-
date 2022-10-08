package com.nissan.repo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.nissan.model.User;

public class UserRepoImplementation implements IUserRepo{

	public void addUser() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		Scanner scanner = new Scanner(System.in);
		
		
		try {
			
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			//starting the transaction
			transaction.begin();
			
			User user = new User();
			
			System.out.println("Enter user name");
			user.setUserName(scanner.nextLine());
			
			System.out.println("password");
			user.setUserName(scanner.nextLine());
			
			System.out.println("Enter user role\n1. Admin\n2. User\n3.Coordinator");
			int roleId = Integer.parseInt(scanner.next());
			switch(roleId) {
			case 1: 
				user.setRoleId("Admin");
				break;
			case 2: 
				user.setRoleId("User");
				break;
			case 3: 
				user.setRoleId("Coordinator");
				break;
			default:
				System.out.println("Enter a valid input!");
			}
			
			System.out.println("Enter date: ");
			user.setCreatedDate(LocalDate.parse(scanner.next()));
			
			entityManager.persist(user);
			
			transaction.commit();
		}
		catch(Exception ex) {
			transaction.rollback();
			ex.printStackTrace();
		}
		finally{
			emf.close();
		}
		
	}
	

	public void updateUser() {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		Scanner scanner = new Scanner(System.in);

		// start process
		try {

			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();

			// start transaction
			transaction.begin();

			// search
			System.out.println("Enter the id of the element");
			int id = Integer.parseInt(scanner.nextLine());

			// select from entity manager
			User userOne = entityManager.find(User.class, id);

			// change usrname and password 
			System.out.println("Enter the username :");
			userOne.setUserName(scanner.nextLine());

			System.out.println("Enter the password :");
			userOne.setUserPassword(scanner.nextLine());

			// after update
			entityManager.getTransaction().commit();
			
			//displays after changing the datas
			System.out.println(userOne);

		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}
		
	}
	

	public void disableUser() {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		Scanner scanner = new Scanner(System.in);

		// start process
		try {

			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();

			// start transaction
			transaction.begin();

			// search
			System.out.println("Enter the userid");
			int id = Integer.parseInt(scanner.nextLine());

			// select from entity manager
			User userOne = entityManager.find(User.class, id);

			// delete the entity
			entityManager.remove(userOne);

			// after update!
			entityManager.getTransaction().commit();
			System.out.println("Congratulations! the user has been deleted");

		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}
		
	}
	

	public void listUsers() {
		
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();

			// List all employees
			// JPQL = Java persistant query langauge
			List<User> users = entityManager.createQuery("from Users").getResultList();

			for (User user : users) {
				System.out.println("UserId:	"+user.getUserId());
				System.out.println("Username:	"+user.getUserName());
				System.out.println("Userpassword:	"+user.getUserPassword());
				System.out.println("User roleid:	"+user.getRoleId());
				System.out.println("User created at:	"+user.getCreatedDate());
				
			}
		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}
		
	}
	

	public void searchUser() {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		Scanner scanner = new Scanner(System.in);

		// start process
		try {

			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();

			// search
			System.out.println("Enter the id of the element");
			int id = Integer.parseInt(scanner.nextLine());

			// select from entity manager
			User user = entityManager.find(User.class, id);

			// display the entity
			if (user!= null) {
				System.out.println("UserId:	"+user.getUserId());
				System.out.println("Username:	"+user.getUserName());
				System.out.println("Userpassword:	"+user.getUserPassword());
				System.out.println("User roleid:	"+user.getRoleId());
				System.out.println("User created at:	"+user.getCreatedDate());
				
			} else {
				System.out.println("Item is not there in the list!");
			}

		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}
		
	}

	
}
