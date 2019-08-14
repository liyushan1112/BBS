package managers;
import java.util.List;

import pojos.Topic;
import util.Page;



public interface ITopicManager {
	public void addTopic(Topic topic);
	public Topic findByid(int id);
	public List<Topic> queryAll(int sid);
	public List<Topic> queryOne(int id);
	public List<Topic> queryOnePage(Page page, int id);
	public int getTotalRow(int id, int type);
	
}