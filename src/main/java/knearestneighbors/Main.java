package knearestneighbors;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	private ClassifierPane classifier;

	@Override
	public void start(Stage stage){
		stage.setTitle("K-Nearest Neighbours");
		SampleLoader loader = new SampleLoader("samples.csv");
		LinkedList<Sample>samples = loader.load();
		this.classifier = new ClassifierPane(new Classifier(2, samples));
		classifier.addAll(samples);
		StackPane root = new StackPane();
		root.getChildren().add(new Label("QWERTY"));
		Scene scene = new Scene(classifier);
		stage.setScene(scene);

		stage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}
