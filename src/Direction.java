public enum Direction {
	NORTH {
		@Override Location moveBackwards() { return new Location(0, - 1); }
		@Override Location moveForwards() { return new Location(0,1); }
		@Override Direction turnRight() { return EAST; }
		@Override Direction turnLeft() { return WEST; }
	},
	EAST{
		@Override Location moveBackwards() { return new Location(-1,0); }
		@Override Location moveForwards() { return new Location(1, 0); }
		@Override Direction turnRight() { return SOUTH; }
		@Override Direction turnLeft() { return NORTH; }
	},
	SOUTH{
		@Override Location moveBackwards() { return new Location(0, 1); }
		@Override Location moveForwards() { return new Location(0, -1); }
		@Override Direction turnRight() { return WEST; }
		@Override Direction turnLeft() { return EAST; }
	},
	WEST{
		@Override Location moveBackwards() { return new Location(1,0); }
		@Override Location moveForwards() { return new Location(- 1, 0); }
		@Override Direction turnRight() { return NORTH; }
		@Override Direction turnLeft() { return SOUTH; }
	};

	abstract Location moveBackwards();
	abstract Location moveForwards();
	abstract Direction turnRight();
	abstract Direction turnLeft();
}

