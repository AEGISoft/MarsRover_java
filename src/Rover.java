import java.awt.*;

public class Rover {
    private Location location;
    private DirectionEnum direction;

    public Rover(Point dropLocation, DirectionEnum direction) {
        this.direction = direction;
        location = new Location(dropLocation);
    }

    public Rover(Location dropLocation, DirectionEnum direction) {
        this.direction = direction;
        location = dropLocation;
    }

    public Point getLocationPoint() {
        return location.getPoint();
    }

    public Rover moveRover(char command) {
        if (moveForwardIsThe(String.valueOf(command)))      { return new Rover(location.moveForward(), direction);   }
        if (moveBackwardsIsThe(String.valueOf(command)))    { return new Rover(location.moveBackwards(), direction); }
        if (turnRightIsThe(String.valueOf(command)))        { return new Rover(location, direction.turnRight());     }
        return new Rover(location, direction.turnLeft());
    }
    public void move(String command) {
        if (moveForwardIsThe(command))      { location = location.moveForward();    } else
        if (moveBackwardsIsThe(command))    { location = location.moveBackwards();  } else
        if (turnRightIsThe(command))        { direction = direction.turnRight();    } else
                                            { direction = direction.turnLeft();     }
    }

    private boolean turnRightIsThe(String command)      { return "r".equalsIgnoreCase(command); }
    private boolean moveBackwardsIsThe(String command)  { return "b".equalsIgnoreCase(command); }
    private boolean moveForwardIsThe(String command)    { return "f".equalsIgnoreCase(command); }

    public DirectionEnum getDirection() {
        return direction;
    }
}
