package core;

import persist.PersistKit;

public  class AccessoryType {
	
	private String accessoryTypeName;
	private int idAccessory;
	
	public AccessoryType(int idAccessory,String accessoryTypeName){
		this.accessoryTypeName=accessoryTypeName;
		this.idAccessory=idAccessory;
		
	}
	
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

	
	

	


}
