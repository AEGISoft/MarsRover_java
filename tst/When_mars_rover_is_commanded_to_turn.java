import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class When_mars_rover_is_commanded_to_turn {
    private static Stream<Arguments> provideDirectionsForRightTest() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Direction.EAST),
                Arguments.of(Direction.EAST, Direction.SOUTH),
                Arguments.of(Direction.SOUTH, Direction.WEST),
                Arguments.of(Direction.WEST, Direction.NORTH));}
	@ParameterizedTest
    @MethodSource("provideDirectionsForRightTest")
	void right_it_should_be_facing_90_degrees_clockwise(Direction directionStart, Direction expectedDirection) {
        Assertions.assertEquals(
                new Rover(new Location(0,0), expectedDirection),
                new Rover(new Location(0,0), directionStart).move(Command.TURN_RIGHT));
	}

    private static Stream<Arguments> provideDirectionsForLeftTest() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Direction.WEST),
                Arguments.of(Direction.WEST, Direction.SOUTH),
                Arguments.of(Direction.SOUTH, Direction.EAST),
                Arguments.of(Direction.EAST, Direction.NORTH));}
    @ParameterizedTest
    @MethodSource("provideDirectionsForLeftTest")
    void left_it_should_be_facing_90_degrees_counterclockwise(Direction directionStart, Direction expectedDirection) {
        Assertions.assertEquals(
                new Rover(new Location(0,0), expectedDirection),
                new Rover(new Location(0,0), directionStart).move(Command.TURN_LEFT));
    }
}
