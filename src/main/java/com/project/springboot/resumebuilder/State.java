package com.project.springboot.resumebuilder;

public class State {
	private int State_ID;
	private String State_Name;
	
	public State() {
		
	}
	
	public State(int StateID, String StateName) {
		this.State_ID=StateID;
		this.State_Name=StateName;		
	}
	public String getStateName() {
		return State_Name;
	}
	public void setStateName(String stname) {
		this.State_Name=stname;
	}
	public int getStateID() {
		return State_ID;
	}
	public void setStateID(int stid) {
		this.State_ID=stid;
	}
}
