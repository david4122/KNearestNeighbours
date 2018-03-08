package knearestneighbors;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private ClassifierPane classifier;

	@Override
	public void start(Stage stage){
		SampleLoader loader = new SampleLoader("samples.csv");
		this.classifier = new ClassifierPane(new Classifier(3, loader.load()));

		stage.setTitle("K-Nearest Neighbours");
		Scene scene = new Scene(classifier);
		stage.setScene(scene);

		stage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
}
