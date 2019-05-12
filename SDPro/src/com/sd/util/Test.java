package com.sd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args){
		String date01=DateManager.dateFormat(new Date());
		System.out.println(date01);
		Date date02=DateManager.stringFormat(new Date().toLocaleString());
		Date date03 = null;
		String reusltString ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			reusltString = sdf.format(new Date());
			System.out.println(reusltString);
			date03 = sdf.parse("2011-05-17 11:39:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
