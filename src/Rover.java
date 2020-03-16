import java.awt.*;

public class Rover {
    private final Point location;

    public Rover(Point dropLocation) {
        this.location = dropLocation;
    }

    public Point getLocation() {
        return location;
    }
}
