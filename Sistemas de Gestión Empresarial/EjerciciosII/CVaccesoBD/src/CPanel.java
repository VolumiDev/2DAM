import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CPanel extends JPanel{

	private JTextField[] inputs;
	private JRadioButton[] radios;
	private JTextArea datosInteres;
	
	public CPanel() {
		// TODO Auto-generated constructor stub
		super();
		
		inputs = new JTextField[3];
		radios = new JRadioButton[2];
		datosInteres= new JTextArea();
		
		for (int i = 0; i < inputs.length; i++) {
			
		}
	}
}
