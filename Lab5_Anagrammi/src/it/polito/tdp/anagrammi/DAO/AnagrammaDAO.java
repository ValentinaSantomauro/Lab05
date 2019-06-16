package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		String sql = "SELECT p.name FROM parola as p WHERE p.name=? ";
		
		String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=Admaiorasemper8" ;
		
		try {
		Connection conn = DriverManager.getConnection(jdbcURL);
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, anagramma);
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			conn.close();
			return true;
		}else {
			conn.close();
			return false;
		}


	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Errore connessione al database");
		throw new RuntimeException("Error Connection Database");
	}
		
	
	}
}
