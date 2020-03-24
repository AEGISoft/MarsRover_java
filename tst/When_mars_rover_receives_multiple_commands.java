import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Disabled("while fixing moving based on direction")
public class When_mars_rover_receives_multiple_commands {
    private static Stream<Arguments> commandSequence() {
        return Stream.of(
            Arguments.of(0, 0, Direction.NORTH, "RF", 1, 0, Direction.EAST)
        );}
    @ParameterizedTest @MethodSource("commandSequence")
    public void it_should_execute_them_in_order(
            int start_x, int start_y, Direction start_direction,
            String commands,
            int end_x, int end_y, Direction end_direction){
        Assertions.assertEquals(
                new Rover(new Location(end_x, end_y), end_direction),
                new Rover(new Location(start_x, start_y),start_direction).move(new Commands(commands))
        );
    }

}
