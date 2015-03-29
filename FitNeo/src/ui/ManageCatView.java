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
import core.CategoryProduct;
import core.CategoryProductFacade;


public class ManageCatView extends JPanel implements ActionListener {

	private CategoryProductFacade categoryFacade;
	//type de persistance choisi
	private int persistType; 

	public ManageCatView(int persistType) {
	/**
	 * Create the panel.
	 */
	
	this.persistType = persistType;
	setBackground(Color.WHITE);
	setBorder(new LineBorder(new Color(0, 0, 0)));
	setLayout(new BorderLayout());
	this.persistType = persistType;	
	this.categoryFacade = new CategoryProductFacade(this.persistType);	
	this.categoryFacade.loadListCategories();
	ArrayList<CategoryProduct> listCat = this.categoryFacade.getAllCategoriesFacade();
	
	
	Vector<String> columnNames = new Vector<String>();
    columnNames.add(0, "Libelle");
    columnNames.add(1, "Categorie Parent");
    columnNames.add(2, "Delete");
    

    Vector<Vector<String>> categories = new Vector<Vector<String>>();
    
    JPanel catPanel = new JPanel();
    catPanel.setLayout(new GridLayout(0, 1));
    
    for (CategoryProduct cat : listCat) {         
        Vector<String> vectorCategory = new Vector<String>();
        vectorCategory.add(cat.getCategoryName());
        if (cat.getSuperCategory() != null){
        vectorCategory.add(cat.getSuperCategoryName());
        }
        else {
        	vectorCategory.add("Null");
        }
        vectorCategory.add("Delete");
        categories.add(vectorCategory);
    }
 
    JTable table = new JTable(categories, columnNames);
    table.setFillsViewportHeight(true);
    table.setRowHeight(20);
    table.getColumn("Delete").setCellRenderer(new ButtonRenderer());
    table.getColumn("Delete").setCellEditor(new ButtonEditor(new JCheckBox()));
    
    JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
    JPanel top = new JPanel();
    top.setLayout(new GridLayout(0,4));
    top.add(new JLabel("Category")); 
    JButton buttonAdd = new JButton("Create Category");
    top.add(buttonAdd);
    buttonAdd.addActionListener(this);
	buttonAdd.setActionCommand("create category");
	add(top, BorderLayout.NORTH); 
    add(scrollPane, BorderLayout.CENTER);
	

	}
	
	public void actionPerformed(ActionEvent e)
	{
		String cmd = e.getActionCommand();
		if(cmd.equals("create category")){ 
			CategoryFormView createCategoryPanel = new CategoryFormView(this.persistType);
			MainView.changePanel(createCategoryPanel);
			
		}
	}
		
	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			    setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (table.getColumnName(column)=="Delete"){
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
		private CategoryProduct catchoisie; 
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
			if(table.getColumnName(column)=="Delete"){ 
				if (isSelected) {
					button.setForeground(table.getSelectionForeground());
					button.setBackground(table.getSelectionBackground());
				} 
				else {
					button.setForeground(table.getForeground());
					button.setBackground(table.getBackground());
				}
				label ="test";
				catchoisie= categoryFacade.getAllCategoriesFacade().get(row); 
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
					confirm = JOptionPane.showOptionDialog(button, label+" "+this.catchoisie.getCategoryName(), "Delete activity",JOptionPane.DEFAULT_OPTION,
				                JOptionPane.INFORMATION_MESSAGE, null, labels, labels[0]);
					if(confirm == 0){
						try {
							categoryFacade.deleteCategory(this.catchoisie.getCategoryId());
						} 
						catch (SQLException e) {
						// TODO Auto-generated catch block
							e.printStackTrace();
						}
						  
						 ManageCatView categoryPanel = new ManageCatView(persistType);
						 MainView.changePanel(categoryPanel);
					  }
						  
					  
				  }
				}
			return button;
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
