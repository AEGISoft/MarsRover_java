import java.util.Objects;

public class Rover {
    private Location location;
    private Direction direction;

    public Rover(Location dropLocation, Direction direction) {
        this.direction = direction;
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
        return new Rover(location, direction.turnLeft());
    }

    Rover turnRight() {
        return new Rover(location, direction.turnRight());
    }

    Rover moveBackward() {
        return new Rover(location.moveBackwards(direction), direction);
    }

    Rover moveForward() {
        return new Rover(location.moveForward(direction), direction);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "@" + location +
                ", facing=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return location.equals(rover.location) &&
                direction == rover.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, direction);
    }

}
