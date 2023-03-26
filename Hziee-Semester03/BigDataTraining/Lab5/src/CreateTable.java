import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class CreateTable {
    public static Connection connection;
	public static Admin admin;
	
	public static void createTable(String tableName, String[] fields) throws IOException {
		init();
		TableName tablename = TableName.valueOf(tableName);
		if (admin.tableExists(tablename)) {
			admin.disableTable(tablename);
			admin.deleteTable(tablename);
		}
		HTableDescriptor hTableDescriptor = new HTableDescriptor(tablename);
		for (String str : fields) {
			HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(str);
			hTableDescriptor.addFamily(hColumnDescriptor);
		}
		admin.createTable(hTableDescriptor);
		close();
	}
	
	public static void init() {
		Configuration con = new Configuration();
		con.set("hbase.zookeeper.quorum", "172.20.10.4");
		try {
			connection = ConnectionFactory.createConnection(con);
			admin = connection.getAdmin();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			if (admin != null) {
				admin.close();
			}
			if (null != connection) {
				connection.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String[] fields = {"S_No", "S_Name", "S_Sex", "S_Age"};
		try {
			createTable("Student", fields);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
