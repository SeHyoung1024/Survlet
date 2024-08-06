package sec08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.xml.sax.DocumentHandler;

import sec07.MemberDAO;
import sec07.MemberVo;

/**
 * Servlet implementation class ProductSelectServlet
 */
// DAO 를 통해 DB 테이블 PRODUCT 에서 모든 데이터를 추출해서 테이블 형식으로 구성 클라이언트에게 출력
@WebServlet("/prdSelect")
public class ProductSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductDAO dao = new ProductDAO();
		
		ArrayList<ProductVo> prdList = dao.productSelect();
		// 반환받은 정보 출력 스트림에 실어서 클라이언트에게 전송
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>상품번호</td><td>상품명</td><td>상품가격</td>" 
				+ "<td>상품색상</td><td>???</td></tr>");
		
		for(ProductVo vo : prdList) {
				out.print("<tr><td>" + vo.getPrdNo() + "</td>");
				out.print("<td>" + vo.getPrdName() + "</td>");
				out.print("<td>" + vo.getPrdPrice() + "</td>");
				out.print("<td>" + vo.getPrdColor() + "</td>");
				out.print("<td>" + vo.getCatNo() + "</td></tr>");
		}
		out.print("</table></body></html>");
		out.close();
		
	}

}
