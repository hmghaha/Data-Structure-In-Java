package chap5;

/**
 * this programe demonstrates inheritance
 * @author Code
 *
 */

public class EmployeeTest {

	public static void main(String[] args) {
		//construct a Manager Object
		Manager boss = new Manager("laowang", 9000, 2000, 12, 31);
		boss.setBonus(5000);
		
		Employee[] staff = new Employee[3];
		// fill the staff with Manager and Employee objects
		staff[0] = boss;
		staff[1] = new Employee("xiaoming", 4000, 2003, 1, 1);
		staff[2] = new Employee("xiaocan", 3000, 2005, 4, 5);
		
		//print out infomation about all Employee objects
		for(Employee e : staff) {
			System.out.println("Name: " + e.getName() + ", Salary: " 
			+ e.getSalary() + ", HireDay: " + e.getHireDay().toString());
		}
		

	}

}
