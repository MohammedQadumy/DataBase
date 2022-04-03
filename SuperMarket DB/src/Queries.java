import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;


public class Queries {
	
	private static String dbURL;
	private static String dbUsername = "root"; //mysql user name
	private static String dbPassword = "258258"; //mysql password
	private static String URL = "127.0.0.1"; // location of db server
	private static String port = "3306"; // constant
	private static String dbName = "superMarket"; //most likely will not change
	private static Connection con;
	
	
	public static void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}
	
	public static void ExecuteStatement(String SQL) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			System.out.println("SQL statement is not executed!");

		}

	}
	
	public static ObservableList<suppliers> getSuppliers() throws ClassNotFoundException, SQLException {
		
		ObservableList<suppliers> suppliersOb = FXCollections.observableArrayList();
		String SQL;

		connectDB();

		SQL = "select s.uniqueNum,s.sname,s.banknumber,s.email,s.goodstype  from suppliers s order by s.uniqueNum ; ";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			int id = Integer.parseInt(rs.getString(1));
			int bankNum = Integer.parseInt(rs.getString(3));
			
			suppliers supplier = new suppliers(id,rs.getString(2),bankNum,rs.getString(5),rs.getString(4));

			suppliersOb.add(supplier);

		}
		rs.close();
		stmt.close();

		con.close();
		return suppliersOb;
		
		

	}
	
	
	
	public static void insertSupplier(suppliers supplier) {
		try {
			connectDB();

			System.out.println("Insert into suppliers (sname,bankNumber,goodstype,email) values( '" 
					+ supplier.getSupname() +"',"+supplier.getBankNum() +   ",'" +supplier.getGoodsType() + "','"+supplier.getEmail() + "');" );
			
			ExecuteStatement("Insert into suppliers (sname,bankNumber,goodstype,email) values( '" 
					+ supplier.getSupname() +"',"+supplier.getBankNum() +   ",'" +supplier.getGoodsType() + "','"+supplier.getEmail() + "');" );
			

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
	     System.out.println("error");
		}
	}
	
	public static void insertBank(bank account ) {
		try {
			connectDB();
			System.out.println("insert into bank (money) values ("+account.getMoney()+");");

			ExecuteStatement("insert into bank (money) values ("+account.getMoney()+");");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
	     System.out.println("ERROR");
		}
	}


	
	public static void insertGood(goods good) {
		
		try {
			connectDB();

			System.out.println("Insert into goods(gname,uniqueNum) values('" +good.getgName() + "',"
					 + good.getUniqueNum()  + ");" );
			ExecuteStatement("Insert into goods(gname,uniqueNum) values('" +good.getgName() + "',"
					 + good.getUniqueNum()  + ");" );

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
	     
		}
	}


	public static void updateGoodsType (int id , String type) throws ClassNotFoundException, SQLException {
		
		connectDB();
		
		ExecuteStatement("update suppliers set goodstype = " +"'"+type +"'" +" where uniqueNum =" +id +  ";");
		
		con.close();
	}
	
	public static void updateEmail (int id , String email) throws ClassNotFoundException, SQLException {
		
		connectDB();
		System.out.println("update suppliers set email = " + "'"+email+ "'" + " where uniqueNum =" +id +  ";");
		ExecuteStatement("update suppliers set email = " + "'"+email+ "'" + " where uniqueNum =" +id +  ";");
		
		con.close();
	}
	
	public static void deleteSupplier (int id ) throws ClassNotFoundException, SQLException {
		connectDB();
		System.out.println("Delete from suppliers  where uniqueNum = " + id + " ;");
		
		String sql = "Delete from suppliers  where uniqueNum = " + id + " ;";
		ExecuteStatement(sql);
		con.close();
	}
	
	public static void deleteGood (int goodId ) throws ClassNotFoundException, SQLException {
		connectDB();
		String sql = "Delete from goods g where g.gcode = " + goodId + " ;";
		ExecuteStatement(sql);
		con.close();
	}
	
	public static void deleteGoodForSupplier(int supplierId ) throws ClassNotFoundException, SQLException {
		connectDB();
		String sql = "Delete from goods  where uniquenum = " + supplierId + " ;";
		ExecuteStatement(sql);
		con.close();
	}
	
	public static void depositMoney (int id , double money) throws ClassNotFoundException, SQLException {
		
		connectDB();
		System.out.println("update bank set money = money + " +money + " where banknumber =" +id +  ";");
		ExecuteStatement("update bank set money = money + " +money + " where banknumber =" +id +  ";");
		
		con.close();
	}
	
	public static void withDrawMoney (int id , double money) throws ClassNotFoundException, SQLException {
		
		connectDB();
		System.out.println("update bank set money = money -" +money + " where banknumber =" +id +  ";");
		ExecuteStatement("update bank set money = money -" +money + " where banknumber =" +id +  ";");
		
		con.close();
	}
	

	
	public static int selectMoney(int id ) throws ClassNotFoundException, SQLException 
	{
		int accountReveal = 0  ;
		
		String SQL;

		connectDB();

		SQL = "Select Money from bank where banknumber = " + id+";" ;

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			accountReveal = Integer.parseInt(rs.getString(1));
			
		}
		rs.close();
		stmt.close();

		con.close();
		return accountReveal;
	}
	
	public static ArrayList<String> nameForPie( ) throws ClassNotFoundException, SQLException 
	{
		ArrayList<String> goodsName = new ArrayList<String>();
		
		String SQL;

		connectDB();

		SQL ="select gname from goods group by gname ; ";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			goodsName.add(rs.getString(1));
			
		}
		rs.close();
		stmt.close();

		con.close();
		return goodsName;
	}
	
	public static ArrayList<Integer> countForPie( ) throws ClassNotFoundException, SQLException 
	{
		ArrayList<Integer> numberOfgood = new ArrayList<Integer>();
		
		String SQL;

		connectDB();

		SQL ="select count(*) from goods group by gname ; ";

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {

			numberOfgood.add(Integer.parseInt(rs.getString(1)));
			
		}
		rs.close();
		stmt.close();

		con.close();
		return numberOfgood;
	}
	
	//public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	//	ArrayList<Integer> n = new ArrayList<Integer>();
	//	n = countForPie();
		
	//	for (int i = 0 ; i<n.size();i++)
	//	{
	//		System.out.println(n.get(i));
	//	}
		
	//	ArrayList<String> goodsName = new ArrayList<String>();
	//	goodsName =nameForPie();
	//	for (int i = 0 ; i< goodsName.size();i++)
	//	{
			//System.out.println(goodsName.get(i));
		//}
	//}
	
	
	
	
	
	//public static void countGoods () throws ClassNotFoundException, SQLException {
		
		//connectDB();
		
		//ExecuteStatement("select gname,count(*) from goods group by gname ; ");
		
	//	con.close();
	//}


	
}
