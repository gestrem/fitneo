package ui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
/**
 * 
 * @author Florent
 *
 */
@SuppressWarnings("serial")
public class ProfilFormView extends JPanel {
	private JTextField tf_FirstName;
	private JTextField tf_LastName;
	private JTextField tf_adress;
	private JTextField tf_ZipCode;
	private JTextField tf_Country;
	private JTextField tf_Number;
	private JTextField tf_Email;

	/**
	 * Create the panel.
	 */
	public ProfilFormView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JButton buttonUpdate = new JButton("update profile");
		springLayout.putConstraint(SpringLayout.WEST, buttonUpdate, 402, SpringLayout.WEST, this);
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(buttonUpdate);
		
		JButton buttonCancel = new JButton("cancel");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancel, 0, SpringLayout.NORTH, buttonUpdate);
		add(buttonCancel);
		
		tf_FirstName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_FirstName, 61, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tf_FirstName, 104, SpringLayout.WEST, this);
		add(tf_FirstName);
		tf_FirstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblFirstName, 6, SpringLayout.NORTH, tf_FirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, -84, SpringLayout.WEST, tf_FirstName);
		springLayout.putConstraint(SpringLayout.EAST, lblFirstName, -12, SpringLayout.WEST, tf_FirstName);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		springLayout.putConstraint(SpringLayout.EAST, lblLastName, 0, SpringLayout.EAST, lblFirstName);
		add(lblLastName);
		
		tf_LastName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblLastName, 6, SpringLayout.NORTH, tf_LastName);
		springLayout.putConstraint(SpringLayout.NORTH, tf_LastName, 9, SpringLayout.SOUTH, tf_FirstName);
		springLayout.putConstraint(SpringLayout.WEST, tf_LastName, 0, SpringLayout.WEST, tf_FirstName);
		add(tf_LastName);
		tf_LastName.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress:");
		springLayout.putConstraint(SpringLayout.NORTH, lblAdress, 59, SpringLayout.SOUTH, lblLastName);
		springLayout.putConstraint(SpringLayout.EAST, lblAdress, 0, SpringLayout.EAST, lblFirstName);
		add(lblAdress);
		
		tf_adress = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_adress, 0, SpringLayout.NORTH, lblAdress);
		springLayout.putConstraint(SpringLayout.WEST, tf_adress, 0, SpringLayout.WEST, tf_FirstName);
		add(tf_adress);
		tf_adress.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code:");
		springLayout.putConstraint(SpringLayout.EAST, lblZipCode, 0, SpringLayout.EAST, lblFirstName);
		add(lblZipCode);
		
		tf_ZipCode = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, tf_adress, -18, SpringLayout.NORTH, tf_ZipCode);
		springLayout.putConstraint(SpringLayout.NORTH, lblZipCode, 6, SpringLayout.NORTH, tf_ZipCode);
		springLayout.putConstraint(SpringLayout.WEST, tf_ZipCode, 0, SpringLayout.WEST, tf_FirstName);
		add(tf_ZipCode);
		tf_ZipCode.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country:");
		springLayout.putConstraint(SpringLayout.SOUTH, lblCountry, -71, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblCountry, 0, SpringLayout.EAST, lblFirstName);
		add(lblCountry);
		
		tf_Country = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, tf_ZipCode, -18, SpringLayout.NORTH, tf_Country);
		springLayout.putConstraint(SpringLayout.NORTH, tf_Country, -6, SpringLayout.NORTH, lblCountry);
		springLayout.putConstraint(SpringLayout.EAST, tf_Country, 0, SpringLayout.EAST, tf_FirstName);
		add(tf_Country);
		tf_Country.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNumber, 6, SpringLayout.NORTH, tf_FirstName);
		springLayout.putConstraint(SpringLayout.WEST, lblNumber, 29, SpringLayout.EAST, tf_FirstName);
		add(lblNumber);
		
		tf_Number = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, tf_Number, 6, SpringLayout.EAST, lblNumber);
		add(tf_Number);
		tf_Number.setColumns(10);
		
		tf_Email = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_Email, 98, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, tf_Number, -9, SpringLayout.NORTH, tf_Email);
		springLayout.putConstraint(SpringLayout.EAST, tf_Number, 0, SpringLayout.EAST, tf_Email);
		add(tf_Email);
		tf_Email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		springLayout.putConstraint(SpringLayout.WEST, tf_Email, 6, SpringLayout.EAST, lblEmail);
		springLayout.putConstraint(SpringLayout.EAST, tf_Email, 166, SpringLayout.EAST, lblEmail);
		springLayout.putConstraint(SpringLayout.SOUTH, lblEmail, 0, SpringLayout.SOUTH, lblLastName);
		springLayout.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblNumber);
		add(lblEmail);
		
		JButton buttonChangePwd = new JButton("Change your password");
		springLayout.putConstraint(SpringLayout.SOUTH, buttonChangePwd, -98, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonChangePwd, -240, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, buttonUpdate, 6, SpringLayout.SOUTH, buttonChangePwd);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancel, 0, SpringLayout.WEST, buttonChangePwd);
		springLayout.putConstraint(SpringLayout.WEST, buttonChangePwd, 77, SpringLayout.EAST, tf_adress);
		buttonChangePwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(buttonChangePwd);
		
		JLabel lblNewLabel = new JLabel("To update your profile,");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 172, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNumber);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("fill fields you need");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 2, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 181, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNumber);
		add(lblNewLabel_1);

	}
}
