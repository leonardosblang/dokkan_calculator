package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import states.UIStates;



public class SettingsController implements Controller {
	

    @FXML
    private AnchorPane pane1;
    
    @FXML
    private Button closeButton;


	
	@FXML
    private ComboBox<String> themeBox;
	 ObservableList<String> list = FXCollections.observableArrayList("Default","Theme1","Theme2","Theme3","Theme4","Theme5");
	 
	    @FXML
	    void selectTheme(ActionEvent event) {
	    	UIStates.resetStyle();
	    	 String newTheme = themeBox.getSelectionModel().getSelectedItem().toString();
	    	 UIStates.changeStyle(newTheme+".css");
	    	 UIStates.theme= newTheme;
	    }

	    @FXML
	    void closeButtonAction(ActionEvent event) {
	    	UIStates.settings=0;
	    	UIStates.root.getChildren().remove(pane1);
	    }

    
 
	@Override
	public void init() {
		themeBox.setItems(list);
		if( UIStates.theme==null)
		{
			themeBox.getSelectionModel().selectFirst();
		}
		else {
		themeBox.setValue(UIStates.theme);	
			
		}
		System.out.println(pane1);
		UIStates.makeDraggable(pane1);
	 	UIStates.centerNode(pane1, 391, 420);
	
		
	}

}
