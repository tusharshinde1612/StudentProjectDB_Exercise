package studentProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Excercise6 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql="select st_no,st_name,(select Datediff(SYSdate(),"
				+ "Student.st_dob)/365) as age from Student "
				+ "where Student.st_no In (select st_no from "
				+ "StudentProject where prj_no='p02')";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentProjectDB", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			//System.out.println("Below are students who developed their project in Java");
			System.out.println("Student No:"+rs.getString(1));
			System.out.println("Student Name:"+rs.getString(2));
			System.out.println("Age:"+rs.getInt(3));
			System.out.println("******************");
		}
	}

}
