package egovframework.gettingstart.guide.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import egovframework.gettingstart.guide.service.NotificationService;
import egovframework.gettingstart.guide.service.NotificationVO;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * 정보알림이를 위한 서비스 구현 클래스
 * @author 개발팀 홍길동
 * @since 2011.01.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.01.01  홍길동          최초 생성
 *
 * </pre>
 */
/*
 * TODO [Step 2-2] @Service 지정
 * 클래스에 @Service(org.springframework.stereotype.Service) annotation을 지정
 * @Service, @Repository, @Controller (@Component 상속) 등을 통해 Bean을 정의할 수 있음
 * id는 "NotificationService"로 지정함
 * ex: @Service("NotificationService")
 */
/*
 * TODO [Step 1-2] Service 구현체 정의 
 * NotificationService를 implement하고, interface 메소드에 대하여 구현 확인
 * 전자정부 표준프레임워크의 AbstractServiceImpl을 extends 하여 적용할 수 있음
 * ex: public class NotificationServiceImpl extends AbstractServiceImpl implements NotificationService {
 */
@Service("NotificationService")
public class NotificationServiceImpl extends AbstractServiceImpl implements NotificationService {

	/*
	 * TODO [Step 2-3] @Resource를 통한 DI (Dependency Injection)지정
	 * 멤버 변수에 @Resource 지정을 통해 DAO를 Injection하여 사용함 
	 * name에 지정하고자 하는 bean(@Repository)의 id를 지정함 ("NotificationDAO")
	 * ex : @Resource(name="NotificationDAO")
	 * 
	 * 이 때 setDao() setter는 필요하지 않음 (삭제 가능)
	 */
    @Resource(name="NotificationDAO")
    private NotificationDAO notificationDao;
    
    public void setDao(NotificationDAO notificationDao) {
    	this.notificationDao = notificationDao;
    }
    
    private Logger logger = Logger.getLogger(this.getClass());	// Logger 처리
    
    /**
     * 정보알림이 목록을 조회 한다.
     */
    public Map<String, Object> selectNotificationList(NotificationVO searchVO) throws Exception {
    	List<NotificationVO> result = notificationDao.selectNotificationList(searchVO);
    	int cnt = notificationDao.selectNotificationListCnt(searchVO);

    	Map<String, Object> map = new HashMap<String, Object>();
	
    	map.put("resultList", result);
    	map.put("resultCnt", Integer.toString(cnt));

    	return map;
    }
    
    /**
     * 정보알림이 정보를 등록한다.
     */
    public void insertNotification(NotificationVO notification) throws Exception {
		//---------------------------------------
		// 알림일자 및 시작 지정
		//---------------------------------------
		StringBuffer time = new StringBuffer();
	
		time.append(notification.getNotificationDate().replaceAll("-", ""));
		time.append(notification.getNotificationHour().length() == 1 ? "0" + notification.getNotificationHour() : notification.getNotificationHour());
		time.append(notification.getNotificationMinute().length() == 1 ? "0" + notification.getNotificationMinute() : notification.getNotificationMinute());
		time.append("00");
	
		notification.setNotificationTime(time.toString());
	
		logger.debug("TIME : " + notification.getNotificationTime());
	
		//---------------------------------------
		// 사전 알림간격 지정
		//---------------------------------------
		StringBuffer interval = new StringBuffer();
	
		String[] array = notification.getInterval();
	
		for (int i = 0; i < array.length; i++) {
		    if (i != 0) {
			interval.append(",");
		    }
	
		    interval.append(array[i]);
		}
	
		notification.setIntervalString(interval.toString());
	
		//---------------------------------------
		// 등록 처리
		//---------------------------------------
		notificationDao.insertNotification(notification);
    }
    
    /**
     * 알림메시지에 대한 상세정보를 조회한다.
     */
    public NotificationVO selectNotification(NotificationVO searchVO) throws Exception {
    	NotificationVO resultVO = notificationDao.selectNotification(searchVO);
    	
    	if (resultVO == null) {
            throw new Exception();//TODO processException("info.nodata.msg");	// Exception 메시지 처리 시..
    	}
    	
    	return resultVO;
    }
    
