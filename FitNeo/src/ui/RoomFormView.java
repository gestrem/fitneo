package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomFormView extends JPanel {
	private JTextField tf_RoomArea;
	private JTextField tf_NbMaxParticipants;

	/**
	 * Create the panel.
	 */
	public RoomFormView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Room Area:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 98, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 57, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		tf_RoomArea = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_RoomArea, -6, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, tf_RoomArea, 6, SpringLayout.EAST, lblNewLabel);
		add(tf_RoomArea);
		tf_RoomArea.setColumns(10);
		
		JToggleButton buttonToggleOffice = new JToggleButton("Office");
		springLayout.putConstraint(SpringLayout.WEST, buttonToggleOffice, 0, SpringLayout.WEST, tf_RoomArea);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonToggleOffice, -230, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonToggleOffice, 0, SpringLayout.EAST, tf_RoomArea);
		add(buttonToggleOffice);
		
		JToggleButton tglbtnClassroom = new JToggleButton("Classroom");
		springLayout.putConstraint(SpringLayout.NORTH, tglbtnClassroom, 6, SpringLayout.SOUTH, buttonToggleOffice);
		springLayout.putConstraint(SpringLayout.WEST, tglbtnClassroom, 0, SpringLayout.WEST, tf_RoomArea);
		springLayout.putConstraint(SpringLayout.EAST, tglbtnClassroom, 0, SpringLayout.EAST, tf_RoomArea);
		add(tglbtnClassroom);
		
		JLabel lblType = new JLabel("Type:");
		springLayout.putConstraint(SpringLayout.NORTH, lblType, 26, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblType, 0, SpringLayout.EAST, lblNewLabel);
		add(lblType);
		
		JLabel lblMaxnbparticipants = new JLabel("MaxNbParticipants:");
		springLayout.putConstraint(SpringLayout.NORTH, lblMaxnbparticipants, 75, SpringLayout.SOUTH, lblType);
		springLayout.putConstraint(SpringLayout.EAST, lblMaxnbparticipants, 0, SpringLayout.EAST, lblNewLabel);
		add(lblMaxnbparticipants);
		
		tf_NbMaxParticipants = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_NbMaxParticipants, -6, SpringLayout.NORTH, lblMaxnbparticipants);
		springLayout.putConstraint(SpringLayout.WEST, tf_NbMaxParticipants, 0, SpringLayout.WEST, tf_RoomArea);
		add(tf_NbMaxParticipants);
		tf_NbMaxParticipants.setColumns(10);
		
		JButton buttonAccesoryAdding = new JButton("Add Accessories");
		springLayout.putConstraint(SpringLayout.WEST, buttonAccesoryAdding, -300, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonAccesoryAdding, -59, SpringLayout.EAST, this);
		buttonAccesoryAdding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(buttonAccesoryAdding);
		
		JButton buttonCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancel, 298, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonAccesoryAdding, -38, SpringLayout.NORTH, buttonCancel);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancel, 474, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonCancel, -189, SpringLayout.EAST, this);
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(buttonCancel);
		
		JButton buttonValid = new JButton("Valid");
		springLayout.putConstraint(SpringLayout.NORTH, buttonValid, 38, SpringLayout.SOUTH, buttonAccesoryAdding);
		springLayout.putConstraint(SpringLayout.WEST, buttonValid, 6, SpringLayout.EAST, buttonCancel);
		springLayout.putConstraint(SpringLayout.EAST, buttonValid, 0, SpringLayout.EAST, buttonAccesoryAdding);
		add(buttonValid);
		
		JLabel lblFillRoomInformations = new JLabel("Fill room informations");
		springLayout.putConstraint(SpringLayout.NORTH, lblFillRoomInformations, -73, SpringLayout.NORTH, tf_RoomArea);
		springLayout.putConstraint(SpringLayout.WEST, lblFillRoomInformations, 204, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFillRoomInformations, -19, SpringLayout.NORTH, tf_RoomArea);
		springLayout.putConstraint(SpringLayout.EAST, lblFillRoomInformations, 445, SpringLayout.WEST, this);
		add(lblFillRoomInformations);

	}
}
