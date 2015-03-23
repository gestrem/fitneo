package persist;

import core.ListCategory;
import core.ListEvent;
import core.ListNotification;
import core.ListProduct;
import core.AccessoryType;
import core.Notification;
import core.ListAccessoryType;
import core.Activity;
import core.Basket;
import core.ListRoom;
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
    
    @Override
    public Basket createBasket(){
        Basket basket = new BasketJDBC();
        return basket;
    }
    
    @Override
    public ListCategory createListCategory(){
    	ListCategory listcategory = new ListCategoryJDBC();
        return listcategory;
    }
    
    @Override
    public ListEvent createListEvent(){
    	ListEvent listevent = new ListEventJDBC();
        return listevent;
    }
    
    @Override
    public ListProduct createListProduct(){
    	ListProduct product = new ListProductJDBC();
        return product;
    }
    
    @Override
    public ListRoom createListRoom(){
    	ListRoom listRoom = new ListRoomJDBC();
        return listRoom;
    }
    
    /*
     * Ce qui reste � modifier
     * 
     */
    
  
    
    @Override
    public Activity createActivity(){
    	Activity activity = new ActivityJDBC();
        return activity;
    }
    
    @Override
    public ListNotification createListNotification(){    	
    	ListNotification notification = new ListNotificationJDBC();
        return notification;
    }

	@Override
	public ListAccessoryType createListAccessory() {
		ListAccessoryType accessory = new ListAccessoryJDBC();
        return accessory;
	}
}
