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
	
	public WPanel(Ventana v) {
		// TODO Auto-generated constructor stub
		
		
		String word = randomWord();
		String hidden = hiddenWord(word);
		
		this.setLayout(new GridLayout(4, 1));
		
		
		JPanel pPalabra = new JPanel();
		pPalabra.setBorder(BorderFactory.createTitledBorder("Palabra:"));
		lblPalabra = new JLabel(hidden);
		pPalabra.add(lblPalabra);
		this.add(pPalabra);

		
		JPanel pIntentos = new JPanel();
		pIntentos.setBorder(BorderFactory.createTitledBorder("Intentos:"));
		lblIntentos = new JLabel();
		pIntentos.add(lblIntentos);
		this.add(pIntentos);
		
		JPanel pLetras = new JPanel();
		pLetras.setBorder(BorderFactory.createTitledBorder("Letras:"));
		
		
		CBLetras = new JComboBox<String>();
		for (int i =(int)'A' ; i <= (int)'Z'; i++) {
			CBLetras.addItem(""+(char)i);
		}
		
	
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new Escucha(v));
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
	
	public String randomWord() {
		String[] palabras = {"EDIFICIO", "COLEGIO", "AUTOBUS", "CRANEO", "MONITOR"};
		return palabras[(int)(Math.random()*palabras.length)]; 
	}
	
	public String hiddenWord(String cad) {
		String hiddenWord = "";
		
		for (int i = 0; i < cad.length(); i++) {
			hiddenWord += "_ ";
		}
		return hiddenWord;
	}
}
