package guis;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloEmpleados;
import clases.Cliente;
import clases.Empleados;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class FrmEmpleados extends JInternalFrame implements ActionListener, KeyListener, MouseListener {
	
	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblRazonSocial;
	private JLabel lblRubro;
	private JLabel lblLugarProcedencia;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JComboBox<String> cboEstado;
	private JScrollPane scrollPane;
	private JButton btnOK;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblEmpleados;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpleados frame = new FrmEmpleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmEmpleados() {
		setResizable(false);
		setTitle("REGISTRO | EMPLEADOS");
		setBounds(100, 100, 1000, 611);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("Codigo    :");
		lblCodigo.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblCodigo.setBounds(223, 31, 69, 23);
		getContentPane().add(lblCodigo);

		lblNombre = new JLabel("Nombre  :");
		lblNombre.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblNombre.setBounds(223, 54, 69, 23);
		getContentPane().add(lblNombre);

		lblRazonSocial = new JLabel("Apellido  :");
		lblRazonSocial.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblRazonSocial.setBounds(223, 79, 69, 23);
		getContentPane().add(lblRazonSocial);

		lblRubro = new JLabel("Estado     :");
		lblRubro.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblRubro.setBounds(223, 104, 69, 23);
		getContentPane().add(lblRubro);

		lblLugarProcedencia = new JLabel("Telefono:");
		lblLugarProcedencia.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblLugarProcedencia.setBounds(223, 129, 69, 23);
		getContentPane().add(lblLugarProcedencia);

		txtCodigo = new JTextField();
		txtCodigo.setForeground(new Color(45, 45, 255));
		txtCodigo.setBounds(292, 29, 121, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(45, 45, 255));
		txtNombre.setBounds(292, 54, 251, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setForeground(new Color(45, 45, 255));
		txtApellido.setBounds(292, 79, 251, 23);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(45, 45, 255));
		txtTelefono.setBounds(292, 129, 121, 23);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

		cboEstado = new JComboBox<String>();
		cboEstado.setForeground(new Color(45, 45, 255));
		cboEstado.setModel(
				new DefaultComboBoxModel(new String[] {"Soltero", "Casado", "Divorciado"}));
		cboEstado.setBounds(292, 104, 121, 23);
		getContentPane().add(cboEstado);

		btnOK = new JButton("OK");
		btnOK.setForeground(new Color(255, 255, 255));
		btnOK.setFont(new Font("Roboto Black", Font.BOLD, 15));
		btnOK.setBackground(new Color(255, 60, 65));
		btnOK.setIcon(new ImageIcon(FrmEmpleados.class.getResource("/iconos/aceptar.png")));
		btnOK.addActionListener(this);
		btnOK.setBounds(436, 111, 100, 32);
		getContentPane().add(btnOK);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnAdicionar.setBackground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(FrmEmpleados.class.getResource("/iconos/anadir.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(624, 16, 121, 32);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnModificar.setBackground(new Color(255, 255, 255));
		btnModificar.setIcon(new ImageIcon(FrmEmpleados.class.getResource("/iconos/boligrafo.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(623, 60, 121, 32);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(FrmEmpleados.class.getResource("/iconos/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(624, 103, 122, 32);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 220, 949, 349);
		getContentPane().add(scrollPane);

		tblEmpleados = new JTable(){
            // Para que no se puedan editar los elementos desde la tabla
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
		tblEmpleados.setForeground(new Color(45, 45, 255));
		tblEmpleados.setGridColor(new Color(255, 255, 255));
		tblEmpleados.addKeyListener(this);
		tblEmpleados.addMouseListener(this);
		tblEmpleados.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblEmpleados);

		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("DNI");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("ESTADO");
		tblEmpleados.setModel(modelo);

		txtCodigo.setEditable(false);
		
		JButton btnBuscar = new JButton("Buscar Empleados");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setIcon(new ImageIcon(FrmEmpleados.class.getResource("/iconos/buscar.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String textoABuscar = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar:", "Buscar", 3);
				
				ArrayList<Empleados> s = ac.buscarEmpleados(textoABuscar);
				
				listar(0, s);
				editarFila();
				
			}
		});
		btnBuscar.setBounds(600, 143, 172, 32);
		getContentPane().add(btnBuscar);
		
		btnCancelarBusqueda = new JButton("Cancelar Busqueda");
		btnCancelarBusqueda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelarBusqueda.setBackground(new Color(255, 255, 255));
		btnCancelarBusqueda.setIcon(new ImageIcon(FrmEmpleados.class.getResource("/iconos/portapapeles.png")));
		btnCancelarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listar(0);
				editarFila();
				
			}
		});
		btnCancelarBusqueda.setBounds(600, 177, 172, 32);
		getContentPane().add(btnCancelarBusqueda);
		
		JLabel lblNewLabel = new JLabel("Dni       :");
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblNewLabel.setBounds(226, 160, 65, 14);
		getContentPane().add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setForeground(new Color(45, 45, 255));
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(292, 156, 121, 23);
		getContentPane().add(txtDni);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpieza();
				habilitarEntradas(false);
				habilitarBotones(true);
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(255, 60, 65));
		btnCancelar.setIcon(new ImageIcon(FrmEmpleados.class.getResource("/iconos/error.png")));
		btnCancelar.setBounds(436, 154, 100, 36);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrmEmpleados.class.getResource("/imagenes/FONDO EMPLEADOS.png")));
		lblNewLabel_1.setBounds(-16, -8, 1000, 626);
		getContentPane().add(lblNewLabel_1);

		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar(0);
		editarFila();

		

		
	}

