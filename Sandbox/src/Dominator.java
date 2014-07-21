import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


/**
 * @author George Ionkov
 */
public class Dominator {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = readStdin();
//		int[] arr = randomArr();
		System.out.println(Arrays.toString(arr));
		
		int dominator = findDominatorHash(arr);
		System.out.println("Dominator: " + dominator);
		dominator = findDominatorSort(arr);
		System.out.println("Dominator: " + dominator);
	}
	
	
	/**
	 * Find dominator index or return Integer.MIN_VALUE.  
	 * 
	 * Solution is O(nlog) time and O(1) space
	 * 
	 * @param arr the array to search for dominator
	 * @return dominator index or Integer.MIN_VALUE if no dominator
	 */
	protected static int findDominatorSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		// sort the array
		Arrays.sort(arr);
		int dIndex = 0;
		int dCount = 0;
		int lCount = 0;
		int lIndex = 0; 
		for (int i = 0; i < arr.length; i++) {
			if (arr[lIndex] != arr[i]) {
				if (dCount < lCount) {
					dIndex = lIndex;
					dCount = lCount;
				}
				lCount = 0;
				lIndex = i;
 			}
			
			lCount++;
		}
		
		if (dCount > arr.length / 2 ) {
			return arr[dIndex];
		}
		return Integer.MIN_VALUE;
	}
	
	
	/**
	 * Find a dominator index or return Integer.MIN_VALUE.
	 * 
	 * Solution is O(n) time and space
	 *    
	 * @param arr the array to search for dominator
	 * @return return Integer.MIN_VALUE or an index of the dominator in arr
	 */
	protected static int findDominatorHash(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		int dominatorIndex = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			if (map.containsKey(arr[i])) {
				count = map.get(arr[i]);
			}
			count++;
			map.put(arr[i], count);
			
			// update dominator
			if (map.get(arr[i]) > map.get(arr[dominatorIndex])) {
				dominatorIndex = i;
			}
		}
		
		// Enforce the n/2 + 1 size limit.
		if (map.get(arr[dominatorIndex]) > arr.length / 2) {
			return arr[dominatorIndex];
		}
		return Integer.MIN_VALUE;
	}
	
	
	/**
	 * Read STDIN into an array.
	 * 
	 * @return int[] read from STDIN.
	 */
	protected static int[] readStdin() {
		int[] arr = null;
		// Read STDIN for ints in the array.
		try (Scanner stdin = new Scanner(System.in)) {
		
			List<Integer> l = new ArrayList<>();
			while(stdin.hasNextInt()) {
				l.add(stdin.nextInt());
			}
			
			if (l.size() > 0) {
				arr = new int[l.size()];
				for (int i = 0; i < arr.length; i++) {
					arr[i] = l.get(i);
				}
			}
			
			stdin.close();
		}
		return arr;
	}
	
	
	/**
	 * Generate an array with randomly selected 10 elements between 1 and 5.
	 * 
	 * @return ten element randomly generated int[]
	 */
	protected static int[] randomArr() {
		Random r = new Random();
		int[] arr= new int[11];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(3);
		}
		return arr;
	}
}
