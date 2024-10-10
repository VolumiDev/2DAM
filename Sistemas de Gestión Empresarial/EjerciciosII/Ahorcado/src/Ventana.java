import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.http.WebSocketHandshakeException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{

	private WPanel westPanel;
	private EPanel eastPanel;
	
	Ventana(){
		
		this.setTitle("Juego del Ahorcado");
		this.setBounds(300, 300, 500, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel PPadding = new JPanel();
		PPadding.setBorder(new EmptyBorder(20,20,20,20));
		this.getContentPane().add(PPadding);
		PPadding.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Menu");
		PPadding.add(title, BorderLayout.NORTH);
		
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(1, 2));
		
		westPanel = new WPanel(this);
		content.add(westPanel);
		
		eastPanel = new EPanel(this);
		content.add(eastPanel);
		
		PPadding.add(content, BorderLayout.CENTER);
		
		
		
	}

	public WPanel getWestPanel() {
		return westPanel;
	}

	public void setWestPanel(WPanel westPanel) {
		this.westPanel = westPanel;
	}

	public EPanel getEastPanel() {
		return eastPanel;
	}

	public void setEastPanel(EPanel eastPanel) {
		this.eastPanel = eastPanel;
	}
	
}
