import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class When_mars_rover_receives_unknown_command {
	@Test
	public void it_should_ignore_the_command_and_stay_there(){
		Assertions.assertEquals(
				new Rover(new Location(0,0),Direction.NORTH),
				new Rover(new Location(0,0),Direction.NORTH).move(new Commands("X"))
		);
	}
}
