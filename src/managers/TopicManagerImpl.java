package managers;

import java.util.List;

import daos.*;
import pojos.Topic;
import util.Page;


public class TopicManagerImpl implements ITopicManager {
	
	private ITopicDao dao;
	
	public TopicManagerImpl(){
		dao = new TopicDaoImpl();
	}

	public void addTopic(Topic topic) {
		dao.addTopic(topic);
		
	}

	public Topic findByid(int id) {
		return dao.getById(id);

	}

	public List<Topic> queryAll(int id) {
		List<Topic> allTopic = dao.queryAll(id);
		return allTopic;
		
		
		
	}

	public Topic findByid() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Topic> queryOne(int id) {
		List<Topic> OneTopic = dao.queryOne(id);
		return OneTopic;
	}

	public int getTotalRow(int id,int type) {
		// TODO Auto-generated method stub
		return dao.getTotalRow(id,type);
	}

	public List<Topic> queryOnePage(Page page, int id) {
		// TODO Auto-generated method stub
		return dao.queryOnePage(page, id);
	}

}
