import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WCtrl extends JFrame{

	private JLabel lbl;
	private JTextField txt, txt1, txt2;
	private JPasswordField pass;
	private JTextArea txtArea;
	
	
	
	WCtrl(){
		super();
		
		this.setTitle("Controls Window");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(300, 300, 500, 700);
		this.setLayout(new FlowLayout());
		this.setResizable(true);
		
		Label();
		TextField();
		Pass();
		textArea();
		
		this.setVisible(true);
	}
	
	private void Label() {
		lbl = new JLabel("Ejm_lbl");
		this.getContentPane().add(lbl);
	}
	
	private void TextField() {
		txt = new JTextField(20);
		txt1 = new JTextField("Const_1", 20);
		txt2 = new JTextField(20);
		
		txt1.setFont(new Font("Consolas", 1, 15));
		txt1.setEnabled(false);
		
		this.getContentPane().add(txt);
		this.getContentPane().add(txt1);
		this.getContentPane().add(txt2);
	}
	
	private void Pass() {
		pass = new JPasswordField("pass", 15);
		pass.setEchoChar('#');
		
		this.getContentPane().add(pass);
	}
	
	private void textArea() {
		txtArea = new JTextArea("Area de muestra/", 10, 10);
		
		//corta la palbras cuando llegan al final del area de escritura. NO RESPETA LAS PALABRAS, LAS CORTA
		txtArea.setLineWrap(true);
		//Mantiene el formato de las palabras al cortarlas
		txtArea.setWrapStyleWord(true);
		//Setea el numero de columnas que tiena el area
		txtArea.setColumns(10);
		//cambia el texto entre las posiciones pasadas como parametro
		txtArea.replaceRange("este es el texto que va a ser cambiado/", 0, 2);
		//inserta el texto indicado en la posicion indicada
		txtArea.insert("este texto se a introducido con con la funcion insert/", 0);
		//añade el texto indicado al final
		txtArea.append("este txt se ha introducido con el metodo append/");
		//Determina que numero de lineas contenido en el textarea
		txtArea.getLineCount();
	
		this.getContentPane().add(txtArea);
	}
}
