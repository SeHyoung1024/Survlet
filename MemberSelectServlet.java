package sec07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberSelectServlet
 */
// 클라이언트 요청에 대해 처리하고 응답하는 서블릿 클래스
// doGet / doPost 모두 처리 가능하도록 doHandle
@WebServlet("/memselect")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// MemberDAO 객체 생성 후
		MemberDAO dao = new MemberDAO();
		// MemberDAO 객체의 memberSelect() 호출해서 DB member 테이블의 정보를 반환받기
		ArrayList<MemberVo> memList = dao.memberSelect();
		// 반환받은 정보 출력 스트림에 실어서 클라이언트에게 전송
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><body>");
		out.print("<table border=1><tr align='center' bgcolor='gold'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td>" 
				+ "<td>이메일</td><td>삭제</td></tr>");
		
		for(MemberVo vo : memList) {
				out.print("<tr><td>" + vo.getId() + "</td>");
				out.print("<td>" + vo.getPwd() + "</td>");
				out.print("<td>" + vo.getName() + "</td>");
				out.print("<td>" + vo.getEmail() + "</td></tr>");
		}
		out.print("</table></body></html>");
		out.close();
		
		
		
	}

}
