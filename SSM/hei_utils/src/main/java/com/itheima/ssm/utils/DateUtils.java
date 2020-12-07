package com.itheima.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//日期转成字符串
public class DateUtils {
    public static String data2String(Date data, String patt) {
        SimpleDateFormat format = new SimpleDateFormat(patt);
        String s = format.format(data);
        return s;
    }
    //字符串转成日期
    public static Date string2Date(String str,String patt) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(patt);
        Date parse = format.parse(str);
        return parse;
    }
}
