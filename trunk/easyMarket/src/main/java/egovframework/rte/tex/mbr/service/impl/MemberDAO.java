package egovframework.rte.tex.mbr.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.tex.mbr.service.MemberVO;

/**
 * @Class Name : MemberDAO.java
 * @Description : 회원관리에 관한 데이터 접근 클래스를 정의한다.
 * @author 신혜연
 * @since 2011.05.25
 * @version 1.0
*/
@Repository("memberDAO")
public class MemberDAO extends EgovAbstractDAO{
	
	/**
	 * 회원의 정보를 화면에서 입력하여 항목의 정합성을 체크하고 데이터베이스에 저장한다.
	 * @param memberVO 회원정보
	 */
	public void insertMember(MemberVO memberVO){
		insert("memberDAO.insertMember", memberVO);
	}
	
	/**
	 * 화면에 조회된 회원정보를 수정하여 항목의 정합성을 체크하고 수정된 데이터를 데이터베이스에 반영한다.
	 * @param memberVO 회원정보
	 */
	public void updateMember(MemberVO memberVO){
		update("memberDAO.updateMember", memberVO);
	}
	
	/**
	 * 선택된 회원정보를 데이터 베이스에서 삭제한다.
	 * @param memberVO 회원정보
	 */
	public void deleteMember(MemberVO memberVO){
		delete("memberDAO.deleteMember", memberVO);
	}
	
	/**
	 * 입력된 정보로 데이터베이스에 접근하여 회원 여부를 확인하고, 
	 * 회원일 경우 회원의 정보를 가져온다.
	 * @param id ID
	 * @return MemberVO 회원정보
	 */
	public MemberVO checkMember(MemberVO vo){
		
		return (MemberVO)selectByPk("memberDAO.getMember", vo);
	}
	
	public MemberVO checkEmail(MemberVO vo){
		getSqlMapClientTemplate().queryForObject("memberDAO.searchPassword", vo);
//		(MemberVO)selectByPk("memberDAO.searchPassword", vo);
		
		return (MemberVO)getSqlMapClientTemplate().queryForObject("memberDAO.searchPassword", vo);
	}

	public void changPassword(MemberVO vo){
		update("memberDAO.changePassword", vo);
	}
	
//	/** 
//	 * 회원이 비밀번호를 기억하지 못할 때 가입시 입력한 이메일로 비밀번호를 전송하는 것으로 입력한 아이디와 이메일을 데이터베이스에서 확인하고 회원일경우 메일로 비밀번호를 전송한다.
//	 * 전송 후에는 로그인페이지를 출력한다. 
//	 * @param id ID
//	 * @param email 이메일주소
//	 * @return String 회원확인 및 이메일전송
//	 */
//	public String sendEmail(String id, String email){
//		return null;
//	}
	
    /**
     * 입력한 사용자아이디의 중복여부를 체크하여 사용가능여부를 확인
     * @param userManageVO
     */
    public int checkIdDplct(String checkId) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
            "memberDAO.checkIdDplct", checkId);
    }
}
