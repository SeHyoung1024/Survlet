package sec07;
// 멤버 1명의 정보 저장 클래스
// 멤버 수 만큼 클래스 객체변수 생성해서 정보 저장

public class MemberVo {
	private String id ;
	private String pwd ;
	private String name;
	private String email;
	
	public MemberVo() {
		
	}
	
	public void MemverVo(String id , String pwd , String name , String email) {
			this.id = id;
			this.pwd = pwd;
			this.name = name;
			this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
