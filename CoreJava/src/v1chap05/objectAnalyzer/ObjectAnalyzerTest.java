package v1chap05.objectAnalyzer;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * This program use reflection to spy on objects.
 * @author Code
 *
 */

public class ObjectAnalyzerTest {
	public static void main(String[] args) {
		ArrayList<Integer> squares = new ArrayList<>();
		for(int i = 1; i <= 5; i++) {
			squares.add(i * i);
		}
		System.out.println(new ObjectAnalyzer().toString(squares));
	}

}
