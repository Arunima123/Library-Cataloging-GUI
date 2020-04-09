package articleSearch;
import application.DBconnect;
import constants.Constants;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
 
public class ArticleDetailsControl implements Initializable {
 
   
   @FXML
   private TextField article_title;
   
   @FXML
   public TextField article_id;
   
   @FXML
   public TextField article_pages;
   
   @FXML
   public TextField article_year;
   
   @FXML 
   private Button mySearchArticle;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   
   public void SearchArticle(ActionEvent event) throws SQLException {
   
	     // Window owner = mySearchArticle.getScene().getWindow();
	   	  
	   	  String query="Select count(*) as count from articles where";
	   	  String query2="Select * from articles where";
	   	  String title=null,id=null,pages=null,year=null;
	      int opt=0;
	      int opt1=0,opt2=0,opt3=0,opt4=0;
	      
	      if (!(article_id.getText().isEmpty())) {
	    	  id=article_id.getText().toString();
	    	  opt++;
	    	  opt1=opt;
	    	  query+=" article_id=?";
	    	  query2+=" article_id=?";
	      }
	      
	      if (!(article_title.getText().isEmpty())) {
	    	  title=article_title.getText().toString();
	    	  opt++;
	    	  opt2=opt;
	    	  if(opt==1)
	    	  {
	    		  query+=" article_title=?";
	    		  query2+=" article_title=?";
	    	  }
	    	  else
	    	  {
	    		  query+=" and article_title=?";
	    		  query2+=" and article_title=?";
	    	  }
	    		  
	      }
	      
	      if (!(article_pages.getText().isEmpty())) {
	    	  pages=article_pages.getText().toString();
	    	  opt++;
	    	  opt3=opt;
	    	  if(opt==1)
	    	  {
	    		  query+=" article_pages=?";
	    		  query2+=" article_pages=?";
	    	  }
	    	  else
	    	  {
	    		  query+=" and article_pages=?";
	    		  query2+=" and article_pages=?";
	    	  }
	      }
	      
	      if (!(article_year.getText().isEmpty())) {
	    	  year=article_year.getText().toString();
	    	  opt++;
	    	  opt4=opt;
	    	  if(opt==1)
	    	  {
	    		  query+=" article_year=?";
	    		  query2+=" article_year=?";
	    	  }
	    	  else
	    	  {
	    		  query+=" and article_year=?";
	    		  query2+=" and article_year=?";
	    	  }
	      }
	       
	      Constants.text=query;
	      Constants.text2=query2;
	      
	        DBconnect DBconnect = new DBconnect();
	        boolean flag = DBconnect.validateArticle(title,id,pages,year,opt1,opt2,opt3,opt4);
	        
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
	            
	          Constants.showArticleList = DBconnect.showArticles(title,id,pages,year,opt1,opt2,opt3,opt4);
	           
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
  
