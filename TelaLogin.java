//Tela de login criada com usuário default como "admin" e senha default como "mestre"

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login_System {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_System window = new Login_System();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 525, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Sistema");
		lblNewLabel.setBounds(207, 10, 105, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Usuário");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUsername.setBounds(42, 90, 111, 26);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(163, 92, 231, 19);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(163, 150, 231, 19);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(42, 153, 111, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String senha = txtPassword.getText();
				String usuario = txtUsername.getText();
				
				if (senha.contains("mestre") && usuario.contains("admin")) {
					JOptionPane.showMessageDialog(null, "Login bem sucedido");
					frame.dispose(); //Se usuário e senha estão corretos, avisa que o login foi bem sucedido e fecha a janela (dispose)
				} else {
					JOptionPane.showMessageDialog(null, "Login inválido!","Erro",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null); //Se o usuário e senha estiverem incorretos, avisa de que o login é inválido e reseta os campos
					txtUsername.setText(null);
				}
			}
		});
		btnNewButton.setBounds(63, 232, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnLimpar.setBounds(207, 232, 85, 21);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirme para sair", "Login Systems"
						, JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				}
		});
		btnSair.setBounds(355, 232, 85, 21);
		frame.getContentPane().add(btnSair);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 203, 446, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 50, 446, 2);
		frame.getContentPane().add(separator_1);
	}
}
