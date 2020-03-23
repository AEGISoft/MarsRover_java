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
            location = moveForward();
        } else if ("b".equalsIgnoreCase(command)) {
            location = moveBackwards();
        } else if ("r".equalsIgnoreCase(command)) {
            direction = direction.turnRight();
        } else {
            direction = direction.turnLeft();
        }
    }

    private Point moveBackwards() {
        return new Point((int) location.getX(), (int) location.getY() - 1);
    }

    private Point moveForward() {
        return new Point((int) location.getX(), (int) location.getY() + 1);
    }

    public DirectionEnum getDirection() {
        return direction;
    }
}
