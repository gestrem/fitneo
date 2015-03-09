package fitneo;

import ui.LoginView;

import persist.PersistKit;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Les differents choix de persistances 
         * 
         * 0 pour JDBC
         * 1 pour Fichier
         * 2 pour XML
         * 
         * */
        

        /* Choix du type de persistance */
        int typePersist = 0;

        /* On charge notre fenetre avec le type souhaite */
        switch (typePersist) {
            case 0: new LoginView(PersistKit.JDBC); break;
            case 1: new LoginView(PersistKit.SERIALIZABLE); break;
            case 2: new LoginView(PersistKit.XML); break;
            default :  new LoginView(PersistKit.JDBC); break;
        }
    }
}