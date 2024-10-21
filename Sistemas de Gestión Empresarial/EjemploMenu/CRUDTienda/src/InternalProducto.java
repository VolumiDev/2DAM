import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.spi.CalendarDataProvider;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InternalProducto  extends JInternalFrame{

	private MainWin mw;
	private JTextField tfRef, tfArticulo, tfDescrip, tfPrecio, tfStock;
	private JLabel lblRef, lblArticulo, lblDescrip, lblPrecio, lblStock, lblProveedor, lblTitulo;
	private JButton btnCerrar, btnAccion, btnAux;
	private JComboBox<Proveedor> cbProveedor;
	
	public InternalProducto(MainWin mw, int option) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		super();
		this.mw = mw;
		
		if(validarSiProveedores()) {
			JOptionPane.showMessageDialog(this, "No hay ningun proveedor dado de alta.");
			this.dispose();
		}else {
			switch(option) {
			case 1:
				Producto p = new Producto();
				crearVentana("Añadir Producto");
				tfRef.setText(String.valueOf(p.calcularPk()));
				tfRef.setEditable(false);
				btnAccion.addActionListener(e -> {
					try {
						this.AñadirProducto(p);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				break;
			case 2:
				p = new Producto();
				crearVentana("Consultar Proveedor");
				setearCamposConsulta();
				btnAccion.addActionListener(e -> {
					try {
						this.consultarProducto(p);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				break;
			case 3:
				p = new Producto();
				crearVentana("Actualizar Proveedor");
				btnAux = new JButton("Buscar Proveedor");
				this.add(btnAux);
				btnAccion.setEnabled(false);
				btnAux.addActionListener(e -> {
					try {
						this.consultarProducto(p);
						btnAccion.setEnabled(true);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				btnAccion.addActionListener(e -> {
					try {
						this.actualizarProducto(p);
						this.limpiarCampos();
						btnAccion.setEnabled(false);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				break;
			}
			
		}
		
		
		
	}
	
	

	private void crearVentana(String tituloVentana) throws ClassNotFoundException, SQLException {
		mw.setSize(400,500);
		Producto p = new Producto();
		this.setTitle(tituloVentana);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblTitulo = new JLabel(tituloVentana);
		lblTitulo.setPreferredSize(new Dimension(400,20));

		lblRef = new JLabel("Referencia articulo"); 
		lblRef.setPreferredSize(new Dimension(400,20));

		lblArticulo = new JLabel("Articulo");
		lblArticulo.setPreferredSize(new Dimension(400,20));

		lblDescrip = new JLabel("Descripcion articulo");
		lblDescrip.setPreferredSize(new Dimension(400,20));

		lblPrecio = new JLabel("Precio");
		lblPrecio.setPreferredSize(new Dimension(400,20));

		lblStock = new JLabel("Stock");
		lblStock.setPreferredSize(new Dimension(400,20));

		lblProveedor = new JLabel("Proveedor");
		lblProveedor.setPreferredSize(new Dimension(400,20));

		btnAccion = new JButton(tituloVentana);
		btnAccion.setActionCommand(tituloVentana);
		btnCerrar = new JButton("Cerrar Ventana");
		btnCerrar.addActionListener(e -> this.dispose());
		btnCerrar.setActionCommand("cerrar");
		
		tfRef = new JTextField(10);
		tfArticulo = new JTextField(20);
		tfDescrip = new JTextField(20);
		tfPrecio = new JTextField(10);
		tfStock = new JTextField(10);
		DefaultComboBoxModel<Proveedor> modelProveedores = new DefaultComboBoxModel<Proveedor>();
		ArrayList<Proveedor> listaProv = new ArrayList<Proveedor>();
		listaProv = p.listaProveedores();
		for (Proveedor i : listaProv) {
			modelProveedores.addElement(i);
		}
		cbProveedor = new JComboBox<Proveedor>(modelProveedores);
		cbProveedor.setPreferredSize(new Dimension(250,20));
		
		this.add(lblTitulo);
		this.add(lblRef);
		this.add(tfRef);
		this.add(lblArticulo);
		this.add(tfArticulo);
		this.add(lblDescrip);
		this.add(tfDescrip);
		this.add(lblPrecio);
		this.add(tfPrecio);
		this.add(lblStock);
		this.add(tfStock);
		this.add(lblProveedor);
		this.add(cbProveedor);
		this.add(btnCerrar);
		this.add(btnAccion);
		
		this.setVisible(true);
		mw.getContentPane().removeAll();
		mw.getContentPane().add(this);
	}
	
	public void AñadirProducto(Producto p) throws ClassNotFoundException, SQLException {
		if(tfArticulo.getText().isBlank() || tfDescrip.getText().isBlank() || tfPrecio.getText().isBlank() || tfStock.getText().isBlank() || cbProveedor.getSelectedItem()==null ) {
			JOptionPane.showMessageDialog(this, "No puede dejar campos vacio");
		}else {		
			p.setRef(Integer.parseInt(tfRef.getText()));
			p.setArticulo(tfArticulo.getText());
			p.setDescripcion(tfDescrip.getText());
			p.setPrecio(Double.parseDouble(tfPrecio.getText()));
			p.setStock(Integer.parseInt(tfStock.getText()));
			p.setCodProveedor(((Proveedor) cbProveedor.getSelectedItem()).getCodProv());
			p.insertarProducto();
			limpiarCampos();
			tfRef.setText(String.valueOf(p.calcularPk()));
			JOptionPane.showMessageDialog(this, "Producto Añadido");
		}
	}
	
	
	public void limpiarCampos() throws ClassNotFoundException, SQLException {
		tfArticulo.setText("");
		tfDescrip.setText("");
		tfPrecio.setText("");
		tfStock.setText("");
	}
	
	private void setearCamposConsulta() {
		tfArticulo.setEditable(false);
		tfDescrip.setEditable(false);
		tfPrecio.setEditable(false);
		tfStock.setEditable(false);
		cbProveedor.setEditable(false);
	}
	
	private void consultarProducto(Producto p) throws NumberFormatException, ClassNotFoundException, SQLException {
		p = p.consultarProducto(Integer.parseInt(tfRef.getText()));
		tfArticulo.setText(p.getArticulo());
		tfDescrip.setText(p.getDescripcion());
		tfPrecio.setText(String.valueOf(p.getPrecio()));
		tfStock.setText(String.valueOf(p.getStock()));
		cbProveedor.setSelectedIndex(p.getCodProveedor()-1);
		if(p.getArticulo() == null) {
			JOptionPane.showMessageDialog(this, "No existe el produto");
			tfRef.setText("");
		}
	}
	
	private boolean validarSiProveedores() throws SQLException, ClassNotFoundException {
		boolean flag = false;
		Conexion con = new Conexion();
		ResultSet rs = con.consulta("select count(*) from proveedores");
		while(rs.next()) {
			if(rs.getInt(1) == 0) {
				flag = true;
			}else {
				flag = false;
			}
		}
		con.cerrar();
		return flag;
	}
	
	private void actualizarProducto(Producto p) {
		// TODO Auto-generated method stub
		p.setArticulo(tfArticulo.getText());
		p.setDescripcion(tfDescrip.getText());
		p.setPrecio(Double.parseDouble(tfPrecio.getText()));
		p.setStock(Integer.parseInt(tfStock.getText()));
		p.setCodProveedor(((Proveedor) cbProveedor.getSelectedItem()).getCodProv());
		JOptionPane.showMessageDialog(this, "Proveedor Actualizado");
	}
	
	
	
	
	

	public MainWin getMw() {
		return mw;
	}

	public void setMw(MainWin mw) {
		this.mw = mw;
	}

	public JTextField getTfRef() {
		return tfRef;
	}

	public void setTfRef(JTextField tfRef) {
		this.tfRef = tfRef;
	}

	public JTextField getTfArticulo() {
		return tfArticulo;
	}

	public void setTfArticulo(JTextField tfArticulo) {
		this.tfArticulo = tfArticulo;
	}

	public JTextField getTfDescrip() {
		return tfDescrip;
	}

	public void setTfDescrip(JTextField tfDescrip) {
		this.tfDescrip = tfDescrip;
	}

	public JTextField getTfPrecio() {
		return tfPrecio;
	}

	public void setTfPrecio(JTextField tfPrecio) {
		this.tfPrecio = tfPrecio;
	}

	public JTextField getTfStock() {
		return tfStock;
	}

	public void setTfStock(JTextField tfStock) {
		this.tfStock = tfStock;
	}

	public JLabel getLblRef() {
		return lblRef;
	}

	public void setLblRef(JLabel lblRef) {
		this.lblRef = lblRef;
	}

	public JLabel getLblArticulo() {
		return lblArticulo;
	}

	public void setLblArticulo(JLabel lblArticulo) {
		this.lblArticulo = lblArticulo;
	}

	public JLabel getLblDescrip() {
		return lblDescrip;
	}

	public void setLblDescrip(JLabel lblDescrip) {
		this.lblDescrip = lblDescrip;
	}

	public JLabel getLblPrecio() {
		return lblPrecio;
	}

	public void setLblPrecio(JLabel lblPrecio) {
		this.lblPrecio = lblPrecio;
	}

	public JLabel getLblStock() {
		return lblStock;
	}

	public void setLblStock(JLabel lblStock) {
		this.lblStock = lblStock;
	}

	public JLabel getLblProveedor() {
		return lblProveedor;
	}

	public void setLblProveedor(JLabel lblProveedor) {
		this.lblProveedor = lblProveedor;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	public JButton getBtnAccion() {
		return btnAccion;
	}

	public void setBtnAccion(JButton btnAccion) {
		this.btnAccion = btnAccion;
	}

	public JButton getBtnAux() {
		return btnAux;
	}

	public void setBtnAux(JButton btnAux) {
		this.btnAux = btnAux;
	}

	public JComboBox<Proveedor> getProveedor() {
		return cbProveedor;
	}

	public void setProveedor(JComboBox<Proveedor> proveedor) {
		this.cbProveedor = proveedor;
	}
	
}
