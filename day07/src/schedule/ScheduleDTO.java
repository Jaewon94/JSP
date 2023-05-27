package schedule;

public class ScheduleDTO {
//	IDX	NUMBER
//	TITLE	VARCHAR2(100 BYTE)
//	MEMO	VARCHAR2(1000 BYTE)
//	SDATE	DATE
	
	private int idx;
	private String title, memo, sdate;
	
	public ScheduleDTO() {
		// TODO Auto-generated constructor stub
	}
	public ScheduleDTO(int idx, String title, String memo, String sdate) {
		this.idx = idx;
		this.title = title;
		this.memo = memo;
		this.sdate = sdate;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	
}
