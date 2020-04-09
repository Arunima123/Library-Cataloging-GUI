package staff;


import java.net.URL;
import java.sql.SQLException;

//import javafx.scene.text.Text;
import java.util.ResourceBundle;

import constants.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
//import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;


public class StaffDetailsControl implements Initializable {
	
	   @FXML 
	   private Button myLogout; 
	   
	   @FXML
	   private Label myID;
	   
	   @FXML
	   private Label myStaffUsername;
	
	   @FXML
	   private Label myStaffEmail;
	   
	   @FXML
	   private Label myStaffDesig;
	
	   @FXML
	   private Label myStaffAddress;
	
	   @FXML
	   private Label myStaffMobile;
	
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
		   myID.setText(Constants.ID);
		   myStaffUsername.setText(Constants.name1);
		   myStaffEmail.setText(Constants.email1);
		   myStaffDesig.setText(Constants.desig);
		   myStaffAddress.setText(Constants.add);
		   myStaffMobile.setText(Constants.mob);
	      
	   }
	   
	   public void Logout(ActionEvent event) throws SQLException {
		
		         try {	   Parent root = FXMLLoader.load(getClass().getResource("/FrontPage/FrontPage.fxml"));/* Exception */
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
