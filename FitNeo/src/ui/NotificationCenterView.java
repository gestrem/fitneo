package ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;

import core.Notification;
import core.NotificationFacade;
import core.UserFacade;

import javax.swing.border.LineBorder;

import java.awt.Color;

@SuppressWarnings("serial")
public class NotificationCenterView extends JPanel {

	private NotificationFacade notifFacade;
	private UserFacade userFacade;
	//type de persistance choisi
	private int persistType;
	
	/**
	 * Create the panel.
	 */
	public NotificationCenterView(int persistType) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout());
		this.persistType = persistType;	
		this.userFacade = new UserFacade(this.persistType);	
		this.notifFacade = new NotificationFacade(this.persistType);
		this.notifFacade.load(userFacade.getIdUser());	
		ArrayList<Notification> list = this.notifFacade.getListNotification();
		
		JLabel lblNewLabel = new JLabel("My notifications");
		
		Vector<String> columnNames = new Vector<String>();
        columnNames.add(0, "Source");
        columnNames.add(1, "Object");
        columnNames.add(2, "Date");
        columnNames.add(3, "Lu");
        
        Vector<Vector<String>> notifications = new Vector<Vector<String>>();
        
        JPanel notifPanel = new JPanel();
        notifPanel.setLayout(new GridLayout(0, 3));
        
        for (Notification notif : list) {         
            Vector<String> vectorNotification = new Vector<String>();
            vectorNotification.add(notif.getSender());
            vectorNotification.add(""+notif.getMessage());
            vectorNotification.add(""+notif.getDate());
            vectorNotification.add(""+notif.getIsRead());
            notifications.add(vectorNotification);
        }
		
        JTable table = new JTable(notifications, columnNames);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(new Color(139,0,0));
        table.getTableHeader().setFont(new Font("Arial Black", Font.BOLD, 18));
        table.setBackground(Color.BLACK);
        table.setForeground(Color.WHITE);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setGridColor(Color.WHITE);
        table.setRowHeight(20);
        table.setAutoCreateRowSorter(true);
        
        table.getTableHeader().setReorderingAllowed(false);
        table.setEnabled(false);
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.BLACK);
        table.setFillsViewportHeight(true);
		
        add(new JLabel("HIGHSCORE"), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
		

		

	}
}
