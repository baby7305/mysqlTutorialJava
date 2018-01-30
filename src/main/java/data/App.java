package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static data.DBcon.getConn;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException {
        Connection conn = getConn("root", "123456", "test");  //没有密码就什么都不写，空字符串
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT VERSION()");//执行查询
        while (rs.next()) {//遍历查询结果
            System.out.println(rs.getString(1));
        }
        stmt.close();//显示关闭Statement对象，释放资源
        conn.close();// 关闭数据库连接，这是个好习惯。尽管在程序运行结束会自动关闭。但web应用是不会结束运行的。
    }
}
