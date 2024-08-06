package sec08;

public class ProductVo {
	private String prdNo;
	private String prdName;
	private String prdPrice;
	private String prdColor;
	private String catNo;
	
	public ProductVo() { // 생성자 함수
			
	}
	
	public void ProductVo(String prdNo , String prdName , String prdPrice, String prdColor , String catNo) {
			this.prdNo = prdNo;
			this.prdName = prdName;
			this.prdPrice = prdPrice;
			this.prdColor = prdColor;
			this.catNo = catNo;  // 멤버필드 변수 초기화
	}
	// Getter / Setter 구성
	public String getPrdNo() {
		return prdNo;
	}

	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(String prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdColor() {
		return prdColor;
	}

	public void setPrdColor(String prdColor) {
		this.prdColor = prdColor;
	}

	public String getCatNo() {
		return catNo;
	}

	public void setCatNo(String catNo) {
		this.catNo = catNo;
	}
	
}
