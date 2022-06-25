package solar;

import java.util.ArrayList;

public class Application {
	private static ArrayList<Planet> planets = new ArrayList<>();
	
	public static String printPlanet(Planet planet) {
		if (planet instanceof Earth) {
			Earth planet1 = (Earth) planet;
			return "Earth's Waste Level is " + planet1.getWasteLevel();
		}
		else if (planet instanceof Saturn) {
			Saturn planet2 = (Saturn) planet;
			return "Saturn's Speed is " + planet2.getSpeed();
		}
		else {
			return "";
		}
	}
	
	public static void main() {
		Earth a = new Earth(1,4);
		Saturn b = new Saturn(2,2);
		planets.add(a);
		planets.add(b);
		for (Planet planet : planets) {
			printPlanet(planet);
		}
	}
	
	
	
}
