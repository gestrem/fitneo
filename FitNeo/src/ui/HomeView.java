package ui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
/**
 * 
 * @author Florent
 *
 */
@SuppressWarnings("serial")
public class HomeView extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomeView() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblHomeView = new JLabel("Welcome on FitNeo !!!");
		springLayout.putConstraint(SpringLayout.NORTH, lblHomeView, 31, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblHomeView, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, lblHomeView, 0, SpringLayout.EAST, this);
		lblHomeView.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomeView.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblHomeView);
		
		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 14, SpringLayout.SOUTH, lblHomeView);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -47, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblHomeView);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("./data/FitNeo-logo .png"));
		add(lblNewLabel);
		
		setVisible(true);
	}

}
