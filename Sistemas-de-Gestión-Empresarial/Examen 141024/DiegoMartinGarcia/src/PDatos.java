import java.awt.Dimension;
import java.awt.FlowLayout;
import java.nio.file.DirectoryNotEmptyException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PDatos extends JPanel{
	
	private JLabel[] lbls;
	private JTextField[] txts;

	public PDatos() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(450,80));
		String[] titulos = {
				"NOMBRE:",
				"TELEFONO:"
		};
		
		this.setBorder(new TitledBorder("Datos Personales"));
		
		lbls = new JLabel[2];
		txts = new JTextField[2];
		for (int i = 0; i < lbls.length; i++) {
			lbls[i] = new JLabel(titulos[i]);
			lbls[i].setPreferredSize(new Dimension(150,20));
			txts[i] = new JTextField(25);
			this.add(lbls[i]);
			this.add(txts[i]);
		}
		
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
	
}
