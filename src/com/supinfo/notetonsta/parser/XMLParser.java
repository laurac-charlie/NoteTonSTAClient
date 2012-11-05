package com.supinfo.notetonsta.parser;

import java.util.ArrayList;

import com.supinfo.notetonsta.entity.Campus;

public class XMLParser extends Parser{

	private static final String CONTENT_TYPE = "application/xml";
	
	public static ArrayList<Campus> getAllCampus()
	{
		@SuppressWarnings("unused")
		String s = sendGetRequest(site + JSONParser.res_campus,CONTENT_TYPE);
		
		return null;
	}
}
