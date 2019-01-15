package v1chap09.linkedList;

import java.util.*;

/**
 * This program demonstrates operations on link list
 * @version 1.0 2019-01-15
 * @author Code
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {
		List<String> a = new LinkedList<>();
		a.add("zs");
		a.add("ls");
		a.add("ww");
		
		List<String> b = new LinkedList<>();
		b.add("zl");
		b.add("sq");
		b.add("zb");
		b.add("wj");
		
		ListIterator aIter = a.listIterator();
		Iterator bIter = b.iterator();
		
		//merge words from b to a
		while(bIter.hasNext()) {
			if (aIter.hasNext()) aIter.next();
			aIter.add(bIter.next()); //给当前位置添加元素  a.add改变后无法再用aIter
		}
		
		//remove every second words from b
		bIter = b.iterator();
		while(bIter.hasNext()) {
			bIter.next(); //skip one element
			if (bIter.hasNext()) {
				bIter.next(); //skip that element
				bIter.remove(); //remove that element
			}
		}
		System.out.println(b);
		
		//bulk operation:remove all words in b from a;
		a.removeAll(b);
		
		System.out.println(a);

	}

}
