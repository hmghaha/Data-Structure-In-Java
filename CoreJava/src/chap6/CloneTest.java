package chap6;


/**
 * This program demonstrates cloning
 * @author 车舵
 *
 */
public class CloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee original = new Employee("Hmg", 10000);
		original.setHireDay(2017, 7, 3);
		System.out.println(original);
		try {
			Employee cloned = (Employee) original.clone();
			cloned.raiseSalary(10);
			original.setHireDay(2018, 4, 3);
			System.out.println(original);
			System.out.println(cloned);
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
	}

}
