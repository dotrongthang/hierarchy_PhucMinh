package com.project.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	public Date convertToDate(String s) {
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
		try {
			date = formatter1.parse(s);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return null;
	}
}
