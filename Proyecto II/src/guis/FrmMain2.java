package guis;


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
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.SystemColor;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class FrmMain2 extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private FrmIniciarSesion2 frmIniciarSesion;
	
	private ArrayList<JInternalFrame> formularios = new ArrayList<>();
	private ArrayList<JPanel> sidebarButtons = new ArrayList<>();
	private ArrayList<JLabel> labels = new ArrayList<>();
	
	private JLabel lblHola;
	private JPanel btnHome;
	private JLabel lblHome;
	private JPanel btnProductos;
	private JLabel lblProductos;
	private JPanel btnVentas;
	private JLabel lblVentas;
	private JPanel btnClientes;
	private JLabel lblClientes;
	private JPanel btnCompras;
	private JLabel lblCompras;
	private JPanel btnStock;
	private JLabel lblStock;
	private JPanel btnReportes;
	private JLabel lblReportes;
	private JPanel btnEmpleados;
	private JLabel lblEmpleados;
	private JPanel sidebar;
	
	
	// Variables para los guis
	private FrmProducto frmProductos;
	private FrmClientes frmClientes;
	private FrmFactura frmVentas;
	
	// Variables para los colores
	private Color colorDefault = new Color(255, 155, 157);
	private Color colorClicked = new Color(254, 36, 36);
	private Color colorHover = new Color(254, 241, 241);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain2 frame = new FrmMain2();
					frame.setVisible(true);
					
					// Tamaño maximo por predeterminado
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//Tamaño minimo de la app
					frame.setMinimumSize(new Dimension(1000, 600));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMain2() {
		setTitle("LA MERCED");
		
		// Permitir que se adapte el desktopPane al tamaño de la pantalla
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				desktopPane.setBounds(275, 0, contentPane.getWidth()-275, contentPane.getHeight());

				centrarComponente(frmIniciarSesion);
				
				sidebar.setBounds(0, 0, 275, contentPane.getHeight());

			}
		});
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(275, 0, 571, 595);
		contentPane.add(desktopPane);
		
		
		// Asignacion para los guis
		frmProductos = new FrmProducto();
		frmProductos.setClosable(true);
		desktopPane.add(frmProductos);

		frmClientes = new FrmClientes();
		frmClientes.setClosable(true);
		desktopPane.add(frmClientes);

		frmVentas = new FrmFactura();
		frmVentas.setClosable(true);
		desktopPane.add(frmVentas);
		
		
		sidebar = new JPanel();
		sidebar.setBackground(new Color(255, 174, 176));
		sidebar.setBounds(0, 0, 275, 595);
		contentPane.add(sidebar);
		
		lblHola = new JLabel("");
		lblHola.setPreferredSize(new Dimension(275, 200));
		lblHola.setIcon(new ImageIcon(FrmMain2.class.getResource("/imagenes/1.png")));
		lblHola.setBackground(colorDefault);
		lblHola.setHorizontalAlignment(SwingConstants.CENTER);
		sidebar.add(lblHola);
		
		btnHome = new JPanel();
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnHome.setBackground(colorDefault);
		sidebar.add(btnHome);
		
		lblHome = new JLabel("Home");
		lblHome.setPreferredSize(new Dimension(275, 40));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setFont(new Font("Verdana", Font.BOLD, 14));
		btnHome.add(lblHome);
//		sidebarButtonsEvents(btnHome); // Eventos del mouse
		
		btnProductos = new JPanel();
		btnProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnProductos.setBackground(colorDefault);
		sidebar.add(btnProductos);
		
		lblProductos = new JLabel("Productos");
		lblProductos.setPreferredSize(new Dimension(275, 40));
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Verdana", Font.BOLD, 14));
		btnProductos.add(lblProductos);
//		sidebarButtonsEvents(lblProductos, btnProductos); // Eventos del mouse
		
		btnVentas = new JPanel();
		btnVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnVentas.setBackground(colorDefault);
		sidebar.add(btnVentas);
		
		lblVentas = new JLabel("Ventas");
		lblVentas.setPreferredSize(new Dimension(275, 40));
		lblVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentas.setFont(new Font("Verdana", Font.BOLD, 14));
		btnVentas.add(lblVentas);
//		sidebarButtonsEvents(lblVentas, btnVentas); // Eventos del mouse
		
		btnClientes = new JPanel();
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnClientes.setBackground(colorDefault);
		sidebar.add(btnClientes);
		
		lblClientes = new JLabel("Clientes");
		lblClientes.setPreferredSize(new Dimension(275, 40));
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Verdana", Font.BOLD, 14));
		btnClientes.add(lblClientes);
