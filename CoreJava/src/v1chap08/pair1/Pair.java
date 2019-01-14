package v1chap08.pair1;

/**
 * @version 1.0 2019-01-14
 * @author Code
 *
 * @param <T>
 */

public class Pair<T> {
	private T first;
	private T second;
	
	public Pair() {
		this.first = null;
		this. second = null;
	}
	
	public Pair(T f, T s) {
		first = f;
		second = s;
	}
	
	public T getFirst() {
		return first;
	}
	
	public T getSecond() {
		return second;
	}
	
	public void setFirst(T value) {first = value;}
	public void setSecond(T value) {second = value;}

}
