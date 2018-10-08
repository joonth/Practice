package bulletin_board;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		User[] userArray =  new User[100];
		Content[] conArray = new Content[100];
		User loginUser = null;
		boolean mainPage = true;
		int signup =1;
		
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
				System.out.println("ID를 입력하세요");
				String tmpId = scan.nextLine();
				for(int i=0; i<userArray.length; i++) {
					if(userArray[i] != null) {
						if(userArray[i].id.equals(tmpId)) {
							System.out.println("PW를 입력하세요.");
							String tmpPw = scan.nextLine();
							if(userArray[i].pw.equals(tmpPw)) {
								System.out.println("로그인 되었습니다.");
								loginUser = userArray[i];
								loginUser.loginStatus = true;
								break;
							} else {
								System.out.println("PW가 틀렸습니다.");
							}
						}else if(i == userArray.length) {
							System.out.println("해당 ID가 존재하지 않습니다.");
							break;
						}
					}else if(userArray[0] == null) {
						System.out.println("회원가입을 해주세요.");
						break;
					}
				}
				
			} else if(menu ==2) {
				System.out.println("사용하실 ID를 입력하세요.");
				String tmpId = scan.nextLine();
				for(int i=0; i<userArray.length; i++) {
					if(userArray[i] != null ) {
						if(userArray[i].id.equals(tmpId)) {
							System.out.println("중복되는 ID입니다.");
							signup =0;
							break;
						}
					}
				}

				if(signup ==1) {
					System.out.println("사용하실 PW를 입력하세요.");
					String tmpPw = scan.nextLine();
					for(int i=0; i<userArray.length; i++) {
						if(userArray[i] == null) {
							userArray[i] = new User(tmpId,tmpPw);
							System.out.println("회원가입이 완료되었습니다.");
							break;
						}
					}
				}
				signup=1;
	
			} else if(menu ==3) {
				System.out.println("종료합니다.");
				mainPage=false;
			} else {
				System.out.println("메뉴를 다시 선택하세요.");
			}
		
			
			while(loginUser != null&&loginUser.loginStatus) {
				System.out.println("################");
				System.out.println("####     Board    ####");
				System.out.println("################");
				System.out.println("####  1.글쓰기         ####");
				System.out.println("####  2.글검색        ####");
				System.out.println("####  3.글목록        ####");
				System.out.println("####  4.마이페이지   ####");
				System.out.println("####  5.로그아웃 ####");
				System.out.println("####  6.종료 ####");
				System.out.println("################");
				int boardMenu =Integer.parseInt(scan.nextLine());
				
				if(boardMenu == 1) {
					for(int i=0; i<conArray.length; i++) {
						if(conArray[i] == null) {
							System.out.println("제목을 입력하세요.");
							String tmpTitle = scan.nextLine();
							System.out.println("내용을 입력하세요.");
							String tmpContent = scan.nextLine();
							conArray[i]=new Content(tmpTitle,tmpContent,loginUser.id);
							break;
						}
					}
				}else if(boardMenu ==2) {
					System.out.print("검색할 내용을 입력하세요 : ");
					String tmpSearch = scan.nextLine();
					for(int i=0; i<conArray.length; i++) {
						if(conArray[i] != null && conArray[i].title.indexOf(tmpSearch) != -1) {
							System.out.printf((i+1+".")+ " [ %3s | %3s | %3s ]\n",conArray[i].title,conArray[i].writer,conArray[i].writeTime);
						}
					}
				}else if(boardMenu ==3) {
					for(int i=0; i<conArray.length; i++) {
						if(conArray[i] != null) {
							System.out.printf((i+1+".")+ " [ %3s | %3s | %3s ]\n",conArray[i].title,conArray[i].writer,conArray[i].writeTime);
						}
					}
				}else if (boardMenu==4) {
					System.out.println("내가 작성한글");
					for(int i=0; i<conArray.length; i++) {
						if(conArray[i] !=null && conArray[i].writer.equals(loginUser.id) ) {
							System.out.println((i+1)+"."+conArray[i].title+" | "+conArray[i].writeTime);
						}
					}
				}else if(boardMenu ==5) {
					System.out.println("로그아웃 되었습니다.");
					loginUser.loginStatus =false;
					break;
				}else if(boardMenu ==6) {
					System.out.println("종료합니다.");
					mainPage = false;
					break;
				}else {
					System.out.println("메뉴를 다시 선택하세요.");
				}
			}
		}//while
	}
}
