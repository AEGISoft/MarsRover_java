import java.awt.*;

public class Location {
    private Point locationPoint;

    public Location(Point locationPoint)
    {
        this.locationPoint = locationPoint;
    }

    Location moveBackwards(){
        return new Location(moveBackwardsPoint());
    }

    Location moveForward(){
        return new Location(moveForwardPoint());
    }

    Point moveBackwardsPoint() {
        return new Point((int) locationPoint.getX(), (int) locationPoint.getY() - 1);
    }

    Point moveForwardPoint() {
        return new Point((int) locationPoint.getX(), (int) locationPoint.getY() + 1);
    }

    public Point getPoint() {
        return locationPoint;
    }
}