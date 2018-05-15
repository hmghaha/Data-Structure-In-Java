package chap9;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * This program demostrates the use of a priority queue.
 * 迭代器取值顺序不定，删除总是从最小值删。
 * @author Code
 *
 */
public class priorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<LocalDate> pq = new PriorityQueue<>();
		pq.add(LocalDate.of(1994, 7, 29));
		pq.add(LocalDate.of(1964, 3, 9));
		pq.add(LocalDate.of(2018, 4, 24));
		pq.add(LocalDate.of(2008, 4, 24));
		pq.add(LocalDate.of(2000, 4, 24));
		
		System.out.println("Iterating over elements...");
		for(LocalDate date : pq) {
			System.out.println(date);
		}
		System.out.println("Removing elements...");
		while(!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
	}

}
