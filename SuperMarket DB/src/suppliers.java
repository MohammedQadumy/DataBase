
public class suppliers {
	

	private int uniqueNum ; 
	private	String supname ; 
	private int bankNum ; 
	private String goodsType ;
	private String email ;
	
	public suppliers() {
		super();
	}

	public suppliers(int uniqueNum, String supname, int bankNum, String goodsType,String email) {
		super();
		
		this.email = email ;
		this.uniqueNum = uniqueNum;
		this.supname = supname;
		this.bankNum = bankNum;
		this.goodsType = goodsType;
	}
	
	public suppliers( String supname, int bankNum, String goodsType,String email) {
		super();
		
		this.email = email ;
		this.supname = supname;
		this.bankNum = bankNum;
		this.goodsType = goodsType;
	}
	public suppliers( String supname, String goodsType,String email) {
		super();
		
		this.email = email ;
		this.supname = supname;
		this.bankNum = bankNum;
		this.goodsType = goodsType;
	}


	public int getUniqueNum() {
		return uniqueNum;
	}

	public void setUniqueNum(int uniqueNum) {
		this.uniqueNum = uniqueNum;
	}

	public String getSupname() {
		return supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}

	public int getBankNum() {
		return bankNum;
	}

	public void setBankNum(int bankNum) {
		this.bankNum = bankNum;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "suppliers [uniqueNum=" + uniqueNum + ", supname=" + supname + ", bankNum=" + bankNum + ", goodsType="
				+ goodsType + ", email=" + email + "]";
	}

}
