package egovframework.gettingstart.guide;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import egovframework.gettingstart.guide.service.NotificationService;
import egovframework.gettingstart.guide.service.NotificationVO;

public class TestUsingXML {
	/*
	 * TODO [Step 4-7] 테스트 수행 : Run As -> Java Application
	 */
	/*
	 * TODO [Step 1-6] 테스트 수행 : Run As -> Java Application
	 */
	public static void main(String[] args) {
		/*
		 * TODO [Step 1-5] 테스트 클래스 정의 
		 * ApplicationContext 생성
		 * Ex:
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"/egovframework/spring/context-service.xml"}
		);
		 */		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"/egovframework/spring/context-service.xml"}
		);
		
		/**
		 * TODO [Step 1-5] 테스트 클래스 정의 
		 * ApplicationContext를 통한 Service 얻기
		 * 아래 line을 다음으로 변경 
		 * Ex: NotificationService service = (NotificationService)context.getBean("notificationService");
		 */
//		NotificationService service = null;
		
		NotificationService service = (NotificationService)context.getBean("notificationService");
		
		List<NotificationVO> list = null;
		
		try {
			list = service.selectNotificationData();
			
			System.out.println("List size (selectNotificationData) = " + list.size());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
