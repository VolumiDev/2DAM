import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WPanel extends JPanel{

	private JLabel lblPalabra, lblIntentos, lblMensajes;
	private JComboBox<String> CBLetras;
	private JButton btnAceptar;
	private JPanel pPalabra;
	private JPanel pIntentos;
	
	public WPanel() {
		
	}
	
	public WPanel(Ventana v) {
		// TODO Auto-generated constructor stub
		
		
		String word = randomWord();
		char[] hidden = hiddenWord(word);
		
		this.setLayout(new GridLayout(4, 1));
		
		
		pPalabra = new JPanel();
		pPalabra.setBorder(BorderFactory.createTitledBorder("Palabra:"));
		lblPalabra = new JLabel();
		reiniciarPalabra(pPalabra, hidden);
		pPalabra.add(lblPalabra);
		this.add(pPalabra);

		
		pIntentos = new JPanel();
		pIntentos.setBorder(BorderFactory.createTitledBorder("Intentos:"));
		lblIntentos = new JLabel();
		reiniciarIntentos(pIntentos);
		pIntentos.add(lblIntentos);
		this.add(pIntentos);
		
		JPanel pLetras = new JPanel();

		pLetras.setBorder(BorderFactory.createTitledBorder("Letras:"));
		
		
		CBLetras = new JComboBox<String>();
		for (int i =(int)'A' ; i <= (int)'Z'; i++) {
			CBLetras.addItem(""+(char)i);
		}
		
	
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new Escucha(v, word, hidden));
		btnAceptar.setActionCommand("btnAceptar");
		pLetras.add(CBLetras);
		CBLetras.setPreferredSize(new Dimension(50, 20));
		pLetras.add(btnAceptar);
		this.add(pLetras);

		
		JPanel pMensajes = new JPanel();
		pMensajes.setBorder(BorderFactory.createTitledBorder("Mensaje:"));
		lblMensajes = new JLabel("Que comienze el juego:");
		pMensajes.add(lblMensajes);
		this.add(pMensajes);
		


		
		
	}
	
	
	//COMENZAMOS EL RESETEO PARA EL REINICIO
	
	//DE LA PALABRA
	public void reiniciarPalabra(JPanel PP, char[] hid) {
		for (int i = 0; i < hid.length; i++) {
			lblPalabra.setText(lblPalabra.getText() + hid[i] + " ");
		}
	}
	
	//DE LOS INTENTOS
	public void reiniciarIntentos(JPanel PI) {
		lblIntentos.setText("");
	}
	
	
	
	
	public String deCharArrayToString(char[] vector) {
		String hid = "";
		for (int i = 0; i < vector.length; i++) {
			hid += vector[i] + " ";
		}
		return hid;
	}
	
	public String randomWord() {
		String[] palabras = {"EDIFICIO", "COLEGIO", "AUTOBUS", "CRANEO", "MONITOR"};
		return palabras[(int)(Math.random()*palabras.length)]; 
	}
	
	public char[] hiddenWord(String cad) {
		char[] hiddenWord = new char[cad.length()];
		
		for (int i = 0; i < cad.length(); i++) {
			hiddenWord[i] = '_';
		}
		return hiddenWord;
	}

	public JLabel getLblPalabra() {
		return lblPalabra;
	}

	public void setLblPalabra(JLabel lblPalabra) {
		this.lblPalabra = lblPalabra;
	}

	public JLabel getLblIntentos() {
		return lblIntentos;
	}

	public void setLblIntentos(JLabel lblIntentos) {
		this.lblIntentos = lblIntentos;
	}

	public JLabel getLblMensajes() {
		return lblMensajes;
	}

	public void setLblMensajes(JLabel lblMensajes) {
		this.lblMensajes = lblMensajes;
	}

	public JComboBox<String> getCBLetras() {
		return CBLetras;
	}

	public void setCBLetras(JComboBox<String> cBLetras) {
		CBLetras = cBLetras;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JPanel getpPalabra() {
		return pPalabra;
	}

	public void setpPalabra(JPanel pPalabra) {
		this.pPalabra = pPalabra;
	}

	public JPanel getpIntentos() {
		return pIntentos;
	}

	public void setpIntentos(JPanel pIntentos) {
		this.pIntentos = pIntentos;
	}
}
