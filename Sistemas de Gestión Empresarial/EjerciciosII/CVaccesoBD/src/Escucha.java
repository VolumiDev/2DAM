import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Escucha implements ActionListener {

	private Ventana vent;
	
	public Escucha(Ventana v) {
		// TODO Auto-generated constructor stub
		vent = v;
	}

	public Escucha() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == vent.getSouthPanel().getBtns()[0]) {
			try {
				almacenarBD();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			vent.getSouthPanel().getBtns()[1].setEnabled(true);
			vent.getSouthPanel().getBtns()[0].setEnabled(false);
		}
		
		if(e.getSource() == vent.getSouthPanel().getBtns()[1]) {
			limpiar();
			vent.getSouthPanel().getBtns()[0].setEnabled(true);

		}
		if(e.getSource() == vent.getSouthPanel().getBtns()[2]) {
			System.exit(0);
		}
	}
	
	public void almacenarBD() throws  SQLException, ClassNotFoundException{
		int codigo = Integer.parseInt(vent.getCenterPanel().getInputs()[0].getText());
		String nombre = vent.getCenterPanel().getInputs()[1].getText();
		String localidad = vent.getCenterPanel().getInputs()[2].getText();
		boolean nacional = true;
		String datosInteres = vent.getCenterPanel().getDatosInteres().getText();
		if(vent.getCenterPanel().getRadios()[0].isSelected()) {
			 nacional = true;
		}else {
			 nacional = false;
		}
		Conexion con = new Conexion("datospersona");
		String sql = "INSERT INTO datos VALUES("+codigo+",'"+nombre+"', '"+localidad+"', "+nacional+", '"+datosInteres+"')";
		con.actualizar(sql);
		con.cerrar();
	}
	
	public void limpiar() {
		for (int i = 0; i < vent.getCenterPanel().getInputs().length; i++) {
			vent.getCenterPanel().getInputs()[i].setText("");
		}
		vent.getCenterPanel().getRadios()[0].setSelected(true);
		vent.getCenterPanel().getDatosInteres().setText("");
	}

}
