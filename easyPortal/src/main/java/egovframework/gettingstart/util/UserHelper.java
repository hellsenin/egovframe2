package egovframework.gettingstart.util;

import javax.servlet.http.HttpSession;

import egovframework.gettingstart.web.vo.LoginVO;

public class UserHelper {
    public static LoginVO getUserInfo(HttpSession session) {
	// TODO 테스트용 사용자 처리로 실제 사용자 정보로 변경 (session 등 사용)
	LoginVO loginVO = new LoginVO();
	loginVO.setUserId("HongKilDong");
	loginVO.setName("홍길동");

	return loginVO;
	// (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    }

    public static Boolean isAuthenticated(HttpSession session) {
	// TODO 테스트용 사용자 처리로 실제 사용자 처리로 변경 (session 등 사용)
	return true;
	// EgovUserDetailsHelper.isAuthenticated();
    }
}
