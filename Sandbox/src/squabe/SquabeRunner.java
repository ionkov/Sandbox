/**
 * 
 */
package squabe;

/**
 * @author George Ionkov
 *
 */
public class SquabeRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Squabe s = new Squabe();
		print(s, 100);
	}

	/**
	 * @param i
	 */
	private static void print(Squabe s, int i) {
		System.out.println("The " + i + " squabe prime-proof containing 200 is: " + s.primeProofSquabe(i));
	}

}
