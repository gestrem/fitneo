package ui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;


public class ActivityView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ActivityView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JTextArea textAreaActivityName = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textAreaActivityName, 30, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textAreaActivityName, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textAreaActivityName, 88, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textAreaActivityName, 260, SpringLayout.WEST, this);
		add(textAreaActivityName);
		
		JLabel activityDescriptionLabel = new JLabel("Detailled Description");
		springLayout.putConstraint(SpringLayout.NORTH, activityDescriptionLabel, 6, SpringLayout.SOUTH, textAreaActivityName);
		springLayout.putConstraint(SpringLayout.WEST, activityDescriptionLabel, 0, SpringLayout.WEST, textAreaActivityName);
		springLayout.putConstraint(SpringLayout.SOUTH, activityDescriptionLabel, 48, SpringLayout.SOUTH, textAreaActivityName);
		springLayout.putConstraint(SpringLayout.EAST, activityDescriptionLabel, 260, SpringLayout.WEST, this);
		activityDescriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		add(activityDescriptionLabel);
		
		JTextArea textAreaActivityDescription = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textAreaActivityDescription, 0, SpringLayout.SOUTH, activityDescriptionLabel);
		springLayout.putConstraint(SpringLayout.WEST, textAreaActivityDescription, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textAreaActivityDescription, -136, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textAreaActivityDescription, 764, SpringLayout.WEST, this);
		add(textAreaActivityDescription);
		
		JTextArea textAreaActivitySEvent = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textAreaActivitySEvent, 17, SpringLayout.SOUTH, textAreaActivityDescription);
		springLayout.putConstraint(SpringLayout.WEST, textAreaActivitySEvent, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textAreaActivitySEvent, 40, SpringLayout.SOUTH, textAreaActivityDescription);
		springLayout.putConstraint(SpringLayout.EAST, textAreaActivitySEvent, 534, SpringLayout.WEST, this);
		add(textAreaActivitySEvent);

	}

}
