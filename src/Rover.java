import java.awt.*;

public class Rover {
    private Point location;

    public Rover(Point dropLocation) {
        this.location = dropLocation;
    }

    public Point getLocation() {
        return location;
    }

    public void move(String command) {
    	if("f".equalsIgnoreCase(command)){
			location = new Point((int) location.getX(), (int) location.getY() + 1);
		}
    	else{
			location = new Point((int) location.getX(), (int) location.getY() - 1);
		}

    }
}
