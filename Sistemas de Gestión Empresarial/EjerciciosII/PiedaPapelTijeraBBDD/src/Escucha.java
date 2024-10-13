import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Escucha implements ActionListener {

	private Ventana vent;
	private int j1, j2, jugadaGanada1, jugadaGanada2, numtirada;
	
	Escucha(Ventana v){
		vent = v; 
		numtirada = 0;
		jugadaGanada1 = 0;
		jugadaGanada2 = 0;
		j1 = 0;
		j2 = 0;
	};
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vent.getWestPanel().getBtn()) {
			j1 = cambiaImagen(vent.getWestPanel().getImagen());
			vent.getWestPanel().getBtn().setEnabled(false);
		}
		
		
		if(e.getSource() == vent.getEastPanel().getBtn()) {
			j2 = cambiaImagen(vent.getEastPanel().getImagen());
			try {
				validarJugadas(j1, j2);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public int cambiaImagen(JLabel lbl) {
		String[] img = {"0.png", "1.png", "2.png"};  
		int index = (int)(Math.random()*img.length);
		ImageIcon imagen = new ImageIcon(img[index]);
		lbl.setIcon(imagen);
		return index;
	}
	
	private void validarJugadas(int j1, int j2) throws ClassNotFoundException, SQLException {		
			if(j1 == 0 && j2 == 1) {
				jugadaGanada2++;
				vent.getSouthPanel().getResultado().setText("Ha ganado Jugador 2");
				JOptionPane.showMessageDialog(vent, "Gana El Jugador 2");
				
				resetearImagen(vent.getWestPanel().getImagen(), vent.getEastPanel().getImagen());
			}else if(j1 == 0 && j2 == 2) {
				jugadaGanada1++;
				vent.getSouthPanel().getResultado().setText("Ha ganado Jugador 1");
				JOptionPane.showMessageDialog(vent, "Gana El Jugador 1");
				resetearImagen(vent.getWestPanel().getImagen(), vent.getEastPanel().getImagen());
			}else if(j1 == 1 && j2 == 0) {
				jugadaGanada1++;
				vent.getSouthPanel().getResultado().setText("Ha ganado Jugador 1");
				JOptionPane.showMessageDialog(vent, "Gana El Jugador 1");
				resetearImagen(vent.getWestPanel().getImagen(), vent.getEastPanel().getImagen());
			}else if(j1 == 1 && j2 == 2) {
				jugadaGanada2++;
				vent.getSouthPanel().getResultado().setText("Ha ganado Jugador 2");
				JOptionPane.showMessageDialog(vent, "Gana El Jugador 2");
				resetearImagen(vent.getWestPanel().getImagen(), vent.getEastPanel().getImagen());
			}else if(j1 == 2 && j2 == 0) {
				jugadaGanada2++;
				vent.getSouthPanel().getResultado().setText("Ha ganado Jugador 2");
				JOptionPane.showMessageDialog(vent, "Gana El Jugador 2");
				resetearImagen(vent.getWestPanel().getImagen(), vent.getEastPanel().getImagen());
			}else if(j1 == 2 && j2 == 1) {
				jugadaGanada1++;
				vent.getSouthPanel().getResultado().setText("Ha ganado Jugador 1");
				JOptionPane.showMessageDialog(vent, "Gana El Jugador 1");
				resetearImagen(vent.getWestPanel().getImagen(), vent.getEastPanel().getImagen());
			}else {
				vent.getSouthPanel().getResultado().setText("Empate, se repite la tirada");
				JOptionPane.showMessageDialog(vent, "Empate, se repite la tirada");
				resetearImagen(vent.getWestPanel().getImagen(), vent.getEastPanel().getImagen());
			}
			numtirada++;
			actualizaMarcador();
			actualizaTirada();
			finalDePartida();
		
	}
	
	private void reiniciarMarcador() {
		jugadaGanada1 = 0;
		jugadaGanada2 = 0;
		numtirada = 0;
		actualizaMarcador();
		actualizaTirada();
		vent.getSouthPanel().getResultado().setText("Que empiece la partida.");
	}
	
	private void resetearImagen(JLabel lbl1, JLabel lbl2) {
		lbl1.setIcon(new ImageIcon("espera.png"));
		lbl2.setIcon(new ImageIcon("espera.png"));
		vent.getWestPanel().getBtn().setEnabled(true);
	}
	
	private void finalDePartida() throws ClassNotFoundException, SQLException {
		if(jugadaGanada1 == 3 || jugadaGanada2 == 3) {
			if(jugadaGanada1 == 3 ) {
				JOptionPane.showMessageDialog(vent, "Final de partida Gana El Jugador 1");
			}else {
				JOptionPane.showMessageDialog(vent, "Final de partida Gana El Jugador 2");
			}
			resetearImagen(vent.getWestPanel().getImagen(), vent.getEastPanel().getImagen());
			guardarBBDD();
			reiniciarMarcador();
		}
	}
	
	private void actualizaTirada() {
		vent.getNorthPanel().getTirada().setText("Gana el primero que gane 3. Tirada: "+ numtirada);
	}
	private void actualizaMarcador() {
		vent.getWestPanel().getMarcador().setText("" + jugadaGanada1);
		vent.getEastPanel().getMarcador().setText("" + jugadaGanada2);
	}
	
	private void guardarBBDD() throws ClassNotFoundException, SQLException {
		int id = calcularPK();
		String ganador = "";
		if( jugadaGanada1 == 3) {
			ganador = "Jugador 1";
		}else {
			ganador = "Jugador 2";
		}
		
		Conexion con = new Conexion();
		String sql = "INSERT INTO jugada VALUES("+ id +",'"+ ganador +"', "+numtirada+")";
		con.actualizar(sql);
		con.cerrar();
		
	}
	
	private int calcularPK() throws ClassNotFoundException, SQLException {
		int pk = -1;
		Conexion con = new Conexion();
		String sql = "select count(*) from jugada";
		ResultSet rs = con.consulta(sql);
		while(rs.next()) {
			if(rs.getInt(1) == 0) {
				pk = 1;
			}else {
				sql = "Select idPartida from jugada order by idPartida desc limit 1";
				rs = con.consulta(sql);
				while(rs.next()) {
					pk = rs.getInt(1) + 1;
				}
			}
		}
		con.cerrar();
		return pk;
	}

}
