package daos;
import java.util.List;

import pojos.*;
import util.Page;


public interface ITopicDao {

		public boolean addTopic(Topic topic);               //添加帖子
		public boolean delTopic(Topic topic);               //删除帖子
		public Topic getById(int id);                       //根据ID取得帖子
		public Topic getByTitle(String title);              //根据名称取得帖子
		public List<Topic> queryAll(int sid);               //取得sid相关的所有信息
		public List<Topic> queryOne(int id);                //取得id相关的帖子
		public List<Topic> queryOnePage(Page page, int pid); //按参数取得一页帖子
		public int getTotalRow(int sid, int type);           //取得记录总数
	
}
