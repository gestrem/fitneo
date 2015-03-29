/**
 * @author Maite AINCIBURU
 */

package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;


import core.Activity;
import core.ActivityFacade;

public class ManageActView extends JPanel implements ActionListener {

	private ActivityFacade activityFacade;
	//type de persistance choisi
	private int persistType;
	
	public ManageActView(int persistType) {
		/**
		 * Create the panel.
		 */
			this.persistType = persistType;
			setBackground(Color.WHITE);
			setBorder(new LineBorder(new Color(0, 0, 0)));
			setLayout(new BorderLayout());
			this.persistType = persistType;	
			this.activityFacade = new ActivityFacade(this.persistType);	
			this.activityFacade.loadListActivities();
			ArrayList<Activity> list = this.activityFacade.getListAllActivities();
			
			Vector<String> columnNames = new Vector<String>();
	        columnNames.add(0, "Name");
	        columnNames.add(1, "Manager");
	        columnNames.add(2, "Update");
	        columnNames.add(3, "Delete");
	        
	        
	        Vector<Vector<String>> activities = new Vector<Vector<String>>();
	        
	        JPanel actPanel = new JPanel();
	        actPanel.setLayout(new GridLayout(0, 1));
	        
	        for (Activity act : list) {         
	            Vector<String> vectorActivity = new Vector<String>();
	            vectorActivity.add(act.getActivityName());
	            vectorActivity.add(act.getActivityManager());
	            vectorActivity.add("Update");
	            vectorActivity.add("Delete");
	            activities.add(vectorActivity);
	        }
			
	        JTable table = new JTable(activities, columnNames);
	        table.setFillsViewportHeight(true);
	        table.setRowHeight(20);
	        table.getColumn("Update").setCellRenderer(new ButtonRenderer());
	        table.getColumn("Update").setCellEditor(new ButtonEditor(new JCheckBox()));
	        table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
	        table.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox()));
	        
	        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
	        JPanel top = new JPanel();
	        top.setLayout(new GridLayout(0,4));
	        top.add(new JLabel("Activity")); 
	        JButton buttonAdd = new JButton("Create Activity");
	        top.add(buttonAdd);
	        buttonAdd.addActionListener(this);
			buttonAdd.setActionCommand("create activity");
	        add(top, BorderLayout.NORTH); 
	        add(scrollPane, BorderLayout.CENTER);

	}
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if(cmd.equals("create activity")){ 
			ActivityFormView createActivityPanel = new ActivityFormView(this.persistType);
			MainView.changePanel(createActivityPanel);
			
		}
	}
	
	
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

		  public ButtonRenderer() {
		    setOpaque(true);
		  }

		  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if(table.getColumnName(column)=="Update"){
			  if (isSelected) {
			  setForeground(table.getSelectionForeground());
			  setBackground(table.getSelectionBackground());
			}
			else {
			  setForeground(table.getForeground()); 
			  setBackground(UIManager.getColor("Button.background"));
			  }
			setText("Update");
			}
			
			else if (table.getColumnName(column)=="Delete"){
				  if (isSelected) {
					  setForeground(table.getSelectionForeground());
					  setBackground(table.getSelectionBackground());
					}
					else {
					  setForeground(table.getForeground()); 
					  setBackground(UIManager.getColor("Button.background"));
					  }
					setText("Delete");
					}
					
				
			return this;
		  }
	}
		class ButtonEditor extends DefaultCellEditor {
			protected JButton button;
			private String label;
			private Activity actchoisie; 
			private boolean isPushed;
			private String buttonSelected; 
			private int confirm;
	
			public ButtonEditor(JCheckBox checkBox) {
				super(checkBox);
				button = new JButton();
			    button.setOpaque(true);
			    button.addActionListener(new ActionListener() {
			    	
			    	public void actionPerformed(ActionEvent e) {
				   		fireEditingStopped();
				   	}
				   });
			}
	
		
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {			  
			if(table.getColumnName(column)=="Update"){ 
			if (isSelected) {
				  button.setForeground(table.getSelectionForeground());
				  button.setBackground(table.getSelectionBackground());
			  } 
			  else 
			  {
				  button.setForeground(table.getForeground());
				  button.setBackground(table.getBackground());
			  }
			  label ="test";
			  actchoisie= activityFacade.getListAllActivities().get(row); 
			  button.setText("Go To Update");
			  isPushed = true;
			  buttonSelected = table.getColumnName(column); 
			 
		  }
			else if(table.getColumnName(column)=="Delete"){ 
				if (isSelected) {
					  button.setForeground(table.getSelectionForeground());
					  button.setBackground(table.getSelectionBackground());
				  } 
				  else 
				  {
					  button.setForeground(table.getForeground());
					  button.setBackground(table.getBackground());
				  }
				  label ="test";
				  actchoisie= activityFacade.getListAllActivities().get(row); 
				  button.setText("Deleted");
				  isPushed = true;
				  buttonSelected = table.getColumnName(column); 
				 
			  }
			 return button;
		}
		

		  public Object getCellEditorValue() {
			  if(buttonSelected =="Delete"){
			  
			  if (isPushed) {
				  String[] labels={"Confirm", "Refuse"};
				  confirm = JOptionPane.showOptionDialog(button, label+" "+this.actchoisie.getActivityName(), "Delete activity",JOptionPane.DEFAULT_OPTION,
			                JOptionPane.INFORMATION_MESSAGE, null, labels, labels[0]);
				  if(confirm == 0){
					  try {
							activityFacade.deleteActivity(this.actchoisie.getActivityId());
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  
					  ManageActView activityPanel = new ManageActView(persistType);
					  MainView.changePanel(activityPanel);
				  }
					  
				  
			  }
				  
				

			  }
			  else   if(buttonSelected=="Update"){
				  
				  if (isPushed) {
					  UpdateActivityFormView activityPanel = new UpdateActivityFormView(persistType, this.actchoisie);
					  MainView.changePanel(activityPanel);
					  
				  }
				  }
			  isPushed = false;
			  return new String(label);
		  }

		  public boolean stopCellEditing() {
			  isPushed = false;
			  return super.stopCellEditing();
		  }

		  protected void fireEditingStopped() {
			  super.fireEditingStopped();
		  }
	}

}
