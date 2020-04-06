public enum Direction {
	NORTH {
		@Override Location moveBackwards() { return Step.SOUTH; }
		@Override Location moveForwards() { return Step.NORTH; }
		@Override Direction turnRight() { return EAST; }
		@Override Direction turnLeft() { return WEST; }
	},
	EAST{
		@Override Location moveBackwards() { return Step.WEST; }
		@Override Location moveForwards() { return Step.EAST; }
		@Override Direction turnRight() { return SOUTH; }
		@Override Direction turnLeft() { return NORTH; }
	},
	SOUTH{
		@Override Location moveBackwards() { return Step.NORTH; }
		@Override Location moveForwards() { return Step.SOUTH; }
		@Override Direction turnRight() { return WEST; }
		@Override Direction turnLeft() { return EAST; }
	},
	WEST{
		@Override Location moveBackwards() { return Step.EAST; }
		@Override Location moveForwards() { return Step.WEST; }
		@Override Direction turnRight() { return NORTH; }
		@Override Direction turnLeft() { return SOUTH; }
	};

	abstract Location moveBackwards();
	abstract Location moveForwards();
	abstract Direction turnRight();
	abstract Direction turnLeft();
}

