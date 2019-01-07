package v1chap06.interfaces;

import java.util.*;

/**
 * This program demonstrates the use of Comparable interface
 * @version 1.0 2019-01-07
 * @author Code
 *
 */

public class EmployeeSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];
		// fill the staff with Manager and Employee objects
		staff[0] = new Employee("xiaohu", 2000);
		staff[1] = new Employee("xiaoming", 4000);
		staff[2] = new Employee("xiaocan", 3000);
		
		Arrays.sort(staff);
		for(Employee e : staff) {
			System.out.println(e.toString());
		}
		
	}

}
