package Weather;

import java.io.*;
import java.util.*;

import aircraft.AircraftFactory;

public	class	Simulator {
	private static WeatherTower weatherTower;
	private static List<Flyable> flyables = new ArrayList<Flyable>();
	public static void main(String args[]) throws InterruptedException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			if (line != null) {
				weatherTower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0) {
					System.out.println("Simulator : Value must be a positive one " + simulations);
					System.exit(1);
				}
				while ((line = reader.readLine()) != null) {
					Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
						Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
						Integer.parseInt(line.split(" ")[4]));
					if (flyable != null)
						flyables.add(flyable);
				}

				for (Flyable flyable : flyables) {
					flyable.registerTower(weatherTower);
				}

				for (int i = 1; i <= simulations; i++) {
					weatherTower.changeWeather();
				}
				reader.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Simulator : " + e + "\n" + "Simulator : File Not Found " + args[0]);
		} catch (IOException e) {
			System.out.println("Simulator : " + e);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Simulator : " + e);
		} catch (NullPointerException e) {
			System.out.println("Simulator : value is null" + e);
		} catch (NumberFormatException e) {
			System.out.println("Simulator : Invalid Number entered " + e);
		} finally {
			Logger.getLogger().close();
		}
	}
}