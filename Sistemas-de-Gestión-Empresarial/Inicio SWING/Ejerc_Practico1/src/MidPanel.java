import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MidPanel extends JPanel{

	private JButton exe;
	private JButton cancel;
	
	public MidPanel() {
		// TODO Auto-generated constructor stub
		super();
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		exe = new JButton("Ejecutar");
		this.add(exe);
		
		cancel= new JButton("Cancelar");
		this.add(cancel);
	}
}
