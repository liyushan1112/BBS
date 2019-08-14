package managers;

import java.util.List;

import daos.IUserDao;
import daos.UserDaoImpl;
import pojos.User;


public class UserManagerImpl implements IUserManager{
	private IUserDao dao;
	
	public UserManagerImpl(){
		dao=new UserDaoImpl();
	}

	public String login(String username, String password) {
		
		return dao.login(username, password);
	}
	
	public boolean register(User user){
		
		
		return dao.register(user);
	}

	public List queryAll() {
	
		return dao.queryAll();
	}

	public boolean modUser(User user) {
		return dao.modUser(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findUserByName(String name) {
			
		return dao.findUserByName(name);
	}

	public User findUserById(int id) {
		return dao.findUserById(id);
	}

	public boolean delUserById(int id) {
		// TODO Auto-generated method stub
		return dao.delUserById(id);
	}
	
	

}
