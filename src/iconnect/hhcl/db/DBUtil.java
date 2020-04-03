package iconnect.hhcl.db;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
/*
 * @author KK JavaTutorials
 * Utility class which is responsible to get JDBC connection object using 
 * BoneCP DataSource connection pool With MYSQL Database.
 */
public class DBUtil {
	private static final String DB_USERNAME="db.username";
	private static final String DB_PASSWORD="db.password";
	private static final String DB_URL ="db.url";
	private static final String DB_DRIVER_CLASS ="db.url";
	
	private static Properties properties = null;
	private static BoneCP dataSource=null;
	static{
		try {
			properties = new Properties();
			properties.load(new FileInputStream("C:\\iconnecttest\\database.properties"));
			
			BoneCPConfig boneCPConfig = new BoneCPConfig();
			boneCPConfig.setJdbcUrl(properties.getProperty(DB_URL));
			boneCPConfig.setUsername(properties.getProperty(DB_USERNAME));
			boneCPConfig.setPassword(properties.getProperty(DB_PASSWORD));
			
			//boneCPConfig.setDriverClassName(properties.getProperty(DB_DRIVER_CLASS));
			
			boneCPConfig.setMinConnectionsPerPartition(5);
			boneCPConfig.setMaxConnectionsPerPartition(100);
			boneCPConfig.setPartitionCount(4);
			boneCPConfig.setLazyInit(true);
			
			dataSource = new BoneCP(boneCPConfig);
			 
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * public static DBUtil getDataSource(){
	 * 
	 * if (dataSource == null) { dataSource = new dataSource(); return dataSource; }
	 * else { return dataSource; } }
	 */
	/*
	 * public static Connection getConnection(){ try { return
	 * dataSource.getConnection(); } catch (SQLException e) { e.printStackTrace(); }
	 * return null; }
	 */
	
	
	
}