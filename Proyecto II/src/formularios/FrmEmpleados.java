package formularios;

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
		setTitle("Registro Empleados");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 10, 111, 23);
		getContentPane().add(lblCodigo);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 35, 110, 23);
		getContentPane().add(lblNombre);

		lblRazonSocial = new JLabel("Apellido:");
		lblRazonSocial.setBounds(10, 60, 111, 23);
		getContentPane().add(lblRazonSocial);

		lblRubro = new JLabel("Estado:");
		lblRubro.setBounds(10, 85, 111, 23);
		getContentPane().add(lblRubro);

		lblLugarProcedencia = new JLabel("Telefono:");
		lblLugarProcedencia.setBounds(10, 110, 110, 23);
		getContentPane().add(lblLugarProcedencia);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(131, 10, 121, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(131, 35, 251, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(131, 60, 251, 23);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(131, 110, 121, 23);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

		cboEstado = new JComboBox<String>();
		cboEstado.setModel(
				new DefaultComboBoxModel(new String[] {"Soltero", "Casado", "Divorciado"}));
		cboEstado.setBounds(131, 85, 121, 23);
		getContentPane().add(cboEstado);

		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		btnOK.setBounds(282, 110, 100, 23);
		getContentPane().add(btnOK);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(635, 10, 150, 23);
		getContentPane().add(btnAdicionar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(635, 35, 150, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(635, 60, 150, 23);
		getContentPane().add(btnEliminar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 209, 775, 351);
		getContentPane().add(scrollPane);

		tblEmpleados = new JTable(){
            // Para que no se puedan editar los elementos desde la tabla
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
		tblEmpleados.addKeyListener(this);
		tblEmpleados.addMouseListener(this);
		tblEmpleados.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblEmpleados);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
		modelo.addColumn("DNI");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("ESTADO");
		tblEmpleados.setModel(modelo);

		txtCodigo.setEditable(false);
		
		JButton btnBuscar = new JButton("Buscar Empleados");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String textoABuscar = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar:", "Buscar", 3);
				
				ArrayList<Empleados> s = ac.buscarEmpleados(textoABuscar);
				
				listar(0, s);
				editarFila();
				
			}
		});
		btnBuscar.setBounds(635, 124, 149, 23);
		getContentPane().add(btnBuscar);
		
		btnCancelarBusqueda = new JButton("Cancelar Busqueda");
		btnCancelarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				listar(0);
				editarFila();
				
			}
		});
		btnCancelarBusqueda.setBounds(635, 158, 149, 23);
		getContentPane().add(btnCancelarBusqueda);
		
		JLabel lblNewLabel = new JLabel("Dni:");
		lblNewLabel.setBounds(10, 144, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(131, 137, 121, 23);
		getContentPane().add(txtDni);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpieza();
				habilitarEntradas(false);
				habilitarBotones(true);
				
			}
		});
		btnCancelar.setBounds(282, 140, 100, 23);
		getContentPane().add(btnCancelar);

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
				String dni = leerDni();
				String telefono = leerTelefono();
				if (telefono.length() > 0) {
					String estado = leerEstado();
					if (estado.length() > 0) {
						
						if (telefono.length() > 0) {
//							try {
								if (btnAdicionar.isEnabled() == false) {
									if (ac.buscar(codigo) == null) {
										Empleados nueva = new Empleados(codigo, nombre, apellido, dni, telefono, estado);
										ac.adicionar(nueva);
										
										ac.grabarEmpleados(); // Modificar archivos
										
										btnAdicionar.setEnabled(true);
										listar(tblEmpleados.getRowCount());
										habilitarEntradas(false);
									}
//									} else
//										error("El DNI " + dni + " ya existe", txtDni);
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
							error("Ingrese TELEFONO correcto", txtTelefono);
						}
					} 
				} 
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