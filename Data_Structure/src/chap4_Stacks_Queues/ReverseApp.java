package chap4_Stacks_Queues;
//stack used to reverse a string
import java.io.*;




public class ReverseApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = " ", output;
		while(true) {
			System.out.print("Enter a string: ");
			System.out.flush();
			try {
				input = getString();
				if(input.equals("")) {
					break;
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //read a string from kb;
			
			
			Reverser theReverser = new Reverser(input);
			output = theReverser.doRev();
			System.out.println("Reversed: " + output);
		}
	} //end main()
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	static class StackX{
		private int maxSize;
		private char[] stackArray;
		private int top;
		
		public StackX(int s) {
			maxSize = s;
			stackArray = new char[maxSize];
			top = -1;
		}
		
		public void push(char j) {
			stackArray[++top] = j;
		}
		
		public char pop() {
			return stackArray[top--];
		}
		
		public char peek() {
			return stackArray[top];
		}
		
		public boolean isEmpty() {
			return (top == -1);
		}
		
		public boolean isFull() {
			return (top == maxSize);
		}
	} //end class StackX
	
	
	static class Reverser{
		private String input;
		private String output;
		
		public Reverser(String in) {
			this.input = in;
		}
		
		public String doRev() {
			int stackSize = input.length();
			StackX theStack = new StackX(stackSize);
			
			for(int j=0; j<input.length(); j++) {
				char ch = input.charAt(j);
				theStack.push(ch);
			}
			output = "";
			while(!theStack.isEmpty()) {
				char ch = theStack.pop();
				output += ch;
			}
			
			return output;
		} //end doRev
	} //end class Reverser
}
