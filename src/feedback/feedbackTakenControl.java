package feedback;
//import application.*;

import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;

import application.DBconnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Label;
import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
//import javafx.stage.Window;
//import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;

public class feedbackTakenControl implements Initializable {
	
	   @FXML
	   private TextArea mytext;
	   
	   @FXML
	   private TextField mytitle;
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
		   }
	   
	   @FXML
	   public void FBsubmit(ActionEvent event) throws SQLException {
		  
		   DBconnect DBconnect = new DBconnect();
		   
		   //System.out.println(mytext.getText().toString());
		 
		  DBconnect.FBinDB(mytext.getText().toString(), mytitle.getText().toString());
		   
		    try {	  
			     
				  Parent root = FXMLLoader.load(getClass().getResource("/feedback/FeedbackThanks.fxml"));
				  Scene scene = new Scene(root);
				  Stage stage = new Stage();
				  stage.setScene(scene);
				  stage.show();
			  }  
		catch(Exception e) {
	        e.printStackTrace();
	    }
	   
		   
	   }
}