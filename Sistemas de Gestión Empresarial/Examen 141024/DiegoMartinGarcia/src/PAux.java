import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PAux extends JPanel{

	private JLabel lbl1, lbl2;
	private JTextField txt1;
	private JRadioButton[] radios;
	
	
	public PAux(int tipo) {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(450,70));
		this.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		
		if(tipo == 1) {
			banquete();
		}else {
			congreso();
		}
		
	}
	
	public void banquete() {
		String[] titulos = {"Cuadradas", "Redondas"};		
		lbl1 = new JLabel("Numero Comensales:");
		lbl1.setPreferredSize(new Dimension(150,20));
		this.add(lbl1);
		
		txt1 = new JTextField(25);
		this.add(txt1);
		
		lbl2 = new JLabel("Tipo Mesa:");
		lbl2.setPreferredSize(new Dimension(150,20));
		this.add(lbl2);
		
		radios = new JRadioButton[2];
		ButtonGroup radiosGrupo = new ButtonGroup();
		
		for (int i = 0; i < radios.length; i++) {
			radios[i] = new JRadioButton(titulos[i]);
			radiosGrupo.add(radios[i]);
			radios[i].setPreferredSize(new Dimension(100,20));
			this.add(radios[i]);
		}
	}
	
	public void congreso() {
		String[] titulos = {"Si", "No"};		
		lbl1 = new JLabel("Numero Jornadas:");
		lbl1.setPreferredSize(new Dimension(150,20));
		this.add(lbl1);
		
		txt1 = new JTextField(25);
		this.add(txt1);
		
		lbl2 = new JLabel("Requiere Habitaciones:");
		lbl2.setPreferredSize(new Dimension(150,20));
		this.add(lbl2);
		
		radios = new JRadioButton[2];
		ButtonGroup radiosGrupo = new ButtonGroup();
		
		for (int i = 0; i < radios.length; i++) {
			radios[i] = new JRadioButton(titulos[i]);
			radiosGrupo.add(radios[i]);
			radios[i].setPreferredSize(new Dimension(100,20));
			this.add(radios[i]);
		}
	}

	public JLabel getLbl1() {
		return lbl1;
	}

	public void setLbl1(JLabel lbl1) {
		this.lbl1 = lbl1;
	}

	public JLabel getLbl2() {
		return lbl2;
	}

	public void setLbl2(JLabel lbl2) {
		this.lbl2 = lbl2;
	}

	public JTextField getTxt1() {
		return txt1;
	}

	public void setTxt1(JTextField txt1) {
		this.txt1 = txt1;
	}

	public JRadioButton[] getRadios() {
		return radios;
	}

	public void setRadios(JRadioButton[] radios) {
		this.radios = radios;
	}
}
