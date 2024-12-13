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

//VISIBILIDAD
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

**Metodos**
```java
//CONSTRUCTOR POR DEFECTO
Jlabel();

//MUESTRA ETIQUETA CON EL CONTENIDO DEL STRING QUE LE PASAMOS COMO PARAMETRO
JLabel(String etq);

//ETIQUETA CON IMAGEN ESPECIFICADA
JLabel(ImageIcon imagen);

//MUESTRA LA IMAGEN QUE SE LE PASA POR PARAMETRO Y CON LA ALINEACION QUE SE ESPECIFCA EN EL SEGUNDO PARAMETRO
JLabel(ImageIcon imagen, int alineación_horizontal);
	//left, rigth, center, leading, trailing

//MUESTRA LA CADENA DE TEXTO DEL PARAMETRO Y LA ALINEACION QUE SE LE PASA POR PARAMETRO
JLabel(String etiq, int alineación horizontal);
	//left, rigth, center, leading, trailing

//ETIQUETA CON IMAGEN TEXTO Y LA ALINEACION ESPECIFICADA
JLabel(String etiq, Icon Image, int alineación horizontal);

//SETEA EL CONTENIDO DEL LABEL
lbl.setText(String txt);

//SETEA EL ICONO
lbl.setIcon(ImageIcon img);

//RETORNA EL CONTENIDO DE LA LABEL
lbl.getText();
```
### JTextField
Cuadro de texto.

```java
//Algunos de los constructores son:

//por defecto conteniendo la cadena vacía y con 0 columnas.
JTextField() Constructor 

//Contenido vacío pero longitud prefijada inicial.
JTextField(int columnas); 

//Campo de texto con un valor inicial.
JTextField(String texto); 

//Las dos anteriores combinadas.
JTextField(String texto, int columnas);

//Algunos de los metodos

//Estable la fuente actual
setFont(Font f);

// Si se pone a false no se podrá escribir sobre el campo de edición.
setEditable(boolean); 

//igual que el anterior pero pone la caja de texto en gris, por lo que puede que su contenido no se vea claramente y además ni siquiera se puede copiar su contenido, mientras que con SetEditable sí.
setEnabled(boolean); 

//asigna la cadena de caracteres que aparecerá cunado nos posiciones sobre la caja de texto.
setToolTipText(String); 

//Para saber el trozo de texto que ha sido seleccionado por el usuario. Muy útil para las acciones de "Copiar", "Cortar" y "Pegar".
int getSelectionStart(), int getSelectionEnd();

//Para marcar una porción de texto. En realidad setSelectionEnd(int fin) indica una posición más allá de la última a marcar. Por ejemplo, para marcar los caracteres 2,3 y 4 (tercer, cuarto y quinto carácter) se utilizaría:
void setSelectionStart(int inicio), void setSelectionEnd(int fin); 
texto.setSelectionStart(2);
texto.setSelectionEnd(5);

//vuelve el foco a la caja de texto 
void requestFocus(); 
```

### JPasswordField
```java
setEechChar(Char)
```
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