
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import core.Activity;
import core.ActivityFacade;
/**
 * @author Maite AINCIBURU
 */
@SuppressWarnings("serial")
public class UpdateActivityFormView extends JPanel implements ActionListener{
	
	private ActivityFacade activityFacade;
	//type de persistance choisi
		private int persistType;
		
		private String nameAct;
		private int idManager;  
		private String shortDescAct;  
		private String lgDescAct; 
		
		private JTextField textFieldShortDescription;
		private JTextField textFieldDetailedDescription;
		private JTextField textFieldActivityName;

		private Activity actchoisie; 
		JComboBox <ComboItem> comboBoxManager;
		private ComboItem comboitem; 

	/**
	 * Create the panel.
	 */
	public UpdateActivityFormView (int persistType, Activity actchoisie){
			this.persistType = persistType;
			this.actchoisie = actchoisie; 

			SpringLayout springLayout = new SpringLayout();
			setLayout(springLayout);
			
			JLabel lblActivityName = new JLabel("Activity Name:");
			add(lblActivityName);
			
			JButton buttonCancel = new JButton("Cancel");
			springLayout.putConstraint(SpringLayout.WEST, buttonCancel, 76, SpringLayout.WEST, this);
			add(buttonCancel);
			buttonCancel.addActionListener(this);
			buttonCancel.setActionCommand("Cancel");
			
			JButton buttonValid = new JButton("Valid");
			springLayout.putConstraint(SpringLayout.NORTH, buttonCancel, 0, SpringLayout.NORTH, buttonValid);
			springLayout.putConstraint(SpringLayout.EAST, buttonCancel, -90, SpringLayout.WEST, buttonValid);
			springLayout.putConstraint(SpringLayout.WEST, buttonValid, 299, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.SOUTH, buttonValid, -36, SpringLayout.SOUTH, this);
			springLayout.putConstraint(SpringLayout.EAST, buttonValid, 0, SpringLayout.EAST, this);
			add(buttonValid);
			buttonValid.addActionListener(this);
			buttonValid.setActionCommand("Valid");
			
			JLabel lblTitle = new JLabel("Fill activity informations");
			springLayout.putConstraint(SpringLayout.WEST, lblTitle, 23, SpringLayout.WEST, this);
			springLayout.putConstraint(SpringLayout.EAST, lblTitle, -479, SpringLayout.EAST, this);
			springLayout.putConstraint(SpringLayout.NORTH, lblActivityName, 42, SpringLayout.SOUTH, lblTitle);
			springLayout.putConstraint(SpringLayout.WEST, lblActivityName, 0, SpringLayout.WEST, lblTitle);
			springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 30, SpringLayout.NORTH, this);
			add(lblTitle);
			
			JLabel lblManager = new JLabel("Activity Manager");
			springLayout.putConstraint(SpringLayout.NORTH, lblManager, 26, SpringLayout.SOUTH, lblActivityName);
			springLayout.putConstraint(SpringLayout.WEST, lblManager, 0, SpringLayout.WEST, lblActivityName);
			add(lblManager);

			this.activityFacade = new ActivityFacade(this.persistType);	
			this.activityFacade.loadListActivities();
			ArrayList<String> listManager = this.activityFacade.loadManagers();

			comboBoxManager = new JComboBox<ComboItem>();
			Iterator<String> it =  listManager.iterator();
	
			while ( it.hasNext()) {
				String id = it.next().toString();
				String  label = it.next().toString();
				this.comboitem = new ComboItem(id, label);
				comboBoxManager.addItem(this.comboitem);
			}

			springLayout.putConstraint(SpringLayout.NORTH, comboBoxManager, 73, SpringLayout.SOUTH, lblTitle);
			springLayout.putConstraint(SpringLayout.WEST, comboBoxManager, 52, SpringLayout.EAST, lblManager);
			springLayout.putConstraint(SpringLayout.SOUTH, comboBoxManager, 102, SpringLayout.SOUTH, lblTitle);
			springLayout.putConstraint(SpringLayout.EAST, comboBoxManager, 228, SpringLayout.EAST, lblManager);
			add(comboBoxManager);
			
