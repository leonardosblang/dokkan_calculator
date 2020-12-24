package main;

import javafx.application.Application;
import javafx.stage.Stage;
import states.UIStates;

public class Runnable extends Application {
	private void initOverview() {
		UIStates.changeView("MainMenu.fxml");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		UIStates.primaryStage = primaryStage;
		UIStates.primaryStage.setTitle("Dokkan Calculator");
		
		initOverview();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
