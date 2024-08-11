package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Insets;
import java.awt.Point;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrmIniciarSesion2 extends JInternalFrame {
	private JTextField txtCorreo;
	private JLabel lblNewLabel_2;
	private JPasswordField txtContrasenia;
	private JButton btnNewButton;
	private JPanel login;
	private JPanel panelBlock;
	
//	private boolean inicioSesion = false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIniciarSesion2 frame = new FrmIniciarSesion2();
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
	public FrmIniciarSesion2() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("LOGIN");
		setBounds(100, 100, 1100, 611);
		getContentPane().setLayout(null);
		
		login = new JPanel();
		login.setBackground(Color.WHITE);
		login.setBounds(721, 0, 371, 581);
		getContentPane().add(login);
		login.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CORREO");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(31, 200, 326, 14);
		login.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(31, 276, 326, 14);
		login.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		
		txtCorreo = new JTextField();
		txtCorreo.setBackground(new Color(244, 244, 244));
		txtCorreo.setSelectedTextColor(new Color(218, 218, 218));
		txtCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if (txtCorreo.getText().equals("Ingrese su correo...") ) {
					txtCorreo.setText("");
					txtCorreo.setForeground(Color.black);
				}
				if (String.valueOf(txtContrasenia.getPassword()).isEmpty()) {
					txtContrasenia.setText("********");
					txtContrasenia.setForeground(Color.LIGHT_GRAY);
				}
				
			}
		});

		txtCorreo.setForeground(Color.LIGHT_GRAY);
		txtCorreo.setText("Ingrese su correo...");
		txtCorreo.setToolTipText("");
		txtCorreo.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(248, 50, 55)));
		txtCorreo.setBounds(31, 219, 326, 35);
		login.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("INICIAR SESION");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(111, 121, 194, 35);
		login.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBackground(new Color(244, 244, 244));
		txtContrasenia.setSelectedTextColor(new Color(218, 218, 218));
		txtContrasenia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
				if (String.valueOf(txtContrasenia.getPassword()).equals("********")) {
					txtContrasenia.setText("");
					txtContrasenia.setForeground(Color.black);
				}
				if (txtCorreo.getText().isEmpty() ) {
					txtCorreo.setText("Ingrese su correo...");
					txtCorreo.setForeground(Color.LIGHT_GRAY);
				}
				
			}
		});

		txtContrasenia.setForeground(Color.LIGHT_GRAY);
		txtContrasenia.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(248, 50, 55)));
		txtContrasenia.setText("********");
		txtContrasenia.setBounds(31, 295, 326, 35);
		login.add(txtContrasenia);
		
		btnNewButton = new JButton("Ingresar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(248, 50, 55));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(132, 369, 115, 35);
		login.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String correo = txtCorreo.getText();
				
				char[] contrasenia = txtContrasenia.getPassword();
				
				if (validarDatos(correo, contrasenia)) {
					JOptionPane.showMessageDialog(null, "Inicio de sesion exitosa");
					
//					inicioSesion = true;
					
					dispose();
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Correo o contraseña invaldos, vuelva a intentar");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Roboto Black", Font.BOLD, 16));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(FrmIniciarSesion2.class.getResource("/imagenes/INICIO.png")));
		lblNewLabel_3.setBounds(-172, 0, 894, 581);
		getContentPane().add(lblNewLabel_3);
		
		
		txtContrasenia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Se comprueba si se ha presionado la tecla ENTER
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                	try {
                		String correo = txtCorreo.getText();
        				
        				char[] contrasenia = txtContrasenia.getPassword();
        				
        				if (validarDatos(correo, contrasenia)) {
        					JOptionPane.showMessageDialog(null, "Inicio de sesion exitosa");
        					
//        					inicioSesion = true;
        					
        					dispose();
        				}
        				
        				else {
        					JOptionPane.showMessageDialog(null, "Correo o contraseña invaldos, vuelva a intentar");
        				}
					} catch (Exception e2) {
						// TODO: handle exception
					}
                }
            }
        });
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// Se comprueba si se ha presionado la tecla ENTER
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					try {
						String correo = txtCorreo.getText();
						
						char[] contrasenia = txtContrasenia.getPassword();
						
						if (validarDatos(correo, contrasenia)) {
							JOptionPane.showMessageDialog(null, "Inicio de sesion exitosa");
							
//        					inicioSesion = true;
							
							dispose();
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Correo o contraseña invaldos, vuelva a intentar");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});

	}
	
	private boolean validarDatos(String correo, char[] contrasenia) {
        
        String usernameValido = "admin";
        char[] passwordValido = "admin".toCharArray();

        return correo.equals(usernameValido) && Arrays.equals(contrasenia, passwordValido);
	}
	
//	public void habilitarSidebar() {
//
//    }


	
	/////////////////////////////

	public JPanel getPanelBlock() {
		return panelBlock;
	}

	public void setPanelBlock(JPanel panelBlock) {
		this.panelBlock = panelBlock;
	}
}
