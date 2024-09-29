import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.concurrent.Flow;

import javax.naming.ContextNotEmptyException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LabelPanel extends JPanel{

	private LinePanel[] linePanels;
	
	public LabelPanel() {
		// TODO Auto-generated constructor stub
		super();
		String[] titles = {"Nombre:   ", "Editor:   ", "Tipo:   ", "De:   " };
		String[] contents = {"C:\\Users\\Diego\\Documents\\2DAMasdasdasdasdasdasdaasdas ", "Salesianos International", "Aplicacion", "C:\\Users\\Diego\\Documents\\2DAM: " };

		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		linePanels = new LinePanel[4];
		for (int i = 0; i < linePanels.length; i++) {
			if(i == 1) {
				linePanels[i] = new LinePanel(titles[i], "<html><a href=" + '"' + "www.salesianospizarrales.com"+ '"' + ">"+ contents[i] +"</a></htmml>");
			}else {
				linePanels[i] = new LinePanel(titles[i], contents[i]);				
			}
			linePanels[i].setPreferredSize(new Dimension(500,20));
			this.add(linePanels[i]);
		}
		
	}
}
