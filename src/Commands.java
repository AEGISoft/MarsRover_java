public class Commands {
    private final String commandString;

    public Commands(String commandString) {
        this.commandString = commandString;
    }

    public Command[] asArray() {
        Command[] commands = new Command[commandString.length()];
        for (int i = 0; i < commandString.length(); i++) {
            commands[i] = Command.fromChar(commandString.toCharArray()[i]);
        }
        return commands;
    }
}
