package persist;

import com.sun.nio.sctp.Notification;

import core.AccessoryType;
import core.Activity;
import core.Basket;
import core.CategoryProduct;
import core.Event;
import core.Product;
import core.Room;
import core.User;

public abstract class PersistKit {

    /* L'instance de notre kit */
    private static PersistKit persistKit = null;

    /* Les types de persistance possible */
    public static final int JDBC = 1;
    public static final int SERIALIZABLE = 2;
    public static final int XML = 3;


    /* Methodes create qui créer une classe metier du bon type de persistance */
    public abstract User createUser(); 
    public abstract Basket createBasket();
    public abstract AccessoryType createAccessory();
    public abstract Activity createActivity();
    public abstract CategoryProduct createCategory();
    public abstract Event createEvent();
    public abstract Notification createNotification();
    public abstract Product createProduct();
    public abstract Room createRoom();
    

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