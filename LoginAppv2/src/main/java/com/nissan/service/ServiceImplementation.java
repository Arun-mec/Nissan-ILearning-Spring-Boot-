package com.nissan.service;

import java.util.Scanner;

import com.nissan.repo.IUserRepo;
import com.nissan.repo.UserRepoImplementation;

public class ServiceImplementation {
	
	// interface definiition
	IUserRepo iuser = new UserRepoImplementation();
	
	Scanner scanner = new Scanner(System.in);
	
	public ServiceImplementation() {
		super();
	}
	
	// main menu to return
	public void mainMenu() {
		
		char choice = 'y';
		
		do {
			
			System.out.println("Enter your choice\n1. Add user\n2. Edit user\n3. Disable user\n"
					+ "4. List all users\n5. Search by name\n6. Exit");
			int option = scanner.nextInt();
			
			switch(option) {
			case 1:
				iuser.addUser();
				break;
			case 2:
				iuser.updateUser();
				break;
			case 3:
				iuser.disableUser();
				break;
			case 4:
				iuser.listUsers();
				break;
			case 5:
				iuser.searchUser();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid selection!");
				break;
				
			}
			
		}while(choice=='y' || choice=='Y');
		
	}

}
