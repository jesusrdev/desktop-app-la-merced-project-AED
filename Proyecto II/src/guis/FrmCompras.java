package guis;

import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

import arreglos.ArregloCompras;
import arreglos.ArregloProductos;
import clases.Compra;
import clases.Factura;

import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;



public class FrmCompras extends JInternalFrame implements ActionListener, KeyListener, MouseListener {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtFactura;
	private JTextField txtProveedor;
	private JTextField txtRuc;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JButton btnOk;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox cboProducto;
	private JButton btnCancelar;
	private JDateChooser dateChooser;
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;
	private JTable tblCompras;
	
	ArregloCompras ac = new ArregloCompras();
	ArregloProductos ap = new ArregloProductos();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private JLabel lblNewLabel;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCompras frame = new FrmCompras();
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
	
	
	
	public FrmCompras() {
		setTitle("REGISTRO | COMPRAS");
		setBounds(100, 100, 1000, 611);
		getContentPane().setLayout(null);
		
		JLabel lblNDeCompra = new JLabel("N° de Factura :");
		lblNDeCompra.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblNDeCompra.setBounds(133, 36, 112, 14);
		getContentPane().add(lblNDeCompra);
		
		JLabel lblProveedor = new JLabel("Proveedor       :");
		lblProveedor.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblProveedor.setBounds(133, 67, 112, 14);
		getContentPane().add(lblProveedor);
		
		JLabel lblRuc = new JLabel("RUC                    : ");
		lblRuc.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblRuc.setBounds(133, 98, 112, 14);
		getContentPane().add(lblRuc);
		
		JLabel lblFecha = new JLabel("Fecha  (dd/mm/aa)");
		lblFecha.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblFecha.setBounds(133, 129, 112, 14);
		getContentPane().add(lblFecha);
		
		txtFactura = new JTextField();
		txtFactura.setForeground(new Color(0, 0, 255));
		txtFactura.setEditable(false);
		txtFactura.setBounds(255, 36, 140, 20);
		getContentPane().add(txtFactura);
		txtFactura.setColumns(10);
		
		txtProveedor = new JTextField();
		txtProveedor.setForeground(new Color(0, 0, 255));
		txtProveedor.setEditable(false);
		txtProveedor.setBounds(255, 67, 140, 20);
		getContentPane().add(txtProveedor);
		txtProveedor.setColumns(10);
		
		txtRuc = new JTextField();
		txtRuc.setForeground(new Color(0, 0, 255));
		txtRuc.setEditable(false);
		txtRuc.setBounds(255, 98, 140, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto   :");
		lblProducto.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblProducto.setBounds(428, 36, 89, 14);
		getContentPane().add(lblProducto);
		
		txtPrecio = new JTextField();
		txtPrecio.setForeground(new Color(0, 0, 255));
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(509, 65, 140, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setForeground(new Color(0, 0, 255));
		txtCantidad.setEditable(false);
		txtCantidad.setBounds(509, 99, 140, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio        :");
		lblPrecio.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblPrecio.setBounds(428, 67, 89, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad    :");
		lblCantidad.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblCantidad.setBounds(428, 98, 89, 14);
		getContentPane().add(lblCantidad);
		
		btnOk = new JButton("OK");
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Roboto Black", Font.BOLD, 15));
		btnOk.setBackground(new Color(255, 60, 65));
		btnOk.setIcon(new ImageIcon(FrmCompras.class.getResource("/iconos/aceptar.png")));
		btnOk.setEnabled(false);
		btnOk.addActionListener(this);
		btnOk.setBounds(560, 129, 89, 32);
		getContentPane().add(btnOk);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnAdicionar.setBackground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(FrmCompras.class.getResource("/iconos/anadir.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(713, 36, 121, 32);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnModificar.setBackground(new Color(255, 255, 255));
		btnModificar.setIcon(new ImageIcon(FrmCompras.class.getResource("/iconos/boligrafo.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(714, 91, 121, 32);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(FrmCompras.class.getResource("/iconos/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(713, 144, 122, 32);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 220, 949, 349);
		getContentPane().add(scrollPane);
		
		tblCompras = new JTable() {
			// Para que no se puedan editar los elementos desde la tabla
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
		};
		tblCompras.setForeground(new Color(45, 45, 255));
		tblCompras.setGridColor(new Color(255, 255, 255));
		tblCompras.setIgnoreRepaint(true);
		
		tblCompras.addKeyListener(this);
		tblCompras.addMouseListener(this);
		tblCompras.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCompras);
		
		modelo.addColumn("FACTURA");
		modelo.addColumn("PROVEEDOR");
		modelo.addColumn("RUC");
		modelo.addColumn("FECHA");
		modelo.addColumn("PRODUCTO");
		modelo.addColumn("PRECIO");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("IMPORTE TOTAL");
		
		tblCompras.setModel(modelo);
		
		cboProducto = new JComboBox();
		cboProducto.setForeground(new Color(0, 0, 255));
		cboProducto.setBounds(509, 31, 140, 23);
		getContentPane().add(cboProducto);
		cboProducto.setModel(new DefaultComboBoxModel(ap.productosComboBox()));
		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(0, 0, 255));
		dateChooser.setEnabled(false);
		dateChooser.setDateFormatString("d/MM/y");
		dateChooser.setBounds(255, 129, 140, 20);
		getContentPane().add(dateChooser);
		
		monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setForeground(new Color(0, 0, 255));
		monthChooser.setMonth(7);
		monthChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				int mes = monthChooser.getMonth();
				int anio = yearChooser.getYear();
				
				ArrayList<Compra> arreglo = ac.filtrarComprasPorFecha(mes, anio);
				
				listar(0, arreglo);
				editarFila();
				
			}
		});
		monthChooser.setBounds(283, 172, 112, 20);
		getContentPane().add(monthChooser);
		
		yearChooser = new JYearChooser();
		yearChooser.getSpinner().setForeground(new Color(0, 0, 255));
		yearChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				int mes = monthChooser.getMonth();
				int anio = yearChooser.getYear();
				
				listar(0, ac.filtrarComprasPorFecha(mes, anio));
				editarFila();
				
			}
		});
		yearChooser.setBounds(411, 172, 100, 20);
		getContentPane().add(yearChooser);
		
		JLabel lblBuscarPorMes = new JLabel("Buscar por mes y año :");
		lblBuscarPorMes.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblBuscarPorMes.setBounds(133, 173, 140, 14);
		getContentPane().add(lblBuscarPorMes);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(255, 60, 65));
		btnCancelar.setIcon(new ImageIcon(FrmCompras.class.getResource("/iconos/error.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnCancelar.setEnabled(false);
				habilitarBotones(true);
				habilitarEntradas(false);
				btnCancelar.setEnabled(false);
				
			}
		});
		btnCancelar.setBounds(560, 172, 89, 32);
		getContentPane().add(btnCancelar);
		
		
		
