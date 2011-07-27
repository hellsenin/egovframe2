package egovframework.gettingstart.guide.web;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.gettingstart.guide.service.NotificationService;
import egovframework.gettingstart.guide.service.NotificationVO;
import egovframework.gettingstart.util.CommonMessageSource;
import egovframework.gettingstart.util.UserHelper;
import egovframework.gettingstart.web.vo.LoginVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * 정보알림이 서비스 컨트롤러 클래스
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
 * TODO [Step 5-5] Controller 설정
 * Ex : @Controller
 */
public class NotificationController {
    @Resource(name="NotificationService")
    protected NotificationService notificationService;
    
    @Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
    
    @Resource(name="commonMessageSource")
    CommonMessageSource commonMessageSource;
    
    @Autowired
    private DefaultBeanValidator beanValidator;
    
    private Logger logger = Logger.getLogger(this.getClass());	// Logger 처리
    
    /**
     * 정보알림이에 대한 목록을 조회한다.
     * 
     * @param notificationVO
     * @param model
     * @return
     * @throws Exception
     */
    /*
     * TODO [Step 5-6] @RequestMapping 설정
     * @RequestMapping annotation을 Conroller의 특정 메소드에 지정함으로서 HandlerMapping을 지정함
     * Ex : @RequestMapping("/guide/selectNotificationList.do")
     */
    public String selectNotificationList(HttpSession session, Locale locale,
	    @ModelAttribute("searchVO") NotificationVO notificationVO, ModelMap model) throws Exception {
	
		LoginVO user = UserHelper.getUserInfo(session);
	
		notificationVO.setUserId(user.getUserId());
	
		logger.debug("Search : " + notificationVO.getSearchWrd());
	
		notificationVO.setPageUnit(propertyService.getInt("pageUnit"));
		notificationVO.setPageSize(propertyService.getInt("pageSize"));
	
		PaginationInfo paginationInfo = new PaginationInfo();
	
		paginationInfo.setCurrentPageNo(notificationVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(notificationVO.getPageUnit());
		paginationInfo.setPageSize(notificationVO.getPageSize());
	
		notificationVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		notificationVO.setLastIndex(paginationInfo.getLastRecordIndex());
		notificationVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		notificationVO.setMinuteLabel(commonMessageSource.getMessage("guide.minute.label", locale));
	
		/*
		 * TODO [Step 5-8] 서비스 메소드 호출 
		 * 아래 line을 다음으로 변경 
		 * Map<String, Object> map = notificationService.selectNotificationList(notificationVO);
		 */
		Map<String, Object> map = null;
		int totCnt = Integer.parseInt((String)map.get("resultCnt"));
	
		paginationInfo.setTotalRecordCount(totCnt);
	
		model.addAttribute("resultList", map.get("resultList"));
		model.addAttribute("resultCnt", map.get("resultCnt"));
		model.addAttribute("paginationInfo", paginationInfo);
	
		/*
		 * TODO [Step 5-9] View 선택 처리  
		 * Ex : return "guide/notificationList";
		 */
		return ""; // JSP or Tiles definition 처리
    }
    
    /**
     * 신규 정보알림이 등록을 위한 등록페이지로 이동한다.
     * 
     * @param notificationVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/guide/insertNotificationPage.do")
    public String insertNotificationPage(@ModelAttribute("searchVO") NotificationVO notificationVO, ModelMap model) throws Exception {

		NotificationVO notification = new NotificationVO();
	
		model.addAttribute("notification", notification);
	
		return "guide/notificationRegist"; // JSP or Tiles definition 처리
    }
    
    /**
     * 신규 정보알림이 정보를 등록한다.
     * 
     * @param notificationVO
     * @param boardMaster
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/guide/insertNotification.do")
    public String insertNotification(HttpSession session, 
	    @ModelAttribute("searchVO") NotificationVO notificationVO, @ModelAttribute("notification") NotificationVO notification,
	    BindingResult bindingResult, SessionStatus status, ModelMap model) throws Exception {
	
		LoginVO user = UserHelper.getUserInfo(session);
		Boolean isAuthenticated = UserHelper.isAuthenticated(session);
	
		beanValidator.validate(notification, bindingResult);
		if (bindingResult.hasErrors()) {
		    return "guide/notificationRegist"; // JSP or Tiles definition 처리
		}
	
		if (!notificationService.checkNotification(notification)) {
		    model.addAttribute("msg", commonMessageSource.getMessage("guide.alertTime"));
	
		    return "guide/notificationRegist"; // JSP or Tiles definition 처리
		}
	
		if (isAuthenticated) {
		    notification.setRegisterUserId(user.getUserId());
	
			/*
			 * TODO [Step 5-8] 서비스 메소드 호출 
			 * 다음 호출 추가
			 * notificationService.insertNotification(notification);
			 */
		}
	
