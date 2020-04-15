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
 
public class JournalDetailsControl implements Initializable {
 
   
   @FXML
   private TextField journal_title;
   
   @FXML
   public TextField journal_id;
   
   @FXML
   public TextField journal_pages;
   
   @FXML
   public TextField journal_year;
   
   @FXML
   public TextField publisher;
   
   @FXML 
   private Button mySearchArticle;
   
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   
   public void SearchArticle(ActionEvent event) throws SQLException {
   
	     // Window owner = mySearchArticle.getScene().getWindow();
	   	  
	   	  String query="Select count(*) as count from journals,articles where journal_id=article_journal_id";
	   	  String query2="Select * from articles,journals where journal_id=article_journal_id";
	   	  String title=null,id=null,pages=null,year=null,pub=null;
	      int opt=0;
	      int opt1=0,opt2=0,opt3=0,opt4=0,opt5=0;
	      
	      if (!(journal_id.getText().isEmpty())) {
	    	  id=journal_id.getText().toString();
	    	  opt++;
	    	  opt1=opt;
	    	  query+=" and journal_id=?";
	    	  query2+=" and journal_id=?";
	      }
	      
	      if (!(journal_title.getText().isEmpty())) {
	    	  title=journal_title.getText().toString();
	    	  opt++;
	    	  opt2=opt;
	    	  query+=" and journal_title=?";
	    	  query2+=" and journal_title=?";
	      }
	      
	      if (!(journal_pages.getText().isEmpty())) {
	    	  pages=journal_pages.getText().toString();
	    	  opt++;
	    	  opt3=opt;
	    	  query+=" and journal_pages=?";
	    	  query2+=" and journal_pages=?";
	      }
	      
	      if (!(journal_year.getText().isEmpty())) {
	    	  year=journal_year.getText().toString();
	    	  opt++;
	    	  opt4=opt;
	    	  query+=" and journal_year=?";
	    	  query2+=" and journal_year=?";
	      }
	      
	      if (!(publisher.getText().isEmpty())) {
	    	  pub=publisher.getText().toString();
	    	  opt++;
	    	  opt5=opt;
	    	  query+=" and publisher=?";
	    	  query2+=" and publisher=?";
	      }
	       
	      Constants.text=query;
	      Constants.text2=query2;
	      
	        DBconnect DBconnect = new DBconnect();
	        boolean flag = DBconnect.validateJournal(title,id,pages,year,pub,opt1,opt2,opt3,opt4,opt5);
	        
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
	            
	          Constants.showArticleList = DBconnect.showArticlesJournal(title,id,pages,year,pub,opt1,opt2,opt3,opt4,opt5);
	           
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
  
