import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class NPanel extends JPanel{

	private JLabel tirada;
	
	NPanel(){
		super();
	
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		tirada = new JLabel("Tirada: 0 / 3");
		tirada.setBorder(new EmptyBorder(20,20,20,20));
		this.add(tirada);
	}

	public JLabel getTirada() {
		return tirada;
	}

	public void setTirada(JLabel tirada) {
		this.tirada = tirada;
	}
	
}
