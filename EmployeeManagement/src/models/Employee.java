package models;

import java.time.LocalDate;

import utilities.GenderType;

public abstract class Employee {
	private String name;
	private int salary;
	private int ID;
	private GenderType gender;
	private LocalDate employmentDate;
	private int bonusAmount;

	public Employee(String name, int salary, GenderType gender) {
		employmentDate = LocalDate.now();
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		bonusAmount = 0;
	}

	public abstract void setBonus(int salary);

	/*******************/
	/***** GETTERS *******/
	/***** SETTERS *******/
	/*******************/

	public int getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(int bonus) {
		bonusAmount = bonus;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public GenderType getGender() {
		return gender;
	}

	public LocalDate getEmploymentDate() {
		return employmentDate;
	}

	@Override
	public String toString() {
		return "| Name: " + name + " | ID: " + ID + " | Salary: " + salary + " | Bonus: " + bonusAmount;
	}
}
