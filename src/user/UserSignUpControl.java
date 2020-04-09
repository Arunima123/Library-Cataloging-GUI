package user;
import application.DBconnect;

import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
  
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
 
public class UserSignUpControl implements Initializable {
 
   
   @FXML
   private TextField user_name;
   
   @FXML
   public TextField user_id;
   
   @FXML
   public TextField user_id_again;
   
   @FXML
   public TextField user_email;
   
   @FXML
   public TextField user_address;
   
   @FXML
   public TextField user_mobile;
   
   @FXML 
   private Button mySignUp;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   
   public void SignUp(ActionEvent event) throws SQLException {
   
	      Window owner = mySignUp.getScene().getWindow();
	   	  
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
	        if (user_id_again.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter the ID again");
	            return;
	           }
	        if (user_email.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter your email");
	            return;
	           }
	        if (user_address.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter your address");
	            return;
	           }
	        if (user_mobile.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter your mobile number");
	            return;
	           }
	    
	        
	        String username= user_name.getText().toString();
			String id= user_id.getText().toString();
			String id2= user_id_again.getText().toString();
			String email= user_email.getText().toString();
			String add= user_address.getText().toString();
			String mob= user_mobile.getText().toString();
			
			//System.out.println(id+" "+id2);
			  
			 if (!(id.equals(id2))) {
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
		                "ID's do not match!");
		            return;
		           }
			 
			 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                    "[a-zA-Z0-9_+&*-]+)*@" + 
	                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                    "A-Z]{2,7}$"; 
	                      
		    	Pattern pat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);  
		    	Matcher matcher = pat.matcher((CharSequence) email);
		    	if(!(matcher.find()))
		    	{
		            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
		                "Please enter valid email");
		            return;
		           }
		    	
		    	String emailRegex2 = "^((\\+){1}91){1}[1-9]{1}[0-9]{9}$"; 
		                      
			    Pattern pat2 = Pattern.compile(emailRegex2);  
			    Matcher matcher2 = pat2.matcher((CharSequence) mob);
			    if(!(matcher2.find()))
			    {
			          showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
			              "Please enter valid mobile number");
			          return;
			       }
		    		
			
			DBconnect DBconnect = new DBconnect();
	      	           try {	  
	            
	           DBconnect.UserInDB(username,id,email,add);
	           DBconnect.UserInDB2(id,mob);
	           
	           Parent root = FXMLLoader.load(getClass().getResource("/user/SignUpThanks.fxml"));
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
  
