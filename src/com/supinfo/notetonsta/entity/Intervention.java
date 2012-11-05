package com.supinfo.notetonsta.entity;

import java.util.List;
import java.io.Serializable;
import java.sql.Date;


public class Intervention implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String subject;
	private Date beginDate;
	private Date endDate;
	private String description;
	private Campus campus;
	private Speaker speaker;
	private List<Mark> marks;  
	
	public Intervention(){}
	
	public Intervention(String subject, Date beginDate, Date endDate, String description, Campus campus, Speaker speaker) {
		this.subject = subject;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.description = description;
		this.campus = campus;
		this.speaker = speaker;
	}
	
	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public float getAverageMark() {
		float somme = 0;
		float avg = 0;
		for(Mark mark : this.marks)
		{
			somme += mark.getSlideNote();
			somme += mark.getSpeakerNote();
		}
		
		if(this.marks.size() > 0)
		{
			avg = (float)somme/(this.marks.size()+this.marks.size());
			return  twoDecimal(avg);
		}
		else
			return avg;
	}

	public String getStatus() {
		String status = "";
		java.util.Date now = new java.util.Date();
		
		if(this.beginDate.after(now)) status = "Not started";
		
		if(this.endDate.before(now)) status = "Done";
		
		if(this.beginDate.before(now) && this.endDate.after(now)) status = "In progress";
		
		return status;
	}

	public int getNumberOfMark() {
		return this.marks.size();
	}
	
	//Calculate the Average Slide Note
	public float getAverageSlideNote() {
		float somme = 0;
		for(Mark mark : this.marks)
			{somme += mark.getSlideNote();}
		if(this.marks.size() > 0)
			return  twoDecimal((float)somme/this.marks.size());
		else
			return 0;
	}

	//Calculate the Average Speaker Note
	public float getAverageSpeakerNote() {
		float somme = 0;
		for(Mark mark : this.marks)
			{somme += mark.getSpeakerNote();}
		
		if(this.marks.size() > 0)
			return  twoDecimal((float)somme/this.marks.size());
		else
			return 0;
	}
	
	private float twoDecimal(float number)
	{
		float f = number*100;
		f = Math.round(f);
		f = f/100;
		return f;
		
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
