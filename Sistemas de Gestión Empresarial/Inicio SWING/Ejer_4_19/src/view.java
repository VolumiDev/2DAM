import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class view extends JPanel{

	private JLabel name, id, date;
	private JTextField in_name, in_id;
	private JPanel in_date;
	
	
	public view() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new GridLayout(3,2));
	}
	
	//generate components 
	public void generateLabels() {
		name = new JLabel("Nombre:");
		this.add(name);
		in_name = new JTextField();
		this.add(in_name);
		id = new JLabel("DNI:");
		this.add(id);
		in_id = new JTextField();
		this.add(in_id);
		date = new JLabel("Fecha de nacimiento:");
		this.add(date);
		in_date = new JPanel();
		InDateComponents in_date_elements = new InDateComponents();
		this.add(in_date_elements);
		
	}
	
	
}
