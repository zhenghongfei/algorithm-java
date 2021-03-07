package alg.ninegrid;

public class Grid {

	private int x;

	private int y;

	private int value;

	private boolean exitsData;

	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isExitsData() {
		return exitsData;
	}

	public void setExitsData(boolean exitsData) {
		this.exitsData = exitsData;
	}

	public Grid copy() {
		Grid grid = new Grid(this.x, this.y);
		grid.value = this.value;
		grid.exitsData = this.exitsData;
		return grid;
	}
}