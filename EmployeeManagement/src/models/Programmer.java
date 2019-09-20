package models;

import utilities.GenderType;

public class Programmer extends Employee {

	public Programmer(String name, int salary, GenderType gender) {
		super(name, salary, gender);
	}

	@Override
	public void setBonus(int salary) {
		super.setBonusAmount((int) (salary * 0.05));
	}

	@Override
	public String toString() {
		return "Profession: " + this.getClass().getSimpleName() + " " + super.toString();
	}

}
