package application;
	
import java.util.HashSet;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


public class GameTester extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
		
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			

			
			Set<Integer> num_sides_test = new HashSet<Integer>();
			for(int i = 3; i < 10; i++)
				num_sides_test.add(i);
			
			Set<NamedColor> color_test = new HashSet<NamedColor>();
			color_test.add(new NamedColor(Color.RED, "Red"));
			color_test.add(new NamedColor(Color.GREEN, "Green"));
			color_test.add(new NamedColor(Color.BLUE, "Blue"));
			
			Game testGame = new Game(5, num_sides_test, color_test);
			
			root.getChildren().add(testGame);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
