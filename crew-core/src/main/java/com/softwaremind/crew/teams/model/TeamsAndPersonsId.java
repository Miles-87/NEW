package com.softwaremind.crew.teams.model;

public class TeamsAndPersonsId {
	
	private Long personId;
	private Long teamId;
	
	public TeamsAndPersonsId(Long personId, Long teamId) {
		this.personId = personId;
		this.teamId = teamId;
	}
	
	public TeamsAndPersonsId() {
	}
	
	public Long getPersonId() {
		return personId;
	}
	
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	
	public Long getTeamId() {
		return teamId;
	}
	
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
}
