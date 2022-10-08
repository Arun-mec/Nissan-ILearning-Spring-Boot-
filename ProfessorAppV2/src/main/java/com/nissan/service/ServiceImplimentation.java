package com.nissan.service;

import java.util.Scanner;

import com.nissan.repo.CrudRepoImplimentation;
import com.nissan.repo.IcrudRepository;

public class ServiceImplimentation {
	
	//constructor injection
	//call methods
	
	IcrudRepository crud = new CrudRepoImplimentation();
	
	Scanner scanner = new Scanner(System.in);
	char choice = 'y';
	//menudriven
	// default constructor --consructor injection
	public ServiceImplimentation() {
		super();
	}
	
	// MenuDriven
	
	public void menuDriven() {
		
		do {
			
			//show choice
			System.out.println("\n1. Add a professor\n2. Search professor\n3. Edit professor\n"
					+ "4. Delete a professor\n5. Find all professor\n6. Find by name\n7. Exit\n"
					+ "Enter your choice...");
			int option = scanner.nextInt();
			
			switch(option) {
			case 1: 
				crud.insertEntity();
				break;
			case 2: 
//				crud.insertEntity();
				break;
			case 3: 
				crud.updateEntity();
				break;
			case 4: 
//				crud.insertEntity();
				break;
			case 5: 
				crud.getProfessors();
				break;
			case 6: 
				System.out.println("Enter the name:");
				String name = scanner.nextLine();
				crud.searchByName(name);
				break;
			case 7: 
				System.exit(0);
				break;
			
			default	: 
				System.out.println("Invalid input, please try to change it!");
				break;
			}
			
			
		}while(choice=='y'|| choice=='y');
		
	}
}
