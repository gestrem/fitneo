package persist;

import core.ListProduct;
import core.Notification;
import core.AccessoryType;
import core.Activity;
import core.Basket;
import core.CategoryProduct;
import core.Event;
import core.Room;
import core.Product;
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
    public CategoryProduct createCategory(){
    	CategoryProduct category = new CategoryJDBC();
        return category;
    }
    
    @Override
    public Event createEvent(){
    	Event event = new EventJDBC();
        return event;
    }
    
    @Override
    public Notification createNotification(){    	
    	Notification notification = new NotificationJDBC();
        return notification;
    }
    
    @Override
    public ListProduct createListProduct(){
    	ListProduct product = new ListProductJDBC();
        return product;
    }
    
    @Override
    public ListRoom createListRoom(){
    	System.out.println("jdbckit");
    	ListRoom listRoom = new ListRoomJDBC();
        return listRoom;
    }

	@Override
	public Room createRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return null;
	}
}
