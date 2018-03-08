package knearestneighbors;

public class Distance implements Comparable<Distance> {
	private double distance;
	private int index;

	public Distance(double distance, int i){
		this.distance = distance;
		this.index = i;
	}

	public int getIndex(){
		return this.index;
	}

	@Override
	public int compareTo(Distance d) {
		return Double.valueOf(this.distance).compareTo(d.distance);
	}

	@Override
	public String toString(){
		return "[" + distance + " - " + index + "]\n";
	}
}
