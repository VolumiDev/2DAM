import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

public class Producto {
	private int ref, stock, codProveedor;
	private String articulo, descripcion;
	private double precio;

	public int calcularPk() throws ClassNotFoundException, SQLException {
		int pk = -1;
		Conexion con = new Conexion();
		String sql = "select count(*) from productos";
		ResultSet rs = con.consulta(sql);
		while (rs.next()) {
			if (rs.getInt(1) == 0) {
				pk = 1;
			} else {
				sql = "select * from productos order by ref desc limit 1";
				rs = con.consulta(sql);
				while (rs.next()) {
					pk = rs.getInt(1) + 1;
				}
			}
		}
		con.cerrar();
		return pk;
	}

	public Producto consultarProducto(int codigo) throws ClassNotFoundException, SQLException {
		Conexion con = new Conexion();
		Producto p = new Producto();
		String sql = "Select * from productos where ref = " + codigo;
		ResultSet rs = con.consulta(sql);
		while (rs.next()) {
			p.setRef(rs.getInt(1));
			p.setArticulo(rs.getString(2));
			p.setDescripcion(rs.getString(3));
			p.setPrecio(rs.getDouble(4));
			p.setStock(rs.getInt(5));
			p.setCodProveedor(rs.getInt(6));
		}
		con.cerrar();
		return p;
	}

	public int insertarProducto() throws SQLException, ClassNotFoundException {
		Conexion con = new Conexion();
		String sql = "insert into productos values(" + ref + ",'" + articulo + "','" + descripcion + "'," + precio + ","
				+ stock + "," + codProveedor + ")";
		int check = con.actualizar(sql);
		con.cerrar();
		return check;
	}

	public int borrarProducto(int codProd) throws ClassNotFoundException, SQLException {
		int check;
		Conexion con = new Conexion();
		String sql = "delete from productos where codprov = " + codProd;
		check = con.actualizar(sql);
		con.cerrar();
		return check;
	}

	public int actualizarProduccto(int CodProd) throws ClassNotFoundException, SQLException {
		int check;
		Conexion con = new Conexion();
		String sql = "UPDATE proveedores SET articulo='" + this.articulo + "',descrip='" + this.descripcion
				+ "',precio =" + this.precio + ",stock=" + this.stock + ",CodProv=" + codProveedor + " WHERE ref ="
				+ CodProd;
		check = con.actualizar(sql);
		con.cerrar();
		return check;
	}

	public ArrayList<Proveedor> listaProveedores() throws ClassNotFoundException, SQLException {
		ArrayList<Proveedor> list = new ArrayList<Proveedor>();
		Conexion con = new Conexion();
		String sql = "select * from proveedores";
		ResultSet rs = con.consulta(sql);
		while (rs.next()) {
			boolean estado;
			if(rs.getInt(4) == 1) {
				estado = true;
			}else {
				estado = false;
			}
			Proveedor p = new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), estado);
			list.add(p);
		}
		con.cerrar();
		return list;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
