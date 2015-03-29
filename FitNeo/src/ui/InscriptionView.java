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

import core.Inscription;
import core.UserFacade;

import javax.swing.border.LineBorder;
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
public class InscriptionView extends JPanel {

	private UserFacade userFacade;
	//type de persistance choisi
	private int persistType;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public InscriptionView(int persistType) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout());
		this.persistType = persistType;	
		this.userFacade = new UserFacade(this.persistType);	
		this.userFacade.loadInscriptions();
		ArrayList<Inscription> list = this.userFacade.getInscriptions(); 
		
		Vector<String> columnNames = new Vector<String>();
        columnNames.add(0, "Event name");
        columnNames.add(1, "Date of the event");
        columnNames.add(2, "Date Inscription");
        columnNames.add(3, "");
        
        Vector<Vector<String>> inscriptions = new Vector<Vector<String>>();
        
        JPanel inscriptionPanel = new JPanel();
        inscriptionPanel.setLayout(new GridLayout(0, 3));
        
        for (Inscription insc : list) {         
            Vector<String> vectorInscription = new Vector<String>();
            vectorInscription.add(insc.getEventName());
            vectorInscription.add(insc.getEventDate());
            vectorInscription.add(insc.getEventDateInscription());
            vectorInscription.add("");
            inscriptions.add(vectorInscription);
        }
		
        table = new JTable(inscriptions, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.getColumn("").setCellRenderer(new ButtonRenderer());
        table.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
        add(new JLabel("My inscriptions : "), BorderLayout.NORTH);
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
			  setText("Delete");
			  return this;
		  }
	}
	
	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;
		private String label;
		private boolean isPushed;
		private Inscription i;

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
			  label = value.toString();
			  button.setText("Détails");
			  i=userFacade.getInscriptions().get(row);
			  isPushed = true;
			  return button;
		  }

		  public Object getCellEditorValue() {
			  if (isPushed) {
				 int confirm;
				 confirm = JOptionPane.showConfirmDialog(button, "Are you sur ?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
				 if(confirm == 0){
					 userFacade.unscribeEvent(i.getEventId());
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
	
	
