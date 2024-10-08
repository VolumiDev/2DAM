import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	private pIzq panelIzq;
	private pDer panelDer;
	
	Ventana(){
		super();
		this.getContentPane().setLayout(new GridLayout(1,2));
		this.setBounds(300,400,500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelIzq = new pIzq(this);
		panelDer = new pDer(this);
		this.getContentPane().add(panelIzq);
		this.getContentPane().add(panelDer);
		
		
	}

	public pIzq getPanelIzq() {
		return panelIzq;
	}

	public void setPanelIzq(pIzq panelIzq) {
		this.panelIzq = panelIzq;
	}

	public pDer getPanelDer() {
		return panelDer;
	}

	public void setPanelDer(pDer panelDer) {
		this.panelDer = panelDer;
	}
	
}
