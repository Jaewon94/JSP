package ex07;

// Data Transfer Object
// DB의 데이터를 자바 객체형태로 나타낸다.
// 데이터를 DB에서 서버로 가져오거나, (DB -> WAS) WAS = Web Application Server(동적 웹 서버)
// 사용자 입력값을 자바 객체로 변환하여 객체를 DB에 전달할때 사용한다. (WAS -> DB)
// 데이터를 담는 그릇 역할의 클래스 (테이블 레코드가 많다면 여러 객체가 존재할 수 있다)

// NAME      VARCHAR2(100) 
// AGE       NUMBER        
// GENDER    VARCHAR2(50)  

public class StudentDTO {
	private String name;
	private int age;
	private String gender;
	
	public StudentDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
