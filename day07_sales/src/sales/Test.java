package sales;

public class Test {
	public static void main(String[] args) {
		SalesDAO dao = new SalesDAO();
		String banner = dao.test();
		System.out.println(banner);
	}
}
