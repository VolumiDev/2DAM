import java.net.ConnectException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Tools {

	public ResultSet getUsers() throws ClassNotFoundException, SQLException {
		String sql = "SELECT Nombre from resultados";
		Conect con = new Conect();
		ResultSet rs = con.query(sql);
		con.close();
		return rs;
	}
	
	
	
	
}
