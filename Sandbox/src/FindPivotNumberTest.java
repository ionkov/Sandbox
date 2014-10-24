import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author George Ionkov
 *
 */
public class FindPivotNumberTest {

	/**
	 * Test method for {@link FindPivotNumber#findPivot(int[])}.
	 */
	@Test
	public void testFindPivot() {
		int[] a1 = {1};
		assertTrue(FindPivotNumber.findPivot(a1) == 1);

		int[] a2 = {1,2};
		assertTrue(FindPivotNumber.findPivot(a2) == 1 || 
				FindPivotNumber.findPivot(a2) == 2);
		
		int[] a3 = {1,3,2};
		assertTrue(FindPivotNumber.findPivot(a3) == 1);

		int[] a4 = {1,0,1};
		assertTrue(FindPivotNumber.findPivot(a4) == Integer.MIN_VALUE);
		
		int[] a5 = {1,1,1,1,1,1};
		assertTrue(FindPivotNumber.findPivot(a5) == 1);
	}
}
