package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	Dictionary dictionary;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clearText;

    @FXML
    private TextArea insertText;

    @FXML
    private ChoiceBox<String> language;

    @FXML
    private Label numeroErrate;

    @FXML
    private Button spellcheck;

    @FXML
    private Label tempoImpiegato;

    @FXML
    private TextArea wrongText;

    @FXML
    void onCheck(ActionEvent event) {
    	
    	 	String testoInserito =	insertText.getText();
    	 	testoInserito = testoInserito.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	 	
    	    String parole[] = testoInserito.split(" ");
    	    String paroleErrate="";
    	    int counter = 0;
    	    
    	    if(language.getValue().compareTo("Italiano")==0){
    	    	dictionary.loadDictionary("src/main/resources/Italian.txt");
    	    }else if(language.getValue().compareTo("English")==0){
    	    	dictionary.loadDictionary("src/main/resources/English.txt");
    	    }
    	    
    	    for(int i=0;i<parole.length;i++) {
    	    	if(!dictionary.getDictionary().contains(parole[i])) {
    	    		counter++;
    	    		paroleErrate += parole[i] + "\n";
    	    	}
    	    }
    	    
    	    wrongText.setText(paroleErrate);
    	    if(counter>1) {
    	    numeroErrate.setText("The text contains " + counter + " errors" );
    	    }else numeroErrate.setText("The text contains " + counter + " error" );
    	    
    	    tempoImpiegato.setText("Spell Check completed in " + System.nanoTime() + " ns");


    }

    @FXML
    void onClear(ActionEvent event) {
    	insertText.clear();
    	wrongText.clear();
    }

    
    void setModel(Dictionary dictionary) {
    	this.dictionary = dictionary;
    }
    
    @FXML
    void initialize() {
        assert clearText != null : "fx:id=\"clearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert insertText != null : "fx:id=\"insertText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'Scene.fxml'.";
        assert numeroErrate != null : "fx:id=\"numeroErrate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert spellcheck != null : "fx:id=\"spellcheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert tempoImpiegato != null : "fx:id=\"tempoImpiegato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert wrongText != null : "fx:id=\"wrongText\" was not injected: check your FXML file 'Scene.fxml'.";
        
        language.getItems().clear();
        language.getItems().add("Italiano");
        language.getItems().add("English");
        

    }

}
