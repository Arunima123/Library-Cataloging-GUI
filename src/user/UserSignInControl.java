package user;
import application.DBconnect;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
 
public class UserSignInControl implements Initializable {
 
   
   @FXML
   private TextField user_name;
   
   @FXML
   public TextField user_id;
   
   @FXML 
   private Button myUserLogin;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   
   public void UserLogin(ActionEvent event) throws SQLException {
   
	      Window owner = myUserLogin.getScene().getWindow();
	   	  
	      		  if (user_name.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter your username");
	            return;
	        }
	        if (user_id.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter your ID");
	            return;
	        }
	        
	        String username= user_name.getText().toString();
			String id= user_id.getText().toString();
			  

			DBconnect DBconnect = new DBconnect();
	        boolean flag = DBconnect.validateUser(username, id);
	        if (!flag) {
	            infoBox("Please enter correct Username and ID", null, "Failed");
	        } else {
	           infoBox("Login Successful!", null, "Passed");
	            
	           try {	  
	            
	           DBconnect.fill_User_detail(username,id);
	           DBconnect.fill_User_detail2(id);
	           
	           Parent root = FXMLLoader.load(getClass().getResource("/user/UserDetails.fxml"));
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
  
