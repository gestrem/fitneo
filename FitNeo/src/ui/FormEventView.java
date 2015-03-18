package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JScrollBar;

public class FormEventView extends JPanel {

	/**
	 * Create the panel.
	 */
	public FormEventView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Event Name :");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 77, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, this);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblNewLabel);
		
		JLabel lblCreateAnEvent = new JLabel("Create an Event");
		springLayout.putConstraint(SpringLayout.NORTH, lblCreateAnEvent, 5, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCreateAnEvent, 372, SpringLayout.WEST, this);
		lblCreateAnEvent.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblCreateAnEvent);
		
		JLabel lblShortDescription = new JLabel("Short Description :");
		lblShortDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblShortDescription, 111, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblShortDescription, 0, SpringLayout.WEST, lblNewLabel);
		add(lblShortDescription);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		springLayout.putConstraint(SpringLayout.NORTH, lblPrice, 43, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblPrice, 0, SpringLayout.WEST, lblNewLabel);
		add(lblPrice);
		
		JScrollBar scrollBar = new JScrollBar();
		springLayout.putConstraint(SpringLayout.WEST, scrollBar, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollBar, -25, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, scrollBar, 0, SpringLayout.EAST, lblNewLabel);
		add(scrollBar);

	}
}
