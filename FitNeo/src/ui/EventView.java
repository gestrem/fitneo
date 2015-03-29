package ui;

import java.awt.BorderLayout;
import java.awt.Component;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import javax.swing.table.TableCellRenderer;



import core.EventFacade;
import core.UserFacade;


public class EventView extends JPanel {
	private int persistType;
	private EventFacade aEventFacade;
	private UserFacade userFacade;
	private JPanel inscriptionPanel; 
	private String label;

	/**
	 * Create the panel.
	 */
	public EventView(int persistType) {
		
		//setBorder(new LineBorder(new Color(0, 0, 0)));
		//setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 2, 0, 0));
		this.persistType = persistType;	
		
		this.aEventFacade = new EventFacade(this.persistType);
		this.userFacade = new UserFacade(this.persistType);

		
		
		this.aEventFacade.getAllEventsFacade();
		ArrayList<core.Event> listEvent = aEventFacade.getListAllEventsFacade();
	
		
		Vector<String> columnNamesEvent = new Vector<String>();
        columnNamesEvent.add(0, "EventLabel");
        columnNamesEvent.add(1, "date");
        columnNamesEvent.add(2, "Details");
        
        
        Vector<Vector<String>> events = new Vector<Vector<String>>();
        
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(new GridLayout(0, 1));
        
        inscriptionPanel= new JPanel();
        inscriptionPanel.setLayout(new GridLayout(0, 1));
        
        for (core.Event event : listEvent) {         
            Vector<String> vectorEvents = new Vector<String>();
            vectorEvents.add(event.getEventName());
            vectorEvents.add(event.getEventDate());
            vectorEvents.add("Details");
            
            events.add(vectorEvents);
        }
		
        JTable table = new JTable(events, columnNamesEvent);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.getColumn("Details").setCellRenderer(new ButtonRenderer());
        table.getColumn("Details").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
        /*categoryPanel.add(new JLabel("Categories"), BorderLayout.NORTH);
        categoryPanel.add(scrollPane, BorderLayout.CENTER);
        
        productPanel.add(new JLabel("Products"), BorderLayout.NORTH);
        productPanel.add(scrollPane, BorderLayout.CENTER);*/
        
        add(eventPanel);
        add(inscriptionPanel);
		
		
		eventPanel.add(scrollPane, BorderLayout.CENTER);
		

	}
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

		  public ButtonRenderer() {
		    setOpaque(true);
		  }

		  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			  if(table.getColumnName(column) == "Details"){
			  if (isSelected) {
				  setForeground(table.getSelectionForeground());
				  setBackground(table.getSelectionBackground());
			  }
			  else {
				  setForeground(table.getForeground());
				  setBackground(UIManager.getColor("Button.background"));
			  }
			  setText("Details");
			  }
			  
			  return this;
		  }
	}
	
	class ButtonEditor extends DefaultCellEditor implements ActionListener {
		protected JButton button;
		
		private core.Event eventChoose;
		private String label;
		private boolean isPushed;
		private String eventSelected;

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
			 if(table.getColumnName(column) == "Details"){
			 if (isSelected) {
				  button.setForeground(table.getSelectionForeground());
				  button.setBackground(table.getSelectionBackground());
			  } 
			  else 
			  {
				  button.setForeground(table.getForeground());
				  button.setBackground(table.getBackground());
			  }
			 
			  eventChoose = aEventFacade.getListAllEventsFacade().get(row);
			  label = aEventFacade.getListAllEventsFacade().get(row).getEventName();
			  button.setText("See event");
			  isPushed = true;
			  eventSelected=table.getColumnName(column);
			  }
			 
			  return button;
		  }

		public Object getCellEditorValue() {
				if(eventSelected=="Details"){
					if (isPushed) { 
				  
				  	
				  	
					JLabel eventLabelName =  new JLabel("Event Name :"+eventChoose.getEventName());
					JLabel eventLabelDate =  new JLabel("Event Date :"+eventChoose.getEventDate());
					JLabel eventLabelPrice =  new JLabel("Event Price :"+eventChoose.getEventPrice()+"Û");
					JLabel eventLabelParticipant= new JLabel("Event Participant :"+eventChoose.getParticipantName());
					JButton subscriptionButton =new JButton("Click To Subscribe");
					subscriptionButton.addActionListener(this);
					subscriptionButton.setActionCommand("Subscribe");
					
			       
			       
			        
			        
			        
			        inscriptionPanel.removeAll();
			        inscriptionPanel.repaint();
			        inscriptionPanel.revalidate();
			        inscriptionPanel.add(eventLabelName);
			        inscriptionPanel.add(eventLabelDate);
			        inscriptionPanel.add(eventLabelPrice);
			        inscriptionPanel.add(eventLabelParticipant);
			        inscriptionPanel.add(subscriptionButton);
			        inscriptionPanel.repaint();
			        inscriptionPanel.revalidate();
			        
			        
				 
			  }}
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

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("Subscribe")){
				//userFacade.subscribeEvent(eventChoose.getEventId());
				System.out.println(eventChoose.getEventId());
				
			}
			
		}
	}
}
