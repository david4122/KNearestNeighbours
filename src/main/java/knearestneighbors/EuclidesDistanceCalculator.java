package knearestneighbors;

public class EuclidesDistanceCalculator {
	public static double calculate(Sample s1, Sample s2) {
		return Math.sqrt(
				Math.pow(s1.getX()-s2.getX(), 2)+Math.pow(s1.getY()-s2.getY(), 2));
	}
}
