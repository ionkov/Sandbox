/**
 * 
 */
package squabe;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author George Ionkov
 * 
 */
public class Squabe {
	private LinkedList<Long> primes;
	private Set<Long> pqValues;
	private Pattern p = Pattern.compile(".*200.*");
	private long maxPQ;
	
	public Squabe() {
		maxPQ = 0;
		pqValues = new HashSet<>();
		primes = new LinkedList<>();
		primes.push(2L);
	}

	/**
	 * Return the n-th prime-proof squabe number.
	 * 
	 * @param n
	 * @return
	 */
	public long primeProofSquabe(int n) {
		long i = 0L;
		while (n > 0) {
			++i;

			// Check for overflow
			if (i < 0L) {
				return -1;
			}
			
			if (isSquabe(i) ){ //&& isPrimeProof(i)) {
				n--;
				
				// TODO: delete me
				System.out.println(n + "th spp: " + i);
			}
		}
		return i;
	}

	/**
	 * @return
	 */
	private boolean isPrimeProof(long n) {
		Matcher m = p.matcher(Long.toString(n));
		return m.matches();
	}

	/**
	 * Return true iff the number n is a squabe -> n == p^2q^3 where p and q and
	 * primes.
	 * 
	 * @param n
	 * @return
	 */
	private boolean isSquabe(long n) {
		// Make sure we have enough primes
		while (primes.peek() < n/2) {
			nextPrime();
		}
		
		return pqValues.contains(n);
	}
	
	/**
	 * Return the next prime number to be used.
	 * 
	 * @return
	 */
	protected long nextPrime() {
		long np = primes.peek() + 1L;
		while (true) {
			boolean prime = true;
			for (long p : primes) {
				if (np % p == 0) {
					prime = false;
					break;
				}
			}

			if (prime) {		
				// update the PQ values too
				long np2 = np * np;
				long np3 = np2 * np;				
				for (long p2: primes) {
					long pq1 = p2*p2*np3; 
					long pq2 = p2*p2*p2*np2;
					pqValues.add(pq1);
					pqValues.add(pq2);
					if (pq1 > maxPQ) {
						maxPQ = pq1;
					}
					if (pq2 > maxPQ) {
						maxPQ = pq2;
					}
				}
				// TODO: delete me
//				System.out.println("New prime: " + np);
//				System.out.println("pqValues.size()=" + pqValues.size() + " primes.size()=" + primes.size() + " maxPQ=" + maxPQ);
				primes.push(np);
				break;
			}
			np++;
		}
		
		return primes.peek();
	}
}
