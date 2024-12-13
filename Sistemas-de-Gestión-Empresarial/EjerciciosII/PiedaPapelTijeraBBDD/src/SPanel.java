import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SPanel extends JPanel{

	private JLabel resultado;
	
	SPanel(){
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		resultado = new JLabel("Que empiece la partida.");
		resultado.setBorder(new EmptyBorder(20,20,20,20));
		this.add(resultado);
		
	}

	public JLabel getResultado() {
		return resultado;
	}

	public void setResultado(JLabel resultado) {
		this.resultado = resultado;
	}
}
