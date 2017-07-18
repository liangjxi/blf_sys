package com.blf.common.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Tennyson
 * E-Mail:xing_wang@cxsoft.com.cn
 * Package:com.blf.common.converter
 * DateTime: 2016年5月23日 下午3:21:51
 * Description:日期转换器
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
	    try {    
	    	if (StringUtils.isNotBlank(source)) {
	    		Timestamp ts = new Timestamp(Long.parseLong(source));
				Date date = new Date();
				date = ts;
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
			    dateFormat.setLenient(false);
		        return dateFormat.parse(dateFormat.format(date)); 
			}   
	    } catch (ParseException e) {    
	        e.printStackTrace();    
	    }      
		return null;
	}

}
