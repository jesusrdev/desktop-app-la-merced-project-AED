package formularios;

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
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class FrmIniciarSesion extends JInternalFrame {
	private JTextField txtCorreo;
	private JLabel lblNewLabel_2;
	private JPasswordField txtContrasenia;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIniciarSesion frame = new FrmIniciarSesion();
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
	public FrmIniciarSesion() {
		setTitle("Iniciar sesión");
		setBounds(100, 100, 367, 337);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo:");
		lblNewLabel.setFont(new Font("Recursive Mn Lnr St SmB", Font.PLAIN, 14));
		lblNewLabel.setBounds(55, 87, 107, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setFont(new Font("Recursive Mn Lnr St SmB", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(55, 163, 107, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(55, 112, 249, 29);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("INICIAR SESION");
		lblNewLabel_2.setFont(new Font("Myanmar Text", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(80, 30, 194, 35);
		getContentPane().add(lblNewLabel_2);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(55, 188, 249, 29);
		getContentPane().add(txtContrasenia);
		
		btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String correo = txtCorreo.getText();
				
				char[] contrasenia = txtContrasenia.getPassword();
				
				if (validarDatos(correo, contrasenia)) {
					JOptionPane.showMessageDialog(null, "Inicio de sesion exitosa");
					
					habilitarBarraMenu();
					
					dispose();
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Correo o contrase�a invaldos, vuelva a intentar");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Recursive Sn Csl St Med", Font.BOLD, 13));
		btnNewButton.setBounds(118, 251, 115, 29);
		getContentPane().add(btnNewButton);
		
		
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
        					
        					habilitarBarraMenu();
        					
        					dispose();
        				}
        				
        				else {
        					JOptionPane.showMessageDialog(null, "Correo o contrase�a invaldos, vuelva a intentar");
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
	
	private void habilitarBarraMenu() {
		JFrame ventanaPrincipal = (JFrame) getTopLevelAncestor();
		JMenuBar menuBar = ventanaPrincipal.getJMenuBar();
		
		menuBar.setEnabled(true);
		
		for (int i = 0; i < menuBar.getMenuCount(); i++) {
//                Menu menu = menuBar.getMenu(i);
//                menu.setEnabled(true);
			menuBar.getMenu(i).setEnabled(true);
		}
		

    }
	

	
}
