import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PRadios extends JPanel{

	private JLabel lblFondo, lblAlineacion;
	private JRadioButton[] radFondo;
	private JRadioButton[] radAlineacion;
	
	
	
	PRadios(){
		super();
		
		Font fuente = new Font("monoespaced", Font.BOLD, 15);
		
		this.setLayout(new GridLayout(1, 2));
		
		JPanel pFondo = new JPanel();
		lblFondo = new JLabel("Fondo");
		lblFondo.setFont(fuente);
		lblFondo.setForeground(Color.BLUE);
		pFondo.setBackground(Color.RED);
		pFondo.setOpaque(true);
		pFondo.add(lblFondo);
		
		this.add(pFondo);
		
		
		
		
		JPanel pAli = new JPanel();
		lblFondo = new JLabel("Fondo");
		lblFondo.setFont(fuente);
		lblFondo.setForeground(Color.BLUE);
		pAli.setBackground(Color.YELLOW);
		pAli.setOpaque(true);
		pAli.add(lblFondo);
		
		this.add(pAli);
	}
}
