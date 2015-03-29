package fitneo;

import java.sql.SQLException;
import java.util.ArrayList;

import core.ListCategory;
import core.ListProduct;
import core.Product;
import ui.LoginUI;
import persist.PersistKit;

public class Main {

    /**
     * @param args the command line arguments
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
    	
        /* Les differents choix de persistances  
         * 
         * 0 pour JDBC
         * 1 pour Fichier
         * 2 pour XML
         * 
         * */


    	/*ListProduct liste= ListProduct.getInstance(PersistKit.JDBC);

        liste.getAllProductByCategory(2);
        ArrayList<Product> liste2 = liste.getListAllProduct();
        System.out.println(liste2);

        liste.updateProduct("tapis pour chaval", 10, 12, 6, 2, 4, 1);
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
