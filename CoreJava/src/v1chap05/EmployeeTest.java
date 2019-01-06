package v1chap05;

/**
 * this programe demonstrates inheritance
 * @author Code
 *
 */

public class EmployeeTest {

	public static void main(String[] args) {
//		//construct a Manager Object
//		Manager boss = new Manager("laowang", 9000, 2000, 12, 31);
//		boss.setBonus(5000);
//		
//		Employee[] staff = new Employee[3];
//		// fill the staff with Manager and Employee objects
//		staff[0] = boss;
//		staff[1] = new Employee("xiaoming", 4000, 2003, 1, 1);
//		staff[2] = new Employee("xiaocan", 3000, 2005, 4, 5);
//		
//		//print out infomation about all Employee objects
//		for(Employee e : staff) {
//			System.out.println("Name: " + e.getName() + ", Salary: " 
//			+ e.getSalary() + ", HireDay: " + e.getHireDay().toString());
//		}
//		
		//test equals() hasCode() toString;
		Employee alice1 = new Employee("Alice", 75000, 2003, 12, 31);
		Employee alice2 = alice1;
		Employee alice3 = new Employee("Alice", 75000, 2003, 12, 31);
		Employee bob = new Employee("Bob", 4000, 2009, 12, 31);
		
		System.out.println("alice1 == alice2: " + (alice1 == alice2));
		System.out.println("alice1 == alice3: " + (alice1 == alice3));
		System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));
		System.out.println("alice1.equals(bob): " + alice1.equals(bob));
		System.out.println("bob.toString(): " + bob.toString());
		
		Manager carl = new Manager("Carl", 90000, 2000, 12, 1);
		Manager boss = new Manager("Carl", 90000, 2000, 12, 1);
		boss.setBonus(5000);
		System.out.println("boss.toString(): " + boss.toString());
		System.out.println("carl.equals(boss): " + carl.equals(boss));
		System.out.println("alice1.hashCode(): " + alice1.hashCode());
		System.out.println("alice3.hashCode(): " + alice3.hashCode());
		System.out.println("carl.hashCode(): " + carl.hashCode());
		System.out.println("boss.hashCode(): " + boss.hashCode());
		
	}

}
