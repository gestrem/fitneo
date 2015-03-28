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
	private Product aProduct;
	private ListProduct aListProduct;
	private ProductFacade aProductFacade;
	private CategoryProduct aCategory;
	private ListCategory aListCategory;
	private CategoryProductFacade aCategoryFacade;
	private ArrayList<CategoryProduct> listCat;
	private ArrayList<Product> listProd;
	/**
	 * Create the panel.
	 */
	public ProductView(int persistType) {

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 2, 0, 0));
		this.persistType = persistType;	
		
		this.aProductFacade = new ProductFacade(this.persistType);
		this.aProductFacade.getAllProductByCategoryFacade(2);
		ArrayList<Product> listProd = this.aProductFacade.getListAllProductFacade();
		
		System.out.println(listProd);
		
		System.out.println();
		
		
		this.aCategoryFacade = new CategoryProductFacade(this.persistType);
		this.aCategoryFacade.loadListCategories();
		ArrayList<CategoryProduct> listCat = this.aCategoryFacade.getAllCategoriesFacade();
		
		Vector<String> columnNames = new Vector<String>();
        columnNames.add(0, "categoryLabel");
        columnNames.add(1, "");
        
        
        
        Vector<Vector<String>> categories = new Vector<Vector<String>>();
        
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(0, 2));
        
        JPanel productPanel= new JPanel();
        productPanel.setLayout(new GridLayout(0, 2));
        
        for (CategoryProduct cat : listCat) {         
            Vector<String> vectorCategories = new Vector<String>();
            vectorCategories.add(cat.getCategoryName());
            vectorCategories.add("");
            categories.add(vectorCategories);
        }
		
        JTable table = new JTable(categories, columnNames);
        table.setFillsViewportHeight(true);
        table.setRowHeight(20);
        table.getColumn("").setCellRenderer(new ButtonRenderer());
        table.getColumn("").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
        categoryPanel.add(new JLabel("Categories"), BorderLayout.NORTH);
        categoryPanel.add(scrollPane, BorderLayout.CENTER);
        
        productPanel.add(new JLabel("Products"), BorderLayout.NORTH);
        productPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(categoryPanel);
		SpringLayout sl_panelGauche = new SpringLayout();
		categoryPanel.setLayout(sl_panelGauche);
		
		add(productPanel);
		SpringLayout sl_panelDroit = new SpringLayout();
		productPanel.setLayout(sl_panelDroit);
		
		categoryPanel.add(table);
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
			  setText("See Products");
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
			  label = aCategoryFacade.getAllCategoriesFacade().get(row).getCategoryName();
			  button.setText("Details");
			  isPushed = true;
			  return button;
		  }

		public Object getCellEditorValue() {
			  if (isPushed) { 
				  
				  	
				  	
					
					Vector<String> columnNames = new Vector<String>();
			        columnNames.add(0, "Product Name");
			        columnNames.add(1, "");
				 
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
	

		
        
       
		
		
		
		
		
	
	
