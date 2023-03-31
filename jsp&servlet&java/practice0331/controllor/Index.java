package controllor;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//設置編碼
		request.setCharacterEncoding("UTF-8");
		//設定初始值至SiteEV 
		SiteEV siteEv =new  SiteEV();
		// applicationscope
		ServletContext application = this.getServletContext();
		//取得action的值等等用於判斷
		String action =  request.getParameter("action");
		
		//取得count的value放置 siteEv1，即可調用get方法
		SiteEV siteEv1 = (SiteEV)application.getAttribute("count");
		
		//將siteev的值以keyValue形式儲存至application
				//判斷action
		if(action==null) {
			application.setAttribute("count",siteEv);
			request.getRequestDispatcher("/view/index.jsp").forward(request, response);
			
		}
		if ("great".equals(action)) {
			//取得great的值調用counter方法使great數自增後返回並帶入set中
			siteEv1.setGreat(SiteEVLogic.counter(siteEv1.getGreat()));
//			siteEv(siteEv1.getGreat(),siteEv1.getNotGreat());
			application.setAttribute("count",siteEv1);
			System.out.println(siteEv1.getGreat()+"+"+siteEv1.getNotGreat());
			request.getRequestDispatcher("/view/index.jsp").forward(request, response);
		}
		if("notGreat".equals(action)) {
			siteEv1.setNotGreat(SiteEVLogic.counter(siteEv1.getNotGreat()));
			
			application.setAttribute("count",siteEv1);
			request.getRequestDispatcher("/view/index.jsp").forward(request, response);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	}

}
