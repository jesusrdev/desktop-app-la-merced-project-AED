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

import arreglos.ArregloClientes;
import clases.Cliente;

public class FrmClientes extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblRazonSocial;
	private JLabel lblRubro;
	private JLabel lblLugarProcedencia;
	private JLabel lblPersonaContacto;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtRazonSocial;
	private JTextField txtPersonaContacto;
	private JTextField txtLugarProcedencia;
	private JComboBox<String> cboRubro;
	private JScrollPane scrollPane;
	private JButton btnOK;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable tblClientes;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes frame = new FrmClientes();
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
	public FrmClientes() {
		setResizable(false);
		setTitle("Mantenimiento | Cliente");
		setBounds(100, 100, 810, 610);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 10, 111, 23);
		getContentPane().add(lblCodigo);

		lblNombre = new JLabel("Nombre Comercial:");
		lblNombre.setBounds(10, 35, 110, 23);
		getContentPane().add(lblNombre);

		lblRazonSocial = new JLabel("Razon Social:");
		lblRazonSocial.setBounds(10, 60, 111, 23);
		getContentPane().add(lblRazonSocial);

		lblRubro = new JLabel("Rubro:");
		lblRubro.setBounds(10, 85, 111, 23);
		getContentPane().add(lblRubro);

		lblLugarProcedencia = new JLabel("Lugar de Procedencia:");
		lblLugarProcedencia.setBounds(10, 110, 110, 23);
		getContentPane().add(lblLugarProcedencia);

		lblPersonaContacto = new JLabel("Persona de Contacto:");
		lblPersonaContacto.setBounds(10, 135, 110, 23);
		getContentPane().add(lblPersonaContacto);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(131, 10, 121, 23);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(131, 35, 251, 23);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtRazonSocial = new JTextField();
		txtRazonSocial.setBounds(131, 60, 251, 23);
		getContentPane().add(txtRazonSocial);
		txtRazonSocial.setColumns(10);

		txtPersonaContacto = new JTextField();
		txtPersonaContacto.setBounds(131, 135, 121, 23);
		getContentPane().add(txtPersonaContacto);
		txtPersonaContacto.setColumns(10);

		txtLugarProcedencia = new JTextField();
		txtLugarProcedencia.setBounds(131, 110, 121, 23);
		getContentPane().add(txtLugarProcedencia);
		txtLugarProcedencia.setColumns(10);

		cboRubro = new JComboBox<String>();
		cboRubro.setModel(
				new DefaultComboBoxModel(new String[] { "Avicultor", "Ganadero", "Comercializador", "Molino" }));
		cboRubro.setBounds(131, 85, 121, 23);
		getContentPane().add(cboRubro);

		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		btnOK.setBounds(282, 135, 100, 23);
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

		tblClientes = new JTable(){
            // Para que no se puedan editar los elementos desde la tabla
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
		tblClientes.addKeyListener(this);
		tblClientes.addMouseListener(this);
		tblClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblClientes);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("RUC");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("RAZON SOCIAL");
		modelo.addColumn("RUBRO");
		modelo.addColumn("LUGAR DE PROCEDENCIA");
		modelo.addColumn("PERSONA CONTACTO");
		modelo.addColumn("TELEFONO");
		tblClientes.setModel(modelo);

		txtCodigo.setEditable(false);

		JLabel lblTelefonoContacto = new JLabel("Telefono de Contacto:");
		lblTelefonoContacto.setBounds(10, 160, 110, 23);
		getContentPane().add(lblTelefonoContacto);

		txtTelefonoContacto = new JTextField();
		txtTelefonoContacto.setEditable(false);
		txtTelefonoContacto.setColumns(10);
		txtTelefonoContacto.setBounds(131, 160, 121, 23);
		getContentPane().add(txtTelefonoContacto);
		
		JButton btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String textoABuscar = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar:", "Buscar", 3);
				
				ArrayList<Cliente> s = ac.buscarClientes(textoABuscar);
				
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
		
		lblRuc = new JLabel("RUC :");
		lblRuc.setBounds(422, 10, 46, 14);
		getContentPane().add(lblRuc);
		
		txtRuc = new JTextField();
		txtRuc.setEditable(false);
		txtRuc.setBounds(459, 7, 86, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpieza();
				habilitarEntradas(false);
				btnCancelar.setEnabled(false);
				habilitarBotones(true);
				btnAdicionar.setEnabled(true);
				
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(282, 160, 100, 23);
		getContentPane().add(btnCancelar);

		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar(0);
		editarFila();

		

		
	}

