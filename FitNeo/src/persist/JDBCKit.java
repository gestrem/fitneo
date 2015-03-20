package persist;

import com.sun.nio.sctp.Notification;

import core.AccessoryType;
import core.Activity;
import core.Basket;
import core.CategoryProduct;
import core.Event;
import core.ListCategory;
import core.ListEvent;
import core.Product;
import core.Room;
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
    public AccessoryType createAccessory(){
    	AccessoryType accessory = new AccessoryJDBC();
        return accessory;
    }
    
    @Override
    public Activity createActivity(){
    	Activity activity = new ActivityJDBC();
        return activity;
    }
    
    @Override
    public ListCategory createListCategory(){
    	ListCategory listCategory = new CategoryJDBC();
        return listCategory;
    }
    
    @Override
    public ListEvent createListEvent(){
    	ListEvent listEvent = new EventJDBC();
        return listEvent;
    }
    
    @Override
    public Notification createNotification(){    	
    	Notification notification = new NotificationJDBC();
        return notification;
    }
    
    @Override
    public Product createProduct(){
    	Product product = new ProductJDBC();
        return product;
    }
    
    @Override
    public Room createRoom(){
    	Room room = new RoomJDBC();
        return room;
    }
}