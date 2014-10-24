package graph;

public class GraphRunner {
	public static void main(String[] argv) {
		GraphMax g = new GraphMax(10);
		System.out.println(g);
		System.out.println("Max traversal sum = " + g.findMaxTraversal());
	}
}