//  Declaración global
	ArregloEmpleados ac = new ArregloEmpleados();
	private JButton btnCancelarBusqueda;
	private JTextField txtDni;
	private JButton btnCancelar;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOK) {
			actionPerformedBtnOK(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		if (ac.tamanio() == 0)
			btnOK.setEnabled(true);
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		habilitarEntradas(true);
		limpieza();
		txtNombre.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(true);
		if (ac.tamanio() == 0) {
			btnOK.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen Clientes");
		} else {
			btnOK.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			
			txtDni.setEditable(false);
			
//			ac.grabarEmpleados(); // Modificar archivo
			
			txtNombre.requestFocus();
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOK.setEnabled(false);
		if (ac.tamanio() == 0) {
			btnEliminar.setEnabled(false);
			mensaje("No existen Empleados");
		} else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿ Desea eliminar el registro ?");
			if (ok == 0) {
				Empleados x = ac.buscar(leerCodigo());
				int posFila = tblEmpleados.getSelectedRow();
				if (posFila == ac.tamanio() - 1)
					posFila--;
				ac.eliminar(x);
				
				ac.grabarEmpleados(); // Modificar el archivo
				
				listar(posFila);
				editarFila();
			}
		}
	}

	protected void actionPerformedBtnOK(ActionEvent arg0) {
		int codigo = leerCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String apellido = leerApellido();
			if (apellido.length() > 0) {
				String telefono = leerTelefono();
				if (telefono.length() > 0) {
					String estado = leerEstado();
					if (estado.length() > 0) {
						
						String dni = leerDni();
						if (dni.length() == 7) {
//							try {
								if (btnAdicionar.isEnabled() == false) {
									if (ac.buscar(dni) == null) {
										Empleados nueva = new Empleados(codigo, nombre, apellido, dni, telefono, estado);
										ac.adicionar(nueva);
										
										ac.grabarEmpleados(); // Modificar archivos
										
										btnAdicionar.setEnabled(true);
										listar(tblEmpleados.getRowCount());
										habilitarEntradas(false);
									}
									 else
										error("El DNI " + dni + " ya existe", txtDni);
								}
								if (btnModificar.isEnabled() == false) {
									Empleados x = ac.buscar(codigo);
									x.setNombre(nombre);
									x.setApellido(apellido);;
									x.setDni(dni);
									x.setTelefono(telefono);
									x.setEstado(estado);				
									ac.grabarEmpleados(); // Modificar archivos
									
									btnModificar.setEnabled(true);
									listar(tblEmpleados.getSelectedRow());
									habilitarEntradas(false);
								}
//							} catch (Exception x) {
//								error("Ingrese ESTATURA correcta", txtEstatura);
//							}
						} else {
							error("Ingrese DNI correcto", txtDni);
						}
					} 
				} else 
					error("Ingrese TELEFONO correcto", txtTelefono);
			} else
				error("ingrese APELLIDO correcta", txtApellido);
		} else
			error("ingrese NOMBRE correcto", txtNombre);
	}

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();
	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblEmpleados) {
			mouseClickedTblPersona(arg0);
		}
	}

	protected void mouseClickedTblPersona(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	// Métodos tipo void (sin parámetros)
	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblEmpleados.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18)); // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20)); // apellido
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); // dni
		tcm.getColumn(4).setPreferredWidth(anchoColumna(13)); // telefono
		tcm.getColumn(5).setPreferredWidth(anchoColumna(13)); // estado
	}

	void listar(int posFila) {
		modelo.setRowCount(0);
		Empleados x;
		for (int i = 0; i < ac.tamanio(); i++) {
			x = ac.obtener(i);
			Object[] fila = { x.getCodigo(), x.getNombre(), x.getApellido(), x.getDni() ,x.getTelefono(),
					x.getEstado()};
			modelo.addRow(fila);
		}
		tblEmpleados.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void listar(int posFila, ArrayList<Empleados> s) {
		modelo.setRowCount(0);
		Empleados x;
		for (int i = 0; i < s.size(); i++) {
			x = s.get(i);
			Object[] fila = { x.getCodigo(), x.getNombre(), x.getApellido(), x.getDni() ,x.getTelefono(),
					x.getEstado()};
			modelo.addRow(fila);
		}
		tblEmpleados.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void editarFila() {
		if (ac.tamanio() == 0)
			limpieza();
		else {
			Empleados x = ac.buscar(Integer.parseInt(tblEmpleados.getValueAt(tblEmpleados.getSelectedRow(), 0).toString()));
			txtCodigo.setText("" + x.getCodigo());
			txtNombre.setText(x.getNombre());
			txtApellido.setText(x.getApellido());
			cboEstado.setSelectedItem(x.getEstado());
			txtTelefono.setText("" + x.getTelefono());
			txtDni.setText(x.getDni());
		}
	}

	void limpieza() {
		txtCodigo.setText("" + ac.codigoCorrelativo());
		txtNombre.setText("");
		txtApellido.setText("");
		cboEstado.setSelectedIndex(0);
		txtTelefono.setText("");
		txtDni.setText("");
	}

	// Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}

	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}

	void habilitarEntradas(boolean sino) {
		btnOK.setEnabled(sino);
		btnCancelar.setEnabled(sino);
		txtNombre.setEditable(sino);
		txtApellido.setEditable(sino);
		txtTelefono.setEditable(sino);
		txtDni.setEditable(sino);
		cboEstado.setEditable(sino);
	}

	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}

	// Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}

	String leerNombre() {
		return txtNombre.getText().trim();
	}

	String leerApellido() {
		return txtApellido.getText().trim();
	}
	
	String leerTelefono() {
		return txtTelefono.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();
	}

	String leerEstado() {
		return cboEstado.getSelectedItem().toString().trim();
	}

	// Métodos que retornan valor (con parámetros)
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}


	double ajustar(double numero) {
		return (int) (numero * 10) / 10.0;
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}