package graph;

import java.util.Random;

public class GraphMax {
	private Node root;

	public GraphMax(int numNodes) {
		if (numNodes <= 0) {
			numNodes = 5;
		}

		Random r = new Random();
		while (--numNodes >= 0) {
			Node n = new Node(r.nextInt(20));
			if (root == null) {
				root = n;
				continue;
			}

			Node n2 = root;
			while (n2 != null) {
				if (r.nextBoolean()) {
					if (n2.getL() == null) {
						n2.setL(n);
						break;
					}
					n2 = n2.getL();
				} else {
					if (n2.getR() == null) {
						n2.setR(n);
						break;
					} else {
						n2 = n2.getR();
					}
				}
			}
		}
	}

	public int findMaxTraversal() {
		if (root == null) {
			return Integer.MIN_VALUE;
		}

		return findMaxTraversalR(root, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		dfTraversal(root, null, sb);
		return sb.toString();
	}

	/**
	 * @param root2
	 * @return
	 */
	private void dfTraversal(Node r, Node p, StringBuilder sb) {
		if (r == null) {
			return;
		}

		sb.append(r + " (" + p + ") ");
		dfTraversal(r.getL(), r, sb);
		dfTraversal(r.getR(), r, sb);
	}

	/**
	 * @param r
	 * @param i
	 * @return
	 */
	private int findMaxTraversalR(Node r, int s) {
		if (r.isLeaf()) {
			return s + r.getD();
		}

		if (r.getL() == null) {
			return findMaxTraversalR(r.getR(), s + r.getD());
		}

		if (r.getR() == null) {
			return findMaxTraversalR(r.getL(), s + r.getD());
		}

		return Math.max(findMaxTraversalR(r.getL(), s + r.getD()),
				findMaxTraversalR(r.getR(), s + r.getD()));
	}

	public class Node {
		private int d;
		private Node l;
		private Node r;

		public Node(int d) {
			this.d = d;
			l = null;
			r = null;
		}

		/**
		 * @param l
		 *            the l to set
		 */
		public void setL(Node l) {
			this.l = l;
		}

		/**
		 * @param r
		 *            the r to set
		 */
		public void setR(Node r) {
			this.r = r;
		}

		/**
		 * @return the d
		 */
		public int getD() {
			return d;
		}

		/**
		 * @return the l
		 */
		public Node getL() {
			return l;
		}

		/**
		 * @return the r
		 */
		public Node getR() {
			return r;
		}

		public boolean isLeaf() {
			return (l == null && r == null);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return Integer.toString(d);
		}
	}
}
