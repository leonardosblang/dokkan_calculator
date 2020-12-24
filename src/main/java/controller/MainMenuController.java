package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import states.UIStates;

public class MainMenuController implements Controller {

	
	
    @FXML
    void showCardInfo(ActionEvent event) {
    	 System.out.println("DEBUGGING");
    	 UIStates.changeView("CharacterMenu.fxml");
    	     
    }
	
    
    @FXML
    void showDatabase(ActionEvent event) {
    	 System.out.println("DEBUGGING");
    	 UIStates.changeView("Database.fxml");
    }
	
	@Override
	public void init() {
		UIStates.changeStyle(UIStates.theme+".css");
		
		
	}
	
   

}
