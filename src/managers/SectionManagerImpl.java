package managers;

import java.util.List;

import daos.*;
import pojos.Section;


public class SectionManagerImpl implements ISectionManager {

	public List<Section> queryAll() {
		ISectionDao dao = new SectionDaoImpl();
		return dao.queryAll();
	}

}
