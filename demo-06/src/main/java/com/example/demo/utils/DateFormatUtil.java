package com.example.demo.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public enum DateFormatUtil {

    INSTANCE;

    private final SimpleDateFormat mSdf;

    /*年月日时分秒*/

    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String yyyyMMddHHmmss_H = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyyMMddHHmmss_CN = "yyyy年MM月dd日 HH:mm:ss";

    public static final String yyyyMMddHHmm = "yyyyMMddHHmm";
    public static final String yyyyMMddHHmm_H = "yyyy-MM-dd HH:mm";
    public static final String yyyyMMddHHmm_CN = "yyyy年MM月dd日 HH:mm";

    /*年月日*/

    public static final String yyyyMMdd = "yyyyMMdd";
    public static final String yyyyMMdd_H = "yyyy-MM-dd";
    public static final String yyyyMMdd_CN = "yyyy年MM月dd日";

    /*年月日时分*/

    public static final String MMddHHmm = "yyyyMMddHHmm";
    public static final String MMddHHmm_H = "MM-dd HH:mm";
    public static final String MMddHHmm_CN = "MM月dd日 HH:mm";

    /*月日*/

    public static final String MMdd = "MMdd";
    public static final String MMdd_H = "MM-dd";
    public static final String MMdd_CN = "MM月dd日";

    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";


    DateFormatUtil() {
        mSdf = new SimpleDateFormat();
    }

    public String format(Date date, String pattern){
        mSdf.applyPattern(pattern);
        return mSdf.format(date);
    }

    public String format(long timeMillis, String pattern){
        mSdf.applyPattern(pattern);
        return mSdf.format(new Date(timeMillis));
    }

    public String format(Calendar calendar, String pattern){
        mSdf.applyPattern(pattern);
        return mSdf.format(calendar.getTime());
    }


    public Date parse(String timeText, String pattern){
        Date parse = null;
        try {
            mSdf.applyPattern(pattern);
            parse = mSdf.parse(timeText);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }

    public long parseToMillis(String timeText, String pattern){
        return parse(timeText, pattern).getTime();
    }

    public Calendar parseToCalendar(String timeText, String pattern){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse(timeText, pattern));
        return calendar;
    }

    public String transform(String date, String patternIn, String patternOut){
        return format(parse(date, patternIn), patternOut);
    }

    /**
     * @Title: dateFormat
     * @Description: 对输入不正确日期进行格式化 -- 格式为：yyyy-MM-dd
     */
    public static Date dateFormat(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate = java.sql.Date.valueOf(sdf.format(date));
        return newDate;
    }

    /**
     * 功能：比较日期是否相等
     *
     * @param FirstDate  String 输入为yyyy-MM-DD或者yyyy/MM/DD
     * @param SecondDate String
     * @return int 1：大于，0：相等，-1：小于
     */
    public static int compareDate(String FirstDate, String SecondDate) throws Exception {
        int intReturn = 0; // 返回值
        java.util.Date firstDate = null;
        java.util.Date secondDate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // StringConvert.replace(FirstDate,"/","-"); //将“/”的分隔符
            String strReturn = "";
            int intStartIndex = 0, intEndIndex = 0;
            if (FirstDate != null || !"".equals(FirstDate)) {
                while ((intEndIndex = FirstDate.indexOf("/", intStartIndex)) > -1) {
                    strReturn = strReturn + FirstDate.substring(intStartIndex, intEndIndex) + "-";
                    intStartIndex = intEndIndex + 1;
                }
            }
            firstDate = format.parse(FirstDate);
            secondDate = format.parse(SecondDate);
            if (firstDate.after(secondDate)) {
                intReturn = 1;
            } else if (firstDate.before(secondDate)) {
                intReturn = -1;
            } else if (firstDate.equals(secondDate)) {
                intReturn = 0;
            }
            return intReturn;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
     */
    public static Date getNextDay(String nowdate, String delay) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date d = format.parse(nowdate, pos);
        long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
        d.setTime(myTime * 1000);
        return d;
    }

    /**
     * 根据字符串格式去转换相应格式的日期和时间
     **/
    public static Date reverseDate(String date) {
        SimpleDateFormat simple = null;
        switch (date.trim().length()) {
            case 19:// 日期+时间
                simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
            case 14:// 日期+时间
                simple = new SimpleDateFormat("yyyyMMddHHmmss");
                break;
            case 10:// 仅日期
                simple = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case 8:// 仅时间
                simple = new SimpleDateFormat("HH:mm:ss");
                break;
            default:
                break;
        }
        try {
            return simple.parse(date.trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @throws
     * @Description: TODO(某个时间与当前时间进行求差 （天）)
     */
    public static long getAppointTimeDifference(Date startDate, Date endDate) {
        long l = endDate.getTime() - startDate.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        return day;
    }
}
