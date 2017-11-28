package za.co.wtc.swingy.modle;

public class Coordinate {
	private int x, y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void advance(Direction direction) {
		switch (direction) {
			case North:
				y -= 1;
				break;
			case East:
				x += 1;
				break;
			case South:
				y += 1;
				break;
			case West:
				x -= 1;
				break;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean equals(Coordinate other) {
		return (this.y == other.y && this.x == other.x);
	}
}
