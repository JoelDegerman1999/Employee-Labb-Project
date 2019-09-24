package models;

import utilities.Utilities;

public class EmployeeStatisticsMenuOptions {
	EmployeeManagement em;

	public EmployeeStatisticsMenuOptions(EmployeeManagement management) {
		em = management;
	}
	
	public void averageWage(){
		double averageWage = em.getAverageWage();
		System.out.println("Average wage at the company is: " + averageWage);
		System.out.println("\nPress enter to continue");
		Utilities.sc.nextLine();
		Utilities.sc.nextLine();
	}
	
	public void getEmployeeWithHighestSalary() {
		Employee maxSalaryEmployee = em.getMaxSalary();
		System.out.println("Employee with highest salary:\n");
		System.out.println(maxSalaryEmployee);
		System.out.println("\nPress enter to continue");
		Utilities.sc.nextLine();
		Utilities.sc.nextLine();
	}
	
	public void getEmployeeWithLowestSalary() {
		Employee minSalaryEmployee = em.getMinSalary();
		System.out.println("Employee with lowest salary:\n");
		System.out.println(minSalaryEmployee);
		System.out.println("\nPress enter to continue");
		Utilities.sc.nextLine();
		Utilities.sc.nextLine();
	}
	
	public void getGenderDistribution() {
		em.getGenderDistribution();
		System.out.println("Press enter to continue");
		Utilities.sc.nextLine();
		Utilities.sc.nextLine();
	}
	
}
