package ui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;

import core.Room;
import core.RoomFacade;
import core.UserFacade;

public class ManageRoomView extends JPanel {
	private JTextField tf_RoomArea1;
	private JTextField tf_NbMaxParticipants1;
	private RoomFacade roomFacade;
	private int persistType;
	private JTextField tf_roomArea2;
	private JTextField tf_maxNbParticipants2;


	/**
	 * Create the panel.
	 */
	public ManageRoomView(int persistType) {
		this.roomFacade = new RoomFacade(this.persistType);	

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Room Area:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 98, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 57, SpringLayout.WEST, this);
		add(lblNewLabel);
		
		tf_RoomArea1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_RoomArea1, -6, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, tf_RoomArea1, 6, SpringLayout.EAST, lblNewLabel);
		add(tf_RoomArea1);
		tf_RoomArea1.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		springLayout.putConstraint(SpringLayout.NORTH, lblType, 26, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.EAST, lblType, 0, SpringLayout.EAST, lblNewLabel);
		add(lblType);
		
		JLabel lblMaxnbparticipants = new JLabel("MaxNbParticipants:");
		add(lblMaxnbparticipants);
		
		tf_NbMaxParticipants1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblMaxnbparticipants, 6, SpringLayout.NORTH, tf_NbMaxParticipants1);
		springLayout.putConstraint(SpringLayout.EAST, lblMaxnbparticipants, -3, SpringLayout.WEST, tf_NbMaxParticipants1);
		springLayout.putConstraint(SpringLayout.WEST, tf_NbMaxParticipants1, 0, SpringLayout.WEST, tf_RoomArea1);
		add(tf_NbMaxParticipants1);
		tf_NbMaxParticipants1.setColumns(10);
		
		JButton buttonUpdateRoom = new JButton("Update room");
		springLayout.putConstraint(SpringLayout.WEST, buttonUpdateRoom, -300, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.EAST, buttonUpdateRoom, -59, SpringLayout.EAST, this);
		
		add(buttonUpdateRoom);
		
		JButton buttonCancel = new JButton("Delete Room");
		springLayout.putConstraint(SpringLayout.NORTH, buttonCancel, 6, SpringLayout.SOUTH, buttonUpdateRoom);
		springLayout.putConstraint(SpringLayout.WEST, buttonCancel, 526, SpringLayout.WEST, this);
		
		add(buttonCancel);
		
		JButton buttonValid = new JButton("Create Room");
		springLayout.putConstraint(SpringLayout.NORTH, buttonValid, 0, SpringLayout.NORTH, buttonUpdateRoom);
		springLayout.putConstraint(SpringLayout.WEST, buttonValid, 0, SpringLayout.WEST, tf_RoomArea1);
		springLayout.putConstraint(SpringLayout.EAST, buttonValid, -477, SpringLayout.EAST, buttonUpdateRoom);

		add(buttonValid);
		
		JLabel lblFillRoomInformations = new JLabel("Create a Room");
		springLayout.putConstraint(SpringLayout.NORTH, lblFillRoomInformations, 24, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblFillRoomInformations, 145, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFillRoomInformations, -14, SpringLayout.NORTH, tf_RoomArea1);
		springLayout.putConstraint(SpringLayout.EAST, lblFillRoomInformations, 386, SpringLayout.WEST, this);
		add(lblFillRoomInformations);
		
		String[] roomTypes={"Office","Class Room"};
		
		JComboBox cb_roomType1 = new JComboBox(roomTypes);
		springLayout.putConstraint(SpringLayout.NORTH, tf_NbMaxParticipants1, 23, SpringLayout.SOUTH, cb_roomType1);
		springLayout.putConstraint(SpringLayout.NORTH, cb_roomType1, 0, SpringLayout.NORTH, lblType);
		springLayout.putConstraint(SpringLayout.WEST, cb_roomType1, 0, SpringLayout.WEST, tf_RoomArea1);
		add(cb_roomType1);
		
		JLabel lblUpdateOrDelete = new JLabel("Update or Delete Room");
		springLayout.putConstraint(SpringLayout.EAST, buttonCancel, 0, SpringLayout.EAST, lblUpdateOrDelete);
		springLayout.putConstraint(SpringLayout.NORTH, lblUpdateOrDelete, 19, SpringLayout.NORTH, lblFillRoomInformations);
		add(lblUpdateOrDelete);
		
		JLabel label = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, label, 134, SpringLayout.EAST, tf_RoomArea1);
		springLayout.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, lblNewLabel);
		add(label);
		
		
		// on instance la liste de toutes les room disponibles
		roomFacade.createListRoomComboBox(0);
		// on la recupere
		ArrayList<Room> listRoom=roomFacade.getListRoom();
		String[] listRoomCombo=roomFacade.listRoomToArrayStringListRoom(listRoom);
		JComboBox cb_roomToUpdate = new JComboBox(listRoomCombo);
		springLayout.putConstraint(SpringLayout.NORTH, cb_roomToUpdate, 68, SpringLayout.NORTH, this);
		cb_roomToUpdate.setToolTipText("Room to update");
		springLayout.putConstraint(SpringLayout.WEST, cb_roomToUpdate, 158, SpringLayout.EAST, lblFillRoomInformations);
		add(cb_roomToUpdate);
		
		JLabel label_1 = new JLabel("Room Area:");
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 0, SpringLayout.NORTH, lblNewLabel);
		add(label_1);
		
		JLabel label_2 = new JLabel("Type:");
		springLayout.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, lblType);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 193, SpringLayout.EAST, cb_roomType1);
		add(label_2);
		
		JLabel label_3 = new JLabel("MaxNbParticipants:");
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 0, SpringLayout.NORTH, lblMaxnbparticipants);
		springLayout.putConstraint(SpringLayout.WEST, label_3, 112, SpringLayout.EAST, tf_NbMaxParticipants1);
		add(label_3);
		
		tf_roomArea2 = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, lblUpdateOrDelete, 0, SpringLayout.EAST, tf_roomArea2);
		springLayout.putConstraint(SpringLayout.WEST, tf_roomArea2, 503, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, label_1, -15, SpringLayout.WEST, tf_roomArea2);
		springLayout.putConstraint(SpringLayout.NORTH, tf_roomArea2, 0, SpringLayout.NORTH, lblNewLabel);
		add(tf_roomArea2);
		tf_roomArea2.setColumns(10);
		
		JComboBox cb_roomType2 = new JComboBox(roomTypes);
		springLayout.putConstraint(SpringLayout.NORTH, cb_roomType2, -4, SpringLayout.NORTH, lblType);
		springLayout.putConstraint(SpringLayout.WEST, cb_roomType2, 6, SpringLayout.EAST, label_2);
		add(cb_roomType2);
		
		tf_maxNbParticipants2 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, buttonUpdateRoom, 13, SpringLayout.SOUTH, tf_maxNbParticipants2);
		springLayout.putConstraint(SpringLayout.NORTH, tf_maxNbParticipants2, 0, SpringLayout.NORTH, tf_NbMaxParticipants1);
		springLayout.putConstraint(SpringLayout.WEST, tf_maxNbParticipants2, 0, SpringLayout.EAST, label_3);
		add(tf_maxNbParticipants2);
		tf_maxNbParticipants2.setColumns(10);

		
		// *********** Create Room Button *******************
		
		buttonValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// on recupere les données sur formulaire
				if (!(tf_RoomArea1.getText().equals("") )|| (!tf_NbMaxParticipants1.getText().equals(""))){
					String roomName=tf_RoomArea1.getText();
					int capacity= Integer.parseInt(tf_NbMaxParticipants1.getText());
					String roomType=(String) cb_roomType1.getSelectedItem();
					roomFacade.createRoom(roomName, roomType, capacity);
					System.out.println("Room "+ roomName +" créé");
					roomFacade.addRoomToListRoom(listRoom, roomName, roomType, capacity);
					cb_roomToUpdate.removeAllItems();
		    		String[] newListRoom=roomFacade.listRoomToArrayStringListRoom(listRoom);
		    		
		    		DefaultComboBoxModel newComboRoom = new DefaultComboBoxModel(newListRoom);
		    		cb_roomToUpdate.setModel( newComboRoom );
		    		JOptionPane.showMessageDialog(null,roomName+" a été créée");
					
					
				}
			}
		});
	// *** Mise à jour infos textField et ComboBox to update ***********
		
	cb_roomToUpdate.addActionListener (new ActionListener () {
	    public void actionPerformed(ActionEvent e) {
	    	if (cb_roomToUpdate.getSelectedIndex()==-1){
	    		// rien faire
	    	}
	    	else{
	    		String roomToUpdateName=(String) cb_roomToUpdate.getSelectedItem();
	    		Room roomToUpdate= roomFacade.getRoom(roomToUpdateName);
	    		tf_roomArea2.setText("");
	    		tf_maxNbParticipants2.setText("");
	    		tf_roomArea2.setText(roomToUpdate.getRoomArea());
	    		tf_maxNbParticipants2.setText(Integer.toString(roomToUpdate.getCapacity()));
	    		cb_roomType2.setSelectedItem(roomToUpdate.getRoomType());
	    		
	    		
	    	}
	    }
	});
	// *************** MISE A JOUR DE LA ROOM **************
	buttonUpdateRoom.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String roomToUpdateNameOld=(String) cb_roomToUpdate.getSelectedItem();
    		String roomArea=tf_roomArea2.getText();
    		int capacity=Integer.parseInt(tf_maxNbParticipants2.getText());
    		String roomType=(String) cb_roomType2.getSelectedItem();
    		roomFacade.updateRoom(roomToUpdateNameOld, roomArea, roomType, capacity);
    		int index=roomFacade.getIndexRoomUpdated(listRoom,roomToUpdateNameOld);
    		System.out.println("index "+index);
    		roomFacade.updateRoomListRoom(listRoom, index, roomArea, roomType, capacity);
    		cb_roomToUpdate.removeAllItems();
    		String[] newListRoom=roomFacade.listRoomToArrayStringListRoom(listRoom);
    		
    		DefaultComboBoxModel newComboRoom = new DefaultComboBoxModel(newListRoom);
    		cb_roomToUpdate.setModel( newComboRoom );
    		JOptionPane.showMessageDialog(null,roomToUpdateNameOld+" a été modifiée");

		}
		
	});
	// *****  DELETE ROOM
	buttonCancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String roomToUpdateNameOld=(String) cb_roomToUpdate.getSelectedItem();
    		
    		
    		roomFacade.deleteRoomJDBC(roomToUpdateNameOld);
    		int index=roomFacade.getIndexRoomUpdated(listRoom,roomToUpdateNameOld);
    		System.out.println("index "+index);
    		roomFacade.deleteRoomListRoom(listRoom, index);
    		cb_roomToUpdate.removeAllItems();
    		String[] newListRoom=roomFacade.listRoomToArrayStringListRoom(listRoom);
    		
    		DefaultComboBoxModel newComboRoom = new DefaultComboBoxModel(newListRoom);
    		cb_roomToUpdate.setModel( newComboRoom );
    		JOptionPane.showMessageDialog(null,roomToUpdateNameOld+" a été supprimée");
		}
	});
}
}
