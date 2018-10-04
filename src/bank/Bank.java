package bank;

public class Bank {
	public static void main(String[] args) {
		
		Functions fc = new Functions();
		while(true) {
			int selectMenu = fc.menuPrint();
			if(selectMenu == 1) {
				fc.createAccount();
			} else if (selectMenu == 2) {
				fc.accountList();
			} else if (selectMenu ==3) {
				fc.deposit();
			} else if(selectMenu ==4) {
				fc.withdraw();
			} else if(selectMenu == 5) {
				System.out.println("시스템을 종료합니다.");
				break;
			} else {
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
}
