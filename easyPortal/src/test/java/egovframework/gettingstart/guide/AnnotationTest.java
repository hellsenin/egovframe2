package egovframework.gettingstart.guide;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.gettingstart.guide.service.NotificationService;
import egovframework.gettingstart.guide.service.NotificationVO;

/*
 * TODO [Step 2-6] TestCase 실행
 * TODO [Step 3-5] TestCase 실행
 * 테스트 수행 : AnnotationTest 클래스 선택 -> Run As -> JUnit Test
 */
/*
 * TODO [Step 3-4] TestCase 수정
 * @ContextConfiguration의 location에 다음 String 추가  (배열이므로 ","로 구분)
 * "classpath*:/egovframework/spring/context-advice.xml"
 * 
 * 전체 Ex:
@ContextConfiguration(locations = {
	"classpath*:/egovframework/spring/context-component.xml",
	"classpath*:/egovframework/spring/context-advice.xml"
	})
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath*:/egovframework/spring/context-component.xml",
	"classpath*:/egovframework/spring/context-advice.xml"
	})
public class AnnotationTest {

	/**
	 * TODO [Step 2-5] TestCase 작성
	 * notificationService에 대하여 @Resource 지정을 통해 DI를 설정
	 * @Resource의 name 부분에는 지정하고자 하는 bean(@Service)의 id를 지정(“NotificationService”)
	 * ex: @Resource(name = "NotificationService")
	 */
	@Resource(name = "NotificationService")
    NotificationService notificationService;

	@Test
	public void testSelectList() throws Exception {

		// select list
		List<NotificationVO> resultList = notificationService.selectNotificationData();
		
		assertTrue(resultList.size() <= 100);
	}

}