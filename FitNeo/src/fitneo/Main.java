package fitneo;

import java.sql.SQLException;
import java.util.Iterator;

import core.CategoryProduct;
import core.ListCategory;
import core.ListProduct;
import core.Product;
import ui.LoginUI;
import core.ListAccessoryType;
import persist.PersistKit;
import core.ListRoom;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	/*
    	 * AFFICHE LISTE CATEGORIE
		public static void main(String[] args) throws SQLException {
    	ListProduct liste= ListProduct.getInstance(PersistKit.JDBC);
    	liste.getAllProduct();
    	liste.updateProduct("tapis pour chaval", 10, 12, 6, 1, 4);
    	
    	ListCategory liste= ListCategory.getInstance(PersistKit.JDBC);
    	liste.getAllCategories();
    	Iterator it= liste.getListAllCategories().iterator();

    	/*ListProduct liste= ListProduct.getInstance(PersistKit.JDBC);
    	liste.getAllProduct();
    	Iterator it= liste.getListAllProduct().iterator();
    	while ( it.hasNext()) {
    		System.out.println(it.next().toString());
    	} */
    	
    	/* CREE UNE CATEGORIE
    	 *  
    	 ListCategory liste= ListCategory.getInstance(PersistKit.JDBC);
    	
    	String catName =  "Streching"; 
    	try {
			liste.insertCategoryWithSuperCategoryJDBC(catName, 5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}*/
    	
    	/* UPDATE UNE CATEGORIE
    	 * 
    	 ListCategory liste= ListCategory.getInstance(PersistKit.JDBC);
    	
    	
    	try {
			liste.updateCategoryWithNameJDBC(6, "YOYO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} */
    	
    	/* DELETE UNE CATEGORIE
    	 * */
    	 /*ListCategory liste= ListCategory.getInstance(PersistKit.JDBC);
    	
    	
    	try {
			liste.deleteCategoryJDBC(6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} */
    	
    	
    	
        /* Les differents choix de persistances 
         * 
         * 0 pour JDBC
         * 1 pour Fichier
         * 2 pour XML
         * 
         * */
       /* ListAccessoryType listAccessoryType= ListAccessoryType.getInstance(PersistKit.JDBC);
        listAccessoryType.createAccessory("poids 20kg");
    	System.out.println("test accessory");*/

        /*
    	ListRoom listroom=ListRoom.getInstance(PersistKit.JDBC);
    	System.out.println("test");
    	listroom.createRoom("20m", "Cours");
    	listroom.createRoom("30m","repos");
    	listroom.updateListRoom(1,"40m2","Concert",20);
    	listroom.createListRoom(0);
    	listroom.getListRoom();
    	System.out.println("Fait");
    	*/
        /* Choix du type de persistance */
        int typePersist = 0;

        /* On charge notre fenetre avec le type souhaite */
        switch (typePersist) {
            case 0: new LoginUI(PersistKit.JDBC); break;
            case 1: new LoginUI(PersistKit.SERIALIZABLE); break;
            case 2: new LoginUI(PersistKit.XML); break;
            default :  new LoginUI(PersistKit.JDBC); break;
        }
        
    }
}
