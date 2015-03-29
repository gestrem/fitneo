package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ProductFormView extends JPanel {
	private JTextField tf_qtyAvailable;
	private JTextField tf_discountMember;
	private JTextField tf_productType;

	/**
	 * Create the panel.
	 */
	public ProductFormView() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel label = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, label, 22, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, label, 355, SpringLayout.WEST, this);
		add(label);
		
		JComboBox cb_Category = new JComboBox();
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
		springLayout.putConstraint(SpringLayout.NORTH, lblQuantityAvailable, 6, SpringLayout.NORTH, tf_qtyAvailable);
		springLayout.putConstraint(SpringLayout.WEST, lblQuantityAvailable, 0, SpringLayout.WEST, lblChooseACategory);
		add(lblQuantityAvailable);
		
		JLabel lblDiscountMember = new JLabel("Discount member");
		springLayout.putConstraint(SpringLayout.WEST, lblDiscountMember, 0, SpringLayout.WEST, lblChooseACategory);
		add(lblDiscountMember);
		
		tf_discountMember = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tf_discountMember, 270, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, tf_discountMember, 20, SpringLayout.EAST, lblDiscountMember);
		springLayout.putConstraint(SpringLayout.WEST, tf_qtyAvailable, 0, SpringLayout.WEST, tf_discountMember);
		springLayout.putConstraint(SpringLayout.SOUTH, tf_qtyAvailable, -40, SpringLayout.NORTH, tf_discountMember);
		springLayout.putConstraint(SpringLayout.NORTH, lblDiscountMember, 6, SpringLayout.NORTH, tf_discountMember);
		add(tf_discountMember);
		tf_discountMember.setColumns(10);
		
		tf_productType = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, tf_productType, -14, SpringLayout.NORTH, tf_qtyAvailable);
		springLayout.putConstraint(SpringLayout.EAST, tf_productType, 0, SpringLayout.EAST, tf_qtyAvailable);
		add(tf_productType);
		tf_productType.setColumns(10);
		
		JLabel lblProductName = new JLabel("Product Name");
		springLayout.putConstraint(SpringLayout.NORTH, lblProductName, 0, SpringLayout.NORTH, tf_productType);
		springLayout.putConstraint(SpringLayout.WEST, lblProductName, 0, SpringLayout.WEST, lblChooseACategory);
		add(lblProductName);
		
		JButton btnCreateProduct = new JButton("Create Product");
		springLayout.putConstraint(SpringLayout.NORTH, btnCreateProduct, 32, SpringLayout.SOUTH, tf_discountMember);
		springLayout.putConstraint(SpringLayout.WEST, btnCreateProduct, 0, SpringLayout.WEST, tf_qtyAvailable);
		add(btnCreateProduct);

	}
}
