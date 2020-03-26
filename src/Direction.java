import java.awt.*;

public enum Direction {
	NORTH {
		@Override Location moveBackwards(Point locationPoint) {
			return new Location(new Point((int) locationPoint.getX(), (int) locationPoint.getY() - 1));
		}
	},
	EAST,
	SOUTH,
	WEST;

	Location moveBackwards(Point locationPoint) {
		return null;
	}

	Direction turnRight(){
		switch (this){
			case NORTH: return EAST;
			case EAST: return SOUTH;
			case SOUTH: return WEST;
			case WEST: return NORTH;
			default: throw new IllegalArgumentException("unsupported direction");
		}
	}
	Direction turnLeft(){
		switch (this){
			case NORTH: return WEST;
			case WEST: return SOUTH;
			case SOUTH: return EAST;
			case EAST: return NORTH;
			default: throw new IllegalArgumentException("unsupported direction");
		}
	}
}

