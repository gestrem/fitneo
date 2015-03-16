package persist;

import core.User;

public class JDBCKit extends PersistKit {

    /**
     * Methode makeKit
     * @return un user du type choisit
     */

    @Override
    public User createUser() {
    	
        User user = new UserJDBC();
        return user;
     
    }
}