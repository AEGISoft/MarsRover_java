import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class When_mars_rover_is_commanded_to_move {
    private static Stream<Arguments> moveForwardInDifferentDirections() {
        return Stream.of(
                Arguments.of(Direction.NORTH, 0, 1),
                Arguments.of(Direction.EAST, 1, 0),
                Arguments.of(Direction.SOUTH, 0, -1),
                Arguments.of(Direction.WEST, -1, 0));}
    @ParameterizedTest
    @MethodSource("moveForwardInDifferentDirections")
    public void forward_it_should_move_in_the_direction_it_is_facing(
        Direction direction, int expected_x, int expected_y){
        Assertions.assertEquals(
                new Rover(new Location(expected_x,expected_y), direction),
                new Rover(new Location(0,0), direction).move(Command.MOVE_FORWARD));
     }
     @Test
    public void backwards_it_should_move_in_the_opposite_direction_it_is_facing(){
         Assertions.assertEquals(
                 new Rover(new Location(0,-1), Direction.NORTH),
                 new Rover(new Location(0, 0), Direction.NORTH).move(Command.MOVE_BACKWARDS));
     }
}
