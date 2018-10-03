package bank;

import java.util.Scanner;

public class Bank{

	public static void main(String[] args){

		Account[] accountArray = new Account[100];
		Scanner scan = new Scanner(System.in);

		while(true){

			System.out.println("---------------------");
			System.out.println("1. 계좌생성");
			System.out.println("2. 계좌조회");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("5.종료");
			System.out.println("메뉴를 선택하세요.");
			int selectMenu = Integer.parseInt(scan.nextLine());

			if(selectMenu == 1){
				System.out.println("생성할 계좌번호를 입력하세요.");
				String tmpAno = scan.nextLine();
				System.out.println("계좌주의 이름을 입력하세요.");
				String tmpOwner = scan.nextLine();
				System.out.println("초기입금액을 입력하세요.");
				int tmpBalance = Integer.parseInt(scan.nextLine());

				for(int i = 0; i < accountArray.length; i++){
					if(accountArray[i] == null){
						accountArray[i] = new Account(tmpAno, tmpOwner, tmpBalance);
						break;
					}
				}

			}else if(selectMenu == 2){
				for(int i = 0; i < accountArray.length; i++){
					if(accountArray[i] != null){
						System.out.printf("계좌번호 : %s , 계좌주 : %s ,잔액 : %d", accountArray[i].ano, accountArray[i].owner,accountArray[i].balance);
						System.out.println();
					}
				}
				
			}else if (selectMenu == 3){
				System.out.println("입금할 계좌번호를 입력하세요.");
				String tmpAno = scan.nextLine();
				for(int i = 0; i < accountArray.length; i++){
					if(accountArray[i].ano.equals(tmpAno)){
						System.out.println("입금할 금액을 입력하세요.");
						int tmpBalance = Integer.parseInt(scan.nextLine());
						accountArray[i].setBalance(accountArray[i].balance + tmpBalance);
						break;
					}
					System.out.println("해당 계좌가 존재하지 않습니다.");
					break;
				}
			
			}else if (selectMenu == 4){
				System.out.println("출금할 계좌번호를 입력하세요.");
				String tmpAno = scan.nextLine();
				for(int i = 0; i < accountArray.length; i++){
					if(accountArray[i].ano.equals(tmpAno)){
						System.out.println("출금할 금액을 입력하세요.");
						int tmpBalance = Integer.parseInt(scan.nextLine());
						if(accountArray[i].balance >= tmpBalance){
							accountArray[i].setBalance(accountArray[i].balance - tmpBalance);
							break;
						}else{
							System.out.println("잔액이 부족합니다.");
							break;
						}
					}
					System.out.println("해당계좌가 존재하지 않습니다.");
					break;
				}
	
			}else if(selectMenu == 5){
				System.out.println("시스템을 종료합니다.");
				break;
			}else{
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
}