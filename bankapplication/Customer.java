package day11handson;
import java.util.*;
import java.sql.*;
import java.sql.Connection;

public class Customer {
	static Scanner sc= new Scanner(System.in);
	static int account_no=0, avl_bal=0;
	static String customer_name=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Connection con = getConnection.connection();
	System.out.println("Enter your name");
	String name =sc.nextLine();
	System.out.println("Enter your acc no");
	int acc = sc .nextInt();
	System.out.println("Entered details"+name+" "+acc);
	
	PreparedStatement pr = con.prepareStatement("select * from bank where account_no=? and customer_name=?");
	pr.setString(2,name);
	pr.setInt(1, acc);
	System.out.println(pr);
	
	ResultSet rs =pr.executeQuery();
	rs.next();
	account_no=rs.getInt(1);
	customer_name=rs.getString(2);
	avl_bal=rs.getInt(3);
	System.out.println(account_no+" "+customer_name);
	if(acc==account_no) {
		int ch=0;
		while(ch!=4) {
			pr.setInt(1, account_no);
			rs= pr.executeQuery();
			rs.next();
			account_no=rs.getInt(1);
			customer_name=rs.getString(2);
			avl_bal=rs.getInt(3);
		System.out.println("choose the option");
		System.out.println("1.Check balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdraw");
		System.out.println("4.Exit");
		ch = sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("Balance:"+avl_bal);
			break;
		
		case 2:
			PreparedStatement pr1=con.prepareStatement("Update bank set avl_bal=? where account_no=?");
			System.out.println("Enter amount to be deposited:");
			int bal=sc.nextInt();
			pr1.setInt(1,avl_bal+bal);
			pr1.setInt(2, account_no);
			pr1.executeUpdate();
			System.out.println("Deposited");
			break;
		case 3:
			if(avl_bal>10000) {
				int d=Withdraw(rs);
				if(d>0) {
					rs=pr.executeQuery();
					rs.next();
					System.out.println("New Balance"+rs.getInt(3));
					
				}
				
			}
			else {
				System.out.println("available balance low to withdraw");
			}
			break;
		case 4:
			System.out.println("thankyou");
		default:
			System.out.println("please give valid option");
		}
		
	}
	}		
	else {
		System.out.println("you are not registerted in bank" );
	}
		sc.close();
		con.close();
}
catch(Exception e) {
	System.out.println(e);
	
	
}
	}



 private static int Withdraw(ResultSet rs) throws SQLException{
	 System.out.println("Enter amount to withdraw");
	 int withdraw=sc.nextInt();
	 int data=0;
	 if(withdraw>=avl_bal) {
		 System.out.println("Available balance too low to withdraw");
	 }
	 else {
		 PreparedStatement pr2 =getConnection.connection().prepareStatement("update bank set avl_bal =? where account_no=?");
		 pr2.setInt(1, avl_bal-withdraw);
		 pr2.setInt(2, account_no);
		 data = pr2.executeUpdate();
		 System.out.println("executed:"+data);
	 }
	 return data;
	 
 }
	 
 }
