import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWin extends JFrame {

	private JMenuBar menuBar;
	private JMenu[] menuOpcion;
	private JMenuItem[] submenuCliente;
	private JMenuItem[] submenuProducto;
	private JMenuItem[] submenuProveedor;

	public MainWin() {
		// TODO Auto-generated constructor stub
		super();

		String[] titMenu = { "Cliente", "Articulos", "Proveedores" };
		String[] titSubmenu = { "Crear", "Consultar", "Actualizar", "Borrar" };
		// INICIALIZAMOS LOS MENUS
		menuBar = new JMenuBar();
		menuOpcion = new JMenu[3];
		submenuCliente = new JMenuItem[4];
		submenuProducto = new JMenuItem[4];
		submenuProveedor = new JMenuItem[4];

		for (int i = 0; i < menuOpcion.length; i++) {
			menuOpcion[i] = new JMenu(titMenu[i]);
			menuBar.add(menuOpcion[i]);
		}

		configurarSubmenus(submenuCliente, titSubmenu, " Cliente", 0);

		configurarSubmenus(submenuCliente, titSubmenu, " Articulo", 1);

		configurarSubmenus(submenuCliente, titSubmenu, " Proveedor", 2);

		this.setJMenuBar(menuBar);

	}

	private void configurarSubmenus(JMenuItem[] subMenus, String[] titSub, String titOpcion, int optionMenu) {
		for (int i = 0; i < subMenus.length; i++) {
			subMenus[i] = new JMenuItem(titSub[i] + titOpcion);
			menuOpcion[optionMenu].add(subMenus[i]);
			subMenus[i].addActionListener(new Escucha(this));
			subMenus[i].setActionCommand(titSub[i] + titOpcion);
			System.out.println(titOpcion + i);
		}
	}
}
