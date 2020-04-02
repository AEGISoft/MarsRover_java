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
            new Rover(new Location(expected_x, expected_y), direction),
            new Rover(new Location(0,0), direction).move(Command.MOVE_FORWARD));
     }


    private static Stream<Arguments> moveBackwardsInDifferentDirections() {
        return Stream.of(
            Arguments.of(Direction.NORTH, 0, -1),
            Arguments.of(Direction.EAST, -1, 0),
            Arguments.of(Direction.SOUTH, 0, 1),
            Arguments.of(Direction.WEST, 1, 0));}
    @ParameterizedTest
    @MethodSource("moveBackwardsInDifferentDirections")
    public void backwards_it_should_move_in_the_opposite_direction_it_is_facing(
        Direction direction, int expected_x, int expected_y){
        Assertions.assertEquals(
            new Rover(new Location(expected_x, expected_y), direction),
            new Rover(new Location(0, 0), direction).move(Command.MOVE_BACKWARDS));
     }

    private static Stream<Arguments> wrapping() {
        return Stream.of(
                Arguments.of( 0, Integer.MAX_VALUE, Direction.NORTH, Command.MOVE_FORWARD, 0, Integer.MIN_VALUE),
                Arguments.of( 0, Integer.MAX_VALUE, Direction.SOUTH, Command.MOVE_BACKWARDS, 0, Integer.MIN_VALUE),

                Arguments.of( 0, Integer.MIN_VALUE, Direction.SOUTH, Command.MOVE_FORWARD, 0, Integer.MAX_VALUE),
                Arguments.of( 0, Integer.MIN_VALUE, Direction.NORTH, Command.MOVE_BACKWARDS, 0, Integer.MAX_VALUE),

                Arguments.of( Integer.MAX_VALUE, 0, Direction.EAST, Command.MOVE_FORWARD, Integer.MIN_VALUE, 0),
                Arguments.of( Integer.MAX_VALUE, 0, Direction.WEST, Command.MOVE_BACKWARDS, Integer.MIN_VALUE, 0),

                Arguments.of( Integer.MIN_VALUE, 0, Direction.WEST, Command.MOVE_FORWARD, Integer.MAX_VALUE, 0),
                Arguments.of( Integer.MIN_VALUE, 0, Direction.EAST, Command.MOVE_BACKWARDS, Integer.MAX_VALUE, 0)
        );}
    @ParameterizedTest
    @MethodSource("wrapping")
    public void beyond_the_edge_of_the_world_it_should_reappear_on_the_other_side(int start_x, int start_y, Direction facing, Command command, int end_x, int end_y) {
        Assertions.assertEquals(
            new Rover(new Location(end_x, end_y), facing),
            new Rover(new Location(start_x, start_y), facing).move(command)
        );
    }

    private static Stream<Arguments> wrapping2() {
        return Stream.of(
                Arguments.of( 0, 10, Direction.NORTH, Command.MOVE_FORWARD, 0, -10, new World(10)),
                Arguments.of( 0, 10, Direction.SOUTH, Command.MOVE_BACKWARDS, 0, -10, new World(10))
        );}
    @ParameterizedTest
    @MethodSource("wrapping2")
    public void beyond_the_edge_of_the_world_it_should_reappear_on_the_other_side2(int start_x, int start_y, Direction facing, Command command, int end_x, int end_y, World world) {
        Assertions.assertEquals(
                new Rover(new Location(end_x, end_y, world), facing),
                new Rover(new Location(start_x, start_y, world), facing).move(command)
        );
    }
}
