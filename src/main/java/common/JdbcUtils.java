package common;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtils {

    private static String DB_USER;
    private static String DB_PASSWORD;
    private static String DB_URL;
    private static Connection DB;

    static {
        ResourceBundle resourceBundle =ResourceBundle.getBundle("jdbc");
        try {
            //加载驱动
            Class.forName(resourceBundle.getString("DB_DRIVER"));
            //获取配置文件的设置
            DB_URL= resourceBundle.getString("DB_URL");
            DB_USER = resourceBundle.getString("DB_USER");
            DB_PASSWORD = resourceBundle.getString("DB_PASSWORD");
            DB = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        if (DB.isClosed()) {
            DB = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        }
        return DB;
    }

    public static void closeConn(Connection conn) throws SQLException {
        if (!conn.isClosed()) {
            conn.close();
        }
    }

    public static void closeStatement(Statement st) throws SQLException {
        if (!st.isClosed()) {
            st.close();
        }
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if (!rs.isClosed()) {
            rs.close();
        }
    }

    public static void freeAllResources(Connection conn, Statement st, ResultSet rs) throws SQLException{
        rs.close();
        st.close();
        conn.close();
    }
}
