package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import states.UIStates;
import database.Database;
import database.TableDatabase;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.javafx.geom.Rectangle;

import database.CardDAO;
import database.Database;
import entity.Card_Table;

public class DatabaseController implements Controller {

	@FXML
	private TableColumn<Card_Table, String> col_id;

	@FXML
	private TableColumn<Card_Table, String> col_apt;

	@FXML
	private TableColumn<Card_Table, String> col_team;

	@FXML
	private TableColumn<Card_Table, String> col_name;

	@FXML
	private TableColumn<Card_Table, String> col_rarity;

	@FXML
	private TableColumn<Card_Table, String> col_type;

	@FXML
	private TableView<Card_Table> table;

	@FXML
	private ImageView imageIcon;

	@FXML
	private TextField txtName;

	@FXML
	private Text lbSubName;
	
    @FXML
    private ImageView aptImage;
    
    @FXML
    private Pane pane;
    
    @FXML
    private ImageView bg2;
    
    @FXML
    private Button close;

    @FXML
    private ImageView bg1;

	@FXML
	void showMainMenu(ActionEvent event) {
		System.out.println("DEBUGGING");
		UIStates.changeView("MainMenu.fxml");
	}

	@FXML
	void loadData(ActionEvent event) throws SQLException {

		createTable();

	}

	@Override
	public void init() {
		UIStates.changeStyle(UIStates.theme + ".css");
		aptImage.setVisible(false);

	}

	public void createTable() throws SQLException {
		
		TableDatabase dao = new TableDatabase();
		col_apt.setCellValueFactory(new PropertyValueFactory<>("apt"));
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		col_team.setCellValueFactory(new PropertyValueFactory<>("Team"));
		col_rarity.setCellValueFactory(new PropertyValueFactory<>("Rarity"));
		col_type.setCellValueFactory(new PropertyValueFactory<>("Type"));

		ObservableList<Card_Table> oblist = FXCollections.observableArrayList();
		dao.createTable(oblist);
		table.setItems(oblist);
		dao.closeConnection();

	}
	
	public void changeText(String txt)
	{
		  if(txt=="AGL")
		  {
			lbSubName.setFill(Color.BLUE);
		  }
		  if(txt=="TEQ")
		  {
			  lbSubName.setFill(Color.GREEN);
		  }
		  if(txt=="INT")
		  {
			  lbSubName.setFill(Color.PURPLE); 
		  }
		  if(txt=="STR")
		  {
			  lbSubName.setFill(Color.RED);
		  }
		  if(txt=="PHY")
		  {
			  lbSubName.setFill(Color.YELLOW);
		  }	
		
		
		
	}

	public void fixPosition(String txt)
	{
		
		if(txt.length()>20)
		{
			  lbSubName.setX(-5);
		}
	
		if(txt.length()>25)
		{
			  lbSubName.setX(-45);
		}
		else {
			lbSubName.setX(0);
			
		}
	}

	@FXML
	public void clickItem(MouseEvent event) throws SQLException {

		TableDatabase dao = new TableDatabase();
		System.out.println(table.getSelectionModel().getSelectedItem().getId());
		String id = (table.getSelectionModel().getSelectedItem().getId());
		InputStream in = null;
		in = dao.changeData(lbSubName, id, in);
		Image im = new Image(in);
		imageIcon.setImage(im);
		dao.closeConnection();
		String typeName = (table.getSelectionModel().getSelectedItem().getType());
		changeText(typeName);
		String Pos = lbSubName.getText();
		fixPosition(Pos);

	}

	@FXML
	void removeDatabase(ActionEvent event) throws SQLException {

		TableDatabase dao = new TableDatabase();
		System.out.println(table.getSelectionModel().getSelectedItem().getId());
		String id = (table.getSelectionModel().getSelectedItem().getId());
		dao.deleteData(id);
		createTable();
		dao.closeConnection();

	}

	@FXML
	void updateData(ActionEvent event) throws SQLException {

		TableDatabase dao = new TableDatabase();
		System.out.println(table.getSelectionModel().getSelectedItem().getId());
		String id = (table.getSelectionModel().getSelectedItem().getId());
		String newName = txtName.getText();
		dao.updateData(id, newName);
		createTable();
		dao.closeConnection();

	}
	
    @FXML
    void openImage(ActionEvent event) throws SQLException {
    	TableDatabase dao = new TableDatabase();
		System.out.println(table.getSelectionModel().getSelectedItem().getId());
		String id = (table.getSelectionModel().getSelectedItem().getId());
		InputStream in = null;
		in = dao.openArt(id, in);
		Image im = new Image(in);
		aptImage.setVisible(true);
	    bg1.setVisible(true);
	    bg2.setVisible(true);
	    close.setVisible(true);
		aptImage.setImage(im);
		dao.closeConnection();
    }


    @FXML
    void closeButton(ActionEvent event) {
    	aptImage.setVisible(false);
	    bg1.setVisible(false);
	    bg2.setVisible(false);
	    close.setVisible(false);
    }
}
