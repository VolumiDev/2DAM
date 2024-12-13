import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.im.InputContext;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class Escuchadora implements ActionListener {

	Ventana vent;
	
	public Escuchadora(Ventana v) {
		// TODO Auto-generated constructor stub
		vent = v;
	}
	
	public Escuchadora() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == vent.getSouthPanel().getBtns()[0]) {
			try {
				escribirTxt();
				vent.getWestPanel().limpiar();
				vent.getEastPanel().limpiar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void escribirTxt() throws IOException {
		
		File txt = new File("cvTxt.txt");
		FileWriter fw = new FileWriter(txt,true);
		PrintWriter pw = new PrintWriter(fw);
		
		for (int i = 0; i < vent.getWestPanel().getTxts().length; i++) {
			pw.print(vent.getWestPanel().getTxts()[i].getText() + " - ");
		}
		
		pw.print(vent.getEastPanel().getEstudios().getSelectedItem() + " - ");
		
		if(vent.getEastPanel().getSexo()[0].isSelected()) {
			pw.print("Hombre - ");
		}else {
			pw.print("Mujer - ");
		}
		
		for (int i = 0; i < vent.getEastPanel().getOtrosDatos().length; i++) {
			if(i < vent.getEastPanel().getOtrosDatos().length -1) {
				if(vent.getEastPanel().getOtrosDatos()[i].isSelected()) {
					pw.print(vent.getEastPanel().getOtrosDatos()[i].getText() + " - ");
				}
			}else {
				if(vent.getEastPanel().getOtrosDatos()[i].isSelected()) {
					pw.print(vent.getEastPanel().getOtrosDatos()[i].getText() + " - ");
				}			
			}
		}
		pw.println();
		
		pw.close();
		fw.close();
	}
}
