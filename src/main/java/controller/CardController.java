package controller;

import database.Database;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import java.util.Locale;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import states.UIStates;

public class CardController implements Controller {

	@FXML
	private TextField cardSubName;

	@FXML
	private TextField cardName;

	@FXML
	private TextField cardTeam;
	

    @FXML
    private AnchorPane pane;
    
    @FXML
    private ImageView imageIcon;
    

    @FXML
    private ImageView imageArt;
    
    @FXML
    private ImageView typeImage;
    
    @FXML
    private ImageView rarityImage;
    


	@FXML
    private ComboBox<String> type;
    ObservableList<String> list = FXCollections.observableArrayList("AGL","TEQ","INT","STR","PHY");
    
    @FXML
    private ComboBox<String> rarity;
    ObservableList<String> list2 = FXCollections.observableArrayList("SR","SSR","UR","LR");
    
	@FXML
	void showCalculation(ActionEvent event) {
		System.out.println("DEBUGGING");
		UIStates.changeView("Overview.fxml");
	}
	
    @FXML
    void selectType(ActionEvent event) {
    String cardType = type.getSelectionModel().getSelectedItem().toString();
    imageSelection(cardType,typeImage);
    
    }

    @FXML
    void selectRarity(ActionEvent event) {
    	 String cardRarity = rarity.getSelectionModel().getSelectedItem().toString();
    	 imageSelection(cardRarity,rarityImage);
    }
	

    @FXML
    void loadIcon(ActionEvent event) {
     FileChooser filechooser = new FileChooser();
     filechooser.setTitle("Open Icon");
     Stage stage = (Stage)pane.getScene().getWindow();
     File file =  filechooser.showOpenDialog(stage);
     Image image = new Image(file.toURI().toString());
     imageIcon.setImage(image);   
     UIStates.icon = image;
     UIStates.iconFile = file;
    }
    @FXML
    void loadArt(ActionEvent event) {
    	   FileChooser filechooser = new FileChooser();
    	     filechooser.setTitle("Open Icon");
    	     Stage stage = (Stage)pane.getScene().getWindow();
    	     File file =  filechooser.showOpenDialog(stage);
    	     Image image = new Image(file.toURI().toString());
    	     imageArt.setImage(image);   
       	     UIStates.artPreview = image;
       	     UIStates.artFile = file;
       	     
    }

	@Override
	public void init() {
		type.setItems(list);
		rarity.setItems(list2);
		type.getSelectionModel().selectFirst();
		rarity.getSelectionModel().selectFirst();
		if(UIStates.theme!= null)
		{
			 UIStates.changeStyle(UIStates.theme+".css");
		}
       
		

	}
	
    @FXML
    void buttonSettings(ActionEvent event) {
    	if(UIStates.settings==0)
    	{
    		System.out.println("DEBUGGING");
    		UIStates.addView("Settings.fxml");	
    		UIStates.settings=1;
    	}	
		
    }
    

    @FXML
    void showCardInfo(ActionEvent event) {
		System.out.println("DEBUGGING");
		UIStates.changeView("CardInfo.fxml");
    }
    
    @FXML
    void saveInfo(ActionEvent event) {
    	UIStates.name = cardName.getText();
    	UIStates.subname = cardSubName.getText();
    	UIStates.Team = cardTeam.getText();
    	UIStates.cardtype = type.getSelectionModel().getSelectedItem().toString();
    	UIStates.cardrarity = rarity.getSelectionModel().getSelectedItem().toString();
    }
	
    @FXML
    void showMainMenu(ActionEvent event) {
    	System.out.println("DEBUGGING");
		UIStates.changeView("MainMenu.fxml");
    }
	
	void imageSelection(String t,ImageView i) {
		Image image;
		switch(t) {
		  case "AGL":
		   image = new Image("/icons/type/AGL_icon.png");
		   i.setImage(image);
		    break;
		  case "TEQ":
			   image = new Image("/icons/type/TEQ_icon.png");
			   i.setImage(image);
		    break;
		  case "INT":
			   image = new Image("/icons/type/INT_icon.png");
			   i.setImage(image);
			    break;
		  case "STR":
			   image = new Image("/icons/type/STR_icon.png");
			   i.setImage(image);
			    break;
		  case "PHY":
			   image = new Image("/icons/type/PHY_icon.png");
			   i.setImage(image);
			    break;
		  case "SR":
			   image = new Image("/icons/rarity/sr.png");
			   i.setImage(image);
			    break;
		  case "SSR":
			   image = new Image("/icons/rarity/ssr.png");
			   i.setImage(image);
			    break;
		  case "UR":
			   image = new Image("/icons/rarity/ur.png");
			   i.setImage(image);
			    break;
		  case "LR":
			   image = new Image("/icons/rarity/lr.png");
			   i.setImage(image);
			    break;
		  default:
		 
		}
		
	}

}
