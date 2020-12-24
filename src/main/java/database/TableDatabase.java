package database;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Card_Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class TableDatabase extends Database {

	public void createTable(ObservableList<Card_Table> oblist) throws SQLException
	{
	
		String query = "select * from Card_Info,Category where idCard_Info= idCategory";
		pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		System.out.println("TEST 1");
		while (rs.next())
		{
			int type = rs.getInt("Type_idType");
			int rarity = rs.getInt("Rarity_idRarity");
		   	System.out.println("TEST 2");
			oblist.add(new Card_Table(rs.getString("idCard_Info"), rs.getString("name"), rs.getString("apt"), rs.getString("Category_Name"), selectType(type), selectRarity(rarity)));
			System.out.println("TEST 3");
			
			
		}
		System.out.println("TEST 4");
	}
	
	public String selectType(int x)
	{
		if(x==1)
		{
			return "AGL";
		}
		if(x==2)
		{
			return "TEQ";
		}
		if(x==3)
		{
			return "INT";
		}
		if(x==4)
		{
			return "STR";
		}
		if(x==5)
		{
			return "PHY";
		}
		else
		{
			return null;
		}
		
	}
	public String selectRarity(int x)
	{
		if(x==1)
		{
			return "SR";
		}
		if(x==2)
		{
			return "SSR";
		}
		if(x==3)
		{
			return "UR";
		}
		if(x==4)
		{
			return "LR";
		}
		else
		{
			return null;
		}
		
	}
	
	public InputStream changeData(Text Subname,String Id,InputStream input) throws SQLException
	{
		int idnumber =  Integer. parseInt(Id);
		System.out.println("TEST 1");
		String query = "select Sub_name from Card_Info where idCard_Info= ? ";
		pst = con.prepareStatement(query);
		pst.setInt (1, idnumber);
		ResultSet rs = pst.executeQuery();
		System.out.println("TEST 2");
		while(rs.next())
		{
			Subname.setText(rs.getString("Sub_Name"));
			System.out.println("TEST 3");
		}
		
		
		String query2 = "select Icon from Card_Info,Images where idImages = ? ";
		pst = con.prepareStatement(query2);
		pst.setInt (1, idnumber);

		ResultSet rs2 = pst.executeQuery();

		while(rs2.next())
		{
			System.out.println("TEST AAAAAAAAAAAA");
			 input = rs2.getBinaryStream("Icon");  
			 System.out.println("TEST AAAAAAAaAAAAA");
			
		}
		return input;
	
		
	}
	
	public void deleteData(String Id) throws SQLException
	{
		String disable = "SET FOREIGN_KEY_CHECKS=0";
		pst = con.prepareStatement(disable);
		pst.execute();
		
		
		int idnumber =  Integer. parseInt(Id);	
		String query = "delete  from Card_Info where idCard_Info= ? ";
		pst = con.prepareStatement(query);
		pst.setInt (1, idnumber);
		pst.execute();
		
		String query2 = "delete  from Images where idImages= ? ";
		pst = con.prepareStatement(query2);
		pst.setInt (1, idnumber);
		pst.execute();
		
		String query3 = "delete  from Category_has_Card_Info where Category_idCategory= ? ";
		pst = con.prepareStatement(query3);
		pst.setInt (1, idnumber);
		pst.execute();
		
		String query4 = "delete  from Category where idCategory= ? ";
		pst = con.prepareStatement(query4);
		pst.setInt (1, idnumber);
		pst.execute();
		
		String enable = "SET FOREIGN_KEY_CHECKS=1";
		pst = con.prepareStatement(enable);
		pst.execute();
		
		
		
		
		
		
	}
	
	public void updateData(String Id,String txt) throws SQLException
	{
		int idnumber =  Integer. parseInt(Id);	
		String query = "update Card_Info set Name = ? where idCard_Info = ?";
		pst = con.prepareStatement(query);
		pst.setString(1, txt);
		pst.setInt (2, idnumber);
		pst.executeUpdate();
		
		
		
	}
	
	public InputStream openArt (String Id,InputStream input) throws SQLException
	{
		int idnumber =  Integer. parseInt(Id);
		String query2 = "select Art from Card_Info,Images where idImages = ? ";
		pst = con.prepareStatement(query2);
		pst.setInt (1, idnumber);

		ResultSet rs2 = pst.executeQuery();

		while(rs2.next())
		{
			System.out.println("TEST AAAAAAAAAAAA");
			 input = rs2.getBinaryStream("Art");  
			 System.out.println("TEST AAAAAAAaAAAAA");
			
		}
		return input;
		
		
	}
	
	
	
}
