package chap4_Stacks_Queues;

//demonstrates priority queue using array
class PriorityQ{
	private int maxSize;
	private long[] queArray;
	private int nItems;
	
	public PriorityQ(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}
	
	public void insert(long item) {
		int j;
		if(nItems == 0)
			queArray[0] = item;
		else {
			for(j = nItems-1; j>= 0; j--) {
				if(item > queArray[j])
					queArray[j+1] = queArray[j];
				else
					break;
			}
			queArray[j+1] = item;
		}
		nItems++;
	} //end of insert
	
	public long remove() {
		return queArray[--nItems];
	}
	
	public long peekMin() {
		return queArray[nItems-1];
	}
	
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	public boolean isFull() {
		return nItems == maxSize;
	}
} //end class PriorityQ 

class PriorityQApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQ thePQ = new PriorityQ(5);
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		
		while(!thePQ.isEmpty()) {
			long temp = thePQ.remove();
			System.out.print(temp + " ");
		}
		System.out.println("");
		
	}

}
