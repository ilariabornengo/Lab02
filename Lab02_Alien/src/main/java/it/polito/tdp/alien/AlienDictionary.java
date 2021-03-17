package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	String alienWord;
	String translation;
	List<String> traduzioni;
	Map<String,List<String>> dizionario;
	
	public AlienDictionary() {
	
		dizionario = new TreeMap<String,List<String>>();
	}
	
	public void addWord(String alienW, String translationW)
	{
		traduzioni=new LinkedList<String>();
		
		if(dizionario.containsKey(alienW))
		{
			traduzioni=dizionario.get(alienW);
			traduzioni.add(translationW);
			dizionario.put(alienW, traduzioni);
		}
		else
		{
			traduzioni.add(translationW);
			dizionario.put(alienW, traduzioni);
			
		}
	}
	
	public List<String> translateWord(String alienW)
	{
		traduzioni=dizionario.get(alienW);
		return traduzioni;
	}
	
	public void clearDictionary()
	{
		this.dizionario.clear();
		
	}
	
	
	

}
