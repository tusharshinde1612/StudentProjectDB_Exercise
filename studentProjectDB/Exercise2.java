package studentProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Project";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentProjectDB", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println(rs.getString(4));
			System.out.println("******************");
		}
	}

}
