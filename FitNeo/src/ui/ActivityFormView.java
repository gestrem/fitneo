package ui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextArea;

public class ActivityFormView extends JPanel {
	private JTextField tf_ShortDesc;

	//type de persistance choisi
		private int persistType;
		private JTextField textFieldActivityName;
	/**
	 * Create the panel.
	 */
	public ActivityFormView(int persistType) {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblActivityName = new JLabel("Activity Name:");
		springLayout.putConstraint(SpringLayout.WEST, lblActivityName, 21, SpringLayout.WEST, this);
		add(lblActivityName);
		
		JLabel lblShortDescription = new JLabel("Short Description:");
		springLayout.putConstraint(SpringLayout.WEST, lblShortDescription, 0, SpringLayout.WEST, lblActivityName);
		add(lblShortDescription);
		
		tf_ShortDesc = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_ShortDesc, -6, SpringLayout.NORTH, lblShortDescription);
		springLayout.putConstraint(SpringLayout.WEST, tf_ShortDesc, 42, SpringLayout.EAST, lblShortDescription);
		springLayout.putConstraint(SpringLayout.EAST, tf_ShortDesc, -90, SpringLayout.EAST, this);
		add(tf_ShortDesc);
		tf_ShortDesc.setColumns(10);
		
		JLabel lblActivityManager = new JLabel("Activity Manager:");
		springLayout.putConstraint(SpringLayout.NORTH, lblShortDescription, 22, SpringLayout.SOUTH, lblActivityManager);
		springLayout.putConstraint(SpringLayout.NORTH, lblActivityManager, 23, SpringLayout.SOUTH, lblActivityName);
		springLayout.putConstraint(SpringLayout.WEST, lblActivityManager, 0, SpringLayout.WEST, lblActivityName);
		add(lblActivityManager);
		
		JLabel lblDetailedDescription = new JLabel("Detailed Description:");
		springLayout.putConstraint(SpringLayout.NORTH, lblDetailedDescription, 21, SpringLayout.SOUTH, lblShortDescription);
		springLayout.putConstraint(SpringLayout.WEST, lblDetailedDescription, 0, SpringLayout.WEST, lblActivityName);
		add(lblDetailedDescription);
		
		JButton buttonCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.WEST, buttonCancel, 85, SpringLayout.WEST, this);
		add(buttonCancel);
		
		JButton buttonValid = new JButton("Valid");
		springLayout.putConstraint(SpringLayout.WEST, buttonValid, 224, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancel, -6, SpringLayout.WEST, buttonValid);
		springLayout.putConstraint(SpringLayout.EAST, buttonValid, -75, SpringLayout.EAST, this);
		add(buttonValid);
		
		textFieldActivityName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldActivityName, 65, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblActivityName, 6, SpringLayout.NORTH, textFieldActivityName);
		springLayout.putConstraint(SpringLayout.EAST, textFieldActivityName, -139, SpringLayout.EAST, this);
		add(textFieldActivityName);
		textFieldActivityName.setColumns(10);
		
		JTextArea textAreaDetailedDescription = new JTextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, textAreaDetailedDescription, -60, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, buttonValid, 44, SpringLayout.SOUTH, textAreaDetailedDescription);
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancel, 44, SpringLayout.SOUTH, textAreaDetailedDescription);
		springLayout.putConstraint(SpringLayout.NORTH, textAreaDetailedDescription, 15, SpringLayout.SOUTH, tf_ShortDesc);
		springLayout.putConstraint(SpringLayout.WEST, textAreaDetailedDescription, 38, SpringLayout.EAST, lblDetailedDescription);
		springLayout.putConstraint(SpringLayout.EAST, textAreaDetailedDescription, -144, SpringLayout.EAST, this);
		add(textAreaDetailedDescription);
		
		JLabel lblFillInformation = new JLabel("Fill Informations");
		springLayout.putConstraint(SpringLayout.NORTH, lblFillInformation, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblFillInformation, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFillInformation, -39, SpringLayout.NORTH, textFieldActivityName);
		springLayout.putConstraint(SpringLayout.EAST, lblFillInformation, 207, SpringLayout.WEST, this);
		add(lblFillInformation);

	}
}
