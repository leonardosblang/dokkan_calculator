package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RarityDAO extends Database {

	public void insertRarity() throws SQLException {
		String query = "SELECT idRarity FROM Rarity WHERE Rarity = ?";
		pst = con.prepareStatement(query);
		pst.setString (1, "SR");
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
	
		} else {
			String query2 = "INSERT INTO `Rarity`(idRarity,Rarity) VALUES (?,?)";
			pst = con.prepareStatement(query2);

			pst.setInt(1, 1);
			pst.setString(2, "SR");
			pst.execute();
			
			query = "INSERT INTO `Rarity`(idRarity,Rarity) VALUES (?,?)";
			pst = con.prepareStatement(query);

			pst.setInt(1, 2);
			pst.setString(2, "SSR");
			pst.execute();
			
			query = "INSERT INTO `Rarity`(idRarity,Rarity) VALUES (?,?)";
			pst = con.prepareStatement(query);

			pst.setInt(1, 3);
			pst.setString(2, "UR");
			pst.execute();
			
			query = "INSERT INTO `Rarity`(idRarity,Rarity) VALUES (?,?)";
			pst = con.prepareStatement(query);

			pst.setInt(1, 4);
			pst.setString(2, "LR");
			pst.execute();
		}
	}
	
}
