import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class Ventana extends JFrame{

	private NPanel northPanel;
	private JugadorPanel westPanel, eastPanel;
	private SPanel southPanel;

	
	
	Ventana(){
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 300, 600, 500);
		this.setLayout(new BorderLayout());
		
		northPanel = new NPanel();
		this.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		
		westPanel = new JugadorPanel(this, "Jugador 1");
		this.add(westPanel, BorderLayout.WEST);
		
		
		eastPanel = new JugadorPanel(this, "Jugador 2");
		this.add(eastPanel, BorderLayout.EAST);
		
		southPanel = new SPanel();
		this.add(southPanel, BorderLayout.SOUTH);
		Escucha esc = new Escucha(this);
		westPanel.getBtn().addActionListener(esc);
		eastPanel.getBtn().addActionListener(esc);
	}



	public NPanel getNorthPanel() {
		return northPanel;
	}



	public void setNorthPanel(NPanel northPanel) {
		this.northPanel = northPanel;
	}



	public JugadorPanel getWestPanel() {
		return westPanel;
	}



	public void setWestPanel(JugadorPanel westPanel) {
		this.westPanel = westPanel;
	}



	public JugadorPanel getEastPanel() {
		return eastPanel;
	}



	public void setEastPanel(JugadorPanel eastPanel) {
		this.eastPanel = eastPanel;
	}



	public SPanel getSouthPanel() {
		return southPanel;
	}



	public void setSouthPanel(SPanel southPanel) {
		this.southPanel = southPanel;
	}
	
}
