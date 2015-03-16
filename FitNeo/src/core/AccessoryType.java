package core;

import persist.PersistKit;

public abstract class AccessoryType {
	
	private String accessoryTypeName; 
	
	private static AccessoryType accessory = null;
	
	public AccessoryType(){	
	}
	
	public static AccessoryType getInstance(int persistType){
		if (accessory == null)
			accessory = PersistKit.createKit(persistType).createAccessory();
		return accessory;
	}

}
