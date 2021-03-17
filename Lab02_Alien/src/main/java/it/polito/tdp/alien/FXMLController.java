package it.polito.tdp.alien;

import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	AlienDictionary dictionary=new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	this.dictionary.clearDictionary();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String inserito1=txtParola.getText();
    	
    		String inserito=inserito1.toLowerCase();
	    	String campi[]=inserito.split(" ");
	    	if(campi.length==2)
	    	{
	    		if(campi[0].matches(".*\\d.*")==false && (campi[0].matches(".*\\W.*")==false) && campi[1].matches(".*\\d.*")==false && (campi[1].matches(".*\\W.*")==false))
	    		{
	    			this.dictionary.addWord(campi[0], campi[1]);
	    			txtParola.clear();
	    			return;
	    		}
	    		else
	        	{
	        		
	        		txtResult.setText("ERRORE FORMATO TESTO");
	        		return;
	        	}
	    	}
	    	else if(campi.length==1)
	    	{
	    		if(campi[0].matches(".*\\d.*")==false && (campi[0].matches(".*\\W.*")==false))
		    	{	List <String> stampa=this.dictionary.translateWord(campi[0]);
		    		String daStampare="";
		    		for(String s:stampa)
		    		{
		    			daStampare+=s+"\n";
		    			
		    		}
		    		txtResult.setText(daStampare);
		    		txtParola.clear();
		    		return;
		    	}
	    		else
	        	{
	        		
	        		txtResult.setText("ERRORE FORMATO TESTO");
	        		return;
	        		
	        	}
	    	}
    	}
    	
    
    

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
