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
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 350);
		this.setLayout(new BorderLayout());
		
		//north
		northLbl = new JLabel("¿Desea ejecutar el archivo?");
		northLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
		northLbl.setBackground(Color.RED);

		this.add(northLbl, BorderLayout.NORTH);
		
		//center
		centerPanel = new CenterPanel();
		centerPanel.setBackground(Color.BLUE);

		this.add(centerPanel, BorderLayout.CENTER);
		
		//south
		southPanel = new SouthPanel();
		southPanel.setBackground(Color.YELLOW);
		
		this.add(southPanel, BorderLayout.SOUTH);
		
//		this.setResizable(false);
		this.setVisible(true);
	}
}
