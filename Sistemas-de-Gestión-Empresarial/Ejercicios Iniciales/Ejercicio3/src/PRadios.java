import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class PRadios extends JPanel{

	private JLabel lblFondo, lblAlineacion;
	private JRadioButton[] radFondo;
	private JRadioButton[] radAlineacion;
	
	
	
	PRadios(Ventana v){
		super();
		
		ClaseEscuchadora ce = new ClaseEscuchadora(v);
		
		Font fuente = new Font("courier", Font.BOLD, 15);
		
		this.setLayout(new GridLayout(1, 2));
		
		//panel del opciones de fondo
		JPanel pFondo = new JPanel();
		pFondo.setLayout(new FlowLayout(FlowLayout.LEFT));
		//etiqueta
		lblFondo = new JLabel("Fondo", SwingConstants.LEFT);
		lblFondo.setFont(fuente);
		lblFondo.setForeground(Color.BLUE);
		
		pFondo.add(lblFondo);
		//margen bajo titulo
		JPanel marginBot1 = new JPanel();
		marginBot1.setPreferredSize(new Dimension(150,10));
		pFondo.add(marginBot1);
		//radios con las opciones
		radFondo = new JRadioButton[2];
		ButtonGroup fondoGroup = new ButtonGroup();
		radFondo[0] = new JRadioButton("Rojo");
		radFondo[1] = new JRadioButton("Verde");
		for (int i = 0; i < radFondo.length; i++) {
			fondoGroup.add(radFondo[i]);
			pFondo.add(radFondo[i]);
			radFondo[i].addActionListener(ce);
		}
		radFondo[0].setActionCommand("fondoRojo");
		radFondo[1].setActionCommand("fondoVerde");
		this.add(pFondo);
		
		
		
		
		//PANEL CON LAS OPCIONES DE ALINEACION
		
		JPanel pAli = new JPanel();
		lblAlineacion = new JLabel("Alineacion", SwingConstants.CENTER);
		lblAlineacion.setPreferredSize(new Dimension(150, 18));
		lblAlineacion.setFont(fuente);
		
		pAli.add(lblAlineacion);
		//MARGEN BAJO TITULO
		JPanel marginBot = new JPanel();
		marginBot.setPreferredSize(new Dimension(150,10));
		pAli.add(marginBot);
		radAlineacion = new JRadioButton[3];
		ButtonGroup aliGroup = new ButtonGroup();
		radAlineacion[0] = new JRadioButton("Izq");
		radAlineacion[1] = new JRadioButton("Center");
		radAlineacion[2] = new JRadioButton("Derch");
		for (int i = 0; i < radAlineacion.length; i++) {
			aliGroup.add(radAlineacion[i]);
			pAli.add(radAlineacion[i]);
			radAlineacion[i].addActionListener(ce);
		}
		
		radAlineacion[0].setActionCommand("izq");
		radAlineacion[1].setActionCommand("center");
		radAlineacion[2].setActionCommand("der");

		
		this.add(pAli);
	}



	public JLabel getLblFondo() {
		return lblFondo;
	}



	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}



	public JLabel getLblAlineacion() {
		return lblAlineacion;
	}



	public void setLblAlineacion(JLabel lblAlineacion) {
		this.lblAlineacion = lblAlineacion;
	}



	public JRadioButton[] getRadFondo() {
		return radFondo;
	}



	public void setRadFondo(JRadioButton[] radFondo) {
		this.radFondo = radFondo;
	}



	public JRadioButton[] getRadAlineacion() {
		return radAlineacion;
	}



	public void setRadAlineacion(JRadioButton[] radAlineacion) {
		this.radAlineacion = radAlineacion;
	}
	
}
