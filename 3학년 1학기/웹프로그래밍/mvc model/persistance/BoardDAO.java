package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource ds;

	public BoardDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<BoardDTO> select() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board";
		ArrayList<BoardDTO> articles = new ArrayList<BoardDTO>();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String contents = rs.getString("contents");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				String hit = rs.getString("hit");
				BoardDTO dto = new BoardDTO(id,title,writer,contents,regdate,hit);
				articles.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
}
