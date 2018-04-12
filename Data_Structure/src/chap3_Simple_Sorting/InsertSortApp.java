package chap3_Simple_Sorting;


class ArrayIns{
	private long[] a;
	private int nElems;          //the number of array elements
	
	public ArrayIns(int Max) {    //constructor
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
	
	public void insertSort() {
		int in;
		long temp;
		for(int out = 1; out < nElems ; out++) {
			temp = a[out];
			for( in = out -1; in >=0; in--) {
				
				if(a[in] > temp) {
					a[in+1] = a[in];
				}else {
					break;
					}
			}
			a[in+1] = temp;
		}
	}
	
	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}	
	
}

public class InsertSortApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize = 100;
		ArrayIns arr = new ArrayIns(maxSize);
		
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
		
		System.out.println("Before insertsort:");
		arr.display();
		
		arr.insertSort();
		System.out.println("After insertsort:");
		arr.display();
		
	}

}
