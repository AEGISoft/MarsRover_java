import java.util.Objects;

public class Rover {
    private Location location;
    private Direction facing;

    public Rover(Location dropLocation, Direction facing) {
        this.facing = facing;
        location = dropLocation;
    }

    public Rover move(Commands commands) {
        Rover rover = this; //ignore IDE concurrency warning as Rover is designed to being immutable
        for (Command command: commands.asArray()) rover = rover.move(command);
        return rover;
    }

    public Rover move(Command command){
        return command.execute(this);
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
