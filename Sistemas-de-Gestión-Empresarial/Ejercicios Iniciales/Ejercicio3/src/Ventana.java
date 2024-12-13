import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.nio.file.DirectoryNotEmptyException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame{
	private JLabel lblTexto;
	private JTextField txtInput;
	private PRadios pRadios;
	private PCheck pCheckBtn;
	
	Ventana(){
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		JPanel marco = new JPanel();
		marco.setPreferredSize(new Dimension(425, 245));
		marco.setBorder(new LineBorder(Color.BLACK, 1));
		
		Font fontTitulo = new Font("sans", Font.BOLD, 25);
		Font fontInput = new Font("sans", Font.PLAIN, 15);
		
		JPanel margintop = new JPanel();
		margintop.setPreferredSize(new Dimension(320, 30));
		marco.add(margintop);
		
		lblTexto = new JLabel("Tratamiento de Texto", SwingConstants.CENTER);
		lblTexto.setFont(fontTitulo);
		lblTexto.setForeground(Color.RED);
		marco.add(lblTexto);
		
		JPanel marginbotTitle = new JPanel();
		marginbotTitle.setPreferredSize(new Dimension(320, 10));
		marco.add(marginbotTitle);
		
		txtInput = new JTextField(22);
		txtInput.setFont(fontInput);
		marco.add(txtInput);
		
		pRadios = new PRadios(this);
		pRadios.setPreferredSize(new Dimension(380, 70));
		marco.add(pRadios);
		
		pCheckBtn = new PCheck(this);
		pCheckBtn.setPreferredSize(new Dimension(380, 40));
		marco.add(pCheckBtn);
		
		this.getContentPane().add(marco);
		
		
	}
	
	
	
	

	public JLabel getLblTexto() {
		return lblTexto;
	}

	public void setLblTexto(JLabel lblTexto) {
		this.lblTexto = lblTexto;
	}

	public JTextField getTxtInput() {
		return txtInput;
	}

	public void setTxtInput(JTextField txtInput) {
		this.txtInput = txtInput;
	}

	public PRadios getpRadios() {
		return pRadios;
	}

	public void setpRadios(PRadios pRadios) {
		this.pRadios = pRadios;
	}

	public PCheck getpCheckBtn() {
		return pCheckBtn;
	}

	public void setpCheckBtn(PCheck pCheckBtn) {
		this.pCheckBtn = pCheckBtn;
	}
	
}
