public class World {

	private int maximumX;
	private int minimumX;
	private int maximumY;
	private int minimumY;

	public World(int sizeLimit) {
		this.minimumX = -sizeLimit;
		this.maximumX = sizeLimit;
		this.minimumY = -sizeLimit;
		this.maximumY = sizeLimit;

	}

	public World() {
		this.minimumX = Integer.MIN_VALUE;
		this.maximumX = Integer.MAX_VALUE;
		this.minimumY = Integer.MIN_VALUE;
		this.maximumY = Integer.MAX_VALUE;
	}

	public Location correctCoordinates(int x, int y) {
		if (x > maximumX) { x = minimumX; }
		if (x < minimumX) { x = maximumX; }
		if (y > maximumY) { y = minimumY; }
		if (y < minimumY) { y = maximumY; }

		return new Location(x, y, this);
	}
}
