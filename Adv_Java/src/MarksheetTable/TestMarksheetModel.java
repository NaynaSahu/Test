package MarksheetTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {
		select();
	}
	
	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setChem(78);
		bean.setFname("RAMESH");
		bean.setId(108);
		bean.setLname("PATIDAR");
		bean.setMath(79);
		bean.setPhy(90);
		bean.setRollNo("8");
		
		MarksheetModel.add(bean);
	}
	
	private static void select() throws Exception {
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
	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(5);;
		
		MarksheetModel.update(bean);
	}
	public static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(5);;
		
		MarksheetModel.delete(bean);
	}
	
}