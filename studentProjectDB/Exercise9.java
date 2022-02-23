package studentProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exercise9 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String sql="select st_no,st_name,MIN((select Datediff(SYSdate(),"
				+ "Student.st_dob)/365)) as age from Student Order BY age";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentProjectDB", "root", "root");
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			System.out.println("Youngest Student");
			System.out.println("******************");
			System.out.println("Student No:"+rs.getString(1));
			System.out.println("Student Name:"+rs.getString(2));
			System.out.println("Age:"+rs.getInt(3));
			
	}

}
}
