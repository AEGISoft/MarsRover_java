import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class When_mars_rover_is_dropped {
    @Test
    public void Its_location_should_be_the_drop_location()
    {
        short dropLocation = 0;
        Rover rover = new Rover(dropLocation);
        Assertions.assertEquals(dropLocation, rover.location);
    }


}
