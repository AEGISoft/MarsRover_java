import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdditionOfLocationAdding {
	@Test
	void test() {
		Assertions.assertEquals(new Location(2, 2), new Location(1, 1).add(new Location(1, 1)));
	}

	@Test
	void test2() {
		Assertions.assertEquals(new Location(0, 0), new Location(1, 1).add(new Location(-1, -1)));
	}
}
