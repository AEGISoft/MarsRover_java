import static java.lang.Character.toUpperCase;

public enum Command {
    MOVE_BACKWARDS { @Override Rover execute(Rover rover) { return rover.moveBackward();} },
    TURN_RIGHT { @Override Rover execute(Rover rover) { return rover.turnRight(); }},
    TURN_LEFT { @Override Rover execute(Rover rover) { return rover.turnLeft(); } },
    MOVE_FORWARD { @Override Rover execute(Rover rover) { return rover.moveForward(); } },
    UNKNOWN { @Override Rover execute(Rover rover) { return rover; } };

    abstract Rover execute(Rover rover);

    public static Command fromChar(char commandChar) {
        switch(toUpperCase(commandChar)){
            case 'F' : return MOVE_FORWARD;
            case 'B' : return MOVE_BACKWARDS;
            case 'L' : return TURN_LEFT;
            case 'R' : return TURN_RIGHT;
            default : return UNKNOWN;
        }
    }
}
