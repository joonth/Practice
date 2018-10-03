package bank;

import java.util.Scanner;

public class Bank{
	
	static Account[] accountArray = new Account[100];
	static Scanner scan = new Scanner(System.in);
	
	public void menuPrint(){
		System.out.println("---------------------");
		System.out.println("1. 계좌생성");
		System.out.println("2. 계좌조회");
		System.out.println("3.입금");
		System.out.println("4.출금");
		System.out.println("5.종료");
		System.out.println("메뉴를 선택하세요.");
	}
	
	public void createAccount(){
		System.out.println("생성할 계좌번호를 입력하세요.");
		String tmpAno = scan.nextLine();
		Account ca = checkAccount(tmpAno);
		if(ca == null){
			System.out.println("계좌주의 이름을 입력하세요.");
			String tmpOwner = scan.nextLine();
			System.out.println("초기입금액을 입력하세요.");
			int tmpBalance = Integer.parseInt(scan.nextLine());
			
			for(int i=0; i<accountArray.length; i++){
				if(accountArray[i] ==null){
					accountArray[i] = new Account(tmpAno,tmpOwner,tmpBalance);
					break;
				}
			}
		}else{
			System.out.println("계좌번호가 중복됩니다.");
		}
	}
	
	public void accountList(){
		for(int i = 0; i<accountArray.length; i++) {
			if(accountArray[i] != null){						
				System.out.printf("계좌번호 : %s , 계좌주 : %s ,잔액 : %d", accountArray[i].ano,accountArray[i].owner,accountArray[i].balance);
				System.out.println();
			}
		}
	}
	
	public void deposit(){
		System.out.println("입금할 계좌번호를 입력하세요.");
		String tmpAno = scan.nextLine();
		Account ca = checkAccount(tmpAno);
		if(ca != null){
			System.out.println("입금할 금액을 입력하세요.");
			int tmpBalance = Integer.parseInt(scan.nextLine());
			ca.setBalance(ca.balance + tmpBalance);	
		} else{				
			System.out.println("해당 계좌가 존재하지 않습니다.");
		}
	}
	
	public void withdraw(){
		System.out.println("출금할 계좌번호를 입력하세요.");
		String tmpAno =scan.nextLine();
		Account ca = checkAccount(tmpAno);
		if(ca != null){
			System.out.println("출금할 금액을 입력하세요.");
			int tmpBalance = Integer.parseInt(scan.nextLine());
			if(ca.balance >= tmpBalance) {
				ca.setBalance(ca.balance-tmpBalance);
			}else{
				System.out.println("잔액이 부족합니다.");
			}
		}else{				
			System.out.println("해당계좌가 존재하지 않습니다.");
		}
	}
	
	public Account checkAccount(String ano){
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null){
				if(accountArray[i].ano.equals(ano)){
					return accountArray[i];
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		Bank bk = new Bank();
		while(true){
			bk.menuPrint();
			int selectMenu = Integer.parseInt(scan.nextLine());
			if(selectMenu == 1){
				bk.createAccount();
			} else if(selectMenu == 2){
				bk.accountList();
			} else if(selectMenu ==3){
				bk.deposit();
			} else if(selectMenu ==4){
				bk.withdraw();
			} else if(selectMenu == 5){
				System.out.println("시스템을 종료합니다.");
				break;
			} else{
				System.out.println("메뉴를 다시 선택하세요.");
			}
		}
	}
}