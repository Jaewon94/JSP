package phonebook;

public class PhonebookDTO {
	
	private int idx, favorites;
	private String name, pnum;
	
	public PhonebookDTO() {
		// TODO Auto-generated constructor stub
	}

	public PhonebookDTO(int idx, int favorites, String name, String pnum) {
		this.idx = idx;
		this.favorites = favorites;
		this.name = name;
		this.pnum = pnum;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getFavorites() {
		return favorites;
	}

	public void setFavorites(int favorites) {
		this.favorites = favorites;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	
	

}
