import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.image.ComponentSampleModel;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InDateComponents extends JPanel{

	private JTextField[] inputs;
	private JLabel[] lbls;

	
	InDateComponents(){
		super();
		this.setLayout(new FlowLayout());
		
		Component[] components = new Component[5];
		for (int i = 0; i < components.length; i++) {
			if(i == 1 || i == 3) {
				components[i] = new JLabel("/");
				this.add(components[i]);
			}else {
				components[i] = new JTextField(3);
				this.add(components[i]);
			}
		}
	}
}
