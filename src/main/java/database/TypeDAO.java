package database;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TypeDAO extends Database {


	
	public void insertType() throws SQLException {
		String query = "SELECT idType FROM Type WHERE Type = ?";
		pst = con.prepareStatement(query);
		pst.setString (1, "AGL");
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {

		} else {
			String query2 = "INSERT INTO `Type`(idType,Type) VALUES (?,?)";
			pst = con.prepareStatement(query2);

			pst.setInt(1, 1);
			pst.setString(2, "AGL");
			pst.execute();
			
			query = "INSERT INTO `Type`(idType,Type) VALUES (?,?)";
			pst = con.prepareStatement(query);

			pst.setInt(1, 2);
			pst.setString(2, "TEQ");
			pst.execute();
			
			 query = "INSERT INTO `Type`(idType,Type) VALUES (?,?)";
			pst = con.prepareStatement(query);

			pst.setInt(1, 3);
			pst.setString(2, "INT");
			pst.execute();
			
			query = "INSERT INTO `Type`(idType,Type) VALUES (?,?)";
			pst = con.prepareStatement(query);

			pst.setInt(1, 4);
			pst.setString(2, "STR");
			pst.execute();
			
			 query = "INSERT INTO `Type`(idType,Type) VALUES (?,?)";
			pst = con.prepareStatement(query);

			pst.setInt(1, 5);
			pst.setString(2, "PHY");
			pst.execute();
		}
		
		
		
		
	
		
	}
	
}
