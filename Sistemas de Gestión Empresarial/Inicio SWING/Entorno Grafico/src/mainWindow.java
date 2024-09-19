import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class mainWindow extends JFrame{

	private JLabel name_label;
	private JTextField name_input;
	
	// cada uno de los elementos de esta ventana serán los atributos de la clase
	
	
	public mainWindow(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(650, 200, 300, 450);
		
		//devuelve el interior del jFrame (espacio donde vamos a insertar componentes)
		
		// antes de añadir componentes tenemos que asignar un layout
		this.getContentPane().setLayout(null);
		
		name_label = new JLabel("Introduce tu nombre");
		name_input = new JTextField(10);
		
		name_label.setBounds(50, 50,100,15);
		name_input.setBounds(100,200, 15, 15);
		
		
		this.getContentPane().add(name_label);
		this.getContentPane().add(name_input);
		
		
		this.getContentPane().setBackground(Color.cyan);
		this.setVisible(true);
	}
	
	
}
