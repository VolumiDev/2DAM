import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
			if(emptyValidate() == false && dateValidator() == false) {
				//PROCEDEMOS CON LA CALIFICACION
			}
			break;
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
		}
		return flag;
	}

}
