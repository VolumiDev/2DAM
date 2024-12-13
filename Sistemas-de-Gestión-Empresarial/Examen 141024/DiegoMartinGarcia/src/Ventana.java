import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	private PDatos datos;
	private PReserva reserva;
	private PAux aux1,aux2;
	private PBotones pBotones;
	
	
	Ventana(){
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100,100,500,250);//500
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setTitle("Reserva de salones");
		
		//PANEL DE DATOS
		datos = new PDatos();
		this.getContentPane().add(datos);
		
		//PANEL DE RESERVA
		reserva = new PReserva(this);
		this.getContentPane().add(reserva);		
		
		
		aux1 = new PAux(1);
		aux2 = new PAux(2);
		pBotones = new PBotones(this);
	}
	
	public void ampliarVentana() {
		this.setSize(500,380);
	}
	public void minimizarVentana() {
		this.setSize(500,250);
	}

	public void insertarBanquete() {
		this.getContentPane().add(aux1);
	}
	public void insertarCongreso() {
		this.getContentPane().add(aux2);
	}
	public void insertarBotones() {
		this.getContentPane().add(pBotones);
	}
	public void eliminarBanquete() {
		this.getContentPane().remove(aux1);
	}
	public void eliminarCongreso() {
		this.getContentPane().remove(aux2);
	}
	public void eliminarBotones() {
		this.getContentPane().remove(pBotones);
	}
	
	public PDatos getDatos() {
		return datos;
	}


	public void setDatos(PDatos datos) {
		this.datos = datos;
	}


	public PReserva getReserva() {
		return reserva;
	}


	public void setReserva(PReserva reserva) {
		this.reserva = reserva;
	}


	public PAux getAux1() {
		return aux1;
	}


	public void setAux1(PAux aux) {
		this.aux1 = aux;
	}


	public PAux getAux2() {
		return aux2;
	}

	public void setAux2(PAux aux2) {
		this.aux2 = aux2;
	}

	public PBotones getpBotones() {
		return pBotones;
	}


	public void setpBotones(PBotones pBotones) {
		this.pBotones = pBotones;
	}
}
