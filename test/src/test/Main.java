package test;

import java.util.Scanner;

public class Main {

	   public static void main(String[] args) {
	      
	      DAO dao = new DAO();
	      DTO dto = new DTO();
	      
	      Scanner sc = new Scanner(System.in);
	      
	      System.out.print("아이디 : ");
	      dto.setId_input(sc.next());
	      System.out.print("비밀번호 : ");
	      dto.setPw_input(sc.next());
	      
	      String answer = dao.login(dto);
	      System.out.println(answer);
	      
	      sc.close();
	   
	   
	}
}
