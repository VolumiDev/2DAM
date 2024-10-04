import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.concurrent.Flow;

import javax.security.sasl.SaslException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{

	private JLabel lblTitulo;
	private JTextField txtInput;
	private JButton btnSaludar;
	
	Ventana(){
		super();
		this.setTitle("Saludador");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 400);
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 70));
		
		//etiqueta
		lblTitulo = new JLabel("Escribe un nombre para saludar");
		this.getContentPane().add(lblTitulo);
		
		//caja de texto
		txtInput = new JTextField();
		txtInput.setPreferredSize(new Dimension(300, 30));
		txtInput.setFont(new Font("Consolas", Font.BOLD, 20));
		this.getContentPane().add(txtInput);
		
		//boton
		btnSaludar = new JButton("Saludar");
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(50,100,50,100));
		
		panel.add(btnSaludar);
		this.getContentPane().add(btnSaludar);
		
		ClaseEscuchadora escuchador = new ClaseEscuchadora(this);
		btnSaludar.addActionListener(escuchador);
		
	}

	public JTextField getTxtInput() {
		return txtInput;
	}

	public void setTxtInput(JTextField txtInput) {
		this.txtInput = txtInput;
	}
	
	
}
