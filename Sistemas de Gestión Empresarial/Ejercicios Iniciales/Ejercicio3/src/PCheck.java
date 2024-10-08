import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PCheck extends JPanel {
	
	private JCheckBox[] jchecks;
	private JButton btnAutor;
	
	public PCheck(Ventana v) {
		// TODO Auto-generated constructor stub
		super();
		
		ClaseEscuchadora ce = new ClaseEscuchadora(v);
		this.setLayout(new GridLayout(1, 2));
		
		JPanel cheks = new JPanel();
		cheks.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		jchecks = new JCheckBox[2];
		 
		jchecks[0] = new JCheckBox("Cursiva");
		jchecks[0].setFont(new Font("sans", Font.ITALIC, 8));
		jchecks[1] = new JCheckBox("Negrita");
		jchecks[1].setFont(new Font("sans", Font.BOLD, 8));
		
		for (int i = 0; i < jchecks.length; i++) {
			cheks.add(jchecks[i]);
			jchecks[i].setPreferredSize(new Dimension(150,10));
			jchecks[i].addActionListener(ce);
		}
		
		this.add(cheks);
		
		
		JPanel boton = new JPanel();
		boton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		btnAutor = new JButton("Autor");
		btnAutor.setFont(new Font("sans", Font.BOLD, 12));
		
		btnAutor.addActionListener(ce);
		btnAutor.setActionCommand("btnAutor");
		
		boton.add(btnAutor);

		this.add(boton);
	}

	public JCheckBox[] getJchecks() {
		return jchecks;
	}

	public void setJchecks(JCheckBox[] jchecks) {
		this.jchecks = jchecks;
	}

	public JButton getBtnAutor() {
		return btnAutor;
	}

	public void setBtnAutor(JButton btnAutor) {
		this.btnAutor = btnAutor;
	}
	
}