		return "forward:/guide/selectNotificationList.do";
    }
    
    /**
     * 정보알림이에 대한 상세정보를 조회한다.
     * 
     * @param notificationVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/guide/selectNotification.do")
    public String selectNotification(HttpSession session, 
	    @ModelAttribute("searchVO") NotificationVO notificationVO, ModelMap model) throws Exception {
	
		LoginVO user = UserHelper.getUserInfo(session);
	
		/*
		 * TODO [Step 5-8] 서비스 메소드 호출 
		 * 아래 line을 다음으로 변경 
		 * NotificationVO vo = notificationService.selectNotification(notificationVO);
		 */
		NotificationVO vo = null;
	
		model.addAttribute("sessionUniqId", user.getUserId());
		/*
		 * TODO [Step 5-7] model 데이터 전달 처리 
		 * Ex : model.addAttribute("result", vo);
		 */
		
		return "guide/notificationDetail"; // JSP or Tiles definition 처리
    }
    
    /**
     * 정보알림이 수정을 위해 수정페이지로 이동한다.
     * 
     * @param notificationVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/guide/updateNotificationPage.do")
    public String updateNotificaitonPage(@ModelAttribute("searchVO") NotificationVO notificationVO, ModelMap model) throws Exception {
		/*
		 * TODO [Step 5-8] 서비스 메소드 호출 
		 * 아래 line을 다음으로 변경 
		 * NotificationVO vo = notificationService.selectNotification(notificationVO);
		 */
    	NotificationVO vo = null;
	
		model.addAttribute("result", vo);
	
		return "guide/notificationUpdt";	// JSP or Tiles definition 처리
    }
    
    /**
     * 정보알림이 정보를 수정한다.
     * 
     * @param notificationVO
     * @param notification
     * @param bindingResult
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/guide/updateNotification.do")
    public String updateNotification(HttpSession session, 
	    @ModelAttribute("searchVO") NotificationVO notificationVO, @ModelAttribute("notification") NotificationVO notification,
	    BindingResult bindingResult, ModelMap model) throws Exception {

		LoginVO user = UserHelper.getUserInfo(session);
		Boolean isAuthenticated = UserHelper.isAuthenticated(session);
	
		beanValidator.validate(notification, bindingResult);
		if (bindingResult.hasErrors()) {
			/*
			 * TODO [Step 5-8] 서비스 메소드 호출 
			 * 아래 line을 다음으로 변경 
			 * NotificationVO vo = notificationService.selectNotification(notificationVO);
			 */
			NotificationVO vo = null;
	
		    model.addAttribute("result", vo);
	
		    return "guide/notificationUpdt"; // JSP or Tiles definition 처리
		}
	
		if (!notificationService.checkNotification(notification)) {
		    model.addAttribute("msg", commonMessageSource.getMessage("guide.alertTime"));
	
			/*
			 * TODO [Step 5-8] 서비스 메소드 호출 
			 * 아래 line을 다음으로 변경 
			 * NotificationVO vo = notificationService.selectNotification(notificationVO);
			 */
		    NotificationVO vo = null;
	
		    model.addAttribute("result", vo);
	
		    return "guide/notificationUpdt"; // JSP or Tiles definition 처리
		}
	
		if (isAuthenticated) {
		    notification.setUpdateUserId(user.getUserId());
			/*
			 * TODO [Step 5-8] 서비스 메소드 호출 
			 * 다음 호출 추가
			 * notificationService.updateNotifiction(notification);
			 */
		}
	
		return "forward:/guide/selectNotificationList.do";
    }
    
    /**
     * 정보알림이 정보를 삭제한다.
     * 
     * @param notificationVO
     * @param notification
     * @param status
     * @return
     * @throws Exception
     */
    @RequestMapping("/guide/deleteNotification.do")
    public String deleteNotification(HttpSession session, 
	    @ModelAttribute("searchVO") NotificationVO notificationVO, @ModelAttribute("notification") NotificationVO notification,
	    SessionStatus status) throws Exception {

		LoginVO user = UserHelper.getUserInfo(session);
		Boolean isAuthenticated = UserHelper.isAuthenticated(session);
	
		if (isAuthenticated) {
		    notification.setUpdateUserId(user.getUserId());
		    /*
			 * TODO [Step 5-8] 서비스 메소드 호출 
			 * 다음 호출 추가
			 * notificationService.deleteNotification(notification);
		     */
		    
		}
		// status.setComplete();
		return "forward:/guide/selectNotificationList.do";
    }
    
    /**
     * 정보알림이 표시를 조회한다.
     * 
     * @param notificationVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/guide/getNotifications.do")
    public String getNotifications(HttpSession session, 
	    @ModelAttribute("searchVO") NotificationVO notificationVO, ModelMap model) throws Exception {
	
		Boolean isAuthenticated = UserHelper.isAuthenticated(session);
	
		if (isAuthenticated) {
		    List<NotificationVO> list = notificationService.selectNotificationData();
	
		    model.addAttribute("list", list);
		}
	
		return "guide/notificationData"; // JSP or Tiles definition 처리
    }
}
