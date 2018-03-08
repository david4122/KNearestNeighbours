package knearestneighbors;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Classifier {

	private int k;
	private List<Sample>samples;

	public Classifier(int k, List<Sample>samples) {
		this.k = k;
		this.samples = samples;
	}

	public Sample classify(Sample sample) {
		Distance[] distances = new Distance[samples.size()];
		for(int i=0; i<samples.size(); i++)
			distances[i] = new Distance(EuclidesDistanceCalculator.calculate(sample, samples.get(i)), i);

		Map<String, Long>occurences = Stream.of(distances).sorted().limit(k).collect(Collectors.groupingBy(d -> samples.get(d.getIndex()).getTag(), Collectors.counting()));
		sample.setTag(Collections.max(occurences.entrySet(), Map.Entry.comparingByValue()).getKey());
		return sample;
	}

	public void setK(int k) {
		this.k = k;
	}

	public int getK() {
		return k;
	}

}
