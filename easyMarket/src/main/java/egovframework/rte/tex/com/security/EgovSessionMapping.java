package egovframework.rte.tex.com.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import egovframework.rte.fdl.security.userdetails.EgovUserDetails;
import egovframework.rte.fdl.security.userdetails.jdbc.EgovUsersByUsernameMapping;
import egovframework.rte.tex.mbr.service.MemberVO;

public class EgovSessionMapping extends EgovUsersByUsernameMapping {
	
	/**
	 * 사용자정보를 테이블에서 조회하여 EgovUsersByUsernameMapping 에 매핑한다.
	 * @param ds DataSource
	 * @param usersByUsernameQuery String
	 */
	public EgovSessionMapping(DataSource ds, String usersByUsernameQuery) {
        super(ds, usersByUsernameQuery);
    }

	/**
	 * mapRow Override
	 * @param rs ResultSet 결과
	 * @param rownum row num
	 * @return Object EgovUserDetails
	 * @exception SQLException
	 */
	@Override
    protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
    	logger.debug("## EgovUsersByUsernameMapping mapRow ##");

        boolean strEnabled  = rs.getBoolean("ENABLED");

        String strUsrNo = rs.getString("USER_NO");
        String strUsrId = rs.getString("USER_ID");
        String strUsrNm    = rs.getString("USER_NM");
        String strPassword = rs.getString("PASSWORD");
        String strIhidnum = rs.getString("IHIDNUM");
        String strUsrEmail = rs.getString("USER_EMAIL");
        String strTelNo = rs.getString("TEL_NO");
        String strMobileNo = rs.getString("MOBLPHON_NO");
        String strUsrZip = rs.getString("USER_ZIP");
        String strUsrAdres = rs.getString("USER_ADRES");
        String strDetailAdres = rs.getString("USER_DETAIL_ADRES");
        String strAuthorCode= rs.getString("AUTHOR_CODE");

        // 세션 항목 설정
        MemberVO loginVO = new MemberVO();

        loginVO.setMemberNo(strUsrNo);
        loginVO.setName(strUsrNm);
        loginVO.setId(strUsrId);
        loginVO.setIhidnum(strIhidnum);
        loginVO.setPassword(strPassword);
        loginVO.setEmail(strUsrEmail);
        loginVO.setTelno(strTelNo);
        loginVO.setMobile(strMobileNo);
        loginVO.setZip(strUsrZip);
        loginVO.setAdres(strUsrAdres);
        loginVO.setDetailAdres(strDetailAdres);
        loginVO.setMngrSe(strAuthorCode);
        
        return  new EgovUserDetails(strUsrId, strPassword, strEnabled, loginVO);
        
    }
}