		habilitarEntradas(false);
//		ajustarAnchoColumnas();
//		listar(0);
//		editarFila();
		btnCancelar.setEnabled(false);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmCompras.class.getResource("/imagenes/FONDO COMPRAS.png")));
		lblNewLabel.setBounds(-16, -6, 1000, 620);
		getContentPane().add(lblNewLabel);
		
	}
	
	
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOk) {
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
			btnOk.setEnabled(true);
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnCancelar.setEnabled(true);
		habilitarEntradas(true);
		limpieza();
		txtFactura.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(true);
		btnCancelar.setEnabled(true);
		if (ac.tamanio() == 0) {
			btnOk.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen Clientes");
		} else {
			btnOk.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			
//			ac.grabarCompras(); // Modificar archivo
			
			txtFactura.requestFocus();
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnOk.setEnabled(false);
		btnCancelar.setEnabled(false);
		if (ac.tamanio() == 0) {
			btnEliminar.setEnabled(false);
			mensaje("No existen clientes");
		} else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿ Desea eliminar el registro ?");
			if (ok == 0) {
				Compra x = ac.buscar(leerFactura(), leerFecha(), leerProducto(), leerPrecio(), leerCantidad());
				int posFila = tblCompras.getSelectedRow();
				if (posFila == ac.tamanio() - 1)
					posFila--;
				ac.eliminar(x);
				
				ac.grabarCompras(); // Modificar el archivo
				
				int mes = monthChooser.getMonth();
				int anio = yearChooser.getYear();
				listar(posFila, ac.filtrarComprasPorFecha(mes, anio));
				editarFila();
			}
		}
	}
	
	protected void actionPerformedBtnOK(ActionEvent arg0) {
		String factura = leerFactura();
		if (factura.length() > 0){
			String nombreProveedor = leerNombreProveedor();
			if (nombreProveedor.length() > 0) {
				String ruc = leerRuc();
				if (ruc.length() > 0) {
				
					String fecha = leerFecha();
//					if (fecha.length() > 0) {
					String producto = leerProducto();
					
					double precio;
					try {
						precio = leerPrecio();
						double cantidad;
						try {
							cantidad = leerCantidad();
							double importeTotal;
								importeTotal = precio * cantidad;

									if (btnAdicionar.isEnabled() == false) {
										if (ac.buscar(factura, fecha, producto, precio, cantidad) == null) {
											Compra nueva = new Compra(factura, nombreProveedor, ruc, fecha, producto, precio, cantidad, (Math.round(importeTotal * 100.0) /100.0) );
											ac.adicionar(nueva);
											
											ac.grabarCompras(); // Modificar archivos
											
											btnAdicionar.setEnabled(true);

											int mes = monthChooser.getMonth();
											int anio = yearChooser.getYear();
											listar(0, ac.filtrarComprasPorFecha(mes, anio));
											
											habilitarEntradas(false);
										}
										
									}
									if (btnModificar.isEnabled() == false) {
										String nCompra = tblCompras.getValueAt(tblCompras.getSelectedRow(), 0).toString();
										String fec = tblCompras.getValueAt(tblCompras.getSelectedRow(), 3).toString();
										String prod = tblCompras.getValueAt(tblCompras.getSelectedRow(), 4).toString();
										double prec = Double.parseDouble(tblCompras.getValueAt(tblCompras.getSelectedRow(), 5).toString());
										double cant = Double.parseDouble(tblCompras.getValueAt(tblCompras.getSelectedRow(), 6).toString());
										
										Compra x = ac.buscar(nCompra, fec, prod, prec, cant);
										
										x.setNombreProveedor(nombreProveedor);
										x.setRuc(ruc);
										x.setFecha(fecha);
										x.setProducto(producto);
										x.setPrecio(precio);
										x.setCantidad(cantidad);
										x.setImporteTotal((Math.round(importeTotal * 100.0) /100.0) );
										
										ac.grabarCompras();
										
										btnModificar.setEnabled(true);
										
										int mes = monthChooser.getMonth();
										int anio = yearChooser.getYear();
										listar(tblCompras.getSelectedRow(), ac.filtrarComprasPorFecha(mes, anio));
										
										habilitarEntradas(false);
										
									}

								

						} catch (Exception e) {
							error("Ingresar un valor entero positivo en CANTIDAD", txtCantidad);
						}

					} catch (Exception e) {
						error("Ingresar un valor positivo en PRECIO", txtPrecio);
					}
						
					
//					}else
//						error("ingrese FECHA correcta", txtFecha);
				
				} else
					error("ingrese RUC correcto", txtRuc);
			} else
				error("ingrese NOMBRE DE PROVEEDOR correcto", txtProveedor);
		} else
			error("ingrese FACTURA correcto", txtFactura);
		
//		btnCancelar.setEnabled(false);
		
	}
	
	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
		arg0.consume();
		editarFila();
	}

	public void keyTyped(KeyEvent arg0) {
	}
	
	protected void mouseClickedTblCompras(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCompras) {
			mouseClickedTblCompras(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
	
		
	void listar(int posFila) {
		modelo.setRowCount(0);
		Compra x;
		for (int i = 0; i < ac.tamanio(); i++) {
			x = ac.obtener(i);
			Object[] fila = { x.getFactura(), x.getNombreProveedor(), x.getRuc(), x.getFecha(), 
					x.getProducto(), x.getPrecio(), x.getCantidad(), x.getImporteTotal()};
			modelo.addRow(fila);
		}
	}
		
	void listar(int posFila, ArrayList<Compra> s) {
		modelo.setRowCount(0);
		Compra x;
		for (int i = 0; i < s.size(); i++) {
			x = s.get(i);
			Object[] fila = { x.getFactura(), x.getNombreProveedor(), x.getRuc(), x.getFecha(), 
					x.getProducto(), x.getPrecio(), x.getCantidad(), x.getImporteTotal()};
			modelo.addRow(fila);
		}
		tblCompras.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void editarFila() {
		if (tblCompras.getRowCount() <= 0)
			limpieza();
		else {
			String nCompra = tblCompras.getValueAt(tblCompras.getSelectedRow(), 0).toString();
			String fec = tblCompras.getValueAt(tblCompras.getSelectedRow(), 3).toString();
			String prod = tblCompras.getValueAt(tblCompras.getSelectedRow(), 4).toString();
			double prec = Double.parseDouble(tblCompras.getValueAt(tblCompras.getSelectedRow(), 5).toString());
			double cant = Double.parseDouble(tblCompras.getValueAt(tblCompras.getSelectedRow(), 6).toString());
			
			Compra x = ac.buscar(nCompra, fec, prod, prec, cant);
			
			
			txtFactura.setText("" + x.getFactura());
			txtProveedor.setText(x.getNombreProveedor());
			txtRuc.setText("" + x.getRuc());
			
			Calendar calendario = new GregorianCalendar();
			String[] a = x.getFecha().split("/");
			calendario.set(Integer.parseInt(a[2]), (Integer.parseInt(a[1])) -1, Integer.parseInt(a[0]));
			dateChooser.setCalendar(calendario);
			
			cboProducto.setSelectedItem(x.getProducto());
			txtPrecio.setText("" + x.getPrecio());
			txtCantidad.setText("" + x.getCantidad());
			
		}
	}

	void limpieza() {
		txtFactura.setText("");
		txtProveedor.setText("");
		txtRuc.setText("");
		dateChooser.setCalendar(new GregorianCalendar());
		cboProducto.setSelectedIndex(0);
		txtPrecio.setText("");
		txtCantidad.setText("");
		
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
		btnCancelar.setEnabled(sino);
		
		txtFactura.setEditable(sino);
		txtProveedor.setEditable(sino);
		txtRuc.setEditable(sino);
		cboProducto.setEnabled(sino);
		txtPrecio.setEditable(sino);
		txtCantidad.setEditable(sino);
		dateChooser.setEnabled(sino);
	}

	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}

	// Métodos que retornan valor (sin parámetros)
	String leerFactura() {
		return txtFactura.getText().trim();
	}

	String leerNombreProveedor() {
		return txtProveedor.getText().trim();
	}
		
	String leerRuc() {
		return txtRuc.getText().trim();
	}

	String leerFecha() {
		return sdf.format(dateChooser.getCalendar().getTime());
	}

	String leerProducto() {
		return cboProducto.getSelectedItem().toString().trim();
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	double leerCantidad() {
		return Double.parseDouble(txtCantidad.getText().trim());}
	


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
