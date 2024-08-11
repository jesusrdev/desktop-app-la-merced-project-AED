package guis;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import arreglos.ArregloCompras;
import arreglos.ArregloFacturas;
import arreglos.ArregloProductos;
import arreglos.ArregloStock;
import clases.StockProducto;


import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;

public class FrmStock extends JInternalFrame {

	ArregloStock as = new ArregloStock();
	ArregloFacturas af = new ArregloFacturas();
	ArregloCompras ac = new ArregloCompras();
	ArregloProductos ap = new ArregloProductos();
	
	
	
	
	private static final long serialVersionUID = 1L;
	private JTable tableStock;
	private DefaultTableModel model = new DefaultTableModel() ;
	private JScrollPane scrollPane;
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStock frame = new FrmStock();
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
	public FrmStock() {
		setTitle("STOCK DE LOS PRODUCTOS");
		
		// Generar los stocks
//		as.generarInformacionDeLosStocks(ac, af);
		generarStockDeLosMesesSiguientes();
		
		
		
		// GUI
		setBounds(100, 100, 1000, 611);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 65, 722, 505);
		getContentPane().add(scrollPane);
		
		tableStock = new JTable();
		tableStock.setForeground(new Color(45, 45, 255));
		tableStock.setGridColor(new Color(255, 255, 255));
		tableStock.setShowVerticalLines(false);
		tableStock.setShowHorizontalLines(false);
		tableStock.setBorder(null);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"DESCRIPCION", "STOCK INICIAL", "INGRESOS", "EGRESOS", "STOCK FINAL"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		tableStock.setModel(model);
		
		scrollPane.setViewportView(tableStock);
		
		monthChooser = new JMonthChooser();
		monthChooser.getComboBox().setForeground(new Color(0, 0, 255));
		monthChooser.setMonth(7);
		monthChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				as.generarInformacionDeLosStocks(ac, af);
				
				int mes = monthChooser.getMonth();
				int anio = yearChooser.getYear();
				
				listar(0, as.filtrarStocksPorFecha(mes, anio));
				
				
			}
		});
		
		monthChooser.setBounds(275, 26, 107, 20);
		getContentPane().add(monthChooser);
		
		yearChooser = new JYearChooser();
		yearChooser.getSpinner().setForeground(new Color(0, 0, 255));
		yearChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				as.generarInformacionDeLosStocks(ac, af);
				
				int mes = monthChooser.getMonth();
				int anio = yearChooser.getYear();
				
				listar(0, as.filtrarStocksPorFecha(mes, anio));
				
				
			}
		});
		
		yearChooser.setBounds(416, 26, 100, 20);
		getContentPane().add(yearChooser);
		
		JButton btnGenerarReportes = new JButton("Generar reportes");
		btnGenerarReportes.setFont(new Font("Roboto Black", Font.BOLD, 11));
		btnGenerarReportes.setBackground(new Color(255, 255, 255));
		btnGenerarReportes.setIcon(new ImageIcon(FrmStock.class.getResource("/iconos/buscar.png")));
		btnGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				Map params = new HashMap();
//				
//				JRDataSource dataSource = new JRTableModelDataSource(tableStock.getModel());
//				JasperPrint print = JasperFillManager.fillReport("pathToYourReport.jasper", params, dataSource);
//				JasperViewer.viewReport(print, true); // true == Exit on Close
				
			}
		});
		btnGenerarReportes.setBounds(566, 21, 177, 33);
		getContentPane().add(btnGenerarReportes);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmStock.class.getResource("/imagenes/FONDO STOCK.png")));
		lblNewLabel.setBounds(-14, -4, 998, 616);
		getContentPane().add(lblNewLabel);

		
		ajustarAnchoColumnas();
		listar(0);
	}
	
	
	
	public void generarStockDeLosMesesSiguientes() {
		int mesInicio = 8;
		int anioInicio = 2023;
		String[] lista = ap.productosComboBox();
		
		while ( anioInicio < 2025 ) {
			for (int i = 0; i < ap.tamanio(); i++) {
				as.adicionar(new StockProducto(lista[i], mesInicio,anioInicio));
			}
			
			if ( mesInicio == 11 ) {
				mesInicio = 0;
				anioInicio++;
			} else {
				mesInicio++;
			}
		}
		
		as.generarInformacionDeLosStocks(ac, af);
	}
	
	void listar(int posFila) {
		model.setRowCount(0);
		StockProducto x;
		for (int i = 0; i < as.tamanio(); i++) {
			x = as.obtener(i);
			Object[] fila = { x.getNombreProducto(), x.getStockInicial(), x.getIngresos(), x.getEgresos(), x.getStockFinal() };
			model.addRow(fila);
		}
		tableStock.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void listar(int posFila, ArrayList<StockProducto> s) {
		model.setRowCount(0);
		StockProducto x;
		for (int i = 0; i < s.size(); i++) {
			x = s.get(i);
			Object[] fila = { x.getNombreProducto(), x.getStockInicial(), x.getIngresos(), x.getEgresos(), x.getStockFinal() };
			model.addRow(fila);
		}
		tableStock.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tableStock.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(18)); // DESCRIPCION
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10)); // STOCK INICIAL
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10)); // INGRESOS
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); // EGRESOS
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); // STOCK FINAL
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
