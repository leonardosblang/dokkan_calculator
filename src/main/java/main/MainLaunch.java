package main;

import java.sql.SQLException;

import database.CardDAO;
import database.RarityDAO;
import database.TypeDAO;
import javafx.application.Application;

public class MainLaunch {
	
	public static void main(final String[] args) throws SQLException {

	/*	TypeDAO dao = new TypeDAO();
        dao.insertType();
		dao.closeConnection();
		RarityDAO dao2 = new RarityDAO();
		dao2.insertRarity();
		dao2.closeConnection(); */
		
		
		
        Application.launch(Runnable.class, args);
    }

}
