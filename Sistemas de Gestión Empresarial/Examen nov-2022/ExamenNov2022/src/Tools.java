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
	
	public ResultSet getUser(String name) throws ClassNotFoundException, SQLException {
		String sql = "SELECT nombre from resultados where nombre like '"+name+"'";
		Conect con = new Conect();
		ResultSet rs = con.query(sql);
		con.close();
		return rs;
	}
	
	public void insertNewUser(JInternalFrame internalW, String name, String date, String sex, double q1, double q2, double q3, double q4, double score, int tries) throws ClassNotFoundException, SQLException {
		Conect con = new Conect();
		String sql = "INSERT into resultado VALUES (name, date, sex, q1, q2, q3, q4, score, tries)";
		if(con.update(sql) == 1) {
			JOptionPane.showMessageDialog(internalW, "Usuario insertado");
		}
		con.close();
	}
	
	public int numTries(String name) throws ClassNotFoundException, SQLException {
		Conect con = new Conect();
		int tries=0;
		String sql = "select Intentos from resultados where Nombre like '"+name+"'";
		ResultSet rs = con.query(sql);
		while(rs.next()) {
			tries = rs.getInt(1);
		}
		con.close();
		return tries;
	}
	
	
	public void userUpdate(String tries, String q1, String q2, String q3, String q4, String score) throws ClassNotFoundException, SQLException {
		Conect c = new  Conect();
		
		String sql= "update resultados set Intentos = "+tries+", Pregunta1 = "+q1+", Pregunta2 = "+q2+", Pregunta3 = "+q3+", Pregunta4 = "+q4+", Score = "+score;
		c.update(sql);
		c.close();
	}
}
