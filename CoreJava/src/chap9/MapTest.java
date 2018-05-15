package chap9;

import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> height = new HashMap<>();
		height.put(170, "HMG");
		height.put(165, "HAHA");
		height.put(180, "fff");
		
		System.out.println(height);
		
		height.remove(165);
		height.put(751, "atm");
		
		System.out.println(height.get(170));
		
		height.forEach((k, v) -> 
				System.out.println("Key = " + k + " Value = " + v));
	}

}
