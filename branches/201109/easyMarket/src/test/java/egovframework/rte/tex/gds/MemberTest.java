package egovframework.rte.tex.gds;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:egovframework/spring/context-*.xml" })
public class MemberTest {

//	@Resource(name="memberService")
//	EgovMemberService memberService; // 카테고리정보에 관한 인터페이스클래스
	
//	@Test
//	public void testListCategory() throws Exception{
//		MemberVO vo = new MemberVO();
//		vo.setId("d");
//		vo.setPassword("d");
//		MemberVO resultVO = memberService.loginMember(vo);
//		assertEquals(resultVO.getMemberNo(), "MEMBER-0000000000002");
//	}
	
	
//	@Test
//	public void testSecurity() throws Exception{
//		List<String> authorities = EgovUserDetailsHelper.getAuthorities();
//		 
//		// 1. authorites 에  권한이 있는지 체크 TRUE/FALSE
//		assertTrue(authorities.contains("ROLE_USER"));
//		assertTrue(authorities.contains("ROLE_RESTRICTED"));
//		assertTrue(authorities.contains("IS_AUTHENTICATED_ANONYMOUSLY"));
//		assertTrue(authorities.contains("IS_AUTHENTICATED_FULLY"));
//		assertTrue(authorities.contains("IS_AUTHENTICATED_REMEMBERED"));
//		 
//		// 2. authorites 에  ROLE 이 여러개 설정된 경우
//		for (Iterator<String> it = authorities.iterator(); it.hasNext();) {
//			String auth = it.next();
//		}
//		 
//		// 3. authorites 에  ROLE 이 하나만 설정된 경우
//		String auth = (String) authorities.toArray()[0];
//	}
	
}
