package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class RegisterView extends JDialog implements ActionListener {

	//attribut de la fenetre
	private final JPanel contentPanel = new JPanel();
	private JTextField firstNameField;
	private JTextField LastNameField;
	private JTextField mailField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmField;
	private JTextField zipField;
	private JTextField cityField;
	private JTextField answerField;
	private JTextArea adressField;
	private JComboBox questionBox;
	//JFrame a partir de laquelle on crée cette fenetre
	private LoginUI owner;

	//toutes les infos sur le user a enregistrer
	private String userFirstName;
	private String userLastName;
	private String userAdresse;
	private String userCity;
	private String userCP;
	private String userEmail;
	private String passwordUser;
	private String userAnswer;
	
	/**
	 * Create the dialog.
	 */
	public RegisterView(JFrame owner, boolean modal) {
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(modal);
		this.owner = (LoginUI) owner;
		setBounds(100, 100, 350, 620);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		JLabel lblCreateAn = new JLabel("Create an account");
		lblCreateAn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblCreateAn, 10, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblCreateAn, 10, SpringLayout.WEST, contentPanel);
		contentPanel.add(lblCreateAn);
		
		JLabel lblName = new JLabel("Name");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblName, 32, SpringLayout.SOUTH, lblCreateAn);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblName, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblName);
		
		firstNameField = new JTextField();
		firstNameField.setToolTipText("First");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, firstNameField, 6, SpringLayout.SOUTH, lblName);
		sl_contentPanel.putConstraint(SpringLayout.WEST, firstNameField, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(firstNameField);
		firstNameField.setColumns(10);
		
		LastNameField = new JTextField();
		LastNameField.setToolTipText("Last");
		sl_contentPanel.putConstraint(SpringLayout.WEST, LastNameField, 6, SpringLayout.EAST, firstNameField);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, LastNameField, 0, SpringLayout.SOUTH, firstNameField);
		contentPanel.add(LastNameField);
		LastNameField.setColumns(10);
		
		JLabel lblUser = new JLabel("Email");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblUser, 6, SpringLayout.SOUTH, firstNameField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblUser, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblUser);
		
		mailField = new JTextField();
		mailField.setToolTipText("someone@example.com");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, mailField, 6, SpringLayout.SOUTH, lblUser);
		sl_contentPanel.putConstraint(SpringLayout.WEST, mailField, 9, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, mailField, 0, SpringLayout.EAST, LastNameField);
		contentPanel.add(mailField);
		mailField.setColumns(10);
		
		JLabel lblCreatePassword = new JLabel("Create password");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblCreatePassword, 6, SpringLayout.SOUTH, mailField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblCreatePassword, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblCreatePassword);
		
		passwordField = new JPasswordField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, lblCreatePassword);
		sl_contentPanel.putConstraint(SpringLayout.WEST, passwordField, -1, SpringLayout.WEST, lblCreateAn);
		sl_contentPanel.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, LastNameField);
		contentPanel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm password");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblConfirmPassword, 202, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblConfirmPassword, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblConfirmPassword);
		
		passwordConfirmField = new JPasswordField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, passwordConfirmField, 6, SpringLayout.SOUTH, lblConfirmPassword);
		sl_contentPanel.putConstraint(SpringLayout.WEST, passwordConfirmField, -1, SpringLayout.WEST, lblCreateAn);
		sl_contentPanel.putConstraint(SpringLayout.EAST, passwordConfirmField, 0, SpringLayout.EAST, LastNameField);
		contentPanel.add(passwordConfirmField);
		passwordConfirmField.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblAdress, 6, SpringLayout.SOUTH, passwordConfirmField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblAdress, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblAdress);
		
		adressField = new JTextArea();
		adressField.setBorder(UIManager.getBorder("TextField.border"));
		adressField.setToolTipText("N\u00B0, name of street");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, adressField, 6, SpringLayout.SOUTH, lblAdress);
		sl_contentPanel.putConstraint(SpringLayout.WEST, adressField, 9, SpringLayout.WEST, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.EAST, adressField, 0, SpringLayout.EAST, LastNameField);
		contentPanel.add(adressField);
		
		JLabel lblZipCode = new JLabel("ZIP code");
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, adressField, -6, SpringLayout.NORTH, lblZipCode);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblZipCode, 342, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblZipCode, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblZipCode);
		
		zipField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, zipField, 6, SpringLayout.SOUTH, lblZipCode);
		sl_contentPanel.putConstraint(SpringLayout.WEST, zipField, -1, SpringLayout.WEST, lblCreateAn);
		sl_contentPanel.putConstraint(SpringLayout.EAST, zipField, 0, SpringLayout.EAST, LastNameField);
		contentPanel.add(zipField);
		zipField.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblCity, 6, SpringLayout.SOUTH, zipField);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblCity, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblCity);
		
		cityField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.WEST, cityField, -1, SpringLayout.WEST, lblCreateAn);
		sl_contentPanel.putConstraint(SpringLayout.EAST, cityField, 0, SpringLayout.EAST, LastNameField);
		contentPanel.add(cityField);
		cityField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Secret question");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 434, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, cityField, -6, SpringLayout.NORTH, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblNewLabel);
		
		String[] questions = {"Place of birth of my mother", "Name of my favorite professor", "Name of my pet" };
		questionBox = new JComboBox(questions);
		sl_contentPanel.putConstraint(SpringLayout.NORTH, questionBox, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, questionBox, -1, SpringLayout.WEST, lblCreateAn);
		sl_contentPanel.putConstraint(SpringLayout.EAST, questionBox, 0, SpringLayout.EAST, LastNameField);
		contentPanel.add(questionBox);
		
		JLabel lblAnswerToThe = new JLabel("Answer to the question");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblAnswerToThe, 6, SpringLayout.SOUTH, questionBox);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblAnswerToThe, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblAnswerToThe);
		
		answerField = new JTextField();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, answerField, 6, SpringLayout.SOUTH, lblAnswerToThe);
		sl_contentPanel.putConstraint(SpringLayout.WEST, answerField, -1, SpringLayout.WEST, lblCreateAn);
		sl_contentPanel.putConstraint(SpringLayout.EAST, answerField, 0, SpringLayout.EAST, LastNameField);
		contentPanel.add(answerField);
		answerField.setColumns(10);
		
		JLabel lblAllFieldsAre = new JLabel("All fields are required");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, lblAllFieldsAre, 6, SpringLayout.SOUTH, lblCreateAn);
		sl_contentPanel.putConstraint(SpringLayout.WEST, lblAllFieldsAre, 0, SpringLayout.WEST, lblCreateAn);
		contentPanel.add(lblAllFieldsAre);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if(cmd.equals("OK")){
			if (verifyMandatoryFields()){
				this.owner.getUserFacade().signin(userLastName, userFirstName, userAdresse, userCity, userCP, userEmail, passwordUser, userAnswer, questionBox.getSelectedIndex());
				this.owner.setLabelMsg("Successfull registration, you can now login", Color.GREEN, true);
				dispose();
			}
		}
		else if(cmd.equals("Cancel")){
			dispose();
		}
	}
	
	public boolean isValidMail(String mail){
		boolean result = true;
		try {
		      InternetAddress emailAddr = new InternetAddress(mail);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
	}
	
	public boolean isValidZipCode(String zip){
		return zip.matches("[0-9]{5}");
	}
	
	public boolean isMatchPasswords(char[] pwd, char[] pwdConfirm){
		boolean result = false;
		String p1 = new String(pwd);
		String p2 = new String(pwdConfirm);
		if (!p1.equals("") && !p2.equals("")){
			if(p1.equals(p2))
				result = true;
		}
		return result;
	}
	
	public boolean isMailAvailable(String mail){
		return this.owner.getUserFacade().isMailAvailable(mail);
	}
	
	public boolean verifyMandatoryFields(){
		boolean result = true;
		
		if(firstNameField.getText().equals("")){
			firstNameField.setBackground(Color.RED);
			result = false;
		}
		else{
			firstNameField.setBackground(Color.WHITE);
			userFirstName=firstNameField.getText();
		}
		
		if(LastNameField.getText().equals("")){
			LastNameField.setBackground(Color.RED);
			result = false;
		}
		else{
			LastNameField.setBackground(Color.WHITE);
			userLastName=LastNameField.getText();
		}
		
		if(mailField.getText().equals("") || !isValidMail(mailField.getText()) || !isMailAvailable(mailField.getText())){
				mailField.setBackground(Color.RED);
				result = false;
		}
		else{
			mailField.setBackground(Color.WHITE);
			userEmail=mailField.getText();
		}
		
		if(!isMatchPasswords(passwordField.getPassword(),passwordConfirmField.getPassword())){
			passwordField.setBackground(Color.RED);
			passwordConfirmField.setBackground(Color.RED);
			result = false;
		}
		else{
			passwordField.setBackground(Color.WHITE);
			passwordConfirmField.setBackground(Color.WHITE);
			passwordUser = new String(passwordField.getPassword());
		}
				
		if(adressField.getText().equals("")){
			adressField.setBackground(Color.RED);
			result = false;
		}
		else{
			adressField.setBackground(Color.WHITE);
			userAdresse = adressField.getText().replace("'", "''");;
		}
		
		if(zipField.getText().equals("") || !isValidZipCode(zipField.getText())){
			zipField.setBackground(Color.RED);
			result = false;
		}
		else{
			zipField.setBackground(Color.WHITE);
			userCP=zipField.getText();
		}
		
		if(cityField.getText().equals("")){
			cityField.setBackground(Color.RED);
			result = false;
		}
		else{
			cityField.setBackground(Color.WHITE);
			userCity=cityField.getText();
		}
		
		if(answerField.getText().equals("")){
			answerField.setBackground(Color.RED);
			result = false;
		}
		else{
			answerField.setBackground(Color.WHITE);
			userAnswer=answerField.getText();
		}
		
		return result;
	}
}
