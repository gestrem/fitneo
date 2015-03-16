package ui;

import javax.swing.JFrame;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;


import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import core.UserFacade;

import javax.swing.SpringLayout;

import java.awt.Color;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener {

	//Facade de la classe User
	private UserFacade userFacade;
	//type de persistance choisi
	private int persistType;
	//fenetre en cas de mdp oublié	
	public JButton btnForgottenPassword;
	public JDialog passwordForgot;
	//fenetre pour s'enregistrer
	public JDialog registerView;
	public JFrame mainWindow;
	
	private JPasswordField fieldPassword;
	private JTextField fieldLogin;
	private JLabel labelMsg;

	/**
	 * Create the application.
	 */
	public LoginUI(int persistType) {
		this.persistType = persistType;
		//On instancie une facadeUser pour la vue
		this.userFacade = new UserFacade(this.persistType);	
		initialize();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public UserFacade getUserFacade(){
		return userFacade;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setBackground(Color.WHITE);
		setLocationByPlatform(true);
		setTitle("Login Form");
		setResizable(false);
		setSize(new Dimension(350, 450));
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		fieldLogin = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, fieldLogin, 98, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, fieldLogin, -64, SpringLayout.EAST, getContentPane());
		getContentPane().add(fieldLogin);
		fieldLogin.setColumns(10);
		
		fieldPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, fieldPassword, 0, SpringLayout.WEST, fieldLogin);
		springLayout.putConstraint(SpringLayout.EAST, fieldPassword, -64, SpringLayout.EAST, getContentPane());
		fieldPassword.setColumns(10);
		getContentPane().add(fieldPassword);
		
		JLabel lblLogin = new JLabel("Email :");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogin, 3, SpringLayout.NORTH, fieldLogin);
		springLayout.putConstraint(SpringLayout.EAST, lblLogin, -6, SpringLayout.WEST, fieldLogin);
		getContentPane().add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password :");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 3, SpringLayout.NORTH, fieldPassword);
		springLayout.putConstraint(SpringLayout.EAST, lblPassword, -6, SpringLayout.WEST, fieldPassword);
		getContentPane().add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, getContentPane());
		label.setIcon(new ImageIcon("././data/petitlogo.png"));
		getContentPane().add(label);
		
		JButton connectButton = new JButton("Log In");
		springLayout.putConstraint(SpringLayout.SOUTH, fieldPassword, -19, SpringLayout.NORTH, connectButton);
		springLayout.putConstraint(SpringLayout.WEST, connectButton, 0, SpringLayout.WEST, fieldLogin);
		connectButton.addActionListener(this);
		connectButton.setActionCommand("Connexion");
		getContentPane().add(connectButton);
		
		JButton registerButton = new JButton("Sign up now");
		registerButton.addActionListener(this);
		registerButton.setActionCommand("Register");
		springLayout.putConstraint(SpringLayout.SOUTH, registerButton, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, registerButton, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(registerButton);
		
		labelMsg = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, fieldLogin, 18, SpringLayout.SOUTH, labelMsg);
		labelMsg.setVisible(false);
		springLayout.putConstraint(SpringLayout.SOUTH, label, -20, SpringLayout.NORTH, labelMsg);
		springLayout.putConstraint(SpringLayout.SOUTH, labelMsg, -225, SpringLayout.SOUTH, getContentPane());
		labelMsg.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.WEST, labelMsg, 0, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, labelMsg, 0, SpringLayout.EAST, getContentPane());
		getContentPane().add(labelMsg);
		
		btnForgottenPassword = new JButton("Forgotten password ?");
		springLayout.putConstraint(SpringLayout.NORTH, btnForgottenPassword, 326, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, connectButton, -6, SpringLayout.NORTH, btnForgottenPassword);
		springLayout.putConstraint(SpringLayout.WEST, btnForgottenPassword, 0, SpringLayout.WEST, fieldLogin);
		btnForgottenPassword.setVisible(false);
		btnForgottenPassword.addActionListener(this);
		btnForgottenPassword.setActionCommand("forgottenpwd");
		getContentPane().add(btnForgottenPassword);
	}
	
	public String getLoginText(){ 
		return fieldLogin.getText(); 
	}

	public String getPasswdText(){
		return new String( fieldPassword.getPassword() );
	}
	
	public void setLabelMsg(String msg, Color c, boolean b){
		labelMsg.setText(msg);
		labelMsg.setForeground(c);
		labelMsg.setVisible(b);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if(cmd.equals("Connexion")){
			if((!getLoginText().equals("")) && (!getPasswdText().equals(""))){
				if (userFacade.login(getLoginText(), getPasswdText()) == null){
					setLabelMsg("Wrong login and/or password ", Color.RED, true);
					btnForgottenPassword.setVisible(true);
				}
				else{
					//setLabelMsg("Welcome on FitNeo, "+getLoginText()+" !", Color.GREEN, true);
					mainWindow = new MainView();
					mainWindow.setVisible(true);
					dispose();
				}
			}			
		}
		else if(cmd.equals("Register")){
			registerView= new RegisterView(this, true);
			registerView.setVisible(true);
		}
		else if(cmd.equals("forgottenpwd")){
			passwordForgot= new PasswordForgottenView(this, true);
			passwordForgot.setVisible(true);
		}
	}
}
