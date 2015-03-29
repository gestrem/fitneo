package persist;

import core.ListAccessoryType;
import core.ListActivity;
import core.ListBasket;
import core.ListCategory;
import core.ListEvent;
import core.ListNotification;
import core.ListProduct;
import core.ListRoom;
import core.User;
/**
 * 
 * @author Florent
 *
 */
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

	@Override
	public ListBasket createListBasket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListCategory createListCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListEvent createListEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListProduct createListProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListRoom createListRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListAccessoryType createListAccessory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListActivity createListActivity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListNotification createListNotification() {
		// TODO Auto-generated method stub
		return null;
	}
}