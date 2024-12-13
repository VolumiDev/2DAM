import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EPanel extends JPanel{

	private JLabel lblIcon;
	
	public EPanel(Ventana v) {
		// TODO Auto-generated constructor stub
		ImageIcon image = new ImageIcon("imagenes/1.gif");
		lblIcon = new JLabel(image);
		this.add(lblIcon);
	}

	public JLabel getLblIcon() {
		return lblIcon;
	}

	public void setLblIcon(JLabel lblIcon) {
		this.lblIcon = lblIcon;
	}
	
}
