package persist;

import core.ListBasket;
import core.ListCategory;
import core.ListEvent;
import core.ListNotification;
import core.ListProduct;
import core.ListAccessoryType;
import core.Activity;
import core.User;
import core.ListRoom;

public abstract class PersistKit {

    /* L'instance de notre kit */
    private static PersistKit persistKit = null;

    /* Les types de persistance possible */
    public static final int JDBC = 1;
    public static final int SERIALIZABLE = 2;
    public static final int XML = 3;


    /* Methodes create qui create une classe metier du bon type de persistance */
    public abstract User createUser(); 
    public abstract ListBasket createListBasket();  
    public abstract ListCategory createListCategory();
    public abstract ListEvent createListEvent();  
    public abstract ListProduct createListProduct();
    public abstract ListRoom createListRoom();
    //reste � modifier ici
    public abstract ListAccessoryType createListAccessory();
    public abstract Activity createActivity();
    public abstract ListNotification createListNotification();
    

    /**
     * Methode getInstance
     * @param type la persistance
     * @return le kit de persistance choisit
     */
    
    public static PersistKit createKit(int type) {

        if (persistKit == null) {

            if (type == JDBC) {
            	
                persistKit = new JDBCKit();

            } else  if (type == SERIALIZABLE) {

                persistKit = new SerializableKit();

            } else  if (type == XML) {

                persistKit = new XMLKit();
            } 
        }

        return persistKit;
    }
}
