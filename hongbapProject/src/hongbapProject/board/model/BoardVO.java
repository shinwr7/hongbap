package hongbapProject.board.model;

import java.sql.Timestamp;

public class BoardVO {
	private int bId;
	private String bTitle;
	private String bWriter;
	private String bContent;
	private Timestamp bDate;
	private int bHit;
	
	
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public int getbId() {
		return bId;
	}
	
	
	public Timestamp getbDate() {
		return bDate;
	}
	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	@Override
	public String toString() {
		return "BoardVO [bId=" + bId + ", bTitle=" + bTitle + ", bWriter=" + bWriter + ", bContent=" + bContent
				+ ", bDate=" + bDate + ", bHit=" + bHit + "]";
	}
	
	
	
	
}
