package egovframework.gettingstart.guide.service;

import java.util.List;
import java.util.Map;

/**
 * 정보알림이를 위한 서비스 인터페이스 클래스
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
public interface NotificationService {
    /*
     * TODO [Step 1-1] Interface 및 메소드 정의
     * 목록 데이터(resultList) 및 전체 건수(resultCnt)를 Map으로 return함
     * searchVO는 검색 조건으로 사용
     * ex: public Map<String, Object> selectNotificationList(NotificationVO searchVO) throws Exception;
     */
	public Map<String, Object> selectNotificationList(NotificationVO searchVO) throws Exception;
	
	/*
	 * TODO [Step 1-1] Interface 및 메소드 정의
	 * 등록을 처리함
	 * ex: public void insertNotification(NotificationVO notification) throws Exception;
	 */
	public void insertNotification(NotificationVO notification) throws Exception;
	
	/*
	 * TODO [Step 1-1] Interface 및 메소드 정의
	 * 상세조회 정보를 return함
	 * searchVO는 조회 대상 정보를 제공
	 * ex : public NotificationVO selectNotification(NotificationVO searchVO) throws Exception;
	 */
	public NotificationVO selectNotification(NotificationVO searchVO) throws Exception;
	
	/*
	 * TODO [Step 1-1] Interface 및 메소드 정의
	 * 정보를 수정함
	 * notification은 수정 정보를 제공
	 * ex : public void updateNotification(NotificationVO notification) throws Exception;
	 */
	public void updateNotification(NotificationVO notification) throws Exception;
	
	/*
	 * TODO [Step 1-1] Interface 및 메소드 정의
	 * 정보를 삭제함
	 * notification 삭제 대상 정보를 제공
	 * ex : public void deleteNotification(NotificationVO notification) throws Exception;
	 */
	public void deleteNotification(NotificationVO notification) throws Exception;
	
	//-------------------------------------------------------------------------------------------------
    /*
     * TODO [Step 1-1] Interface 및 메소드 정의 
     * => 상위 개별로 처리하지 않고 전체를 적용할 경우 사용
     * ex: 
     * 
     * public Map<String, Object> selectNotificationList(NotificationVO searchVO) throws Exception;
     * 
     * public void insertNotification(NotificationVO notification) throws Exception;
     * 
     * public NotificationVO selectNotification(NotificationVO searchVO) throws Exception;
     * 
     * public void updateNotification(NotificationVO notification) throws Exception;
     * 
     * public void deleteNotification(NotificationVO notification) throws Exception;
     */
	//-------------------------------------------------------------------------------------------------
    
    /**
     * 정보알림이 알림시간 등에 대한 점검을 수행한다.
     * 
     * @param notification
     * @return
     * @throws Exception
     */
    public boolean checkNotification(NotificationVO notification) throws Exception;
    
    /**
     * 정보알림이 정보 표시를 수행한다.
     * 
     * @return
     * @throws Exception
     */
    public List<NotificationVO> selectNotificationData() throws Exception;
}