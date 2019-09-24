package ui;

import models.EmployeeManagement;
import models.EmployeeManagementMenuOptions;
import models.EmployeeStatisticsMenuOptions;
import models.Programmer;
import models.Salesman;
import utilities.GenderType;
import utilities.Utilities;

public class Menu {
	static EmployeeManagement em = new EmployeeManagement();
	
	//Creating an instance of the class and gives the EmployeeManagement in the parameter to be able to use it!
	static EmployeeManagementMenuOptions employeeManagementMenuOptions = new EmployeeManagementMenuOptions(em);
	//Creating an instance of the class and gives the EmployeeManagement in the parameter to be able to use it!
	static EmployeeStatisticsMenuOptions employeeStatisticsMenuOptions = new EmployeeStatisticsMenuOptions(em);

	//Adding 4 employees to start off with!
	public static void loadStartEmployees() {
		Programmer p1 = new Programmer("Joel", 50000, GenderType.MALE);
		Programmer p2 = new Programmer("Micke", 40000, GenderType.MALE);
		Salesman s1 = new Salesman("Emma", 35000, GenderType.FEMALE);
		Salesman s2 = new Salesman("Kalle", 20000, GenderType.MALE);

		em.registerEmployee(p1);
		em.registerEmployee(p2);
		em.registerEmployee(s1);
		em.registerEmployee(s2);
	}

	public static void printEmployeeManagementMenu() {
		boolean backToMainMenu = false;
		
		do {
			printEmployeeManagementOptions();
			int choice = Utilities.sc.nextInt();
			
			switch (choice) {
			case 1:
				employeeManagementMenuOptions.registerEmployee();
				break;

			case 2:
				employeeManagementMenuOptions.removeEmployee();
				break;

			case 3:
				employeeManagementMenuOptions.updateSalary();
				break;

			case 4:
				employeeManagementMenuOptions.findEmployee();
				break;

			case 5:
				employeeManagementMenuOptions.deliverBonus();
				break;

			case 6:
				employeeManagementMenuOptions.employeeList();
				break;

			case 0:
				backToMainMenu = true;
				break;

			default:
				break;
			}
		} while (!backToMainMenu);

	}

	public static void printEmployeeStatisticsMenu() {
		boolean backToMainMenu = false;
		do {
			printEmployeeStatistcsOptions();

			int choice = Utilities.sc.nextInt();

			switch (choice) {
			case 1:
				employeeStatisticsMenuOptions.averageWage();
				break;

			case 2:
				employeeStatisticsMenuOptions.getEmployeeWithHighestSalary();
				break;

			case 3:
				employeeStatisticsMenuOptions.getEmployeeWithLowestSalary();
				break;

			case 4:
				employeeStatisticsMenuOptions.getGenderDistribution();
				break;
			case 0:
				backToMainMenu = true;
			default:
				break;
			}

		} while (!backToMainMenu);
	}

	public static void printMenu() {
		System.out.println("+--------------------------------------------------------+");
		System.out.println("+---Employee Management by Joel, Mikael, Patrik © 2019---+");
		System.out.println("+--------------------------------------------------------+\n");

		System.out.println("1. Employee management");
		System.out.println("2. Employee statistics");
		System.out.println("0. Exit\n");
	}

	public static void printEmployeeManagementOptions() {
		System.out.println("\n+-------------------------+");
		System.out.println("+---Employee Management---+");
		System.out.println("+-------------------------+\n");

		System.out.println("1. Register employee");
		System.out.println("2. Delete employee");
		System.out.println("3. Update Salary of employee");
		System.out.println("4. Search employee by ID");
		System.out.println("5. Deliver bonuses");
		System.out.println("6. Display all employees");
		System.out.println("0. Back to main menu\n");

		System.out.print("Enter your choice: ");
	}

	public static void printEmployeeStatistcsOptions() {
		System.out.println("\n+-----------------------+");
		System.out.println("+---Employee Statistics---+");
		System.out.println("+-------------------------+\n");

		System.out.println("1. Average wage at company");
		System.out.println("2. Maximum salary");
		System.out.println("3. Minimum salary");
		System.out.println("4. Gender distribution");
		System.out.println("0. Back to main menu\n");

		System.out.print("Enter your choice: ");
	}
}
