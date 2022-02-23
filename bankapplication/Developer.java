package day11handson;
import java.util.*;
import java.sql.*;



public class Developer {
	static Scanner sc =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Connection con =getConnection.connection();
	System.out.println("Enter account name to add");
	String name = sc.nextLine();
	System.out.println("Enter acc no");
	int acc=sc.nextInt();
	System.out.println("Enter balance to add");
	int balance=sc.nextInt();
	System.out.println("Enter mobile number");
	String p=sc.nextLine();
	System.out.println("Entered details:"+name +"  "+acc+" "+balance +"  "+p);
	PreparedStatement pr =con.prepareStatement("insert into Bank values(?,?,?,?)");
	pr.setInt(1, acc);
	pr.setString(2, name);
	pr.setInt(3, balance);
	pr.setString(4, p);
	System.out.println("Record saved!");
	
	//step 4
	int data = pr.executeUpdate();
	System.out.println("Record executed.."+data);
	pr=con.prepareStatement("select * from Bank");
	ResultSet rs=pr.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
	}
	con.close();
}
catch(Exception e) {
	System.out.println(e);
}
	}

}
