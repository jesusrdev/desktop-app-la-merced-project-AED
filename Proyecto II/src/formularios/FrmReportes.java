package formularios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import arreglos.ArregloCompras;
import arreglos.ArregloFacturas;
import arreglos.ArregloProductos;
import arreglos.ArregloStock;
import clases.StockProducto;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;

public class FrmReportes extends JInternalFrame {
	
	ArregloStock as = new ArregloStock();
	
	ArregloFacturas af = new ArregloFacturas();
	ArregloProductos ap = new ArregloProductos();

	private static final long serialVersionUID = 1L;
	private JTable tblReportesDelMes;
	private DefaultTableModel modeloReportesDelMes;
	private JTable tblReportesDelAnio;
	private DefaultTableModel modeloReportesDelAnio;
	private JYearChooser yearChooserReportesDelMes;
	private JYearChooser yearChooserReportesDelAnio;
	private JMonthChooser monthChooserReportesDelMes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReportes frame = new FrmReportes();
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
	public FrmReportes() {
		as.cargarStocks();
		
		setTitle("10 PRODUCTOS MAS VENDIDOS");
		setBounds(100, 100, 600, 455);
		getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(291, 11, 2, 400);
		getContentPane().add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 97, 271, 313);
		getContentPane().add(scrollPane);
		
		tblReportesDelMes = new JTable();
		
		modeloReportesDelMes = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Orden", "Producto", "Cantidad"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
		tblReportesDelMes.setModel(modeloReportesDelMes);
		
		scrollPane.setViewportView(tblReportesDelMes);
		
		monthChooserReportesDelMes = new JMonthChooser();
		monthChooserReportesDelMes.setMonth(7);
		monthChooserReportesDelMes.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				int mes = monthChooserReportesDelMes.getMonth();
				int anio = yearChooserReportesDelMes.getYear();
				
				try {
					ArrayList<StockProducto> arreglo = as.filtrarStocksPorFecha(mes, anio);
					buscarLosDiezProductosMasVendidosDelMes(arreglo, modeloReportesDelMes);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		});
		monthChooserReportesDelMes.setBounds(31, 15, 110, 20);
		getContentPane().add(monthChooserReportesDelMes);
		
		yearChooserReportesDelMes = new JYearChooser();
		yearChooserReportesDelMes.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				int mes = monthChooserReportesDelMes.getMonth();
				int anio = yearChooserReportesDelMes.getYear();
				
				try {
					ArrayList<StockProducto> arreglo = as.filtrarStocksPorFecha(mes, anio);
					buscarLosDiezProductosMasVendidosDelMes(arreglo, modeloReportesDelMes);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		yearChooserReportesDelMes.setBounds(166, 15, 100, 20);
		getContentPane().add(yearChooserReportesDelMes);
		
		JButton btnReportesDelMes = new JButton("Generar reporte del mes");
		btnReportesDelMes.setBounds(57, 52, 177, 23);
		getContentPane().add(btnReportesDelMes);
		
		yearChooserReportesDelAnio = new JYearChooser();
		yearChooserReportesDelAnio.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				int anio = yearChooserReportesDelAnio.getYear();
				
				try {
					ArrayList<StockProducto> arreglo = as.ventasTotalesDeLosProductosEnUnAnio(anio, af, ap);
					buscarLosDiezProductosMasVendidosDelMes(arreglo, modeloReportesDelAnio);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		yearChooserReportesDelAnio.setBounds(459, 15, 100, 20);
		getContentPane().add(yearChooserReportesDelAnio);
		
		JButton btnReportesDelAnio = new JButton("Generar reporte del año");
		btnReportesDelAnio.setBounds(350, 52, 177, 23);
		getContentPane().add(btnReportesDelAnio);
		
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(302, 97, 271, 313);
		getContentPane().add(scrollPane2);
		
		tblReportesDelAnio = new JTable();
		
		modeloReportesDelAnio = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Orden", "Producto", "Cantidad"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
		tblReportesDelAnio.setModel(modeloReportesDelAnio);
		
		scrollPane2.setViewportView(tblReportesDelAnio);

	}
	
	
	public void buscarLosDiezProductosMasVendidosDelMes(ArrayList<StockProducto> arreglo, DefaultTableModel model) {
		
		model.setRowCount(0);
		StockProducto prodMasVendido;
		
		for (int i = 0; i < 10 ; i++) {
			
			prodMasVendido = buscarElProductoMasVendido(arreglo);
			
			if (prodMasVendido.getEgresos() > 0) {
				Object[] fila = { i + 1, prodMasVendido.getNombreProducto(), prodMasVendido.getEgresos() };
				model.addRow(fila);
			}
			
			arreglo.remove(prodMasVendido);
			
		}
		
	}
	
	public StockProducto buscarElProductoMasVendido(ArrayList<StockProducto> arreglo) {
		StockProducto prodMasVendido = arreglo.get(0);
		
		for (int i = 0; i < arreglo.size(); i++) {
			StockProducto prod = arreglo.get(i);
			
			if ( prodMasVendido.getEgresos() < prod.getEgresos() ) {
				prodMasVendido = prod;
			}
		}
		
		return prodMasVendido;
	}
	
	
}
