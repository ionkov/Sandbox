/**
 * 
 */
package power;

/**
 * @author George Ionkov
 * 
 */
public class PowerRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		for (int i = 0; i <= 30; i++) {
			power(30);
//		}
	}

	/**
	 * @param i
	 */
	private static void power(int i) {
		long n = DigitPower.nthDigitPower(i);
		System.out.println("The " + i + "th power number is " + n);
	}
}
