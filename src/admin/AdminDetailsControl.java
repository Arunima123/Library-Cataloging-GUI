package admin;


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


public class AdminDetailsControl implements Initializable {
	
	   @FXML 
	   private Button myLogout; 
	   
	   @FXML
	   private Label myID;
	   
	   @FXML
	   private Label myAdminUsername;
	
	   @FXML
	   private Label myAdminPassword;
	
	
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
		   myID.setText(Constants.ID);
		  // System.out.println(myAdminPassword);
		   myAdminUsername.setText(Constants.name1);
		   myAdminPassword.setText(Constants.password);
	      
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
