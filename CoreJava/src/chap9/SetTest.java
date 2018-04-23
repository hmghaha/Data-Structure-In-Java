package chap9;

import java.util.*;

/**
 * This program use a set to print all unique words in System.in.
 * @author ³µ¶æ
 *
 */
public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> words = new HashSet(); //HashSet implements Set
		long totalTime = 0;
		
		try(Scanner in = new Scanner(System.in)){
			while(in.hasNext()) {
				String word = in.next();
				long callTime = System.currentTimeMillis();
				words.add(word);
				callTime = System.currentTimeMillis() - callTime;
				totalTime += callTime;
			}
		}
		
		Iterator<String> iter = words.iterator();
		for(int i = 1; i <= 20 && iter.hasNext(); i++) {
			System.out.println(iter.next());
		}
		System.out.println("...");
		System.out.println(words.size() + "distinct words. "
				+ totalTime + "milliseconds.");
		
	}

}














