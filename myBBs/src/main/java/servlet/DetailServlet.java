package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyBbsDao;
import dto.BbsDto;

@WebServlet("/bbs_detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		MyBbsDao dao = new MyBbsDao();
		BbsDto dto = new BbsDto();
		
		try {
			dto = dao.getBbs(num);
			request.setAttribute("dto", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
