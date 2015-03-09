package persist;

import core.User;

public class JDBCKit extends PersistKit {

    /**
     * Methode makeKit
     * @return un user du type choisit
     */

    @Override
    public User makeKit() {
        
        return User.getInstance(PersistKit.JDBC);
        
    }
}