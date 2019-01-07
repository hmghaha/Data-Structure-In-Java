package v1chap05.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * This program demonstrates the use of reflection for manipulating arrays.
 * @version 1.0 2019-01-07 
 * @author Code
 *
 */
public class CopyOfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3};
		a = (int[]) goodCopyOf(a, 10);
		System.out.println(Arrays.toString(a));
		
		String[] b = {"Tom", "Dick", "Harry"};
		b = (String[]) goodCopyOf(b, 10);
		System.out.println(Arrays.toString(b));
		
		System.out.println("The following call will generate an exception.");
		b = (String[]) badCopyOf(b, 10);

	}
	
	/**
	 * This method attemps to grow an array by allocating a new array and copying all elements.
	 * @param a  the array to grow
	 * @param newLength  the new length
	 * @return a larger array that contains all elements of a. However, the return array has
	 * type Object[], not the same type as a.
	 */
	public static Object[] badCopyOf(Object[] a, int newLength) {
		Object[] newArray = new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
		return newArray;
	}
	
	/**
	 * This metnod grows an array by allocating a new array of the same type and coping all elements.
	 * @param a the array to grow. This can be an object array or a primitive type array
	 * @param newLength
	 * @return a larger array that contains all elements of a.
	 */
	public static Object goodCopyOf(Object a, int newLength) {
		Class cl = a.getClass();
		if(!cl.isArray()) return null;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength); //newArray 引用的对象是componentType类型的
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
		
	}

}
