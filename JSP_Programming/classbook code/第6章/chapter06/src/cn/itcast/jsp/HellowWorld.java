package cn.itcast.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.runtime.HttpJspBase;
/**
 * ��ʹ�ø���鿴HttpJspBase���Դ����
 * @author admin
 *
 */
public class HellowWorld {
        HttpJspBase httpJspBase = new HttpJspBase() {
		@Override
		public void _jspService(HttpServletRequest arg0, HttpServletResponse arg1)
				throws ServletException, IOException {
		}
	};

}
