package framelib.dfs;

import java.io.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 *Title:DFSFactory 
 *Description:
 *@Create_by:songxianjia
 *@Create_date:2013-11-11
 *@Last_Edit_By:
 *@Edit_Description
 *@version:baoogu 1.0
 */

public class FastDFSFactory {
	private static Log log = LogFactory.getLog(FastDFSFactory.class);
	private static StorageClient storageClient = null;
	static {
		try {
			String classPath = new File(FastDFSFactory.class.getResource("/").getFile()).getCanonicalPath();
			String configFilePath = classPath + File.separator + "config/resources/fdfs_client.conf";	
			String path = configFilePath.replaceAll("%20", " ");
			ClientGlobal.init(path);
			ClientGlobal.setG_connect_timeout(2000);
			ClientGlobal.setG_network_timeout(3000);
			TrackerClient trackerClient = new TrackerClient();
			TrackerServer trackerServer = trackerClient.getConnection();	
			StorageServer storageServer = null;
			storageClient = new StorageClient(trackerServer, storageServer);
		} catch (Exception e) {
			log.error("初始化DFSFactory失败");
			e.printStackTrace();
		}
	}

	public static StorageClient getInstance() {
		return storageClient;
	}
}
