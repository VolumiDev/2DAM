import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class nPanel extends JPanel{

	private JLabel titulo;
	
	nPanel(){
		super();
		titulo = new JLabel("PORFAVOR, RELLENE LOS DATOS DEL CURRICULUM", SwingConstants.CENTER);
		titulo.setBorder(new EmptyBorder(20,20,20,20));
		this.add(titulo);
		
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}
	
}
