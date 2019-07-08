package aircraft;

import Weather.Coordinates;
import Weather.Flyable;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equalsIgnoreCase("Baloon")) {
			return new Baloon(name, coordinates);
		} else if (type.equalsIgnoreCase("JetPlane")) {
			return new JetPlane(name, coordinates);
		} else if (type.equalsIgnoreCase("Helicopter")) {
			return new Helicopter(name, coordinates);
		} else {
			System.out.println("Unknown Type: " + type);
			return null;
		}
	}
}