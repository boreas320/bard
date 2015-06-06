    package com.bard.davol.util;
    
    import java.io.PrintStream;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Calendar;
    import java.util.Date;
    import org.apache.log4j.Logger;
    
    public class DateUtils
    {
      private static Logger logger = Logger.getLogger(DateUtils.class);
    
      public static SimpleDateFormat SDF1 = new SimpleDateFormat("yyyy-MM-dd");
    
      public static SimpleDateFormat SDF2 = new SimpleDateFormat("yyyy/MM/dd");
    
      public static SimpleDateFormat SDF21 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
      public static SimpleDateFormat SDF3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
      public static SimpleDateFormat SDF4 = new SimpleDateFormat("yyyyMMddhhmmss");
    
      public static long secondsInMilli = 1000L;
      public static long minutesInMilli = secondsInMilli * 60L;
      public static long hoursInMilli = minutesInMilli * 60L;
      public static long daysInMilli = hoursInMilli * 24L;
    
      public static Date getStartTime()
      {
        Calendar calendar = Calendar.getInstance();
    
        calendar.set(11, 24);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Date date = new Date(calendar.getTimeInMillis());
        return date;
      }
    
      public static boolean isSameDate(Date d1, Date d2)
      {
        if ((d1 == null) || (d2 == null)) {
          logger.debug("isSameDate : 参数有空值，直接返回false");
          return false;
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
    
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d2);
    
        return (c1.get(1) == c2.get(1)) && (c1.get(2) == c2.get(2)) && (c1.get(5) == c2.get(5));
      }
    
      public static Date clearTime(Date d)
      {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        ca.set(11, 0);
        ca.set(12, 0);
        ca.set(13, 0);
        ca.set(14, 0);
        return ca.getTime();
      }
    
      public static String getDateTime() {
        return String.valueOf(new Date().getTime());
      }
    
      public static Date addHour(Date d, int hour)
      {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        ca.add(11, hour);
        return ca.getTime();
      }
    
      public static Date addDay(Date d, int dayToAdd)
      {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        ca.add(5, dayToAdd);
        return ca.getTime();
      }
    
      public static Date addMonth(Date d, int monthToAdd)
      {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        ca.add(2, monthToAdd);
        return ca.getTime();
      }
    
      public static Date addSecond(Date d, int secondToAdd)
      {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        ca.add(13, secondToAdd);
        return ca.getTime();
      }
    
      public static boolean isToday(Date d)
      {
        return isSameDate(d, new Date());
      }
    
      public static String dateToString(Date date, String format)
      {
        if (date == null) {
          return "";
        }
        if (format == null) {
          format = "yyyy-MM-dd hh:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
      }
    
      public static String dateToString(Date date)
      {
        if (date == null) {
          return "";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return df.format(date);
      }
    
      public static String dateToString() {
        return SDF2.format(new Date());
      }
    
      public static String dateToString2() {
        return SDF1.format(new Date());
      }
    
      public static String date24ToString(Date date)
      {
        if (date == null) {
          return "";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
      }
    
      public static long dateToTimeMillis(Date date)
      {
        if (date == null) {
          return 0L;
        }
        return date.getTime() / 1000L;
      }
    
      public static Date StringToDate(String datestr) {
        Date dt = null;
        if ((datestr == null) || ("".equals(datestr)))
          dt = new Date();
        try
        {
          dt = SDF2.parse(datestr);
        }
        catch (ParseException e) {
          e.printStackTrace();
        }
    
        return dt;
      }
      public static Date StringToDate(String datestr, SimpleDateFormat sdf) {
        Date dt = null;
        if ((datestr == null) || ("".equals(datestr)))
          dt = new Date();
        try
        {
          dt = sdf.parse(datestr);
        }
        catch (ParseException e) {
          e.printStackTrace();
        }
    
        return dt;
      }
    
      public static long printDifferenceDay(Date startDate, Date endDate)
      {
        long different = endDate.getTime() - startDate.getTime();
        long elapsedDays = different / daysInMilli;
        return elapsedDays;
      }
    
      public static long printDifferenceminutes(Date startDate, Date endDate)
      {
        long different = endDate.getTime() - startDate.getTime();
        long elapsedDays = different / minutesInMilli;
        return elapsedDays;
      }
    
      public static long printDifferencehours(Date startDate, Date endDate)
      {
        long different = endDate.getTime() - startDate.getTime();
        long elapsedDays = different / hoursInMilli;
        return elapsedDays;
      }
    
      public static void main(String[] args)
      {
        System.out.println(currentDate());
      }
    
      public static int currentDate()
      {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int date = 0;
        date += calendar.get(1) * 10000;
        date += calendar.get(2) * 100;
        date += calendar.get(5);
        return date;
      }
    }

/* Location:           D:\新建文件夹\bard-cms-0.0.1-SNAPSHOT\WEB-INF\classes\
 * Qualified Name:     com.bard.davol.util.DateUtils
 * JD-Core Version:    0.5.4
 */