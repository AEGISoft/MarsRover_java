import static java.lang.Character.toUpperCase;

public enum Command {
    MOVE_BACKWARDS, TURN_RIGHT, TURN_LEFT, MOVE_FORWARD;

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
