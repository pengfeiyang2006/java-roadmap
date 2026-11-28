package day17;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Day17：最小 Servlet。
 *
 * 浏览器访问 /day17/device → Tomcat 调 doGet → 这里查 MySQL → 把结果拼成 HTML → 回给浏览器。
 * 与 day16 的区别：day16 的入口是 main 方法，由 java 命令启动；
 * 这里的入口是 doGet 方法，由浏览器请求触发。
 */
@WebServlet("/device")
public class DeviceListServlet extends HttpServlet {

    // 关键：在 Tomcat 的 webapp 类加载器里，DriverManager 不会自动发现 WEB-INF/lib 下的驱动，
    // 必须在类第一次被使用时显式加载一次，否则报 "No suitable driver found"。
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("找不到 MySQL 驱动：" + e.getMessage());
        }
    }

    private static final String URL =
            "jdbc:mysql://localhost:3306/device_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 告诉浏览器：内容是 HTML，字符集 UTF-8
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"zh-CN\"><head><meta charset=\"UTF-8\">");
        out.println("<title>设备列表</title>");
        out.println("<style>");
        out.println("body{font-family:sans-serif;padding:24px}");
        out.println("table{border-collapse:collapse;margin-top:12px}");
        out.println("th,td{border:1px solid #999;padding:8px 16px;text-align:left}");
        out.println("th{background:#eee}");
        out.println("</style></head><body>");
        out.println("<h2>设备列表</h2>");
        out.println("<p>数据来自 MySQL 的 device_db.device 表，由 Servlet 查询后直接输出到页面。</p>");

        int count = 0;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT id, name, location, status FROM device ORDER BY id");
             ResultSet rs = ps.executeQuery()) {

            out.println("<table><tr><th>id</th><th>设备名</th><th>位置</th><th>状态</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getLong("id") + "</td>"
                        + "<td>" + rs.getString("name") + "</td>"
                        + "<td>" + rs.getString("location") + "</td>"
                        + "<td>" + rs.getString("status") + "</td></tr>");
                count++;
            }
            out.println("</table>");
        } catch (SQLException e) {
            out.println("<p style=\"color:#c00\">查询失败：" + e.getMessage() + "</p>");
        }

        out.println("<p>共 " + count + " 行</p>");
        out.println("<p>" + new java.util.Date() + "</p>");
        out.println("</body></html>");
    }
}
