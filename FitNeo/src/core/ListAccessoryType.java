package core;
/**
 * @author  Guillaume
 * 
 */
import java.util.ArrayList;

import persist.PersistKit;

public abstract class ListAccessoryType {
	
	
	//Class Attribute
	private static ListAccessoryType myAccessoryTypeList = null;
	private ArrayList<AccessoryType> listAccessoryType = new ArrayList<AccessoryType>(); 

	
	
	public static ListAccessoryType getMyAccessoryTypeList() {
		return myAccessoryTypeList;
	}

	public  void setMyAccessoryTypeList(ArrayList<AccessoryType> myAccessoryTypeList) {
		this.listAccessoryType = myAccessoryTypeList;
	}
	
	
	public static ListAccessoryType getInstance(int persistType){
		if (myAccessoryTypeList == null)
			myAccessoryTypeList= PersistKit.createKit(persistType).createListAccessory();
		
		return myAccessoryTypeList;
	}
	
	public ListAccessoryType(){
		
	}
	
	
	/**
	 *addAccessoryToList
	 * @param accessoryType
	 */
	public void addAccessoryToList(AccessoryType accessoryType){
		listAccessoryType.add(accessoryType);
	}

	
	/**
	 *createAccessoryTypeJDBC crée un accessoire dans la bd
	 * @param accessoryType
	 */
	public abstract void createAccessoryTypeJDBC(String accessoryType);
	/**
	 *getAllAccessoryTypeJDBC instancie une liste d'accessoire
	 */
	public abstract void getAllAccessoryTypeJDBC();
	/**
	 *updateAccessoryTypeJDBC  met à jour un accessoire
	 * @param idAccessoryType 
	 * @param nameAccessoryType
	 */
	public abstract void updateAccessoryTypeJDBC(int idAccessoryType,String nameAccessoryType);
	/**
	 *deleteAccessoryTypeJDBC  supprime un accessoire
	 * @param idAccessoryType 
	 */
	public abstract void deleteAccessoryTypeJDBC(int idAccessoryType);
	
}
