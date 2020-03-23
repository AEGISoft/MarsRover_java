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
            direction = direction.turnRight();
        }

    }

    public DirectionEnum getDirection() {
        return direction;
    }
}