    /**
     * 정보알림이 정보를 수정한다.
     */
    public void updateNotification(NotificationVO notification) throws Exception {
		//---------------------------------------
		// 알림일자 및 시작 지정
		//---------------------------------------
		StringBuffer time = new StringBuffer();
	
		time.append(notification.getNotificationDate().replaceAll("-", ""));
		time.append(notification.getNotificationHour().length() == 1 ? "0" + notification.getNotificationHour() : notification.getNotificationHour());
		time.append(notification.getNotificationMinute().length() == 1 ? "0" + notification.getNotificationMinute() : notification.getNotificationMinute());
		time.append("00");
	
		notification.setNotificationTime(time.toString());
	
		logger.debug("TIME : " + notification.getNotificationTime());
	
		//---------------------------------------
		// 사전 알림간격 지정
		//---------------------------------------
		StringBuffer interval = new StringBuffer();
	
		String[] array = notification.getInterval();
	
		for (int i = 0; i < array.length; i++) {
		    if (i != 0) {
			interval.append(",");
		    }
	
		    interval.append(array[i]);
		}
	
		notification.setIntervalString(interval.toString());
	
		//---------------------------------------
		// 수정 처리
		//---------------------------------------
		notificationDao.updateNotification(notification);
    }
    
    /**
     * 정보알림이 정보를 삭제한다.
     */
    public void deleteNotification(NotificationVO notification) throws Exception {
    	notificationDao.deleteNotification(notification);
    }
    
    /**
     * 정보알림이 알림시간 등에 대한 점검을 수행한다.
     */
    public boolean checkNotification(NotificationVO notification) throws Exception {
		//---------------------------------------
		// 알림일자 및 시작 지정
		//---------------------------------------
		StringBuffer time = new StringBuffer();
	
		time.append(notification.getNotificationDate().replaceAll("-", ""));
		time.append(notification.getNotificationHour().length() == 1 ? "0" + notification.getNotificationHour() : notification.getNotificationHour());
		time.append(notification.getNotificationMinute().length() == 1 ? "0" + notification.getNotificationMinute() : notification.getNotificationMinute());
		time.append("00");
	
		logger.debug("TIME : " + time.toString());
	
		//---------------------------------------
		// 시간 지정
		//---------------------------------------
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar alarm = Calendar.getInstance();
		alarm.setTime(formatter.parse(time.toString()));
	
		Calendar current = Calendar.getInstance();
		current.add(Calendar.MINUTE, -1);
	
		if (current.after(alarm)) {
		    return false;
		}
	
		return true;
    }
		    
    private String getDateTimeWithoutSec(Calendar cal) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	
		return formatter.format(cal.getTime()).substring(0, 12);
    }
	    
    /**
     * 정보알림이 정보 표시를 수행한다.
     */
    public List<NotificationVO> selectNotificationData() throws Exception {
    	List<NotificationVO> result = new ArrayList<NotificationVO>();

		//------------------------------------------
		// 검색 조건 지정
		//------------------------------------------
		NotificationVO vo = new NotificationVO();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat other = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 전후 1시간 조건 지정..
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();

		start.add(Calendar.HOUR, -1);
		end.add(Calendar.HOUR, 1);

		vo.setStartDateTime(formatter.format(start.getTime()));
		vo.setEndDateTime(formatter.format(end.getTime()));
		////----------------------------------------

		List<NotificationVO> target = notificationDao.getNotificationData(vo);

		Calendar current = Calendar.getInstance();
		for (int i = 0; i < target.size(); i++) {
			vo = target.get(i);

			String[] interval = ("0," + vo.getIntervalString()).split(",");

			for (int j = 0; j < interval.length; j++) {
				Calendar alarm = Calendar.getInstance();
				alarm.setTime(other.parse(vo.getNotificationTime()));

				alarm.add(Calendar.MINUTE, -1 * Integer.parseInt(interval[j]));

				if (getDateTimeWithoutSec(current).equals(getDateTimeWithoutSec(alarm))) {

					result.add(vo);
					break;
				}
			}
		}
	
		return result;
    }
}
