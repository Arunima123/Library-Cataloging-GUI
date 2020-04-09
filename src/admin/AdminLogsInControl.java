package admin;
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
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
 
public class AdminLogsInControl implements Initializable {
 
   
   @FXML
   private TextField admin_name;
   
   @FXML
   public PasswordField admin_password;
   
   @FXML 
   private Button myAdminLogin;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   
   public void admin(ActionEvent event) throws SQLException {
   
	      Window owner = myAdminLogin.getScene().getWindow();
	   	  
	      		  if (admin_name.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter your username");
	            return;
	        }
	        if (admin_password.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the password");
	            return;
	        }
	        
	        String username= admin_name.getText().toString();
			String password= admin_password.getText().toString();
		
			DBconnect DBconnect = new DBconnect();
	        boolean flag = DBconnect.validate(username, password);
	      //  System.out.println(flag);
	        if (!flag) {
	            infoBox("Please enter correct Email and Password", null, "Failed");
	        } else {
	           infoBox("Login Successful!", null, "Passed");
	            
	           try {	  
	            
	           DBconnect.fill_admin_detail(username,password);
	           
	          Parent root = FXMLLoader.load(getClass().getResource("/admin/AdminDetails.fxml"));
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
  
