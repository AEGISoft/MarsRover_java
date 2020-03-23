public enum DirectionEnum {
	NORTH {
		@Override DirectionEnum turnRight(){return EAST;}
		@Override DirectionEnum turnLeft(){return WEST;}
	},

	EAST{
		@Override DirectionEnum turnRight(){return SOUTH;}
		@Override DirectionEnum turnLeft(){return NORTH;}
	},

	SOUTH{
		@Override DirectionEnum turnRight(){return WEST;}
		@Override DirectionEnum turnLeft(){return EAST;}
	},

	WEST{
		@Override DirectionEnum turnRight(){return NORTH;}
		@Override DirectionEnum turnLeft(){return SOUTH;}
	};

	abstract DirectionEnum turnRight();
	abstract DirectionEnum turnLeft();
}

