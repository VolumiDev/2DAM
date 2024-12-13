import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	private Connection con;
	
	Conexion() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost/" + "tienda"; 
		con = DriverManager.getConnection(url, "root","");
	}
	
	public int actualizar(String sql) throws SQLException {
		int check = -1 ;
		Statement stmt = con.createStatement();
		check = stmt.executeUpdate(sql);
		return check;
	}
	
	public ResultSet consulta(String sql) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	public void cerrar() throws SQLException {
		con.close();
	}
}
