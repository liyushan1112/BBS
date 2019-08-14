package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Topic;
import util.DbUtil;
import util.Page;



public class TopicDaoImpl implements ITopicDao {
	private Connection connection = null;
	private PreparedStatement pstatement = null;
	private int totalRow = 0;


	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	

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

	public boolean addTopic(Topic Topic) {

		String sql = "insert into bbs_topic(userid,pid,title,content,creat_date,sid) values (?,?,?,?,?,?)";
		try {
			PreparedStatement pstat = init(sql);
			pstat.setInt(1, Topic.getUserid());
			pstat.setInt(2, Topic.getPid());
			pstat.setString(3, Topic.getTitle());
			pstat.setString(4, Topic.getContent());
			pstat.setTimestamp(5, Topic.getCreatDate());
			pstat.setInt(6, Topic.getSid());
			pstat.executeUpdate();

			close(pstat, connection);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
	
	public Topic getById(int id) {
		Topic Topic = null;
		String sql = "select * from bbs_topic where id =\"" + id + "\"";
		PreparedStatement pstat = init(sql);
		try {
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Topic tTopic = new Topic();
				tTopic.setContent(rs.getString("Content"));
				tTopic.setTitle(rs.getString("title"));
				Topic = tTopic;
			}
			rs.close();
			close(pstat, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Topic;
	}

	public Topic getByTitle(String title) {

		return null;
	}

	public List<Topic> queryAll(int sid) {
		List<Topic> allTopic = new ArrayList<Topic>();
		String sql = "select * from bbs_topic where pid = '" + 0
				+ "' and sid = '" + sid + "'";
		PreparedStatement pstat = init(sql);
		try {
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Topic Topic = new Topic();
				Topic.setId(rs.getInt("id"));
				Topic.setUserid(rs.getInt("userid"));
				Topic.setPid(rs.getInt("pid"));
				Topic.setTitle(rs.getString("title"));
				Topic.setCreatDate(rs.getTimestamp("creat_date"));
				Topic.setContent("");
				Topic.setSid(sid);
				allTopic.add(Topic);
			}
			rs.close();
			close(pstat, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allTopic;
	}

	public List<Topic> queryOne(int id) {
		List<Topic> allTopic = new ArrayList<Topic>();
		String sql = "select * from bbs_topic where pid = '" + id
				+ "' or id = '" + id + "'" + "order by id";
		PreparedStatement pstat = init(sql);
		try {
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Topic Topic = new Topic();
				Topic.setId(rs.getInt("id"));
				Topic.setUserid(rs.getInt("userid"));
				Topic.setPid(rs.getInt("pid"));
				Topic.setTitle(rs.getString("title"));
				Topic.setContent(rs.getString("Topic"));
				Topic.setCreatDate(rs.getTimestamp("creat_date"));
				allTopic.add(Topic);
			}
			rs.close();
			close(pstat, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allTopic;
	}
	

	public List<Topic> queryOnePage(Page page, int id) {
		List<Topic> allTopic = new ArrayList<Topic>();
		String sql = "select * from bbs_topic where pid = '" + id
				+ "' or id = '" + id + "'" + "order by id";
		PreparedStatement pstat = init(sql);
		try {
		
			pstat.setMaxRows(page.getPageSize() * page.getCurrentPage());
			ResultSet rs = pstat.executeQuery();
			
			if (page.getFirstRow() > 0) {//关键语句：调整首行记录位置
				rs.absolute(page.getFirstRow());
			}

			while (rs.next()) {
				Topic Topic = new Topic();
				Topic.setId(rs.getInt("id"));
				Topic.setUserid(rs.getInt("userid"));
				Topic.setPid(rs.getInt("pid"));
				Topic.setTitle(rs.getString("title"));
				Topic.setContent(rs.getString("content"));
				Topic.setCreatDate(rs.getTimestamp("creat_date"));
				allTopic.add(Topic);
			}
			rs.close();
			close(pstat, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allTopic;
	}

	public boolean delTopic(Topic Topic) {

		String sql = "delete from bbs_topic where id = ?";
		try {
			PreparedStatement pstat = init(sql);
			pstat.setInt(1, Topic.getId());
			pstat.executeUpdate();

			close(pstat, connection);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
		// TODO Auto-generated method stub

	}
	
	public int getTotalRow(int id,int type){
		//type 1:id = sid
		//type 2:id = pid
		String sql = null;
		if(type==1){
		 sql = "select count(*) from bbs_topic where pid = '" + 0
				+ "' and sid = '" + id + "'" ;}
		else if(type==2){
		 sql = "select count(*) from bbs_topic where pid = '" + id
					+ "' or id = '" + id + "'" ;
				}
		int totalRow = 0;
		PreparedStatement pstat = init(sql);
		try {
			
			ResultSet rs = pstat.executeQuery();
			while(rs.next()){
				totalRow=rs.getInt(1);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		close(pstat, connection);
		return totalRow;
	}
	

}
