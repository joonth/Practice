package bank;

 public class Account {
	
	String ano;
	String owner;
	int balance;
	
	public Account(String ano, String owner, int balance) {
		this.ano= ano;
		this.owner = owner;
		this.balance = balance;
	}
	
	void setAno(String ano) {this.ano = ano;}
	void setOwner(String owner) {this.owner = owner;}
	void setBalance(int balance) {this.balance = balance;}
	String getAno() {return ano;}
	String getOwner() {return owner;}
	int getBalance() {return balance;}
	
}