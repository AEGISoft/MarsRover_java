import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class When_mars_rover_is_commanded_to_move {
    @Test
    public void forward_it_should_move_in_the_direction_it_is_facing(){
        Assertions.assertEquals(
                new Rover(new Location(0,1), Direction.NORTH),
                new Rover(new Location(0,0), Direction.NORTH).move(Command.MOVE_FORWARD));
     }
     @Test
    public void backwards_it_should_move_in_the_opposite_direction_it_is_facing(){
         Assertions.assertEquals(
                 new Rover(new Location(0,-1), Direction.NORTH),
                 new Rover(new Location(0, 0), Direction.NORTH).move(Command.MOVE_BACKWARDS));
     }
}
