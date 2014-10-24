import java.util.LinkedList;
import java.util.List;

public class Fibonacci {
	protected LinkedList<Integer> primes;

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		
		long n = 20;
		long m = f.factorial(n * 2)/(f.factorial(n) * f.factorial(n));
		System.out.println(m);
		System.out.println(f.latticePath((int)n));
//		f.findTheNextNPrimes(10);
//		System.out.println("Largest prime factor: "
//				+ f.largestPrimeFactor(600_851_475_143L));
//		System.out.println(f.fibonacci(1L, 2L, 2L));
	}

	public Fibonacci() {
		primes = new LinkedList<>();
		primes.push(2);
		// primes.push(3);
		// primes.push(5);
	}
	
	public long factorial(long n) {
		if (n <= 1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public int latticePath(int n) {
		if (n <= 0) {
			return 0;
		}
 		if (n == 1) {
			return 2;
		}
		
		
		int[][] m = new int[n][n];
		m[0][0] = 2;
		for (int i = 1; i < n; ++i) {
			m[i][0] = m[i-1][0] + 1;
			m[0][i] = m[0][i-1] + 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				m[i][j] = m[i - 1][j] + m[i][j - 1]; 
			}
		}
		
		return m[n - 1][n - 1];
	}


	protected void findTheNextNPrimes(int n) {
		int a = primes.peek() + 1;
		int s = primes.size();
		while (s + n > primes.size()) {
			boolean prime = true;
			for (Integer p : primes) {
				if (a % p == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				primes.push(a);
				System.out.println("Next prime: " + a);
			}
			++a;
		}
	}

	protected int largestPrimeFactor(long n) {
		System.out.println("Number: " + n);
		int a = primes.peek() + 1;
		while (true) {
			boolean prime = true;
			for (Integer p : primes) {
				if (a % p == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				if (n % a == 0) {
					System.out.println(n + "/" + a + "=" + n / a);
					n = n / a;
					if (n == 1) {
						break;
					}
				}
				primes.push(a);
			}
			++a;
		}
		return a;
	}

	protected long fibonacci(long n1, long n2, long s) {
		long n3 = n1 + n2;
		if (n3 >= 4_000_000) {
			return s;
		}

		if (n3 % 2 == 0) {
			return fibonacci(n2, n3, s + n3);
		}
		return fibonacci(n2, n3, s);
	}
}
