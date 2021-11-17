
package MarksheetTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksheetModel {

	public static void add(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,?)");
			ps.setInt(1, bean.getId());
			ps.setString(2, bean.getRollNo());
			ps.setString(3, bean.getFname());
			ps.setString(4, bean.getLname());
			ps.setInt(5, bean.getPhy());
			ps.setInt(6, bean.getChem());
			ps.setInt(7, bean.getMath());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException E) {

		}
		conn.commit();
		System.out.println("RECORD(S) INSERTED");

		conn.close();

	}

	public static void select() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet ");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.println("\t" + rs.getString(7));

		}

		ps.close();
		conn.close();

	}

	public static void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("update employee set FNAME = ? , LNAME =? WHERE ID = ?");
		try {
			ps.setString(1, bean.getFname());
			ps.setString(2, bean.getLname());
			ps.setInt(3, bean.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		System.out.println("RECORD(S) UPDATED");
		conn.close();

	}

	public static void delete(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		try {
			ps.setInt(1, bean.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			conn.rollback();
		}
		System.out.println("RECORD(S) DELETED");
		conn.close();

	}

}
