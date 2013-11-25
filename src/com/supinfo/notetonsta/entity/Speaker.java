package com.supinfo.notetonsta.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Charlie
 * @version 1.0
 *
 */
public class Speaker implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String lastName;
	private String firstName;
	private String eMail;
	private String password;
	private List<Intervention> interventions;
	
	public Speaker(){}

	
	public Speaker(String lastName, String firstName, String eMail,	String password) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.eMail = eMail;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}


	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}
	
}
