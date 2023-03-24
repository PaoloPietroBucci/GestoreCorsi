package it.polito.tdp.corsi.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import it.polito.tdp.corsi.model.Corso;

public class TestDAO {

	public static void main(String[] args) {

		CorsoDAO dao = new CorsoDAO();
		
		Map <Corso,Integer> result = new HashMap<>();
		
		result = dao.getCorsiIscritti(2);
		
		System.out.println(result);
	}

}
