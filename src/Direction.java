import java.awt.*;

public enum Direction {
	NORTH {
		@Override Location moveBackwards() {
			return new Location(0, - 1);
		}

		@Override Location moveForwards() {
			return new Location(0,1);
		}
	},
	EAST{
		@Override Location moveBackwards() {
			return new Location(-1,0);
		}

		@Override Location moveForwards() {
			return new Location(1, 0);
		}
	},
	SOUTH{
		@Override Location moveBackwards() {
			return new Location(0, 1);
		}

		@Override Location moveForwards() {
			return new Location(0, -1);
		}
	},
	WEST{
		@Override Location moveBackwards() {
			return new Location(1,0);
		}

		@Override Location moveForwards() {
			return new Location(- 1, 0);
		}
	};

	abstract Location moveBackwards();

	abstract Location moveForwards();

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

