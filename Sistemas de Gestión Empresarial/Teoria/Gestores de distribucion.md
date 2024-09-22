# TIPOS DE CONTENEDORES
### JFrame 
(Ventana Basica)
```java
JFrame new_window = new JFrame("titulo de la ventana");
```
### JDialog 	
Venta tido dialogo.

### JPane
Paneles donde se almacenan otros componentes.

### JScrollPane
Vincular barras de scroll a nuestra aplicación

### JsplitPane
Contenedor dividido en dos secciones.

### JTabbedPane
Creacion de pestañas en la pestaña principa.

### JDescktopPane 
Aloja componentes de tipo JInternalFrame, que son ventanas internas dentro de la pestaña principal.

### JTooBar 
Representa una barra de herramientas dentro de la la aplicación. 

**Metodos:**
```java
JFrame() nw = new JFrame();
//TAMAÑO
nw.setSize(int ancho, int alto);
//POSICION
nw.setLocation(int x, int y);
//POSICION TAMAÑO
nw.setBounds(int x, int y, int ancho, int alto);
//VISIBILIDAD<>
nw.setVisible(boolean estado);
//OPERACION QUE SUCEDERÁ AL CERRAR LA VENTANA
nw.setDefaultCloseOperation(int operacion); //salir del programa, no hacer nada, ocultar la ventana, liberar recursos de la ventana
//ASIGNAR TITULO A LA VENTANA
nw.setTitle(String titulo);
//USUARIO PUEDE CAMBIAR TAMAÑO DE LA VENTANA
nw.setResizable(boolean resize);
//ESTABLEZE EL ESTADO DE LA VENTANA 
nw.setExtendedState(int state); //normal, iconified, maximized_both, maximized_horiz, maximized_vert
//RETORNA EL ELEMENTO CONTENTPANE
nw.getContentPane()
//CAMBIA EL COLOR DE FONDO
nw.getContentPane().setBackgroud(Color color);
//SET LAYOUT
nw.getContentPane().setLayout(LayoutManager layout);
//ESTALECE LA BARRA DE MENU PARA EL FRAME
nw.setJMenuBar(JmenuBar menu);
```

# CONTROLES
### JButton
Boton estandard.
### Jlabel
Etiqueta de texto estandard.
### JTextField
Cuadro de texto.
### JTextArea
Cuadro de texto multilinea.
### JCheckBox
Casilla de verificación.
### JRadioButton
Boton de opción.
### JComboBox
Lista de desplegue.



# GESTORES DE DISTRIBUCION
	-FlowLayout -> Va colocando consecutivamente
	-GridLayout -> Divide la ventana en un determinado numero de filas y columnas
	-BorderLayout -> Divide la pantalla en 5 zonas
		-north
		-south
		-west
		-east
		-center
		-Pañadirlo tienes que indicar a que zona de las 5 tienes que indicar a que zona