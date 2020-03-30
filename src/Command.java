import static java.lang.Character.toUpperCase;

public enum Command {
    MOVE_BACKWARDS {
        @Override
        Rover execute(Rover rover) {
            return null;
        }
    },
    TURN_RIGHT {
        @Override
        Rover execute(Rover rover) {
            return null;
        }},
    TURN_LEFT{
        @Override
        Rover execute(Rover rover) {
            return null;
        }},
    MOVE_FORWARD { @Override Rover execute(Rover rover) { return rover.moveForward(); } };

    abstract Rover execute(Rover rover);

    public static Command fromChar(char commandChar) {
        switch(toUpperCase(commandChar)){
            case 'F' : return MOVE_FORWARD;
            case 'B' : return MOVE_BACKWARDS;
            case 'L' : return TURN_LEFT;
            case 'R' : return TURN_RIGHT;
            default : throw new IllegalArgumentException("unsupported command");
        }
    }
}
