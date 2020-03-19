public enum DirectionEnum {
	NORTH (0),
	EAST(90),
	SOUTH(180),
	WEST (270);

	private int degrees;

	DirectionEnum(int degrees){
		this.degrees = degrees;
	}
}

