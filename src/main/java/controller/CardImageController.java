package controller;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import states.UIStates;
import database.CardDAO;
import entity.Card;

public class CardImageController implements Controller {

	@FXML
	private Text txtSupport;

	@FXML
	private Text txtName;

	@FXML
	private Text txtAPT;

	@FXML
	private Text txtTeam;

	@FXML
	private Text txtLinks;
	@FXML
	private ImageView artPreview;
	
    @FXML
    private Text txtCrit;

    @FXML
    private Text txtAdd;
    
    @FXML
    private ImageView imagePreview;
    

    @FXML
    private Button backButton;
    
    @FXML
    private Button dbButton;


	@FXML
	void showCardInfo(ActionEvent event) {
		System.out.println("DEBUGGING");
		UIStates.changeView("CharacterMenu.fxml");
	}
	
	void fixPosition(Text text)
	{
		if(UIStates.name.length()>5)
		{
			text.setX(-50);
		}
	
		if(UIStates.name.length()>9)
		{
			text.setX(-100);
		}
	
	}
	
	void changeColor(Text text)
	{
	  if(UIStates.cardtype=="AGL")
	  {
		  text.setFill(Color.BLUE);
	  }
	  if(UIStates.cardtype=="TEQ")
	  {
		  text.setFill(Color.GREEN);
	  }
	  if(UIStates.cardtype=="INT")
	  {
		  text.setFill(Color.PURPLE); 
	  }
	  if(UIStates.cardtype=="STR")
	  {
		  text.setFill(Color.RED);
	  }
	  if(UIStates.cardtype=="PHY")
	  {
		  text.setFill(Color.YELLOW);
	  }
		
	}

    int getTypeID(String typename)
    {
    	int typeid = 0;
    	if(typename=="AGL")
    	{
    		typeid=1;
    	}
    	if(typename=="TEQ")
    	{
    		typeid=2;
    	}
    	if(typename=="INT")
    	{
    		typeid=3;
    	}
    	if(typename=="STR")
    	{
    		typeid=4;
    	}
    	if(typename=="PHY")
    	{
    		typeid=5;
    	}
    	
		return typeid;
    	
    }
    int getRarityID(String rarityname)
    {
    	int rarityid = 0;
    	if(rarityname=="SR")
    	{
    		rarityid=1;
    	}
    	if(rarityname=="SSR")
    	{
    		rarityid=2;
    	}
    	if(rarityname=="UR")
    	{
    		rarityid=3;
    	}
    	if(rarityname=="LR")
    	{
    		rarityid=4;
    	}
    	
		return rarityid;
    	
    }
    
    
	
	 @FXML
	    void saveToDatabase(ActionEvent event) throws SQLException, IOException {
	
		    
		 
		    int typeid = getTypeID(UIStates.cardtype);
		    int rarityid = getRarityID(UIStates.cardrarity);
		  
		    
		    dbButton.setVisible(false);
		    backButton.setVisible(false);
		    WritableImage image = UIStates.printScreen();
	        imagePreview.setImage(image);
	        dbButton.setVisible(true);
		    backButton.setVisible(true);
		    
		    File file = new File("data.png");
		    
		    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		    
		    UIStates.artFile = file;
		    
		    
		 
		 	Card card = new Card(UIStates.name,UIStates.subname,UIStates.Team,UIStates.iconFile,UIStates.artFile,UIStates.apt,typeid,rarityid);
			CardDAO dao = new CardDAO();
	        dao.insertCardData(card);   
			dao.closeConnection();
			
		
			
			;
	    }

	@Override
	public void init() {
		artPreview.setImage(UIStates.artPreview);
		UIStates.changeStyle(UIStates.theme + ".css");
		txtName.setText(UIStates.name);
	    txtSupport.setText(String.valueOf((float) UIStates.support+"% Support"));   
	    txtLinks.setText(String.valueOf((float) UIStates.links)+"% Links");
	    txtTeam.setText(UIStates.Team+" - "+UIStates.leader+"%");
	    txtAPT.setText("APT: "+ NumberFormat.getNumberInstance(Locale.US).format((int) UIStates.apt));
	    txtCrit.setText(""+UIStates.crit);
	    txtAdd.setText(""+UIStates.add);
		fixPosition(txtName);
        changeColor(txtName);
   

	}

}
