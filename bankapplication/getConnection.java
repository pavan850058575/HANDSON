package day11handson;
import java.sql.Connection;
import java.sql.DriverManager;


public class getConnection {

	public static Connection connection() {
		Connection con =null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Driver is loading");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","Password");
	System.out.println("Connecting to DB");
}catch(Exception e) {
	System.out.println(e);
}
return con;
	}

}
