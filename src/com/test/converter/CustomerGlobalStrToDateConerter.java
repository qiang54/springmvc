package com.test.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomerGlobalStrToDateConerter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}


}
