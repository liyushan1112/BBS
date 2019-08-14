package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class DbUtil {
	 //驱动程序名
	private static String driver = "com.mysql.cj.jdbc.Driver";
    //URL指向要访问的数据库名mydata
	private static String url = "jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    //MySQL配置时的用户名
	private static String user = "root";
    //MySQL配置时的密码
	private static String password = "19971112";
		
		//数据库连接
		public static Connection getConnection(){
			try {
				Class.forName(driver);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
		//关闭数据库连接
		public static boolean closeConnection(Connection conn){
			try {
				conn.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		public static boolean closePStat(PreparedStatement pstat){
			try {
				pstat.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}

		public static boolean closeStat(Statement stat){
			try {
				stat.close();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
}
