package login;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginVista extends JFrame {

	private JPanel contentPane;
	private JTextField userTxt;
	private JTextField passwordTxt;
	private JButton ingresarBtn;
	private JButton cancelarBtn;

	private String usuario;
	private String password;

	/**
	 * Create the frame.
	 */
	public LoginVista() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(55, 50, 69, 20);
		contentPane.add(userLabel);

		userTxt = new JTextField();
		userTxt.setBounds(139, 47, 224, 26);
		contentPane.add(userTxt);
		userTxt.setColumns(10);

		JLabel passLabel = new JLabel("Password");
		passLabel.setBounds(37, 111, 87, 20);
		contentPane.add(passLabel);

		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(139, 108, 224, 26);
		contentPane.add(passwordTxt);

		ingresarBtn = new JButton("Ingresar");
		ingresarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datos();
				if (usuario.equals(userTxt.getText()) && password.equals(passwordTxt.getText())) {
					JOptionPane.showMessageDialog(null, "Bienvenido");

				} else if (userTxt.getText().equals("") && passwordTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un usuario y contraseña");
					userTxt.setFocusable(true);

				} else if (userTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un usuario");
					userTxt.setFocusable(true);

				} else if (userTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un password");
					passwordTxt.setFocusable(true);
				}

				else if (userTxt.getText().compareTo(usuario) != 0 && passwordTxt.getText().compareTo(password) != 0) {
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña no válidos\nIngrese nuevamente.");
					userTxt.setFocusable(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña no válidos\nIngrese nuevamente.");
					userTxt.setFocusable(true);
				}
			}
		});
		ingresarBtn.setBounds(75, 196, 115, 29);
		contentPane.add(ingresarBtn);

		cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cancelarBtn.setBounds(248, 196, 115, 29);
		contentPane.add(cancelarBtn);
	}

	public void datos() {
		usuario = "Admin";
		password = "admin";
	}

	public void initialization() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setTitle("Login");
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		userTxt.setFocusable(true);
	}
}
