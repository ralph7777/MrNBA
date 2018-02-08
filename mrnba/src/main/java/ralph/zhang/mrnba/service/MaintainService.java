package ralph.zhang.mrnba.service;

import java.util.ArrayList;
import java.util.List;

import ralph.zhang.mrnba.bean.Team;
import ralph.zhang.mrnba.bean.TeamInfo;
import ralph.zhang.mrnba.dao.PlayerDao;
import ralph.zhang.mrnba.dao.TeamDao;


/*
 * Business of table maintenance, CRUD functionality with SQL
 * 
 * Note that most of the functions in this class are to support operations on the back-end management page.
 */
public class MaintainService {


	/**
	 * "CRUD"-C: Create operation.
	 * 
	 * Add a new player to the Player table
	 * @param name
	 * @param team
	 * @param number
	 */
	public void addOnePlayer(String name, String team, String number) {
		PlayerDao playerDao=new PlayerDao();
		playerDao.addOne(name, team, number);
	}
	
	/**
	 * "CRUD"-D: Delete operation.
	 * 
	 * Delete one record in the Player table
	 * @param id, for manually selecting on the web page
	 */
	public void deleteOnePlayer(String id) {
		if (id!=null && !"".equals(id.trim())){
			PlayerDao playerDao=new PlayerDao();
			playerDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/**
	 * "CRUD"-D: Delete operation.
	 * 
	 * Delete multiple records in the Player table
	 * @param ids, for manually selecting on the web page
	 */
	public void deleteBatchPlayers(String[] ids) {
		if (ids==null || ids.length==0) return;
		List<Integer> idList=new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		PlayerDao playerDao=new PlayerDao();
		playerDao.deleteBatch(idList);
	}
	
	
	/**
	 * "CRUD"-C: Create operation.
	 * 
	 * Add a new team in the Team table
	 * @param name
	 * @param fullname
	 * @param state
	 * @param arena
	 * @param year
	 */
	public void addOneTeam(String name, String fullname, String state, String arena, String year){
		//Name can not be empty
		if (name!=null && !"".equals(name.trim())){
			TeamDao teamDao=new TeamDao();
			List<Team> teamList=teamDao.queryTeamList(name,null);
			if (!teamList.isEmpty()){
				//If the team already exists in table, update
				teamDao.updateTeam(name, fullname, state, arena, year);
			} else {
				//Otherwise, add
				teamDao.addOne(name, fullname, state, arena, year);
			}
		}
	}
	
	/**
	 * "CRUD"-C: Create operation.
	 * 
	 * Add a new piece of team information in the TeamInfo table
	 * @param name
	 * @param info
	 */
	public void addOneTeamInfo(String name, String info){
		if ((name!=null && !"".equals(name.trim()))&&(info!=null && !"".equals(info.trim()))){
			TeamDao teamDao=new TeamDao();
			List<Team> teamList=teamDao.queryTeamList(name,null);
			if (!teamList.isEmpty()){
				//If the team is in Team table, add new info to TeamInfo
				teamDao.addOneInfo(name, info);
			} else {
				//Otherwise, add a new team to Team table first
				teamDao.addOne(name, null, null, null, null);
				teamDao.addOneInfo(name, info);
			}
		}
	}
	
	/**
	 * "CRUD"-U: Update operation.
	 * 
	 * Update a team's detail in the Team table
	 * @param name
	 * @param fullname
	 * @param state
	 * @param arena
	 * @param year
	 */
	public void updateTeam(String name, String fullname, String state, String arena, String year){
		//In the front-end page, limit the update to fields fullname, state, arena and year
		if (name!=null && !"".equals(name.trim())){
			TeamDao teamDao=new TeamDao();
			teamDao.updateTeam(name, fullname, state, arena, year);
		}
	}
	
	/**
	 * "CRUD"-D: Delete operation.
	 * 
	 * Delete one team in Team table
	 * @param name
	 */
	public void deleteOneTeam(String name){
		if (name!=null && !"".equals(name.trim())){
			TeamDao teamDao = new TeamDao();
			teamDao.deleteOneTeam(name);
		}
	}
	
	/**
	 * "CRUD"-D: Delete operation.
	 * 
	 * Delete one record in TeamInfo table
	 * @param id, for manually selecting on the web page
	 */
	public void deleteOneTeamInfo(String id){
		if (id!=null && !"".equals(id.trim())){
			TeamDao teamDao = new TeamDao();
			teamDao.deleteOneInfo(Integer.valueOf(id));
		}
	}
	
	
	/**
	 * Test driver
	 * @param args
	 */
	public static void main(String[] args) {
		MaintainService maintainService=new MaintainService();
		QueryService queryService=new QueryService();

		String name1="Kobe Bryant";
		String team1="Los Angels Lakers";
		String number1="24";
		String name2="Tim Duncan";
		String team2="San Antonio Spurs";
		String number2="21";
		String name3="Kevin Garnett";
		String team3="Minnesota Timberwolves";
		String number3="21";
		
		System.out.println("Add one player - Kobe:");
		maintainService.addOnePlayer(name1, team1, number1);
		System.out.println();
		
		System.out.println("Add one player - Tim:");
		maintainService.addOnePlayer(name2, team2, number2);
		System.out.println();
		
		System.out.println("Add one player - Kevin:");
		maintainService.addOnePlayer(name3, team3, number3);
		System.out.println();
		
		System.out.println("Delete one player - Kobe:");
		String id1=queryService.queryPlayerList(name1, team1).get(0).getId();
		maintainService.deleteOnePlayer(id1);
		System.out.println();
		
		System.out.println("Delete two players - Tim and Kevin:");	
		String[] id23={queryService.queryPlayerList(name2, team2).get(0).getId(),
				queryService.queryPlayerList(name3, team3).get(0).getId()};
		maintainService.deleteBatchPlayers(id23);
		System.out.println();
		
		String name="Bulls";
		String fullname="Chicago Bulls";
		String state="IL";
		String oldArena="Chicago Stadium";
		String newArena="United Center";
		String year="1966";
		
		String info="They are known for having one of the NBA's greatest dynasties, "
				+ "winning six NBA championships between 1991 and 1998 with two three-peats.";
		
		System.out.println("Add one team - Bulls:");
		maintainService.addOneTeam(name, fullname, state, oldArena, year);
		System.out.println();
		
		System.out.println("Add one piece of team info - Bulls:");
		maintainService.addOneTeamInfo(name, info);
		System.out.println();
		
		System.out.println("Update team details - Bulls:");
		maintainService.updateTeam(name, null, null, newArena, null);
		System.out.println();
		
		System.out.println("Delete piece of team info - Bulls:");
		Team team=queryService.queryTeamList(name).get(0);
		TeamInfo tInfo=team.getTeamInfo().get(0);
		String id=Integer.toString(tInfo.getId());
		maintainService.deleteOneTeamInfo(id);
		
	}
}

