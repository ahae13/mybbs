package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDao uDao;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		uDao = new UserDao();
		
		HttpSession session = request.getSession();
		
		try {
			int result = uDao.checkLogin(id, pw);
			if(result != 1) {
				System.out.println("login fail~~");
				response.sendRedirect("loginForm");
			}else {
				System.out.println("success");
				session.setAttribute("user", id);
				request.getRequestDispatcher("list").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
