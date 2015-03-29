package ui;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import core.BasketFacade;
import core.Product;
import core.UserFacade;

import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class BasketView extends JPanel {

	private BasketFacade basketFacade;
	private UserFacade userFacade;
	//type de persistance choisi
	private int persistType;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public BasketView(int persistType) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout());
		this.persistType = persistType;	
		this.userFacade = new UserFacade(this.persistType);	
		this.basketFacade = new BasketFacade(this.persistType);
		this.basketFacade.loadMainBasket(userFacade.getIdUser());	
		ArrayList<Product> list = this.basketFacade.getMainBasket().getListProducts();
		
		Vector<String> columnNames = new Vector<String>();
        columnNames.add(0, "Name");
        columnNames.add(1, "Price");
        columnNames.add(2, "Quantity");
        columnNames.add(3, "Discount");
        columnNames.add(4, "");
        
        Vector<Vector<String>> products = new Vector<Vector<String>>();
        
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(0, 4));
        
        for (Product product : list) {         
            Vector<String> vectorNotification = new Vector<String>();
            vectorNotification.add(product.getProductTypeName());
            vectorNotification.add(""+product.getProductPrice());
            vectorNotification.add(""+product.getAvailableQuantity());
            vectorNotification.add(""+product.getDiscountMember());
            vectorNotification.add("Delete");
            products.add(vectorNotification);
        }
		
        table = new JTable(products, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.getColumn("").setCellRenderer(new ButtonRenderer());
        table.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
        add(new JLabel("My Shopping cart : "+this.basketFacade.getMainBasket().getTotalPrice()+" €"), BorderLayout.NORTH);
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
			  isPushed = true;
			  return button;
		  }

		  public Object getCellEditorValue() {
			  if (isPushed) {
				 
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
	
	
