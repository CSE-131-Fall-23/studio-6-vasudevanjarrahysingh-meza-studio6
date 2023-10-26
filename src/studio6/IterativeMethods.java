package studio6;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class IterativeMethods {

	public static void gp(double llx, double lly, double size) {
		// base case, stop when the size is sufficiently small
		if (size < .05) {
			return;  // abandon recursion
		}
		StdDraw.line(llx + size/2,lly, llx + size/2, lly + size);
		StdDraw.line(llx,lly + size/2, llx + size, lly + size/2);
		
		StdDraw.pause(10);
		
		gp(llx, lly, 0.5*size);//LEFT LOWER
		gp(llx, lly+0.5*size, 0.5*size);//upper left 
		gp(llx+0.5*size, lly, 0.5*size);//lower right
	}
	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		double sum = 0.0;
		for (int power = 1; power <= n; ++power) {
			sum = sum + Math.pow(0.5, power);
		}
		return sum;
	}

	/**
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		while (q != 0) {
			int temp = q;
			q = p % q;
			p = temp;
		}
		return p;
	}

	/**
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] reversed = new int[array.length];
		if (array.length > 0) {
			int lastIndex = array.length - 1;
			for (int index = 0; index <= array.length / 2; ++index) {
				int mirrorIndex = lastIndex - index;
				// note:
				// since we read from array and write to reversed
				// we do not need to use a temp variable
				reversed[index] = array[mirrorIndex];
				reversed[mirrorIndex] = array[index];
			}
		}
		return reversed;
	}
}
