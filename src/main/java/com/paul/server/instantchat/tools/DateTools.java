package com.paul.server.instantchat.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {
    public static Date String2Date(String str_date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse(str_date);
        return date;
    }
}
