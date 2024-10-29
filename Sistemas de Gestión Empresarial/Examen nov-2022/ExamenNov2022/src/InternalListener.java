import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.module.FindException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalField;

import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;

public class InternalListener implements ActionListener {

	private InternalEvaluation iFrame;
	
	public InternalListener(InternalEvaluation iFrame) {
		super();
		this.iFrame = iFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		
		switch (command) {
		case "qualify":
			User u = null;
			try {
				u = u.getUserData(iFrame.getTfPersonalData()[0].getText());
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(u.getTries() < 3) {
				if(emptyValidate() == false && dateValidator() == false) {
					finalScore(u);
					try {
						u.userUpdate();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}else {
				JOptionPane.showMessageDialog(iFrame, "Ha alcanzado el numero maximo de intentos");
			}
			break;
		case "search":
			
			User t = new User();
			try {
				if(searchUser(t)) {
					//SI EEXISTE YA TIENE COMPLETO AL MENOS UN INTENTO, SETEAMOS LA INFO Y VALIDAMOS LOS INTENTOS
					t = t.getUserData(iFrame.getTfPersonalData()[0].getText());
					//MOSTRAMOS LA INFO EN LOS TEXTFIELD
					showInfoTextFields(t);
				}else {
					//VALIDAMOS QUE NO ESTE VACIO NINGUN CAMPO DE DATOS
					if(emptyDataValidator() == false) {
						String sex;
						if(iFrame.getRbMan().isSelected()) {
							sex = "Hombre";
						}else {
							sex = "Mujer";
						}
						// GENERAMOS EL NUEVO USER CON SUS DATOS
						t = new User(iFrame.getTfPersonalData()[0].getText(), iFrame.getTfPersonalData()[1].getText(), sex);
						t.insertNewUser(iFrame);
					}else {
						JOptionPane.showMessageDialog(iFrame, "No pueden quedar campos vacio en los datos personales");
					}
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	
	//MOSTRAMOS LA INFO DEL USUARIO EN LOS TEXT FIELD
	private void showInfoTextFields(User u) {
		iFrame.getTfPersonalData()[0].setText(u.getName());
		iFrame.getTfPersonalData()[1].setText(u.getDate());
		if(u.getSex().equalsIgnoreCase("Hombre")) {
			iFrame.getRbMan().setSelected(true);
		}else {
			iFrame.getRbWomen().setSelected(true);
		}
	}
	
	//DEVUELVE UN BOOLEANO EN TRUE SI EXISTE EL USUARIO O FALSE SI NO EXISTE
	private boolean searchUser(User t) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		t = t.getUserData(iFrame.getTfPersonalData()[0].getText());
		if(t.getName() != null) {
			return true;
		}else {
			return false;			
		}
	}
	//VALIDAMOS QUE TODOS LOS CAMPOS ESTE RELLENOS CORRECTAMENTE
	private boolean emptyValidate() {
		// TODO Auto-generated method stub
		boolean empty = false;
		boolean checkFlag = false;
		//VALIDAMOS LOS TEXTFIELD
		JTextField[] txt = iFrame.getTfPersonalData();
		for (int i = 0; i < txt.length && empty == false; i++) {
			if(txt[i].getText().isBlank()) {
				empty = true;
			}
		}
		
		//VALIDAMOS LOS RADIO BUTTON
		if(!empty) {
			if(!iFrame.getRbMan().isSelected() && !iFrame.getRbWomen().isSelected()) {
				empty = true;
			}			
		}
		//VALIDAMOS LA QUESTION 1
		if(!empty) {
			JCheckBox[] checks = iFrame.getCbQuestion1();
			for (int i = 0; i < checks.length; i++) {
				if(iFrame.getCbQuestion1()[i].isSelected()) {
					checkFlag = true;
				}
			}
			if(!checkFlag) {
				empty = true;
			}
		}
		
		//VALIDAMOS LA PREGUNTA 3
		if(!empty) {
			if(iFrame.getRbQuestion3()[0].isSelected() && iFrame.getRbQuestion3()[1].isSelected() && iFrame.getRbQuestion3()[2].isSelected() && iFrame.getRbQuestion3()[3].isSelected()) {
				empty = true;
			}
		}
		//VALIDAMOS LA PREGUNTA 2
		if(!empty) {
			if(iFrame.getTaQuestion2().getText().isBlank()) {
				empty = true;
			}			
		}
		//VALIDAMOS LA PREGUNTA 4
		if(!empty) {
			if(iFrame.getJlQuestion4().isSelectionEmpty()) {
				empty = true;
			}
		}
		
		if(empty) {
			JOptionPane.showMessageDialog(iFrame, "No pueden quedar campos vacios");
		}
		return empty;
	}
	
	//VALIDAMOS QUE LA FECHA SEA CORRECTA TANTO EN FORMATO COMO EN FECHA
	private boolean dateValidator() {
		boolean flag = false;
		// TODO Auto-generated method stub
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		try {
			LocalDate inputDate = LocalDate.parse(iFrame.getTfPersonalData()[1].getText(), dateFormat);
			LocalDate today = LocalDate.now();
			
			if(inputDate.isAfter(today)) {
				JOptionPane.showMessageDialog(iFrame, "La fecha no puede ser posterior a hoy");
				iFrame.getTfPersonalData()[1].setText("");
				flag = true;
			}		
		}catch(DateTimeParseException e) {
			JOptionPane.showMessageDialog(iFrame, "Introduce un formato de fecha valido yyyy-MM-dd");
			flag = true;
		}
		return flag;
	}
	
	//PUNTUAMOS LA QUESTION 1
	private double response1() {
		// TODO Auto-generated method stub
		double result=0;
		
		responseStyle1(iFrame.getCbQuestion1()[0], Color.RED);
		responseStyle1(iFrame.getCbQuestion1()[1], Color.GREEN);
		responseStyle1(iFrame.getCbQuestion1()[2], Color.GREEN);
		responseStyle1(iFrame.getCbQuestion1()[3], Color.RED);
		
		if(!iFrame.getCbQuestion1()[0].isSelected() && iFrame.getCbQuestion1()[1].isSelected() && iFrame.getCbQuestion1()[2].isSelected() &&!iFrame.getCbQuestion1()[0].isSelected()) {
			result = 1;
		}else {
			result = -0.5;
		}
		System.out.println("1 retorna " + (result));

		return result;
	}
	
	
	//COLOREAMOS LAS RESPUESTAS EN FUNCION DE LA RESPUESTA 1
	private void responseStyle1(JCheckBox cb, Color c) {
		// TODO Auto-generated method stub
		if(cb.isSelected()) {
			cb.setForeground(c);
		}
	}
	
	//PUNTUAMOS LA QUESTION 3
	private double response3() {
		// TODO Auto-generated method stub
		double result = 0;
		
		responseStyle3(iFrame.getRbQuestion3()[0], Color.RED);
		responseStyle3(iFrame.getRbQuestion3()[1], Color.RED);
		responseStyle3(iFrame.getRbQuestion3()[2], Color.GREEN);
		responseStyle3(iFrame.getRbQuestion3()[3], Color.RED);
		
		if(iFrame.getRbQuestion3()[2].isSelected()) {
			result = 1;
		}else {
			result = -0.5;
		}
		System.out.println("3 retorna " + result);

		return result;
	}
	
	//COLOREAMOS LAS REPUESTAS DE LA PREGUNTA 3
	private void responseStyle3(JRadioButton rb, Color c) {
		// TODO Auto-generated method stub
		if(rb.isSelected()) {
			rb.setForeground(c);
		}
	}
		
	
	//PUNTUAMOS LA QUESTION 2
		private double response2() {
			// TODO Auto-generated method stub
			double result = 0;
			
			
			if(iFrame.getTaQuestion2().getText().contains("conjunto de instrucciones que permiten realizar una tarea")) {
				result = 1;
				iFrame.getTaQuestion2().setForeground(Color.GREEN);
			}else {
				result = -0.5;
				iFrame.getTaQuestion2().setForeground(Color.RED);
			}
			System.out.println("2 retorna " + result);

			return result;
		}
		
		
		
		//PUNTUAMOS LA QUESTION 4
		private double response4() {
			// TODO Auto-generated method stub
			double result = 0;
			if (iFrame.getJlQuestion4().getSelectedValue().equalsIgnoreCase("Un IDE para desarrollar aplicaciones")) {
				result = 1;
				iFrame.getJlQuestion4().setSelectionBackground(Color.GREEN);
			}else {
				result = -0.5;
				iFrame.getJlQuestion4().setSelectionBackground(Color.RED);
			}
			System.out.println("4 retorna " + result);
			return result;
		}
		
		
	
		//MOSTRAMOS LA PUNTUACION FINAL QUE HA OBTENIDO EL JUGADOR
		private void finalScore(User u) {
			// TODO Auto-generated method stub
			double finalScore = response1() + response2() + response3() + response4();
			u.setQ1(response1());
			u.setQ2(response2());
			u.setQ3(response3());
			u.setQ4(response4());
			u.setScore(finalScore);
			u.setTries(u.getTries()+1);
			JOptionPane.showMessageDialog(iFrame, "El resultado obtenido por " + iFrame.getTfPersonalData()[0].getText() + " es de " + finalScore + "." );
		}
		
		//RECOGEMOS LOS DATOS DEL USUARIO E INSTANCIAMOS UN OBJETO
		private void setUserInfo() throws ClassNotFoundException, SQLException {
			if(emptyDataValidator() == false) {
				String sex;
				if(iFrame.getRbMan().isSelected() == true) {
					sex = "Hombre";
				}else {
					sex = "Mujer";
				}
				User u = new User(iFrame.getTfPersonalData()[0].getText(), 
						iFrame.getTfPersonalData()[1].getText(), 
						sex);
			}
		}
		
		//VALIDAMOS SI EL USUARIO EXISTE YA EN LA BASE DE DATOS O NO
		private boolean userExist(User u) throws ClassNotFoundException, SQLException {
			boolean flag;
			u = u.getUserData(u.getName());
			if(u.getName() == null) {
				flag = false;
			}else {
				flag = true;
			}
			return flag;
		}
		
//		//REGISTRAMOS AL USUARIO O NO DEPENDIENDO DE SI ESTA O NO EN LA BD
//		private void userValidation() throws ClassNotFoundException, SQLException {
//			User u = new User();
//			if(userExist(u)) {
//				u.userUpdate(u.getTries(), u.getQ1(), u.getQ2(), u.getQ3(), u.getQ4(), u.getScore());					
//				JOptionPane.showMessageDialog(iFrame, "Usuario existente, actualizando datos");
//				iFrame.settingUserFields(u);
//			}else {
//				JOptionPane.showMessageDialog(iFrame, "No existe el user, lo damos de alta");
//				u.insertNewUser(iFrame);
//			}			
//		}
		
		private boolean emptyDataValidator() {
			// TODO Auto-generated method stub
			boolean empty = false;
			boolean checkFlag = false;
			//VALIDAMOS LOS TEXTFIELD
			JTextField[] txt = iFrame.getTfPersonalData();
			for (int i = 0; i < txt.length && empty == false; i++) {
				if(txt[i].getText().isBlank()) {
					empty = true;
				}
			}
			
			//VALIDAMOS LOS RADIO BUTTON
			if(!empty) {
				if(!iFrame.getRbMan().isSelected() && !iFrame.getRbWomen().isSelected()) {
					empty = true;
				}	
			}
			return empty;
		}
		
		
}
