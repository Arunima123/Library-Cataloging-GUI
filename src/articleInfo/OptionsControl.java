package articleInfo;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import application.DBconnect;
//import javafx.scene.layout.VBox;
//import constants.Constants;
//import application.DBconnect;
import constants.Constants;

import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;

import javafx.fxml.Initializable;
 
public class OptionsControl implements Initializable {
 
  @Override
   public void initialize(URL location, ResourceBundle resources) {
 
  }
   
  public void ArticleInfo(ActionEvent event) {
   
		  
	try {	   Parent root = FXMLLoader.load(getClass().getResource("/articleInfo/GetInfo.fxml"));/* Exception */
		   Scene scene = new Scene(root);
		   Stage stage = new Stage();
		   stage.setScene(scene);
		   stage.show();
   }  
		   catch(Exception e) {
		        e.printStackTrace();
		    }
  }
  
  public void AllArticleInfo(ActionEvent event) {
	   
	  Constants.showArticleList=DBconnect.showAllArticleInfo();
	  
		try {	   Parent root = FXMLLoader.load(getClass().getResource("/articleInfo/AllArticle.fxml"));/* Exception */
			   Scene scene = new Scene(root);
			   Stage stage = new Stage();
			   stage.setScene(scene);
			   stage.show();
	   }  
			   catch(Exception e) {
			        e.printStackTrace();
			    }
	      }
  
  public void AllJournalInfo(ActionEvent event) {
	   
	  
	  Constants.showArticleList=DBconnect.showAllJournalInfo();	
	  
	   try {	   Parent root = FXMLLoader.load(getClass().getResource("/articleInfo/AllJournal.fxml"));/* Exception */
			   Scene scene = new Scene(root);
			   Stage stage = new Stage();
			   stage.setScene(scene);
			   stage.show();
	   }  
			   catch(Exception e) {
			        e.printStackTrace();
			    }
	      }
  public void AllAuthorInfo(ActionEvent event) {
	   
	  
	  Constants.showArticleList =DBconnect.showAllAuthorInfo();
	  
	  try {	   Parent root = FXMLLoader.load(getClass().getResource("/articleInfo/AllAuthor.fxml"));/* Exception */
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