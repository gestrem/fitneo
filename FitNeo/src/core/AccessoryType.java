package core;

<<<<<<< Updated upstream
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
=======
public class AccessoryType {
	
	public String accessoryName;
	public  Integer accessoryQuantity;
	
	
	
	//methodes
	
	public void addAccessory(Integer quantity){
		this.accessoryQuantity = this.accessoryQuantity + quantity ;
		}
	public void deleteAccessory(Integer quantity){
		if (this.accessoryQuantity > quantity) {
			this.accessoryQuantity = this.accessoryQuantity - quantity ;
		} 
		// Mettre execption quantite a supprimer superieur a quantite existante
>>>>>>> Stashed changes

	}	
}
