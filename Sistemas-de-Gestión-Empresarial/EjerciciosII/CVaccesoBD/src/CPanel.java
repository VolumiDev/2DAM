import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CPanel extends JPanel{

	private JTextField[] inputs;
	private JRadioButton[] radios;
	private JTextArea datosInteres;
	
	public CPanel() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		super();
		String[] titulos = {"Si", "No"};
		
		inputs = new JTextField[3];
		radios = new JRadioButton[2];
		datosInteres= new JTextArea(10,10);
		
		this.setLayout(new GridLayout(6, 1));
		
		for (int i = 0; i < inputs.length; i++) {
			JPanel p = new JPanel();
			JPanel marginTop = new JPanel();
			marginTop.setPreferredSize(new Dimension(190, 8));
			p.add(marginTop);
			inputs[i] = new JTextField(15);
			p.add(inputs[i]);
			this.add(p);
		}
		
		inputs[0].setEditable(false);
		
		
		JPanel marginTop1 = new JPanel();
		marginTop1.setPreferredSize(new Dimension(190, 8));
		JPanel panelRadios = new JPanel();
		panelRadios.add(marginTop1);

		ButtonGroup rb = new ButtonGroup();
		for (int i = 0; i < radios.length; i++) {
			radios[i] = new JRadioButton(titulos[i]);
			radios[i].setPreferredSize(new Dimension(90, 15));
			panelRadios.add(radios[i]);
			rb.add(radios[i]);
		}
		radios[0].setSelected(true);
		this.add(panelRadios);
	
		JPanel panelDatosInteres = new JPanel();
		JScrollPane pScroll = new JScrollPane(datosInteres, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		pScroll.setPreferredSize(new Dimension(200, 60));
		panelDatosInteres.add(pScroll);
		this.add(panelDatosInteres);
	
		calcularCodigo();
	}

	
	public String calcularCodigo() throws ClassNotFoundException, SQLException {
		String cod="";
		int numTuplas = 0;
		int pk = 1;
		Conexion con = new Conexion("datospersona");
		String sql = "Select count(*) from datos";
		ResultSet rs = con.consultar(sql);
		while(rs.next()) {
			numTuplas = rs.getInt(1);
		}
		
		if(numTuplas == 0) {
			inputs[0].setText("" + pk);
		}else {
			sql = "select codigo from datos order by codigo desc limit 1";
			rs = con.consultar(sql);
			while(rs.next()) {
				pk = rs.getInt(1) + 1;
			}
		}
		con.cerrar();
		
		inputs[0].setText("" + pk);
		return cod;
	}
	
	
	public JTextField[] getInputs() {
		return inputs;
	}

	public void setInputs(JTextField[] inputs) {
		this.inputs = inputs;
	}

	public JRadioButton[] getRadios() {
		return radios;
	}

	public void setRadios(JRadioButton[] radios) {
		this.radios = radios;
	}

	public JTextArea getDatosInteres() {
		return datosInteres;
	}

	public void setDatosInteres(JTextArea datosInteres) {
		this.datosInteres = datosInteres;
	}
}
