import java.awt.*;
import java.util.Objects;

public class Location {
    private Point locationPoint;

    public Location(int x, int y)
    {
        this.locationPoint = new Point(x,y);
    }
    public Location(Point locationPoint)
    {
        this.locationPoint = locationPoint;
    }

    Location moveBackwards(){
        return new Location(new Point((int) locationPoint.getX(), (int) locationPoint.getY() - 1));
    }

    Location moveForward(){
        return new Location(new Point((int) locationPoint.getX(), (int) locationPoint.getY() + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationPoint.equals(location.locationPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationPoint);
    }
}