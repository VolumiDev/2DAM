import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainW extends JFrame{
	private JLabel lbl_title;
	private JPanel buttons;
	private CenterView center_view;
	
	public MainW() {
		// TODO Auto-generated constructor stub
		super();
		//seteamos el Layout
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		
		// posicion y tamaño
		this.setBounds(200, 200, 400, 420);
		this.setResizable(false);
		
		//titulo 
		this.setTitle("Curriculum Vitae");
		lbl_title = new JLabel("PORFAVOR, RELLENA LOS DATOS DE TU CURRICULUM");
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lbl_title, BorderLayout.NORTH);
		
		//add buttons
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		JButton insert = new JButton("Insertar Datos");
		JButton cancel = new JButton("Cancelar");
		buttons.add(insert);
		buttons.add(cancel);
		this.getContentPane().add(buttons, BorderLayout.SOUTH);
		
		//set center view
		center_view = new CenterView();
		this.getContentPane().add(center_view, BorderLayout.CENTER);
		
		
		
		this.setVisible(true);
		
	}
	
}
