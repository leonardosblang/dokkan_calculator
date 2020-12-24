package states;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UIStates {
	public static int extraPanes;
	
	public static Stage primaryStage;
	public static Pane root;
	
    public static int settings = 0;
    
	public static String theme;
	
	public static Image artPreview;
	
	public static Image icon;
	
	public static int apt;
	
	public static float support;
	
	public static float links;
	
	public static int leader;
	
	public static String name;
	
	public static String subname;
	
	public static String Team;
	
	public static String cardtype;
	
	public static String cardrarity;
	
	public static int add;
	
	public static int crit;
	
	public static File iconFile;
	
	public static File artFile;
	
	public static WritableImage artPreviewImage;
	
	
	public static void changeView(String viewPath) {
		FXMLLoader fxmlLoader = new FXMLLoader();

		try {
			UIStates.root = fxmlLoader.load(UIStates.class.getResource("/view/" + viewPath).openStream());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		Scene scene = new Scene(UIStates.root);
		UIStates.primaryStage.setScene(scene);

		if (!UIStates.primaryStage.isShowing()) {
			UIStates.primaryStage.sizeToScene();
			UIStates.primaryStage.setResizable(false);
			UIStates.primaryStage.show();
		}

		Controller controller = (Controller) fxmlLoader.getController();
		controller.init();
	}

	public static Controller addView(String viewPath) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		
		try {
			UIStates.root.getChildren()
					.add(fxmlLoader.load(UIStates.class.getResource("/view/" + viewPath).openStream()));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		Controller controller = (Controller) fxmlLoader.getController();
		controller.init();
		
		return controller;
	}
	
	public static void centerNode(Node node, double width, double height) {
		node.setLayoutX((UIStates.root.getWidth() / 2) - (width / 2));
		node.setLayoutY((UIStates.root.getHeight() / 2) - (height / 2));
	}
	
	public static void changeStyle(String stylePath)
	{
		root.getStylesheets().add("/view/css/" + stylePath);	
		
	}
	
	public static void resetStyle()
	{
		root.getStylesheets().clear();

		
	}
	
	public static void makeDraggable(Node node) {
		final Delta dragDelta = new Delta();

		node.setOnMousePressed(me -> {
			dragDelta.x = me.getX();
			dragDelta.y = me.getY();
		});

		node.setOnMouseDragged(me -> {
			node.setLayoutX(node.getLayoutX() + me.getX() - dragDelta.x);
			node.setLayoutY(node.getLayoutY() + me.getY() - dragDelta.y);
		});
	}

	private static class Delta {
		public double x;
		public double y;
	}
    
	
	public static WritableImage printScreen()
	{
		 WritableImage image = root.snapshot(new javafx.scene.SnapshotParameters(), null);
		 return image;
	}
   
	
	
	
	
}
