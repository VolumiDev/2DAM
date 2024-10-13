import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.http.WebSocketHandshakeException;

import javax.swing.JFrame;

public class Ventana extends JFrame{

	private nPanel northPanel;
	private wPanel westPanel;
	private ePanel eastPanel;
	private sPanel southPanel;
	
	Ventana(){
		super();
		this.setBounds(300,300,500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		northPanel = new nPanel();
		this.getContentPane().add(northPanel, BorderLayout.NORTH);
		
		westPanel = new wPanel();
		westPanel.setPreferredSize(new Dimension(250,300));
		this.getContentPane().add(westPanel, BorderLayout.WEST);
		
		eastPanel = new ePanel();
		eastPanel.setPreferredSize(new Dimension(250,300));
		this.getContentPane().add(eastPanel, BorderLayout.EAST);
		
		southPanel = new sPanel(this);
		southPanel.setPreferredSize(new Dimension(250,50));
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
	}

	public nPanel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(nPanel northPanel) {
		this.northPanel = northPanel;
	}

	public wPanel getWestPanel() {
		return westPanel;
	}

	public void setWestPanel(wPanel westPanel) {
		this.westPanel = westPanel;
	}

	public ePanel getEastPanel() {
		return eastPanel;
	}

	public void setEastPanel(ePanel eastPanel) {
		this.eastPanel = eastPanel;
	}

	public sPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(sPanel southPanel) {
		this.southPanel = southPanel;
	}
	
}
