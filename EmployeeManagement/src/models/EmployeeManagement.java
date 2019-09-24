package models;

import java.util.ArrayList;
import java.util.Scanner;

import models.exception.EmployeeNotFoundException;
import utilities.GenderType;

public class EmployeeManagement {

	ArrayList<Employee> employeeList;

	private static int ID = 1;

	public EmployeeManagement() {
		employeeList = new ArrayList<Employee>();
	}

	public void registerEmployee(Employee em) {
		employeeList.add(em);
		em.setID(ID++);
	}

	public void removeEmployee(Employee em) {
		employeeList.remove(em);
	}

	public Employee getEmployeeByID(int ID) throws EmployeeNotFoundException {
		for (Employee employee : employeeList) {
			if (employee.getID() == ID) {
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}

	public Employee getEmployeeByName(String name) throws EmployeeNotFoundException {
		for (Employee employee : employeeList) {
			if (employee.getName().equalsIgnoreCase(name)) {
				return employee;
			}
		}
		throw new EmployeeNotFoundException();
	}

	public void listEmployees() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}

	public void changeSalary(Employee em, int newSalary) {
		em.setSalary(newSalary);
	}

	public int getNumberOfEmployees() {
		return employeeList.size();
	}

	public double getAverageWage() {
		int totalWages = 0;
		for (Employee em : employeeList) {
			totalWages += em.getSalary();
		}

		return totalWages / getNumberOfEmployees();
	}

	public Employee getMaxSalary() {
		int maxSalary = 0;
		Employee maxSalaryEmployee = null;
		if (employeeList.size() > 0) {
			maxSalary = employeeList.get(0).getSalary();
			maxSalaryEmployee = employeeList.get(0);
		}
		for (Employee employee : employeeList) {
			if (maxSalary < employee.getSalary()) {
				maxSalary = employee.getSalary();
				maxSalaryEmployee = employee;
			}
		}

		return maxSalaryEmployee;
	}

	public Employee getMinSalary() {
		int minSalary = 0;
		Employee minSalaryEmployee = null;
		if (!employeeList.isEmpty()) {
			minSalary = employeeList.get(0).getSalary();
			minSalaryEmployee = employeeList.get(0);
		}

		for (Employee employee : employeeList) {
			if (minSalary > employee.getSalary()) {
				minSalary = employee.getSalary();
				minSalaryEmployee = employee;
			}
		}

		return minSalaryEmployee;
	}

	public void getGenderDistribution() {
		double numOfMen = 0;

		for (Employee em : employeeList) {
			if (em.getGender() == GenderType.MALE) {
				numOfMen++;
			}
		}

		double shareOfMen = (numOfMen / getNumberOfEmployees()) * 100;
		double shareOfWomen = ((getNumberOfEmployees() - numOfMen) / getNumberOfEmployees()) * 100;
		System.out.println("Gender distribution: " + shareOfMen + "% Men" + " | " + shareOfWomen + "% Women");

	}

	
	//Metod som kallas i Menu.java för att skapa en ny employee!
	//Inte nöjd med denna metod, men var vår bästa lösning vi kom på!
	public static Employee createEmployee() {
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		String name;
		int salary;
		String gender;
		
		do {
			System.out.println("1. Programmer");
			System.out.println("2. Salesman\n");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter name: ");
				name = sc.nextLine();
				System.out.print("Enter salary: ");
				salary = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter gender (male/female): ");
				gender = sc.nextLine();

				if (gender.equalsIgnoreCase("male")) {
					exit = true;
					return new Programmer(name, salary, GenderType.MALE);
				} else if (gender.equalsIgnoreCase("female")) {
					exit = true;
					return new Programmer(name, salary, GenderType.FEMALE);
				}
				System.out.println("\nWrong input, start over\n");
				break;
			case 2:
				System.out.print("Enter name: ");
				name = sc.nextLine();
				System.out.print("Enter salary: ");

				salary = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter gender (male/female): ");
				gender = sc.nextLine();

				if (gender.equalsIgnoreCase("male")) {
					exit = true;
					return new Salesman(name, salary, GenderType.MALE);
				} else if (gender.equalsIgnoreCase("female")) {
					exit = true;
					return new Salesman(name, salary, GenderType.FEMALE);
				}
				System.out.println("\nWrong input, start over\n");
				break;
			}
		} while (exit == false);
		sc.close();
		return null;
	}

	public void deliverBonuses() {
		for (Employee employee : employeeList) {
			employee.setBonus(employee.getSalary());
		}
	}

}
