package day14;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/device_db"
                + "?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8";

        try (Connection conn = DriverManager.getConnection(url, "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from device")) {

            System.out.println("连接成功");
            while (rs.next()) {
                System.out.println(rs.getLong("id") + " | "
                        + rs.getString("name") + " | "
                        + rs.getString("location") + " | "
                        + rs.getString("status"));
            }
        }
    }
}