			JLabel lblShortDescription = new JLabel("Short Description");
			springLayout.putConstraint(SpringLayout.NORTH, lblShortDescription, 34, SpringLayout.SOUTH, lblManager);
			springLayout.putConstraint(SpringLayout.WEST, lblShortDescription, 0, SpringLayout.WEST, lblActivityName);
			add(lblShortDescription);
			
			textFieldShortDescription = new JTextField();
			springLayout.putConstraint(SpringLayout.NORTH, textFieldShortDescription, 32, SpringLayout.SOUTH, comboBoxManager);
			springLayout.putConstraint(SpringLayout.WEST, textFieldShortDescription, -134, SpringLayout.EAST, comboBoxManager);
			springLayout.putConstraint(SpringLayout.SOUTH, textFieldShortDescription, 61, SpringLayout.SOUTH, comboBoxManager);
			springLayout.putConstraint(SpringLayout.EAST, textFieldShortDescription, 0, SpringLayout.EAST, comboBoxManager);
			add(textFieldShortDescription);
			textFieldShortDescription.setColumns(10);
			textFieldShortDescription.setText(actchoisie.getActivityShortDescription()); 
			
			JLabel lblDetailedDescription = new JLabel("Detailed Description");
			springLayout.putConstraint(SpringLayout.NORTH, lblDetailedDescription, 54, SpringLayout.SOUTH, lblShortDescription);
			springLayout.putConstraint(SpringLayout.WEST, lblDetailedDescription, 0, SpringLayout.WEST, lblActivityName);
			add(lblDetailedDescription);
			
			textFieldDetailedDescription = new JTextField();
			springLayout.putConstraint(SpringLayout.NORTH, textFieldDetailedDescription, 41, SpringLayout.SOUTH, textFieldShortDescription);
			springLayout.putConstraint(SpringLayout.WEST, textFieldDetailedDescription, 28, SpringLayout.EAST, lblDetailedDescription);
			springLayout.putConstraint(SpringLayout.SOUTH, textFieldDetailedDescription, -6, SpringLayout.NORTH, buttonCancel);
			springLayout.putConstraint(SpringLayout.EAST, textFieldDetailedDescription, 562, SpringLayout.EAST, lblDetailedDescription);
			add(textFieldDetailedDescription);
			textFieldDetailedDescription.setColumns(10);
			textFieldDetailedDescription.setText(actchoisie.getActivityDetailedDescription()); 
			
			textFieldActivityName = new JTextField();
			springLayout.putConstraint(SpringLayout.NORTH, textFieldActivityName, -6, SpringLayout.NORTH, lblActivityName);
			springLayout.putConstraint(SpringLayout.WEST, textFieldActivityName, 70, SpringLayout.EAST, lblActivityName);
			add(textFieldActivityName);
			textFieldActivityName.setColumns(10); 
			textFieldActivityName.setText(actchoisie.getActivityName()); 
			

	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Cancel")){
			AccountView accountPanel = new AccountView(this.persistType);
			MainView.changePanel(accountPanel);
		
		}
		if(cmd.equals("Valid")){
			nameAct = textFieldActivityName.getText();
			comboitem = (ComboItem) comboBoxManager.getSelectedItem();  
			idManager = Integer.parseInt(comboitem.getValue()); 
			shortDescAct = textFieldShortDescription.getText(); 
			lgDescAct = textFieldDetailedDescription.getText(); 
			
			
			try {
				this.activityFacade.updateActivityFacade(actchoisie.getActivityId(), nameAct, idManager, shortDescAct, lgDescAct);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			AccountView accountPanel = new AccountView(this.persistType);
			MainView.changePanel(accountPanel);
			
			
			}

	}
}

