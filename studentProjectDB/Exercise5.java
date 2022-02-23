package studentProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql="select count(st_no),st_no,st_name from Student where Student.st_no NOT IN(select st_no from StudentProject)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentProjectDB", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("count of Student:"+rs.getInt(1));
			System.out.println("******************");
			System.out.println("Student_No:"+rs.getString(2));
			System.out.println("Student Name:"+rs.getString(3));
		}
	}

}
