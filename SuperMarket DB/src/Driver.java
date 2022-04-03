
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Group ;


public class Driver extends Application {
	
	private static String dbUsername = "root"; //mysql user name
	private static String dbPassword = "258258"; //mysql password
	private static String URL = "127.0.0.1"; // location of db server
	private static String port = "3306"; // constant
	private static String dbName = "superMarket"; //most likely will not change
	private static Connection con;

	public static void main(String[] args)   throws SQLException , ClassNotFoundException   {
		
	
		launch(args);
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setScene(scenes.suppliersScene(primaryStage));

		primaryStage.show();
	}
	
	

}
