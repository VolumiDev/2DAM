import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainW extends JFrame{

	private JPanel buttons;
	private view view;
	
	public mainW() {
		// TODO Auto-generated constructor stub
		super();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setBounds(200, 200, 350, 200);
		this.setTitle("A�adir usuario");
		
		//make buttons and add it to south zone
		buttons = new JPanel();
		buttons.add(new JButton("Aceptar"));
		buttons.add(new JButton("Cancelar"));
		this.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		//make jpanel and add it
		view = new view();
		view.generateLabels();
		this.getContentPane().add(view, BorderLayout.CENTER);
		
		
		this.setVisible(true);
		
	}
}
