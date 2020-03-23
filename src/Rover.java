import java.util.Objects;

public class Rover {
    private Location location;
    private DirectionEnum direction;

    public Rover(Location dropLocation, DirectionEnum direction) {
        this.direction = direction;
        location = dropLocation;
    }

    public Rover moveRover(Command command){
        switch (command){
            case MOVE_FORWARD:      return new Rover(location.moveForward(), direction);
            case MOVE_BACKWARDS:    return new Rover(location.moveBackwards(), direction);
            case TURN_RIGHT:        return new Rover(location, direction.turnRight());
            case TURN_LEFT:         return new Rover(location, direction.turnLeft());
            default: throw new IllegalArgumentException("command not supported");
        }
    }
    public Rover move(char command) {
        if (moveForwardIsThe(String.valueOf(command)))      { return new Rover(location.moveForward(), direction);   }
        if (moveBackwardsIsThe(String.valueOf(command)))    { return new Rover(location.moveBackwards(), direction); }
        if (turnRightIsThe(String.valueOf(command)))        { return new Rover(location, direction.turnRight());     }
        return new Rover(location, direction.turnLeft());
    }

    private boolean turnRightIsThe(String command)      { return "r".equalsIgnoreCase(command); }
    private boolean moveBackwardsIsThe(String command)  { return "b".equalsIgnoreCase(command); }
    private boolean moveForwardIsThe(String command)    { return "f".equalsIgnoreCase(command); }

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
