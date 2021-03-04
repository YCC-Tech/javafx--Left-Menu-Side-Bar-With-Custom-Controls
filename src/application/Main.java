package application;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	double xOffset, yOffset = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
			/* Remove original title bar and windows control buttons */
			primaryStage.initStyle(StageStyle.UNDECORATED);
			
			/* Restrict windows to be resizable */
			primaryStage.setResizable(false);

			Parent root = FXMLLoader.load(getClass().getResource("/resources/pages/Students.fxml"));
			root.setStyle("-fx-background-color: transparent; "); 
			
			/* Make window to be draggable */
			root.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					xOffset = primaryStage.getX() - event.getScreenX();
					yOffset = primaryStage.getY() - event.getScreenY();
				}
			});
			root.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					primaryStage.setX(event.getScreenX() + xOffset);
					primaryStage.setY(event.getScreenY() + yOffset);
				}
			});

			Scene scene = new Scene(root);
			
			JMetro jMetro = new JMetro(Style.LIGHT);
			jMetro.setScene(scene);
			
			scene.setFill(Color.TRANSPARENT);
			scene.getStylesheets().add(getClass().getResource("/resources/css/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
