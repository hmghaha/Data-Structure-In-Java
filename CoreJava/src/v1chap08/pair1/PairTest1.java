package v1chap08.pair1;

/**
 * @version 1.0 2019-01-14
 * @author Code
 *
 */

public class PairTest1 {

	public static void main(String[] args) {
		String[] words = {"Mary", "had", "a", "little", "lamp"};
		Pair<String> aPair = ArrayAlg.minmax(words);
		System.out.println("min:" + aPair.getFirst());
		System.out.println("max:" + aPair.getSecond());
	}

}

class ArrayAlg{
	public static Pair<String> minmax(String[] aArray){
		if (aArray == null || aArray.length == 0) return null;
		String min = aArray[0];
		String max = aArray[0];
		
		for (String v : aArray) {  //大写字母在Unicode中编码更小，所以最小Mary 最大little
			if (min.compareTo(v) > 0) min = v;
			if (max.compareTo(v) < 0) max = v;
		}
		return new Pair<String>(min, max);
	}
}