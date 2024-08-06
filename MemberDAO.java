package sec07;
// DB member 테이블에 있는 모든 레코드를 추출(select)해서
// MemberVo 객체변수에 각 각 담고
// 멤버 정보 모두를 ArrayList 에 저장 후 리턴하는 메소드 구성

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
		// DB 연결하는 담당 메소드 : DB 연결 Connection 객체 반환
	private Connection getConnection() {
			Connection con = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// DB 연결 정보
				
				String url = "jdbc:oracle:thin:@local:1521:xe";
				String user = "C##SHOPDBUSER";
				String pwd = "1234";
				
				// Connection 객체 생성
				con = DriverManager.getConnection(url,user,pwd);
				
				// 반환 여부
				if(con != null) {
						System.out.println("DB 연결 성공");
				}else {
						System.out.println("DB 연결 실패");
				}
				
			}catch(Exception e){
					e.printStackTrace();
			}
			return con;
	}
	
	// 멤버 정보 조회 메소드(전체 멤버 정보 Select 해서 ArrayList 로 반환)
	// MemberVo 로 각 멤버 정보 받아서 ArrayList 에 저장 후 반환
	public ArrayList<MemberVo> memberSelect(){
			Connection con = null;
			PreparedStatement pstmt = null; // DB 테이블에서 DML 쿼리 진행 가능하게 하는 객체 변수
			ResultSet rs = null; // Select 진행 후 반환되는 결과 테이블(ResultSet)을 저장할 객체 변수
			
			// DB에서 반환되는 RS 데이터를 저장할 배열 객체 생성 -> 반환
			ArrayList<MemberVo> memList = new ArrayList<MemberVo>();
			
			// memList 에 Member 테이블에서 추출한 데이터 저장
			try {
					con = getConnection(); // 현재 클래스 내 private 메소드 , 동일 클래스에서 호출이므로 가능
					
					String sql = "select * from member"; // 멤버 테이블의 모든 데이터 추출
					pstmt = con.prepareStatement(sql); // PSTMT 객체 생성하면서 쿼리구문 전달 , 폴더문자 없음
					// 바인딩이 필요 없음
					rs = pstmt.executeQuery(); // Select 구문 executeQuery()
					// Select 되는 데이터 없어도 테이블 형태는 반환
					
					while(rs.next()) { // rs.next 는 커서를 움직였을때 레코드(데이터)가 있으면 true 반환
							// 레코드 1개(한행:1명의 멤버) 처리
							// RS 에서 컬럼별 데이터 추출
							String memId = rs.getString("memId"); // 순서번호 1,2,3 ... or 열 이름 사용
							String memPwd = rs.getString("memPwd");
							String memName = rs.getString("memName");
							String memEmail = rs.getString("memEmail");
					//		Date memJoin = rs.getDate("memJoin"); // Select 하지만 사용하지 않음
							
							// MemberVo 에 담아서
							MemberVo vo = new MemberVo();
							vo.setId(memId);
							vo.setPwd(memPwd);
							vo.setName(memName);
							vo.setEmail(memEmail);
							
							// ArrayList 에 추가
							memList.add(vo);
							
					}
					
			}catch(Exception e) {
					e.printStackTrace();
			} finally {
				try {
						rs.close();
						pstmt.close();
						con.close();
				}catch(Exception e) {
					
				}
			}
			
			return memList ;
	}
	
}
