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
 * Servlet implementation class RentServlet
 */
@WebServlet("/rent")
public class RentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<DVD>dvds =DVDDao.selectDVD(0);
		request.setAttribute("dvds", dvds);
		
		request.getRequestDispatcher("/view/rent.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String [] dvdId = request.getParameterValues("dvdId");
		DVDDao.rentDVD(dvdId);
		String msg ="成功借出DVD";
		request.setAttribute("msg", msg);
		doGet(request, response);
	}

}
