package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) throws Exception{
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

}
