/**
 * 
 */
package power;

import java.util.HashMap;
import java.util.Map;

/**
 * @author George Ionkov
 *
 */
public class DigitPower {
	public static long nthDigitPower(int n) {
		Map<Long, Long> map = new HashMap<>();
		
		long i = 9L;
		while(n > 0) {
			++i;
			
			// Check for overflow
			if (i < 0) {
				return -1L;
			}
			
			// Get the digits sum
			long sum = digitsSum(i);
			
			// Check if i is a power of its digits
			long power = sum;
			if (map.containsKey(sum)) {
				power = map.get(sum);
			}
			
			while (sum != 1 && power <= i) {
				if (power == i) {
					// TODO: delete me 
					System.out.println(n + " " + i + " " + sum + " map size: " + map.size());
					n--;
				}
				power *= sum;
			}
			map.put(sum, power);
		}
		return i;
	}

	/**
	 * @param i
	 * @return
	 */
	private static long digitsSum(long n) {
		long sum = 0;
		long i = n;
		while (i > 0) {
			sum += i % 10;
			i /= 10;
		}
		return sum;
	}
}
