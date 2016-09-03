package zhouzhou.pn.com.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

@SuppressWarnings("hiding")
public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		// TODO Auto-generated method stub
		System.out.println("source:"+source);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
