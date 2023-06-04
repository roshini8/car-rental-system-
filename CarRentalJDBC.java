import java.sql.*;


public class CarRentalJDBC {

	String driver;
	String dbName;
	String connectionURL;
	String username;
	String password;
	Connection conn;
	
	public CarRentalJDBC() {
		
		driver = "com.mysql.cj.jdbc.Driver";
		connectionURL = "jdbc:mysql://localhost:3306/";
		dbName = "dbcrms";
		username = "root";
		password = "";
	}
	
	public Connection getConnection() throws Exception{
		
		System.out.println("Connect database successfully!");
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(connectionURL+dbName,username,password);
		return connection;
	}
}
