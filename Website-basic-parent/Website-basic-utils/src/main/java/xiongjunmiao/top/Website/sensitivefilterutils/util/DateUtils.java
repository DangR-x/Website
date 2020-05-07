package xiongjunmiao.top.Website.utils.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by qiaohao on 2017/9/15.
 */
@Slf4j
public class DateUtils {
    public static final String formatStr_yyyyMMddHHmmssS_ = "yyyyMMddHHmmss";
    public static final String formatStr_yyyyMMddHHmmssS = "yyyy-MM-dd HH:mm:ss.S";
    public static final String formatStr_yyyyMMddHHmmssSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String formatStr_yyyyMMddHHmmssSSS_NO = "yyyyMMddHHmmssSSS";
    public static final String formatStr_yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String formatStr_yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
    public static final String formatStr_yyyyMMddHH = "yyyy-MM-dd HH";
    public static final String formatStr_yyyyMMdd_bias = "yyyy/MM/dd";
    public static final String formatStr_yyyyMMdd = "yyyy-MM-dd";
    public static final String formatStr_yyyyMM = "yyyy-MM";
    public static final String formatStr_yyyyMM_NO = "yyyyMM";
    public static final String formatStr_yyyyMMd_NO = "yyyyMMdd";
    public static final String formatStr_yyMMd_NO = "yyMMdd";
    public static final String formatStr_HHmmss = "HH:mm:ss";
    public static final String formatStr_HHmm = "HH:mm";
    public static final String formatStr_HHmmss_NO = "HHmmss";
    public static final String formatStr_yyyy = "yyyy";
    public static final String formatStr_yyyyMMddDelimiter = "-";
    public static final String formatStr_dd = "dd";
    public static final String formatStr_yyyymm = "yyyy.MM";
    public static final String formatStr_mm = "mm";
    public static final String formatStr_HH = "HH";
    public static final String formatStr_yyyyMMddChinese = "yyyy年MM月dd日";
    public static final String max_date_str = "20991231235959";
    public static final String yyyy = "yyyy";
    public static final String MM = "MM";
    public static final String dd = "dd";


    /**
     * @return
     * @throws
     * @Title:
     * @Description: 获取时间戳
     * @author qiaomengnan
     * @date 2019/05/09 10:47:39
     */
    public synchronized static String getDateNo() {
        return getNowDateStr(formatStr_yyyyMMddHHmmssSSS_NO);
    }

    public static Date getNowDate() {
        return new Date();
    }

    public static String getNowDateStr(String format) {
        if (StringUtils.isTrimBlank(format))
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(getNowDate());
    }

    public static String dateToStr(Date date, String format) {
        if (date == null || StringUtils.isTrimBlank(format))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date strToDate(String dateStr, String format) {
        if (StringUtils.isContainTrimBlank(dateStr, format))
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 当前日
     *
     * @return
     */
    public static String getCurrentDay() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("dd").format(ts);
    }

    /**
     * 当前月的 下12个的数组
     *
     * @return
     */
    public static String getNextMonth() {
        String ret = new String();
        int nextYear = Integer.parseInt(getCurrentYear());
        ;
        int nextMonth = Integer.parseInt(getCurrentMonth());

        nextMonth++;
        if (nextMonth > 12) {
            nextYear++;
            nextMonth = 1;
        }
        String mth = "";
        if (nextMonth < 10) {
            mth = "0" + nextMonth;
        } else {
            mth = nextMonth + "";
        }
        ret = new String(String.valueOf(nextYear) + mth);

        return ret;
    }

    /**
     * 当前月
     *
     * @return
     */
    public static String getCurrentMonth() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("MM").format(ts);
    }

