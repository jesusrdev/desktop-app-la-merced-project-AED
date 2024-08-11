package formularios;


import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class FrmMain extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private FrmIniciarSesion frmIniciarSesion;
	
	private ArrayList<JInternalFrame> formularios = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
					frame.setVisible(true);
					
					// Tamaño maximo por predeterminado
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//Tamaño minimo de la app
					frame.setMinimumSize(new Dimension(700, 600));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMain() {
		
		// Permitir que se adapte el desktopPane al tamaño de la pantalla
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				desktopPane.setBounds(10, 11, contentPane.getWidth()-20, contentPane.getHeight()-20);

				centrarComponente(frmIniciarSesion);
				
				for (JInternalFrame jiframe : formularios) {
					centrarComponente(jiframe);
				}
			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 634);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setEnabled(false);
		setJMenuBar(menuBar);

		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setEnabled(false);
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < formularios.size(); i++) {
					formularios.get(i).setVisible(false);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setEnabled(false);
		menuBar.add(mnArchivo);
		
		JMenu mnProducto = new JMenu("Producto");
		mnProducto.setEnabled(false);
		menuBar.add(mnProducto);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Producto");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmProducto frmRegistrarProducto = new FrmProducto();
				frmRegistrarProducto.setClosable(true);
				desktopPane.add(frmRegistrarProducto);
				
				centrarComponente(frmRegistrarProducto);
				
				ocultarDemasComponentes(frmRegistrarProducto);
				
			}
		});
		mnProducto.add(mntmNewMenuItem_1);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setEnabled(false);
		menuBar.add(mnClientes);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmClientes frmClientes = new FrmClientes();
				frmClientes.setClosable(true);
				desktopPane.add(frmClientes);
				
				centrarComponente(frmClientes);
				
				ocultarDemasComponentes(frmClientes);
				
			}
		});
		mnClientes.add(mntmClientes);
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setEnabled(false);
		menuBar.add(mnVentas);
		
		JMenuItem mntmFacturas = new JMenuItem("Facturas");
		mntmFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmFactura frmFacturas = new FrmFactura();
				frmFacturas.setClosable(true);
				desktopPane.add(frmFacturas);
				
				centrarComponente(frmFacturas);
				
				ocultarDemasComponentes(frmFacturas);
				
			}
		});
		mnVentas.add(mntmFacturas);
		
		JMenu mnStock = new JMenu("Stock");
		mnStock.setEnabled(false);
		menuBar.add(mnStock);
		
		JMenuItem mntmStock = new JMenuItem("Stock de Productos");
		mntmStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmStock frmStock = new FrmStock();
				frmStock.setClosable(true);
				desktopPane.add(frmStock);
				
				centrarComponente(frmStock);
				
				ocultarDemasComponentes(frmStock);
				
			}
		});
		mnStock.add(mntmStock);
		
		JMenu mnCompras = new JMenu("Compras");
		mnCompras.setEnabled(false);
		menuBar.add(mnCompras);
		
		JMenuItem mntmCompras = new JMenuItem("Compras");
		mntmCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmCompras frmCompras = new FrmCompras();
				frmCompras.setClosable(true);
				desktopPane.add(frmCompras);
				
				centrarComponente(frmCompras);
				
				ocultarDemasComponentes(frmCompras);
				
			}
		});
		mnCompras.add(mntmCompras);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnEmpleados.setEnabled(false);
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmEmpleados frmEmpleados = new FrmEmpleados();
				frmEmpleados.setClosable(true);
				desktopPane.add(frmEmpleados);
				frmEmpleados.setVisible(true);
				
				centrarComponente(frmEmpleados);
				
				ocultarDemasComponentes(frmEmpleados);
				
			}
		});
		mnEmpleados.add(mntmEmpleados);
		
		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setEnabled(false);
		menuBar.add(mnReportes);
		
		JMenuItem mntmReportes = new JMenuItem("Reportes");
		mntmReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmReportes frmReportes = new FrmReportes();
				frmReportes.setClosable(true);
				desktopPane.add(frmReportes);
				frmReportes.setVisible(true);
				
				centrarComponente(frmReportes);
				
				ocultarDemasComponentes(frmReportes);
				
			}
		});
		mnReportes.add(mntmReportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 11, 576, 451);
		contentPane.add(desktopPane);
		
		
		
		// Crear formulario de inciio de sesion predeterminado
		
		frmIniciarSesion = new FrmIniciarSesion();
		desktopPane.add(frmIniciarSesion);
		
		centrarComponente(frmIniciarSesion);
		
		ocultarDemasComponentes(frmIniciarSesion);
		
		
	}
	
	private void centrarComponente(JInternalFrame frame) {
			
			// Centrar el componente en el desktopPane
			int x = (desktopPane.getWidth() - frame.getWidth()) / 2;
			int y = (desktopPane.getHeight() - frame.getHeight()) / 2;
			frame.setLocation(x, y);
			
	}
	
	
	private void ocultarDemasComponentes(JInternalFrame internalFrame) {
		formularios.add(internalFrame);
		
		// Asegurarse de que solo aparezca el formulario seleccionado
		for (int i = 0; i < formularios.size(); i++) {
			
			if ( internalFrame == formularios.get(i) ) {
				internalFrame.setVisible(true);
			}
			else {
				formularios.get(i).setVisible(false);
			}
		}
		
	}
}
