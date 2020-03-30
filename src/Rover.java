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
        switch (command){
            case MOVE_FORWARD:      return command.execute(this);
            case MOVE_BACKWARDS:    return new Rover(location.moveBackwards(direction), direction);
            case TURN_RIGHT:        return new Rover(location, direction.turnRight());
            case TURN_LEFT:         return new Rover(location, direction.turnLeft());
            default: throw new IllegalArgumentException("command not supported");
        }
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
