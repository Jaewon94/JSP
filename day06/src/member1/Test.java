package member1;

public class Test {
	public static void main(String[] args) {
		MemberDAO  dao = new MemberDAO();
		
		String banner = dao.test();
		
		System.out.println(banner);
	}
}
