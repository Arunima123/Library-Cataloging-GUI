package articleSearch;


import java.net.URL;
import java.sql.SQLException;

//import javafx.scene.text.Text;
import java.util.ResourceBundle;

//import application.DBconnect;
import constants.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
//import javafx.event.Event;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Label;
import javafx.scene.control.TableView;
//import javafx.scene.control.TableColumn;
import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
//import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;


public class ArticleListControl implements Initializable {
	
	 private ObservableList<String> data;
	 
	 @FXML
	 private TableView<ObservableList<String>> tableView;

	 String[] columnNames = new String[] {"ID", "Title", "No of Pages", "Year of Publishing"};
	

	  @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       
	 		
		   ObservableList<String> row= FXCollections.observableArrayList();
		   data = FXCollections.observableArrayList();
		   
		   
               
		   System.out.println(row);
		   data.addAll(row);
	       //Item item = new Item(row[0], row[1], row[2], row[3]);
	       //tableView.setItems(row);
		   
		   //TableView<ObservableList<String>> tableView = new TableView<>();
	        tableView.setItems(buildData(Constants.showArticleList));
	 
	        for (int i = 0; i < Constants.showArticleList[0].length; i++) {
	            final int curCol = i;
	            final TableColumn<ObservableList<String>, String> column = new TableColumn<>(
	            		columnNames[i]
	            );
	            column.setCellValueFactory(
	                    param -> new ReadOnlyObjectWrapper<>(param.getValue().get(curCol))
	            );
	            tableView.getColumns().add(column);
	        }
	   
	   }
	   
	    private ObservableList<ObservableList<String>> buildData(String[][] dataArray) {
	        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
	 
	        for (String[] row : dataArray) {
	            data.add(FXCollections.observableArrayList(row));
	        }
	 
	        return data;
	    }
	   
	   
	   public void MainFunctions(ActionEvent event) throws SQLException {
		
		         try {	   Parent root = FXMLLoader.load(getClass().getResource("/user/LibFunc.fxml"));/* Exception */
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
