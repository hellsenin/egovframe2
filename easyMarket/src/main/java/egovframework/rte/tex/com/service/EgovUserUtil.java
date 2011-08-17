package egovframework.rte.tex.com.service;

import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.tex.mbr.service.MemberVO;

public class EgovUserUtil {

	public static MemberVO getMemberInfo(){
		if (EgovUserDetailsHelper.isAuthenticated()) {
			return (MemberVO)EgovUserDetailsHelper.getAuthenticatedUser();
		} else {
		    return null;
		}
	}
	
}
