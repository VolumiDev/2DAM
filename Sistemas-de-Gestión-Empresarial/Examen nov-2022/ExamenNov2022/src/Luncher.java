import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Luncher extends JFrame{

	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem evaluation;
	private JMenuItem exit;
	
	
	public Luncher() {
		super();
		// TODO Auto-generated constructor stub
		//MENU
		menuInit();
	}
	
	// INICALIZAMOS LOS MENUS
	private void menuInit() {
		// TODO Auto-generated method stub
		menubar = new JMenuBar();
		menu = new JMenu("MENU");
		evaluation = new JMenuItem("Evaluación inicial");
		evaluation.addActionListener(new Listener(this));
		evaluation.setActionCommand("btnEvaluation");
		exit = new JMenuItem("Salir");
		exit.addActionListener(e-> System.exit(0));
		
		menu.add(evaluation);
		menu.add(exit);
		
		menubar.add(menu);
		
		this.setJMenuBar(menubar);
	}
	
}
