package sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.catalina.tribes.transport.RxTaskPool;

public class ProductDAO {
	// DB 연결 담당 메소드 , Connection con 반환
	private Connection getConnection() {
			Connection con = null;
			
			try { // 예외처리
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DB 연결 정보
			
			String url = "jdbc:oracle:thin:@local:1521:xe";
			String user = "C##PRODUCTLIST";
			String pwd = "1234";
			
			// Connection 객체 생성
			con = DriverManager.getConnection(url,user,pwd);
			
			if(con != null) { // con 에 정확한 값이 들어가면 성공
					System.out.println("DB 연결 성공 !!");
			}else { // null 값이면 실해
					System.out.println(("DB 연결 실패 !!"));
			}
			
			}catch(Exception e) {
					e.printStackTrace();
			}
			return con;
	}
	
	// DB product 테이블에서 모든 제품 정보를 Select 하고 Select 된 정보를 ArrayList 에 저장해 반환하는 함수
	
	// 한개의 제품정보는 ProductVo 객체 변수에 저장
	// ArrayList<ProductVo> 객체변수 prdList 반환
	public ArrayList<ProductVo> productSelect(){
			ArrayList<ProductVo> prdList = new ArrayList<ProductVo>(); // ArrayList 객체 생성
			Connection con = null;  // Connection 객체 변수 초기화
			PreparedStatement pstmt = null;  // PreparedStatement 객체 변수 초기화
			ResultSet rs = null; // ResultSet 객체 변수 초기화
			
			try { // 예외처리
					con = getConnection(); // DB 연결 시도
					String sql = "Select * From PRODUCT"; // SQL 문
					pstmt = con.prepareStatement(sql);// pstmt 객체 통해 SQL 문 전달
					rs = pstmt.executeQuery();
					
					while(rs.next()) { // rs.next(커서) false 될 때까지 while 진행
							String prdNo = rs.getString("prdNo");
							String prdName = rs.getString("prdName");
							String prdPrice = rs.getString("prdPrice");
							String prdColor = rs.getString("prdColor");
							String catNo = rs.getString("catNo");
							
							ProductVo vo = new ProductVo();
							
							vo.getPrdNo();
							vo.getPrdName();
							vo.getPrdPrice();
							vo.getPrdColor();
							vo.getCatNo();
							
							prdList.add(vo);
					}
					
			}catch(Exception e) {
					e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					con.close();
			}catch(Exception e) {
				
			}
		}
			
			return prdList;
	}
}
