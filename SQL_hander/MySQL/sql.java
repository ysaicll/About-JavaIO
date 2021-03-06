package leettest;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
public class sql {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");   
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://" +   
		        "localhost:3306/test", "root", "123");   
		// 关闭事务自动提交   
		con.setAutoCommit(false);   
		   
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS");   
		TimeZone t = sdf.getTimeZone();   
		t.setRawOffset(0);   
		sdf.setTimeZone(t);   
		Long startTime = System.currentTimeMillis();   
		   
		PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into test04 values (?,'中国')");   
		for (int i = 0; i < 100; i++) {   
		    pst.setInt(1, i);   
		    // 把一个SQL命令加入命令列表   
		    pst.addBatch();   
		}   
		// 执行批量更新   
		pst.executeBatch();   
		// 语句执行完毕，提交本事务   
		con.commit();   
		   
		Long endTime = System.currentTimeMillis();   
		System.out.println("用时：" + sdf.format(new Date(endTime - startTime)));   
		   
		pst.close();   
		con.close();  
    }
}
