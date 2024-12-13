import java.lang.classfile.ClassFile.AttributesProcessingOption;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Proveedor {

	private int codProv;
	private String nombre;
	private String tipo;
	private boolean activo;

	public Proveedor(int codProv, String nombre, String tipo, boolean activo) {
		this.codProv = codProv;
		this.nombre = nombre;
		this.tipo = tipo;
		this.activo = activo;
	}

	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	public int calcularPk() throws ClassNotFoundException, SQLException {
		int pk = -1;
		Conexion con = new Conexion();
		String sql = "select count(*) from proveedores";
		ResultSet rs = con.consulta(sql);
		while (rs.next()) {
			if (rs.getInt(1) == 0) {
				pk = 1;
			} else {
				sql = "select * from proveedores order by codprov desc limit 1";
				rs = con.consulta(sql);
				while (rs.next()) {
					pk = rs.getInt(1) + 1;
				}
			}
		}
		con.cerrar();
		return pk;
	}

	public Proveedor consultarProveedor(int codigo) throws ClassNotFoundException, SQLException {
		Conexion con = new Conexion();
		Proveedor p = new Proveedor();
		String sql = "Select * from proveedores where codprov = " + codigo;
		ResultSet rs = con.consulta(sql);
		while (rs.next()) {
			p.setCodProv(rs.getInt(1));
			p.setNombre(rs.getString(2));
			p.setTipo(rs.getString(3));
			p.setActivo(rs.getBoolean(4));
		}
		con.cerrar();
		return p;
	}

	public int insertarProveedor()
			throws SQLException, ClassNotFoundException {
		int estado;
		if(activo) {
			estado = 1;
		}else {
			estado = 0;
		}
		Conexion con = new Conexion();
		String sql = "insert into proveedores values(" + codProv + ",'" + nombre + "','" + tipo + "'," + estado + ")";
		int check = con.actualizar(sql);
		con.cerrar();
		return check;
	}

	public int borrarProveedor(int codProv) throws ClassNotFoundException, SQLException {
		int check;
		Conexion con = new Conexion();
		String sql = "delete from proveedores where codprov = " + codProv;
		check = con.actualizar(sql);
		con.cerrar();
		return check;
	}

	public int actualizarProveedor(int CodProv) throws ClassNotFoundException, SQLException {
		int check;
		int estado;
		if(activo) {
			estado = 1;
		}else {
			estado = 0;
		}
		Conexion con = new Conexion();
		String sql = "UPDATE proveedores SET nombre='" + this.nombre + "',tipo='"
				+ this.tipo + "',activo =" + estado + " WHERE codprov =" + CodProv;
		check = con.actualizar(sql);
		con.cerrar();
		return check;
	}
	
	public String toString() {
		return ""+nombre;
	}

	public int getCodProv() {
		return codProv;
	}

	public void setCodProv(int codProv) {
		this.codProv = codProv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
