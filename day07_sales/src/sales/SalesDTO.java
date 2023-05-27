package sales;

public class SalesDTO {
	private String idx;
	private String name;
	private int price;
	private int cnt;
	private int status;
	
	public SalesDTO() {
		// TODO Auto-generated constructor stub
	}

	public SalesDTO(String idx, String name, int price, int cnt, int status) {
		this.idx = idx;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		this.status = status;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
