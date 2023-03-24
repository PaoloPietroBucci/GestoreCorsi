package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {

	public List<Corso> getCorsiByPeriodo(int periodo){
		
		String sql = "SELECT * "
				+ "FROM corso "
				+ "WHERE pd = ? ";
		List<Corso> result = new ArrayList<>();
		
		try {
			Connection conn =ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				result.add(c);
			}
			rs.close();
			st.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			System.out.print("Errore statement");
			e.printStackTrace();
			return null;
		}
	}
	
	public Map<Corso,Integer> getCorsiIscritti(int periodo){
		
		String sql = "SELECT c.codins, c.crediti, c.nome, c.pd, COUNT(*) AS n "
				+ "FROM corso c , iscrizione i "
				+ "WHERE c.pd=? AND  c.codins = i.codins "
				+ "GROUP BY c.codins,c.crediti,c.nome,c.pd";
		Map<Corso, Integer> result = new HashMap<>();
		
		try {
			Connection conn =ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				result.put(c,rs.getInt("n"));
			}
			rs.close();
			st.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			System.out.print("Errore statement");
			e.printStackTrace();
			return null;
		}
	}
	
	
}
