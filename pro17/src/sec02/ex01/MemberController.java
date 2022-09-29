package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	MemberDAO memberDAO;

	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo(); /*URL에서 요청가져오기*/
		System.out.println("action:" + action);
		/*최초로 요청했거나, action 값이 /listMembers.do면 회원 목록을 출력*/
		if (action == null || action.equals("/listMembers.do")) {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			/*listMembers.jsp 로 포워딩*/
			nextPage = "/test02/listMembers.jsp";
		} else if (action.equals("/addMember.do")) { /*전송된 회원 정보를 가져와 테이블에 출력*/
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			/*회원 등록 후 다시회원 목록을 출력*/
			nextPage = "/member/listMembers.do";
		/*action 값이 /memberForm.do 이면 회원 가입창을 화면에 출력*/
		} else if (action.equals("/memberForm.do")) {
			nextPage = "/test02/memberForm.jsp"; /*memberForm.jsp로 포워딩*/
		} else { /*그외 다른 action 값은 회원 목록을 출력*/
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";  /*회원등록후 다시 회원 목록을 출력*/
		}
		/*nextPage에 지정한 요청명으로 다시 서블릿에 요청*/
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);	
	}		
}
