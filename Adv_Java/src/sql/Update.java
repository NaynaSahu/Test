package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) throws Exception {
		//insert();
		//update();
		select();
		//delete();

	}

	public static void insert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("INSERT into EMPLOYEE values(26,'SIDHI','SINGH',70000,4)");
		System.out.println(i + " record(s) updated");

		stmt.close();
		conn.close();

	}
	public static void update() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("UPDATE EMPLOYEE set FNAME = 'GANESH' , LNAME ='BHEEM' WHERE ID = 22 ");
		System.out.println(i + " record(s) updated");

		stmt.close();
		conn.close();

	}
	public static void  select() throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays","root" , "root");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
	System.out.println("ID\t\tFNAME\t\tLNAME\t\tSALARY\t\tDEP_ID");
	while(rs.next()) {
		System.out.print(rs.getString(1));
		System.out.print("\t" +"\t"+rs.getString(2));
		System.out.print("\t"+"\t"+rs.getString(3));
		System.out.print("\t"+"\t"+rs.getString(4));
		System.out.println("\t"+"\t"+ rs.getString(5));
	}
	
	stmt.close();
	conn.close();
	}
	public static void delete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("delete from employee where ID = 27");
		System.out.println(i + " record(s) deleted");

		stmt.close();
		conn.close();

	}
	
}


