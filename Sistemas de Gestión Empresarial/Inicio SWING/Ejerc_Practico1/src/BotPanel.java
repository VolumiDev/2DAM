import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BotPanel extends JPanel{
	private JCheckBox ck_question;
	
	public BotPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		ck_question = new JCheckBox("<html>Preguntar siempre antes de abrir este archivo</html>");
		ck_question.setPreferredSize(new Dimension(200,60));
		this.add(ck_question);
	}
}
