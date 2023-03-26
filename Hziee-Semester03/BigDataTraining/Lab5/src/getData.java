import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class getData {
	public static Configuration configuration;
	public static Connection connection;
	public static Admin admin;
	public static Map<String, String> map = new HashMap<String, String>();
	public static String res = "";
	
	public static void bindData(String tableName, String column) throws IOException {
		init();
		Table table = connection.getTable(TableName.valueOf(tableName));
		Scan scan = new Scan();
		scan.addFamily(Bytes.toBytes(column));
		ResultScanner scanner = table.getScanner(scan);
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			Cell[] cells = result.rawCells();
			for (Cell cell : cells) {
				map.put(new String(CellUtil.cloneRow(cell)), new String(CellUtil.cloneValue(cell)));
			}
		}
		table.close();
		close();
	}
	
	public static void scanColumn(String tableName, String column, String id) throws IOException {
		init();
		Table table = connection.getTable(TableName.valueOf(tableName));
		Scan scan = new Scan();
		scan.addFamily(Bytes.toBytes(column));
		ResultScanner scanner = table.getScanner(scan);
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			showCell(result, id);
		}
		table.close();
		close();
	}
	
	public static void scanColumn1(String tableName, String id) throws IOException {
		init();
		Table table = connection.getTable(TableName.valueOf(tableName));
		Scan scan = new Scan();
		ResultScanner scanner = table.getScanner(scan);
		for (Result result = scanner.next(); result != null; result = scanner.next()) {
			String row = getSno(result, id);
            if (!(getSno(result, id).equals("no"))) {
                showCell1(result, row);
            }
		}
		table.close();
		close();
	}
	
	public static void showCell(Result result, String id) {
		Cell[] cells = result.rawCells();
		for (Cell cell : cells) {
			if (new String(CellUtil.cloneRow(cell)).equals(id)) {
				res += new String(CellUtil.cloneQualifier(cell)) + ":" + new String(CellUtil.cloneValue(cell)) + "\n";
			}
		}
	}
	
	public static String getSno(Result result, String id) {
		Cell[] cells = result.rawCells();
		for (Cell cell : cells) {
			if (new String(CellUtil.cloneQualifier(cell)).equals("SC_Sno")) {
                if (new String(CellUtil.cloneValue(cell)).equals(id)) {
                    return new String(CellUtil.cloneRow(cell));
                } else {
                    return "no";
                }
			}
		}
		return "no";
	}
	
	
	public static void showCell1(Result result, String id) {
		Cell[] cells = result.rawCells();
		for (Cell cell : cells) {
			if (new String(CellUtil.cloneRow(cell)).equals(id)) {
				if (new String(CellUtil.cloneQualifier(cell)).equals("SC_Cno")) {
					res += "课程号:" + new String(CellUtil.cloneValue(cell)) + ";课程名:" + map.get(new String(CellUtil.cloneValue(cell))) + "\n";
				} else if (new String(CellUtil.cloneQualifier(cell)).equals("SC_Score")) {
                    res += "成绩:" + new String(CellUtil.cloneValue(cell)) + "分\n";
                }
			}
		}
	}
	
	public static void init() {
		configuration = HBaseConfiguration.create();
		configuration.set("hbase.zookeeper.quorum", "192.168.18.128");
		try {
			connection = ConnectionFactory.createConnection(configuration);
			admin = connection.getAdmin();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 关闭连接
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
		try {
			Scanner sc = new Scanner(System.in);
			String id = sc.next();
			bindData("Course", "C_Name");
			scanColumn("Student", "S_No", id);
			scanColumn("Student", "S_Name", id);
			scanColumn("Student", "S_Sex", id);
			scanColumn("Student", "S_Age", id);
			scanColumn1("SC", id);
			System.out.println(res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

