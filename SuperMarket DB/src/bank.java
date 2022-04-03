
public class bank {

	private int bankNum ;
	private double money ;
	
	public bank() {
		super();
		
	}

	public bank(int bankNum, double money) {
		super();
		this.bankNum = bankNum;
		this.money = money;
	}
	public bank( double money) {
		super();
		this.money = money;
	}
	

	public int getBankNum() {
		return bankNum;
	}

	public void setBankNum(int bankNum) {
		this.bankNum = bankNum;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "bank [bankNum=" + bankNum + ", money=" + money + "]";
	} 
	
	
	
}
