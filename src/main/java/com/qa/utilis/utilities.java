package com.qa.utilis;

import java.util.Date;

public class utilities {

	public static final int implicit_Wait_Time = 10;
	public static final int page_Wait_Time = 5;


	public static String generateEmailWithTimeStamp(){
		Date date = new Date(); 
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");	
		return "sriram"+timeStamp+"@gamil.com";


	}
}
