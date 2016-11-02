package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;



public class ShapeTester extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
		
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,300,300);

			Shape test = new Shape(5);
			
			FlowPane controlPane = new FlowPane();
			
			
			
			
			
			
			Button button = new Button("Test");
			controlPane.getChildren().add(button);
			
			root.setCenter(test);
			//root.setTop(controlPane);
			
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

