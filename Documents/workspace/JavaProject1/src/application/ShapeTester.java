package application;
	
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;


public class ShapeTester extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
		
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			
			Shape test = new Shape(10);
			
			FlowPane controlPane = new FlowPane();
			
			
			
			
			
			
			Button button = new Button("Test");
			controlPane.getChildren().add(button);
			
			root.setCenter(test);
			root.setTop(controlPane);
			
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

