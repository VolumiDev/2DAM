import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWin extends JFrame{
	
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem[] opcionesSubmenu; 
	
	MainWin(){
		super();
		String[] titulosSubmenu = {"Animales", "Comida", "Lugares"};
		barraMenu = new JMenuBar();
		menu = new JMenu("Vocabulario");
		opcionesSubmenu = new JMenuItem[3];
		for (int i = 0; i < opcionesSubmenu.length; i++) {
			opcionesSubmenu[i] = new JMenuItem(titulosSubmenu[i]);
			menu.add(opcionesSubmenu[i]);
			opcionesSubmenu[i].setActionCommand("crucigrama" + i);
			opcionesSubmenu[i].addActionListener(new Escucha(this));
		}
		barraMenu.add(menu);
		
		this.setJMenuBar(barraMenu); 
	}
}
