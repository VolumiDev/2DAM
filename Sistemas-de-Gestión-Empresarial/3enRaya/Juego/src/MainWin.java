import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Iterator;
import java.util.random.RandomGenerator.ArbitrarilyJumpableGenerator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class MainWin extends JFrame{
	private JButton[] btns;
	private JRadioButton[] modosJuego;
	private JLabel resultado;
	private JButton btnReiniciar;
	private int jugador;
	
	
	
	public MainWin() {
		// TODO Auto-generated constructor stub
		super();
		jugador = 1;
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel btnPanel = new JPanel();
		btnPanel.setPreferredSize(new Dimension(150,150));
		btns = new JButton[9];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton();
			btns[i].setPreferredSize(new Dimension(45,45));
			btns[i].setActionCommand(""+i);
			btns[i].addActionListener(new Escucha(this));
			btnPanel.add(btns[i]);
			btns[i].setEnabled(false);
		}
		this.getContentPane().add(btnPanel);
		
		
		String[] titRadios = {"Humano vs Computadora", "Humano vs Humano"};
		JPanel radiosPanel = new JPanel();
		radiosPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		radiosPanel.setPreferredSize(new Dimension(200, 170));
		modosJuego = new JRadioButton[2];
		ButtonGroup radiosGroup = new  ButtonGroup();
		for (int i = 0; i < modosJuego.length; i++) {
			modosJuego[i] = new JRadioButton(titRadios[i]);
			modosJuego[i].addActionListener(e -> this.activarBtns());
			radiosGroup.add(modosJuego[i]);
			radiosPanel.add(modosJuego[i]);
		}
		resultado = new JLabel();
		resultado.setPreferredSize(new Dimension(190, 30));
		radiosPanel.add(resultado);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new Escucha(this));
		btnReiniciar.setActionCommand("reiniciar");
		radiosPanel.add(btnReiniciar);
		
		
		this.getContentPane().add(radiosPanel);
	}
	
	public void tiradaComputadora() {
		int rng = 0;
		boolean flag = true;
		if(hayHueco()) {
			do {
				rng = (int)(Math.random()*btns.length);
				if(btns[rng].getText().equalsIgnoreCase("")) {
					btns[rng].setText("O");
					flag= false;
				}
			}while(flag);
			
		}
		this.jugador=1;
	}
	
	private void activarBtns() {
		for (int i = 0; i < btns.length; i++) {
			btns[i].setEnabled(true);
		}
	}
	
	private boolean hayHueco() {
		boolean flag = false;
		
		for (int i = 0; i < btns.length; i++) {
			if(btns[i].getText().equalsIgnoreCase("")) {
				flag = true;
			}
		}
		
		return flag;
	}
	

	
	


	public int getJugador() {
		return jugador;
	}





	public void setJugador(int jugador) {
		this.jugador = jugador;
	}





	public JButton[] getBtns() {
		return btns;
	}



	public void setBtns(JButton[] btns) {
		this.btns = btns;
	}



	public JRadioButton[] getModosJuego() {
		return modosJuego;
	}



	public void setModosJuego(JRadioButton[] modosJuego) {
		this.modosJuego = modosJuego;
	}



	public JLabel getResultado() {
		return resultado;
	}



	public void setResultado(JLabel resultado) {
		this.resultado = resultado;
	}



	public JButton getBtnReiniciar() {
		return btnReiniciar;
	}



	public void setBtnReiniciar(JButton btnReiniciar) {
		this.btnReiniciar = btnReiniciar;
	}
}
