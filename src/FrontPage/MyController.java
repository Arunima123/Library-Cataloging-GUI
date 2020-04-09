package FrontPage;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.layout.VBox;
 
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
 
public class MyController implements Initializable {
 
  @Override
   public void initialize(URL location, ResourceBundle resources) {
 
	   
      
   }
 
   // When user click on myButton
   // this method will be called.
   public void adminLogin(ActionEvent event) {
   
		  // Node node=event.getSource();
		   //Stage stage=(Stage) (event.getSource()).getScene().getWindow();
	try {	   Parent root = FXMLLoader.load(getClass().getResource("/admin/AdminLogsIn.fxml"));/* Exception */
		   Scene scene = new Scene(root);
		   Stage stage = new Stage();
		   stage.setScene(scene);
		   stage.show();
   }  
		   catch(Exception e) {
		        e.printStackTrace();
		    }
      }
   
   public void userLogin(ActionEvent event) {
	   
		  // Node node=event.getSource();
		   //Stage stage=(Stage) (event.getSource()).getScene().getWindow();
	try {	   Parent root = FXMLLoader.load(getClass().getResource("/user/UserAccess.fxml"));/* Exception */
		   Scene scene = new Scene(root);
		   Stage stage = new Stage();
		   stage.setScene(scene);
		   stage.show();
}  
		   catch(Exception e) {
		        e.printStackTrace();
		    }
   }
   
   public void staffLogin(ActionEvent event) {
	   
		  // Node node=event.getSource();
		   //Stage stage=(Stage) (event.getSource()).getScene().getWindow();
	try {	   Parent root = FXMLLoader.load(getClass().getResource("/staff/StaffAccess.fxml"));/* Exception */
		   Scene scene = new Scene(root);
		   Stage stage = new Stage();
		   stage.setScene(scene);
		   stage.show();
}  
		   catch(Exception e) {
		        e.printStackTrace();
		    }
   }
   
   public void getFeedback(ActionEvent event) {
	   
		  // Node node=event.getSource();
		   //Stage stage=(Stage) (event.getSource()).getScene().getWindow();
	try {	   Parent root = FXMLLoader.load(getClass().getResource("/feedback/FeedbackIDGiven.fxml"));/* Exception */
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