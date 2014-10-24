import java.util.LinkedList;

public class IntegerRightTriangles {

	public static void main(String[] args) {
		IntegerRightTriangles irt = new IntegerRightTriangles();
		irt.maxP(1000);
	}

	public int maxP(int n) {
		LinkedList<Triangle> maxTriangles = new LinkedList<>();
		int max = 0;
		for (int p = 4; p <= n; ++p) {
			int count = 0;
			LinkedList<Triangle> triangles = new LinkedList<>();
			int c = p / 2;
			while (c > 0 && c < p) {
				int a = 1;
				int b = p - c - a;
				while (a <= b) {
					if (Triangle.isValid(a, b, c) && Triangle.isRightTriangle(a, b, c)) {
						count++;
						triangles.add(new Triangle(a,b,c));
					}
					a++;
					b = p - c - a;
				}
				c--;
				if (count > max) {
					max = count;
					maxTriangles = triangles;
				}
			}
		}
		
		System.out.println("Triangles: " + maxTriangles.toString());
		return max;
	}

	protected static class Triangle {
		int a;
		int b;
		int c;

		public Triangle(int a, int b, int c) {
			this.a = Math.min(a, b);
			this.b = Math.max(a, b);
			this.c = c;
		}

		public static boolean isValid(int a, int b, int c) {
			return (c < a + b) && (c > a) && (c > b);
		}

		public static boolean isRightTriangle(Triangle t) {
			return isRightTriangle(t.a, t.b, t.c);
		}

		public static boolean isRightTriangle(int a, int b, int c) {
			return (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2));
		}

		public int perimeter() {
			return a + b + c;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return a + " " + b + " " + c;
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			return toString().hashCode();
		}
	}
}
