package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

import core.CategoryProductFacade;
import core.ProductFacade;
import core.RoomFacade;
import core.UserFacade;
import core.CategoryProduct;
import core.Product;

public class ProductFormView extends JPanel implements ActionListener {
	private JTextField tf_qtyAvailable;
	private JTextField tf_discountMember;
	private JTextField tf_productType;
	private JTextField tf_price;
	private UserFacade userFacade;
	private int persistType;
	private CategoryProductFacade categoryProductFacade;
	private ProductFacade productFacade;
	private JComboBox cb_Category;
	/**
	 * Create the panel.
	 */
	public ProductFormView(int persistType) {
		this.persistType = persistType;

		this.userFacade = new UserFacade(this.persistType);	
		this.categoryProductFacade = new CategoryProductFacade(this.persistType);	
		this.productFacade = new ProductFacade(this.persistType);	

		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel label = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, label, 22, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label, 355, SpringLayout.WEST, this);
		add(label);
		
		this.cb_Category = new JComboBox();
		categoryProductFacade.loadListCategories();
		ArrayList<CategoryProduct> listCategory =categoryProductFacade.getAllCategoriesFacade();
		System.out.println("siez : "+listCategory.size());

		for (int i=0;i<listCategory.size();i++){
			System.out.println("id : "+listCategory.get(i).getCategoryId());
			String id=Integer.toString(listCategory.get(i).getCategoryId());
			String categoryName=listCategory.get(i).getCategoryName();
			cb_Category.addItem(new ComboItem(id, categoryName));

		}

		springLayout.putConstraint(SpringLayout.NORTH, cb_Category, 101, SpringLayout.NORTH, this);
		add(cb_Category);
		
		JLabel lblChooseACategory = new JLabel("Choose a Category");
		springLayout.putConstraint(SpringLayout.WEST, lblChooseACategory, 20, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.WEST, cb_Category, 29, SpringLayout.EAST, lblChooseACategory);
		springLayout.putConstraint(SpringLayout.NORTH, lblChooseACategory, 4, SpringLayout.NORTH, cb_Category);
		add(lblChooseACategory);
		
		tf_qtyAvailable = new JTextField();
		add(tf_qtyAvailable);
		tf_qtyAvailable.setColumns(10);
		
		JLabel lblQuantityAvailable = new JLabel("Quantity Available");
		springLayout.putConstraint(SpringLayout.WEST, tf_qtyAvailable, 17, SpringLayout.EAST, lblQuantityAvailable);
		springLayout.putConstraint(SpringLayout.NORTH, lblQuantityAvailable, 6, SpringLayout.NORTH, tf_qtyAvailable);
		springLayout.putConstraint(SpringLayout.WEST, lblQuantityAvailable, 0, SpringLayout.WEST, lblChooseACategory);
		add(lblQuantityAvailable);
		
		JLabel lblDiscountMember = new JLabel("Discount member (%)");
		springLayout.putConstraint(SpringLayout.WEST, lblDiscountMember, 0, SpringLayout.WEST, lblChooseACategory);
		add(lblDiscountMember);
		
		tf_discountMember = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lblDiscountMember, 6, SpringLayout.NORTH, tf_discountMember);
		springLayout.putConstraint(SpringLayout.NORTH, tf_discountMember, 14, SpringLayout.SOUTH, tf_qtyAvailable);
		springLayout.putConstraint(SpringLayout.WEST, tf_discountMember, 0, SpringLayout.WEST, tf_qtyAvailable);
		add(tf_discountMember);
		tf_discountMember.setColumns(10);
		
		tf_productType = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, tf_productType, -211, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, tf_qtyAvailable, 14, SpringLayout.SOUTH, tf_productType);
		springLayout.putConstraint(SpringLayout.EAST, tf_productType, 0, SpringLayout.EAST, tf_qtyAvailable);
		add(tf_productType);
		tf_productType.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblProductName, 6, SpringLayout.NORTH, tf_productType);
		springLayout.putConstraint(SpringLayout.EAST, lblProductName, -21, SpringLayout.WEST, tf_productType);
		add(lblProductName);
		
		JButton btnCreateProduct = new JButton("Create Product");
		springLayout.putConstraint(SpringLayout.NORTH, btnCreateProduct, 58, SpringLayout.SOUTH, tf_discountMember);
		springLayout.putConstraint(SpringLayout.WEST, btnCreateProduct, 0, SpringLayout.WEST, tf_qtyAvailable);
		add(btnCreateProduct);
		
		tf_price = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_price, 8, SpringLayout.SOUTH, tf_discountMember);
		springLayout.putConstraint(SpringLayout.WEST, tf_price, 0, SpringLayout.WEST, tf_qtyAvailable);
		add(tf_price);
		tf_price.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		springLayout.putConstraint(SpringLayout.NORTH, lblPrice, 6, SpringLayout.NORTH, tf_price);
		springLayout.putConstraint(SpringLayout.EAST, lblPrice, 0, SpringLayout.EAST, lblChooseACategory);
		add(lblPrice);
		
		 cb_Category.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	ComboItem co=(ComboItem) cb_Category.getSelectedItem();
		    	System.out.println("id"+co.getValue());
		    	
		    }
		});
		btnCreateProduct.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	//on verifie que les champs ne sont pas vides 
		    	if((!tf_qtyAvailable.getText().equals("")) || (!tf_discountMember.getText().equals("")) ||(!tf_productType.getText().equals("")) || (!tf_price.getText().equals("")) ){ 
			    	ComboItem categoryItem=(ComboItem) cb_Category.getSelectedItem();
			    	int id_Cat=Integer.parseInt(categoryItem.getValue());
			    	System.out.println("id "+id_Cat);
		    		String productName=tf_productType.getText();
		    		int qty_available=Integer.parseInt(tf_qtyAvailable.getText());
		    		int discountMember=Integer.parseInt(tf_discountMember.getText());
		    		int price = Integer.parseInt(tf_price.getText());
		    		int id_user=userFacade.getIdUser();
			    	System.out.println("id user "+id_user);

		    		Product product= new Product(productName, price,qty_available,discountMember,id_Cat, id_user);
		    		try {
						productFacade.createProductFacade(product);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    		JOptionPane.showMessageDialog(null,productName+" a été ajouté");

	}				
		    }
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
