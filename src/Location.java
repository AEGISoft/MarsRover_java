import java.util.Objects;

public class Location extends Coordinate {
    private World world;

    public Location(int x, int y)
    {
        this(x, y, new World());
    }

    public Location(int x, int y, World world) {
        super(x, y);

        this.world = world;
    }

    Location moveBackwards(Direction direction){
        return this.add(direction.moveBackwards());
    }
    Location moveForward(Direction direction) {
        return this.add(direction.moveForwards());
    }


    private Location add(Step step) {
        return world.correctCoordinates(x + step.x, y + step.y);
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

    @Override public int hashCode() {
        return Objects.hash(x, y);
    }
}