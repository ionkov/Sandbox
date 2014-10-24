import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

/**
 * 
 */

/**
 * @author George Ionkov
 *
 */
public class DveDatiTest {

	/**
	 * Test method for {@link DveDati#dayDiff(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDayDiff() {
		try {
			assertTrue(DveDati.dayDiff("04/26/1981", "04/26/1981") == 0);
			assertTrue(DveDati.dayDiff("04/26/1981", "04/25/1981") == 
					DveDati.dayDiff("04/25/1981", "04/26/1981"));
		} catch (ParseException pe) {
			fail("Exception: " + pe.toString());
		}
	}

}
