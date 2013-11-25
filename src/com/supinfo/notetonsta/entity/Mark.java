package com.supinfo.notetonsta.entity;

import java.io.Serializable;

/**
 * 
 * @author Charlie
 * @version 1.0
 *
 */
public class Mark implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Intervention intervention;
	private int idBooster;
	private float slideNote;
	private float speakerNote;
	private String comments;
	
	public Mark() {}
	
	public Mark(Intervention intervention, int idBooster, float slideNote, float speakerNote, String comments) {
		this.intervention = intervention;
		this.idBooster = idBooster;
		this.slideNote = slideNote;
		this.speakerNote = speakerNote;
		this.comments = comments;
	}

	public Intervention getIntervention() {
		return intervention;
	}
	
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}
	
	public int getIdBooster() {
		return idBooster;
	}
	
	public void setIdBooster(int idBooster) {
		this.idBooster = idBooster;
	}
	
	public float getSlideNote() {
		return slideNote;
	}
	
	public void setSlideNote(float slideNote) {
		this.slideNote = slideNote;
	}
	
	public float getSpeakerNote() {
		return speakerNote;
	}
	
	public void setSpeakerNote(float speakerNote) {
		this.speakerNote = speakerNote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
