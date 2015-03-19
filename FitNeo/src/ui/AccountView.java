package ui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import core.UserFacade;
import java.awt.Font;

@SuppressWarnings("serial")
public class AccountView extends JPanel {

	//Facade de la classe User
	private UserFacade userFacade;
	//type de persistance choisi
	private int persistType;
	
	JPanel panel_1;
	private JLabel firstnameLabel;
	private JLabel lastnameLabel;
	private JLabel adressLabel;
	private JLabel cpLabel;
	private JLabel cityLabel;
	private JLabel mailLabel;
	private JComboBox<String> comboBoxRole;
	
	/**
	 * Create the panel.
	 */
	public AccountView(int persistType) {
		this.persistType = persistType;
		//On instancie une facadeUser pour la vue
		this.userFacade = new UserFacade(this.persistType);	
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		firstnameLabel = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.WEST, firstnameLabel, 10, SpringLayout.WEST, panel);
		panel.add(firstnameLabel);
		
		lastnameLabel = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, lastnameLabel, 30, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lastnameLabel, 135, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lastnameLabel, -156, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, firstnameLabel, -6, SpringLayout.WEST, lastnameLabel);
		panel.add(lastnameLabel);
		
		adressLabel = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, adressLabel, 6, SpringLayout.SOUTH, firstnameLabel);
		sl_panel.putConstraint(SpringLayout.WEST, adressLabel, 10, SpringLayout.WEST, panel);
		panel.add(adressLabel);
		
		cpLabel = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, cpLabel, 6, SpringLayout.SOUTH, adressLabel);
		sl_panel.putConstraint(SpringLayout.WEST, cpLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cpLabel, 0, SpringLayout.EAST, adressLabel);
		panel.add(cpLabel);
		
		cityLabel = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, cityLabel, 6, SpringLayout.SOUTH, cpLabel);
		sl_panel.putConstraint(SpringLayout.EAST, adressLabel, 0, SpringLayout.EAST, cityLabel);
		sl_panel.putConstraint(SpringLayout.WEST, cityLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cityLabel, -156, SpringLayout.EAST, panel);
		panel.add(cityLabel);
		
		mailLabel = new JLabel("New label");
		sl_panel.putConstraint(SpringLayout.NORTH, mailLabel, 6, SpringLayout.SOUTH, cityLabel);
		sl_panel.putConstraint(SpringLayout.WEST, mailLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, mailLabel, 0, SpringLayout.EAST, adressLabel);
		panel.add(mailLabel);
		
		JLabel lblNewLabel = new JLabel("Personnal informations");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, firstnameLabel, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		panel.add(lblNewLabel);
		
		JButton btnUpdateProfil = new JButton("Update profil");
		sl_panel.putConstraint(SpringLayout.WEST, btnUpdateProfil, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnUpdateProfil, -10, SpringLayout.SOUTH, panel);
		panel.add(btnUpdateProfil);
		
		JButton btnChangePassword = new JButton("Change password");
		sl_panel.putConstraint(SpringLayout.WEST, btnChangePassword, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnChangePassword, -6, SpringLayout.NORTH, btnUpdateProfil);
		panel.add(btnChangePassword);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		/*comboBoxRole = new JComboBox();
		comboBoxRole.setToolTipText("Select your role");
		panel_1.add(comboBoxRole, BorderLayout.NORTH);*/
		
		setInfosUser();
	}
	
	public void setInfosUser(){
		firstnameLabel.setText(userFacade.getUserFirstName());
		lastnameLabel.setText(userFacade.getUserLastName());
		adressLabel.setText(userFacade.getUserAdresse());
		cpLabel.setText(userFacade.getUserCP());
		cityLabel.setText(userFacade.getUserCity());
		mailLabel.setText(userFacade.getUserEmail());
		
		String[] roles = {"Simple user"};
		if(userFacade.isRoleAdmin())
			roles= new String[] {"Administrator", "Manager", "Participant", "Member"};
		else if(userFacade.isRoleManager())
			roles= new String[] {"Manager", "Participant", "Member"};
		else if(userFacade.isRoleParticipant())
			roles= new String[] {"Participant", "Member"};
		else if(userFacade.isRoleMember())
			roles= new String[] {"Member", "Simple user"};
		
		comboBoxRole = new JComboBox<String>(roles);
		comboBoxRole.setToolTipText("Select your role");
		panel_1.add(comboBoxRole, BorderLayout.NORTH);
	}
}
