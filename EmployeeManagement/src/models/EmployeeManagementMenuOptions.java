package models;

import models.exception.EmployeeNotFoundException;
import utilities.Utilities;

public class EmployeeManagementMenuOptions {
	EmployeeManagement em;

	public EmployeeManagementMenuOptions(EmployeeManagement management) {
		em = management;
	}

	public void registerEmployee() {
		Employee newEmployee = EmployeeManagement.createEmployee();
		em.registerEmployee(newEmployee);
		System.out.println("\nEmployee registred, press enter to continue");
		//Detta för att koden ska stanna av för att vi ska hinna läsa!
		Utilities.sc.nextLine();
		Utilities.sc.nextLine();
	}

	public void removeEmployee() {
		System.out.print("\nEnter ID for employee to remove: ");
		int ID = Utilities.sc.nextInt();
		// Reset cache on Scanner
		Utilities.sc.nextLine();
		try {
			em.removeEmployee(em.getEmployeeByID(ID));
			System.out.println("Employee with ID: " + ID + " was removed. \n(Press enter to continue)");
			Utilities.sc.nextLine();
		} catch (EmployeeNotFoundException e) {
			System.out.println("\nEmployee not found. \n(Press enter to continue)");
			Utilities.sc.nextLine();
		}
	}

	public void updateSalary() {
		System.out.print("\nEnter ID for employee to update salary: ");
		int ID = Utilities.sc.nextInt();
		Utilities.sc.nextLine();
		try {
			Employee foundEmployee = em.getEmployeeByID(ID);
			System.out.print("\nEnter new salary: ");
			int newSalary = Utilities.sc.nextInt();
			foundEmployee.setSalary(newSalary);
			System.out.println("Salary changed to " + newSalary + " for employee: \n");
			System.out.println(foundEmployee);
			System.out.println("\nPress enter to continue");
			Utilities.sc.nextLine();
			Utilities.sc.nextLine();
		} catch (EmployeeNotFoundException e) {
			System.out.println("\nEmployee not found. \n(Press enter to continue)");
			Utilities.sc.nextLine();
		}
	}
	
	public void findEmployee() {
		System.out.print("\nEnter ID for employee to find: ");
		int ID = Utilities.sc.nextInt();
		Utilities.sc.nextLine();
		try {
			Employee foundEmployee = em.getEmployeeByID(ID);
			System.out.println(foundEmployee);
			System.out.println("(Press enter to continue)");
			Utilities.sc.nextLine();
		} catch (EmployeeNotFoundException e) {
			System.out.println("\nEmployee not found. \n(Press enter to continue)");
			Utilities.sc.nextLine();
		}

	}
	
	public void deliverBonus() {
		System.out.print("\nDeliver bonuses to employees? (yes/no): ");
		Utilities.sc.nextLine();
		String bonusAnswer = Utilities.sc.nextLine();
		if (bonusAnswer.equalsIgnoreCase("yes")) {
			em.deliverBonuses();
			System.out.println("(Press enter to continue)");
			Utilities.sc.nextLine();
		} else {
			System.out.println("Wrong input");
			Utilities.sc.nextLine();
		}
	}
	
	public void employeeList() {
		System.out.println("\nEmployee list (Name / ID / Profession):\n");
		em.listEmployees();
		System.out.println("\nPress enter to continue");
		//Detta för att koden ska stanna av för att vi ska hinna läsa!
		Utilities.sc.nextLine();
		Utilities.sc.nextLine();
	}
}
