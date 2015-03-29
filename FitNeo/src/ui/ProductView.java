package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import persist.ListCategoryJDBC;
import persist.ListProductJDBC;
import persist.PersistKit;
import ui.NotificationCenterView.ButtonEditor;
import ui.NotificationCenterView.ButtonRenderer;
import core.BasketFacade;
import core.CategoryProduct;
import core.CategoryProductFacade;
import core.ListCategory;
import core.ListProduct;
import core.Notification;
import core.NotificationFacade;
import core.Product;
import core.ProductFacade;
import core.UserFacade;

import javax.swing.JTable;

public class ProductView extends JPanel {
	private int persistType;
	private ProductFacade aProductFacade;
	private CategoryProductFacade aCategoryFacade;
	private JPanel productPanel;
	private BasketFacade aBasketFacade;
	private UserFacade userFacade;
	/**
	 * Create the panel.
	 */
	public ProductView(int persistType) {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 2, 0, 0));
		this.persistType = persistType;	
		
		this.aProductFacade = new ProductFacade(this.persistType);
		this.userFacade = new UserFacade(this.persistType);
		this.aBasketFacade = new BasketFacade(this.persistType);
		this.aBasketFacade.loadMainBasket(this.userFacade.getIdUser());
		
		
		this.aCategoryFacade = new CategoryProductFacade(this.persistType);
		this.aCategoryFacade.loadListCategories();
		ArrayList<CategoryProduct> listCat = this.aCategoryFacade.getAllCategoriesFacade();
		
		Vector<String> columnNamesCategory = new Vector<String>();
        columnNamesCategory.add(0, "categoryLabel");
        columnNamesCategory.add(1, "");
        
        Vector<Vector<String>> categories = new Vector<Vector<String>>();
        
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(0, 1));
        
        productPanel= new JPanel();
        productPanel.setLayout(new GridLayout(0, 1));
        
        for (CategoryProduct cat : listCat) {         
            Vector<String> vectorCategories = new Vector<String>();
            vectorCategories.add(cat.getCategoryName());
            vectorCategories.add("");
            categories.add(vectorCategories);
        }
		
        JTable table = new JTable(categories, columnNamesCategory);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.getColumn("").setCellRenderer(new ButtonRenderer());
        table.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
        /*categoryPanel.add(new JLabel("Categories"), BorderLayout.NORTH);
        categoryPanel.add(scrollPane, BorderLayout.CENTER);
        
        productPanel.add(new JLabel("Products"), BorderLayout.NORTH);
        productPanel.add(scrollPane, BorderLayout.CENTER);*/
        
        add(categoryPanel);
		add(productPanel);
		
		categoryPanel.add(scrollPane, BorderLayout.CENTER);
		
	
	}
	
	class ButtonRenderer extends JButton implements TableCellRenderer {

		  public ButtonRenderer() {
		    setOpaque(true);
		  }

		  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			  if(table.getColumnName(column) == ""){
			  if (isSelected) {
				  setForeground(table.getSelectionForeground());
				  setBackground(table.getSelectionBackground());
			  }
			  else {
				  setForeground(table.getForeground());
				  setBackground(UIManager.getColor("Button.background"));
			  }
			  setText("See Products");
			  }
			  
			  else if (table.getColumnName(column) == "Add") {
				  if (isSelected) {
				  setForeground(table.getSelectionForeground());
				  setBackground(table.getSelectionBackground());
			  }
			  else {
				  setForeground(table.getForeground());
				  setBackground(UIManager.getColor("Button.background"));
			  }
			  setText("Add products");
			  }
			  return this;
		  }
	}
	
	class ButtonEditor extends DefaultCellEditor {
		protected JButton button;
		private CategoryProduct categoryChoose;
		private Product productChoose;
		private String label;
		private boolean isPushed;
		private String tableSelected;

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
			 if(table.getColumnName(column) == ""){
			 if (isSelected) {
				  button.setForeground(table.getSelectionForeground());
				  button.setBackground(table.getSelectionBackground());
			  } 
			  else 
			  {
				  button.setForeground(table.getForeground());
				  button.setBackground(table.getBackground());
			  }
			 
			  categoryChoose = aCategoryFacade.getAllCategoriesFacade().get(row);
			  label = aCategoryFacade.getAllCategoriesFacade().get(row).getCategoryName();
			  button.setText("See Products");
			  isPushed = true;
			  tableSelected=table.getColumnName(column);
			  }
			 
			 else if (table.getColumnName(column) == "Add"){
				 if (isSelected) {
					  button.setForeground(table.getSelectionForeground());
					  button.setBackground(table.getSelectionBackground());
				  } 
				  else 
				  {
					  button.setForeground(table.getForeground());
					  button.setBackground(table.getBackground());
				  }
				 
				  productChoose = aProductFacade.getListAllProductFacade().get(row);
				  label = aProductFacade.getListAllProductFacade().get(row).getProductTypeName();
				  button.setText("Add");
				  isPushed = true;
				  tableSelected=table.getColumnName(column);
			 }
			  return button;
		  }

		public Object getCellEditorValue() {
				if(tableSelected==""){
					if (isPushed) { 
				  
				  	
				  	aProductFacade.getAllProductByCategoryFacade(categoryChoose.getCategoryId());
					ArrayList<Product> listProd = aProductFacade.getListAllProductFacade();
					System.out.println(listProd);
					Vector<String> columnNamesProducts = new Vector<String>();
			        columnNamesProducts.add(0, "Product Name");
			        columnNamesProducts.add(1, "Product Price");
			        columnNamesProducts.add(2, "Discount");
			        columnNamesProducts.add(3, "Add");
			        Vector<Vector<String>> products = new Vector<Vector<String>>();
			        for (Product prod : listProd) {         
			            Vector<String> vectorProducts = new Vector<String>();
			            vectorProducts.add(prod.getProductTypeName());
			            vectorProducts.add(""+prod.getProductPrice());
			            vectorProducts.add(""+prod.getDiscountMember());
			            vectorProducts.add("");
			            products.add(vectorProducts);
			        }
			        JTable tableProducts = new JTable(products, columnNamesProducts);
			        tableProducts.setFillsViewportHeight(true);
			        tableProducts.setRowHeight(20);
			        tableProducts.getColumn("Add").setCellRenderer(new ButtonRenderer());
			        tableProducts.getColumn("Add").setCellEditor(new ButtonEditor(new JCheckBox()));
			        JScrollPane scrollPaneProduct = new JScrollPane(tableProducts, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			        
			        
			        
			        productPanel.removeAll();
			        productPanel.repaint();
			        productPanel.revalidate();
			        productPanel.add(scrollPaneProduct, BorderLayout.CENTER);
			        productPanel.repaint();
			        productPanel.revalidate();
			        
			        
				 
			  }}
				else if (tableSelected=="Add"){
					//add product productChoose
					System.out.println("j'aimmerai ajouter "+productChoose.getProductTypeName());
					String quantity = JOptionPane.showInputDialog(null, "Enter a quantity", "Enter a quantity", JOptionPane.QUESTION_MESSAGE);
					aBasketFacade.insertProduct(productChoose, Integer.parseInt(quantity));
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
	

		
        
       
		
		
		
		
		
	
	
