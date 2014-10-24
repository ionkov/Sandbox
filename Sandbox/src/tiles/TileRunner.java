/**
 * 
 */
package tiles;

/**
 * @author George Ionkov
 * 
 */
public class TileRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tile t = new Tile();
		t.addTileType(TileType.BLACK);
		t.addTileType(TileType.RED);
		t.addTileType(TileType.GREEN);
		t.addTileType(TileType.BLUE);

		for (int i = 0; i <= 50; i++) {
			color(t, i);
		}
	}

	private static void color(Tile t, int size) {
		long x = t.howManyVariations(size);
		System.out.println("Tile wall of size " + size + " can be colored " + x
				+ " different ways.");
	}
}
