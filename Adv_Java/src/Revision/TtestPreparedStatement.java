package Revision;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

		

public class TtestPreparedStatement {
	public static void Select() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");
        
        PreparedStatement ps =  conn.prepareStatement("Select * from employee");
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        	System.out.print(rs.getString(1));
        	System.out.print("\t"+"\t"+rs.getString(2));
        	System.out.print("\t"+"\t"+rs.getString(3));
        	System.out.print("\t"+"\t"+rs.getString(4));
        	System.out.println("\t"+"\t"+rs.getString(5));
			
		}
        ps.close();
        conn.close();
		
	}
	public static void main(String[] args) throws Exception {
		
	}
}
