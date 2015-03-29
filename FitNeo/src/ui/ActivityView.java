package ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import core.Activity;
import core.ActivityFacade;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActivityView extends JPanel implements ActionListener{

	
	private ActivityFacade activityFacade;
	//type de persistance choisi
	private int persistType;
	private Activity actchoisi; 
	
	private ListActivityView listactivityPanel;
	/**
	 * Create the panel.
	 */
	public ActivityView(int persistType,Activity act) {
		this.persistType = persistType;
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		

		JLabel activityNameLabel = new JLabel();
		activityNameLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
		activityNameLabel.setText(act.getActivityName());

		springLayout.putConstraint(SpringLayout.NORTH, activityNameLabel, 30, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, activityNameLabel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, activityNameLabel, 88, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, activityNameLabel, 260, SpringLayout.WEST, this);
		add(activityNameLabel);
		
		JLabel activityShortDescriptionLabel = new JLabel();
		activityShortDescriptionLabel.setText(act.getActivityShortDescription()); 

		springLayout.putConstraint(SpringLayout.NORTH, activityShortDescriptionLabel, 6, SpringLayout.SOUTH, activityNameLabel);
		springLayout.putConstraint(SpringLayout.WEST, activityShortDescriptionLabel, 0, SpringLayout.WEST, activityNameLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, activityShortDescriptionLabel, 48, SpringLayout.SOUTH, activityNameLabel);
		springLayout.putConstraint(SpringLayout.EAST, activityShortDescriptionLabel, 260, SpringLayout.WEST, this);
		activityShortDescriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

		add(activityShortDescriptionLabel);
		
		JLabel activityDetailedDescriptionLabel = new JLabel();
		activityDetailedDescriptionLabel.setText(act.getActivityDetailedDescription());
		springLayout.putConstraint(SpringLayout.NORTH, activityDetailedDescriptionLabel, 0, SpringLayout.SOUTH, activityShortDescriptionLabel);
		springLayout.putConstraint(SpringLayout.WEST, activityDetailedDescriptionLabel, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, activityDetailedDescriptionLabel, -136, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, activityDetailedDescriptionLabel, 764, SpringLayout.WEST, this);
		add(activityDetailedDescriptionLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setActionCommand("Back");
		springLayout.putConstraint(SpringLayout.WEST, backButton, 29, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, backButton, -28, SpringLayout.SOUTH, this);
		add(backButton);
		
		JButton seeEventsButton = new JButton("See Events");
		seeEventsButton.addActionListener(this);
		seeEventsButton.setActionCommand("See Events");
		springLayout.putConstraint(SpringLayout.NORTH, seeEventsButton, 0, SpringLayout.NORTH, backButton);
		springLayout.putConstraint(SpringLayout.EAST, seeEventsButton, -10, SpringLayout.EAST, this);
		add(seeEventsButton);

	}
	

	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if(cmd.equals("Back")){
		listactivityPanel = new ListActivityView(persistType);
		MainView.changePanel(listactivityPanel);
		
		}
		if(cmd.equals("See Events")){
			
			
			}

}


}
