package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestPreparedStatements {
	public static void main(String[] args) throws Exception {
		// update();
		//insert();
		 select();
		//delete();
	}

	private static void update() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		int id = 22;
		String fn = "bindu";
		String ln = "bhatiya";

		PreparedStatement ps = conn.prepareStatement("update employee set FNAME = ? , LNAME =? WHERE ID = ?");
		ps.setInt(3, id);
		ps.setString(1, fn);
		ps.setString(2, ln);
		ps.executeUpdate();
		System.out.println("RECORD(S) UPDATED");

		ps.close();
		conn.close();

	}

	private static void insert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		int id = 23;
		String fn = "samay";
		String ln = "raina";
		int sal = 80000;
		int dd = 5;

		PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, fn);
		ps.setString(3, ln);
		ps.setInt(4, sal);
		ps.setInt(5, dd);
		ps.executeUpdate();
		System.out.println("RECORD(S) INSERTED");

		ps.close();
		conn.close();

	}

	private static void select() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from employee ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.println("\t" + rs.getString(5));

		}

		ps.close();
		conn.close();

	}

	private static void delete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		int id = 26;
		
		PreparedStatement ps = conn.prepareStatement("delete from employee where ID = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("RECORD(S) DELETED");

		ps.close();
		conn.close();

	}

}
