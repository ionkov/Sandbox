/**
 * 
 */
package tiles;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class responsible for tile-ating a wall of given size.
 * 
 */
public class Tile {
	private Set<TileType> tiles;

	public Tile() {
		this.tiles = new HashSet<>();
	}

	/**
	 * Add a number of different TyleTypes to this Tile family.
	 * 
	 * @param t
	 */
	public void addTileType(TileType t) {
		if (t != null) {
			tiles.add(t);
		}
	}

	public long howManyVariations(int size) {
		Map<Integer, Long> cache = new HashMap<>();
		return calculateVariations(size, cache);
	}

	/**
	 * @param size
	 *            the size of the tile wall that needs to be covered.
	 * @return the number of possible variations given the tile types that we
	 *         know of.
	 */
	private long calculateVariations(int size, Map<Integer, Long> cache) {
		// Base case: the wall to tile is too small
		if (size <= 0) {
			return 0L;
		}

		// Dynamic optimization step: use previously calculated values.
		if (cache.containsKey(size)) {
			return cache.get(size);
		}

		// Recursive call: generate all possible combination for tiles and
		// recurse deeper.
		long c = 0L;
		for (TileType t : tiles) {
			if (size == t.getSize()) {
				c++;
			} else if (size > t.getSize()) {
				c += calculateVariations(size - t.getSize(), cache);
			}
		}

		// Dynamic optimization: save calculated value for size for future use.
		cache.put(size, c);
		return c;
	}
}
