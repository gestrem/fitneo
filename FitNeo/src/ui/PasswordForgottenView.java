package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

public class PasswordForgottenView extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();

	//JFrame a partir de laquelle on crée cette fenetre
	private LoginUI owner;
	private JLabel lblNewLabel;
	private JLabel lblYouCanUse;
	private JLabel lblEnterYouEmail;
	private JTextField mailField;
	private JLabel lblEnterYourEmail;
	private JLabel msglabel;
	private JLabel lblYourNewPassword;
	private JTextField newPasswordField;
	private JPanel panelPassword;

	/**
	 * Create the dialog.
	 */
	public PasswordForgottenView(JFrame owner, boolean modal) {
		setModal(modal);
		this.owner = (LoginUI) owner;
		setResizable(false);
		setBounds(100, 100, 316, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			lblNewLabel = new JLabel("Lost your password ?");
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -287, SpringLayout.SOUTH, contentPanel);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanel.add(lblNewLabel);
		}
		{
			lblYouCanUse = new JLabel("You can use this form to reinitialize your password.");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblYouCanUse, 6, SpringLayout.SOUTH, lblNewLabel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblYouCanUse, 0, SpringLayout.WEST, lblNewLabel);
			contentPanel.add(lblYouCanUse);
		}
		{
			lblEnterYouEmail = new JLabel("Enter you email adress below.");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblEnterYouEmail, 6, SpringLayout.SOUTH, lblYouCanUse);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblEnterYouEmail, 0, SpringLayout.WEST, lblNewLabel);
			contentPanel.add(lblEnterYouEmail);
		}
		{
			lblEnterYourEmail = new JLabel("Enter your email");
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblEnterYourEmail, 26, SpringLayout.SOUTH, lblEnterYouEmail);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblEnterYourEmail, 10, SpringLayout.WEST, contentPanel);
			contentPanel.add(lblEnterYourEmail);
		}
		{
			mailField = new JTextField();
			sl_contentPanel.putConstraint(SpringLayout.NORTH, mailField, -3, SpringLayout.NORTH, lblEnterYourEmail);
			sl_contentPanel.putConstraint(SpringLayout.WEST, mailField, 6, SpringLayout.EAST, lblEnterYourEmail);
			sl_contentPanel.putConstraint(SpringLayout.EAST, mailField, -15, SpringLayout.EAST, contentPanel);
			contentPanel.add(mailField);
			mailField.setColumns(10);
		}
		{
			msglabel = new JLabel("This email is invalid !");
			msglabel.setVisible(false);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, msglabel, 6, SpringLayout.SOUTH, mailField);
			sl_contentPanel.putConstraint(SpringLayout.WEST, msglabel, 0, SpringLayout.WEST, mailField);
			sl_contentPanel.putConstraint(SpringLayout.EAST, msglabel, -64, SpringLayout.EAST, contentPanel);
			msglabel.setForeground(Color.RED);
			contentPanel.add(msglabel);
		}
		{
			panelPassword = new JPanel();
			panelPassword.setVisible(false);
			sl_contentPanel.putConstraint(SpringLayout.WEST, panelPassword, 0, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, panelPassword, -10, SpringLayout.EAST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, panelPassword);
			sl_contentPanel.putConstraint(SpringLayout.NORTH, panelPassword, 16, SpringLayout.SOUTH, msglabel);
			sl_contentPanel.putConstraint(SpringLayout.SOUTH, panelPassword, -24, SpringLayout.SOUTH, contentPanel);
			panelPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelPassword.setBackground(Color.WHITE);
			contentPanel.add(panelPassword);
			SpringLayout sl_panelPassword = new SpringLayout();
			panelPassword.setLayout(sl_panelPassword);
			{
				lblYourNewPassword = new JLabel("Your new password is :");
				panelPassword.add(lblYourNewPassword);
			}
			{
				newPasswordField = new JTextField();
				sl_panelPassword.putConstraint(SpringLayout.NORTH, newPasswordField, 48, SpringLayout.NORTH, panelPassword);
				sl_panelPassword.putConstraint(SpringLayout.WEST, newPasswordField, 20, SpringLayout.WEST, panelPassword);
				sl_panelPassword.putConstraint(SpringLayout.EAST, newPasswordField, -22, SpringLayout.EAST, panelPassword);
				sl_panelPassword.putConstraint(SpringLayout.WEST, lblYourNewPassword, 0, SpringLayout.WEST, newPasswordField);
				sl_panelPassword.putConstraint(SpringLayout.SOUTH, lblYourNewPassword, -6, SpringLayout.NORTH, newPasswordField);
				panelPassword.add(newPasswordField);
				newPasswordField.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
			if(!mailField.getText().equals("") && !owner.getUserFacade().isMailAvailable(mailField.getText())){
				String newpass = owner.getUserFacade().reinitializePassword(mailField.getText());
				panelPassword.setVisible(true);
				newPasswordField.setText(newpass);
				msglabel.setVisible(false);
			}
			else{
				msglabel.setVisible(true);
			}
		}
		else if(cmd.equals("Cancel")){
			dispose();
		}
	}

}
