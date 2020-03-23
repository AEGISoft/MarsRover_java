import java.awt.*;

public class Rover {
    private Location location;
    private Point locationPoint;

    private DirectionEnum direction;

    public Rover(Point dropLocation, DirectionEnum direction) {
        this.locationPoint = dropLocation;
        this.direction = direction;
        location = new Location(dropLocation);
    }

    public Point getLocationPoint() {
        return locationPoint;
    }

    public void move(String command) {
        if ("f".equalsIgnoreCase(command)) {
            locationPoint = location.moveForwardPoint();
            location = location.moveForward();
        } else if ("b".equalsIgnoreCase(command)) {
            locationPoint = location.moveBackwardsPoint();
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
