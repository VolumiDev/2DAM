import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Escucha implements ActionListener {

	private MainWin v;
	private InternalProveedor internal;

	public Escucha(MainWin mw) {
		// TODO Auto-generated constructor stub
		v = mw;
	}

	public Escucha(InternalProveedor internalCrear) {
		// TODO Auto-generated constructor stub
		internal = internalCrear;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.err.println(command);
		switch (e.getActionCommand()) {
		case "Crear Proveedor":
			try {
				InternalProveedor crearProvFrame = new InternalProveedor(v,1);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Consultar Proveedor":
			try {
				InternalProveedor crearProvFrame = new InternalProveedor(v,2);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Actualizar Proveedor":
			try {
				InternalProveedor crearProvFrame = new InternalProveedor(v,3);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Borrar Proveedor":
			try {
				InternalProveedor crearProvFrame = new InternalProveedor(v,4);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Crear Articulo":
			try {
				InternalProducto crearProvFrame = new InternalProducto(v,1);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Consultar Articulo":
			try {
				InternalProducto crearProvFrame = new InternalProducto(v,2);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "Actualizar Articulo":
			try {
				InternalProducto crearProvFrame = new InternalProducto(v,3);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
