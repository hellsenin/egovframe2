package egovframework.rte.tex.com.service.impl;

import javax.annotation.Resource;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.tex.com.service.EgovMailService;
import egovframework.rte.tex.mbr.service.MemberVO;

@Service("mailService")
public class EgovMailServiceImpl implements EgovMailService {

	@Resource(name="mailInfoService")
	protected EgovPropertyService mailInfoService ;

	public boolean sendEmailTo(MemberVO vo) {
		boolean result = false;

		Email email = new SimpleEmail();

		email.setCharset("utf-8"); // 한글 인코딩

		// setHostName에 실제 메일서버정보
		email.setHostName(mailInfoService.getString("hostName")); // SMTP서버 설정
		email.setSmtpPort(mailInfoService.getInt("port"));
		email.setAuthenticator(new DefaultAuthenticator(mailInfoService.getString("mailId"), mailInfoService.getString("mailPass")));
		email.setTLS(true);
		try {
			email.addTo(vo.getEmail(), vo.getId()); // 수신자 추가
		} catch (EmailException e) {
			e.printStackTrace();
		}
		try {
			email.setFrom(mailInfoService.getString("mailId"), mailInfoService.getString("mailName")); // 보내는 사람
		} catch (EmailException e) {
			e.printStackTrace();
		}
		email.setSubject(mailInfoService.getString("subject")); // 메일 제목
		email.setContent("ID: "+vo.getId() + "<br>" + "PASSWORD: "+vo.getPassword(), "text/plain; charset=utf-8");
		try {
			email.send();
			result = true;
		} catch (EmailException e) {
			e.printStackTrace();
		}
		return result;
	}
}
