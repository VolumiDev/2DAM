import java.awt.AWTException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Escucha implements ActionListener {

	private MainWin mw;
	private JTextField[][] crucigrama;
	
	public Escucha(MainWin mw) {
		super();
		this.mw = mw;
	}
	public Escucha(MainWin mw, JTextField[][] crucigrama) {
		super();
		this.mw = mw;
		this.crucigrama = crucigrama;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println(command);
		switch(command) {
		case "crucigrama0":
			try {
				generarInternalFrame();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "corregir":
			corregirCrucigrama();
			break;
		}
	}

	
	private void generarInternalFrame() throws ParseException {
		InternalWin iw = new InternalWin(mw);
	}
	
	
	private void corregirCrucigrama() {
		char[][] correccion = generaCorreccionAnimales();
		
		for (int i = 0; i < crucigrama.length; i++) {
			for (int j = 0; j < crucigrama[i].length; j++) {
				if(crucigrama[i][j] instanceof JTextField) {
					System.err.println(crucigrama[i][j].getText());
					if(crucigrama[i][j].getText() != " ") {
						try {
							if(crucigrama[i][j].getText().toUpperCase().trim().charAt(0) == correccion[i][j]) {
								crucigrama[i][j].setBackground(Color.GREEN);
							}else {
								crucigrama[i][j].setBackground(Color.RED);
							}
						}catch (StringIndexOutOfBoundsException e) {
							// TODO: handle exception
						}
						crucigrama[i][j].setOpaque(true);						
					}
				}
			}	
		}
	}
	private char[][] generaCorreccionAnimales(){
		
		String[] palabras = {"DOLPHIN", "O", "FROG", "A", "BUTTERFLY", "B", "FISH","T O", "R", "S", "CAMEL", "O", "N", "SHARK", "E", "Y"};
		
		char[][] correccion = new char[crucigrama.length][crucigrama[0].length];
		
		for (int i = 0; i < correccion.length; i++) {
			for (int j = 0; j < correccion[i].length; j++) {
				if(i == 0 && (j >= 5 && j <= 11)) {
					correccion[i][j] = palabras[0].charAt(j - 5);
				}else if( i == 1 && j == 5) {
					correccion[i][j] = palabras[1].charAt(0);
				}else if(i == 2 && (j >= 2 && j <= 5)) {
					correccion[i][j] = palabras[2].charAt(j - 2);
				}else if(i == 3 && j == 3) {
					correccion[i][j] = palabras[3].charAt(0);
				}else if(i == 4 && (j >= 3 && j <= 11)) {
					correccion[i][j] = palabras[4].charAt(j - 3);
				}else if(i == 5 && j == 3) {
					correccion[i][j] = palabras[5].charAt(0);
				}else if(i == 6 && (j >= 2 && j <= 5)) {
					correccion[i][j] = palabras[6].charAt(j - 2);
				}else if(i == 7 && (j == 3 || j == 5)) {
					if(j == 3) {
						correccion[i][j] = 'T';
					}else {
						correccion[i][j] = 'O';
					}
				}else if(i == 8 && j == 5) {
					correccion[i][j] = palabras[8].charAt(0);
				}else if(i == 9 && j == 5) {
					correccion[i][j] = palabras[9].charAt(0);
				}else if(i == 10 && (j >= 2 && j <= 6)) {
					correccion[i][j] = palabras[10].charAt(j - 2);
				}else if(i == 11 && j == 4) {
					correccion[i][j] = palabras[11].charAt(0);
				}else if(i == 12 && j == 4) {
					correccion[i][j] = palabras[12].charAt(0);
				}else if(i == 13 && (j >= 0 && j <= 4)) {
					correccion[i][j] = palabras[13].charAt(j);
				}else if(i == 14 && j == 4) {
					correccion[i][j] = palabras[14].charAt(0);
				}else if(i == 15 && j == 4) {
					correccion[i][j] = palabras[15].charAt(0);
				}else {
					correccion[i][j] = ' ';
				}
			}
		}
		
//		for (int i = 0; i < correccion.length; i++) {
//			for (int j = 0; j < correccion[i].length; j++) {
//				if(correccion[i][j] == ' ') {
//					System.out.print(' ');
//				}else {
//					System.out.print(correccion[i][j]);
//				}
//			}
//			System.out.println();
//		}
		
		
		return correccion;
	}
	
}
