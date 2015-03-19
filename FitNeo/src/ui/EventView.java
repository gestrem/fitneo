package ui;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;


public class EventView extends JPanel {

	/**
	 * Create the panel.
	 */
	public EventView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel dateOfEventLabel = new JLabel("Date Of Event");
		springLayout.putConstraint(SpringLayout.NORTH, dateOfEventLabel, 76, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, dateOfEventLabel, 10, SpringLayout.WEST, this);
		add(dateOfEventLabel);
		
		JLabel lblDescription = new JLabel("Description");
		springLayout.putConstraint(SpringLayout.WEST, lblDescription, 72, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblDescription, -225, SpringLayout.SOUTH, this);
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		add(lblDescription);
		
		JLabel priceLabel = new JLabel("Price");
		springLayout.putConstraint(SpringLayout.NORTH, priceLabel, 22, SpringLayout.SOUTH, dateOfEventLabel);
		springLayout.putConstraint(SpringLayout.WEST, priceLabel, 0, SpringLayout.WEST, dateOfEventLabel);
		add(priceLabel);
		
		JTextArea textAreaDescription = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textAreaDescription, 6, SpringLayout.SOUTH, lblDescription);
		springLayout.putConstraint(SpringLayout.WEST, textAreaDescription, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textAreaDescription, -63, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textAreaDescription, -10, SpringLayout.EAST, this);
		add(textAreaDescription);
		
		JTextArea textAreaPrice = new JTextArea();
		springLayout.putConstraint(SpringLayout.WEST, textAreaPrice, 80, SpringLayout.EAST, priceLabel);
		springLayout.putConstraint(SpringLayout.EAST, textAreaPrice, -512, SpringLayout.EAST, this);
		add(textAreaPrice);
		
		JTextArea textAreaDateOfEvent = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textAreaPrice, 22, SpringLayout.SOUTH, textAreaDateOfEvent);
		springLayout.putConstraint(SpringLayout.WEST, textAreaDateOfEvent, 25, SpringLayout.EAST, dateOfEventLabel);
		springLayout.putConstraint(SpringLayout.NORTH, textAreaDateOfEvent, 0, SpringLayout.NORTH, dateOfEventLabel);
		springLayout.putConstraint(SpringLayout.EAST, textAreaDateOfEvent, -512, SpringLayout.EAST, this);
		add(textAreaDateOfEvent);
		
		JButton btnRegisterEvent = new JButton("Register To This Event");
		springLayout.putConstraint(SpringLayout.WEST, btnRegisterEvent, 614, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnRegisterEvent, 0, SpringLayout.EAST, textAreaDescription);
		add(btnRegisterEvent);
		
		JButton btnBackActivity = new JButton("Back To The Activity");
		springLayout.putConstraint(SpringLayout.NORTH, btnRegisterEvent, -1, SpringLayout.NORTH, btnBackActivity);
		springLayout.putConstraint(SpringLayout.WEST, btnBackActivity, 0, SpringLayout.WEST, dateOfEventLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, btnBackActivity, -10, SpringLayout.SOUTH, this);
		add(btnBackActivity);
		
		JTextArea textAreaEventName = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textAreaEventName, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textAreaEventName, 0, SpringLayout.WEST, dateOfEventLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, textAreaEventName, -11, SpringLayout.NORTH, dateOfEventLabel);
		springLayout.putConstraint(SpringLayout.EAST, textAreaEventName, 259, SpringLayout.WEST, this);
		add(textAreaEventName);

	}
}
