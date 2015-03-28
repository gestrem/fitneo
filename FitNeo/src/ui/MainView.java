package ui;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.ImageIcon;

import core.Notification;
import core.NotificationFacade;
import core.UserFacade;

@SuppressWarnings("serial")
public class MainView extends JFrame implements ActionListener {

	//Facade de la classe User
	private UserFacade userFacade;
	private NotificationFacade notifFacade;
	//type de persistance choisi
	private int persistType;
	
	private static JPanel panelDisplay;
	private SpringLayout springLayout;
	private HomeView homePanel;
	private AccountView accountPanel;
	private ActivityView activityPanel;
	private EventView eventPanel;
	private NotificationCenterView notifPanel;
	private Button notifButton;
	private int nbNotif;
	
	/**
	 * Create the application.
	 */
	public MainView(int persistType) {
		this.persistType = persistType;
		//On instancie une facadeUser pour la vue
		this.userFacade = new UserFacade(this.persistType);	
		this.notifFacade = new NotificationFacade(this.persistType);
		nbNotif=this.notifFacade.nbNewNotification(userFacade.getIdUser());	
		setTitle("FitNeo");
		setResizable(false);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		panelDisplay = new JPanel();
		homePanel = new HomeView();
		springLayout.putConstraint(SpringLayout.WEST, panelDisplay, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panelDisplay, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panelDisplay, -10, SpringLayout.EAST, getContentPane());
		panelDisplay.add(homePanel);
		getContentPane().add(panelDisplay);
		
		Button homeButton = new Button("Home");
		homeButton.addActionListener(this);
		homeButton.setActionCommand("Home");
		springLayout.putConstraint(SpringLayout.NORTH, panelDisplay, 6, SpringLayout.SOUTH, homeButton);
		springLayout.putConstraint(SpringLayout.SOUTH, homeButton, -415, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, homeButton, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, homeButton, -613, SpringLayout.EAST, getContentPane());
		getContentPane().add(homeButton);
		
		Button activityButton = new Button("Activities");
		activityButton.addActionListener(this);
		activityButton.setActionCommand("Activity");
		springLayout.putConstraint(SpringLayout.WEST, activityButton, 6, SpringLayout.EAST, homeButton);
		springLayout.putConstraint(SpringLayout.SOUTH, activityButton, -6, SpringLayout.NORTH, panelDisplay);
		springLayout.putConstraint(SpringLayout.EAST, activityButton, -412, SpringLayout.EAST, getContentPane());
		getContentPane().add(activityButton);
		
		Button eventButton = new Button("Events");
		eventButton.addActionListener(this);
		eventButton.setActionCommand("Event");
		springLayout.putConstraint(SpringLayout.WEST, eventButton, 6, SpringLayout.EAST, activityButton);
		springLayout.putConstraint(SpringLayout.SOUTH, eventButton, -6, SpringLayout.NORTH, panelDisplay);
		springLayout.putConstraint(SpringLayout.EAST, eventButton, -211, SpringLayout.EAST, getContentPane());
		getContentPane().add(eventButton);
		
		Button productButton = new Button("Products");
		springLayout.putConstraint(SpringLayout.WEST, productButton, 6, SpringLayout.EAST, eventButton);
		springLayout.putConstraint(SpringLayout.SOUTH, productButton, -6, SpringLayout.NORTH, panelDisplay);
		panelDisplay.setLayout(new CardLayout(0, 0));
		springLayout.putConstraint(SpringLayout.EAST, productButton, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(productButton);
		
		Button basketButton = new Button("Basket");
		springLayout.putConstraint(SpringLayout.NORTH, basketButton, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, basketButton, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(basketButton);
		
		Button accountButton = new Button("My account");
		accountButton.addActionListener(this);
		accountButton.setActionCommand("Account");
		springLayout.putConstraint(SpringLayout.NORTH, accountButton, 0, SpringLayout.NORTH, basketButton);
		springLayout.putConstraint(SpringLayout.EAST, accountButton, -6, SpringLayout.WEST, basketButton);
		getContentPane().add(accountButton);
		
		
		
		notifButton = new Button("Notifications : "+nbNotif);
		notifButton.addActionListener(this);
		notifButton.setActionCommand("Notif");
		springLayout.putConstraint(SpringLayout.NORTH, notifButton, 0, SpringLayout.NORTH, basketButton);
		springLayout.putConstraint(SpringLayout.EAST, notifButton, -6, SpringLayout.WEST, accountButton);
		getContentPane().add(notifButton);
		
		JLabel lblLogoFitneo = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblLogoFitneo, 0, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLogoFitneo, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLogoFitneo, -6, SpringLayout.NORTH, homeButton);
		springLayout.putConstraint(SpringLayout.EAST, lblLogoFitneo, -2, SpringLayout.EAST, homeButton);
		lblLogoFitneo.setIcon(new ImageIcon("./data/petitlogo.png"));
		lblLogoFitneo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblLogoFitneo);
	}
	
	public static void changePanel(JPanel panel){
		//remove ancient JPanel if exist
		panelDisplay.removeAll();
		panelDisplay.repaint();
		panelDisplay.revalidate();
		
		//add the new JPanel
		panelDisplay.add(panel);
		panelDisplay.repaint();
		panelDisplay.revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		nbNotif=this.notifFacade.nbNewNotification(userFacade.getIdUser());	
		if(cmd.equals("Home")){
			notifButton.setLabel("Notifications : "+nbNotif);
			changePanel(homePanel);
		}
		else if(cmd.equals("Account")){
			accountPanel = new AccountView(this.persistType);
			notifButton.setLabel("Notifications : "+nbNotif);
			changePanel(accountPanel);
		}
		else if(cmd.equals("Activity")){
			activityPanel = new ActivityView();
			notifButton.setLabel("Notifications : "+nbNotif);
			changePanel(activityPanel);
		}
		else if(cmd.equals("Event")){
			eventPanel = new EventView();
			notifButton.setLabel("Notifications : "+nbNotif);
			changePanel(eventPanel);
		}
		else if(cmd.equals("Notif")){
			notifPanel = new NotificationCenterView(this.persistType);
			notifButton.setLabel("Notifications : "+nbNotif);
			changePanel(notifPanel);
		}
	}
}
