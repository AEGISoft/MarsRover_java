import java.awt.*;

public class Rover {
    private Point location;

    private DirectionEnum direction;

    public Rover(Point dropLocation, DirectionEnum direction) {
        this.location = dropLocation;
        this.direction = direction;
    }

    public Point getLocation() {
        return location;
    }

    public void move(String command) {
        if ("f".equalsIgnoreCase(command)) {
            location = new Point((int) location.getX(), (int) location.getY() + 1);
        } else if ("b".equalsIgnoreCase(command)) {
            location = new Point((int) location.getX(), (int) location.getY() - 1);
        } else {
            if (direction == DirectionEnum.NORTH) {
                direction = DirectionEnum.EAST;
            } else if (direction == DirectionEnum.EAST) {
                direction = DirectionEnum.SOUTH;
            } else if (direction == DirectionEnum.SOUTH) {
                direction = DirectionEnum.WEST;
            } else if (direction == DirectionEnum.WEST) {
				direction = DirectionEnum.NORTH;
			}
        }

    }

    public DirectionEnum getDirection() {
        return direction;
    }
}
