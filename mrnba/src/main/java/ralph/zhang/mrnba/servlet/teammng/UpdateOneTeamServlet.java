package ralph.zhang.mrnba.servlet.teammng;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ralph.zhang.mrnba.service.MaintainService;

@SuppressWarnings("serial")
public class UpdateOneTeamServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Set character encoding
		req.setCharacterEncoding("UTF-8");
		
		//Get id info from the page
		String name=req.getParameter("upname");
		String fullname=req.getParameter("upfullname");
		String state=req.getParameter("upstate");
		String arena=req.getParameter("uparena");
		String year=req.getParameter("upyear");
		
		//Search player list and post to page
		MaintainService maintainService=new MaintainService();
		maintainService.updateTeam(name, fullname, state, arena, year);
		
		//Redirect page
		req.getRequestDispatcher("/TeamList.action").forward(req, resp);
		
	}
	
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
