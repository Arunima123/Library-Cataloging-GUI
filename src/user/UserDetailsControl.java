package user;


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


public class UserDetailsControl implements Initializable {
	
	   @FXML 
	   private Button myLogout; 
	   
	   @FXML
	   private Label myID;
	   
	   @FXML
	   private Label myUserUsername;
	
	   @FXML
	   private Label myUserEmail;
	   
	   @FXML
	   private Label myUserAddress;
	
	   @FXML
	   private Label myUserMobile;
	
	   
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
		   myID.setText(Constants.ID);
		   myUserUsername.setText(Constants.name1);
		   myUserEmail.setText(Constants.email1);
		   myUserAddress.setText(Constants.add);
		   myUserMobile.setText(Constants.mob);
	      
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
	   
	   public void AccessLib(ActionEvent event) throws SQLException {
			
	         try {	   Parent root = FXMLLoader.load(getClass().getResource("/user/LibFunc.fxml"));/* Exception */
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
