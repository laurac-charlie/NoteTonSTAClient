package com.supinfo.notetonsta.entity;

import java.io.Serializable;
import java.util.List;

public class Campus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<Intervention> intervention;
	
	public Campus(){}
	
	public Campus(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Intervention> getIntervention() {
		return intervention;
	}
	public void setIntervention(List<Intervention> intervention) {
		this.intervention = intervention;
	}
}
