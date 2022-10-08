package com.nissan.app;

import com.nissan.service.ServiceImplimentation;

public class DemoProfessorApp {
	
	public static void main(String[] args) {
		
		//calling
		ServiceImplimentation service = new ServiceImplimentation();
		service.menuDriven();
		
	}

}
