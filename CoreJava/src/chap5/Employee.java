package chap5;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name, double salary, int year, int month, int dayOfMonth) {
		this.name = name;
		this.salary = salary;
		hireDay = LocalDate.of(year, month, dayOfMonth);
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public LocalDate getHireDay() {
		return hireDay;
	}
	
	public void raiseSalary(double byPercent) {
		salary += salary * byPercent / 100;
	}
	
	public boolean equals(Object otherObject) {
		if(this == otherObject) return true;
	
		if(otherObject == null) return false;
		
		if(getClass() != otherObject.getClass()) return false;
		
		Employee other = (Employee) otherObject;
		
		return Objects.equals(this.name, other.name)
				&& salary == other.salary
				&& Objects.equals(hireDay, other.hireDay);
	}
	
	public int hashCode() {
		return Objects.hash(name, salary, hireDay);
	}
	
	public String toString(){
	return getClass().getName()+": "+name+", "+salary+", "+hireDay;
	}

}
