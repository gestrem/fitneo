package core;

public class Notification {

	private String message;
	private String sender;
	private String date;
	private String categoryName;
	private int idNotification;
	private int idCategoryParent;
	//isRead renvoie vrai si la notification est lue
	private Boolean isRead; 
	//is Demand renvoie vrai si la notification correspond a une demande a valider 
	private Boolean isCreationDemand;
	
	/*
	 * Constructeur Notification simple
	 */
	public Notification(int idNotification, String sender, String message, boolean isRead, boolean isCreationDemand, String date){	
		this.idNotification=idNotification;
		this.sender=sender;
		this.message=message;
		this.isRead=isRead;
		this.isCreationDemand=isCreationDemand;	
		this.date = date;
	}
	
	/*
	 * Constructeur Notification avec demande de creation
	 */
	public Notification(int idNotification, String sender, String message, boolean isRead, boolean isCreationDemand, String date, String categoryName, int idCategoryParent){	
		this.idNotification=idNotification;
		this.sender=sender;
		this.message=message;
		this.isRead=isRead;
		this.isCreationDemand=isCreationDemand;	
		this.date = date;
		this.categoryName=categoryName;	
		this.idCategoryParent = idCategoryParent;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getIdCategoryParent() {
		return idCategoryParent;
	}

	public void setIdCategoryParent(int idCategoryParent) {
		this.idCategoryParent = idCategoryParent;
	}

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}
	
}
