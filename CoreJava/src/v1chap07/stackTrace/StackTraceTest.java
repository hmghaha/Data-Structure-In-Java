package v1chap07.stackTrace;

import java.util.Scanner;

/**
 * The program displays a trace feature of a recursive method call
 * @author Code
 *
 */

public class StackTraceTest {

	/**
	 * Computes the factorial of a number
	 * @param n a non_negative integer
	 * @return n!
	 */
	public static int factorial(int n) {
		System.out.println("factorial(" + n + "):");
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for(StackTraceElement f : frames)
			System.out.println(f);
		int r;
		if(n <= 1) r = 1;
		else r = n * factorial(n -1);
		System.out.println("return " + r);
		return r;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = in.nextInt();
		factorial(n);
	}

}
