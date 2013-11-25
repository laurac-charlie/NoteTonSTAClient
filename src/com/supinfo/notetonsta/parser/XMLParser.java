package com.supinfo.notetonsta.parser;

import java.util.ArrayList;

import com.supinfo.notetonsta.entity.Campus;

/**
 * 
 * @author Charlie
 * @version 1.0
 *
 */
public class XMLParser extends Parser{

	private static final String CONTENT_TYPE = "application/xml";
	
	public static ArrayList<Campus> getAllCampus()
	{
		@SuppressWarnings("unused")
		String s = sendGetRequest(Parser.site + Parser.res_campus,CONTENT_TYPE);
		
		return null;
	}
}
