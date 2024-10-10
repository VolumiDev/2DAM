import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.security.KeyStore.ProtectionParameter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{

	private WPanel westPanel, westPanelC;
	private CPanel centerPanel, centerPanelC;
	private EPanel eastPanel, eastPanelC;
	
	Ventana(){
		super();
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 1));
		
		JPanel pPadding = new JPanel();
		pPadding.setLayout(new GridLayout(2,1));
		pPadding.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		this.getContentPane().add(pPadding);
		
		
		//COMENZAMOS CON EL PANEL ORIGINAL
		JPanel original = new JPanel();
		original.setLayout(new BorderLayout());
		JLabel lblTitulo1 = new JLabel("Original");
		original.add(lblTitulo1, BorderLayout.NORTH);
		
		westPanel = new WPanel(this, "Original");
		original.add(westPanel, BorderLayout.WEST);
		
		centerPanel = new CPanel(this, "Original");
		original.add(centerPanel, BorderLayout.CENTER);
		
		eastPanel = new EPanel(this, "Original");
		original.add(eastPanel, BorderLayout.EAST);
		
		JSeparator separador = new JSeparator();
		original.add(separador, BorderLayout.SOUTH);
		pPadding.add(original);

		
		//COMENZAMOS CON LA COPIA
		JPanel copia = new JPanel();
		copia.setLayout(new BorderLayout());
		JLabel lblTitulCopia = new JLabel("Espejo");
		copia.add(lblTitulCopia, BorderLayout.NORTH);
		
		westPanelC = new WPanel(this, "Copia");
		copia.add(westPanelC, BorderLayout.WEST);
		
		centerPanelC = new CPanel(this, "Copia");
		copia.add(centerPanelC, BorderLayout.CENTER);
		
		eastPanelC = new EPanel(this, "Copia");
		copia.add(eastPanelC, BorderLayout.EAST);
		
		
		
		pPadding.add(copia);
	}

	public WPanel getWestPanel() {
		return westPanel;
	}

	public void setWestPanel(WPanel westPanel) {
		this.westPanel = westPanel;
	}

	public WPanel getWestPanelC() {
		return westPanelC;
	}

	public void setWestPanelC(WPanel westPanelC) {
		this.westPanelC = westPanelC;
	}

	public CPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(CPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public CPanel getCenterPanelC() {
		return centerPanelC;
	}

	public void setCenterPanelC(CPanel centerPanelC) {
		this.centerPanelC = centerPanelC;
	}

	public EPanel getEastPanel() {
		return eastPanel;
	}

	public void setEastPanel(EPanel eastPanel) {
		this.eastPanel = eastPanel;
	}

	public EPanel getEastPanelC() {
		return eastPanelC;
	}

	public void setEastPanelC(EPanel eastPanelC) {
		this.eastPanelC = eastPanelC;
	}
	
}
