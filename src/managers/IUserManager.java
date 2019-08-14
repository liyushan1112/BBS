package managers;

import java.util.List;

import pojos.User;


public interface IUserManager {
	public String login(String username, String password);
	public boolean register(User user);
	public List queryAll();
	public boolean modUser(User user);
	public List findUserByName(String name);
	public User findUserById(int id);
	public boolean delUserById(int id);
}
