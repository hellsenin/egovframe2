package egovframework.gettingstart.guide.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.gettingstart.guide.service.NotificationVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * 정보알림이를 위한 데이터 접근 클래스
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

/*
 * TODO [Step 4-3] EgovAbstractDAO 상속
 * iBatis를 적용하기 위해 생성한 sqlMapClient를 DI(Dependency Injection)을 통해 지정해서 사용해야 하지만..
 * 간단하게 DAO 클래스가 EgovAbstractDAO를 상속하도록 하면 처리됨
 * ex : public class NotificationDAO extends EgovAbstractDAO {
 */
/*
 * TODO [Step 2-1] @Repository 지정
 * DAO 클래스에 @Repository(org.springframework.stereotype.Repository 클래스) annotation을 지정
 * @Controller, @Service, @Repository, (@Component 상속) 등을 통해 Bean을 정의할 수 있음
 * id는 "NotificationDAO"로 지정함
 * ex: @Repository("NotificationDAO")
 */
/*
 * TODO [Step 1-3] DAO 구현 확인
 */
@Repository("NotificationDAO")
public class NotificationDAO extends EgovAbstractDAO {
	/* TODO [Step 4-5] DAO 작성 : 아래 임의로 자료를 생성한 static 부분은 제거 */
	static List<NotificationVO> list;

	/* TODO [Step 4-5] DAO 작성 : 아래 임의로 자료를 생성한 static 부분은 제거 */
	static {
		list = new java.util.ArrayList<NotificationVO>();
		NotificationVO noti;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for (int i = 1; i <= 100; i++) {
			noti = new NotificationVO();
			noti.setNotificationId(String.valueOf(i));
			noti.setNotificationSubject("Notification #" + i);
			noti.setNotificationContents("Notification Example");
			noti.setNotificationTime(formatter.format(new java.util.Date()));
			noti.setIntervalString("10,20");
			noti.setRegisterDateTime("2011-01-01");
			
			list.add(noti);
		}
	}
	
    /**
     * 정보알림이 목록을 조회한다.
     * 
     * @param NotificationVO
     */
    @SuppressWarnings("unchecked")
    public List<NotificationVO> selectNotificationList(NotificationVO vo) throws Exception {
    	/*
    	 * TODO [Step 4-5] DAO 작성
    	 * 상위 EgovAbstractDAO 클래스의 list 메소드를 통해 목록 조회를 처리함
    	 * 파라미터는 query id와 parameter vo를 넘겨 처리함
    	 * 기존 return은 삭제
    	 * ex: return list("NotificationDAO.selectNotificationList", vo);
    	 */
    	return list;
    }

    /**
     * 정보알림이 목록 숫자를 조회한다
     * 
     * @param vo
     * @return
     * @throws Exception
     */
    public int selectNotificationListCnt(NotificationVO vo) throws Exception {
    	/*
    	 * TODO [Step 4-5] DAO 작성
    	 * 상위 EgovAbstractDAO 클래스의 selectByPk 메소드를 통해 조회를 처리함
    	 * 파라미터는 query id와 parameter vo를 넘겨 처리함
    	 * 기존 return은 삭제
    	 * ex: return (Integer)selectByPk("NotificationDAO.selectNotificationListCnt", vo);
    	 */
    	return list.size();
    }

    /**
     * 정보알림이 정보를 등록한다.
     * 
     * @param notification
     * @return
     * @throws Exception
     */
    public String insertNotification(NotificationVO notification) throws Exception {
    	/*
    	 * TODO [Step 4-5] DAO 작성
    	 * 상위 EgovAbstractDAO 클래스의 insert 메소드를 통해 등록을 처리함
    	 * 파라미터는 query id와 parameter vo를 넘겨 처리함
    	 * 기존 list.add 및 return은 삭제
    	 * ex: return (String)insert("NotificationDAO.insertNotification", notification);
    	 */
    	notification.setNotificationId(String.valueOf(list.size() + 1));
    	list.add(notification);
    	
    	return notification.getNotificationId();
    }

    /**
     * 정보알림이에 대한 상세정보를 조회한다.
     * 
     * @param searchVO
     * @return
     */
    public NotificationVO selectNotification(NotificationVO searchVO) {
    	/*
    	 * TODO [Step 4-5] DAO 작성
    	 * 상위 EgovAbstractDAO 클래스의 selectByPk 메소드를 통해 조회를 처리함
    	 * 파라미터는 query id와 parameter vo를 넘겨 처리함
    	 * 기존 for문 및 return은 삭제
    	 * ex: return (NotificationVO)selectByPk("NotificationDAO.selectNotification", searchVO);
    	 */
    	for (int i = 0; i < list.size(); i++) {
    		if (list.get(i).getNotificationId().equals(searchVO.getNotificationId())) {
    			return list.get(i);
    		}
    	}
    	
    	return null;
    }

    /**
     * 정보알림이 정보를 수정한다.
     * 
     * @param notification
     * @return
     * @throws Exception
     */
    public void updateNotification(NotificationVO notification) throws Exception {
    	/*
    	 * TODO [Step 4-5] DAO 작성
    	 * 상위 EgovAbstractDAO 클래스의 update 메소드를 통해 수정을 처리함
    	 * 파라미터는 query id와 parameter vo를 넘겨 처리함
    	 * 기존 for문은 삭제
    	 * ex: update("NotificationDAO.updateNotification", notification);
    	 */
    	for (int i = 0; i < list.size(); i++) {
    		if (list.get(i).getNotificationId().equals(notification.getNotificationId())) {
    			list.remove(i);
    			
    			list.add(i, notification);
    		}
    	}
    }

    /**
     * 정보알림이 정보를 삭제한다.
     * 
     * @param notification
     * @throws Exception
     */
    public void deleteNotification(NotificationVO notification) throws Exception {
    	/*
    	 * TODO [Step 4-5] DAO 작성
    	 * 상위 EgovAbstractDAO 클래스의 delete 메소드를 통해 삭제를 처리함
    	 * 파라미터는 query id와 parameter vo를 넘겨 처리함
    	 * 기존 for문은 삭제
    	 * ex: delete("NotificationDAO.deleteNotification", notification);
    	 */
    	for (int i = 0; i < list.size(); i++) {
    		if (list.get(i).getNotificationId().equals(notification.getNotificationId())) {
    			list.remove(i);
    		}
    	}
    }

    /**
     * 정보알림이 표시를 위한 대상 알림 정보를 얻는다.
     * 
     * @param vo
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<NotificationVO> getNotificationData(NotificationVO vo) throws Exception {
    	/*
    	 * TODO [Step 4-5] DAO 작성
    	 * 상위 EgovAbstractDAO 클래스의 list 메소드를 통해 목록 조회를 처리함
    	 * 파라미터는 query id와 parameter vo를 넘겨 처리함
    	 * 기존 return은 삭제
    	 * ex: return list("NotificationDAO.getNotificationData", vo);
    	 */
    	
//    	return list;
    	return list("NotificationDAO.getNotificationData", vo);
    }
}