import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;

public class AddRecord {
	public static Configuration configuration;
	public static Connection connection;
	public static Admin admin;
	
	public static void addRecord(String tableName, String row, String[] fields, String[] values) throws IOException {
		init();
		Table table = connection.getTable(TableName.valueOf(tableName));
		for (int i = 0; i != fields.length; i++) {
			Put put = new Put(row.getBytes());
			String[] cols = fields[i].split(":");
			put.addColumn(cols[0].getBytes(), cols[1].getBytes(), values[i].getBytes());
			table.put(put);
		}
		table.close();
		close();
	}
	
	public static void init() {
		configuration = HBaseConfiguration.create();
		configuration.set("hbase.zookeeper.quorum", "172.20.10.4");
		try {
			connection = ConnectionFactory.createConnection(configuration);
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
		String[] fields = {"S_No:S_No", "S_Name:S_Name", "S_Sex:S_Sex", "S_Age:S_Age"};
		String[] values1 = {"2015001", "Zhangsan", "male", "23"};
		String[] values2 = {"2015002", "Mary", "female", "22"};
		String[] values3 = {"2015003", "Lisi", "male", "24"};
		String[] fields1 = {"C_No:C_No", "C_Name:C_Name", "C_Credit:C_Credit"};
		String[] values11 = {"123001", "Math", "2.0"};
		String[] values22 = {"123002", "Computer Science", "5.0"};
		String[] values33 = {"123003", "English", "3.0"};
		String[] fields2 = {"SC_Sno:SC_Sno", "SC_Cno:SC_Cno", "SC_Score:SC_Score"};
		String[] values111 = {"2015001", "123001", "86"};
		String[] values222 = {"2015001", "123003", "69"};
		String[] values333 = {"2015002", "123002", "77"};
		String[] values444 = {"2015002", "123003", "99"};
		String[] values555 = {"2015003", "123001", "98"};
		String[] values666 = {"2015003", "123002", "95"};
		
		try {
			addRecord("SC", "1", fields2, values111);
			addRecord("SC", "2", fields2, values222);
			addRecord("SC", "3", fields2, values333);
			addRecord("SC", "4", fields2, values444);
			addRecord("SC", "5", fields2, values555);
			addRecord("SC", "6", fields2, values666);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}


