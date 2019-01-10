package v1chap06.clone;


/**
 * This program demonstrates cloning
 * @author Code
 *
 */
public class CloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee original = new Employee("Hmg", 10000);
		original.setHireDay(2017, 7, 3);
		try {
			Employee cloned = (Employee) original.clone();
			cloned.raiseSalary(10);
			original.setHireDay(2018, 4, 3);
			System.out.println("original=" + original);
			System.out.println("clone=" + cloned);
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
