import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

class When_mars_rover_is_dropped {
    @Test
    public void Its_location_should_be_the_drop_location() {
        Point dropLocation = new Point(0, 0);

        Rover rover = new Rover(dropLocation, DirectionEnum.NORTH);

        Assertions.assertEquals(dropLocation, rover.getLocation());
    }

	@Test
	public void its_direction_should_be_the_drop_direction() {
		Point dropLocation = new Point(0, 0);

		Rover rover = new Rover(dropLocation, DirectionEnum.NORTH);

		Assertions.assertEquals(DirectionEnum.NORTH, rover.getDirection());
	}

}

class When_mars_rover_is_commanded_to_move {
    @Test
    public void forward_it_should_move_in_the_direction_it_is_facing(){
        Point dropLocation = new Point(0,0);

        Rover rover = new Rover(dropLocation, DirectionEnum.NORTH);

        rover.move("F");

        Point expectedLocation = new Point(0,1);

        Assertions.assertEquals(expectedLocation, rover.getLocation());
     }
     @Test
    public void backwards_it_should_move_in_the_opposite_direction_it_is_facing(){
        Point dropLocation = new Point(0,0);

        Rover rover = new Rover(dropLocation, DirectionEnum.NORTH);

        rover.move("B");

        Point expectedLocation = new Point(0,-1);

        Assertions.assertEquals(expectedLocation, rover.getLocation());
     }

}

class When_mars_rover_is_commanded_to_turn {
	@Test
	void right_it_should_be_facing_90_degrees_clockwise() {
		Point dropLocation = new Point(0,0);

		Rover rover = new Rover(dropLocation, DirectionEnum.NORTH);

		rover.move("R");

		Assertions.assertEquals(DirectionEnum.EAST, rover.getDirection());
	}
}