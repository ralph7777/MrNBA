package ralph.zhang.mrnba.service;


import java.util.List;
import java.util.Random;

import ralph.zhang.mrnba.bean.Player;
import ralph.zhang.mrnba.bean.Team;
import ralph.zhang.mrnba.bean.TeamInfo;
import ralph.zhang.mrnba.dao.PlayerDao;
import ralph.zhang.mrnba.dao.TeamDao;
import ralph.zhang.mrnba.util.*;

/**
 * Business of table query, search functionality with SQL
 * 
 * Note that most of the functions in this class are to support auto-answering in front-end page.
 */
public class QueryService {
	
	
	/**
	 * "CRUD"-R: Read operation.
	 * 
	 * Query Player table according to input player's name and team
	 * @param player's name
	 * @param player's team
	 * @return a list of players, can be displayed on the back-end management page
	 */
	public List<Player> queryPlayerList(String name, String team) {
		PlayerDao playerDao = new PlayerDao();
		return playerDao.queryPlayerList(name, team);
	}
	
	
	/**
	 * "CRUD"-R: Read operation.
	 * 
	 * Query Player table according to user's input name
	 * @param name, possible input in the dialogue page
	 * @return a String containing player's information，can be the response from Mr.NBA in dialogue
	 */
	public String queryByPlayerName(String name) {
		PlayerDao playerDao = new PlayerDao();
		List<Player> playerList;

		//If the input is HELP_COMMAND_P, show all players' name in the database
		if (Iconst.HELP_COMMAND_P.equals(name)) {
			playerList=playerDao.queryPlayerList(null, null);
			StringBuilder result=new StringBuilder();
			for (int i=0; i<playerList.size(); i++) {
				if (i != 0) {
					//for main driver testing
//					result.append("\n");
					result.append("<br/>");
				}
				result.append(playerList.get(i).getName());
			}
			return result.toString();
		}
		
		playerList=playerDao.queryPlayerList(name, null);
		
		//Assemble a string representing the query result
		if (playerList.size()>0) {
			StringBuilder result=new StringBuilder();
			
			for (int i=0; i<playerList.size(); i++) {
				//For main driver test
//				if (i != 0) {
//					result.append("\n");
//				}
//				result.append("Name: "+playerList.get(i).getName()+"\n");
//				result.append("Team: "+playerList.get(i).getTeam()+"\n");
//				result.append("Number: "+playerList.get(i).getNumber());
				if (i != 0) {
					result.append("<br/><br/>");
				}
				result.append("Name: "+playerList.get(i).getName()+"<br/>");
				result.append("Team: "+playerList.get(i).getTeam()+"<br/>");
				result.append("Number: "+playerList.get(i).getNumber());
			}
			return result.toString();
		}
		
		return Iconst.NO_MATCHING_CONTENT;
	}
	
	
	/**
	 * "CRUD"-R: Read operation.
	 * 
	 * Query Team table according to input team's name
	 * @param team's name
	 * @return a list of teams, can be displayed on the back-end management page
	 */
	public List<Team> queryTeamList(String name) {
		TeamDao teamDao = new TeamDao();
		List<Team> teamList=teamDao.queryTeamList(name, null);
		return teamList;
	}
	
	/**
	 * "CRUD"-R: Read operation.
	 * 
	 * Query TeamInfo table according to input team's name
	 * @param team's name
	 * @return a list of teaminfo, can be displayed on the back-end management page
	 */
	public List<TeamInfo> queryTeamInfoList(String name) {
		TeamDao teamDao = new TeamDao();
		List<TeamInfo> teamInfoList=teamDao.queryTeamInfoList(name);
		return teamInfoList;
	}
	
	/**
	 * "CRUD"-R: Read operation.
	 * 
	 * Query joined Team & TeamInfo table according to user's input team name
	 * @param team name, possible input in the dialogue page
	 * @return a String containing team information, can be the response from Mr.NBA in dialogue
	 */
	public String queryByTeamName(String fullname) {
		TeamDao teamDao = new TeamDao();
		List<Team> teamList;
		
		//If the input is HELP_COMMAND_T, show all teams' name in the database
		if (Iconst.HELP_COMMAND_T.equals(fullname)) {
			teamList=teamDao.queryTeamList(null, null);
			StringBuilder result=new StringBuilder();
			for (int i=0; i<teamList.size(); i++) {
				if (i != 0) {
					result.append("<br/>");
				}
				result.append(teamList.get(i).getFullname());
			}
			return result.toString();
		}
		
		teamList=teamDao.queryTeamList(null, fullname);
		
		//Assemble a string representing the query result
		if (teamList.size()>0) {
			StringBuilder result=new StringBuilder();
			
			//For main driver test
//			result.append(teamList.get(0).getFullname()+":\n");
//			result.append("States: " + teamList.get(0).getState() + "\n");
//			result.append("Arena: " + teamList.get(0).getArena() + "\n");
//			result.append("Year founded: " + teamList.get(0).getYear() + "\n");
			
			result.append(teamList.get(0).getFullname()+":<br/>");
			result.append("States: " + teamList.get(0).getState() + "<br/>");
			result.append("Arena: " + teamList.get(0).getArena() + "<br/>");
			result.append("Year founded: " + teamList.get(0).getYear() + "<br/>");
			
			List<TeamInfo> infoList=teamList.get(0).getTeamInfo();
			int i=new Random().nextInt(infoList.size());
			result.append(infoList.get(i).getInformation());
			return result.toString();
		}
		
		return Iconst.NO_MATCHING_CONTENT;
	}
	

	/**
	 * Test driver
	 * @param args
	 */
	public static void main(String[] args) {
		
		QueryService queryService=new QueryService();
		
		System.out.println("Query one player - Harden:");
		System.out.println(queryService.queryByPlayerName("Harden"));
		System.out.println();
		
		System.out.println("Query players - James:");
		System.out.println(queryService.queryByPlayerName("James"));
		System.out.println();
		
		System.out.println("Query one team with details and a piece of random info - Rockets:");
		System.out.println(queryService.queryByTeamName("Rockets"));
		System.out.println();
		
		System.out.println("Query one team with details and a piece of random info - Hou:");
		System.out.println(queryService.queryByTeamName("Hou"));
		System.out.println();
		
		
		System.out.println("Query all players");
		System.out.println(queryService.queryPlayerList(null, null));
		System.out.println();
		
		System.out.println("Query all teams");
		System.out.println(queryService.queryTeamList(null));
		System.out.println();
	}


	
}
