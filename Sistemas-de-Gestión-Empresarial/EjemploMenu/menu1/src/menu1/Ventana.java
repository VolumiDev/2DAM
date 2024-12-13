package menu1;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class Ventana extends JFrame{

	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem opc1, opc2, opc3, opc4, opc5;
	private JSeparator[] separator;
	private JPanel internalMenuPanel;
	private VentanaAux auxFrame;
	private InternalFrame intFrame;
	
	Ventana(){
		super();
		crearMenu();
		
	};
	
	
	private void crearMenu() {
		internalMenuPanel = new JPanel();
		
		menubar = new JMenuBar();
		menu = new JMenu("Clientes");
		
		opc1 = new JMenuItem("JFrame externo");
		opc1.setPreferredSize(new Dimension(200,20));

		opc2 = new JMenuItem("Internal Frame");
		opc3 = new JMenu("Submenu 3");
		
		opc4 = new JMenuItem("SubOption 4");
		opc5 = new JMenuItem("SubOption1 5");
		
		separator = new JSeparator[2];
		for (int i = 0; i < separator.length; i++) {
			separator[i] = new JSeparator();
		}
		separator[1].setPreferredSize(new Dimension(-1,1));
	
		menu.add(opc1);
		menu.add(opc2);
		menu.add(separator[1]);
		
		opc3.add(opc4);
		opc3.add(opc5);
		
		menu.add(opc3);
		
		opc1.addActionListener(new Escucha(this));
		opc2.addActionListener(new Escucha(this));
		opc3.addActionListener(new Escucha(this));
		menubar.add(menu);
		
		this.setJMenuBar(menubar);
		
	}


	public JMenuBar getMenubar() {
		return menubar;
	}


	public void setMenubar(JMenuBar menubar) {
		this.menubar = menubar;
	}


	public JMenu getMenu() {
		return menu;
	}


	public void setMenu(JMenu menu) {
		this.menu = menu;
	}


	public JMenuItem getOpc1() {
		return opc1;
	}


	public void setOpc1(JMenuItem opc1) {
		this.opc1 = opc1;
	}


	public JMenuItem getOpc2() {
		return opc2;
	}


	public void setOpc2(JMenuItem opc2) {
		this.opc2 = opc2;
	}


	public JMenuItem getOpc3() {
		return opc3;
	}


	public void setOpc3(JMenuItem opc3) {
		this.opc3 = opc3;
	}


	public JSeparator[] getSeparator() {
		return separator;
	}


	public void setSeparator(JSeparator[] separator) {
		this.separator = separator;
	}
}
