package chap3_Simple_Sorting;


class ArraySel{
	private long[] a;
	private int nElems;          //the number of array elements
	
	public ArraySel(int Max) {    //constructor
		a = new long[Max];
		nElems = 0;
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++ ) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public void selectSort() {
		int min = 0;
		for(int out = 0; out < nElems -1; out++) {
			min = out;
			for(int in = out +1; in < nElems; in++) {
				if(a[in] < a[min]) {
					min = in;
				}
			}
			swap(min, out);
		}
	}
	
	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}	
	
}

public class SelectSortApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize = 100;
		ArraySel arr = new ArraySel(maxSize);
		
		arr.insert(88);
		arr.insert(23);
		arr.insert(18);
		arr.insert(67);
		arr.insert(43);
		arr.insert(48);
		arr.insert(0);
		arr.insert(99);
		arr.insert(75);
		arr.insert(44);
		arr.insert(12);
		
		System.out.println("Before selectsort:");
		arr.display();
		
		arr.selectSort();
		System.out.println("After selectsort:");
		arr.display();
		
	}

}
