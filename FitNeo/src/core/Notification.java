package core;

public class Notification {

	private String message;
	private String sender;
	//isRead renvoie vrai si la notification est lue
	private Boolean isRead; 
	//is Demand renvoie vrai si la notification correspond a une demande a valider 
	private Boolean isCreationDemand;
	
	public Notification(String sender, String message, boolean isRead, boolean isCreationDemand){	
		this.sender=sender;
		this.message=message;
		this.isRead=isRead;
		this.isCreationDemand=isCreationDemand;	
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public Boolean getIsCreationDemand() {
		return isCreationDemand;
	}

	public void setIsCreationDemand(Boolean isCreationDemand) {
		this.isCreationDemand = isCreationDemand;
	}
	
	public String toString(){
		return this.sender+" "+this.message+" "+this.isCreationDemand;
	}
	
}
