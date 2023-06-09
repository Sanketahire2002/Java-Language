import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

class Frame_2
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(700,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(800,400);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setTitle("Student Login Page");
		
		frame.setLayout(null);
		
		JLabel lblUsername = new JLabel();
		lblUsername.setText("User Name");
		lblUsername.setBounds (50,50,100,30);
		lblUsername.setFont (new Font ("Arial", Font.BOLD, 18));
		lblUsername.setForeground (Color.RED);
		frame.add(lblUsername);
		
		JTextField txtUsername = new JTextField(); 
		txtUsername.setBounds(200,50,100,30);
		frame.add (txtUsername);
		
		JLabel lblPassword = new JLabel();
		lblPassword.setText("Password");
		lblPassword.setBounds (50,110,100,30);
		lblPassword.setFont (new Font ("Arial", Font.BOLD, 18));
		lblPassword.setForeground (Color.RED);
		frame.add(lblPassword);
		
		JTextField txtPassword = new JTextField(); 
		txtPassword.setBounds(200,110,100,30);
		frame.add (txtPassword);
		
		JButton btnLogin = new JButton();
		btnLogin.setText("Login");
		btnLogin.setBounds (80, 160, 100, 30);
		frame.add(btnLogin);
		
		JButton btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.setBounds(200, 160, 100, 30);
		frame.add(btnCancel);
	}
}