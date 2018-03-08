package knearestneighbors;

import java.util.LinkedList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ClassifierPane extends StackPane {
	private LinkedList<Sample> samples;
	private Canvas canvas;
	private Classifier classifier;

	public ClassifierPane(Classifier cl){
		this.classifier = cl;
		this.samples = new LinkedList<>();
		this.canvas = new Canvas(500, 500);
		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
			Sample s = new Sample(e.getX(), e.getY());
			classifier.classify(s);
			add(s);
		});
		this.getChildren().add(canvas);
	}

	public void add(Sample s){
		this.samples.add(s);
		drawSample(s);
	}

	private void drawSample(Sample s){
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		gc.fillRect(s.getX(), s.getY(), 10, 10);
		gc.fillText(s.getTag(), s.getX()+15, s.getY()+15);
	}

	public void addAll(List<Sample>ls) {
		for(Sample s: ls)
			add(s);
	}

}
