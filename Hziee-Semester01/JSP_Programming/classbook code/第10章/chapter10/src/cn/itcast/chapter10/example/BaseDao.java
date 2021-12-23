package cn.itcast.chapter10.example;
import java.sql.Connection;                                                                                                                                             
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.ResultSetHandler;
public class BaseDao {
 	// 优化查询
 	public static Object query(String sql, ResultSetHandler<?> rsh, 
		                       Object... params) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 定义一个返回结果
		Object obj = null;
		try {
			// 获得连接
			conn = JDBCUtils.getConnection();
			// 预编译sql
			pstmt = conn.prepareStatement(sql);
			// 将参数设置进去
			for (int i = 0; params != null && i < params.length; i++)
			  {
				pstmt.setObject(i + 1, params[i]);
			}
			// 发送sql
			rs = pstmt.executeQuery();
			// 让调用者去实现对结果集的处理
			obj = rsh.handle(rs);
		} catch (Exception e) {
			// 出现异常，返回封装的异常信息
			return new Exception(e.getMessage());
		}finally {
			// 释放资源
			JDBCUtils.release(rs, pstmt, conn);
		}
		return obj;
 	}
}
