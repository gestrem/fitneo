package persist;

import core.User;

public class XMLKit extends PersistKit {

     /**
     * Methode makeKit
     * @return un highscore du type choisit
     */

    @Override
    public User createUser() {

		User user = new UserXML();
		return user;
		
    }
}