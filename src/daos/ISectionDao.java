package daos;

import java.util.List;

import pojos.Section;



public interface ISectionDao {
	public boolean addSection(Section section);
	public boolean delSectionById(int id);
	public List queryAll();
}