//  Declaración global
	ArregloClientes ac = new ArregloClientes();
	
	private JTextField txtTelefonoContacto;
	private JButton btnCancelarBusqueda;
	private JTextField txtRuc;
	private JLabel lblRuc;
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
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(true);
		habilitarEntradas(true);
		limpieza();
		txtNombre.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(true);
		if (ac.tamanio() == 0) {
			btnOK.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen Clientes");
		} else {
			btnOK.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			txtRuc.setEditable(false);
//			ac.grabarClientes(); // Modificar archivo
			
			txtNombre.requestFocus();
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOK.setEnabled(false);
		if (ac.tamanio() == 0) {
			btnEliminar.setEnabled(false);
			mensaje("No existen clientes");
		} else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿ Desea eliminar el registro ?");
			if (ok == 0) {
				Cliente x = ac.buscar(leerCodigo());
				int posFila = tblClientes.getSelectedRow();
				if (posFila == ac.tamanio() - 1)
					posFila--;
				ac.eliminar(x);
				
				ac.grabarClientes(); // Modificar el archivo
				
				listar(posFila);
				editarFila();
			}
		}
	}

	protected void actionPerformedBtnOK(ActionEvent arg0) {
		int codigo = leerCodigo();
		String ruc = leerRuc();
		if(ruc != leerRuc()){
			String nombre = leerNombre();
			if (nombre.length() > 0) {
				String razonSocial = leerRazonSocial();
				if (razonSocial.length() > 0) {
					String rubro = leerRubro();
					String lugarProcedencia = leerLugarProcedencia();
					if (lugarProcedencia.length() > 0) {
						String personaContacto = leerPersonaContacto();
						if (personaContacto.length() > 0) {
							String telefono = leerTelefono();
							if (telefono.length() > 0) {
//								try {
									if (btnAdicionar.isEnabled() == false) {
										if (ac.buscar(codigo) == null) {
											Cliente nueva = new Cliente(codigo, ruc, nombre, razonSocial, rubro, lugarProcedencia, personaContacto, telefono);
											ac.adicionar(nueva);
											
											ac.grabarClientes(); // Modificar archivos
											
											btnAdicionar.setEnabled(true);
											listar(tblClientes.getRowCount());
											habilitarEntradas(false);
											
										}
//										} else
//											error("El DNI " + dni + " ya existe", txtDni);
									}
									if (btnModificar.isEnabled() == false) {
										Cliente x = ac.buscar(codigo);
										x.setNombre(nombre);
										x.setRazonSocial(razonSocial);;
										x.setRubro(rubro);
										x.setLugarProcedencia(lugarProcedencia);
										x.setPersonaContacto(personaContacto);
										x.setTelefono(telefono);
										
										ac.grabarClientes(); // Modificar archivos
										
										btnModificar.setEnabled(true);
										listar(tblClientes.getSelectedRow());
										habilitarEntradas(false);
									}
//								} catch (Exception x) {
//									error("Ingrese ESTATURA correcta", txtEstatura);
//								}
							} else {
								error("Ingrese TELEFONO correcto", txtTelefonoContacto);
							}
						} else {
							error("Ingrese PERSONA DE CONTACTO correcta", txtPersonaContacto);
						}
					} else {
						error("Ingrese LUGAR DE PROCEDENCIA correcto", txtLugarProcedencia);
					}
				} else
					error("ingrese RAZON SOCIAL correcta", txtRazonSocial);
			} else
				error("ingrese NOMBRE correcto", txtNombre);
		}else{
			error("Ruc Existente", txtRuc);
		}
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
		if (arg0.getSource() == tblClientes) {
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
		TableColumnModel tcm = tblClientes.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(13)); // ruc
		tcm.getColumn(2).setPreferredWidth(anchoColumna(18)); // nombre
		tcm.getColumn(3).setPreferredWidth(anchoColumna(25)); // razon social
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); // rubro
		tcm.getColumn(5).setPreferredWidth(anchoColumna(13)); // lugar de procedencia
		tcm.getColumn(6).setPreferredWidth(anchoColumna(13)); // Persona de contacto
		tcm.getColumn(7).setPreferredWidth(anchoColumna(10)); // telefono
	}

	void listar(int posFila) {
		modelo.setRowCount(0);
		Cliente x;
		for (int i = 0; i < ac.tamanio(); i++) {
			x = ac.obtener(i);
			Object[] fila = { x.getCodigo(), x.getRuc(), x.getNombre(), x.getRazonSocial(), x.getRubro(),
					x.getLugarProcedencia(), x.getPersonaContacto(), x.getTelefono() };
			modelo.addRow(fila);
		}
		tblClientes.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void listar(int posFila, ArrayList<Cliente> s) {
		modelo.setRowCount(0);
		Cliente x;
		for (int i = 0; i < s.size(); i++) {
			x = s.get(i);
			Object[] fila = { x.getCodigo(), x.getRuc(), x.getNombre(), x.getRazonSocial(), x.getRubro(),
					x.getLugarProcedencia(), x.getPersonaContacto(), x.getTelefono() };
			modelo.addRow(fila);
		}
		tblClientes.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void editarFila() {
		if (ac.tamanio() == 0)
			limpieza();
		else {
			Cliente x = ac.buscar(Integer.parseInt(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString()));
			txtCodigo.setText("" + x.getCodigo());
			txtRuc.setText(x.getRuc());
			txtNombre.setText(x.getNombre());
			txtRazonSocial.setText(x.getRazonSocial());
			cboRubro.setSelectedItem(x.getRubro());
			txtLugarProcedencia.setText("" + x.getLugarProcedencia());
			txtPersonaContacto.setText(x.getPersonaContacto());
			txtTelefonoContacto.setText("" + x.getTelefono());
		}
	}

	void limpieza() {
		txtCodigo.setText("" + ac.codigoCorrelativo());
		txtRuc.setText("");
		txtNombre.setText("");
		txtRazonSocial.setText("");
		cboRubro.setSelectedIndex(0);
		txtLugarProcedencia.setText("");
		txtPersonaContacto.setText("");
		txtTelefonoContacto.setText("");
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
		
		txtRuc.setEditable(sino);
		txtNombre.setEditable(sino);
		txtRazonSocial.setEditable(sino);
		txtPersonaContacto.setEditable(sino);
		txtLugarProcedencia.setEditable(sino);
		txtTelefonoContacto.setEditable(sino);
		cboRubro.setEditable(sino);
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

	String leerRazonSocial() {
		return txtRazonSocial.getText().trim();
	}

	String leerPersonaContacto() {
		return txtPersonaContacto.getText().trim();
	}

	String leerLugarProcedencia() {
		return txtLugarProcedencia.getText().trim();
	}

	String leerRubro() {
		return cboRubro.getSelectedItem().toString().trim();
	}

	String leerTelefono() {
		return txtTelefonoContacto.getText().trim();
	}
	
	String leerRuc() {
		return txtRuc.getText().trim();
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
