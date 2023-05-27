package schedule;

public class Test {
	public static void main(String[] args) {
		ScheduleDAO dao = new ScheduleDAO();
		String banner = dao.test();
		System.out.println(banner);
	}
}
