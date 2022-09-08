package sec03.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}

	//만약 전송방식(doPost)과 다른 메서드(doGet)를 사용한 경우에는 오류 메시지를 출력
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        System.out.println("아이디:" + user_id);
        System.out.println("비밀번호:" + user_pw);
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

}
