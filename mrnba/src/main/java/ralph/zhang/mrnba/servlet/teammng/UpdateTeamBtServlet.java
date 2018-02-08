package ralph.zhang.mrnba.servlet.teammng;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ralph.zhang.mrnba.bean.Team;
import ralph.zhang.mrnba.service.QueryService;


@SuppressWarnings("serial")
public class UpdateTeamBtServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Set character encoding
		req.setCharacterEncoding("UTF-8");
		
		//Get filled-in info in page
		String name=req.getParameter("name");
		
		//Search player list and post to page
		QueryService listService=new QueryService();
		List<Team> teamList=listService.queryTeamList(name);
		
		Team team=teamList.get(0);
		//Post info to page
		req.setAttribute("team", team);
		
		//Redirect page
		req.getRequestDispatcher("/WEB-INF/jsp/back/updateTeam.jsp").forward(req, resp);
		
	}
	
	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
