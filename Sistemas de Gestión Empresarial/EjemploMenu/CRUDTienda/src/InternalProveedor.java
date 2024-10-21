import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class InternalProveedor extends JInternalFrame {
	
	private MainWin mw;
	private JTextField tfCod, tfNombre, tfTipo;
	private JLabel lblCod, lblNombre, lblTipo, lblActivo, lblTitulo;;
	private JRadioButton rbSi, rbNo;
	private JButton btnCerrar, btnAccion, btnAux;
	private ButtonGroup radios;

	public InternalProveedor(MainWin mw, int option) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		super();
		this.mw = mw;
		
		switch(option) {
		case 1:
			Proveedor p = new Proveedor();
			crearVentana("Añadir Proveedor");
			tfCod.setText(String.valueOf(p.calcularPk()));
			tfCod.setEditable(false);

			btnAccion.addActionListener(e -> {
				try {
					this.AñadirProveedor(p);
					this.limpiarCampos();
					tfCod.setText(String.valueOf(p.calcularPk()));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			break;
		case 2:
			p = new Proveedor();
			crearVentana("Consultar Proveedor");
			setearCamposConsulta();
			btnAccion.addActionListener(e -> {
				try {
					this.consultarProveerdor(p);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			break;
		case 3:
			p = new Proveedor();
			crearVentana("Actualizar Proveedor");
			btnAux = new JButton("Buscar Proveedor");
			this.add(btnAux);
			btnAccion.setEnabled(false);
			btnAux.addActionListener(e -> {
				try {
					this.consultarProveerdor(p);
					btnAccion.setEnabled(true);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			btnAccion.addActionListener(e -> {
				try {
					this.actualizarProveerdor(p);
					this.limpiarCampos();
					btnAccion.setEnabled(false);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			break;
		case 4:
			p = new Proveedor();
			crearVentana("Eliminar Proveedor");
			setearCamposConsulta();
			btnAux = new JButton("Buscar Proveedor");
			this.add(btnAux);
			btnAccion.setEnabled(false);
			btnAux.addActionListener(e -> {
				try {
					this.consultarProveerdor(p);
					btnAccion.setEnabled(true);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			btnAccion.addActionListener(e -> {
				try {
					this.borrarProveedor(p);
					this.limpiarCampos();
					tfCod.setText("");
					btnAccion.setEnabled(false);
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			break;
		}
	}

	private void crearVentana(String tituloVentana) {
		this.setTitle(tituloVentana);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblTitulo = new JLabel(tituloVentana, SwingConstants.CENTER);
		lblTitulo.setPreferredSize(new Dimension(400,20));
		lblTitulo.setFont(new Font("arial", Font.BOLD, 20));
		tfCod = new JTextField(10);
		tfNombre = new JTextField(20);
		tfTipo = new JTextField(10);
		lblCod = new JLabel("Codigo:");
		lblCod.setPreferredSize(new Dimension(400,20));
		lblActivo = new JLabel("Activo:");
		lblActivo.setPreferredSize(new Dimension(400,20));
		lblNombre = new JLabel("Nombre:");
		lblNombre.setPreferredSize(new Dimension(400,20));
		lblTipo = new JLabel("Tipo:");
		lblTipo.setPreferredSize(new Dimension(400,20));
		rbNo = new JRadioButton("No");
		rbSi = new JRadioButton("Si");
		rbSi.setPreferredSize(new Dimension(200,20));
		radios = new ButtonGroup();
		radios.add(rbNo);
		radios.add(rbSi);
		btnAccion = new JButton(tituloVentana);
		btnAccion.setActionCommand(tituloVentana);
		btnCerrar = new JButton("Cerrar Ventana");
		btnCerrar.addActionListener(e -> this.dispose());
		btnCerrar.setActionCommand("cerrar");
		
		this.add(lblTitulo);
		this.add(lblCod);
		this.add(tfCod);
		this.add(lblNombre);
		this.add(tfNombre);
		this.add(lblTipo);
		this.add(tfTipo);
		this.add(lblActivo);
		this.add(rbNo);
		this.add(rbSi);
		this.add(btnCerrar);
		this.add(btnAccion);
		
		
	
		this.setVisible(true);
		mw.getContentPane().removeAll();
		mw.getContentPane().add(this);
	}
	
	public void AñadirProveedor(Proveedor p) throws ClassNotFoundException, SQLException {
		boolean flag = false;
		if(!rbSi.isSelected() && !rbNo.isSelected()) {
			flag=true;
		}
		
		if(tfNombre.getText().isBlank() || tfCod.getText().isBlank() || tfTipo.getText().isBlank() || flag) {
			JOptionPane.showMessageDialog(this, "No puede dejar campos vacio");
		}else {		
			p.setCodProv(Integer.parseInt(tfCod.getText()));			
			p.setNombre(tfNombre.getText());
			p.setTipo(tfTipo.getText());
			if(rbNo.isSelected()) {
				p.setActivo(false);
			}else {
				p.setActivo(true);
			}
			p.insertarProveedor();
			JOptionPane.showMessageDialog(this, "Proveedor Añadido");
		}
	}
	
	private void consultarProveerdor(Proveedor p) throws NumberFormatException, ClassNotFoundException, SQLException {
		p = p.consultarProveedor(Integer.parseInt(tfCod.getText()));
		tfNombre.setText(p.getNombre());
		tfTipo.setText(p.getTipo());
		if(p.isActivo()) {
			rbSi.setSelected(true);
		}else {
			rbNo.setSelected(true);
		}
		if(p.getNombre() == null) {
			JOptionPane.showMessageDialog(this, "No existe el proveedor");
			tfCod.setText("");
		}
	}
	
	private void actualizarProveerdor(Proveedor p) throws NumberFormatException, ClassNotFoundException, SQLException {
		p.setNombre(tfNombre.getText());
		p.setTipo(tfTipo.getText());
		if(rbSi.isSelected()) {
			p.setActivo(true);
		}else {
			p.setActivo(false);
		}
		p.actualizarProveedor(Integer.parseInt(tfCod.getText()));
		JOptionPane.showMessageDialog(this, "Proveedor Actualizado");
	}
	
	private void borrarProveedor(Proveedor p) throws NumberFormatException, ClassNotFoundException, SQLException {
		int option = JOptionPane.showConfirmDialog(this, "Desea borrar el proveedor "+ tfNombre.getText());
		System.err.println(option);
		if(option == 0) {
			p.borrarProveedor(Integer.parseInt(tfCod.getText()));
			JOptionPane.showMessageDialog(this, "Proveedor Eliminado");			
		}
	}
	
	
	
	public void limpiarCampos() throws ClassNotFoundException, SQLException {
		tfNombre.setText("");
		tfTipo.setText("");
		radios.clearSelection();	
	}
	
	private void setearCamposConsulta() {
		tfCod.setEditable(true);
		tfNombre.setEditable(false);
		tfTipo.setEditable(false);
		rbSi.setEnabled(false);
		rbNo.setEnabled(false);
	}
	
}
