package chap4_Stacks_Queues;

class StackX{
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

class BracketChecker{
	private String input;
	
	public BracketChecker(String in) {
		this.input = in;
	}
	
	public void check() {
		int stackSize = input.length();
		StackX theStack= new StackX(stackSize);
		
		for(int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);
			switch(ch) {
			case '{':
			case '[':
			case '(':
				theStack.push(ch);
				break;
			case '}':
			case ']':
			case ')':
				if(!theStack.isEmpty()) {
					char chx = theStack.pop();
					if(chx == '{' && ch !='}' ||
					   chx == '[' && ch != ']' ||
					   chx == '(' && ch != ')') {
						System.out.println("Error: " + ch + " at " + j);
					}
				}else {
					System.out.println("Error: " + ch + " at " + j);
				}
				break;
			default :
				break;
			}e
		}
	}
}

public class BracketApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
