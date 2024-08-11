package guis;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloClientes;
import arreglos.ArregloProductos;
import clases.Cliente;
import clases.Producto;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class FrmProducto extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTable tblProducto;
	private DefaultTableModel tModel  = new DefaultTableModel();
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblTipo;
	private JLabel lblClasificacin;
	private JButton btnOk;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnEliminar;
	ArregloProductos ap = new ArregloProductos();
	private JScrollPane scrollPane;
	private JComboBox cboTipo;
	private JComboBox cboClasificacion;
	private JButton btnCancelarRegistro;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
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
	public FrmProducto() {
		setTitle("REGISTRO | PRODUCTOS");
		setBounds(100, 100, 1000, 611);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Codigo       :");
		lblCodigo.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblCodigo.setBounds(238, 31, 76, 14);
		getContentPane().add(lblCodigo);
		
		lblNombre = new JLabel("Nombre     :");
		lblNombre.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblNombre.setBounds(238, 60, 76, 14);
		getContentPane().add(lblNombre);
		
		lblPrecio = new JLabel("Precio       :");
		lblPrecio.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblPrecio.setBounds(238, 85, 76, 14);
		getContentPane().add(lblPrecio);
		
		lblTipo = new JLabel("Tipo           :");
		lblTipo.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblTipo.setBounds(238, 110, 90, 14);
		getContentPane().add(lblTipo);
		
		lblClasificacin = new JLabel("Clasificaci\u00F3n :");
		lblClasificacin.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblClasificacin.setBounds(238, 141, 100, 14);
		getContentPane().add(lblClasificacin);
		
		txtCodigo = new JTextField();
		txtCodigo.setForeground(new Color(0, 0, 255));
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(338, 28, 149, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 0, 255));
		txtNombre.setEditable(false);
		txtNombre.setBounds(338, 57, 149, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setForeground(new Color(0, 0, 255));
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(338, 82, 149, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		cboTipo = new JComboBox();
		cboTipo.setForeground(new Color(0, 0, 255));
		cboTipo.setEnabled(false);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Aves", "Porcinos", "Bobinos"}));
		cboTipo.setBounds(338, 107, 149, 20);
		getContentPane().add(cboTipo);
		
		cboClasificacion = new JComboBox();
		cboClasificacion.setForeground(new Color(0, 0, 255));
		cboClasificacion.setEnabled(false);
		cboClasificacion.setModel(new DefaultComboBoxModel(new String[] {"Pienso", "Suplemento", "Mezcla"}));
		cboClasificacion.setBounds(338, 138, 149, 20);
		getContentPane().add(cboClasificacion);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setIcon(new ImageIcon(FrmProducto.class.getResource("/iconos/anadir.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
				
			}
		});
		btnRegistrar.setBounds(577, 19, 121, 32);
		getContentPane().add(btnRegistrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnModificar.setBackground(new Color(255, 255, 255));
		btnModificar.setIcon(new ImageIcon(FrmProducto.class.getResource("/iconos/boligrafo.png")));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();

				}
		});
		btnModificar.setBounds(577, 62, 121, 32);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(FrmProducto.class.getResource("/iconos/eliminar.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnEliminar.setBounds(577, 105, 121, 33);
		getContentPane().add(btnEliminar);
		
		btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Roboto Black", Font.BOLD, 15));
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setBackground(new Color(255, 60, 65));
		btnOk.setIcon(new ImageIcon(FrmProducto.class.getResource("/iconos/aceptar.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
	
			}
		});
		btnOk.setEnabled(false);
		btnOk.setBounds(302, 176, 89, 32);
		getContentPane().add(btnOk);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 220, 949, 349);
		getContentPane().add(scrollPane);
		
		tblProducto = new JTable();
		
		tblProducto = new JTable(){
            // Para que no se puedan editar los elementos desde la tabla
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
		tblProducto.setForeground(new Color(45, 45, 255));
		tblProducto.setGridColor(new Color(255, 255, 255));
		tblProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getSource() == tblProducto) {
					mouseClickedTblProducto(arg0);
				}
			}
		});
        scrollPane.setViewportView(tblProducto);
        
		tModel.addColumn("CODIGO");
		tModel.addColumn("NOMBRE");
		tModel.addColumn("PRECIO");
		tModel.addColumn("TIPO");
		tModel.addColumn("CLASIFICACION");
		tblProducto.setModel(tModel);
		
		JButton btnBuscar = new JButton("Buscar Producto");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBackground(new Color(255, 255, 255));
		btnBuscar.setIcon(new ImageIcon(FrmProducto.class.getResource("/iconos/buscar.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String textoABuscar = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar:", "Buscar", 3);
					
					ArrayList<Producto> s = ap.buscarProducto(textoABuscar);
					
					listar(0, s);
					editarFila();
				} catch (Exception e) {
				
				}

			}
		});
		btnBuscar.setBounds(556, 149, 170, 26);
		getContentPane().add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar Busqueda");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setIcon(new ImageIcon(FrmProducto.class.getResource("/iconos/portapapeles.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar(0);
				editarFila();
			}
		});
		btnCancelar.setBounds(556, 182, 170, 27);
		getContentPane().add(btnCancelar);
		
		btnCancelarRegistro = new JButton("Cancelar");
		btnCancelarRegistro.setForeground(new Color(255, 255, 255));
		btnCancelarRegistro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCancelarRegistro.setBackground(new Color(255, 60, 65));
		btnCancelarRegistro.setIcon(new ImageIcon(FrmProducto.class.getResource("/iconos/error.png")));
		btnCancelarRegistro.setEnabled(false);
		btnCancelarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpieza();
				habilitarEntradas(false);
				btnCancelarRegistro.setEnabled(false);
				habilitarBotones(true);
				btnRegistrar.setEnabled(true);
			}
		});
		btnCancelarRegistro.setBounds(415, 176, 100, 34);
		getContentPane().add(btnCancelarRegistro);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmProducto.class.getResource("/imagenes/fondo 2.png")));
		lblNewLabel.setBounds(-16, 0, 1000, 604);
		getContentPane().add(lblNewLabel);
		
		
		habilitarEntradas(false);
		listar(0);
		editarFila();

	}
	protected void mouseClickedTblProducto(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	void eliminar(){
		btnRegistrar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (ap.tamanio() == 0) {
			btnEliminar.setEnabled(false);
			mensaje("No existen Productos");
		} else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿ Desea eliminar el registro ?");
			if (ok == 0) {
				Producto x = ap.buscar(leerCodigo());
				int posFila = tblProducto.getSelectedRow();
				if (posFila == ap.tamanio() - 1)
					posFila--;
				ap.eliminar(x);
				 
				ap.grabarProductos();
				
				listar(posFila);
				editarFila();
			}
		}
	}


	
	void registrar(){
		if (ap.tamanio() == 0)
			btnOk.setEnabled(true);
		btnRegistrar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnCancelarRegistro.setEnabled(true);
		habilitarEntradas(true);
		limpieza();
		txtNombre.requestFocus();
	}
	
	void modificar(){
		btnRegistrar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(true);
		btnCancelarRegistro.setEnabled(true);
		if (ap.tamanio() == 0) {
			btnOk.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen Clientes");
		} else {
			btnOk.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			
			ap.grabarProductos();
			
			
			txtNombre.requestFocus();
		}
	}

	// Métodos tipo void (sin parámetros)
	void adicionar(){
		habilitarEntradas(true);
		int codigo = leerCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			try {
				double precio = leerPrecio();
					String tipo = leerTipo();
					String clasificacion = leerClasificacion();
					if (btnRegistrar.isEnabled() == false) {
						if (ap.buscar(codigo) == null) {
							Producto nueva = new Producto(codigo, nombre, precio, tipo, clasificacion);
							ap.adicionar(nueva);
							
							ap.grabarProductos();
							btnRegistrar.setEnabled(true);
							listar(tblProducto.getRowCount());
							habilitarEntradas(false);
						}
//						
					}
					if (btnModificar.isEnabled() == false) {
						Producto x = ap.buscar(codigo);
						x.setNombre(nombre);
						x.setPrecio(precio);
						x.setTipo(tipo);
						x.setClasificacion(clasificacion);
						
						
						btnModificar.setEnabled(true);
						listar(tblProducto.getSelectedRow());
						habilitarEntradas(false);
					}
			} catch (Exception e2) {
				error("ingrese PRECIO correcta", txtPrecio);
			}
		} else
			error("ingrese NOMBRE correcto", txtNombre);

	}

	void listar(int posFila) {
		tModel.setRowCount(0);
		Producto x;
		for (int i = 0; i < ap.tamanio(); i++) {
			x = ap.obtener(i);
			Object[] fila = { x.getCodigo(), x.getNombre(), x.getPrecio(),
					x.getTipo(), x.getClasificacion()};
			tModel.addRow(fila);
		}
		tblProducto.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void listar(int posFila, ArrayList<Producto> s) {
		tModel.setRowCount(0);
		Producto x;
		for (int i = 0; i < s.size(); i++) {
			x = s.get(i);
			Object[] fila = {x.getCodigo(), x.getNombre(), x.getPrecio(),
					x.getTipo(), x.getClasificacion()};
			tModel.addRow(fila);
		}
		tblProducto.getSelectionModel().setSelectionInterval(posFila, posFila);
	}


	void editarFila() {
		if (ap.tamanio() == 0)
			limpieza();
		else {
			Producto x = ap.buscar(Integer.parseInt(tblProducto.getValueAt(tblProducto.getSelectedRow(), 0).toString()));
			txtCodigo.setText("" + x.getCodigo());
			txtNombre.setText(x.getNombre());
			txtPrecio.setText("" + x.getPrecio());
			cboTipo.setSelectedItem(x.getTipo());
			cboClasificacion.setSelectedItem(x.getClasificacion());
			
		}
	}

	void limpieza() {
		txtCodigo.setText("" + ap.codigoCorrelativo());
		txtNombre.setText("");
		txtPrecio.setText("");
		cboTipo.setSelectedIndex(0);
		cboClasificacion.setSelectedIndex(0);
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
		btnOk.setEnabled(sino);
		btnCancelarRegistro.setEnabled(sino);
		
		txtNombre.setEditable(sino);
		txtPrecio.setEditable(sino);
		cboTipo.setEnabled(sino);
		cboClasificacion.setEnabled(sino);
	}

	void habilitarBotones(boolean sino) {
		btnModificar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}

	// Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}

	String leerNombre() {
		return txtNombre.getText().trim();
	}

	Double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	String leerTipo() {
		return cboTipo.getSelectedItem().toString().trim();
	}

	String leerClasificacion() {
		return cboClasificacion.getSelectedItem().toString().trim();
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
