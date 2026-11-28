package day16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Day16：驱动 jar 交给 Maven 管，跑通 JDBC 的增、改、删、查四条链路。
 *
 * 和 day15 的区别：classpath 里不再手动挂 mysql-connector-j，
 * 只靠 pom.xml 里的坐标，Maven 自己下载并加入 classpath。
 */
public class CrudDemo {

    // 协议/主机/端口/库名/参数
    private static final String URL =
            "jdbc:mysql://localhost:3306/device_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("1. 连接成功，驱动版本 = " + conn.getMetaData().getDriverVersion());

            // 增
            long id = insert(conn, "AGV搬运车", "四号车间", "待维修");
            System.out.println("2. 插入成功，自增 id = " + id);

            // 改
            int updated = updateStatus(conn, id, "正常运行");
            System.out.println("3. 更新影响行数 = " + updated);

            printAll(conn, "4. 当前全表");

            // 删
            int deleted = delete(conn, id);
            System.out.println("5. 删除影响行数 = " + deleted);

            printAll(conn, "6. 删除后全表");
        } catch (SQLException e) {
            System.out.println("SQL 执行失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /** 插入一条设备记录，返回数据库生成的自增 id。 */
    private static long insert(Connection conn, String name, String location, String status)
            throws SQLException {
        String sql = "INSERT INTO device(name, location, status) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setString(3, status);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getLong(1);
                }
            }
            throw new SQLException("插入成功但没取到自增 id");
        }
    }

    /** 按 id 改状态，返回影响行数。 */
    private static int updateStatus(Connection conn, long id, String status) throws SQLException {
        String sql = "UPDATE device SET status = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setLong(2, id);
            return ps.executeUpdate();
        }
    }

    /** 按 id 删除，返回影响行数。 */
    private static int delete(Connection conn, long id) throws SQLException {
        String sql = "DELETE FROM device WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate();
        }
    }

    /** 查出全表并逐行打印。 */
    private static void printAll(Connection conn, String title) throws SQLException {
        String sql = "SELECT id, name, location, status FROM device ORDER BY id";
        List<String> rows = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                rows.add(String.format("   id=%d  %s / %s / %s",
                        rs.getLong("id"), rs.getString("name"),
                        rs.getString("location"), rs.getString("status")));
            }
        }
        System.out.println(title + "（共 " + rows.size() + " 行）");
        rows.forEach(System.out::println);
    }
}
