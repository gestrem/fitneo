package persist;

import core.User;

public abstract class PersistKit {

    /* L'instance de notre kit */
    private static PersistKit pesistKit = null;

    /* Les types de persistance possible */
    public static final int JDBC = 1;
    public static final int SERIALIZABLE = 2;
    public static final int XML = 3;

    /**
     * Methode makeKit
     * @return un user du type choisit
     */
    
    public abstract User makeKit();

    /**
     * Methode getInstance
     * @param type la persistance
     * @return le kit de persistance choisit
     */
    
    public static PersistKit getInstance(int type) {

        if (pesistKit == null) {

            if (type == JDBC) {

                pesistKit = new JDBCKit();

            } else  if (type == SERIALIZABLE) {

                pesistKit = new SerializableKit();

            } else  if (type == XML) {

                pesistKit = new XMLKit();
            } 
        }

        return pesistKit;
    }
}