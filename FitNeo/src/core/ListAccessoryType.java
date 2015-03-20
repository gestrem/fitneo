package core;

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
	
	public void createAccessory(String accessoryType){
		createAccessoryTypeJDBC(accessoryType);
	}

	public void addAccessoryToList(AccessoryType accessoryType){
		listAccessoryType.add(accessoryType);
	}

	public void getAllAccessoryType(){
		
		getAllAccessoryTypeJDBC();
	}
	
	public abstract void createAccessoryTypeJDBC(String accessoryType);
	public abstract void getAllAccessoryTypeJDBC();
;

}
