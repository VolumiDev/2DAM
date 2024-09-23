import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class btnMemory extends JPanel{
	private JButton[] btn;
	
	public btnMemory() {
		super();
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(4, 1, 3, 3));
		
		
		
	}
	
	public void btnMemo() {
		this.setLayout(new GridLayout(4, 1, 3, 3));
		btn = new JButton[4];
		String[] txt = {"MC", "MR","M+", "M-"};
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(txt[i]);
			btn[i].setPreferredSize(new Dimension(60,60));
			this.add(btn[i]);
		}
	}
	
	
	public void btnNum() {
		this.setLayout(new GridLayout(4, 5));
		String[] txt = {"7", "8","9", "/", "sqrt", "4", "5","6", "*", "%", "1", "2","3", "-", "1/x", "0", "+/-",".", "+", "="};
		btn = new JButton[txt.length];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(txt[i]);
			btn[i].setPreferredSize(new Dimension(60,60));
			this.add(btn[i]);
		}
	}
}
