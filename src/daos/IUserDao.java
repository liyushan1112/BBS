package daos;

import java.util.List;

import pojos.User;


public interface IUserDao {
	

	public String login(String useername, String password); //用户登录

	public boolean register(User user);                    //用户注册
	
	public List queryAll();                                //查询所有用户
	
	public boolean modUser(User user);                     //修改用户信息
	
	public boolean delUserById(int id);                    //删除指定id的用户
	
	public List findUserByName(String name);               //通过用户名查找用户
	
	public User findUserById(int id);                      //通过id查找用户
	
}
