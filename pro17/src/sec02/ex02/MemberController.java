package sec02.ex02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
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
			nextPage = "/test03/listMembers.jsp";
		} else if (action.equals("/addMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			request.setAttribute("msg", "addMember");
			nextPage = "/member/listMembers.do";
		} else if (action.equals("/memberForm.do")) {
			nextPage = "/test03/memberForm.jsp";
		/*회원 수정 요청시 id로 회원정보를 조회한 후 수정창으로 포워딩*/	
		} else if(action.equals("/modMemberForm.do")){
			 /*전송된 id를 이용해 회원정보 조회*/
		     String id=request.getParameter("id");
		     MemberVO memInfo = memberDAO.findMember(id);
		     request.setAttribute("memInfo", memInfo);
		     nextPage="/test03/modMemberForm.jsp";
		/*테이블의 회원 정보를 수정*/     
		} else if(action.equals("/modMember.do")){
		     String id=request.getParameter("id");
		     String pwd=request.getParameter("pwd");
		     String name= request.getParameter("name");
	         String email= request.getParameter("email");
		     MemberVO memberVO = new MemberVO(id, pwd, name, email);
		     memberDAO.modMember(memberVO);
		     /*회원 목록창으로 수정 작업 완료 메세지 전달*/
		     request.setAttribute("msg", "modified");
		     nextPage="/member/listMembers.do";
		/*회원 정보를 삭제*/     
		}else if(action.equals("/delMember.do")){
			/*삭제할 회원 아이디를 받아옴*/
		     String id=request.getParameter("id");
		     memberDAO.delMember(id);
		     /*회원 목록창으로 삭제 작업 완료 메세지 전달*/
		     request.setAttribute("msg", "deleted");
		     nextPage="/member/listMembers.do";
		}else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		}
		/*nextPage에 지정한 요청명으로 다시 서블릿에 요청*/
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);	
	}		
}
