package ralph.zhang.mrnba.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ralph.zhang.mrnba.bean.Team;
import ralph.zhang.mrnba.bean.TeamInfo;
import ralph.zhang.mrnba.db.DBAccess;

public class TeamDao {
	
	/**
	 * Query joined Team & TeamInfo table
	 * @param team's name
	 * @param team's fullname
	 * @return
	 */
	public List<Team> queryTeamList(String name, String fullname) {

		List<Team> tList=new ArrayList<Team>();
		
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Instantiate an instance of Team to pass in parameter values
			Team team=new Team();
			team.setName(name);
			team.setFullname(fullname);
			
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			tList=sqlSession.selectList("Team.queryTeamList",team);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return tList;
	}

	/**
	 * Query TeamInfo table
	 * @param team's name
	 * @return
	 */
	public List<TeamInfo> queryTeamInfoList(String name) {

		List<TeamInfo> tInfoList=new ArrayList<TeamInfo>();
		
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Instantiate an instance of Team to pass in parameter values
			TeamInfo teamInfo=new TeamInfo();
			teamInfo.setName(name);
			
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			tInfoList=sqlSession.selectList("TeamInfo.queryTeamInfoList",teamInfo);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		return tInfoList;
	}
	
	
	/**
	 * Update one record in the Team table
	 * @param name
	 * @param fullname
	 * @param state
	 * @param arena
	 * @param year
	 */
	public void updateTeam(String name, String fullname, String state, String arena, String year) {

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Instantiate an instance of Team to pass in parameter values
			Team team=new Team();
			team.setName(name);
			team.setFullname(fullname);
			team.setState(state);
			team.setArena(arena);
			team.setYear(year);
			
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			sqlSession.update("Team.updateTeam",team);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
	
	
	/**
	 * Add a new team to Team table
	 * @param name
	 * @param fullname
	 * @param state
	 * @param arena
	 * @param year
	 */
	public void addOne(String name, String fullname, String state, String arena, String year) {

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		
		try {
			//Instantiate an instance of Player to add
			Team team=new Team();
			team.setName(name);
			team.setFullname(fullname);
			team.setState(state);
			team.setArena(arena);
			team.setYear(year);
			
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			
			//Run sql command using SqlSession
			sqlSession.insert("Team.addOne", team);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}
	

	/**
	 * Add one piece of team information to TeamInfo table
	 * @param name
	 * @param information
	 */
	public void addOneInfo(String name, String information) {

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		
		try {
			//Instantiate an instance of Player to add
			TeamInfo teamInfo=new TeamInfo();
			teamInfo.setName(name);
			teamInfo.setInformation(information);

			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			
			//Run sql command using SqlSession
			sqlSession.insert("TeamInfo.addOne", teamInfo);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * Delete one team from Team table
	 * @param name
	 */
	public void deleteOneTeam(String name) {

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			sqlSession.delete("Team.deleteOne", name);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}
	
	
	/**
	 * Delete one piece of team information from TeamInfo table
	 * @param id
	 */
	public void deleteOneInfo(int id) {

		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			//Get SqlSession
			sqlSession=dbAccess.getSqlSession();
			//Run sql command using SqlSession
			sqlSession.delete("TeamInfo.deleteOne", id);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		
	}
	
}
