package aircraft;

import Weather.Coordinates;
import Weather.Flyable;
import Weather.Logger;
import Weather.WeatherTower;

public class JetPlane extends Aircrafts implements Flyable{

	WeatherTower weatherTower;
	protected JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}


	public void updateConditions() {
		String weahter = weatherTower.getWeather(_coordinates);
		switch(weahter) {
		case "RAIN" :
			_coordinates = new Coordinates(_coordinates.getht() + 0, _coordinates.getlat() + 0, _coordinates.getlo() + 5);
			Logger.getLogger().logToFile("JetPlane#" + this._name + "(" + this._id + "): I should have checked the weather this morning. Curse you rain!!");
			break;
		case "FOG" :
			_coordinates = new Coordinates(_coordinates.getht() + 0, _coordinates.getlat() + 0, _coordinates.getlo() + 1);
			Logger.getLogger().logToFile("JetPlane#" + this._name + "(" + this._id + "): This fog is too thick.");
			break;
		case "SUN" : 
			_coordinates = new Coordinates(_coordinates.getht() + 2, _coordinates.getlat() + 0, _coordinates.getlo() + 10);
			Logger.getLogger().logToFile("JetPlane#" + this._name + "(" + this._id + "): This is hot");
			break;
		case "SNOW" :
			_coordinates = new Coordinates(_coordinates.getht() - 7, _coordinates.getlat() + 0, _coordinates.getlo() + 0);
			Logger.getLogger().logToFile("JetPlane#" + this._name + "(" + this._id + "): Snow! Winter is coming!!!");
		}
	}

	public void registerTower(WeatherTower WeatherTower) {
		weatherTower = WeatherTower;
		Logger.getLogger()
				.logToFile("Tower says: JetPlane#" + this._name + "(" + this._id + ")" + " registered to weather tower.");
		WeatherTower.register(this);
		
	}

}
