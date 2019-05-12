package com.sd.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateManager {
	
    /**
     * 将日期转换为string
     * @param date
     * @return
     */
    public static String dateFormat(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    
    /**
     * 将日期转换为string 20111123
     * @param date
     * @return
     */
    
    public static String dateFormates(Date date){
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	return sdf.format(date);
    }
    //精确到秒
    public static String dateFormatesSend(Date date){
    	SimpleDateFormat   sdf   =   new   SimpleDateFormat( "yyyy-MM-dd",Locale.CHINA); 
   	return sdf.format(date);
   }
  
    /**
     * 将日期使时间转换为string
     * @param date
     * @return
     */
    public static String dateFormatTime(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    public static String dateFormatTimes(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }
    /**
     * 将string转换为日期
     * @param date  yyyy-MM-dd
     * @return
     * @throws ParseException 
     */
    public static Date stringFormat(String date)
    {
        try
        {  
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(date.trim());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static Date stringFormats(String date)
    {
        try
        {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
            return format.parse(date.trim());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将string转换为日期
     * @param date  yyyy-MM-dd
     * @return
     * @throws ParseException 
     */
    public static Date stringFormatTime(String date)
    {
        try
        {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.parse(date.trim());
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }
   
    /**
     * 返回前多少天和后多少天日期
     * @param days 天数，5前5天日期，-5后五天日期
     * @param format 返回日期字符格式
     * @return
     */
    public static String DateBefAft()
    {   
     	SimpleDateFormat ssd = new SimpleDateFormat("yyyy-MM-dd");
     	Calendar curr = Calendar.getInstance();
     	curr.set(Calendar.DAY_OF_MONTH,curr.get(Calendar.DAY_OF_MONTH)-5);
     	Date date=curr.getTime();
     	return ssd.format(date);
    }
    public static String getBackDate(int i){
     	SimpleDateFormat ssd = new SimpleDateFormat("yyyy-MM-dd");
     	Calendar curr = Calendar.getInstance();
     	curr.set(Calendar.DAY_OF_MONTH,curr.get(Calendar.DAY_OF_MONTH)-i);
     	Date date=curr.getTime();
     	return ssd.format(date);
    }
    
    public static String getBackDates(int i){
     	SimpleDateFormat ssd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     	Calendar curr = Calendar.getInstance();
     	curr.set(Calendar.DAY_OF_MONTH,curr.get(Calendar.DAY_OF_MONTH)+i);
     	Date date=curr.getTime();
     	return ssd.format(date);
    }
    public static String getBackDateshour(int i){
     	SimpleDateFormat ssd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     	Calendar curr = Calendar.getInstance();
     	curr.set(Calendar.HOUR,curr.get(Calendar.HOUR)+i);
     	Date date=curr.getTime();
     	return ssd.format(date);
    }
    /**
     * 输入一个日期和天数，得到输入日期加上输入的天数以后的日期
     * @param str 输入的日期 格式为 yyyy-MM-dd
     * @param day 天数 如：10
     * @return
     */
    public static String DateBef(String str, Integer day)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date d = sdf.parse(str);
            Calendar cd = Calendar.getInstance();
            cd.setTime(d);
            cd.add(Calendar.DAY_OF_YEAR, day);
            int year = cd.get(cd.YEAR);
            int month = cd.get(cd.MONTH) + 1;
            int day_of_month = cd.get(cd.DAY_OF_MONTH);
            int day_of_week = cd.get(cd.DAY_OF_WEEK) - 1;
            if (day_of_week == 0)
            {
                day_of_week += 7;
            }
            int hh = cd.get(cd.HOUR_OF_DAY);
            int mm=cd.get(cd.MINUTE);
            int ss=cd.get(cd.SECOND);
            return year+"-"+ month+"-"+day_of_month+" "+hh+":"+mm+":"+ss;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String getHour(String day,int i){
    	try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(day);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.HOUR_OF_DAY, i);
           // c.add(Calendar.MINUTE, 40);

            return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c
                    .getTime());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getDay(String day,int i){
	try {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(day);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, i);
        //c.add(Calendar.MINUTE, 40);

        return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c
                .getTime());

    } catch (Exception e) {
        e.printStackTrace();
     }
    return null;
    }
    
    public static int getDays(String day){
    	try{
    		Date date = new Date();
		    String today = date.toLocaleString();
		    long startT=DateManager.fromDateStringToLong(today);
		    long endT=DateManager.fromDateStringToLong(day);
			long ss=(endT-startT)/(1000); //共计秒数
			int MM = (int)ss/60;   //共计分钟数
			int hh=(int)ss/3600;  //共计小时数
			int dd=(int)hh/24;   //共计天数
			return dd;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    }
    //当前时间的
    public static int getfenzhong(){
    	try{
    		Date date = new Date();
		    String today = date.toLocaleString();
		    long startT=DateManager.fromDateStringToLong(today);
			long ss=startT/(1000); //共计秒数
			int MM = (int)ss/60;   //共计分钟数
			int hh=(int)ss/3600;  //共计小时数
			int dd=(int)hh/24;   //共计天数
			return MM;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    }
    
    public static int getorderfenzhong(String day){
    	try{
		   	    
		    long endT=DateManager.fromDateStringToLong(day);
			long ss=endT/(1000); //共计秒数
			int MM = (int)ss/60;   //共计分钟数
			int hh=(int)ss/3600;  //共计小时数
			int dd=(int)hh/24;   //共计天数
			return MM;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    }
    
	public static long fromDateStringToLong(String inVal) { //此方法计算时间毫秒
		  Date date = null;   //定义时间类型       
		  SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		  try { 
		  date = inputFormat.parse(inVal); //将字符型转换成日期型
		  } catch (Exception e) { 
		  e.printStackTrace(); 
		  } 
		  return date.getTime();   //返回毫秒数
	} 
	
	//获取n个自然月后天数   1、 如果是当月最后一天 就是n月后最后一天 2、如果不是当月最后一天但是大于n月后最后一天 取n月后最后一天 否则取n月后的对应当日 3、返回所取日期与参数日相差日数
	public static int getNaturalMonthDays(String datetime, int months){
		boolean isLastDay = checkIsLastDay(datetime);
		boolean isGreater = false;
		int alldays = 0;
		try {
			Calendar rightNow = Calendar.getInstance();
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rightNow.setTime(simpleDate.parse(datetime));
			if(isLastDay){
				rightNow.add(rightNow.MONTH, months);
				int nMonthLaterDay = rightNow.getActualMaximum(rightNow.DAY_OF_MONTH);
				rightNow.set(rightNow.DATE, nMonthLaterDay);
				long alldaysl = (rightNow.getTime().getTime() - (simpleDate.parse(datetime)).getTime())/(60000*60*24);
				alldays = (int)alldaysl/1;
			}else{
				rightNow.add(rightNow.MONTH, months);
				long alldaysl = (rightNow.getTime().getTime() - (simpleDate.parse(datetime)).getTime())/(60000*60*24);
				alldays = (int)alldaysl/1;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return alldays;
	}
	
	//获取n个自然月后时间  1、 如果是当月最后一天 就是n月后最后一天 2、如果不是当月最后一天但是大于n月后最后一天 取n月后最后一天 否则取n月后的对应当日 3、返回最后时间
	public static String getNaturalMonthTime(String datetime, int months){
		boolean isLastDay = checkIsLastDay(datetime);
		boolean isGreater = false;
		String alldays = "";
		try {
			Calendar rightNow = Calendar.getInstance();
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rightNow.setTime(simpleDate.parse(datetime));
			if(isLastDay){
				rightNow.add(rightNow.MONTH, months);
				int nMonthLaterDay = rightNow.getActualMaximum(rightNow.DAY_OF_MONTH);
				rightNow.set(rightNow.DATE, nMonthLaterDay);
				alldays = simpleDate.format(rightNow.getTime());
			}else{
				rightNow.add(rightNow.MONTH, months);
				alldays = simpleDate.format(rightNow.getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return alldays;
	}
	
	//获取n个自然月后时间
    public static String getBackDates(String datetime, int days){
    	Calendar rightNow = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			rightNow.setTime(simpleDate.parse(datetime));
			rightNow.set(rightNow.DAY_OF_MONTH,rightNow.get(rightNow.DAY_OF_MONTH)+days);
	     	date = rightNow.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
     	return simpleDate.format(date);
    }
	
	//判断是否是最后一天
	public static boolean checkIsLastDay(String datetime){
		try {
			Calendar rightNow = Calendar.getInstance();
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rightNow.setTime(simpleDate.parse(datetime));
			int currentday = rightNow.get(rightNow.DATE);
			int currentMonthday = rightNow.getActualMaximum(rightNow.DAY_OF_MONTH);
			if(currentday >= currentMonthday)return true;
			if(currentday < currentMonthday)return false;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//判断是否比n月后最后一天大
	public static boolean checkIsGreater(String datetime, int months){
		try {
			Calendar rightNow = Calendar.getInstance();
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rightNow.setTime(simpleDate.parse(datetime));
			int currentday = rightNow.get(rightNow.DATE);
			rightNow.add(rightNow.MONTH, months);
			int nMonthLaterDay = rightNow.getActualMaximum(rightNow.DAY_OF_MONTH);
			if(currentday >= nMonthLaterDay)return true;
			if(currentday < nMonthLaterDay)return false;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args0){
		System.out.println(getNaturalMonthDays("2013-01-32 08:57:50",1));
		System.out.println(getNaturalMonthTime("2013-01-32 08:57:50",1));
	}
}
