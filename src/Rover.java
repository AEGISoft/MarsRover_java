import java.util.Objects;
import java.util.function.BiFunction;

public class Rover {
    private Location location;
    private Direction facing;

    public Rover(Location dropLocation, Direction facing) {
        this.facing = facing;
        this.location = dropLocation;
    }

    public Rover move(Commands commands) {
        BiFunction<Rover, ? super Command, Rover> action = Rover::move;
        return commands.executeAccumulativelyStartingWith(this, action);
    }

    public Rover move(Command command){
        return command.executeOn(this);
    }

    Rover turnLeft() {
        return new Rover(location, facing.turnLeft());
    }

    Rover turnRight() {
        return new Rover(location, facing.turnRight());
    }

    Rover moveBackward() {
        return new Rover(location.moveBackwards(facing), facing);
    }

    Rover moveForward() {
        return new Rover(location.moveForward(facing), facing);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "@" + location +
                ", facing=" + facing +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return location.equals(rover.location) &&
                facing == rover.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, facing);
    }

}
