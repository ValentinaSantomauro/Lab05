package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class AnagrammiModel {
	
	List<String> ottima;
	AnagrammaDAO dao = new AnagrammaDAO();
	public List<String> elencoAnagrammi(String parola){
		this.ottima=new ArrayList <String> ();
		//PARZIALE: stringa ancora vuota che ogni volta aumenterà di una lettera
		String parziale ="";
	
		this.cercaAnagramma(0,parziale,parola,ottima);
		return ottima;
	}
	public boolean isCorrect(String parola) {
		return dao.isCorrect(parola);
	}
	
	private void cercaAnagramma(int livello,String parziale,String parola,List<String> ottima) {
		//-->CONDIZIONE DI TERMINAZIONE
		
		if(livello==parola.length()) {
			ottima.add(parziale);
		}
		
		//RICORSIONE -> per tutte le lettere di parola, le devo scambiare
		for(int i=0;i<parola.length();i++) {
			/*
			 * per ogni parola devo controllare quante lettere uguali ci sono --> le conto con charCounter
			 * se ho già inserito il numero tot di lettere uguali -> ho finito
			 * altrimenti il num di lettere uguali di parziale sarà minore rispetto a quello della parola data
			 * aggiungo la lettera in questione a parziale
			 * avvio la ricorsione
			 */
			if(this.charCounter(parziale, parola.charAt(i))< this.charCounter(parola, parola.charAt(i)));
			parziale+=parola.charAt(i);
			cercaAnagramma(livello+1,parziale,parola,ottima);
			parziale=parziale.substring(0, parziale.length()-1);
			
		
		}
		
		
		
	}
	
	private int charCounter(String string, char c) {
		int count=0;
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)==c)
				count++;
		}
		return count;
	}
	
	
	
}
