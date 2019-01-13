package v1chap06.staticInnerClass;

import java.util.Random;

import v1chap06.staticInnerClass.ArrayAlg.Pair;

/**
 * This program demonstrats the use of static inner class
 * 静态内部类代码是写在外围类里面的, 但是并不能访问外围类的非公开成员, 因为实际上它们就是两个不同的类,
 * @version 1.0 2019-01-12
 * @author Code
 *
 */
public class StaticInnerClassTest {

	public static void main(String[] args) {
		double[] array = new double[20];
		for(int i = 0; i < array.length; i++) {
			array[i] = 100 * Math.random();  //random number between [0,100)
		}
		ArrayAlg.Pair aPair = ArrayAlg.minmax(array); //避免类名冲突
		System.out.println("Min:" + aPair.getFirst());
		System.out.println("Max:" + aPair.getSecond());
	}

}

class ArrayAlg{
	public static class Pair{  //必须为static 使它无法引用外部类
		private double first;
		private double second;
		
		public Pair(double f, double s) {
			first = f;
			second = s;
		}
		
		public double getFirst() {
			return first;
		}
		
		public double getSecond() {
			return second;
		}
	}
	
	public static Pair minmax(double[] arr) { //声明为static才可以通过类ArrayAlg直接调用
//		double min = arr[0];
//		double max = arr[0];
		double min = Double.POSITIVE_INFINITY; //先赋值Double类的最大值，使得min之后一定会被数组里的最小值替换
		double max = Double.NEGATIVE_INFINITY;
		for (double v : arr) {
			if (min > v) min = v;
			if (max < v) max = v;
		}
		return new Pair(min, max);
	}
}