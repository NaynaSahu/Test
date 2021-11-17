package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionHandling {
	public static void main(String[] args) throws Exception {
		// update();
		select();
		//insert();
	}

	private static void update() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		int id = 22;
		String fn = "BINDU";
		String ln = "MAKHIJA";
		try {
			PreparedStatement ps = conn.prepareStatement("update employee set FNAME = ? , LNAME =? WHERE ID = ?");
			ps.setInt(3, id);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			conn.rollback();

		}

		conn.commit();
		System.out.println("RECORD(S) UPDATED");

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
	private static void insert() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		int id = 24;
		String fn = "BINDU";
		String ln = "MAKHIJA";
		int sal = 300000;
		int dd = 4;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee VALUES (?,?,?,?,?)");
			PreparedStatement pss = conn.prepareStatement("insert into employee VALUES (?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, fn);
			ps.setString(3, ln);
			ps.setInt(4, sal);
			ps.setInt(5, dd);
			ps.executeUpdate();
			ps.close();
			pss.setInt(1, id);
			pss.setString(2, fn);
			pss.setString(3, ln);
			pss.setInt(4, sal);
			pss.setInt(5, dd);
			pss.executeUpdate();
			pss.close();
		} catch (SQLException e) {
			conn.rollback();
			System.out.println("not inserted");

		}

		conn.commit();
		System.out.println("RECORD(S) UPDATED");

		conn.close();

	}



}
