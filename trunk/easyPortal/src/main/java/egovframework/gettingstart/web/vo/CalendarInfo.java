package egovframework.gettingstart.web.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CalendarInfo implements Serializable {
    /** 년 */
    private String year = "";

    /** 월 */
    private String month = "";

    /** 일 */
    private String day = "";

    /** 달력셀 */
    private int cellNum = 0;

    /** 월별 주순위 */
    private int weeks = 0;

    /** 월 주수 */
    private int maxWeeks = 0;

    /** 요일 */
    private int week = 0;

    /** 시작요일 */

    private int startWeekMonth = 0;

    /** 마지막 일자 */
    private int lastDayMonth = 0;

    /**
     * year attribute 를 리턴한다.
     * 
     * @return String
     */
    public String getYear() {
    	return year;
    }

    /**
     * year attribute 값을 설정한다.
     * 
     * @param year String
     */
    public void setYear(String year) {
    	this.year = year;
    }

    /**
     * month attribute 를 리턴한다.
     * 
     * @return String
     */
    public String getMonth() {
    	return month;
    }

    /**
     * month attribute 값을 설정한다.
     * 
     * @param month String
     */
    public void setMonth(String month) {
    	this.month = month;
    }

    /**
     * day attribute 를 리턴한다.
     * 
     * @return String
     */
    public String getDay() {
    	return day;
    }

    /**
     * day attribute 값을 설정한다.
     * 
     * @param day String
     */
    public void setDay(String day) {
    	this.day = day;
    }

    /**
     * cellNum attribute 를 리턴한다.
     * 
     * @return int
     */
    public int getCellNum() {
    	return cellNum;
    }

    /**
     * cellNum attribute 값을 설정한다.
     * 
     * @param cellNum int
     */
    public void setCellNum(int cellNum) {
    	this.cellNum = cellNum;
    }

    /**
     * weeks attribute 를 리턴한다.
     * 
     * @return int
     */
    public int getWeeks() {
    	return weeks;
    }

    /**
     * weeks attribute 값을 설정한다.
     * 
     * @param weeks int
     */
    public void setWeeks(int weeks) {
    	this.weeks = weeks;
    }

    /**
     * maxWeeks attribute 를 리턴한다.
     * 
     * @return int
     */
    public int getMaxWeeks() {
    	return maxWeeks;
    }

    /**
     * maxWeeks attribute 값을 설정한다.
     * 
     * @param maxWeeks int
     */
    public void setMaxWeeks(int maxWeeks) {
    	this.maxWeeks = maxWeeks;
    }

    /**
     * week attribute 를 리턴한다.
     * 
     * @return int
     */
    public int getWeek() {
    	return week;
    }

    /**
     * week attribute 값을 설정한다.
     * 
     * @param week int
     */
    public void setWeek(int week) {
    	this.week = week;
    }

    /**
     * startWeekMonth attribute 를 리턴한다.
     * 
     * @return int
     */
    public int getStartWeekMonth() {
    	return startWeekMonth;
    }

    /**
     * startWeekMonth attribute 값을 설정한다.
     * 
     * @param startWeekMonth int
     */
    public void setStartWeekMonth(int startWeekMonth) {
    	this.startWeekMonth = startWeekMonth;
    }

    /**
     * lastDayMonth attribute 를 리턴한다.
     * 
     * @return int
     */
    public int getLastDayMonth() {
    	return lastDayMonth;
    }

    /**
     * lastDayMonth attribute 값을 설정한다.
     * 
     * @param lastDayMonth int
     */
    public void setLastDayMonth(int lastDayMonth) {
    	this.lastDayMonth = lastDayMonth;
    }
}