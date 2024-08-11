package guis;

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
import clases.MejorProducto;
import clases.StockProducto;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import utils.ReporteConfiguracion;
import utils.ReporteNombre;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmReportes extends JInternalFrame {
	
	ArregloStock as = new ArregloStock();
	
	ArregloFacturas af = new ArregloFacturas();
	ArregloProductos ap = new ArregloProductos();
	
	ArrayList<MejorProducto> mejoresProductosMes = new ArrayList<MejorProducto>();
	ArrayList<MejorProducto> mejoresProductosAnio = new ArrayList<MejorProducto>();
	
	
//	ArrayList<MejorProducto> mejoresProductos = new ArrayList<MejorProducto>();

	private static final long serialVersionUID = 1L;
	private JTable tblReportesDelMes;
	private DefaultTableModel modeloReportesDelMes;
	private JTable tblReportesDelAnio;
	private DefaultTableModel modeloReportesDelAnio;
	private JYearChooser yearChooserReportesDelMes;
	private JYearChooser yearChooserReportesDelAnio;
	private JMonthChooser monthChooserReportesDelMes;
	private JLabel lblNewLabel;

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
		setBounds(100, 100, 1000, 611);
		getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(481, 36, 2, 517);
		getContentPane().add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 97, 406, 459);
		getContentPane().add(scrollPane);
		
		tblReportesDelMes = new JTable();
		tblReportesDelMes.setForeground(new Color(45, 45, 255));
		tblReportesDelMes.setGridColor(new Color(255, 255, 255));
		
		modeloReportesDelMes = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ODEN", "PRODUCTO", "CANTIDAD"
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
		monthChooserReportesDelMes.getComboBox().setForeground(new Color(0, 0, 255));
		monthChooserReportesDelMes.setMonth(7);
		monthChooserReportesDelMes.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				int mes = monthChooserReportesDelMes.getMonth();
				int anio = yearChooserReportesDelMes.getYear();
				
				try {
					ArrayList<StockProducto> arreglo = as.filtrarStocksPorFecha(mes, anio);
					mejoresProductosMes = buscarLosDiezProductosMasVendidosDelMes(arreglo, modeloReportesDelMes);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
		});
		monthChooserReportesDelMes.setBounds(141, 18, 110, 20);
		getContentPane().add(monthChooserReportesDelMes);
		
		yearChooserReportesDelMes = new JYearChooser();
		yearChooserReportesDelMes.getSpinner().setForeground(new Color(0, 0, 255));
		yearChooserReportesDelMes.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				int mes = monthChooserReportesDelMes.getMonth();
				int anio = yearChooserReportesDelMes.getYear();
				
				try {
					ArrayList<StockProducto> arreglo = as.filtrarStocksPorFecha(mes, anio);
					mejoresProductosMes = buscarLosDiezProductosMasVendidosDelMes(arreglo, modeloReportesDelMes);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		yearChooserReportesDelMes.setBounds(276, 18, 100, 20);
		getContentPane().add(yearChooserReportesDelMes);
		
		JButton btnReportesDelMes = new JButton("Generar reporte del mes");
		btnReportesDelMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
//				FrmReportes2 frmReportes2 = new FrmReportes2();
				
				
				
			}
		});
		btnReportesDelMes.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnReportesDelMes.setBackground(new Color(255, 255, 255));
		btnReportesDelMes.setIcon(new ImageIcon(FrmReportes.class.getResource("/iconos/reporte-anual.png")));
		btnReportesDelMes.setBounds(151, 52, 212, 34);
		getContentPane().add(btnReportesDelMes);
		
		yearChooserReportesDelAnio = new JYearChooser();
		yearChooserReportesDelAnio.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				int anio = yearChooserReportesDelAnio.getYear();
				
				try {
					ArrayList<StockProducto> arreglo = as.ventasTotalesDeLosProductosEnUnAnio(anio, af, ap);
					mejoresProductosAnio = buscarLosDiezProductosMasVendidosDelMes(arreglo, modeloReportesDelAnio);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		yearChooserReportesDelAnio.setBounds(652, 18, 100, 20);
		getContentPane().add(yearChooserReportesDelAnio);
		
		JButton btnReportesDelAnio = new JButton("Generar reporte del año");
		btnReportesDelAnio.setForeground(new Color(0, 0, 0));
		btnReportesDelAnio.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnReportesDelAnio.setBackground(new Color(255, 255, 255));
		btnReportesDelAnio.setIcon(new ImageIcon(FrmReportes.class.getResource("/iconos/reporte-anual.png")));
		btnReportesDelAnio.setBounds(603, 52, 212, 34);
		getContentPane().add(btnReportesDelAnio);
		
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(506, 97, 406, 459);
		getContentPane().add(scrollPane2);
		
		tblReportesDelAnio = new JTable();
		tblReportesDelAnio.setForeground(new Color(45, 45, 255));
		tblReportesDelAnio.setGridColor(new Color(255, 255, 255));
		
		modeloReportesDelAnio = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ORDEN", "PRODUCTO", "CANTIDAD"
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
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmReportes.class.getResource("/imagenes/FONDO REPORTE.png")));
		lblNewLabel.setBounds(-15, 0, 999, 611);
		getContentPane().add(lblNewLabel);

	}
	
	
	public ArrayList<MejorProducto> buscarLosDiezProductosMasVendidosDelMes(ArrayList<StockProducto> arreglo, DefaultTableModel model) {
		
		model.setRowCount(0);
		StockProducto prodMasVendido;
		
		ArrayList<MejorProducto> mejoresProductos = new ArrayList<MejorProducto>();
		
		for (int i = 0; i < 10 ; i++) {
			
			prodMasVendido = buscarElProductoMasVendido(arreglo);
			
			mejoresProductos.add(new MejorProducto(i+1, prodMasVendido.getNombreProducto(), prodMasVendido.getEgresos()));
			
			if (prodMasVendido.getEgresos() > 0) {
				Object[] fila = { i + 1, prodMasVendido.getNombreProducto(), prodMasVendido.getEgresos() };
				model.addRow(fila);
			}
			
			arreglo.remove(prodMasVendido);
			
		}
		
		return mejoresProductos;
		
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
