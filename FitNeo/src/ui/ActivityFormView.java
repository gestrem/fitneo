package ui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;

public class ActivityFormView extends JPanel {
	private JTextField tf_ActivityName;
	private JTextField tf_ShortDesc;
	private JTextField tf_ActivityManager;
	private JTextField tf_DetailedDesc;

	//type de persistance choisi
		private int persistType;
	/**
	 * Create the panel.
	 */
	public ActivityFormView(int persistType) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblActivityName = new JLabel("Activity Name:");
		springLayout.putConstraint(SpringLayout.NORTH, lblActivityName, 107, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblActivityName, 63, SpringLayout.WEST, this);
		add(lblActivityName);
		
		tf_ActivityName = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, tf_ActivityName, 6, SpringLayout.EAST, lblActivityName);
		springLayout.putConstraint(SpringLayout.EAST, tf_ActivityName, -430, SpringLayout.EAST, this);
		add(tf_ActivityName);
		tf_ActivityName.setColumns(10);
		
		JLabel lblShortDescription = new JLabel("Short Description:");
		springLayout.putConstraint(SpringLayout.NORTH, lblShortDescription, 31, SpringLayout.SOUTH, lblActivityName);
		springLayout.putConstraint(SpringLayout.EAST, lblShortDescription, 0, SpringLayout.EAST, lblActivityName);
		add(lblShortDescription);
		
		tf_ShortDesc = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, tf_ActivityName, -19, SpringLayout.NORTH, tf_ShortDesc);
		springLayout.putConstraint(SpringLayout.NORTH, tf_ShortDesc, -6, SpringLayout.NORTH, lblShortDescription);
		springLayout.putConstraint(SpringLayout.WEST, tf_ShortDesc, 0, SpringLayout.WEST, tf_ActivityName);
		springLayout.putConstraint(SpringLayout.EAST, tf_ShortDesc, 189, SpringLayout.EAST, lblShortDescription);
		add(tf_ShortDesc);
		tf_ShortDesc.setColumns(10);
		
		JLabel lblActivityManager = new JLabel("Activity Manager:");
		springLayout.putConstraint(SpringLayout.NORTH, lblActivityManager, 38, SpringLayout.SOUTH, lblShortDescription);
		springLayout.putConstraint(SpringLayout.EAST, lblActivityManager, 0, SpringLayout.EAST, lblActivityName);
		add(lblActivityManager);
		
		tf_ActivityManager = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_ActivityManager, -6, SpringLayout.NORTH, lblActivityManager);
		springLayout.putConstraint(SpringLayout.WEST, tf_ActivityManager, 0, SpringLayout.WEST, tf_ActivityName);
		springLayout.putConstraint(SpringLayout.EAST, tf_ActivityManager, 0, SpringLayout.EAST, tf_ActivityName);
		add(tf_ActivityManager);
		tf_ActivityManager.setColumns(10);
		
		JLabel lblDetailedDescription = new JLabel("Detailed Description:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDetailedDescription, 0, SpringLayout.NORTH, lblActivityName);
		springLayout.putConstraint(SpringLayout.WEST, lblDetailedDescription, 65, SpringLayout.EAST, tf_ActivityName);
		add(lblDetailedDescription);
		
		tf_DetailedDesc = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_DetailedDesc, 6, SpringLayout.SOUTH, lblDetailedDescription);
		springLayout.putConstraint(SpringLayout.WEST, tf_DetailedDesc, 65, SpringLayout.EAST, tf_ShortDesc);
		springLayout.putConstraint(SpringLayout.SOUTH, tf_DetailedDesc, 0, SpringLayout.SOUTH, tf_ActivityManager);
		springLayout.putConstraint(SpringLayout.EAST, tf_DetailedDesc, -87, SpringLayout.EAST, this);
		add(tf_DetailedDesc);
		tf_DetailedDesc.setColumns(10);
		
		JButton buttonCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancel, 54, SpringLayout.SOUTH, tf_DetailedDesc);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancel, 0, SpringLayout.WEST, lblDetailedDescription);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancel, 0, SpringLayout.EAST, lblDetailedDescription);
		add(buttonCancel);
		
		JButton buttonValid = new JButton("Valid");
		springLayout.putConstraint(SpringLayout.NORTH, buttonValid, 54, SpringLayout.SOUTH, tf_DetailedDesc);
		springLayout.putConstraint(SpringLayout.WEST, buttonValid, 6, SpringLayout.EAST, buttonCancel);
		springLayout.putConstraint(SpringLayout.EAST, buttonValid, -75, SpringLayout.EAST, this);
		add(buttonValid);
		
		JLabel lblNewLabel = new JLabel("Fill activity informations");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 272, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -42, SpringLayout.NORTH, tf_ActivityName);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -230, SpringLayout.EAST, this);
		add(lblNewLabel);

	}
}
