package day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudDemo {
    //协议/主机/端口/库名/参数值
    private static final String URL = "jdbc:mysql://localhost:3306/device_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database.");

            int rows = insert(conn, "工业机器人", "三号车间", "正常运行");
            System.out.println("插入影响的行数：" + rows);
        } catch (SQLException e) {
            System.out.println("SQL执行失败" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static int insert(Connection conn, String name, String location, String status)
            throws SQLException {

        String sql = "INSERT INTO device (name,location,status) VALUES (?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setString(3, status);
            return ps.executeUpdate();
        }
    }
}
