package DAO;

import common.JdbcUtils;
import domain.User;

import java.sql.*;

public class MyDAO {
    private Connection conn;
    private Statement st;
    private PreparedStatement pst;

    /**
     * 查询是否存在用户
     * @param name
     * @return
     * @throws SQLException
     */
    public Boolean queryUser(String name) throws SQLException {
        conn = JdbcUtils.getConn();
        st = conn.createStatement();

        String sql = "select * from users "+"where user_name='"+name+"'";
        ResultSet rs = st.executeQuery(sql);
        if (!rs.next()) {
            //不存在返回空
            return false;
        } else {
            return true;
        }
    }

    //查询用户名和密码是否正确
    public Boolean verifyUser(String name, String password) throws SQLException {
        conn = JdbcUtils.getConn();
        st = conn.createStatement();

        String sql = "select * from users "+"where user_name='"+name+"' and user_pwd='"+password+"'";
        ResultSet rs = st.executeQuery(sql);
        if (!rs.next()) {
            //不存在返回空
            return false;
        } else {
            return true;
        }
    }

    //插入用户基本账户信息
    public void insertUser(String name, String password) throws SQLException{
        conn = JdbcUtils.getConn();
        String sql = "insert users(user_name,user_pwd) values (?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2,password);
        pst.executeUpdate();
    }

    public int insertBlobs() {
        return 0;
    }
}
