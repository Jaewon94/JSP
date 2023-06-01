package member;

public class MemberDTO {

//	IDX      NOT NULL NUMBER        
//	USERID   NOT NULL VARCHAR2(100) 
//	USERPW   NOT NULL VARCHAR2(100) 
//	USERNAME NOT NULL VARCHAR2(100) 
//	EMAIL    NOT NULL VARCHAR2(100) 
//	BIRTH             VARCHAR2(100) 
//	GENDER            VARCHAR2(100) 
//	AGE               NUMBER   
	
	private int idx, age;
	private String userId, userPw, userName, email, birth, gender;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(int idx, int age, String userId, String userPw, String userName, String email, String birth,
			String gender) {
		this.idx = idx;
		this.age = age;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}

