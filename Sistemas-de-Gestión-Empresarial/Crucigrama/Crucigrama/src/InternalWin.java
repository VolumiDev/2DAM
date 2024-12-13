import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class InternalWin extends JInternalFrame{

	private MainWin mw;
	private JLabel[] imagenes;
	private JLabel titCrucigrama;
	private JPanel crucigramaPanel;
	private JTextField[][] crucigrama;
	private JButton corregir;
	private JButton cerrar;
	private JPanel north, west, east, south; 
	
	public InternalWin(MainWin mw) throws ParseException {
		super();
		// TODO Auto-generated constructor stub
		this.mw = mw;
		north = new JPanel();
		west= new JPanel();
		east = new JPanel();
		south = new JPanel();
		
		
		this.iconosAnimales();
		this.crucigrama();
		

		
		corregir = new JButton("Corregir");
		cerrar = new JButton("Cerrar");
		cerrar.addActionListener(e -> this.dispose());
		corregir.setActionCommand("corregir");
		corregir.addActionListener(new Escucha(mw,crucigrama));
		
		south.add(corregir);
		south.add(cerrar);
		
	}

	
	private void iconosAnimales() {
		
		west.setPreferredSize(new Dimension(300,500));
		east.setPreferredSize(new Dimension(300,500));
		
		this.setTitle("Crucigrama Animales");
		this.setLayout(new BorderLayout());
		titCrucigrama = new JLabel("Crucigrama de animales");
		this.add(titCrucigrama, BorderLayout.NORTH);
		String[] fotos = {"1a.png", "2a.png", "3a.png", "4a.png", "5a.png", "55a.png", "6a.png", "7a.png", "8a.png", "9a.png"};
		ImageIcon[] iconos = new ImageIcon[fotos.length];
		imagenes = new JLabel[fotos.length];
		for (int i = 0; i < imagenes.length; i++) {
			 iconos[i] = new ImageIcon(fotos[i]);
			imagenes[i] = new JLabel(iconos[i]);
		}
		
		for (int i = 0; i < imagenes.length; i++) {
			if(i >= 0 && i <= 2) {
				north.add(imagenes[i]);
			}else if(i == 3 || i == 4) {
				west.add(imagenes[i]);
			}else if(i == 5 || i == 6) {
				east.add(imagenes[i]);
			}else {
				south.add(imagenes[i]);
			}
		}
		
		this.add(north, BorderLayout.NORTH);
		this.add(west, BorderLayout.WEST);
		this.add(east, BorderLayout.EAST);
		this.add(south, BorderLayout.SOUTH);
		
				
		this.setVisible(true);
		mw.getContentPane().removeAll();
		mw.getContentPane().add(this);
	}
	
	private void crucigrama() throws ParseException {
		
	
		MaskFormatter mascara = new MaskFormatter("U");
		
		
		crucigramaPanel = new JPanel();
		crucigramaPanel.setPreferredSize(new Dimension(400, 533));
		Border marco = BorderFactory.createLineBorder(Color.BLUE, 5, true);
		crucigramaPanel.setBorder(marco);
		crucigramaPanel.setLayout(new GridLayout(16, 12));
		crucigrama = new JTextField[16][12];
		for (int i = 0; i < crucigrama.length; i++) {
			for (int j = 0; j < crucigrama[i].length; j++) {
				if(i == 0 && (j >= 5 && j <= 11)) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");
					crucigramaPanel.add(crucigrama[i][j]);
				}else if( i == 1 && j == 5) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 2 && (j >= 2 && j <= 5)) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 3 && j == 3) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 4 && (j >= 3 && j <= 11)) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 5 && j == 3) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 6 && (j >= 2 && j <= 5)) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 7 && (j == 3 || j == 5)) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 8 && j == 5) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 9 && j == 5) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 10 && (j >= 2 && j <= 6)) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 11 && j == 4) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 12 && j == 4) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 13 && (j >= 0 && j <= 4)) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 14 && j == 4) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else if(i == 15 && j == 4) {
					crucigrama[i][j] = new JFormattedTextField(mascara);
					crucigrama[i][j].setText(" ");

					crucigramaPanel.add(crucigrama[i][j]);
				}else {
					JLabel vacio = new JLabel(" ");
					crucigramaPanel.add(vacio);
				}
			}
		}
		
		this.add(crucigramaPanel, BorderLayout.CENTER);
		
	}
	
}
