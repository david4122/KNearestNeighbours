package knearestneighbors;

public class Sample {

	private String tag;
	private double x;
	private double y;

	public Sample(String tag, double x, double y) {
		this(x, y);
		this.tag = tag;
	}

	public Sample(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString(){
		return String.format("[%s (%f, %f)]", tag, x, y);
	}
}
