
import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.sun.glass.events.KeyEvent;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class scenes {

	public static Scene suppliersScene(Stage primaryStage) throws FileNotFoundException {
		
		primaryStage.setTitle("Suppliers tab");

		TextField tfName = new TextField();
		tfName.setPrefHeight(25);
		tfName.setPrefWidth(270);
		
		TextField tfId = new TextField();
		tfId.setPrefHeight(25);
		tfId.setPrefWidth(270);
		
		TextField tfBankNum = new TextField();
		tfBankNum.setPrefHeight(25);
		tfBankNum.setPrefWidth(270);
		
		TextField tfType = new TextField();
		tfType.setPrefHeight(25);
		tfType.setPrefWidth(270);
		
		TextField tfEmail = new TextField();
		tfEmail.setPrefHeight(25);
		tfEmail.setPrefWidth(270);
		

		tfName.setPromptText("Enter supplier name ");
		tfId.setPromptText(" For delete or update ONLY ! ");
		tfBankNum.setPromptText("Enter supplier Bank Number");
		tfType.setPromptText("Enter good type (milk,hummus ...)");
		tfEmail.setPromptText("Enter supplier email here ");
		
		Label lName = new Label("Name");
		lName.setPrefHeight(30);
		lName.setPrefWidth(100);

		Label lId = new Label("Supplier Id");
		lId.setPrefHeight(30);
		lId.setPrefWidth(100);
		
		Label lEmail = new Label("email");
		lEmail.setPrefHeight(30);
		lEmail.setPrefWidth(100);

		Label lBankNum = new Label("Bank number");
		lBankNum.setPrefHeight(30);
		lBankNum.setPrefWidth(100);

		Label ltype = new Label("Goods type");
		ltype.setPrefHeight(30);
		ltype.setPrefWidth(100);

		VBox textFields1 = new VBox();
		VBox labels1 = new VBox();

		textFields1.setSpacing(10);
		textFields1.getChildren().add(tfName);
		textFields1.getChildren().add(tfId);
		textFields1.getChildren().add(tfEmail);
		textFields1.getChildren().add(tfBankNum);
		textFields1.getChildren().add(tfType);

		labels1.setSpacing(10);
		labels1.getChildren().add(lName);
		labels1.getChildren().add(lId);
		labels1.getChildren().add(lEmail);
		labels1.getChildren().add(lBankNum);
		labels1.getChildren().add(ltype);

		HBox vboxes = new HBox();

		vboxes.getChildren().add(labels1);
		vboxes.getChildren().add(textFields1);

		vboxes.setLayoutX(22);
		vboxes.setLayoutY(10);

		Button insert = new Button(" Insert ");
		Button delete = new Button(" Delete ");
		Button update = new Button(" Update ");
		Button transfer = new Button(" Transfer ");
		Button wareHouse = new Button(" See WareHouse ");

		insert.setLayoutX(40);
		insert.setLayoutY(226);

		delete.setLayoutX(40);
		delete.setLayoutY(267);

		update.setLayoutX(40);
		update.setLayoutY(303);

		transfer.setLayoutX(187);
		transfer.setLayoutY(226);
		
		wareHouse.setLayoutX(187);
		wareHouse.setLayoutY(267);

		Group buttons = new Group();

		buttons.getChildren().addAll(insert, delete, update, transfer, wareHouse);

		TableView table = new TableView();

		table.setPrefSize(815, 278);
		table.setLayoutX(22);
		table.setLayoutY(338);
		
		TableColumn <suppliers,String> cName = new TableColumn<suppliers,String>("Supplier Name");
		TableColumn <suppliers,Integer>cId = new TableColumn("Supplier ID");
		TableColumn <suppliers,String>cEmail = new TableColumn("supplier Email ");
		TableColumn <suppliers,Integer>cBankNum = new TableColumn("Supplier Bank Number");
		TableColumn <suppliers,String>cType = new TableColumn("Goods type ");
		
		cName.setCellValueFactory(new PropertyValueFactory<suppliers,String>("supname"));
		cType.setCellValueFactory(new PropertyValueFactory<suppliers,String>("goodsType"));
		cEmail.setCellValueFactory(new PropertyValueFactory<suppliers,String>("email"));
		cId.setCellValueFactory(new PropertyValueFactory<suppliers,Integer>("uniqueNum"));
		cBankNum.setCellValueFactory(new PropertyValueFactory<suppliers,Integer>("bankNum"));
		
		
		table.getColumns().addAll(cName,cId,cEmail,cBankNum,cType);
		cName.setPrefWidth(150);
		cId.setPrefWidth(100);
		cBankNum.setPrefWidth(215);
		cType.setPrefWidth(100);
		cEmail.setPrefWidth(250);
		
		try {
			table.setItems(Queries.getSuppliers());
		} catch (ClassNotFoundException | SQLException e2) {
			e2.printStackTrace();
		}
		
		



		Image mainPage = new Image(new FileInputStream("main.jpeg"));
		ImageView viewMain = new ImageView(mainPage);
		viewMain.setFitHeight(259);
		viewMain.setFitWidth(407);
		viewMain.setLayoutX(412);
		viewMain.setLayoutY(33);

		Image Imageinsert = new Image(new FileInputStream("plus.png"));
		ImageView viewInsert = new ImageView(Imageinsert);
		viewInsert.setFitWidth(24);
		viewInsert.setFitHeight(25);
		viewInsert.setLayoutX(10);
		viewInsert.setLayoutY(226);

		Image IamgeDelete = new Image(new FileInputStream("delete.png"));
		ImageView viewDelete = new ImageView(IamgeDelete);
		viewDelete.setFitWidth(24);
		viewDelete.setFitHeight(25);
		viewDelete.setLayoutX(10);
		viewDelete.setLayoutY(268);

		Image ImageUpdate = new Image(new FileInputStream("new.png"));
		ImageView viewUpdate = new ImageView(ImageUpdate);
		viewUpdate.setFitWidth(24);
		viewUpdate.setFitHeight(25);
		viewUpdate.setLayoutX(10);
		viewUpdate.setLayoutY(304);

		Image ImageDeposit = new Image(new FileInputStream("transfer.png"));
		ImageView viewDeposit = new ImageView(ImageDeposit);
		viewDeposit.setFitWidth(24);
		viewDeposit.setFitHeight(25);
		viewDeposit.setLayoutX(156);
		viewDeposit.setLayoutY(226);



		Image ImageWareHouse = new Image(new FileInputStream("warehouse.png"));
		ImageView viewWareHouse = new ImageView(ImageWareHouse);
		viewWareHouse.setFitWidth(24);
		viewWareHouse.setFitHeight(25);
		viewWareHouse.setLayoutX(156);
		viewWareHouse.setLayoutY(268);



		Group images = new Group();
		images.getChildren().addAll( viewWareHouse, viewUpdate, viewMain, viewInsert, viewDeposit,
				viewDelete);

		Pane pane = new Pane();

		pane.getChildren().addAll(vboxes, buttons, images, table);
		pane.setPrefSize(850, 630);
		pane.setStyle("-fx-background-color: #20B2AA");

		
	
		
		insert.setOnAction((ActionEvent e)->{
			
			if (tfName.getText().isEmpty()||tfEmail.getText().isEmpty()||tfType.getText().isEmpty()) {
				Alert alertBox = new Alert(AlertType.INFORMATION);
				alertBox.setTitle("Error");
				alertBox.setHeaderText("FILL NAME,EMAIL,TYPE");
				alertBox.show();
				
			}
			

			else {
				
				String Name = tfName.getText();
				String email = tfEmail.getText();
				int bankNum = Integer.parseInt(tfBankNum.getText());
				String goodType = tfType.getText();
				suppliers s = new suppliers( Name, bankNum, goodType, email);
				
				bank account = new bank (0);
				
				Queries.insertBank(account);
				Queries.insertSupplier(s);
				
				try {
					table.setItems(Queries.getSuppliers());
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		);
		
		delete.setOnAction(e->{
		
			if (tfId.getText().isEmpty())
			{
				Alert alertBox = new Alert(AlertType.INFORMATION);
				alertBox.setTitle("Error");
				alertBox.setHeaderText("FILL SUPPLIER ID TO DELETE ");
				alertBox.show();
			}
			else 
			{
				int supplierId = Integer.parseInt(tfId.getText());
				
					try {
					 	Queries.deleteGoodForSupplier(supplierId);
						Queries.deleteSupplier(supplierId);
						
						try {
							table.setItems(Queries.getSuppliers());
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
	
			}
			
		});
		
		update.setOnAction(e->{
			if (tfName.getText().isEmpty() && tfType.getText().isEmpty() && tfBankNum.getText().isEmpty() )
			{
				int supplierId = Integer.parseInt(tfId.getText());
				String newEmail = tfEmail.getText();
				try {
					
					Queries.updateEmail(supplierId, newEmail);
					try {
						table.setItems(Queries.getSuppliers());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			else if (tfName.getText().isEmpty() && tfEmail.getText().isEmpty() && tfBankNum.getText().isEmpty() )
			{
				int supplierId = Integer.parseInt(tfId.getText());
				String newType = tfType.getText();
				try {
					
					Queries.updateGoodsType(supplierId, newType);
					
					try {
						table.setItems(Queries.getSuppliers());
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			else 
			{
				Alert alertBox = new Alert(AlertType.INFORMATION);
				alertBox.setTitle("Error");
				alertBox.setHeaderText("YOU CAN ONLY UPDATE EMAIL AND GOOD TYPE ! ");
				alertBox.show();
			}
		});

		transfer.setOnAction(e->{
			try {
				primaryStage.setScene(scenes.bankScene(primaryStage));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		

		wareHouse.setOnAction(e->{
			try {
				primaryStage.setScene(scenes.goodsScene(primaryStage));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
		});
		

		
		Scene s = new Scene(pane, 850, 630);
		return s;
	}
	
	
	public static Scene goodsScene(Stage primaryStage) throws FileNotFoundException
	{
		primaryStage.setTitle("Goods tab");
		
		Label lgoodName = new Label("Good Name");
		Label lgoodUniqueNum = new Label("Good Number");
		
		

		Label lsuppplierId2 = new Label("Supplier ID ");
		
		lgoodName.setLayoutX(29);
		lgoodName.setLayoutY(90);
		
		lgoodUniqueNum.setLayoutX(29);
		lgoodUniqueNum.setLayoutY(134);
		
		lsuppplierId2.setLayoutX(29);
		lsuppplierId2.setLayoutY(175);
		



		
		Group labels = new Group();
		labels.getChildren().addAll(lsuppplierId2,lgoodUniqueNum,lgoodName);
		
		
		TextField tfgoodName = new TextField();
		TextField tfgoodUniqueNum = new TextField();
		
	
		TextField tfsupplierId2 = new TextField();
		
		tfgoodName.setLayoutX(150);
		tfgoodName.setLayoutY(86);
		
		tfgoodUniqueNum.setLayoutX(150);
		tfgoodUniqueNum.setLayoutY(130);
		
		tfsupplierId2.setLayoutX(150);
		tfsupplierId2.setLayoutY(170);

		tfgoodName.setPromptText(" Enter good name here ");
		tfgoodUniqueNum.setPromptText(" FOR DELETION ONLY ");
		
		
		
		tfsupplierId2.setPromptText(" Enter supplier ID here  ");

		
		Group textFields = new Group();
		textFields.getChildren().addAll(tfsupplierId2,tfgoodUniqueNum,tfgoodName);
		
		
		
		
		Button back2main = new Button(" Back to main page ") ;
		Button stats = new Button(" See warehouse stats ") ;
		Button insertGood = new Button(" Add new good ") ;
		Button DeleteGood = new Button(" Delete good ") ;
		
		DeleteGood.setLayoutX(400);
		DeleteGood.setLayoutY(85);
		
		insertGood.setLayoutX(543);
		insertGood.setLayoutY(85);

		stats.setLayoutX(427);
		stats.setLayoutY(373);
		
		back2main.setLayoutX(51);
		back2main.setLayoutY(482);
		
		
		Group buttons = new Group();
		buttons.getChildren().addAll(back2main,stats,insertGood,DeleteGood);
		
		
		Image goodsImage = new Image(new FileInputStream("ware-house.jpg"));
		ImageView viewGoods = new ImageView(goodsImage);
		viewGoods.setFitWidth(280);
		viewGoods.setFitHeight(230);
		viewGoods.setLayoutX(50);
		viewGoods.setLayoutY(227);
		
		Image Iinsert = new Image(new FileInputStream("plus.png"));
		ImageView viewInsert = new ImageView(Iinsert);
		viewInsert.setFitWidth(24);
		viewInsert.setFitHeight(25);
		viewInsert.setLayoutX(513);
		viewInsert.setLayoutY(86);
		
		Image IDelete = new Image(new FileInputStream("delete.png"));
		ImageView viewDelete = new ImageView(IDelete);
		viewDelete.setFitWidth(24);
		viewDelete.setFitHeight(25);
		viewDelete.setLayoutX(374);
		viewDelete.setLayoutY(86);
		
		Image IPieChart = new Image(new FileInputStream("pie-chart.png"));
		ImageView viewPieChart = new ImageView(IPieChart);
		viewPieChart.setFitWidth(24);
		viewPieChart.setFitHeight(25);
		viewPieChart.setLayoutX(400);
		viewPieChart.setLayoutY(377);
		
		Image IBack = new Image(new FileInputStream("undo.png"));
		ImageView viewBack = new ImageView(IBack);
		viewBack.setFitWidth(24);
		viewBack.setFitHeight(25);
		viewBack.setLayoutX(26);
		viewBack.setLayoutY(482);
		
		
		Group images = new Group();
		images.getChildren().addAll(viewPieChart,viewInsert,viewGoods,viewDelete,viewBack);
			
		
		Pane pane = new Pane();
		
		pane.getChildren().addAll(labels,textFields,images,buttons);
		pane.setPrefSize(690, 520);
		pane.setStyle("-fx-background-color: #20B2AA");
		
		

		
		DeleteGood.setOnAction(e->{
			
			if(tfgoodName.getText().isEmpty()&&tfsupplierId2.getText().isEmpty())
			{
				int goodCode = Integer.parseInt(tfgoodUniqueNum.getText());
				try {
					Queries.deleteGood(goodCode);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
			else 
			{
				Alert alertBox = new Alert(AlertType.INFORMATION);
				alertBox.setTitle("Error");
				alertBox.setHeaderText("ENTER ONLY GOOD CODE");
				alertBox.show();
			}
			
		});
		
		insertGood.setOnAction(e->{
			
			if (tfgoodName.getText().isEmpty()||tfsupplierId2.getText().isEmpty())
			{
				Alert alertBox = new Alert(AlertType.INFORMATION);
				alertBox.setTitle("Error");
				alertBox.setHeaderText("ENTER GOOD NAME AND SUPPLIER NAME ");
				alertBox.show();
			}
			else 
			{
				String goodName = tfgoodName.getText();
				int supplierId = Integer.parseInt(tfsupplierId2.getText());
				
				goods good = new goods(goodName,supplierId) ;
				Queries.insertGood(good); 
				
				
			}
			
		});
		
		stats.setOnAction(e->{
			try {
				primaryStage.setScene(pieChart(primaryStage));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		back2main.setOnAction(e->{
			
			try {
				primaryStage.setScene(scenes.suppliersScene(primaryStage));
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		});

		Scene s = new Scene(pane, 690, 520);
		return s;
		
		
	}
	
	public static Scene bankScene(Stage primaryStage) throws FileNotFoundException
	{
		primaryStage.setTitle("Bank tab");
		
		Label lbankId = new Label("Account Number");
		Label lmoney = new Label("Money amount");
		Label laccount = new Label("Account reveal");
		
		lbankId.setLayoutX(36);
		lbankId.setLayoutY(56);
		
		lmoney.setLayoutX(36);
		lmoney.setLayoutY(94);
		
		laccount.setLayoutX(8);
		laccount.setLayoutY(187);
		
		Group labels = new Group();
		labels.getChildren().addAll(lbankId,lmoney,laccount);
		
		
		
		TextField tfbankId = new TextField();
		TextField tfmoney = new TextField();
		TextField tfaccount = new TextField();
		
		tfbankId.setPromptText(" Enter Account number here ");
		tfmoney.setPromptText(" Enter amount of money here ");
		
		tfbankId.setLayoutX(150);
		tfbankId.setLayoutY(55);
		tfbankId.setPrefWidth(215);
		
		tfmoney.setLayoutX(150);
		tfmoney.setLayoutY(93);
		tfmoney.setPrefWidth(215);
		
		tfaccount.setLayoutX(120);
		tfaccount.setLayoutY(183);
		
		RadioButton rbDeposit = new RadioButton("Deposit");
		RadioButton rbWithDraw = new RadioButton("WithDraw");
		
		rbDeposit.setLayoutX(15);
		rbDeposit.setLayoutY(21);
		
		rbWithDraw.setLayoutX(100);
		rbWithDraw.setLayoutY(21);
		
		ToggleGroup radioButtons = new ToggleGroup();
		
		rbDeposit.setToggleGroup(radioButtons);
		rbWithDraw.setToggleGroup(radioButtons);
		
		Group textFields = new Group();
		textFields.getChildren().addAll(tfmoney,tfbankId,tfaccount);
		
		
		Button confirm = new Button("Confirm");
		Button back = new Button("Back to main page");
		
		confirm.setLayoutX(46);
		confirm.setLayoutY(145);
		
		back.setLayoutX(48);
		back.setLayoutY(229);
		
		Group buttons = new Group();
		buttons.getChildren().addAll(confirm,back,rbDeposit,rbWithDraw);
		
		Image IBankNum = new Image(new FileInputStream("bank number.png"));
		ImageView viewBankNum = new ImageView(IBankNum);
		viewBankNum.setFitWidth(26);
		viewBankNum.setFitHeight(23);
		viewBankNum.setLayoutX(2);
		viewBankNum.setLayoutY(56);
		
		Image IMoney = new Image(new FileInputStream("atm.png"));
		ImageView viewMoney = new ImageView(IMoney);
		viewMoney.setFitWidth(26);
		viewMoney.setFitHeight(25);
		viewMoney.setLayoutX(2);
		viewMoney.setLayoutY(93);
		
		Image IConfirm = new Image(new FileInputStream("confirmation.png"));
		ImageView viewConfirm = new ImageView(IConfirm);
		viewConfirm.setFitWidth(26);
		viewConfirm.setFitHeight(23);
		viewConfirm.setLayoutX(15);
		viewConfirm.setLayoutY(146);
		
		Image IBack = new Image(new FileInputStream("undo.png"));
		ImageView viewBack = new ImageView(IBack);
		viewBack.setFitWidth(26);
		viewBack.setFitHeight(25);
		viewBack.setLayoutX(15);
		viewBack.setLayoutY(229);
		
		Group images = new Group();
		images.getChildren().addAll(viewMoney,viewConfirm,viewBankNum,viewBack);
		
		
		
		Pane pane = new Pane();
		
		pane.getChildren().addAll(images,labels,textFields,buttons);
		pane.setPrefSize(380, 270);
		pane.setStyle("-fx-background-color: #20B2AA");
		
		
		confirm.setOnAction(e->{
			
			if (rbDeposit.isSelected())
			{
				int bankNum = Integer.parseInt(tfbankId.getText());
				int money = Integer.parseInt(tfmoney.getText());
				
				try {
					Queries.depositMoney(bankNum, money);
					tfaccount.setText(Integer.toString(Queries.selectMoney(bankNum)));
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
			
			else if (rbWithDraw.isSelected())
			{
				int bankNum = Integer.parseInt(tfbankId.getText());
				int money = Integer.parseInt(tfmoney.getText());
				
				try {
					Queries.withDrawMoney(bankNum, money);
					tfaccount.setText(Integer.toString(Queries.selectMoney(bankNum)));
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
	
		});
		
		
		back.setOnAction(e->{
			
			try {
				primaryStage.setScene(scenes.suppliersScene(primaryStage));
				
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		});
		Scene s = new Scene(pane, 380, 270);
		
		
		
		return s ;
	}
	
	public static Scene pieChart(Stage primaryStage) throws FileNotFoundException, ClassNotFoundException, SQLException {
		
		ArrayList<Integer> numberOfGood = new ArrayList<Integer>();
		ArrayList<String> goodsName = new ArrayList<String>();
		
		numberOfGood = Queries.countForPie();
		goodsName = Queries.nameForPie();
		
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();
        
        for (int i = 0 ; i < goodsName.size();i++) 
        {
        	pieChartData.add(new PieChart.Data(goodsName.get(i),numberOfGood.get(i)));
        }

        PieChart goodsStat = new PieChart(pieChartData);
        goodsStat.setTitle("GOODS");
        
        Label percentage = new Label();
        
        for (final PieChart.Data data : goodsStat.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED,
                e -> {
                    double total = 0;
                    for (PieChart.Data d : goodsStat.getData()) {
                        total += d.getPieValue();
                    }
                    percentage.setTranslateX(450);
                    percentage.setTranslateY(200);
                    String text = String.format("%.1f%%", 100*data.getPieValue()/total) ;
                    percentage.setText(data.getName()+":"+text);
                 }
                );
        }
        

        
		Image IBack1 = new Image(new FileInputStream("undo.png"));
		ImageView viewBack1 = new ImageView(IBack1);
		viewBack1.setFitWidth(24);
		viewBack1.setFitHeight(25);

		
		Image IBack2 = new Image(new FileInputStream("undo.png"));
		ImageView viewBack2 = new ImageView(IBack2);
		viewBack2.setFitWidth(24);
		viewBack2.setFitHeight(25);

        
        Button backToSupplier = new Button("Back to supplier page",viewBack1);
        Button backToGoods = new Button("Back to goods page",viewBack2);
		
        backToGoods.setLayoutX(50);
        backToGoods.setLayoutY(450);
        
        backToSupplier.setLayoutX(300);
        backToSupplier.setLayoutY(450);
        



        backToSupplier.setOnAction(e->{
        	try {
				primaryStage.setScene(suppliersScene(primaryStage));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
        });
        backToGoods.setOnAction(e->{
        	try {
				primaryStage.setScene(goodsScene(primaryStage));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
        });
      
        Pane statPane = new Pane();
        statPane.getChildren().addAll(goodsStat,backToGoods,backToSupplier,percentage);
        statPane.setStyle("-fx-background-color: #20B2AA");
        
		Scene s = new Scene(statPane,600,500);
		return s ;
	}
	


}
