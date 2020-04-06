public enum Direction {
	NORTH {
		@Override Step moveBackwards() { return Step.SOUTH; }
		@Override Step moveForwards() { return Step.NORTH; }
		@Override Direction turnRight() { return EAST; }
		@Override Direction turnLeft() { return WEST; }
	},
	EAST{
		@Override Step moveBackwards() { return Step.WEST; }
		@Override Step moveForwards() { return Step.EAST; }
		@Override Direction turnRight() { return SOUTH; }
		@Override Direction turnLeft() { return NORTH; }
	},
	SOUTH{
		@Override Step moveBackwards() { return Step.NORTH; }
		@Override Step moveForwards() { return Step.SOUTH; }
		@Override Direction turnRight() { return WEST; }
		@Override Direction turnLeft() { return EAST; }
	},
	WEST{
		@Override Step moveBackwards() { return Step.EAST; }
		@Override Step moveForwards() { return Step.WEST; }
		@Override Direction turnRight() { return NORTH; }
		@Override Direction turnLeft() { return SOUTH; }
	};

	abstract Step moveBackwards();
	abstract Step moveForwards();
	abstract Direction turnRight();
	abstract Direction turnLeft();
}

