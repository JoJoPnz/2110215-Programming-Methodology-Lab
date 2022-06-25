package solar;

public class Planet {
	protected Coordinate coordinate;
	protected Coordinate orbitCenterCoordinate;
	protected int orbitRadius;
	
	public Planet() {
		super();
		coordinate = new Coordinate(1,0);
		orbitCenterCoordinate = new Coordinate(0,0);
		orbitRadius = 1;
	}

	public Planet(int orbitRadius) {
		super();
		orbitCenterCoordinate = new Coordinate(0,0);
		if (orbitRadius <= 1) {
			this.orbitRadius = 1;
		}
		else {
			this.orbitRadius = orbitRadius;
		}
		coordinate = new Coordinate(this.orbitRadius,0);
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Coordinate getOrbitCenterCoordinate() {
		return orbitCenterCoordinate;
	}

	public int getOrbitRadius() {
		return orbitRadius;
	}
	
	public boolean orbit() {
		if ( coordinate.getY() == 0 && coordinate.getX() > 0 ) {
			coordinate = new Coordinate(0,-orbitRadius);
			return true;
		}
		else if ( coordinate.getY() == 0 && coordinate.getX() < 0 ) {
			coordinate = new Coordinate(0,orbitRadius);
			return true;
		}
		else if ( coordinate.getX() == 0 && coordinate.getY() > 0 ) {
			coordinate = new Coordinate(orbitRadius,0);
			return true;
		}
		else if ( coordinate.getX() == 0 && coordinate.getY() < 0 ) {
			coordinate = new Coordinate(-orbitRadius,0);
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
