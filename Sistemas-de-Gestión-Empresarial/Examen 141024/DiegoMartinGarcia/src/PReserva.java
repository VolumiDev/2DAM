import java.awt.Dimension;
import java.awt.FlowLayout;
import java.nio.file.DirectoryNotEmptyException;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PReserva extends JPanel{

	private JLabel lblEvento, lblFecha, lblCocina, lblNumPersonas;
	private JRadioButton[] radios;
	private JTextField txtEvento, txtNumPersonas;
	private JComboBox<String> tiposCocina;
	private ButtonGroup radiosGrupo;
	
	
	
	public PReserva(Ventana v) {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setPreferredSize(new Dimension(450,110));
		this.setBorder(new TitledBorder("Datos Reserva"));
		
		String[] radioTit = {"Banquete", "Congreso"};
		String[] tiposTit = {
				"Bufet",
				"Carta",
				"Pedir cita chef",
				"No precisa"
		};
		
		
		lblEvento = new JLabel("Tipo de Evento:");
		lblEvento.setPreferredSize(new Dimension(150, 20));
		this.add(lblEvento);
		
		radiosGrupo = new ButtonGroup();
		radios = new JRadioButton[2];
		for (int i = 0; i < radios.length; i++) {
			radios[i] = new JRadioButton(radioTit[i]);
			radiosGrupo.add(radios[i]);
			radios[i].setPreferredSize(new Dimension(100,20));
			this.add(radios[i]);
			radios[i].addActionListener(new Escucha(v));
		}
		
		lblFecha = new JLabel("Fecha Evento:");
		lblFecha.setPreferredSize(new Dimension(150, 20));
		this.add(lblFecha);

		
		txtEvento = new JTextField(25);
		this.add(txtEvento);
		
		lblCocina = new JLabel("Tipo de cocina:");
		lblCocina.setPreferredSize(new Dimension(100, 20));
		this.add(lblCocina);
		
		
		tiposCocina = new JComboBox<String>(tiposTit);
		tiposCocina.setPreferredSize(new Dimension(100,20));
		this.add(tiposCocina);
		
		
		JLabel margin = new JLabel();
		margin.setPreferredSize(new Dimension(20,20));
		this.add(margin);
		
		
		lblNumPersonas = new JLabel("Nº Personas");
		lblCocina.setPreferredSize(new Dimension(100, 20));
		this.add(lblNumPersonas);
		
		txtNumPersonas = new JTextField(10);
		this.add(txtNumPersonas);
		
	}

	public void desseleccionar() {
		radiosGrupo.clearSelection();
	}


	public JLabel getLblEvento() {
		return lblEvento;
	}




	public void setLblEvento(JLabel lblEvento) {
		this.lblEvento = lblEvento;
	}




	public JLabel getLblFecha() {
		return lblFecha;
	}




	public void setLblFecha(JLabel lblFecha) {
		this.lblFecha = lblFecha;
	}




	public JLabel getLblCocina() {
		return lblCocina;
	}




	public void setLblCocina(JLabel lblCocina) {
		this.lblCocina = lblCocina;
	}




	public JLabel getLblNumPersonas() {
		return lblNumPersonas;
	}




	public void setLblNumPersonas(JLabel lblNumPersonas) {
		this.lblNumPersonas = lblNumPersonas;
	}




	public JRadioButton[] getRadios() {
		return radios;
	}




	public void setRadios(JRadioButton[] radios) {
		this.radios = radios;
	}




	public JTextField getTxtEvento() {
		return txtEvento;
	}




	public void setTxtEvento(JTextField txtEvento) {
		this.txtEvento = txtEvento;
	}




	public JTextField getTxtNumPersonas() {
		return txtNumPersonas;
	}




	public void setTxtNumPersonas(JTextField txtNumPersonas) {
		this.txtNumPersonas = txtNumPersonas;
	}




	public JComboBox<String> getTiposCocina() {
		return tiposCocina;
	}




	public void setTiposCocina(JComboBox<String> tiposCocina) {
		this.tiposCocina = tiposCocina;
	}
	
}
