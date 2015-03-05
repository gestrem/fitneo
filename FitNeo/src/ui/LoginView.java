package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import core.UserFacade;

@SuppressWarnings("serial")
public class LoginView extends JFrame implements ILoginView {
	
	public LoginView(){
		super("login Form");
		initComponents();
	};
	
	public String getLoginText(){ 
		return fieldLogin.getText(); 
	}

	public String getPasswdText(){
		return new String( fieldPassword.getPassword() );
	}

	JTextField fieldLogin;
	JPasswordField fieldPassword;
	JButton connectButton;
	JButton missingpwdButton;
	  
	private void initComponents()
	{
		setBounds(100, 100, 691, 488);
		Container contentPane = getContentPane();
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ActionListener e = new ButtonListener();
		  
		JPanel loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		fieldLogin= new JTextField(15);
		fieldPassword= new JPasswordField(15);
		connectButton = new JButton("Sign In");
		missingpwdButton = new JButton("Forgotten password");
		loginPanel.setLayout(new GridLayout(3,2));
		JLabel login = new JLabel("Login :",JLabel.CENTER);
		JLabel pwd = new JLabel("Password :",JLabel.CENTER);
		JLabel lblNewLabel = new JLabel("Connection");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		connectButton.addActionListener(e);
		connectButton.setActionCommand("Connexion");
		missingpwdButton.addActionListener(e);
		missingpwdButton.setActionCommand("forgottenpwd");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(pwd)
								.addComponent(login))
							.addGap(59)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(fieldPassword, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(fieldLogin, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
								.addComponent(connectButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(37)))
					.addGap(347))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(228)
					.addComponent(missingpwdButton)
					.addContainerGap(296, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(login)
						.addComponent(fieldLogin, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwd)
						.addComponent(fieldPassword, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(connectButton)
					.addGap(18)
					.addComponent(missingpwdButton)
					.addGap(101))
		);
		contentPane.setLayout(gl_contentPane);
	  }
	
	public class ButtonListener implements ActionListener {
		public JFrame passwordForgot;
		public ButtonListener(){}
		
		public void actionPerformed(ActionEvent e)
		{
			String cmd = e.getActionCommand();
			if(cmd.equals("Connexion")){
				if((!getLoginText().equals("")) && (!getPasswdText().equals(""))){
					UserFacade facade = new UserFacade();
					facade.login(getLoginText(), getPasswdText());
				}			
			}
			else if(cmd.equals("forgottenpwd")){
				passwordForgot= new PasswordForgottenView();
				passwordForgot.setVisible(true);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		 LoginView loginView = new LoginView();
		 loginView.setVisible(true);
	}
}
