import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CenterPanel extends JPanel {

	private TopPanel pNor;
	private MidPanel pCen;
	private BotPanel pSou;
	
	
	public CenterPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		pNor = new TopPanel();
		pNor.setPreferredSize(new Dimension(450, 120));
		this.add(pNor, BorderLayout.NORTH);
		
		pCen = new MidPanel();
		pCen.setPreferredSize(new Dimension(450, 20));
		this.add(pCen, BorderLayout.CENTER);
	
		pSou= new BotPanel();
		pSou.setPreferredSize(new Dimension(450, 60));
		this.add(pSou, BorderLayout.SOUTH);

	}
	
}
