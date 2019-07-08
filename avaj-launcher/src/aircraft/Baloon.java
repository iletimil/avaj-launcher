package aircraft;

import Weather.Coordinates;
import Weather.Flyable;
import Weather.WeatherTower;
import Weather.Logger;

public class Baloon extends Aircrafts implements Flyable{

	WeatherTower weatherTower;
	protected Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weahter = weatherTower.getWeather(_coordinates);
		switch(weahter) {
		case "RAIN" :
			_coordinates = new Coordinates(_coordinates.getht() - 5, _coordinates.getlat() + 0, _coordinates.getlo() + 0);
			Logger.getLogger().logToFile("Baloon#" + this._name + "(" + this._id + "): I should have checked the weather this morning. Curse you rain!!");
			break;
		case "FOG" :
			_coordinates = new Coordinates(_coordinates.getht() - 2, _coordinates.getlat() + 0, _coordinates.getlo() + 0);
			Logger.getLogger().logToFile("Baloon#" + this._name + "(" + this._id + "): This fog is too thick.");
			break;
		case "SUN" : 
			_coordinates = new Coordinates(_coordinates.getht() + 4, _coordinates.getlat() + 0, _coordinates.getlo() + 2);
			Logger.getLogger().logToFile("Baloon#" + this._name + "(" + this._id + "): This is hot");
			break;
		case "SNOW" :
			_coordinates = new Coordinates(_coordinates.getht() - 15, _coordinates.getlat() + 0, _coordinates.getlo() + 0);
			Logger.getLogger().logToFile("Baloon#" + this._name + "(" + this._id + "): Snow! Winter is coming!!!");
		}
	}

	public void registerTower(WeatherTower WeatherTower) {
		weatherTower = WeatherTower;
		WeatherTower.register(this);
		Logger.getLogger()
		.logToFile("Tower says: Baloon#" + this._name + "(" + this._id + ")" + " registered to weather tower.");
	}
}
