package org.wu.toolbox.common.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * SimpleDateFormat是非线程安全的，使用时如果需要考虑执行效率，可定义新的方法，不要修改现有方法
 * @author wusq
 * @date 2019/6/18
 */
public class DateUtils {

    public static final String FORMAT_DAY = "yyyy-MM-dd";
    public static final String FORMAT_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_TIME_LONG = "yyyyMMddHHmmss";

    /**
     * 清除传入时间的时分秒
     * @param date
     * @return date，时分秒全是0
     * @throws ParseException
     */
    public static Date clearHms(Date date)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DAY);
        return sdf.parse(sdf.format(date));
    }

    /**
     * 获取当月第一天的日期
     * @return date
     */
    public static Date getMonthFirstDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取当月第一天的日期
     * @return string
     */
    public static String getMonthFirstDay(){
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DAY);
        return sdf.format(getMonthFirstDate());
    }

    /**
     * 获取某日期下一个工作日
     * @param date
     * @return Date
     */
    public static Date getNextWorkDate(Date date){
        Date result = null;
        while(Boolean.TRUE){
            date = org.apache.commons.lang3.time.DateUtils.addDays(date, 1);
            if(isWorkDay(date)){
                result = date;
                break;
            }
        }
        return result;
    }

    /**
     * 获取某日期下一个工作日
     * @param date
     * @return String
     */
    public static String getNextWorkDay(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DAY);
        return sdf.format(getNextWorkDate(date));
    }

    /**
     * 字节数组转时间字符串
     * 年月日时分秒，每个字段1字节，年份19表示2019年
     * @param sb
     * @param bytes
     * @return 时间字符串
     */
    public static String getTime(StringBuilder sb, byte[] bytes){
        String year = "20";
        String zero = "0";
        sb.delete(0, sb.length());

        sb.append(year).append(bytes[0]);
        if(bytes[1] < 10){
            sb.append(zero);
        }
        sb.append(bytes[1]);
        if(bytes[2] < 10){
            sb.append(zero);
        }
        sb.append(bytes[2]);
        if(bytes[3] < 10){
            sb.append(zero);
        }
        sb.append(bytes[3]);
        if(bytes[4] < 10){
            sb.append(zero);
        }
        sb.append(bytes[4]);
        if(bytes[5] < 10){
            sb.append(zero);
        }
        sb.append(bytes[5]);

        return sb.toString();
    }

    /**
     * 时间转6字节数组
     * 年月日时分秒，每个字段1字节，年份19表示2019年
     * @param date
     * @return 6字节数组
     */
    public static byte[] getTime(Date date){
        int year = 2000;
        byte[] result = new byte[6];
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        result[0] = (byte) (calendar.get(Calendar.YEAR) - year);
        result[1] = (byte) (calendar.get(Calendar.MONTH) + 1);
        result[2] = (byte) calendar.get(Calendar.DATE);
        result[3] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
        result[4] = (byte) calendar.get(Calendar.MINUTE);
        result[5] = (byte) calendar.get(Calendar.SECOND);
        return result;
    }

    /**
     * 获取日期是周几
     * @param date
     * @return
     */
    public static Integer getWeekDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 判断是否是工作日
     * @param date
     * @return
     */
    public static boolean isWorkDay(Date date){
        Boolean result = Boolean.FALSE;
        int weekday = getWeekDay(date);
        if(1 <= weekday && weekday <= 5){
            result = Boolean.TRUE;
        }
        return result;
    }

    /**
     * 获取两个日期之间的所有日期
     * @param beginDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public static List<Date> listDates(Date beginDate, Date endDate) throws ParseException{
        List<Date> result = new ArrayList<>();

        // 需要将日期的时分秒清零
        beginDate = clearHms(beginDate);
        endDate = clearHms(endDate);

        result.add(beginDate);
        Date tmp = beginDate;
        Calendar calendar = Calendar.getInstance();
        while (tmp.before(endDate)){
            calendar.setTime(tmp);
            calendar.add(Calendar.DATE, 1);
            result.add(calendar.getTime());
            tmp = calendar.getTime();
        }
        return result;
    }

    /**
     * 获取两个日期之间的所有日期
     * @param beginDate 开始日期
     * @param endDate 结束日期
     * @return
     */
    public static List<String> listDays(Date beginDate, Date endDate) throws ParseException{
        List<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DAY);
        List<Date> dateList = listDates(beginDate, endDate);
        dateList.forEach(o -> result.add(sdf.format(o)));
        return result;
    }

    /**
     * 获取两个日期之间的所有日期
     * @param beginDay 开始日期
     * @param endDay 结束日期
     * @return
     */
    public static List<String> listDays(String beginDay, String endDay) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DAY);
        return listDays(sdf.parse(beginDay), sdf.parse(endDay));
    }

    public static void main(String[] args) throws Exception{
        System.out.println(getMonthFirstDate());
    }
}
