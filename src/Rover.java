import java.awt.*;

public class Rover {
    private Location location;

    private DirectionEnum direction;

    public Rover(Point dropLocation, DirectionEnum direction) {
        this.direction = direction;
        location = new Location(dropLocation);
    }

    public Point getLocationPoint() {
        return location.getPoint();
    }

    public void move(String command) {
        if ("f".equalsIgnoreCase(command)) {
            location = location.moveForward();
        } else if ("b".equalsIgnoreCase(command)) {
            location = location.moveBackwards();
        } else if ("r".equalsIgnoreCase(command)) {
            direction = direction.turnRight();
        } else {
            direction = direction.turnLeft();
        }
    }

    public DirectionEnum getDirection() {
        return direction;
    }
}
