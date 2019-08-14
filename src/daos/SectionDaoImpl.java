package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Section;
import util.DbUtil;



public class SectionDaoImpl implements ISectionDao {

	private Connection connection = null;
	private PreparedStatement pstatement = null;

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

	public boolean addSection(Section section) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delSectionById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Section> queryAll() {
		List<Section> allSection = new ArrayList<Section>();
		String sql = "select * from bbs_section";
		PreparedStatement pstat = init(sql);
		try {
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Section section = new Section();
				section.setId(rs.getInt("id"));
				section.setName(rs.getString("name"));
				allSection.add(section);
			}
			rs.close();
			close(pstat, connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allSection;

	}

}
