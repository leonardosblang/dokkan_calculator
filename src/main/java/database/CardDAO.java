package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import entity.Card;
import javafx.scene.image.Image;

public class CardDAO extends Database {

	public void insertCardData(Card card) throws SQLException, FileNotFoundException {

		System.out.print("Debug 00  ");

		int imageId = insertImageData(card);

		System.out.print("Debug 01 - Value of image id: " + imageId);

		String query = "INSERT INTO `Card_Info`(Name,Sub_name,Type_idType,Rarity_idRarity,APT,Images_idImages) VALUES (?,?,?,?,?,?)";

		System.out.print("Debug 02 -- INSERT STEP ");

		pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

		pst.setString(1, card.getName());
		pst.setString(2, card.getSubname());
		pst.setInt(3, card.getTypeId());
		pst.setInt(4, card.getRarityId());
		pst.setInt(5, card.getApt());
		pst.setInt(6, imageId);

		System.out.print("Debug 03 -- SET STEP ");

		pst.execute();
	
		
		String query4 =  "INSERT INTO `Category`(idCategory,Category_Name) VALUES (?,?)";
		pst = con.prepareStatement(query4);

		pst.setInt(1, imageId);
		pst.setString(2, card.getTeam());
		pst.execute();
		
		String query5 =  "INSERT INTO `Category_has_Card_Info`(Category_idCategory,Card_Info_idCard_Info) VALUES (?,?)";
		pst = con.prepareStatement(query5);

		pst.setInt(1, imageId);
		pst.setInt(2, imageId);
	    pst.execute(); 	


	}

	public int insertImageData(Card card) throws SQLException, FileNotFoundException {
		String query2 = "INSERT INTO `Images`(Icon,Art) VALUES (?,?)";
		pst = con.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);

		FileInputStream icon = new FileInputStream(card.getIcon());
		FileInputStream imagePreview = new FileInputStream(card.getArtPreview());
		pst.setBinaryStream(1, icon);
		pst.setBinaryStream(2, imagePreview);

		pst.execute();

		System.out.print("Debugging 01 - AFTER EXECUTE  ");

		String query3 = "select idImages from Images";

		System.out.print("Debugging 02 - AFTER SELECT  ");

		ResultSet rs = pst.executeQuery(query3);

		System.out.print("Debugging 03 - AFTER RESULT SET  ");
		
		int imageID = 0;

		while (rs.next()) {

			 imageID = rs.getInt("idImages");

			System.out.print("Debugging 04 - AFTER int IMAGE  " + imageID);

		}
		return imageID;
	}



}
