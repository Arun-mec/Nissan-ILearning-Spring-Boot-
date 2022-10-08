package com.nissan.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.nissan.model.Professor;

public class CrudRepoImplimentation implements IcrudRepository {

	public void insertEntity() {

		// EntityManagerFactory
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

			// create an object of professor
			Professor professor = new Professor();

			// get input from the user
			System.out.println("Enter the first name of the user:");
			professor.setFirstName(scanner.nextLine());

			System.out.println("Enter the last name of the user:");
			professor.setLastName(scanner.nextLine());

			System.out.println("Enter the dept no. of the user:");
			professor.setDeptNo(Integer.parseInt(scanner.nextLine()));

			System.out.println("Enter the salary of the user:");
			professor.setSalary(Double.parseDouble(scanner.nextLine()));

			System.out.println("Enter the jooining date(yyyy-mm-dd");
			professor.setJoinDtae(LocalDate.parse(scanner.nextLine()));

			System.out.println("Enter the date of birth(yyyy-mm-dd");
			professor.setDateOfBirth(LocalDate.parse(scanner.nextLine()));

			System.out.println("Enter the gender");
			professor.setGender(scanner.nextLine());

			// ORM
			entityManager.persist(professor);

			// DB
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}

	}

	// read all professors
	public void getProfessors() {
		// TODO Auto-generated method stub
		// EntityManagerFactory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();

			// List all employees
			// JPQL = Java persistant query langauge
			List<Professor> professors = entityManager.createQuery("from Professor").getResultList();

			for (Professor professor : professors) {
				System.out.println("Professor first name:" + professor.getFirstName());
				System.out.println("Professor last name:" + professor.getLastName());
				System.out.println("Professor dept no.:" + professor.getDeptNo());
				System.out.println("Professor salary:" + professor.getSalary());
				System.out.println("Joining date:" + professor.getJoinDtae());
				System.out.println("Date of birth:" + professor.getDateOfBirth());
				System.out.println("Gender:" + professor.getGender());
			}
		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}

	}

	// Edit a professor
	public void updateEntity() {
		// EntityManagerFactory
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
			Professor professorOne = entityManager.find(Professor.class, id);

			// change lastname and firstname
			System.out.println("Enter the first name :");
			professorOne.setFirstName(scanner.nextLine());

			System.out.println("Enter the last name :");
			professorOne.setLastName(scanner.nextLine());

			// after update
			entityManager.getTransaction().commit();
			System.out.println(professorOne);

		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}

	}

	public void deleteEntity() {
		// EntityManagerFactory
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
			Professor professorOne = entityManager.find(Professor.class, id);

			// delete the entity
			entityManager.remove(professorOne);

			// after update
			entityManager.getTransaction().commit();
			System.out.println("Congratulations! the record has been deleted!");

		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}
	}

	public void searchById() {
		
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
			Professor professor = entityManager.find(Professor.class, id);

			// display the entity
			if (professor!= null) {
				System.out.println("Professor first name:" + professor.getFirstName());
				System.out.println("Professor last name:" + professor.getLastName());
				System.out.println("Professor dept no.:" + professor.getDeptNo());
				System.out.println("Professor salary:" + professor.getSalary());
				System.out.println("Joining date:" + professor.getJoinDtae());
				System.out.println("Date of birth:" + professor.getDateOfBirth());
				System.out.println("Gender:" + professor.getGender());
				
			} else {
				System.out.println("Item is not there in the list!");
			}

		} catch (Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}
	}

	public Optional<Professor> searchByName(String name) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("DemoEmpDB");
			entityManager = emf.createEntityManager();

			// List all employees
			// JPQL = Java persistant query langauge
			Professor professor = entityManager.createQuery("SELECT p FROM Professor p WHERE p.firstName=:name",Professor.class)
					.setParameter("firstName", name).getSingleResult();

			
		return (Optional<Professor>)((professor!=null) ? Optional.of(professor):Optional.empty());
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		return null;
	}

}