    /**
     * 当前年
     *
     * @return
     */
    public static String getCurrentYear() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy").format(ts);
    }

    /*
     * 根据date类日期返回yyyymmdd类型的日期
     *
     */
    public static String getStringDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc
                .get(Calendar.DATE));
        return sdf.format(gc.getTime());
    }

    /*
     * 根据date类日期返回指定格式的类型的日期
     *
     */
    public static String getStringDate(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc
                .get(Calendar.DATE));
        return sdf.format(gc.getTime());
    }

    /**
     * @param
     * @return java.lang.String
     * @throws
     * @Title: getCurrentDateString
     * @Description:获取当前时间字符串(yyyMMdd) eg:20170918
     * @author qiaohao
     * @date 2017/11/17 11:17:04
     */
    public static String getCurrentDateString() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMdd").format(ts);
    }

    /**
     * 获取当前时间 HHmmss
     */
    public static String getCurrentTime() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String currentTime = new SimpleDateFormat("HHmmss").format(ts);
        return currentTime;
    }


    /**
     * @param stDate
     * @param endDate
     * @return boolean
     * @throws
     * @Title: currentDateInRange
     * @Description:
     * @author qiaohao
     * @date 2017/11/17 11:22:48
     */
    public static boolean currentDateInRange(Integer stDate, Integer endDate) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(ts);
        if (currentDate == null || "".equals(currentDate)) {
            return false;
        }
        return (Integer.valueOf(currentDate) >= stDate && Integer.valueOf(currentDate) <= endDate) ? true : false;
    }

    /**
     * @Description: 修改日期的月份, zl>0增加,zl<0减少 zl增加几个月 (1月31号加一月，会自动调整为2月28号或29号)
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/14 10:40
     */
    public static Date getAddMonth(Date startDate, int zl) {
        Calendar cal = null;
        cal = getCalendar(startDate);
        cal.add(Calendar.MONTH, zl);
        return cal.getTime();
    }

    /**
     * @param date 日期
     * @param day  天数
     * @return
     * @throws
     * @Title:
     * @Description: 在指定日期上添加指数定天
     * @author qiaomengnan
     * @date 2018/07/18 11:47:10
     */
    public static Date getAddDay(Date date, Integer day) {
        if (date != null && day != null) {
            Calendar calendar = getCalendar(date);
            if (calendar != null) {
                calendar.add(Calendar.DATE, day);
                return calendar.getTime();
            }
        }
        return null;
    }

    /**
     * @param date 日期
     * @param day  天数
     * @return
     * @throws
     * @Title:
     * @Description: 在指定日期上添加指数定天
     * @author qiaomengnan
     * @date 2018/07/18 11:47:10
     */
    public static Date getAddDay(Date date, String day) {
        if (date != null && StringUtils.isNotTrimBlank(day)) {
            return getAddDay(date, new Integer(day));
        }
        return null;
    }

