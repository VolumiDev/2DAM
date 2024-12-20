import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display extends JFrame{

	private btnMemory west, center;
	private JTextField view;
	
	public Display() {
		// TODO Auto-generated constructor stub
		super();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.setTitle("Calculadora");
		this.setBounds(200, 200, 500, 400);
		
		//botones de memoria
		west = new btnMemory();
		west.setPreferredSize(new Dimension(60,60));
		west.btnMemo();
		this.getContentPane().add(west,BorderLayout.WEST);
		
		//pantalla
		view = new JTextField(50);
		view.setPreferredSize(new Dimension(300,60));

		this.getContentPane().add(view,BorderLayout.NORTH);
		
		//numeros
		center = new btnMemory();
		center.setPreferredSize(new Dimension(440,60));
		center.btnNum();
		this.getContentPane().add(center,BorderLayout.CENTER);
		
		
		
		this.setVisible(true);
	}
	
}
