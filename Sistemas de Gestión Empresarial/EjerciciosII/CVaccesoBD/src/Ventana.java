import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	private WPanel westPanel;
	private CPanel centerPanel;
	private SPanel southPanel;
	
	public Ventana() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		super();
		this.setBounds(300, 300, 400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
		westPanel = new WPanel();
		this.getContentPane().add(westPanel, BorderLayout.WEST);
		
		
		centerPanel = new CPanel();
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		
		southPanel = new SPanel(this);
		southPanel.setPreferredSize(new Dimension(400,50));
		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		
	}

	public WPanel getWestPanel() {
		return westPanel;
	}

	public void setWestPanel(WPanel westPanel) {
		this.westPanel = westPanel;
	}

	public CPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(CPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public SPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(SPanel southPanel) {
		this.southPanel = southPanel;
	}
	
}
