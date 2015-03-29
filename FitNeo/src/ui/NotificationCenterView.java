package ui;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

import core.CategoryProductFacade;
import core.Notification;
import core.NotificationFacade;
import core.UserFacade;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * @author Florent
 *
 */
@SuppressWarnings("serial")
public class NotificationCenterView extends JPanel {

	private NotificationFacade notifFacade;
	private UserFacade userFacade;
	private CategoryProductFacade catFacade;
	//type de persistance choisi
	private int persistType;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public NotificationCenterView(int persistType) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout());
		this.persistType = persistType;	
		this.userFacade = new UserFacade(this.persistType);	
		this.notifFacade = new NotificationFacade(this.persistType);
		this.catFacade = new CategoryProductFacade(this.persistType);
		this.notifFacade.load(userFacade.getIdUser());	
		ArrayList<Notification> list = this.notifFacade.getListNotification();
		
		Vector<String> columnNames = new Vector<String>();
        columnNames.add(0, "Source");
        columnNames.add(1, "Object");
        columnNames.add(2, "Date");
        columnNames.add(3, "Checked");
        columnNames.add(4, "");
        
        Vector<Vector<String>> notifications = new Vector<Vector<String>>();
        
        JPanel notifPanel = new JPanel();
        notifPanel.setLayout(new GridLayout(0, 4));
        
        for (Notification notif : list) {         
            Vector<String> vectorNotification = new Vector<String>();
            vectorNotification.add(notif.getSender());
            vectorNotification.add(notif.getMessage());
            vectorNotification.add(notif.getDate());
            vectorNotification.add(""+notif.getIsRead());
            vectorNotification.add("Details");
            notifications.add(vectorNotification);
        }
		
        table = new JTable(notifications, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.getColumn("").setCellRenderer(new ButtonRenderer());
        table.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumn("Checked").setCellRenderer(new CheckBoxRenderer());
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane, BorderLayout.CENTER);
	}
	
	class CheckBoxRenderer extends DefaultTableCellRenderer {
 
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        	JCheckBox cb = new JCheckBox();
            cb.setSelected(Boolean.valueOf(value.toString()));
            return cb;
        }
        
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
			  setText("Details");
			  return this;
		  }
	}
	
	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;
		private String label;
		private String categoryName;
		private int idcategoryParent;
		private boolean isPushed;
		private boolean isCreationDemand;
		private int confirm;
		private int idNotif;

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
			  label = notifFacade.getListNotification().get(row).getMessage();
			  isCreationDemand = notifFacade.getListNotification().get(row).getIsCreationDemand();
			  categoryName = notifFacade.getListNotification().get(row).getCategoryName();
			  idcategoryParent = notifFacade.getListNotification().get(row).getIdCategoryParent();
			  button.setText("Details");
			  isPushed = true;
			  idNotif=notifFacade.getListNotification().get(row).getIdNotification();
			  System.out.println(idNotif);
			  return button;
		  }

		  public Object getCellEditorValue() {
			  if (isPushed) {
				  notifFacade.setRead(idNotif);
				  if(isCreationDemand){
					  String[] labels={"Confirm", "Refuse"};
					  confirm = JOptionPane.showOptionDialog(button, label+" "+categoryName, "Request to create category",JOptionPane.DEFAULT_OPTION,
				                JOptionPane.INFORMATION_MESSAGE, null, labels, labels[0]);
					  if(confirm == 0){
						  if(!catFacade.confirmCreationCategory(categoryName, idcategoryParent)){						  
							  JOptionPane.showMessageDialog(null, "You have already create this category");
						  }
					  }
				  }				  
				  else{
					  JOptionPane.showMessageDialog(button, label);
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
	
	
