import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CenterPanel extends JPanel {

	private TopPanel p_top;
//	private MidPanel p_mid;
//	private BotPanel p_bot;
	
	
	public CenterPanel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new FlowLayout());
		p_top = new TopPanel();
		p_top.setPreferredSize(new Dimension(500, 250));
		this.add(p_top);
	}
	
}
