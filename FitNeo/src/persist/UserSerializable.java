package persist;

import core.User;
/**
 * 
 * @author Florent
 *
 */
public class UserSerializable extends User {

	@Override
	public void setUser(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String changePassword(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyMail(String mail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerUser(String userLastName, String userFirstName,
			String userAdresse, String userCity, String userCP,
			String userEmail, String passwordUser, String userAnswer,
			int idquestion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadInscription() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unscribeEvent(int idevent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeEvent(int idevent) {
		// TODO Auto-generated method stub
		
	}

}
