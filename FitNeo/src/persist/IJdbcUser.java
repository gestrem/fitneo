package persist;

import core.User;

public interface IJdbcUser {
	public User getUser(String login);
}
