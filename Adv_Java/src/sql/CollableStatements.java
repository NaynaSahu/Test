package sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

public class CollableStatements {
	public static void main(String[] args) throws Exception {
					Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testrays", "root", "root");

			CallableStatement callStmt= conn.prepareCall("{CALL empCount(?)}");
			callStmt.registerOutParameter(1, Types.INTEGER);
			callStmt.execute();
			 int count = callStmt.getInt(1);
			 System.out.println("Count = "+ count);
			
			conn.close();

		}


	}
	


