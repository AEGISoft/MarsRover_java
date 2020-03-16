import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;

class When_mars_rover_is_dropped {
    @Test
    public void Its_location_should_be_the_drop_location()
    {
        Point dropLocation = new Point(0,0);

        Rover rover = new Rover(dropLocation);

        Assertions.assertEquals(dropLocation, rover.getLocation());
    }

    @Test
    public void checkMoveForward(){
        Point dropLocation = new Point(0,0);

        Rover rover = new Rover(dropLocation);

        rover.move("F");

        Point expectedLocation = new Point(0,1);

        Assertions.assertEquals(expectedLocation, rover.getLocation());
     }
     @Test
    public void checkMoveBackwards(){
        Point dropLocation = new Point(0,0);

        Rover rover = new Rover(dropLocation);

        rover.move("B");

        Point expectedLocation = new Point(0,-1);

        Assertions.assertEquals(expectedLocation, rover.getLocation());
     }

}
