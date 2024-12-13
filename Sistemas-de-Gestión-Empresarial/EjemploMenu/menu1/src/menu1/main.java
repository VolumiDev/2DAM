package menu1;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*PODEMOS TENER UN SOLO JFRAME Y LAS VENTNAS HIJAS JINTERNALFRAME
		*	
		*LA BARRA DE MENU ES UN JMENUBAR.
		*LAS DIFERENTES OPCIONES DEL MENU SON JMENU
		*Y LAS DISTINTAS OPCIONES DEL JMENU SON JMENUITEM
		*/
		
		Ventana v = new Ventana();
		v.setBounds(100,100,300,300);
		v.setVisible(true);
	}

}