//		sidebarButtonsEvents(lblClientes, btnClientes); // Eventos del mouse
		
		btnCompras = new JPanel();
		btnCompras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		sidebarButtonsEvents(btnCompras); // Eventos del mouse
		
		btnCompras.setBackground(colorDefault);
		sidebar.add(btnCompras);
		
		lblCompras = new JLabel("Compras");
		lblCompras.setPreferredSize(new Dimension(275, 40));
		lblCompras.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompras.setFont(new Font("Verdana", Font.BOLD, 14));
		btnCompras.add(lblCompras);
		
		btnStock = new JPanel();
		btnStock.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		sidebarButtonsEvents(btnEmpleados); // Eventos del mouse
		
		btnStock.setBackground(colorDefault);
		sidebar.add(btnStock);
		
		lblStock = new JLabel("Stock");
		lblStock.setPreferredSize(new Dimension(275, 40));
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Verdana", Font.BOLD, 14));
		btnStock.add(lblStock);
		
		btnReportes = new JPanel();
		btnReportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReportes.setBackground(colorDefault);
		sidebar.add(btnReportes);
		
		lblReportes = new JLabel("Reportes");
		lblReportes.setPreferredSize(new Dimension(275, 40));
		lblReportes.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportes.setFont(new Font("Verdana", Font.BOLD, 14));
		btnReportes.add(lblReportes);
		
		btnEmpleados = new JPanel();
		btnEmpleados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmpleados.setBackground(colorDefault);
		sidebar.add(btnEmpleados);
		
		lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setPreferredSize(new Dimension(275, 40));
		lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleados.setFont(new Font("Verdana", Font.BOLD, 14));
		btnEmpleados.add(lblEmpleados);
		
		// Crear formulario de inciio de sesion predeterminado
		
		frmIniciarSesion = new FrmIniciarSesion2();
		frmIniciarSesion.addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0) {
				
				sidebarButtonsEvents(lblHome, btnHome);
				sidebarButtonsEvents(lblProductos, btnProductos);
				sidebarButtonsEvents(lblClientes, btnClientes);
				sidebarButtonsEvents(lblVentas, btnVentas);
				sidebarButtonsEvents(lblCompras, btnCompras);
				sidebarButtonsEvents(lblStock, btnStock);
				sidebarButtonsEvents(lblReportes, btnReportes);
				sidebarButtonsEvents(lblEmpleados, btnEmpleados);
				
			}
		});
//		frmIniciarSesion.
		
		frmIniciarSesion.setClosable(false);
		desktopPane.add(frmIniciarSesion);
		
		centrarComponente(frmIniciarSesion);
		
		ocultarDemasComponentes(frmIniciarSesion);
		
		
		coloresTextoLabels(colorHover);
		coloresFondoPanels(colorDefault);
		
		
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
			formularios.get(i).setVisible(false);
		}
		internalFrame.setVisible(true);
		
	}
	
	private void cambiarColorAlClick(JPanel btn, JLabel lbl) {
		sidebarButtons.add(btn);
		labels.add(lbl);
		
		for (JPanel panel : sidebarButtons) {
			panel.setBackground(colorDefault);
		}
		for (JLabel label : labels) {
			label.setForeground(colorHover);
		}
		
		btn.setBackground(colorClicked);
		lbl.setForeground(Color.WHITE);
	}
	
	
	private void sidebarButtonsEvents(JLabel btn, JPanel panel) {
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cambiarColorAlClick(panel, btn);
				
				switch (btn.getText().toString()) {
				case "Home":
					
					for (int i = 0; i < formularios.size(); i++) {
						formularios.get(i).setVisible(false);
					}
					
					break;
				case "Productos":
					
					FrmProducto frmProducto = new FrmProducto();
					frmProducto.setClosable(true);
					desktopPane.add(frmProducto);
					
					centrarComponente(frmProducto);
					
					ocultarDemasComponentes(frmProducto);
					
					
					break;
				case "Clientes":
					
					FrmClientes frmClientes = new FrmClientes();
					frmClientes.setClosable(true);
					desktopPane.add(frmClientes);
					
					centrarComponente(frmClientes);
					
					ocultarDemasComponentes(frmClientes);
					
					
					break;
				case "Ventas":
					
					FrmFactura frmFacturas = new FrmFactura();
					frmFacturas.setClosable(true);
					desktopPane.add(frmFacturas);
					
					centrarComponente(frmFacturas);
					
					ocultarDemasComponentes(frmFacturas);
					
					
					break;
				case "Compras":
					
					FrmCompras frmCompras = new FrmCompras();
					frmCompras.setClosable(true);
					desktopPane.add(frmCompras);
					
					centrarComponente(frmCompras);
					
					ocultarDemasComponentes(frmCompras);
					
					
					break;
				case "Stock":
					
					FrmStock frmStock = new FrmStock();
					frmStock.setClosable(true);
					desktopPane.add(frmStock);
					
					centrarComponente(frmStock);
					
					ocultarDemasComponentes(frmStock);
					
					
					break;
				case "Reportes":
					
					FrmReportes frmReportes = new FrmReportes();
					frmReportes.setClosable(true);
					desktopPane.add(frmReportes);
//					frmReportes.setVisible(true);
					
					centrarComponente(frmReportes);
					
					ocultarDemasComponentes(frmReportes);
					
					
					break;
				case "Empleados":
					
					FrmEmpleados frmEmpleados = new FrmEmpleados();
					frmEmpleados.setClosable(true);
					desktopPane.add(frmEmpleados);
//					frmEmpleados.setVisible(true);
					
					centrarComponente(frmEmpleados);
					
					ocultarDemasComponentes(frmEmpleados);
					
					
					break;

				default:
					break;
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (panel.getBackground() != colorClicked) {
					panel.setBackground(colorHover);	
					btn.setForeground(colorDefault);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (panel.getBackground() != colorClicked) {
					panel.setBackground(colorDefault);
					btn.setForeground(Color.white);
				}
			}
		});
	}

	void coloresTextoLabels(Color color) {
		lblClientes.setForeground(color);
		lblCompras.setForeground(color);
		lblEmpleados.setForeground(color);
		lblHome.setForeground(color);
		lblProductos.setForeground(color);
		lblReportes.setForeground(color);
		lblStock.setForeground(color);
		lblVentas.setForeground(color);
	}
	
	void coloresFondoPanels(Color color) {
		btnClientes.setBackground(color);
		btnCompras.setBackground(color);
		btnEmpleados.setBackground(color);
		btnHome.setBackground(color);
		btnProductos.setBackground(color);
		btnReportes.setBackground(color);
		btnStock.setBackground(color);
		btnVentas.setBackground(color);
	}

}
