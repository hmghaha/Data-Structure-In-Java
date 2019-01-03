package chap5;

import java.util.Objects;

public class Manager extends Employee {
	private double bonus;
	
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		bonus = 0;
	}
	
	public double getSalary() {
		return super.getSalary() + bonus;
	}
	
	public void setBonus(double b) {
		bonus = b;
	}
	
	public boolean equals(Object otherObject) {
		if(!super.equals(otherObject)) return false;
		Manager other = (Manager) otherObject;
		return bonus == other.bonus;
	}
	
	public int hashCode() {
		return super.hashCode() + 17*Objects.hashCode(bonus);
	}
	
	public String toString() {
		return super.toString() + ", " + bonus;
	}
}
