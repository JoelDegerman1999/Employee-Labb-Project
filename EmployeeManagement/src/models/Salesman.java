package models;

import utilities.GenderType;

public class Salesman extends Employee {

	public Salesman(String name, int salary, GenderType gender) {
		super(name, salary, gender);
	}

	@Override
	public void setBonus(int salary) {
		super.setBonusAmount((int) (salary * 0.1));
	}

	@Override
	public String toString() {
		return "Profession: " + this.getClass().getSimpleName() + " " + super.toString();
	}
	
}
