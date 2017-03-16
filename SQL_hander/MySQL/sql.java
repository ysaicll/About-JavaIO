package leettest;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
public class sql {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");   
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://" +   
		        "localhost:3306/test", "root", "123");   
		// �ر������Զ��ύ   
		con.setAutoCommit(false);   
		   
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");   
		TimeZone t = sdf.getTimeZone();   
		t.setRawOffset(0);   
		sdf.setTimeZone(t);   
		Long startTime = System.currentTimeMillis();   
		   
		PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into test04 values (?,'�й�')");   
		for (int i = 0; i < 100; i++) {   
		    pst.setInt(1, i);   
		    // ��һ��SQL������������б�   
		    pst.addBatch();   
		}   
		// ִ����������   
		pst.executeBatch();   
		// ���ִ����ϣ��ύ������   
		con.commit();   
		   
		Long endTime = System.currentTimeMillis();   
		System.out.println("��ʱ��" + sdf.format(new Date(endTime - startTime)));   
		   
		pst.close();   
		con.close();  
    }
}
