package fitneo;

import java.util.Iterator;

import core.ListProduct;
import ui.LoginUI;

import persist.PersistKit;
import core.ListRoom;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	ListProduct liste= ListProduct.getInstance(PersistKit.JDBC);
    	liste.getAllProduct();
    	Iterator it= liste.getListAllProduct().iterator();
    	while ( it.hasNext()) {
    		System.out.println(it.next().toString());
    	}
        /* Les differents choix de persistances 
         * 
         * 0 pour JDBC
         * 1 pour Fichier
         * 2 pour XML
         * 
         * */
        
    	ListRoom listroom=ListRoom.getInstance(PersistKit.JDBC);
    	System.out.println("test");
    	listroom.createRoom("20m", "Cours");
    	listroom.createRoom("30m","repos");
    	//listroom.updateListRoom(1,"40m2","Concert",20);
    	listroom.createListRoom(0);
    	listroom.getListRoom();
    	System.out.println("Fait");
    	
    	
    	
        /* Choix du type de persistance */
        int typePersist = 0;

        /* On charge notre fenetre avec le type souhaite */
        /*
        switch (typePersist) {
            case 0: new LoginUI(PersistKit.JDBC); break;
            case 1: new LoginUI(PersistKit.SERIALIZABLE); break;
            case 2: new LoginUI(PersistKit.XML); break;
            default :  new LoginUI(PersistKit.JDBC); break;
$        }
        
        }*/
    }
}
