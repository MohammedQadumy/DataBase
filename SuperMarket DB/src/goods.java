
public class goods {
	
	private String  gName ; 
	private int gCode ; 
	private int uniqueNum ;
	
	public goods() {
		super();
	
	}

	public goods(String gName, int gCode, int uniqueNum) {
		super();
		this.gName = gName;
		this.gCode = gCode;
		this.uniqueNum = uniqueNum;
	}
	
	public goods(String gName, int uniqueNum) {
		super();
		this.gName = gName;
		this.uniqueNum = uniqueNum;
	}
	
	public goods(String gName) {
		super();
		this.gName = gName;
	}
	


	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgCode() {
		return gCode;
	}

	public void setgCode(int gCode) {
		this.gCode = gCode;
	}

	public int getUniqueNum() {
		return uniqueNum;
	}

	public void setUniqueNum(int uniqueNum) {
		this.uniqueNum = uniqueNum;
	}

	@Override
	public String toString() {
		return "goods [gName=" + gName + ", gCode=" + gCode + ", uniqueNum=" + uniqueNum + "]";
	}
	
	
	
	
	

}
