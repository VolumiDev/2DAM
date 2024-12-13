import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class User {

	private String name;
	private String date;
	private String sex;
	private double q1;
	private double q2;
	private double q3;
	private double q4;
	private double score;
	private int tries;
	
	public User(String name, String date, String sex, double q1, double q2, double q3, double q4, double score) throws ClassNotFoundException, SQLException {
		
		this.name = name;
		this.date = date;
		this.sex = sex;
		this.q1 = 0;
		this.q2 = 0;
		this.q3 = 0;
		this.q4 = 0;
		this.score = 0;
		this.tries = 0;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String date, String sex) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.date = date;
		this.sex = sex;
		this.q1 = 0;
		this.q2 = 0;
		this.q3 = 0;
		this.q4 = 0;
		this.score = 0;
		this.tries = 0;
	}
	
	
	

	public void insertNewUser(JInternalFrame internalW) throws ClassNotFoundException, SQLException {
		Conect con = new Conect();
		String sql = "INSERT into resultados VALUES ('"+this.name+"', '"+this.date+"', '"+this.sex+"', "+this.q1+", "+this.q2+", "+this.q3+", "+this.q4+", "+this.score+", "+this.tries+")";
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
	
	public void userUpdate() throws ClassNotFoundException, SQLException {
		Conect c = new  Conect();
		String sql= "update resultados set Intentos = "+tries+", Pregunta1 = "+q1+", Pregunta2 = "+q2+", Pregunta3 = "+q3+", Pregunta4 = "+q4+", Puntos = "+score+" where Nombre like '"+this.name+"'";
		c.update(sql);
		c.close();
	}
	
	
	public User getUserData(String name) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * from resultados where nombre like '"+name+"'";
		Conect con = new Conect();
		User u = new User();
		ResultSet rs = con.query(sql);
		while(rs.next()) {
			this.name = rs.getString(1);
			this.date = rs.getString(2);
			this.sex = rs.getString(3);
			this.q1 = rs.getDouble(4);
			this.q2 = rs.getDouble(5);
			this.q3 = rs.getDouble(6);
			this.q4 = rs.getDouble(7);
			this.score = rs.getDouble(8);
			this.tries = rs.getInt(9);
		}
		con.close();
		return u;
	}
	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getQ1() {
		return q1;
	}

	public void setQ1(double q1) {
		this.q1 = q1;
	}

	public double getQ2() {
		return q2;
	}

	public void setQ2(double q2) {
		this.q2 = q2;
	}

	public double getQ3() {
		return q3;
	}

	public void setQ3(double q3) {
		this.q3 = q3;
	}

	public double getQ4() {
		return q4;
	}

	public void setQ4(double q4) {
		this.q4 = q4;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getTries() {
		return tries;
	}

	public void setTries(int tries) {
		this.tries = tries;
	}
	
}
