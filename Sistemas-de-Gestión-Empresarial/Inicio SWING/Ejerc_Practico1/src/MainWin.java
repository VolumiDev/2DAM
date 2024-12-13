import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainWin extends JFrame{
	
	private JLabel northLbl;
	private CenterPanel centerPanel;
	private SouthPanel southPanel;
	
	
	public MainWin() {
		// TODO Auto-generated constructor stub
		super();
		this.setBounds(100, 100, 500, 370);
		this.setLayout(new BorderLayout(10, 10));
		
		//north
		northLbl = new JLabel("¿Desea ejecutar el archivo?");
		northLbl.setPreferredSize(new Dimension(350, 30));
		northLbl.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(northLbl, BorderLayout.NORTH);
		
		//center
		centerPanel = new CenterPanel();
		centerPanel.setPreferredSize(new Dimension(350, 300));
		this.add(centerPanel, BorderLayout.CENTER);
		
		//south
		southPanel = new SouthPanel();
		centerPanel.setPreferredSize(new Dimension(350, 50));
		this.add(southPanel, BorderLayout.SOUTH);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
	}
}
