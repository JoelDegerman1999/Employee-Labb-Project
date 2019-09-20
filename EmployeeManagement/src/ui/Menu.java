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

	static Programmer p1 = new Programmer("Joel", 50000, GenderType.MALE);
	static Programmer p2 = new Programmer("Micke", 40000, GenderType.MALE);

	public static void printMenu() {
		System.out.println("+--------------------------------------------------------+");
		System.out.println("+---Employee Management by Joel, Mikael, Patrik © 2019---+");
		System.out.println("+--------------------------------------------------------+\n");

		System.out.println("1. Employee management");
		System.out.println("2. Employee statistics");
		System.out.println("0. Exit\n");

	}

	public static void printEmployeeManagementMenu() {
		boolean backToMainMenu = false;
		int ID = 0;

		em.registerEmployee(p1);
		em.registerEmployee(p2);

		do {
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
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				Employee newEmployee = EmployeeManagement.createEmployee();
				em.registerEmployee(newEmployee);
				System.out.println("\nEmployee registred, press enter to continue");
				sc.nextLine();// nolställa cache
				sc.nextLine();
				break;

			case 2:
				System.out.print("\nEnter ID for employee to remove: ");
				ID = sc.nextInt();
				sc.nextLine();
				try {
					em.removeEmployee(em.getEmployeeByID(ID));
					System.out.println("Employee with ID: " + ID + " was removed. \n(Press enter to continue)");
				} catch (EmployeeNotFoundException e) {
					System.out.println("\nEmployee not found. \n(Press enter to continue)");
					sc.nextLine();
					break;
				}
				sc.nextLine();
				break;

			case 3:
				System.out.print("\nEnter ID for employee to update salary: ");
				ID = sc.nextInt();
				System.out.print("\nEnter new salary: ");
				int newSalary = sc.nextInt();
				sc.nextLine();
				try {
					Employee foundEmployee = em.getEmployeeByID(ID);
					foundEmployee.setSalary(newSalary);
					System.out.println("Salary changed to " + newSalary + " for employee: \n");
					System.out.println(foundEmployee);
				} catch (EmployeeNotFoundException e) {
					System.out.println("\nEmployee not found. \n(Press enter to continue)");
					sc.nextLine();
					break;
				}
				System.out.println("(Press enter to continue)");
				sc.nextLine();
				break;

			case 4:
				System.out.print("\nEnter ID for employee to find: ");
				ID = sc.nextInt();
				sc.nextLine();
				try {
					Employee foundEmployee = em.getEmployeeByID(ID);
					System.out.println(foundEmployee);
				} catch (EmployeeNotFoundException e) {
					System.out.println("\nEmployee not found. \n(Press enter to continue)");
					sc.nextLine();
					break;
				}
				System.out.println("(Press enter to continue)");
				sc.nextLine();
				break;

			case 5:
				System.out.print("\nDeliver bonuses to employees? (yes/no): ");
				sc.nextLine();
				String bonusAnswer = sc.nextLine();
				if (bonusAnswer.equalsIgnoreCase("yes")) {
					em.deliverBonuses();
					System.out.println("(Press enter to continue)");
					sc.nextLine();
				}else {
					System.out.println("Wrong input");
					sc.nextLine();
				}

				break;

			case 6:
				System.out.println("\nEmployee list (Name / ID / Profession):\n");
				em.listEmployees();
				System.out.println();
				System.out.println("Press enter to continue");
				sc.nextLine();
				sc.nextLine();
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

	}

}
