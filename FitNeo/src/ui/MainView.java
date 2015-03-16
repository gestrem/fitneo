package ui;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	/**
	 * Create the application.
	 */
	public MainView() {
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
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(panel);
		panel.setLayout(new SpringLayout());
		
		Button homeButton = new Button("Home");
		springLayout.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, homeButton);
		springLayout.putConstraint(SpringLayout.SOUTH, homeButton, -415, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, homeButton, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, homeButton, -613, SpringLayout.EAST, getContentPane());
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		getContentPane().add(homeButton);
		
		Button activityButton = new Button("Activities");
		springLayout.putConstraint(SpringLayout.WEST, activityButton, 6, SpringLayout.EAST, homeButton);
		springLayout.putConstraint(SpringLayout.SOUTH, activityButton, -6, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, activityButton, -412, SpringLayout.EAST, getContentPane());
		getContentPane().add(activityButton);
		
		Button eventButton = new Button("Events");
		springLayout.putConstraint(SpringLayout.WEST, eventButton, 6, SpringLayout.EAST, activityButton);
		springLayout.putConstraint(SpringLayout.SOUTH, eventButton, -6, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, eventButton, -211, SpringLayout.EAST, getContentPane());
		getContentPane().add(eventButton);
		
		Button productButton = new Button("Products");
		springLayout.putConstraint(SpringLayout.WEST, productButton, 6, SpringLayout.EAST, eventButton);
		springLayout.putConstraint(SpringLayout.SOUTH, productButton, -6, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, productButton, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(productButton);
		
		Button basketButton = new Button("Basket");
		springLayout.putConstraint(SpringLayout.NORTH, basketButton, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, basketButton, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(basketButton);
		
		Button accountButton = new Button("My account");
		springLayout.putConstraint(SpringLayout.NORTH, accountButton, 0, SpringLayout.NORTH, basketButton);
		springLayout.putConstraint(SpringLayout.EAST, accountButton, -6, SpringLayout.WEST, basketButton);
		getContentPane().add(accountButton);
		
		Button notifButton = new Button("Notifications");
		notifButton.setVisible(false);
		springLayout.putConstraint(SpringLayout.NORTH, notifButton, 0, SpringLayout.NORTH, basketButton);
		springLayout.putConstraint(SpringLayout.EAST, notifButton, -6, SpringLayout.WEST, accountButton);
		getContentPane().add(notifButton);
		
		JLabel lblLogoFitneo = new JLabel("Logo Fitneo");
		lblLogoFitneo.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.NORTH, lblLogoFitneo, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblLogoFitneo, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblLogoFitneo, 106, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblLogoFitneo, 138, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblLogoFitneo);
	}
}
