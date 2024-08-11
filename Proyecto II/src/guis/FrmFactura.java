package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import arreglos.ArregloFacturas;
import arreglos.ArregloProductos;
import clases.Factura;
import clases.Producto;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class FrmFactura extends JInternalFrame {
	private JTextField txtPrecio;
	private JTextField txtCliente;
	private JTextField txtRuc;
	private JTextField txtCantidad;
	private JTextField txtFactura;
	private JTable tblFactura;
	private JScrollPane scrollPane;
	private JButton btnOk;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnAdicionar;
	private JComboBox cboProducto;
	private JDateChooser dateChooser;
	private DefaultTableModel model = new DefaultTableModel() ;
	ArregloFacturas af = new ArregloFacturas();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	ArregloProductos ap = new ArregloProductos();
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;
	private JButton btnCancelar;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFactura frame = new FrmFactura();
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
	public FrmFactura() {
		setTitle("REGISTRO | VENTAS");
		setBounds(100, 100, 1000, 611);
		getContentPane().setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto    :");
		lblProducto.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblProducto.setBounds(228, 65, 86, 14);
		getContentPane().add(lblProducto);
		
		cboProducto = new JComboBox();
		cboProducto.setForeground(new Color(0, 0, 255));
		cboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String producto  = leerProducto();
					txtPrecio.setText(Double.toString(ap.buscarPrecio(producto)));
				
			}
		});
		cboProducto.setModel(new DefaultComboBoxModel(ap.productosComboBox()));
		cboProducto.setEnabled(false);
		cboProducto.setBounds(306, 62, 127, 20);
		getContentPane().add(cboProducto);
		
		JLabel lblPrecio = new JLabel("Precio         :");
		lblPrecio.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblPrecio.setBounds(228, 91, 87, 14);
		getContentPane().add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setForeground(new Color(0, 0, 255));
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(306, 88, 127, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fecha          :");
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblNewLabel.setBounds(228, 120, 89, 14);
		getContentPane().add(lblNewLabel);
		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(0, 0, 255));
		dateChooser.setEnabled(false);
		dateChooser.setDateFormatString("d/MM/y");
		dateChooser.setBounds(306, 114, 127, 20);
		getContentPane().add(dateChooser);
		
		JLabel lblCliente = new JLabel("Cliente        :");
		lblCliente.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblCliente.setBounds(228, 143, 89, 14);
		getContentPane().add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setForeground(new Color(0, 0, 255));
		txtCliente.setEditable(false);
		txtCliente.setBounds(306, 140, 127, 20);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblRuc = new JLabel("RUC             :");
		lblRuc.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblRuc.setBounds(228, 173, 85, 14);
		getContentPane().add(lblRuc);
		
		txtRuc = new JTextField();
		txtRuc.setForeground(new Color(0, 0, 255));
		txtRuc.setEditable(false);
		txtRuc.setBounds(306, 167, 127, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblCantidad.setBounds(457, 40, 74, 14);
		getContentPane().add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setForeground(new Color(0, 0, 255));
		txtCantidad.setEditable(false);
		txtCantidad.setBounds(519, 37, 86, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnAdicionar.setBackground(new Color(255, 255, 255));
		btnAdicionar.setIcon(new ImageIcon(FrmFactura.class.getResource("/iconos/anadir.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
				
			}
		});
		btnAdicionar.setBounds(637, 31, 121, 32);
		getContentPane().add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnModificar.setBackground(new Color(255, 255, 255));
		btnModificar.setIcon(new ImageIcon(FrmFactura.class.getResource("/iconos/boligrafo.png")));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		btnModificar.setBounds(637, 73, 121, 32);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnEliminar.setBackground(new Color(255, 255, 255));
		btnEliminar.setIcon(new ImageIcon(FrmFactura.class.getResource("/iconos/eliminar.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		btnEliminar.setBounds(637, 112, 121, 32);
		getContentPane().add(btnEliminar);
		
		btnOk = new JButton("Ok");
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Roboto Black", Font.BOLD, 15));
		btnOk.setBackground(new Color(255, 60, 65));
		btnOk.setIcon(new ImageIcon(FrmFactura.class.getResource("/iconos/aceptar.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnOk.setEnabled(false);
		btnOk.setBounds(485, 95, 99, 34);
		getContentPane().add(btnOk);
		
		JLabel lblNFactura = new JLabel("N° Factura  :");
		lblNFactura.setFont(new Font("Roboto Black", Font.BOLD, 12));
		lblNFactura.setBounds(228, 41, 87, 14);
		getContentPane().add(lblNFactura);
		
		txtFactura = new JTextField();
		txtFactura.setForeground(new Color(0, 0, 255));
		txtFactura.setEditable(false);
		txtFactura.setBounds(306, 38, 127, 20);
		getContentPane().add(txtFactura);
		txtFactura.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		scrollPane.setBounds(18, 220, 949, 349);
		getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(tblFactura);
		
		tblFactura = new JTable(){
            // Para que no se puedan editar los elementos desde la tabla
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
		tblFactura.setForeground(new Color(45, 45, 255));
		tblFactura.setGridColor(new Color(255, 255, 255));
		tblFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getSource() == tblFactura) {
					mouseClickedTblFactura(arg0);
				}
			}
		});
        scrollPane.setViewportView(tblFactura);
        
		model.addColumn("N* FACTURA");
		model.addColumn("FECHA");
		model.addColumn("RUC");
		model.addColumn("CLIENTE");
		model.addColumn("PRODUCTO");
		model.addColumn("PRECIO");
		model.addColumn("CANTIDAD");
		model.addColumn("TOTAL");
		
		tblFactura.setModel(model);
		
		monthChooser = new JMonthChooser();
		monthChooser.setMonth(7);
		monthChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				int mes = monthChooser.getMonth();
				int anio = yearChooser.getYear();
				
				listar(0, af.filtrarFacturasPorFecha(mes, anio));
				editarFila();
				
				
			}
		});
		monthChooser.setBounds(642, 154, 109, 20);
		getContentPane().add(monthChooser);
		
		yearChooser = new JYearChooser();
		yearChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				int mes = monthChooser.getMonth();
				int anio = yearChooser.getYear();
				
				listar(0, af.filtrarFacturasPorFecha(mes, anio));
				editarFila();
				
				
			}
		});
		yearChooser.setBounds(642, 184, 109, 20);
		getContentPane().add(yearChooser);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(255, 60, 65));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCancelar.setIcon(new ImageIcon(FrmFactura.class.getResource("/iconos/error.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpieza();
				habilitarEntradas(false);
				btnCancelar.setEnabled(false);
				habilitarBotones(true);
				btnAdicionar.setEnabled(true);
				txtFactura.setEditable(false);
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(485, 143, 99, 35);
		getContentPane().add(btnCancelar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FrmFactura.class.getResource("/imagenes/FONDO VENTAS.png")));
		lblNewLabel_1.setBounds(-16, -4, 1000, 614);
		getContentPane().add(lblNewLabel_1);
		
		
		habilitarEntradas(false);
//		listar(0);
//		editarFila();

	}
	
	protected void mouseClickedTblFactura(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		editarFila();
	}
	
	void eliminar(){
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnOk.setEnabled(false);
		if (af.tamanio() == 0) {
			btnEliminar.setEnabled(false);
			mensaje("No existen Productos");
		} else {
			editarFila();
			habilitarEntradas(false);
			int ok = confirmar("¿ Desea eliminar el registro ?");
			if (ok == 0) {
				Factura x = af.buscar(leerFactura(), leerFecha(), leerProducto(), leerPrecio(), leerCantidad());
				int posFila = tblFactura.getSelectedRow();
				if (posFila == af.tamanio() - 1)
					posFila--;
				af.eliminar(x);
				 
				af.grabarFactura();
				
				int mes = monthChooser.getMonth();
				int anio = yearChooser.getYear();
				listar(posFila, af.filtrarFacturasPorFecha(mes, anio));
				editarFila();
			}
		}
	}
	
	void registrar(){
		if (af.tamanio() == 0)
			btnOk.setEnabled(true);
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnCancelar.setEnabled(true);
		btnEliminar.setEnabled(true);
		habilitarEntradas(true);
		txtFactura.setEditable(true);
		limpieza();
		txtCliente.requestFocus();
	}
	
	void modificar(){
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(true);
		btnCancelar.setEnabled(true);
		if (af.tamanio() == 0) {
			btnOk.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existen Clientes");
		} else {
			btnOk.setEnabled(true);
			habilitarEntradas(true);
			editarFila();
			
			af.grabarFactura();
			
			
			txtCliente.requestFocus();
		}
	}

	// Métodos tipo void (sin parámetros)
	void adicionar(){
		habilitarEntradas(true);
		String factura = leerFactura();
		String producto = leerProducto();
		double precio = leerPrecio();
		String fecha = leerFecha();
		String cliente = leerCliente();
		if (cliente.length() > 0) {
				String ruc = leerRuc();
				if (ruc.length() > 0) {
					try {
						double cantidad = leerCantidad();
						double total = precio * cantidad;
							if (btnAdicionar.isEnabled() == false) {
								if (af.buscar(factura, fecha, producto, precio, cantidad) == null) {
									Factura nueva = new Factura(factura, fecha, cliente, ruc, producto, precio, cantidad, (Math.round(total * 100.0) /100.0) );
									af.adicionar(nueva);
									
									af.grabarFactura();
									btnAdicionar.setEnabled(true);
									txtFactura.setEditable(false);
									
									int mes = monthChooser.getMonth();
									int anio = yearChooser.getYear();
									listar(0, af.filtrarFacturasPorFecha(mes, anio));
									habilitarEntradas(false);
								} else {
									error("YA EXISTE UNA FACTURA CON LOS MISMOS DATOS", txtFactura);
								}
//								
							}
							if (btnModificar.isEnabled() == false) {
								String nFactura = tblFactura.getValueAt(tblFactura.getSelectedRow(), 0).toString();
								String fec = tblFactura.getValueAt(tblFactura.getSelectedRow(), 1).toString();
								String prod = tblFactura.getValueAt(tblFactura.getSelectedRow(), 4).toString();
								double prec = Double.parseDouble(tblFactura.getValueAt(tblFactura.getSelectedRow(), 5).toString());
								double cant = Double.parseDouble(tblFactura.getValueAt(tblFactura.getSelectedRow(), 6).toString());
								
								Factura x = af.buscar(nFactura, fec, prod, prec, cant);
								
								
								x.setFecha(fecha);
								x.setCliente(cliente);
								x.setRuc(ruc);
								x.setProducto(producto);
								x.setPrecio(precio);
								x.setPesoSolicitado(cantidad);
								x.setTotal((Math.round(total * 100.0) /100.0) );
								
								af.grabarFactura();
								btnModificar.setEnabled(true);
//								btnCancelar.setEnabled(false);
								
								int mes = monthChooser.getMonth();
								int anio = yearChooser.getYear();
								listar(tblFactura.getSelectedRow(), af.filtrarFacturasPorFecha(mes, anio));
								
								habilitarEntradas(false);
							}
					} catch (Exception e2) {
						error("ingrese CANTIDAD correcto", txtCantidad);
					}
					
				}else 
					error("ingrese RUC correcto", txtRuc);
		} else 
			error("ingrese NOMBRE CLIENTE correcto", txtCliente);

	}
	
	void listar(int posFila) {
		model.setRowCount(0);
		Factura x;
		for (int i = 0; i < af.tamanio(); i++) {
			x = af.obtener(i);
			Object[] fila = { x.getFactura(), x.getFecha(), x.getCliente(), x.getRuc(), x.getProducto(), x.getPrecio(),x.getPesoSolicitado(),
					 x.getTotal()};
			model.addRow(fila);
		}
		tblFactura.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void listar(int posFila, ArrayList<Factura> s) {
		model.setRowCount(0);
		Factura x;
		for (int i = 0; i < s.size(); i++) {
			x = s.get(i);
			Object[] fila = { x.getFactura(), x.getFecha(), x.getCliente(), x.getRuc(), x.getProducto(), x.getPrecio(),x.getPesoSolicitado(),
					 x.getTotal()};
			model.addRow(fila);
		}
		tblFactura.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void editarFila() {
		if (tblFactura.getRowCount() <= 0)
			limpieza();
		else {
			String nFactura = tblFactura.getValueAt(tblFactura.getSelectedRow(), 0).toString();
			String fecha = tblFactura.getValueAt(tblFactura.getSelectedRow(), 1).toString();
			String producto = tblFactura.getValueAt(tblFactura.getSelectedRow(), 4).toString();
			double precio = Double.parseDouble(tblFactura.getValueAt(tblFactura.getSelectedRow(), 5).toString());
			double cantidad = Double.parseDouble(tblFactura.getValueAt(tblFactura.getSelectedRow(), 6).toString());
			
			Factura x = af.buscar(nFactura, fecha, producto, precio, cantidad);
			txtFactura.setText("" + x.getFactura());
			cboProducto.setSelectedItem(x.getProducto());
//			dateChooser.setDateFormatString(x.getFecha());
			
			// Para editar el JDateChooser en el formulario
			Calendar calendario = new GregorianCalendar();
			String[] a = x.getFecha().split("/");
			calendario.set(Integer.parseInt(a[2]), (Integer.parseInt(a[1]) -1), Integer.parseInt(a[0]));
			dateChooser.setCalendar(calendario);
			
			txtPrecio.setText("" + x.getPrecio());
			txtCliente.setText("" + x.getCliente());
			txtRuc.setText("" + x.getRuc());
			txtCantidad.setText("" + x.getPesoSolicitado());
			
			
		}
	}

	void limpieza() {
		txtFactura.setText("");
		cboProducto.setSelectedIndex(0);
		dateChooser.setCalendar(new GregorianCalendar());
		txtPrecio.setText("");
		txtCliente.setText("");
		txtRuc.setText("");
		txtCantidad.setText("");
		
	}
	
	
	// Métodos tipo void (con parámetros)
	String leerFactura(){
		return txtFactura.getText().trim();
	}
	
	String leerProducto(){
		return cboProducto.getSelectedItem().toString().trim();
	}
	
	double leerPrecio(){
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	
	String leerCliente(){
		return txtCliente.getText().trim();
	}
	
	String leerRuc(){
		return txtRuc.getText().trim();
	}
	
	String leerFecha(){
		return sdf.format(dateChooser.getCalendar().getTime());
	}
	
	double leerCantidad(){
		return Double.parseDouble(txtCantidad.getText().trim());
	}
	
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
		
		cboProducto.setEnabled(sino);
		dateChooser.setEnabled(sino);
		txtCliente.setEditable(sino);
		txtRuc.setEditable(sino);
		txtCantidad.setEditable(sino);
		
	}
	
	void habilitarBotones(boolean sino) {
		btnModificar.setEnabled(sino);
		btnAdicionar.setEnabled(sino);
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
