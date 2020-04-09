package feedback;
import application.*;

import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;
//import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;

public class FeedbackIDGivenControl implements Initializable {
	
	   @FXML
	   private TextField myIDFeedback;
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
	      
	   }
	   
	   public void TakeFeedback(ActionEvent event) throws SQLException {
			
	         
	   Window owner = myIDFeedback.getScene().getWindow();
	   	  
		  if (myIDFeedback.getText().isEmpty()) {
			  showAlert(Alert.AlertType.ERROR, owner, "Form Error!","Please enter your ID");
			  return;
		  }
 
 
		  String ID= myIDFeedback.getText().toString();
	
	  
		  DBconnect DBconnect = new DBconnect();
		  boolean flag = DBconnect.validateFB(ID);
		  if (!flag) {
			  infoBox("Please enter correct ID", null, "Failed");
		  } else {
			  infoBox("Access Successful!", null, "Passed");
     
			  try {	  
     
				  Parent root = FXMLLoader.load(getClass().getResource("/feedback/FeedbackTaken.fxml"));
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
 

public static void infoBox(String infoMessage, String headerText, String title) {
 Alert alert = new Alert(AlertType.CONFIRMATION);
 alert.setContentText(infoMessage);
 alert.setTitle(title);
 alert.setHeaderText(headerText);
 alert.showAndWait();
}

private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
 Alert alert = new Alert(alertType);
 alert.setTitle(title);
 alert.setHeaderText(null);
 alert.setContentText(message);
 alert.initOwner(owner);
 alert.show();
}
}
	   
	  
		   
		   
		   
 
	   
	   
	   