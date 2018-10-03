package bank;


import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {

		Account[] accountArray = new Account[100];
		Scanner scan = new Scanner(System.in);
		int selectMenu = scan.nextInt();

		while (true) {
			System.out.println("---------------------");
			System.out.println("1. 계좌생성");
			System.out.println("2. 계좌조회");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("5.종료");

			if (selectMenu == 1) {
			} else if (selectMenu == 2) {

			} else if (selectMenu == 3) {

			} else if (selectMenu == 4) {

			} else if (selectMenu == 5) {
				break;
			} else {
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
}