package admin;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import javafx.scene.layout.VBox;
 
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
 
public class SuccessfulControl implements Initializable {
 
  @Override
   public void initialize(URL location, ResourceBundle resources) {
 
  }
   
  public void admin_func(ActionEvent event) {
   
		  
	try {	   Parent root = FXMLLoader.load(getClass().getResource("/admin/AdminFunc.fxml"));/* Exception */
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