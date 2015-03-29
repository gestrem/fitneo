package ui;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;
import core.Basket;
import core.BasketFacade;
import core.Product;
import core.UserFacade;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
/**
 * 
 * @author Florent
 *
 */
@SuppressWarnings("serial")
public class OrderView extends JPanel {
	
	private BasketFacade basketFacade;
	private UserFacade userFacade;
	//type de persistance choisi
	private int persistType;
	private JTable table;
	private JPanel panelDroit;
	
	public OrderView(int persistType) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(1, 2, 0, 0));
		this.persistType = persistType;	
		this.userFacade = new UserFacade(this.persistType);	
		this.basketFacade = new BasketFacade(this.persistType);
		this.basketFacade.loadOrders(userFacade.getIdUser());	
		ArrayList<Basket> listB = this.basketFacade.getOrders();
		
		JPanel panelGauche = new JPanel();
        panelGauche.setLayout(new GridLayout(0, 1));
		add(panelGauche);
		
		panelDroit = new JPanel();
		panelDroit.setLayout(new GridLayout(0, 1));
		add(panelDroit);
		
		Vector<String> columnNames = new Vector<String>();
        columnNames.add(0, "Num");
        columnNames.add(1, "Date");
        columnNames.add(2, "Price");
        columnNames.add(3, "");
        
        Vector<Vector<String>> baskets = new Vector<Vector<String>>();
        
        for (Basket basket : listB) {         
            Vector<String> vectorBasket = new Vector<String>();
            vectorBasket.add(""+basket.getIdBasket());
            vectorBasket.add(""+basket.getIdUser());
            vectorBasket.add(""+basket.getTotalPrice());
            vectorBasket.add("");
            baskets.add(vectorBasket);
        }
        
        table = new JTable(baskets, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        //ajout des boutons grace au cellRenderer
        table.getColumn("").setCellRenderer(new ButtonRenderer());
        table.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panelGauche.add(scrollPane, BorderLayout.CENTER);
	}
	/**
	 * 
	 * @author Florent
	 *
	 */
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
	/**
	 * 
	 * @author Florent
	 *
	 */
	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;
		private String label;
		private boolean isPushed;
		private int idBasket;

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
			  button.setText("See");
			  isPushed = true;
			  
			  idBasket= row;
			  return button;
		  }

		  public Object getCellEditorValue() {
			  if (isPushed) {
				  ArrayList<Product> list = basketFacade.getOrders().get(idBasket).getListProducts();
					
				  Vector<String> columnNames = new Vector<String>();
			      columnNames.add(0, "Name");
			      columnNames.add(1, "Price");
			      columnNames.add(2, "Quantity");
			      columnNames.add(3, "Discount");
			        
			      Vector<Vector<String>> products = new Vector<Vector<String>>();
			      for (Product product : list) {         
			            Vector<String> vectorNotification = new Vector<String>();
			            vectorNotification.add(product.getProductTypeName());
			            vectorNotification.add(""+product.getProductPrice());
			            vectorNotification.add(""+product.getAvailableQuantity());
			            vectorNotification.add(""+product.getDiscountMember());
			            products.add(vectorNotification);
			        }
					
			        JTable tableP = new JTable(products, columnNames);
			        tableP.setFillsViewportHeight(true);
			        tableP.setRowHeight(20);
			        
			        JScrollPane scrollPane = new JScrollPane(tableP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			        panelDroit.removeAll();
			        panelDroit.repaint();
			        panelDroit.revalidate();
			        panelDroit.add(scrollPane, BorderLayout.CENTER);
			        panelDroit.repaint();
			        panelDroit.revalidate();
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