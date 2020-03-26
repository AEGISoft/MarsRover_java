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

    Location moveBackwards(Direction direction){
        switch (direction){
            case NORTH:
                return direction.moveBackwards(locationPoint);
        case EAST: return new Location(new Point((int) locationPoint.getX() - 1, (int) locationPoint.getY()));
            case SOUTH:return new Location(new Point((int) locationPoint.getX(), (int) locationPoint.getY() + 1));
            case WEST: return new Location(new Point((int) locationPoint.getX() + 1, (int) locationPoint.getY()));
            default: throw new IllegalArgumentException("no such direction");
        }
    }

    Location moveForward(Direction direction){
        switch (direction){
            case NORTH:return new Location(new Point((int) locationPoint.getX(), (int) locationPoint.getY() + 1));
            case EAST: return new Location(new Point((int) locationPoint.getX() + 1, (int) locationPoint.getY()));
            case SOUTH:return new Location(new Point((int) locationPoint.getX(), (int) locationPoint.getY() - 1));
            case WEST: return new Location(new Point((int) locationPoint.getX() - 1, (int) locationPoint.getY()));
            default: throw new IllegalArgumentException("no such direction");
        }
    }

    @Override
    public String toString() {
        return "Location{" + locationPoint.x + ", " + locationPoint.y + "}";
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