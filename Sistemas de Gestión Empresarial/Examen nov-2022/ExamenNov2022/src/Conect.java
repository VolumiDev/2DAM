import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conect {

	private Connection con;
	
	Conect() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/ Encuesta ";
		con = DriverManager.getConnection(url, "root", "");
	}
	
	public ResultSet query(String sql) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}	
	
	public int update(String sql) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = con.createStatement();
		int chk = stmt.executeUpdate(sql);
		return chk;
	}
	
	public void close() throws SQLException {
		con.close();
	}
}
