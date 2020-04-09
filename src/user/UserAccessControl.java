package user;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.layout.VBox;
 
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
 
public class UserAccessControl implements Initializable {
 
  @Override
   public void initialize(URL location, ResourceBundle resources) {
 
  }
   
  public void SignUp(ActionEvent event) {
   
		  
	try {	   Parent root = FXMLLoader.load(getClass().getResource("/user/UserSignUp.fxml"));/* Exception */
		   Scene scene = new Scene(root);
		   Stage stage = new Stage();
		   stage.setScene(scene);
		   stage.show();
   }  
		   catch(Exception e) {
		        e.printStackTrace();
		    }
      }
  
  public void SignIn(ActionEvent event) {
	   
	  
		try {	   Parent root = FXMLLoader.load(getClass().getResource("/user/UserSignIn.fxml"));/* Exception */
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