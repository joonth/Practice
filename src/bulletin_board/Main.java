package bulletin_board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		User[] userArray =  new User[100];
		Content[] conArray = new Content[100];
		User loginUser = null;
		boolean mainPage = true;

		
		while(mainPage) {
			
			System.out.println("################");
			System.out.println("####  Main Page  ####");
			System.out.println("################");
			System.out.println("####    1.로그인     ####");
			System.out.println("####    2.회원가입   ####");
			System.out.println("####    3.종료        ####");
			System.out.println("################");
			int menu = Integer.parseInt(scan.nextLine());
			
			if(menu==1) {
				
			} else if(menu ==2) {
				
			
			} else if(menu ==3) {
				
			} else {
				
			}
		
			
			while(loginUser.loginStatus) {
				System.out.println("################");
				System.out.println("####     Board    ####");
				System.out.println("################");
				System.out.println("####  1.글쓰기         ####");
				System.out.println("####  2.글검색        ####");
				System.out.println("####  3.글목록        ####");
				System.out.println("####  4.마이페이지   ####");
				System.out.println("####  5.로그아웃 ####");
				System.out.println("####  6.종료 			####");
				System.out.println("################");
				int boardMenu =Integer.parseInt(scan.nextLine());
				
				if(boardMenu == 1) {
					
				}else if(boardMenu ==2) {
					
				}else if(boardMenu ==3) {
					
				}else if (boardMenu==4) {
					
				}else if(boardMenu ==5) {
					
				}else if(boardMenu ==6) {
				
				}else {
					System.out.println("메뉴를 다시 선택하세요.");
				}
			}
		}//while
	}
}
