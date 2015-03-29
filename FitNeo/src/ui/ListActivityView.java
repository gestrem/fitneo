/**
 * @author Maite AINCIBURU
 */
package ui;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

import core.Activity;
import core.ActivityFacade;

import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class ListActivityView extends JPanel {

	private ActivityFacade activityFacade;
	//type de persistance choisi
	private int persistType;
	
	
	private ActivityView activityPanel;
	
	/**
	 * Create the panel.
	 */
	public ListActivityView(int persistType) {
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
        columnNames.add(2, "See");
        
        Vector<Vector<String>> activities = new Vector<Vector<String>>();
        
        JPanel actPanel = new JPanel();
        actPanel.setLayout(new GridLayout(0, 1));
        
        for (Activity act : list) {         
            Vector<String> vectorActivity = new Vector<String>();
            vectorActivity.add(act.getActivityName());
            vectorActivity.add(act.getActivityManager());
            vectorActivity.add("See");
            activities.add(vectorActivity);
        }
		
        JTable table = new JTable(activities, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.getColumn("See").setCellRenderer(new ButtonRenderer());
        table.getColumn("See").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
        add(new JLabel("Activities"), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
	}
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

		  public ButtonRenderer() {
		    setOpaque(true);
		  }

		  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (isSelected) {
			  setForeground(table.getSelectionForeground());
			  setBackground(table.getSelectionBackground());
			}
			else {
			  setForeground(table.getForeground()); 
			  setBackground(UIManager.getColor("Button.background"));
			  }
			setText("See");
			return this;
		  }
	}
	
	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;
		private String label;
		private Activity actchoisie; 
		private boolean isPushed;

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
			  button.setText("See");
			  isPushed = true;
			  return button;
		  }

		  public Object getCellEditorValue() {
			  if (isPushed) {
				  
				  activityPanel = new ActivityView (persistType,actchoisie );
				  MainView.changePanel(activityPanel);
				  
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
