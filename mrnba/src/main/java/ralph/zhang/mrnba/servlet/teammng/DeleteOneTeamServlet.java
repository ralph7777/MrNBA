package ralph.zhang.mrnba.servlet.teammng;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ralph.zhang.mrnba.service.MaintainService;

/*
 * Servlet for deleting one record in Team list
 */
@SuppressWarnings("serial")
public class DeleteOneTeamServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Set character encoding
		req.setCharacterEncoding("UTF-8");
		
		//Get name info from the page
		String name=req.getParameter("name");
		
		MaintainService maintainService=new MaintainService();
		maintainService.deleteOneTeam(name);
				
		//Redirect page
		req.getRequestDispatcher("/TeamList.action").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
