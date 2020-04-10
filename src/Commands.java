import java.util.*;
import java.util.function.*;

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

    public Rover executeAccumulativelyStartingWith(Rover initialRover, BiFunction<Rover, ? super Command, Rover> action) {
        BinaryOperator<Rover> combiner = (r1, r2) -> {throw new UnsupportedOperationException();};
        return commands.stream().reduce(initialRover, action, combiner);
    }

}
