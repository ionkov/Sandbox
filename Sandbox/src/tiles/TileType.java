/**
 * 
 */
package tiles;

/**
 * @author George Ionkov
 * 
 */
public enum TileType {
	BLACK(1), RED(2), GREEN(3), BLUE(4);

	private final int size;

	private TileType(int size) {
		this.size = size;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return Integer.toString(size);
	}
}
