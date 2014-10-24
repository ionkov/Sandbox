import java.util.Arrays;
import java.util.Random;


/**
 * @author George Ionkov
 *
 */
public class FindPivotNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generate a random integer array
		int [] arr = randomArr();
		int minorityVote = findPivot(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.println("Pivot:" + minorityVote);
	}
	
	
	protected static int findPivot(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}
		
		if (arr.length == 1) {
			return arr[0];
		}
		
		int l = 0;
		int r = arr.length - 1;
		int minPivot = l;
		int maxPivot = r;
		while (l < r) {
			if (arr[l] < arr[maxPivot]) {	
				if (arr[l] > arr[minPivot]) {
					minPivot = l;
				}
				l++;
			} else {
				if (arr[r] < arr[maxPivot]) {
					maxPivot = r;
				}		
				r--;
			} 
		}
		
		if (arr[minPivot] > arr[maxPivot]) {
			return Integer.MIN_VALUE;
		}
		return arr[minPivot];
	}
	
	
	
	/**
	 * Generate a random integer array with up to 10 elements.
	 * 
	 * @return randomly generated integer array.  Null is a valid return value
	 */
	protected static int[] randomArr() {
		Random rGenerator = new Random();
		
		// Randomly generate how many elements to have in the array
		int s = rGenerator.nextInt(10);
		
		if (s <= 0) {
			return null;
		}
		
		// Generate s many random integers between 0 and 3
		int[] arr = new int[s];
		for (int i = 0; i < s; i++) {
			arr[i] = rGenerator.nextInt(3);
		}
		return arr;
	}

}
