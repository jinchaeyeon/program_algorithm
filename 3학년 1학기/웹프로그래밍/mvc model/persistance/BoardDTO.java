package persistance;

import java.time.LocalDateTime;

public class BoardDTO {
	private String id;
	private String writer;
	private String title;
	private String contents;
	private LocalDateTime regdate; 
	private String hit;
	
	public BoardDTO(String id, String writer, String title, String contents, LocalDateTime regdate, String hit) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.regdate = regdate;
		this.hit = hit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public LocalDateTime getRegdate() {
		return regdate;
	}
	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
}