//    public static void main(String [] args){
//
//        try {
//            System.out.println(DateUtils.dateToStr(getAddDay(strToDate("2018-02-28",formatStr_yyyyMMdd),new Integer(1)),formatStr_yyyyMMdd));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        ;
//
//    }


    /*
     * 把Date转化成Calendar
     */
    public static Calendar getCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal;
    }

    /*
     * 根据string 类型日期返回date类
     */
    public static Date getDateForString(String day) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date = sdf.parse(day);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /*
     * 根据string 类型日期返回date类,格式为yyyyMMddHHmmss
     */
    public static Date getDateTime(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr_yyyyMMddHHmmssS_);
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDateTime() {
        return getNowDateStr(formatStr_yyyyMMddHHmmssS_);
    }


    /**
     * @param
     * @return
     * @throws
     * @Title: 得到当前系统日期 :
     * @Description: 当前日期的格式字符串, 日期格式为"yyyy-MM-dd HH:mi:ss"
     * @author chenshunhua
     * @date 2017/11/22 03:10:32
     */
    public static String getCurrentDateTime() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Date today = new Date();
        String tString = df.format(today);
        return tString;
    }

    public static int getYear(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int resYear = 0;
        try {
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(sdf.parse(date1));
            aft.setTime(sdf.parse(date2));
            resYear = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR));
            int month = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            if (month > 0) {
                // 不足一年按照一年计算
                resYear = resYear + 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resYear;
    }

    /**
     * <li>功能描述：时间相减得到月数【yyyyMMdd】
     *
     * @param date1 被减日期
     * @param date2 日期
     * @return long          月数
     * @author Administrator
     */
    public static int getMonth(String date1, String date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int resMonth = 0;
        try {
            Calendar bef = Calendar.getInstance();
            Calendar aft = Calendar.getInstance();
            bef.setTime(sdf.parse(date1));
            aft.setTime(sdf.parse(date2));
            int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
            resMonth = Math.abs(month + result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resMonth;
    }


    /**
     * <li>功能描述：时间相减得到天数
     *
     * @param date1 被减日期
     * @param date2 日期
     * @return long          月数
     * @author Administrator
     */
    public static int getDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            return day2 - day1;
        }
    }

    /**
     * 某年 某月中最大的天数
     *
     * @param year
     * @param mon
     * @return
     */
    public static int getMaxDayOfMonth(int year, int mon) {
        int dqnd = year;
        int dqyd = mon;
        String dqydstr = "";
        if (dqyd == 12) {
            dqnd++;
            dqyd = 1;
        } else {
            dqyd++;
        }
        if (dqyd < 10) {
            dqydstr = "0" + dqyd;
        } else {
            dqydstr = dqyd + "";
        }
        java.sql.Date xydyt = java.sql.Date.valueOf(dqnd + "-" + dqydstr + "-01");
        Timestamp ts = new Timestamp(xydyt.getTime() - 86400000L);
        String day = new SimpleDateFormat("dd").format(ts);
        return Integer.parseInt(day);
    }

    //得到当前日期对应的下个月日期 如果下个月没有这天 则取最后一天
    public static String getNextDayByDay(String month, int day) {
        String hkday = month + (day < 10 ? "0" + day : (day + ""));
        int maxdayofmonth = DateUtils.getMaxDayOfMonth(Integer.parseInt(month.substring(0, 4)), Integer.parseInt(month.substring(4, 6)));//当前月份的最大天数
        if (maxdayofmonth < day) {
            hkday = month + (maxdayofmonth < 10 ? "0" + maxdayofmonth : (maxdayofmonth + ""));
        }
        return hkday;
    }

    public static String getDqsj(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(data);
    }

    //根据当前日期和还款日取得首期还款日期-期初支付
    public static String getFirstDateEndMode(String repayDay) {
        String skmonth = DateUtils.getNextMonth();//下个收款月份
        return DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));
    }


    //根据当前日期和还款日取得首期还款日期-期末支付
    public static String getFirstDateBeginMode(String repayDay) {
        String skmonth;
        if (Integer.valueOf(repayDay) > Integer.valueOf(DateUtils.getCurrentDay())) {
            skmonth = DateUtils.getNowDateStr(DateUtils.formatStr_yyyy + DateUtils.formatStr_dd);//当月
        } else {
            skmonth = DateUtils.getNextMonth();//下个收款月份
        }
        return DateUtils.getNextDayByDay(skmonth, Integer.valueOf(repayDay));
    }

    //根据当前日期是否最后一天
    public static boolean isEndOfMonth(Date date) {
        Date nextDay = getAddDay(date, 1);
        if (!dateToStr(nextDay, formatStr_mm).equals(dateToStr(date, formatStr_mm))) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 取得最大日期 2099-12-31 23:59:59
     */
    public static Date getMaxDate() {
        return getDateTime(max_date_str);
    }

    /**
     * @param val1 val2
     * @return
     * @throws
     * @Title:
     * @Description: 是否相等
     * @author qiaomengnan
     * @date 2018/12/12 05:56:42
     */
    public static boolean equals(Date val1, Date val2) {
        if (val1 == null || val2 == null)
            return val1 == val2;
        else
            return val1.getTime() == val2.getTime();
    }

    /**
     * @param val1 val2
     * @return
     * @throws
     * @Title:
     * @Description: 是否不相等
     * @author qiaomengnan
     * @date 2018/12/12 05:55:35
     */
    public static boolean notEquals(Date val1, Date val2) {
        return !equals(val1, val2);
    }

    /**
     * @param date
     * @return
     * @throws
     * @Title:
     * @Description: 返回周几  0.周日  往下排
     * @author qiaomengnan
     * @date 2019/03/06 04:11:26
     */
    public static int getWeekDay(Date date) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            return week;
        }
        return -1;
    }

    /**
     * @param date
     * @return
     * @throws
     * @Title:
     * @Description: 判断是否是周末
     * @author qiaomengnan
     * @date 2019/03/06 04:13:42
     */
    public static boolean weekend(Date date) {
        if (date != null) {
            int week = getWeekDay(date);
            if (week == 0 || week == 6)
                return true;
        }
        return false;
    }

    /**
     * @param date
     * @return
     * @throws
     * @Title:
     * @Description: 获取小时
     * @author qiaomengnan
     * @date 2019/03/06 04:18:41
     */
    public static int getHour(Date date) {
        return getDateInt(date, DateUtils.formatStr_HH);
    }

    /**
     * @param date
     * @return
     * @throws
     * @Title:
     * @Description: 获取分钟
     * @author qiaomengnan
     * @date 2019/03/06 04:30:28
     */
    public static int getMinute(Date date) {
        return getDateInt(date, DateUtils.formatStr_mm);
    }

    /**
     * @param begin end date
     * @return
     * @throws
     * @Title:
     * @Description: 判断小时是否在区间中
     * @author qiaomengnan
     * @date 2019/03/06 04:23:34
     */
    public static boolean hourSection(int begin, int end, Date date) {
        if (date != null) {
            int hour = getHour(date);
            if (hour >= begin && hour <= end) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param date values
     * @return
     * @throws
     * @Title:
     * @Description: 判断分钟是否在区间内
     * @author qiaomengnan
     * @date 2019/03/06 04:33:54
     */
    public static boolean minuteSection(Date date, int... values) {
        return IntegerUtils.containValue(values, getMinute(date));
    }

    /**
     * @param date format
     * @return
     * @throws
     * @Title:
     * @Description: 将日期的某个部分转换成int类型
     * @author qiaomengnan
     * @date 2019/03/06 04:28:46
     */
    public static int getDateInt(Date date, String format) {
        if (date != null && StringUtils.isNotTrimBlank(format)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            try {
                return Integer.parseInt(simpleDateFormat.format(date));
            } catch (Exception ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
            }
        }
        return -1;
    }

    /**
     * @param beginTime endTime
     * @return
     * @throws
     * @Title:
     * @Description: 获取小时百分比
     * @author qiaomengnan
     * @date 2019/03/11 01:17:28
     */
    public static BigDecimal getHour(Date beginTime, Date endTime) {
        if (beginTime != null && endTime != null) {
            BigDecimal second = new BigDecimal((endTime.getTime() - beginTime.getTime()) / 1000 + "");
            BigDecimal minute = second.divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal hour = minute.divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
            return hour;
        }
        return BigDecimal.ZERO;
    }


    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

}
