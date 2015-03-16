package persist;

import core.User;

public class SerializableKit extends PersistKit {

    /**
     * Methode makeKit
     * @return un highscore du type choisit
     */
    
    @Override
    public User createUser() {

    	User user = new UserSerializable();
    	return user;

    }
}