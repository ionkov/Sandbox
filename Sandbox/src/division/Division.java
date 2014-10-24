package division;

public class Division {
	public static void main(String[] args) {
		divPrint(2,1);
		divPrint(100,5);
		divPrint(5,2);
		divPrint(1,2);
		divPrint(0,100);
	}

	public static void divPrint(int a, int b) {
		System.out.println(a + "/" + b + "=" + div(a,b));
	}
	
	
	public static int div(int a, int b) {
		if (b == 0) {
			return Integer.MAX_VALUE;
		}
		
		int sign = 1;
		if ((b < 0 && a > 0) || (b > 0 && a < 0)) {
			sign = -1;
		}
		a = Math.abs(a);
		b = Math.abs(b);
		
		int r = 0;
		int c = b; 
		while (a >= c) {
			c += b;
			r++;
		}
		return r * sign;
	}
}
