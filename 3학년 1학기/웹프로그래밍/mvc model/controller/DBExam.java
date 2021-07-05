package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBExam")
public class DBExam extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String preQuery = "INSERT INTO board(title,writer,contents,regdate,hit)"
				+ "VALUES (?,?,?,?,?)";
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/mydb?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
		String user = req.getServletContext().getInitParameter("dbId");
		String pw = req.getServletContext().getInitParameter("dbPassword");
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			System.out.println("연결 성공");
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM board");
			while(rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String contents = rs.getString("contents");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				
				System.out.printf("%s | %s | %s | %s | %s \n", id,title,writer,contents,regdate.toString());
				System.out.println("-------------------------------------");
			}
			System.out.println("Insert using PreparedStatement");
			pstmt = con.prepareStatement(preQuery); 
			pstmt.setString(1, "have a nice day");
			pstmt.setString(2, "yoon");
			pstmt.setString(3, "Good luck");					
			pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setString(5, "0");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[SQL Error : " + e.getMessage() + "]");
		} catch (ClassNotFoundException e1) {
			System.out.println("[JDBC Connector Driver Error : " + e1.getMessage() + "]");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

