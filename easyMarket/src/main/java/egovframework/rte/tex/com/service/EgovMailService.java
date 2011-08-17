package egovframework.rte.tex.com.service;

import egovframework.rte.tex.mbr.service.MemberVO;


public interface EgovMailService {

	 boolean sendEmailTo(MemberVO vo);
}
