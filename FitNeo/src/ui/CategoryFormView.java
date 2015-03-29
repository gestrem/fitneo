/**
 * @author Maite AINCIBURU
 */
package ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import core.CategoryProductFacade;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
public class CategoryFormView extends JPanel implements ActionListener {
	
		private CategoryProductFacade categoryFacade;
	//type de persistance choisi
		private int persistType;

		private String name;
		private int idCatParent; 
		
	
		private JTextField textFieldName;
		
		JComboBox <ComboItem> comboBox;
		private ComboItem comboitem; 
	/**
	 * Create the panel.
	 */
	public CategoryFormView(int persistType) {
		
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblFillTheFollowing = new JLabel("CATEGORY Fill the following information");
		springLayout.putConstraint(SpringLayout.NORTH, lblFillTheFollowing, 26, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblFillTheFollowing, 45, SpringLayout.WEST, this);
		add(lblFillTheFollowing);
		
		JLabel lblCategoryName = new JLabel("Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblCategoryName, 50, SpringLayout.SOUTH, lblFillTheFollowing);
		springLayout.putConstraint(SpringLayout.WEST, lblCategoryName, 10, SpringLayout.WEST, this);
		add(lblCategoryName);
		
		textFieldName = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldName, 30, SpringLayout.EAST, lblCategoryName);
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldName, 0, SpringLayout.SOUTH, lblCategoryName);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblCategoryParent = new JLabel("Category Parent");
		springLayout.putConstraint(SpringLayout.NORTH, lblCategoryParent, 59, SpringLayout.SOUTH, lblCategoryName);
		springLayout.putConstraint(SpringLayout.WEST, lblCategoryParent, 0, SpringLayout.WEST, lblCategoryName);
		add(lblCategoryParent);
		
		this.categoryFacade = new CategoryProductFacade(this.persistType);	
		this.categoryFacade.loadListCategories();
		ArrayList<String> listCategory = this.categoryFacade.loadCategories();; 
		JComboBox <ComboItem> comboBox = new JComboBox<ComboItem>();
		Iterator<String> it =  listCategory.iterator();
		while ( it.hasNext()) {
			String id = it.next().toString();
			String  label = it.next().toString();
			this.comboitem = new ComboItem(id, label);
			comboBox.addItem(this.comboitem);
		}
		
		
		
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 59, SpringLayout.SOUTH, textFieldName);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 24, SpringLayout.EAST, lblCategoryParent);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox, 86, SpringLayout.SOUTH, textFieldName);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 158, SpringLayout.EAST, lblCategoryParent);
		add(comboBox);
		
		JButton btnCancel = new JButton("Cancel");
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 31, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCancel, -31, SpringLayout.SOUTH, this);
		add(btnCancel);
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("Cancel");
		
		JButton btnValid = new JButton("Validate");
		btnValid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnValid, 0, SpringLayout.SOUTH, btnCancel);
		springLayout.putConstraint(SpringLayout.EAST, btnValid, -44, SpringLayout.EAST, this);
		add(btnValid);
		btnValid.addActionListener(this);
		btnValid.setActionCommand("Validate");

	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("Cancel")){
			AccountView accountPanel = new AccountView(this.persistType);
			MainView.changePanel(accountPanel);
		
		}
		if(cmd.equals("Validate")){
			name = textFieldName.getText(); 
			comboitem = (ComboItem) comboBox.getSelectedItem(); 
			idCatParent = Integer.parseInt(comboitem.getValue()); 
			
			try {
				this.categoryFacade.createCategoryFacade(name, idCatParent);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			AccountView accountPanel = new AccountView(this.persistType);
			MainView.changePanel(accountPanel);
		
			}

	}
}
