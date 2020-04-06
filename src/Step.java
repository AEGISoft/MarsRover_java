public class Step extends Coordinate {
	public static final Step SOUTH = new Step(0, - 1);

	public static final Step NORTH = new Step(0,1);

	public static final Step EAST = new Step(1, 0);

	public static final Step WEST = new Step(-1, 0);

	private Step(int x, int y) {
		super(x, y);
	}
}
