import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Commands implements Iterable<Command> {
    private List<Command> commands;

    public Commands(String commandString) {
        Command[] commandsAsCharacter = new Command[commandString.length()];
        for (int i = 0; i < commandString.length(); i++) {
            commandsAsCharacter[i] = Command.fromChar(commandString.toCharArray()[i]);
        }
        this.commands = Arrays.asList(commandsAsCharacter);
    }

    @Override
    public Iterator<Command> iterator() {
        return commands.iterator();
    }

    @Override
    public void forEach(Consumer<? super Command> action) {
        commands.forEach(action);
    }

    @Override
    public Spliterator<Command> spliterator() {
        return commands.spliterator();
    }
}
