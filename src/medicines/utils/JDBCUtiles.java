package medicines.utils;

import java.sql.*;

public class JDBCUtiles {

    private static Connection conn = null;
    private static Statement stat = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static int rows = 0;


    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");     // 加载数据库驱动，注册到驱动管理器
            String url = "jdbc:mysql://localhost:3306/medicine?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false";
            String username = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ResultSet query(String sql){
        try{
            conn = getConnection();//获得一个连接的对象
            stat = conn.createStatement();//向数据库发送sql语句
            rs = stat.executeQuery(sql);//获得查询结果，返回Resultset对象
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

    public static void add(String sql){
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rows = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
//        return rows;
    }


    public static void update(String sql){
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rows = ps.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
//        return rows;
    }

    public static void delete(String sql){
        try{
            conn = getConnection();
            stat = conn.createStatement();
            rows = ps.executeUpdate(sql);
//            return rows;
        }catch (SQLException e){
            e.printStackTrace();
        }
//        return 0;
    }

    public static void close(){
        try{
            if(rs != null){
                rs.close();
            }
            if(stat != null){
                stat.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
