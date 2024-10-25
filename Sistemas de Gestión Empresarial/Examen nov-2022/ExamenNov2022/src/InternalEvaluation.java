import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class InternalEvaluation extends JInternalFrame{

	private JLabel titVentana;
	private JLabel[] titlePersonalData;
	private JTextField[] tfPersonalData;
	private ButtonGroup radiosGroupSex;
	private JRadioButton rbMan;
	private JRadioButton rbWomen;
	
	private JLabel[] titleQuestions;
	private JCheckBox[] cbQuestion1;
	private JTextArea taQuestion2;
	private JRadioButton[] rbQuestion3;
	private ButtonGroup radiosGroupQ3;
	private JList<String> jlQuestion4;
	private JPanel centerPanel;
	
	private JButton btnQualify;
	
	private JButton btnSearch;
	
 	public InternalEvaluation() {
		// TODO Auto-generated constructor stub
		super();
		titleQuestions = new JLabel[4];
		this.setLayout(new BorderLayout());
		//INICIALIZAMOS EL TITLE Y LE DAMOS EL FORMATO QUE NECESITAMOS
		setWindowTitle();
		
		//GENERAMOS EL PANEL CENTRAL, GRID DONDE METEMOS DATOS
		generateCenterPanel();
		
		//AÑADIMOS LAS PREGUNTAS 1 Y 3 A LAS SEGUNDA CELDA DEL PANEL CENTRAL
		generateQuestions1_3();
		
		//ALADIMOS LAS PREGUNTAS 1 Y 4 A LA TERCERA CELDA DEL PANE CENTRAL
		generateQuestion2_4();
		
		//CAMBIAMOS LOS ESTILOS
		changeStyles();
		
		this.setVisible(true);
	}
 	// SETEAMOS LA VENTANA
 	private void setWindowTitle() {
		// TODO Auto-generated method stub
 		titVentana = new JLabel("EVALUACION FINAL", SwingConstants.CENTER);
 		titVentana.setFont(new Font("arial", Font.BOLD, 20));
 		titVentana.setForeground(Color.RED);
 		this.getContentPane().add(titVentana, BorderLayout.NORTH);
 		
 		btnQualify = new JButton("Calificar");
 		btnQualify.addActionListener(new InternalListener(this));
 		btnQualify.setActionCommand("qualify");
 		this.getContentPane().add(btnQualify, BorderLayout.SOUTH);
	}
 	// GENERAMOS EL PANEL CENTRAL QUE CONTENDRA LOS CONTROLES
 	private void generateCenterPanel() {
		// TODO Auto-generated method stub
 		centerPanel = new JPanel();
 		centerPanel.setLayout(new GridLayout(3,1));
 		this.add(centerPanel, BorderLayout.CENTER);
 		
 		generatePersonalData();
	}
 	// GENERAMOS EL PANEL DE LOS DATOS PERSONALES
 	private void generatePersonalData() {
		// TODO Auto-generated method stub
 		JPanel personalDataPanel = new JPanel();
 		personalDataPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
 		TitledBorder titlePesonalDataPanel = new TitledBorder("Datos Personales");
 		titlePesonalDataPanel.setTitleColor(Color.RED);
 		personalDataPanel.setBorder(titlePesonalDataPanel);
 		
 		setDataControls(personalDataPanel);
 		
 		centerPanel.add(personalDataPanel);
	}
 	//SETEAMOS LOS CONTROLES DEL PANEL DE DATOS PERSONALES
 	private void setDataControls(JPanel dataPanel) {
		// TODO Auto-generated method stub
 		JPanel subDataPanel = new JPanel();
 		subDataPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
 		subDataPanel.setPreferredSize(new Dimension(500,90));
 		
 		//LABELS Y TEXTFIELDS
 		titlePersonalData = new JLabel[3];
 		tfPersonalData = new JTextField[2];
 		String[] labelTitle = {"Nomber y Apellidos", "Fecha de Nacimineto", "Sexo"};
 		for (int i = 0; i < titlePersonalData.length; i++) {
			titlePersonalData[i] = new JLabel(labelTitle[i], SwingConstants.LEFT);
			titlePersonalData[i].setPreferredSize(new Dimension(200,20));
		}
 		for (int i = 0; i < tfPersonalData.length; i++) {
			tfPersonalData[i] = new JTextField(15);
		}
 		
 		btnSearch = new JButton("Buscar");
 		btnSearch.addActionListener(new InternalListener(this));
 		btnSearch.setActionCommand("search");
 		
 		//RADIOS
 		radiosGroupSex = new ButtonGroup();
 		rbMan = new JRadioButton("Hombre");
 		rbWomen = new JRadioButton("Mujer");
 		radiosGroupSex.add(rbMan);
 		radiosGroupSex.add(rbWomen);
 		
 		
 		//AÑADIMOS
 		subDataPanel.add(titlePersonalData[0]);
 		subDataPanel.add(tfPersonalData[0]);
 		subDataPanel.add(btnSearch);
 		subDataPanel.add(titlePersonalData[1]);
 		subDataPanel.add(tfPersonalData[1]);
 		subDataPanel.add(titlePersonalData[2]);
 		subDataPanel.add(rbMan);
 		subDataPanel.add(rbWomen);
 		
 		dataPanel.add(subDataPanel);
	}
 	
 	//GENERAMOS EL PANEL DE LAS QUESTIONS 1 3 
 	private void generateQuestions1_3() {
		// TODO Auto-generated method stub
 		JPanel Panel_1_3 = new JPanel();
 		Panel_1_3.setLayout(new GridLayout(1,2));
 		
 		//AÑADIMOS EL PANEL DE LA PREGUNTA 1
 		question1(Panel_1_3);
 		
 		//AÑADIMOS EL PANEL DE LA PREGUNTA 3
 		question3(Panel_1_3);
 		
 		//AÑADIMOS LE PANEL A LA VENTANA
 		centerPanel.add(Panel_1_3);
	}
 	
 	//SETEAMOS EL PANEL DE LOS CHECK BOXES
 	private void question1(JPanel p1_3) {
		// TODO Auto-generated method stub
 		String[] cbTitle = {"Ratón", "Sistema Operativo", "Juego de Ordenador", "Disquetera"};
 		
 		JPanel cb = new JPanel();
 		cb.setLayout(new FlowLayout(FlowLayout.LEFT));
 		cb.setPreferredSize(new Dimension(345,100));

 		//TITULO PREGUNTA
 		titleQuestions[0] = new JLabel("1.- Selecciona los elementos que sean Software", SwingConstants.LEFT);
 		cb.add(titleQuestions[0]);
 		
 		//CHECK BOXES DE LA PREGUNTA
 		cbQuestion1 = new JCheckBox[4];
 		for (int i = 0; i < cbQuestion1.length; i++) {
			cbQuestion1[i] = new JCheckBox(cbTitle[i]);
			cbQuestion1[i].setPreferredSize(new Dimension(200,20));
			cb.add(cbQuestion1[i]);
		}
 		p1_3.add(cb);
 	}
 	
 	//SETEAMOS EL PANEL DE LOS RADIO BOXES PREGUNTA 2
 	
 	private void question3(JPanel p1_3) {
		// TODO Auto-generated method stub
 		JPanel rb = new JPanel();
 		rb.setLayout(new FlowLayout(FlowLayout.LEFT));
 		rb.setPreferredSize(new Dimension(345,100));
 		
 		//TITULO PREGUNTA
 		titleQuestions[1] = new JLabel("2.- ¿Cuál es la deficinión de clase en POO?", SwingConstants.LEFT);
 		rb.add(titleQuestions[1]);
 		
 		//RADIOS
 		String[] rbTitle = {"Es un concepto similar a un 'Array'",
 				"Es un tipo particular de variable",
 				"Es un modelo a partir del cual creamos 'objetos'",
 				"Es una categoria de datos ordenada secuencialmente"};
 		
 		radiosGroupQ3 = new ButtonGroup();
 		rbQuestion3 = new JRadioButton[4];
 		for (int i = 0; i < rbQuestion3.length; i++) {
			rbQuestion3[i] = new JRadioButton(rbTitle[i]);
			rbQuestion3[i].setPreferredSize(new Dimension(300,18));
			radiosGroupQ3.add(rbQuestion3[i]);
			rb.add(rbQuestion3[i]);
 		}
 		p1_3.add(rb);
	}
 	
 	//GENERAMOS EL PANEL DE LA PREGUNTAS 2 4 
 	private void generateQuestion2_4() {
		// TODO Auto-generated method stub
 		JPanel panel_2_4 = new JPanel();
 		panel_2_4.setLayout(new GridLayout(1,2));
 		
 		//GENERAMOS EL PANEL DE LA PREGUNTA 2
 		question2(panel_2_4);
 		
 		//GENERAMOS LA PREGUNTA 4
 		question4(panel_2_4);
 		
 		//AÑADIMOS AL PANEL CENTRAL
 		centerPanel.add(panel_2_4);
	}
 	
 	//GENERAMOS PREGUNTA 2
	private void question2(JPanel panel_2_4) {
		// TODO Auto-generated method stub
		JPanel q2 = new JPanel();
 		q2.setLayout(new FlowLayout(FlowLayout.LEFT));

		//TITULO PREGUNTA
		titleQuestions[2] = new JLabel("3.- ¿Qué es un programa?", SwingConstants.LEFT);
		q2.add(titleQuestions[2]);
		
		// TEXT AREA
		taQuestion2 = new JTextArea(10,20);
		JScrollPane taScroll = new JScrollPane(taQuestion2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		taScroll.setPreferredSize(new Dimension(335,100));
		q2.add(taScroll);
		
		panel_2_4.add(q2);
	}
	//GENERAMOS PREGUNTA 4
	private void question4(JPanel panel_2_4) {
		// TODO Auto-generated method stub
		JPanel q4 = new JPanel();
 		q4.setLayout(new FlowLayout(FlowLayout.LEFT));

		//TITULO PREGUNTA
		titleQuestions[3] = new JLabel("4.- ¿Qué es Eclipse?", SwingConstants.LEFT);
		q4.add(titleQuestions[3]);
		
		//LISTA DE sTRING CON LISTMODEL
		DefaultListModel<String> listQ4 = new DefaultListModel<String>();
		listQ4.addElement("Una librería de Java");
		listQ4.addElement("Una versión de Javva especial para servidores");
		listQ4.addElement("Un IDE para desarrollar aplicaciones");
		listQ4.addElement("Ninguna de las anteriores");
		
		jlQuestion4 = new JList<String>(listQ4);
		
		q4.add(jlQuestion4);
		
		panel_2_4.add(q4);
	}
	
	//CAMBIAMOS LOS ESTILOS DE LOS ELEMENTOS QUE LO NECESITEN
	private void changeStyles() {
		// TODO Auto-generated method stub
		for (int i = 0; i < titleQuestions.length; i++) {
			titleQuestions[i].setForeground(Color.RED);
		}
		jlQuestion4.setBackground(Color.PINK);
	}
	
	
	public JLabel getTitVentana() {
		return titVentana;
	}
	public void setTitVentana(JLabel titVentana) {
		this.titVentana = titVentana;
	}
	public JLabel[] getTitlePersonalData() {
		return titlePersonalData;
	}
	public void setTitlePersonalData(JLabel[] titlePersonalData) {
		this.titlePersonalData = titlePersonalData;
	}
	public JTextField[] getTfPersonalData() {
		return tfPersonalData;
	}
	public void setTfPersonalData(JTextField[] tfPersonalData) {
		this.tfPersonalData = tfPersonalData;
	}
	public ButtonGroup getRadiosGroupSex() {
		return radiosGroupSex;
	}
	public void setRadiosGroupSex(ButtonGroup radiosGroupSex) {
		this.radiosGroupSex = radiosGroupSex;
	}
	public JRadioButton getRbMan() {
		return rbMan;
	}
	public void setRbMan(JRadioButton rbMan) {
		this.rbMan = rbMan;
	}
	public JRadioButton getRbWomen() {
		return rbWomen;
	}
	public void setRbWomen(JRadioButton rbWomen) {
		this.rbWomen = rbWomen;
	}
	public JLabel[] getTitleQuestions() {
		return titleQuestions;
	}
	public void setTitleQuestions(JLabel[] titleQuestions) {
		this.titleQuestions = titleQuestions;
	}
	public JCheckBox[] getCbQuestion1() {
		return cbQuestion1;
	}
	public void setCbQuestion1(JCheckBox[] cbQuestion1) {
		this.cbQuestion1 = cbQuestion1;
	}
	public JTextArea getTaQuestion2() {
		return taQuestion2;
	}
	public void setTaQuestion2(JTextArea taQuestion2) {
		this.taQuestion2 = taQuestion2;
	}
	public JRadioButton[] getRbQuestion3() {
		return rbQuestion3;
	}
	public void setRbQuestion3(JRadioButton[] rbQuestion3) {
		this.rbQuestion3 = rbQuestion3;
	}
	public ButtonGroup getRadiosGroupQ3() {
		return radiosGroupQ3;
	}
	public void setRadiosGroupQ3(ButtonGroup radiosGroupQ3) {
		this.radiosGroupQ3 = radiosGroupQ3;
	}
	public JList<String> getJlQuestion4() {
		return jlQuestion4;
	}
	public void setJlQuestion4(JList<String> jlQuestion4) {
		this.jlQuestion4 = jlQuestion4;
	}
	public JPanel getCenterPanel() {
		return centerPanel;
	}
	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}
	public JButton getBtnQualify() {
		return btnQualify;
	}
	public void setBtnQualify(JButton btnQualify) {
		this.btnQualify = btnQualify;
	}
}
