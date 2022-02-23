package studentProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql="select st_no,count(*) from StudentProject Group by st_no Having count(prj_no)>1 ";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentProjectDB", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Student_No:"+rs.getString(1));
			System.out.println("count:"+rs.getInt(2));
			System.out.println("******************");
		}
	}

}
