import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class When_mars_rover_is_commanded_to_turn {
    private static Stream<Arguments> provideDirectionsForRightTest() {
        return Stream.of(
                Arguments.of(DirectionEnum.NORTH,DirectionEnum.EAST),
                Arguments.of(DirectionEnum.EAST,DirectionEnum.SOUTH),
                Arguments.of(DirectionEnum.SOUTH,DirectionEnum.WEST),
                Arguments.of(DirectionEnum.WEST,DirectionEnum.NORTH));}
	@ParameterizedTest
    @MethodSource("provideDirectionsForRightTest")
	void right_it_should_be_facing_90_degrees_clockwise(DirectionEnum directionStart, DirectionEnum expectedDirection) {
        Assertions.assertEquals(
                new Rover(new Location(0,0), expectedDirection),
                new Rover(new Location(0,0), directionStart).move(Command.TURN_RIGHT));
	}

    private static Stream<Arguments> provideDirectionsForLeftTest() {
        return Stream.of(
                Arguments.of(DirectionEnum.NORTH,DirectionEnum.WEST),
                Arguments.of(DirectionEnum.WEST,DirectionEnum.SOUTH),
                Arguments.of(DirectionEnum.SOUTH,DirectionEnum.EAST),
                Arguments.of(DirectionEnum.EAST,DirectionEnum.NORTH));}
    @ParameterizedTest
    @MethodSource("provideDirectionsForLeftTest")
    void left_it_should_be_facing_90_degrees_counterclockwise(DirectionEnum directionStart, DirectionEnum expectedDirection) {
        Assertions.assertEquals(
                new Rover(new Location(0,0), expectedDirection),
                new Rover(new Location(0,0), directionStart).move(Command.TURN_LEFT));
    }
}
