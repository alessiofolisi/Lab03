package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class Dictionary {

	private List<String> dictionaryList = new LinkedList<String>();
	
	public void loadDictionary(String dictionary) {
		try {
			
			FileReader fr = new FileReader(dictionary);
			
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while((word = br.readLine()) != null) {
				dictionaryList.add(word);
			}
			br.close();
		}catch(IOException e) {
			System.out.println("Errore nella lettura del file");		}
	}
	
	public List<String> getDictionary(){
		
		Collections.sort(dictionaryList);
		return dictionaryList;
	}
	
	
	
}
