package core;
/**
 * @author gestrem
 */


public class AccessoryType {

	
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

	public static AccessoryType getAccessory() {
		return accessory;
	}

	public static void setAccessory(AccessoryType accessory) {
		AccessoryType.accessory = accessory;
	}

	
	

	


}
