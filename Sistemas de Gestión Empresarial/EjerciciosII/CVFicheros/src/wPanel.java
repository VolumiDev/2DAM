import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class wPanel extends JPanel{

	private JLabel[] lbls;
	private JTextField[] txts;
	private JTextArea datos;
	
	wPanel(){
		super();
		String[] titulos = {
				"NOMBRE",
				"DIRECCION",
				"TELEFONO",
				"OTROS DATOS"
		};
		this.setLayout(new GridLayout(2,1));
		
		JPanel ptxt_lbl = new JPanel();
		lbls = new JLabel[4];
		txts = new JTextField[3];
		for (int i = 0; i < lbls.length; i++) {
			lbls[i] = new JLabel(titulos[i]);
			lbls[i].setPreferredSize(new Dimension(200,15));
			lbls[i].setBorder(new EmptyBorder(10,10,10,10));
			if(i < 3) {
				ptxt_lbl.add(lbls[i]);
				txts[i] = new JTextField(16);
				ptxt_lbl.add(txts[i]);				
			}
		}
		this.add(ptxt_lbl);
		
		datos = new JTextArea(10,10);
		JPanel datosInteres = new JPanel();
		JScrollPane scroll = new JScrollPane(datos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(200,140));
		datosInteres.add(lbls[3]);
		datosInteres.add(scroll);
		this.add(datosInteres);
	}

	public void limpiar() {
		for (int i = 0; i < txts.length; i++) {
			txts[i].setText("");
		}
		datos.setText("");
	}
	
	public JLabel[] getLbls() {
		return lbls;
	}

	public void setLbls(JLabel[] lbls) {
		this.lbls = lbls;
	}

	public JTextField[] getTxts() {
		return txts;
	}

	public void setTxts(JTextField[] txts) {
		this.txts = txts;
	}

	public JTextArea getDatos() {
		return datos;
	}

	public void setDatos(JTextArea datos) {
		this.datos = datos;
	}
	
	
}
