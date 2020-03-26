import java.awt.*;

public enum Direction {
	NORTH {
		@Override Location moveBackwards(Point locationPoint) {
			return new Location(new Point((int) locationPoint.getX(), (int) locationPoint.getY() - 1));
		}
	},
	EAST{
		@Override Location moveBackwards(Point locationPoint) {
			return new Location(new Point((int) locationPoint.getX() - 1, (int) locationPoint.getY()));
		}
	},
	SOUTH{
		@Override Location moveBackwards(Point locationPoint) {
			return new Location(new Point((int) locationPoint.getX(), (int) locationPoint.getY() + 1));
		}
	},
	WEST{
		@Override Location moveBackwards(Point locationPoint) {
			return new Location(new Point((int) locationPoint.getX() + 1, (int) locationPoint.getY()));
		}
	};




	abstract Location moveBackwards(Point locationPoint);

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

