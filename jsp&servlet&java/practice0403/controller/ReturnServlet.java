package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DVD;
import model.DVDDao;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/return")
public class ReturnServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<DVD>dvds =DVDDao.selectDVD(1);
		request.setAttribute("dvds", dvds);
		
		request.getRequestDispatcher("/view/return.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String[] dvdIds = request.getParameterValues("dvdId");

		DVDDao.return_sp(dvdIds);
		String msg ="成功歸還DVD";
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}
