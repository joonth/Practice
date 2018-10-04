package bank;

import java.util.Scanner;

public class Functions {
	
	static Account[] accountArray = new Account[100];
	static Scanner scan = new Scanner(System.in);
	
	public int menuPrint() {
		System.out.println("---------------------");
		System.out.println("1.계좌생성\n2.계좌조회\n3.입금\n4.출금\n5.종료\n메뉴를 선택하세요");
		return Integer.parseInt(scan.nextLine());
	}
	
	public void createAccount() {
		System.out.println("생성할 계좌번호를 입력하세요.");
		String tmpAno = scan.nextLine();
		Account ca = checkAccount(tmpAno);
		if(ca == null) {	
			for(int i=0; i<accountArray.length; i++) {
				if(accountArray[i] ==null) {
					System.out.println("계좌주의 이름과 초기입금액을 입력하세요.");
					accountArray[i] = new Account(tmpAno,scan.nextLine(),Integer.parseInt(scan.nextLine()));
					break;
				}
			}
		}else {
			System.out.println("계좌번호가 중복됩니다.");
		}
	}
	
	public void accountList() {
		for(int i = 0; i<accountArray.length; i++) {
			if(accountArray[i] != null) {						
				System.out.printf("계좌번호 : %s , 계좌주 : %s ,잔액 : %d \n", accountArray[i].ano,accountArray[i].owner,accountArray[i].balance);
			}
		}
	}
	
	public void deposit() {
		System.out.println("입금할 계좌번호를 입력하세요.");
		Account ca = checkAccount(scan.nextLine());
		if(ca != null) {
			System.out.println("입금할 금액을 입력하세요.");
			ca.setBalance(ca.balance + Integer.parseInt(scan.nextLine()));	
		} else {				
			System.out.println("해당 계좌가 존재하지 않습니다.");
		}
	}
	
	public void withdraw() {
		System.out.println("출금할 계좌번호를 입력하세요.");
		Account ca = checkAccount(scan.nextLine());
		if(ca != null) {
			System.out.println("출금할 금액을 입력하세요.");
			int tmpBalance = Integer.parseInt(scan.nextLine());
			if(ca.balance >= tmpBalance) {
				ca.setBalance(ca.balance-tmpBalance);
			} else {
				System.out.println("잔액이 부족합니다.");
			}
		} else {				
			System.out.println("해당계좌가 존재하지 않습니다.");
		}
	}
	
	public Account checkAccount(String ano) {
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null && accountArray[i].ano.equals(ano)) {
				return accountArray[i];	
			}
		}
		return null;
	}
	
}
