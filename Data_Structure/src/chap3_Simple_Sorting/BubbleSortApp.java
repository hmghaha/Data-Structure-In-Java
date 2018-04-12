package chap3_Simple_Sorting;

import java.util.Date;

class ArrayBub{
	private long[] a;
	private int nElems;          //the number of array elements
	public int num = 0;
	
	public ArrayBub(int Max) {    //constructor
		a = new long[Max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++ ) {
			System.out.println(a[i] + " ");
			num ++;
		}
		System.out.println();
	}
	
	public void bubbleSort() {
		for(int out = nElems -1; out > 1; out--) {
			for(int in = 0; in < out; in++) {
				if(a[in] > a[in+1]) {
					swap(in, in+1);
				}
			}
		}
	}
	
	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}	
	
}

public class BubbleSortApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize =50000;
		long n;
		
		ArrayBub arr = new ArrayBub(maxSize);
		
		for (int i = 0; i < maxSize; i++) {
			n = (long)(Math.random() * maxSize);
			arr.insert(n);
		}
		arr.display();
		arr.bubbleSort();
		System.out.println(arr.num);
		arr.display();
//		int maxSize = 100;
//		ArrayBub arr = new ArrayBub(maxSize);
//		
//		arr.insert(88);
//		arr.insert(23);
//		arr.insert(18);
//		arr.insert(67);
//		arr.insert(43);
//		arr.insert(48);
//		arr.insert(0);
//		arr.insert(99);
//		arr.insert(75);
//		arr.insert(44);
//		arr.insert(12);
//		
//		System.out.println("Before bubblesort:");
//		arr.display();
//		
//		arr.bubbleSort();
//		System.out.println("After bubblesort:");
//		arr.display();
		
	}

}
