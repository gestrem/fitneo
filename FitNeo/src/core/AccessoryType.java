package core;

import persist.PersistKit;

public abstract class AccessoryType {
	
	private String accessoryTypeName;
	
	private int idAccessory;
	
	public int getIdAccessory() {
		return idAccessory;
	}

	public void setIdAccessory(int idAccessory) {
		this.idAccessory = idAccessory;
	}

	private static AccessoryType accessory = null;
	
	public String getAccessoryTypeName() {
		return accessoryTypeName;
	}

	public void setAccessoryTypeName(String accessoryTypeName) {
		this.accessoryTypeName = accessoryTypeName;
	}

	
	
	public AccessoryType(){	
	}
	
	public static AccessoryType getInstance(int persistType){
		if (accessory == null)
			accessory = PersistKit.createKit(persistType).createAccessory();
		return accessory;
	}

}
