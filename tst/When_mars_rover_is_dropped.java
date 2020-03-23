import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.stream.Stream;

class When_mars_rover_is_dropped {

    private static Stream<Arguments> dropLocations() { return Stream.of(
        Arguments.of(0, 0, DirectionEnum.NORTH),
        Arguments.of(1, -1, DirectionEnum.SOUTH));}
    @ParameterizedTest
    @MethodSource("dropLocations")
    public void Its_location_and_direction_should_be_the_drop_location_and_direction(int x, int y, DirectionEnum direction) {
        Assertions.assertEquals(
                new Rover(new Location(x,y), direction),
                new Rover(new Location(x, y), direction)
        );
	}

}

class When_mars_rover_is_commanded_to_move {
    @Test
    public void forward_it_should_move_in_the_direction_it_is_facing(){
        Point dropLocation = new Point(0,0);

        Rover rover = new Rover(dropLocation, DirectionEnum.NORTH);

        rover.move("F");

        Point expectedLocation = new Point(0,1);

        Assertions.assertEquals(expectedLocation, rover.getLocationPoint());
     }
     @Test
    public void backwards_it_should_move_in_the_opposite_direction_it_is_facing(){
        Point dropLocation = new Point(0,0);

        Rover rover = new Rover(dropLocation, DirectionEnum.NORTH);

        rover.move("B");

        Point expectedLocation = new Point(0,-1);

        Assertions.assertEquals(expectedLocation, rover.getLocationPoint());
     }

}

class When_mars_rover_is_commanded_to_turn {

    private static Stream<Arguments> provideDirectionsForRightTest() {
        return Stream.of(
                Arguments.of(DirectionEnum.NORTH,DirectionEnum.EAST),
                Arguments.of(DirectionEnum.EAST,DirectionEnum.SOUTH),
                Arguments.of(DirectionEnum.SOUTH,DirectionEnum.WEST),
                Arguments.of(DirectionEnum.WEST,DirectionEnum.NORTH)
        );
    }

	@ParameterizedTest
    @MethodSource("provideDirectionsForRightTest")
	void right_it_should_be_facing_90_degrees_clockwise(DirectionEnum directionStart, DirectionEnum expectedDirection) {
		Point dropLocation = new Point(0,0);

		Rover rover = new Rover(dropLocation, directionStart);

		rover.move("R");

		Assertions.assertEquals(expectedDirection, rover.getDirection());
	}


    private static Stream<Arguments> provideDirectionsForLeftTest() {
        return Stream.of(
                Arguments.of(DirectionEnum.NORTH,DirectionEnum.WEST),
                Arguments.of(DirectionEnum.WEST,DirectionEnum.SOUTH),
                Arguments.of(DirectionEnum.SOUTH,DirectionEnum.EAST),
                Arguments.of(DirectionEnum.EAST,DirectionEnum.NORTH)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDirectionsForLeftTest")
    void left_it_should_be_facing_90_degrees_counterclockwise(DirectionEnum directionStart, DirectionEnum expectedDirection) {
        Point dropLocation = new Point(0,0);

        Rover rover = new Rover(dropLocation, directionStart);

        rover.move("L");

        Assertions.assertEquals(expectedDirection, rover.getDirection());
    }
}