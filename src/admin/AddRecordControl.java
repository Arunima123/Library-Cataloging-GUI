package admin;
import application.DBconnect;

//import java.util.regex.Matcher; 
//import java.util.regex.Pattern; 
  
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
//import javafx.scene.control.TextInputControl;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
 
public class AddRecordControl implements Initializable {
 
   
   @FXML
   private TextField article_title;
   
   @FXML
   public TextField article_id;
   
   @FXML
   public TextField journal_id;
   
   @FXML
   public TextField journal_title;
   
   @FXML
   public TextField author_name;
   
   @FXML
   public TextField author_id;
   
   @FXML
   public TextField institution_id;
   
   @FXML 
   private Button add_record;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   
   public void AddRecord(ActionEvent event) throws SQLException {
   
	      Window owner = add_record.getScene().getWindow();
	   	  
	      	 if (article_id.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the Article ID");
	            return;
	           }
	        if (article_title.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the Article title");
	            return;
	        }
	        if (journal_id.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the Journal ID");
	            return;
	           }
	        if (journal_title.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the Journal title");
	            return;
	           }
	        if (author_id.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the Author ID");
	            return;
	           }
	        if (author_name.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the Author name");
	            return;
	           }
	        if (institution_id.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the Institution ID");
	            return;
	           }
	    
	        
	        String title1= article_title.getText().toString();
			String id1= article_id.getText().toString();
			String id2= journal_id.getText().toString();
			String title2= journal_title.getText().toString();
			String id3= author_id.getText().toString();
			String name= author_name.getText().toString();
			String id4= institution_id.getText().toString();		
			
			DBconnect DBconnect = new DBconnect();
	      	try {	  
	            
	      		DBconnect.RecInDB4(id4);
	      		DBconnect.RecInDB3(name,id3,id4);
	      		DBconnect.RecInDB2(title2,id2);    
	      		DBconnect.RecInDB1(title1,id1,id2,id3);
	          
	           
	           
	           Parent root = FXMLLoader.load(getClass().getResource("/admin/AddSuccessful.fxml"));
	           Scene scene = new Scene(root);
	 		   Stage stage = new Stage();
	 		   stage.setScene(scene);
	 		   stage.show();
           	
	        }  
	 		   catch(Exception e) {
	 		        e.printStackTrace();
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
  
