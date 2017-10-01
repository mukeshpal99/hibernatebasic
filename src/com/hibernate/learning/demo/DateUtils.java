package com.hibernate.learning.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	
	// read a date string and parse/convert to a date
	public static Date parseDate(String dateStr)
	{
		Date date = null;
		try {
			 date = formatter.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
	
	// read a date and format/convert to a string
	public static String formatDate(Date date)
	{
		String result = null;
		if(date != null)
		{
			result= formatter.format(date);
		}
		
		return result;
	}

}
