package v1chap08.pair2;

import java.time.LocalDate;

import javafx.util.converter.LocalDateStringConverter;

/**
 * @version 1.0 2019-01-14
 * @author Code
 *
 */

public class PairTest2 {

	public static void main(String[] args) {
		LocalDate[] birthday = {
				LocalDate.of(2019, 1, 14),
				LocalDate.of(1994, 7, 30),
				LocalDate.of(1995, 1, 20),
				LocalDate.of(2000, 5, 14)
		};
		Pair<LocalDate> aPair = ArrayAlg.minmax(birthday);
		System.out.println("min:" + aPair.getFirst());
		System.out.println("max:" + aPair.getSecond());
	}

}

class ArrayAlg{
	public static <T extends Comparable> Pair<T> minmax(T[] aArray){ //返回一个泛型类对象的 泛型方法
		if (aArray == null || aArray.length == 0) return null;
		T min = aArray[0];
		T max = aArray[0];
		
		for (T v : aArray) {  //大写字母在Unicode中编码更小，所以最小Mary 最大little
			if (min.compareTo(v) > 0) min = v;
			if (max.compareTo(v) < 0) max = v;
		}
		return new Pair<>(min, max);
	}
}