package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.User;
import util.DbUtil;



public class UserDaoImpl implements IUserDao {
	

	private Connection connection = null;
	private PreparedStatement pstatement = null;
	private String sql = "";

	public PreparedStatement init(String sql) {
		connection = DbUtil.getConnection();
		try {
			pstatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstatement;

	}

	public void close(PreparedStatement pstat, Connection conn) {
		DbUtil.closeConnection(conn);
		DbUtil.closePStat(pstat);
	}

	public String login(String username, String password) {
		sql = "select id,password,is_admin from bbs_user where username ='"
				+ username + "'";
		PreparedStatement pstat = init(sql);
		try {
			
			ResultSet rs = pstat.executeQuery(sql);
			while(rs.next()) {
				if (rs.getString("password").equals(password)) {
					String info = rs.getString("id") + "#"
							+ rs.getString("is_admin");
					close(pstatement, connection);
					
					return info;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstatement, connection);
		return null;
	}

	
	public boolean register(User user) {

		sql = "insert into bbs_user(password,username,realname,sex,tel,favorite,is_admin,home) values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstat = init(sql);
	
			pstat.setString(1, user.getPassword());
			pstat.setString(2, user.getUserName());
			pstat.setString(3, user.getRealname());
			pstat.setString(4, user.getSex());
			pstat.setString(5, user.getTel());
			pstat.setString(6, user.getFavorite());
			pstat.setInt(7, 0);
			pstat.setString(8, user.getHome());

			pstat.executeUpdate();

			close(pstat, connection);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 查询所有用户
	 */
	public List<User> queryAll() {
		sql = "select id,username from bbs_user";
		List<User> allUser = new ArrayList<User>();
		PreparedStatement pstat = init(sql);
		try {
			ResultSet rs = pstat.executeQuery(sql);
			while(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			allUser.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(pstat, connection);
		return allUser;
	}
/*
 * (non-Javadoc)
 * @see com.ch07.daos.IUserDao#modUser(com.ch07.pojos.User)
 * 修改用户的信息
 */
	public boolean modUser(User user) {
		sql = "update bbs_user set username='"+user.getUserName()+"'"+",realname= '"+user.getRealname()+"'"
				+",password= '"+user.getPassword()+"'"+",sex= '"+user.getSex()+"'"
				+" ,tel= '"+user.getTel()+"'"+",favorite= '"+user.getFavorite()+"'"
				+",home= '"+user.getHome()+"'"+"where id = ' "+user.getId()+"'";
		PreparedStatement pstat = init(sql);
		try {
			pstat.execute();
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
/*
 * (non-Javadoc)
 * @see com.ch07.daos.IUserDao#delUserById(int)
 * 根据用户id删除用户信息
 */
	public boolean delUserById(int id) {
			sql = "delete from bbs_user where id = '"+id+"'";
			boolean result = false;
			PreparedStatement pstat = init(sql);
			try {
				result=pstat.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close(pstat, connection);
		return result;
	}
	/**
	 * 查询用户信息
	 */
	public List<User> findUserByName(String name) {
		sql = "select * from bbs_user where username ='"+name+"'";
		List<User> allUser = new ArrayList<User>();
		PreparedStatement pstat = init(sql);
		
		try {
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setRealname(rs.getString("realname"));
			user.setFavorite(rs.getString("favorite"));
			user.setPassword(rs.getString("password"));
			user.setHome(rs.getString("home"));
			user.setSex(rs.getString("sex"));
			user.setAdmin(rs.getInt("is_admin"));
			user.setTel(rs.getString("tel"));
			allUser.add(user);
			}
			close(pstat, connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return allUser;
	}

	public User findUserById(int id) {
		sql = "select * from bbs_user where id ='"+id+"'";
		PreparedStatement pstat = init(sql);
		User user = new User();
		try {
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setRealname(rs.getString("realname"));
			user.setFavorite(rs.getString("favorite"));
			user.setPassword(rs.getString("password"));
			user.setHome(rs.getString("home"));
			user.setSex(rs.getString("sex"));
			user.setAdmin(rs.getInt("is_admin"));
			user.setTel(rs.getString("tel"));
			}
			close(pstat, connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
		
	}

}
