<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
/**
 * @Class Name : EgovAccessDenied.jsp
 * @Description : 접근권한 에러화면
 * @author 신혜연
 * @since 2011.07. 15
 * @version 1.0
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="error.error" /></title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>
</head>
<body>
<!-- 전체 레이어 시작 -->
<div id="wrap">
	<!-- header 시작 -->
	<div id="header"><%@ include file="/WEB-INF/jsp/egovframework/rte/tex/com/header.jsp" %></div>
	<!-- //header 끝 -->	
	<!-- container 시작 -->
	<div id="container">
		<!-- 좌측메뉴 시작 -->
		<div id="leftmenu"><%@ include file="/WEB-INF/jsp/egovframework/rte/tex/com/leftmenu.jsp" %></div>
		<!-- //좌측메뉴 끝 -->
		
		
<!-- content 시작 -->
<div id="content_pop">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="center" valign="top">
    <table width="600" border="0" cellpadding="0" cellspacing="0" background="<c:url value='/images/egovframework/error/blue_bg.jpg'/>">
      <tr>
        <td align="center"><table width="100%" border="0" cellspacing="9" cellpadding="0">
          <tr>
            <td bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="left"><img src="<c:url value='/images/egovframework/error/er_logo.jpg'/>" width="379" height="57" alt="<spring:message code="alt.error.viewImg" />" /></td>
              </tr>
              <tr>
                <td><br />
                  <br /></td>
              </tr>

              <tr>
                <td align="center"><table width="520" border="0" cellspacing="2" cellpadding="2">
                  <tr>
                    <td width="74" rowspan="2" align="center"><img src="<c:url value='/images/egovframework/error/danger.jpg'/>"  width="74" height="74" alt="<spring:message code="alt.image" />" /></td>
                    <td width="399" align="left" class="board_title"><spring:message code="error.msg.access" /></td>
                  </tr>
                </table>
        	 </td>
              </tr>
            </table>
              <br /></td>
          </tr>
        </table></td>
      </tr>
    </table>
    </td>
  </tr>
</table>

</div>
<!-- //content 끝-->
	</div>
	<!-- //container 끝-->
	<!-- footer 시작 -->
	<div id="footer"><%@ include file="/WEB-INF/jsp/egovframework/rte/tex/com/footer.jsp" %></div>
	<!-- //footer 끝 -->
	</div>
	<!--// 전체 레이어 끝 -->
</body>
</html>
