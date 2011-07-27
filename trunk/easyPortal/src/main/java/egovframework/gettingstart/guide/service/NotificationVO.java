package egovframework.gettingstart.guide.service;

import org.apache.commons.lang.builder.ToStringBuilder;

import egovframework.gettingstart.web.vo.CommonVO;

/**
 * 정보알림이 서비스를 위한 VO 클래스
 * 
 * @author 개발팀 홍길동
 * @since 2011.01.01
 * @version 1.0
 * @see <pre>
 * &lt;&lt; 개정이력(Modification Information) &gt;&gt;
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.01.01  홍길동          최초 생성
 * 
 * </pre>
 */
@SuppressWarnings("serial")
public class NotificationVO extends CommonVO {

    /** 알림 번호 */
    private String notificationId = "";

    /** 알림 제목 */
    private String notificationSubject = "";

    /** 알림 내용 */
    private String notificationContents = "";

    /** 알림 시간 */
    private String notificationDate = "";

    /** 알림 시간 */
    private String notificationTime = "";

    /** 사전 알림 간격 */
    private String[] interval = new String[0];

    /** 사전 알림 간격 문자열 */
    private String intervalString = "";

    /** 최초등록자 아이디 */
    private String registerUserId = "";

    /** 최초 등록자명 */
    private String registerUserName = "";

    /** 최초등록시점 */
    private String registerDateTime = "";

    /** 최종수정자 아이디 */
    public String updateUserId = "";

    /** 최종수정시점 */
    private String updateDateTime = "";

    /** 유일 아이디 */
    private String userId = "";

    /** 알림 시간 */
    private String notificationHour = "";

    /** 알림 시간 */
    private String notificationMinute = "";

    /** 정보알림이 표시를 위한 시작일 및 시작시간 */
    private String startDateTime = "";

    /** 정보알림이 표시를 위한 종료일 및 종료시간 */
    private String endDateTime = "";
    
    private String minuteLabel = "m";


    /**
     * notificationId attribute를 리턴한다.
     * 
     * @return the notificationId
     */
    public String getNotificationId() {
	return notificationId;
    }

    /**
     * notificationId attribute 값을 설정한다.
     * 
     * @param notificationId the notificationId to set
     */
    public void setNotificationId(String notificationId) {
	this.notificationId = notificationId;
    }

    /**
     * notificationSubject attribute를 리턴한다.
     * 
     * @return the notificationSubject
     */
    public String getNotificationSubject() {
	return notificationSubject;
    }

    /**
     * notificationSubject attribute 값을 설정한다.
     * 
     * @param notificationSubject the notificationSubject to set
     */
    public void setNotificationSubject(String notificationSubject) {
	this.notificationSubject = notificationSubject;
    }

    /**
     * notificationContents attribute를 리턴한다.
     * 
     * @return the notificationContents
     */
    public String getNotificationContents() {
	return notificationContents;
    }

    /**
     * notificationContents attribute 값을 설정한다.
     * 
     * @param notificationContents the notificationContents to set
     */
    public void setNotificationContents(String notificationContents) {
	this.notificationContents = notificationContents;
    }

    /**
     * notificationDate attribute를 리턴한다.
     * 
     * @return the notificationDate
     */
    public String getNotificationDate() {
	return notificationDate;
    }

    /**
     * notificationDate attribute 값을 설정한다.
     * 
     * @param notificationDate the notificationDate to set
     */
    public void setNotificationDate(String notificationDate) {
	this.notificationDate = notificationDate;
    }

    /**
     * notificationTime attribute를 리턴한다.
     * 
     * @return the notificationTime
     */
    public String getNotificationTime() {
	return notificationTime;
    }

    /**
     * notificationTime attribute 값을 설정한다.
     * 
     * @param notificationTime the notificationTime to set
     */
    public void setNotificationTime(String notificationTime) {
	this.notificationTime = notificationTime;
    }

    /**
     * interval attribute를 리턴한다.
     * 
     * @return the interval
     */
    public String[] getInterval() {
	return interval;
    }

    /**
     * interval attribute 값을 설정한다.
     * 
     * @param interval the interval to set
     */
    public void setInterval(String[] interval) {
	this.interval = interval;
    }

    /**
     * intervalString attribute를 리턴한다.
     * 
     * @return the intervalString
     */
    public String getIntervalString() {
	return intervalString;
    }

