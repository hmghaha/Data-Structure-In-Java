package chap4_Stacks_Queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackY{
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackY(int s) {
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
} //end class StackY

class BracketChecker{
	private String input;
	
	public BracketChecker(String in) {
		this.input = in;
	}
	
	public void check() {
		int stackSize = input.length();
		StackY theStack= new StackY(stackSize);
		
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
				if(!theStack.isEmpty()) { //第一个错误是准确的 但会pop一个正常的导致后面匹配错误
					char chx = theStack.pop();
					if(chx == '{' && ch !='}' ||
					   chx == '[' && ch != ']' ||
					   chx == '(' && ch != ')') {
						System.out.println("Error: " + ch + " at " + j);
						break;
					}
				}else {
					System.out.println("Error: " + ch + " at " + j);
				}
				break;
			default :
				break;
			} //end switch
		} //end for
		if(!theStack.isEmpty()) {
			System.out.println("Error: missing right dilimiter");
		}
	} //end checker
}

public class BracketApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String input;
		while(true) {
			System.out.println("Enter string containing delimiters: ");
			System.out.flush();
			input = getString();
			if(input.equals("")) {
				break;
			}
			BracketChecker theChecker = new BracketChecker(input);
			theChecker.check();
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

}







