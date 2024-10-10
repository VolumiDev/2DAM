import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	private WPanel westPanel;
	private CPanel centerPanel;
	private SPanel southPanel;
	
	public Ventana() {
		// TODO Auto-generated constructor stub
		super();
		this.setBounds(300, 300, 400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
		westPanel = new WPanel();
		this.getContentPane().add(westPanel, BorderLayout.WEST);
		
		
		centerPanel = new CPanel();
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		
		southPanel = new SPanel();
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
	}
	
}
