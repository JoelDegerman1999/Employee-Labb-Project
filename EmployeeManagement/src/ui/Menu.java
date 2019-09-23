package ui;

import java.util.Scanner;

import models.Employee;
import models.EmployeeManagement;
import models.Programmer;
import models.exception.EmployeeNotFoundException;
import utilities.GenderType;

public class Menu {
	private static Scanner sc = new Scanner(System.in);
	static EmployeeManagement em = new EmployeeManagement();

	public static void loadStartEmployees() {
		Programmer p1 = new Programmer("Joel", 50000, GenderType.MALE);
		Programmer p2 = new Programmer("Micke", 40000, GenderType.MALE);

		em.registerEmployee(p1);
		em.registerEmployee(p2);
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

	public static void printEmployeeStatistcsMenuOptions() {
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

	public static void printEmployeeManagementMenu() {
		boolean backToMainMenu = false;

		do {
			printEmployeeManagementOptions();
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				registerEmployee();
				break;

			case 2:
				removeEmployee();
				break;

			case 3:
				updateSalary();
				break;

			case 4:
				findEmployee();
				break;

			case 5:
				deliverBonus();
				break;

			case 6:
				employeeList();
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
			printEmployeeStatistcsMenuOptions();

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				double averageWage = em.getAverageWage();
				System.out.println("Average wage at the company is: " + averageWage);
				System.out.println("\nPress enter to continue");
				sc.nextLine();
				sc.nextLine();
				break;

			case 2:
				Employee maxSalaryEmployee = em.getMaxSalary();
				System.out.println("Employee with highest salary:\n");
				System.out.println(maxSalaryEmployee);
				System.out.println("\nPress enter to continue");
				sc.nextLine();
				sc.nextLine();
				break;

			case 3:
				Employee minSalaryEmployee = em.getMinSalary();
				System.out.println("Employee with lowest salary:\n");
				System.out.println(minSalaryEmployee);
				System.out.println("\nPress enter to continue");
				sc.nextLine();
				sc.nextLine();
				break;

			case 4:
				// metoden printar.
				em.getGenderDistribution();
				System.out.println("Press enter to continue");
				sc.nextLine();
				sc.nextLine();
				break;
			case 0:
				backToMainMenu = true;
			default:
				break;
			}

		} while (!backToMainMenu);
	}

	private static void employeeList() {
		System.out.println("\nEmployee list (Name / ID / Profession):\n");
		em.listEmployees();
		System.out.println();
		System.out.println("Press enter to continue");
		sc.nextLine();
		sc.nextLine();
	}

	private static void registerEmployee() {
		Employee newEmployee = EmployeeManagement.createEmployee();
		em.registerEmployee(newEmployee);
		System.out.println("\nEmployee registred, press enter to continue");
		sc.nextLine();// nolställa cache
		sc.nextLine();
	}

	private static void removeEmployee() {
		System.out.print("\nEnter ID for employee to remove: ");
		int ID = sc.nextInt();
		sc.nextLine();
		try {
			em.removeEmployee(em.getEmployeeByID(ID));
			System.out.println("Employee with ID: " + ID + " was removed. \n(Press enter to continue)");
			sc.nextLine();
		} catch (EmployeeNotFoundException e) {
			System.out.println("\nEmployee not found. \n(Press enter to continue)");
			sc.nextLine();
		}
	}

	private static void updateSalary() {
		System.out.print("\nEnter ID for employee to update salary: ");
		int ID = sc.nextInt();
		System.out.print("\nEnter new salary: ");
		int newSalary = sc.nextInt();
		sc.nextLine();
		try {
			Employee foundEmployee = em.getEmployeeByID(ID);
			foundEmployee.setSalary(newSalary);
			System.out.println("Salary changed to " + newSalary + " for employee: \n");
			System.out.println(foundEmployee);

			System.out.println("(Press enter to continue)");
			sc.nextLine();
		} catch (EmployeeNotFoundException e) {
			System.out.println("\nEmployee not found. \n(Press enter to continue)");
			sc.nextLine();
		}
	}

	private static void findEmployee() {
		System.out.print("\nEnter ID for employee to find: ");
		int ID = sc.nextInt();
		sc.nextLine();
		try {
			Employee foundEmployee = em.getEmployeeByID(ID);
			System.out.println(foundEmployee);
			System.out.println("(Press enter to continue)");
			sc.nextLine();
		} catch (EmployeeNotFoundException e) {
			System.out.println("\nEmployee not found. \n(Press enter to continue)");
			sc.nextLine();
		}

	}

	private static void deliverBonus() {
		System.out.print("\nDeliver bonuses to employees? (yes/no): ");
		sc.nextLine();
		String bonusAnswer = sc.nextLine();
		if (bonusAnswer.equalsIgnoreCase("yes")) {
			em.deliverBonuses();
			System.out.println("(Press enter to continue)");
			sc.nextLine();
		} else {
			System.out.println("Wrong input");
			sc.nextLine();
		}

	}

}
