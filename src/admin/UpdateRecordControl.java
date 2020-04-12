package admin;


import java.net.URL;
import java.sql.SQLException;

//import javafx.scene.text.Text;
import java.util.ResourceBundle;

import application.DBconnect;
//import constants.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
//import javafx.event.Event;
import javafx.scene.control.TextField;
//import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;
//import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;


public class UpdateRecordControl implements Initializable {
	
	   
	   @FXML
	   private TextField myId;
	   
	   @FXML
	   private TextField myfield;
	
	   @FXML
	   private TextField myValue;
	   
	   @FXML
	   private Button myUpdate;
	   
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
	      
	   }
	   
	   
	   public void update(ActionEvent event) throws SQLException {
		
		   Window owner = myUpdate.getScene().getWindow();
		   	  
	        if (myId.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter Article ID");
	            return;
	        }
	        
	        if (myfield.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the Field");
	            return;
	        }
	  
	        if (myValue.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the new value");
	            return;
	        }
	  
	  
			String id= myId.getText().toString();
			String field= myfield.getText().toString();
			String val= myValue.getText().toString();
			  
			  
			DBconnect DBconnect = new DBconnect();
	        boolean flag = DBconnect.validateRec(id);
	        if (!flag) {
	            infoBox("Please enter the correct ID", null, "Failed");
	        } else {
	           try {	  
	            
	           DBconnect.UpdateRecord(id,field,val);
	           
	               Parent root = FXMLLoader.load(getClass().getResource("/admin/UpdateSuccessful.fxml"));/* Exception */
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
