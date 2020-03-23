import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class When_mars_rover_is_dropped {
    private static Stream<Arguments> dropLocations() { return Stream.of(
        Arguments.of(0, 0, DirectionEnum.NORTH),
        Arguments.of(1, -1, DirectionEnum.SOUTH));}
    @ParameterizedTest
    @MethodSource("dropLocations")
    public void Its_location_and_direction_should_be_the_drop_location_and_direction(int x, int y, DirectionEnum direction) {
        Assertions.assertEquals(
                new Rover(new Location(x, y), direction),
                new Rover(new Location(x, y), direction)
        );
	}
}

