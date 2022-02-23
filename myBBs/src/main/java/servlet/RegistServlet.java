package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDao uDao = new UserDao();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("username");
		try {
			int result = uDao.regist(id, pw, name);
			if(result == 1)
				System.out.println("success");
			response.sendRedirect("success.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