    /**
     * intervalString attribute 값을 설정한다.
     * 
     * @param intervalString the intervalString to set
     */
    public void setIntervalString(String intervalString) {
	this.intervalString = intervalString;
    }

    /**
     * registerUserId attribute를 리턴한다.
     * 
     * @return the registerUserId
     */
    public String getRegisterUserId() {
	return registerUserId;
    }

    /**
     * registerUserId attribute 값을 설정한다.
     * 
     * @param frstRegisterId the registerUserId to set
     */
    public void setRegisterUserId(String registerUserId) {
	this.registerUserId = registerUserId;
    }

    /**
     * registerUserName attribute를 리턴한다.
     * 
     * @return the registerUserName
     */
    public String getRegisterUserName() {
	return registerUserName;
    }

    /**
     * registerUserName attribute 값을 설정한다.
     * 
     * @param registerUserName the registerUserName to set
     */
    public void setRegisterUserName(String registerUserName) {
	this.registerUserName = registerUserName;
    }

    /**
     * registerDateTime attribute를 리턴한다.
     * 
     * @return the registerDateTime
     */
    public String getRegisterDateTime() {
	return registerDateTime;
    }

    /**
     * registerDateTime attribute 값을 설정한다.
     * 
     * @param registerDateTime the registerDateTime to set
     */
    public void setRegisterDateTime(String registerDateTime) {
	this.registerDateTime = registerDateTime;
    }

    /**
     * updateUserId attribute를 리턴한다.
     * 
     * @return the updateUserId
     */
    public String getUpdateUserId() {
	return updateUserId;
    }

    /**
     * updateUserId attribute 값을 설정한다.
     * 
     * @param updateUserId the updateUserId to set
     */
    public void setUpdateUserId(String updateUserId) {
	this.updateUserId = updateUserId;
    }

    /**
     * updateDateTime attribute를 리턴한다.
     * 
     * @return the updateDateTime
     */
    public String getUpdateDateTime() {
	return updateDateTime;
    }

    /**
     * updateDateTime attribute 값을 설정한다.
     * 
     * @param updateDateTime the updateDateTime to set
     */
    public void setUpdateDateTime(String updateDateTime) {
	this.updateDateTime = updateDateTime;
    }

    /**
     * userId attribute를 리턴한다.
     * 
     * @return the userId
     */
    public String getUserId() {
	return userId;
    }

    /**
     * userId attribute 값을 설정한다.
     * 
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
	this.userId = userId;
    }

    /**
     * notificationHour attribute를 리턴한다.
     * 
     * @return the notificationHour
     */
    public String getNotificationHour() {
	return notificationHour;
    }

    /**
     * notificationHour attribute 값을 설정한다.
     * 
     * @param notificationHour the notificationHour to set
     */
    public void setNotificationHour(String notificationHour) {
	this.notificationHour = notificationHour;
    }

    /**
     * notificationMinute attribute를 리턴한다.
     * 
     * @return the notificationMinute
     */
    public String getNotificationMinute() {
	return notificationMinute;
    }

    /**
     * notificationMinute attribute 값을 설정한다.
     * 
     * @param notificationMinute the notificationMinute to set
     */
    public void setNotificationMinute(String notificationMinute) {
	this.notificationMinute = notificationMinute;
    }

    /**
     * startDateTime attribute를 리턴한다.
     * 
     * @return the startDateTime
     */
    public String getStartDateTime() {
	return startDateTime;
    }

    /**
     * startDateTime attribute 값을 설정한다.
     * 
     * @param startDateTime the startDateTime to set
     */
    public void setStartDateTime(String startDateTime) {
	this.startDateTime = startDateTime;
    }

    /**
     * endDateTime attribute를 리턴한다.
     * 
     * @return the endDateTime
     */
    public String getEndDateTime() {
	return endDateTime;
    }

    /**
     * endDateTime attribute 값을 설정한다.
     * 
     * @param endDateTime the endDateTime to set
     */
    public void setEndDateTime(String endDateTime) {
	this.endDateTime = endDateTime;
    }

    /**
     * minuteLabel attribute를 리턴한다.
     * 
     * @return the minuteLabel
     */
    public String getMinuteLabel() {
	return minuteLabel;
    }

    /**
     * minuteLabel attribute 값을 설정한다.
     * 
     * @param minuteLabel the minuteLabel to set
     */
    public void setMinuteLabel(String minuteLabel) {
	this.minuteLabel = minuteLabel;
    }

    /**
     * toString 메소드를 대치한다.
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }
}