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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AccountView extends JPanel implements ActionListener {

	//Facade de la classe User
	private UserFacade userFacade;
	//type de persistance choisi
	private int persistType;
	
	private JPanel panelDroit;
	private JLabel firstnameLabel;
	private JLabel lastnameLabel;
	private JLabel adressLabel;
	private JLabel cpLabel;
	private JLabel cityLabel;
	private JLabel mailLabel;
	private JComboBox comboBoxRole;
	private JPanel panelButton;
	
	private ManageActView manageactivityPanel;
	private ManageRoomView roomPanel;

	
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
		
		JPanel panelGauche = new JPanel();
		add(panelGauche);
		SpringLayout sl_panelGauche = new SpringLayout();
		panelGauche.setLayout(sl_panelGauche);
		
		firstnameLabel = new JLabel("New label");
		sl_panelGauche.putConstraint(SpringLayout.WEST, firstnameLabel, 10, SpringLayout.WEST, panelGauche);
		panelGauche.add(firstnameLabel);
		
		lastnameLabel = new JLabel("New label");
		sl_panelGauche.putConstraint(SpringLayout.NORTH, lastnameLabel, 30, SpringLayout.NORTH, panelGauche);
		sl_panelGauche.putConstraint(SpringLayout.WEST, lastnameLabel, 135, SpringLayout.WEST, panelGauche);
		sl_panelGauche.putConstraint(SpringLayout.EAST, lastnameLabel, -156, SpringLayout.EAST, panelGauche);
		sl_panelGauche.putConstraint(SpringLayout.EAST, firstnameLabel, -6, SpringLayout.WEST, lastnameLabel);
		panelGauche.add(lastnameLabel);
		
		adressLabel = new JLabel("New label");
		sl_panelGauche.putConstraint(SpringLayout.NORTH, adressLabel, 6, SpringLayout.SOUTH, firstnameLabel);
		sl_panelGauche.putConstraint(SpringLayout.WEST, adressLabel, 10, SpringLayout.WEST, panelGauche);
		panelGauche.add(adressLabel);
		
		cpLabel = new JLabel("New label");
		sl_panelGauche.putConstraint(SpringLayout.NORTH, cpLabel, 6, SpringLayout.SOUTH, adressLabel);
		sl_panelGauche.putConstraint(SpringLayout.WEST, cpLabel, 10, SpringLayout.WEST, panelGauche);
		sl_panelGauche.putConstraint(SpringLayout.EAST, cpLabel, 0, SpringLayout.EAST, adressLabel);
		panelGauche.add(cpLabel);
		
		cityLabel = new JLabel("New label");
		sl_panelGauche.putConstraint(SpringLayout.NORTH, cityLabel, 6, SpringLayout.SOUTH, cpLabel);
		sl_panelGauche.putConstraint(SpringLayout.EAST, adressLabel, 0, SpringLayout.EAST, cityLabel);
		sl_panelGauche.putConstraint(SpringLayout.WEST, cityLabel, 10, SpringLayout.WEST, panelGauche);
		sl_panelGauche.putConstraint(SpringLayout.EAST, cityLabel, -156, SpringLayout.EAST, panelGauche);
		panelGauche.add(cityLabel);
		
		mailLabel = new JLabel("New label");
		sl_panelGauche.putConstraint(SpringLayout.NORTH, mailLabel, 6, SpringLayout.SOUTH, cityLabel);
		sl_panelGauche.putConstraint(SpringLayout.WEST, mailLabel, 10, SpringLayout.WEST, panelGauche);
		sl_panelGauche.putConstraint(SpringLayout.EAST, mailLabel, 0, SpringLayout.EAST, adressLabel);
		panelGauche.add(mailLabel);
		
		JLabel lblNewLabel = new JLabel("Personnal informations");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_panelGauche.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panelGauche);
		sl_panelGauche.putConstraint(SpringLayout.NORTH, firstnameLabel, 6, SpringLayout.SOUTH, lblNewLabel);
		sl_panelGauche.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panelGauche);
		panelGauche.add(lblNewLabel);
		
		JButton btnUpdateProfil = new JButton("Update profile");
		sl_panelGauche.putConstraint(SpringLayout.WEST, btnUpdateProfil, 0, SpringLayout.WEST, firstnameLabel);
		sl_panelGauche.putConstraint(SpringLayout.SOUTH, btnUpdateProfil, -10, SpringLayout.SOUTH, panelGauche);
		btnUpdateProfil.addActionListener(this);
		btnUpdateProfil.setActionCommand("Update");
		panelGauche.add(btnUpdateProfil);
		
		JButton btnChangePassword = new JButton("Change password");
		sl_panelGauche.putConstraint(SpringLayout.WEST, btnChangePassword, 0, SpringLayout.WEST, firstnameLabel);
		sl_panelGauche.putConstraint(SpringLayout.SOUTH, btnChangePassword, -6, SpringLayout.NORTH, btnUpdateProfil);
		panelGauche.add(btnChangePassword);
		
		JButton btnOrders = new JButton("My Orders");
		btnOrders.addActionListener(this);
		btnOrders.setActionCommand("orders");
		sl_panelGauche.putConstraint(SpringLayout.WEST, btnOrders, 0, SpringLayout.WEST, firstnameLabel);
		sl_panelGauche.putConstraint(SpringLayout.SOUTH, btnOrders, -6, SpringLayout.NORTH, btnChangePassword);
		panelGauche.add(btnOrders);
		
		panelDroit = new JPanel();
		panelDroit.setBackground(Color.WHITE);
		add(panelDroit);
		panelDroit.setLayout(new BorderLayout(0, 0));
		
		panelButton = new JPanel();
		panelButton.setBackground(Color.WHITE);
		panelDroit.add(panelButton, BorderLayout.CENTER);
		panelButton.setLayout(new GridLayout(4, 1));
		
		JComboBox comboBoxRole = new JComboBox();
		panelDroit.add(comboBoxRole, BorderLayout.NORTH);
		
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
		
		comboBoxRole = new JComboBox(roles);
		comboBoxRole.addActionListener(this);
		comboBoxRole.setToolTipText("Select your role");
		panelDroit.add(comboBoxRole, BorderLayout.NORTH);
		comboBoxRole.setSelectedIndex(0);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton){
			String cmd = e.getActionCommand();
			if(cmd.equals("manage activity")){
				ManageActView activityPanel = new ManageActView(persistType);
				MainView.changePanel(activityPanel);
			}
			else if(cmd.equals("orders")){
				OrderView orderPanel = new OrderView(persistType);
				MainView.changePanel(orderPanel);
			}
			else if(cmd.equals("inscriptions")){
				InscriptionView inscriptionPanel = new InscriptionView(persistType);
				MainView.changePanel(inscriptionPanel);
			}
			else if(cmd.equals("Manage Room")){
				ManageRoomView roomPanel = new ManageRoomView(persistType);
				MainView.changePanel(roomPanel);
			}
		}
		else if(e.getSource() instanceof JComboBox){
		
			JComboBox cb = (JComboBox) e.getSource();
		    String selectedRole = (String) cb.getSelectedItem();
		    switch (selectedRole) {
		        case "Administrator": 
		        	System.out.println("admin");
		        	panelButton.removeAll();
		        	panelButton.repaint();
		        	panelButton.revalidate();
		        	JButton btn1 = new JButton("Manage Category");
		        	JButton btn2 = new JButton("Manage Room");
		        	JButton btn3 = new JButton("Manage Users");
		        	panelButton.add(btn1);
		        	panelButton.add(btn2); 
		        	panelButton.add(btn3); 
		        	panelButton.repaint();
		        	panelButton.revalidate();
		        	btn2.addActionListener(this);
		        	btn2.setActionCommand("Manage Room");
		        	break;
		        case "Manager": 
		        	System.out.println("Manager");
		        	panelButton.removeAll();
		        	panelButton.repaint();
		        	panelButton.revalidate();
		        	JButton btnM1 = new JButton("Manage Participant");
		        	JButton btnM2 = new JButton("Manage Activity");
		        	JButton btnM3 = new JButton("Create Category Demand");
		        	panelButton.add(btnM1);
		        	panelButton.add(btnM2); 
		        	panelButton.add(btnM3); 
		        	panelButton.repaint();
		        	panelButton.revalidate();
		        	btnM2.addActionListener(this);
		        	btnM2.setActionCommand("manage activity");
	
		        	break;
		        case "Participant":
		        	System.out.println("Participant");
		        	panelButton.removeAll();
		        	panelButton.repaint();
		        	panelButton.revalidate();
		        	JButton btnE = new JButton("Create Event");
		        	JButton BtnE2 = new JButton("Manage Events");
		        	panelButton.add(btnE);
		        	panelButton.add(BtnE2);
		        	panelButton.repaint();
		        	panelButton.revalidate();
		        	break;
		        case "Member":
		        	System.out.println("Member");
		        	panelButton.removeAll();
		        	panelButton.repaint();
		        	panelButton.revalidate();
		        	JButton btnP = new JButton("Add a product");
		        	JButton btnP2 = new JButton("Manage inscription events");
		        	btnP2.addActionListener(this);
		        	btnP2.setActionCommand("inscriptions");
		        	panelButton.add(btnP);
		        	panelButton.add(btnP2);
		        	panelButton.repaint();
		        	panelButton.revalidate();
		        	break;
		    }
		}
	}
}
		        
