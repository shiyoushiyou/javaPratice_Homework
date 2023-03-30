package controllor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthCheckLogic;


@WebServlet("/Check")
public class HealthCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//連接網址
		request.getRequestDispatcher("/view/healthCheck.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//接收數據
		String Height = request.getParameter("height");//身高
		String weight = request.getParameter("weight");//體重
		
		//判斷數據是否正確輸入(在Logic判斷)
		if(HealthCheckLogic.CheckTrue(Height, weight)==false) {
				response.getWriter().print("你輸入的資料不完全");
		}else {
			double BMI = HealthCheckLogic.CheckBMI(Height ,weight);
			//正確輸入的話計算BMI跟判斷體型(在Logic判斷，將結果返回)
			String health = HealthCheckLogic.bodyCheck(BMI);
			System.out.println(BMI);
			System.out.println(health);
			Health healthResult = new Health(Height,weight ,BMI, health);
			System.out.println( ":))))))))))))))))");
			request.setAttribute("user",healthResult);
			System.out.println( ":((((((((((((");
			//將結果返回至成功頁面
			request.getRequestDispatcher("/view/healthCheckResult.jsp").forward(request, response);
			
			
			
		}
		
		
		
		
	}

}
