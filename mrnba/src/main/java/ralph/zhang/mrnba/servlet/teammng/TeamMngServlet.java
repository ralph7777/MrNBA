package ralph.zhang.mrnba.servlet.teammng;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ralph.zhang.mrnba.bean.*;
import ralph.zhang.mrnba.service.QueryService;

/**
 * Initialize the Team List
 */
@SuppressWarnings("serial")
public class TeamMngServlet extends HttpServlet {
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Set character encoding
		req.setCharacterEncoding("UTF-8");
		
		//Get filled-in info in page
		String name=req.getParameter("searchTeamName");
		//Post info to page
		req.setAttribute("name", name);
		
		//Search player list and post to page
		QueryService listService=new QueryService();
		List<Team> teamList=listService.queryTeamList(name);
		List<TeamInfo> teamInfoList=listService.queryTeamInfoList(name);	
		
		req.setAttribute("teamList", teamList);
		req.setAttribute("teamInfoList", teamInfoList);
		
		//Redirect page
		req.getRequestDispatcher("/WEB-INF/jsp/back/teammng.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
