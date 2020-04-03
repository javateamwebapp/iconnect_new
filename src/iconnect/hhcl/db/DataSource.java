package iconnect.hhcl.db;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class DataSource {

    private static DataSource     datasource;
    private BoneCP connectionPool;
    
	private static final String DB_USERNAME="db.username";
	private static final String DB_PASSWORD="db.password";
	private static final String DB_URL ="db.url";
	private static final String DB_DRIVER_CLASS ="db.url";
	
	private static Properties properties = null;

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        try {
            // load the database driver (make sure this is in your classpath!)
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
			properties = new Properties();
			properties.load(new FileInputStream("C:\\iconnecttest\\database.properties"));
			
			BoneCPConfig boneCPConfig = new BoneCPConfig();
			boneCPConfig.setJdbcUrl(properties.getProperty(DB_URL));
			boneCPConfig.setUsername(properties.getProperty(DB_USERNAME));
			boneCPConfig.setPassword(properties.getProperty(DB_PASSWORD));
			
			//boneCPConfig.setDriverClassName(properties.getProperty(DB_DRIVER_CLASS));
			
			boneCPConfig.setMinConnectionsPerPartition(5);
			boneCPConfig.setMaxConnectionsPerPartition(10);
			boneCPConfig.setPartitionCount(4);
			boneCPConfig.setLazyInit(true);
			
			connectionPool = new BoneCP(boneCPConfig);
			 
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		/*
		 * try { // setup the connection pool using BoneCP Configuration BoneCPConfig
		 * config = new BoneCPConfig(); // jdbc url specific to your database, eg
		 * jdbc:mysql://127.0.0.1/yourdb
		 * config.setJdbcUrl("jdbc:mysql://localhost/test"); config.setUsername("root");
		 * config.setPassword("root"); config.setMinConnectionsPerPartition(5);
		 * config.setMaxConnectionsPerPartition(10); config.setPartitionCount(1); //
		 * setup the connection pool connectionPool = new BoneCP(config); } catch
		 * (Exception e) { e.printStackTrace(); return; }
		 */

    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.connectionPool.getConnection();
    }

}