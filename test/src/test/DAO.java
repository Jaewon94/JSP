package test;

public class DAO {
	   private String[] id = { "pkr0957", "it", "ddangkong" };
	   private String[] pw = { "qkr140502", "bank", "qkr149592" };

	   public String login(DTO dto) {
	      String answer = "";
	      
	      for (int i = 0; i < id.length; i++) {
	         if (dto.getId_input().equals(id[i])&& dto.getPw_input().equals(pw[i])) {
	            answer = "로그인 성공";
	            break;
	         } else {
	            answer = "로그인 실패";
	         }
	      }
	      return answer;
	   
	}
}
