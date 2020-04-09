package articleSearch;
import application.DBconnect;
import constants.Constants;

import java.net.URL;
import java.sql.SQLException;
// java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
//import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
 
public class AuthorDetailsControl implements Initializable {
 
   
   @FXML
   private TextField author_name;
   
   @FXML
   public TextField author_id;
   
   @FXML
   public TextField author_email;
   
   @FXML
   public TextField author_department;
   
   @FXML
   public TextField author_address;
   
   @FXML
   public TextField institution_name;
   
   @FXML 
   private Button mySearchAuthor;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   
   public void SearchAuthor(ActionEvent event) throws SQLException {
   
	     // Window owner = mySearchArticle.getScene().getWindow();
	   	  
	   	  String query="Select count(*) as count from articles join authors on article_author_id=author_id join institution on author_institution_id=institution_id where";
	   	  String query2="select * from articles join authors on article_author_id=author_id join institution on author_institution_id=institution_id where";
	   	  String name=null,id=null,email=null,dept=null,add=null,inst=null;
	      int opt=0;
	      int opt1=0,opt2=0,opt3=0,opt4=0,opt5=0,opt6=0;
	      
	      if (!(author_id.getText().isEmpty())) {
	    	  id=author_id.getText().toString();
	    	  opt++;
	    	  opt1=opt;
	    	  query+=" author_id=?";
	    	  query2+=" author_id=?";
	      }
	      
	      if (!(author_name.getText().isEmpty())) {
	    	  name=author_name.getText().toString();
	    	  opt++;
	    	  opt2=opt;
	    	  if(opt==1)
	    	  {
	    		  query+=" author_name=?";
	    		  query2+=" author_name=?";
	    	  }
	    	  else
	    	  {
	    		  query+=" and author_name=?";
	    		  query2+=" and author_name=?";
	    	  }
	    		  
	      }
	      
	      if (!(author_email.getText().isEmpty())) {
	    	  email=author_email.getText().toString();
	    	  opt++;
	    	  opt3=opt;
	    	  if(opt==1)
	    	  {
	    		  query+=" author_email=?";
	    		  query2+=" author_email=?";
	    	  }
	    	  else
	    	  {
	    		  query+=" and author_email=?";
	    		  query2+=" and author_email=?";
	    	  }
	      }
	      
	      if (!(author_department.getText().isEmpty())) {
	    	  dept=author_department.getText().toString();
	    	  opt++;
	    	  opt4=opt;
	    	  if(opt==1)
	    	  {
	    		  query+=" author_department=?";
	    		  query2+=" author_department=?";
	    	  }
	    	  else
	    	  {
	    		  query+=" and author_department=?";
	    		  query2+=" and author_department=?";
	    	  }
	      }
	      
	      if (!(author_address.getText().isEmpty())) {
	    	  add=author_address.getText().toString();
	    	  opt++;
	    	  opt5=opt;
	    	  if(opt==1)
	    	  {
	    		  query+=" author_addresss=?";
	    		  query2+=" author_addresss=?";
	    	  }
	    	  else
	    	  {
	    		  query+=" and author_addresss=?";
	    		  query2+=" and author_addresss=?";
	    	  }
	      }
	      
	      if (!(institution_name.getText().isEmpty())) {
	    	  inst=institution_name.getText().toString();
	    	  opt++;
	    	  opt6=opt;
	    	  if(opt==1)
	    	  {
	    		  query+=" institution_name=?";
	    		  query2+=" institution_name=?";
	    	  }
	    	  else
	    	  {
	    		  query+=" and institution_name=?";
	    		  query2+=" and institution_name=?";
	    	  }
	      }
	       
	      Constants.text=query;
	      Constants.text2=query2;
	      
	        DBconnect DBconnect = new DBconnect();
	        boolean flag = DBconnect.validateAuthor(name,id,email,dept,add,inst,opt1,opt2,opt3,opt4,opt5,opt6);
	        
	        if (!flag) {
	            infoBox("Article Not Found!", null, "Failed");
	            try {
	            	 Parent root = FXMLLoader.load(getClass().getResource("/user/LibFunc.fxml"));
	  	           Scene scene = new Scene(root);
	  	 		   Stage stage = new Stage();
	  	 		   stage.setScene(scene);
	  	 		   stage.show();
	            }
	            catch(Exception e) {
	 		        e.printStackTrace();
	 		    }
	 		   
	            
	        } else {
	           infoBox("Article/Articles Found!", null, "Passed");
	            
	           try {	  
	            
	          Constants.showArticleList = DBconnect.showArticlesAuthor(name,id,email,dept,add,inst,opt1,opt2,opt3,opt4,opt5,opt6);
	           
	           Parent root = FXMLLoader.load(getClass().getResource("/articleSearch/ArticleList.fxml"));
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

	
	}
  
