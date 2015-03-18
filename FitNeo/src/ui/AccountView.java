package ui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;

public class AccountView extends JPanel {

	/**
	 * Create the panel.
	 */
	public AccountView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblFirstname = new JLabel("FirstName :");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstname, 156, SpringLayout.NORTH, this);
		lblFirstname.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.WEST, lblFirstname, 10, SpringLayout.WEST, this);
		add(lblFirstname);
		
		JTextArea taFirstname = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, taFirstname, 7, SpringLayout.NORTH, lblFirstname);
		add(taFirstname);
		
		JLabel lblLastname = new JLabel("Lastname:");
		springLayout.putConstraint(SpringLayout.WEST, lblLastname, 0, SpringLayout.WEST, this);
		lblLastname.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblLastname);
		
		JTextArea taLastName = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, taFirstname, 0, SpringLayout.WEST, taLastName);
		springLayout.putConstraint(SpringLayout.EAST, taFirstname, 0, SpringLayout.EAST, taLastName);
		springLayout.putConstraint(SpringLayout.NORTH, lblLastname, -7, SpringLayout.NORTH, taLastName);
		springLayout.putConstraint(SpringLayout.WEST, taLastName, 124, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, taLastName, -387, SpringLayout.EAST, this);
		add(taLastName);
		
		JLabel lblNewLabel = new JLabel("Adress:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 156, SpringLayout.NORTH, this);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblNewLabel);
		
		JTextArea taAdress = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, taAdress, 7, SpringLayout.NORTH, lblFirstname);
		springLayout.putConstraint(SpringLayout.WEST, taAdress, 546, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, taAdress, 23, SpringLayout.NORTH, lblFirstname);
		add(taAdress);
		
		JLabel lblCity = new JLabel("City :");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblCity);
		springLayout.putConstraint(SpringLayout.NORTH, lblCity, 0, SpringLayout.NORTH, lblLastname);
		lblCity.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblCity);
		
		JTextArea taCity = new JTextArea();
		springLayout.putConstraint(SpringLayout.EAST, taAdress, 0, SpringLayout.EAST, taCity);
		springLayout.putConstraint(SpringLayout.EAST, lblCity, -28, SpringLayout.WEST, taCity);
		springLayout.putConstraint(SpringLayout.SOUTH, taCity, 16, SpringLayout.NORTH, taLastName);
		springLayout.putConstraint(SpringLayout.EAST, taCity, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, taCity, 0, SpringLayout.NORTH, taLastName);
		add(taCity);
		
		JLabel lblZipcode = new JLabel("ZipCode :");
		lblZipcode.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblZipcode);
		
		JTextArea taZipcode = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, taZipcode, 18, SpringLayout.EAST, lblZipcode);
		springLayout.putConstraint(SpringLayout.EAST, taZipcode, -10, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, taCity, 0, SpringLayout.WEST, taZipcode);
		springLayout.putConstraint(SpringLayout.NORTH, taZipcode, 0, SpringLayout.NORTH, lblZipcode);
		add(taZipcode);
		
		JLabel lblEmail = new JLabel("email :");
		springLayout.putConstraint(SpringLayout.NORTH, lblZipcode, 7, SpringLayout.NORTH, lblEmail);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmail, -44, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblLastname);
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblEmail);
		
		JTextArea taEmail = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, lblZipcode, 37, SpringLayout.EAST, taEmail);
		springLayout.putConstraint(SpringLayout.SOUTH, taLastName, -72, SpringLayout.NORTH, taEmail);
		springLayout.putConstraint(SpringLayout.NORTH, taEmail, 7, SpringLayout.NORTH, lblEmail);
		springLayout.putConstraint(SpringLayout.WEST, taEmail, 0, SpringLayout.WEST, taLastName);
		springLayout.putConstraint(SpringLayout.EAST, taEmail, -396, SpringLayout.EAST, this);
		add(taEmail);
		
		JLabel lblYourProfile = new JLabel("Your profile");
		springLayout.putConstraint(SpringLayout.NORTH, lblYourProfile, 36, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblYourProfile, -325, SpringLayout.EAST, this);
		lblYourProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblYourProfile);

	}
}
