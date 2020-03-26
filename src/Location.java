import java.awt.*;
import java.util.Objects;

public class Location {
    private Point locationPoint;
    private int x;
    private int y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.locationPoint = new Point(x,y);
    }
    public Location(Point locationPoint)
    {
        this.locationPoint = locationPoint;
        this.x = locationPoint.x;
        this.y = locationPoint.y;
    }



    Location moveBackwards(Direction direction){
        return direction.moveBackwards(locationPoint);
    }

    Location moveForward(Direction direction){
        switch (direction){
            case NORTH:return new Location(x,y + 1);
            case EAST: return new Location(x + 1, y);
            case SOUTH:return new Location(x, y - 1);
            case WEST: return new Location(x - 1, y);
            default: throw new IllegalArgumentException("no such direction");
        }
    }

    @Override
    public String toString() {
        return "Location{" + x + ", " + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationPoint);
    }

    public Location add(Location other) {
        return new Location(x + other.x, y + other.y);
    }
}