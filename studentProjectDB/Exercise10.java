package studentProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise10 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from student where st_no In"
				+ "(select st_no from StudentProject where prj_no "
				+ "In (select prj_no from studentProject group by "
				+ "prj_no Having count(distinct st_no)=3))";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentProjectDB", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			
			System.out.println("Student No:"+rs.getString(1));
			System.out.println("Student Name:"+rs.getString(2));
			System.out.println("Dob:"+rs.getDate(3));
			System.out.println("Doj:"+rs.getDate(4));
			System.out.println("******************");
	}

}
}