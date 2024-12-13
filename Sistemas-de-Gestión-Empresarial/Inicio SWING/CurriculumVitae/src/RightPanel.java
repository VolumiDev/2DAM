import java.awt.GridLayout;

import javax.swing.JPanel;

public class RightPanel extends JPanel{

	private TopPanel top;
	private BottomPanel bot;
	
	
	RightPanel(){
		super();
		//set layout
		this.setLayout(new GridLayout(2, 1));
		top = new TopPanel();
		this.add(top);
		
		bot = new BottomPanel();
		this.add(bot);
	}
	
}
