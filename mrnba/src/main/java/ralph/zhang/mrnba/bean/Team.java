package ralph.zhang.mrnba.bean;

import java.util.List;

public class Team {
	
	private String name;
	
	private String fullname;
	
	private String state;
	
	private String year;
	
	private String arena;
	
	private List<TeamInfo> teamInfoList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getArena() {
		return arena;
	}

	public void setArena(String arena) {
		this.arena = arena;
	}
	
	public List<TeamInfo> getTeamInfo() {
		return teamInfoList;
	}

	public void setTeamInfo(List<TeamInfo> teamInfo) {
		this.teamInfoList = teamInfo;
	}
	
	
	

}
