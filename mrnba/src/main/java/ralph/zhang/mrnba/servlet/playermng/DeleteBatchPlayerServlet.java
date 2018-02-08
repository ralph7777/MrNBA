package ralph.zhang.mrnba.servlet.playermng;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ralph.zhang.mrnba.service.MaintainService;

/*
 * Servlet for deleting multiple records in Player list
 */
@SuppressWarnings("serial")
public class DeleteBatchPlayerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Set character encoding
		req.setCharacterEncoding("UTF-8");
		
		//Get id info from the page
		String[] ids=req.getParameterValues("id");
		
		//Search player list and post to page
		MaintainService maintainService=new MaintainService();
		maintainService.deleteBatchPlayers(ids);
				
		//Redirect page
		req.getRequestDispatcher("/PlayerList.action").forward(req, resp);
		
	}
	
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
