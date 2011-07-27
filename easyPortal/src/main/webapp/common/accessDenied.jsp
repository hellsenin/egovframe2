<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.security.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.Authentication" %>
<%@ page import="org.springframework.security.ui.AccessDeniedHandlerImpl" %> 
<%@ page import="org.springframework.security.userdetails.UserDetails" %>
<%@ page import="org.springframework.security.userdetails.UserDetailsService" %>

<%@ page isErrorPage="true"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="egovframework.rte.fdl.string.EgovStringUtil" %>
<%@ page import="java.lang.String" %>
<%
 /**
  * @Class Name : accessDenied.jsp
  * @Description : 사용자 접근거부알림 화면
  * @Modification Information
  * @
  * @  수정일      수정자            수정내용
  * @ -------        --------    ---------------------------
  * @ 2011.01.01   홍길동          최초 생성
  *
  *  @author 개발팀 홍길동
  *  @since 2011.01.01
  *  @version 1.0 
  *  @see
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value='/css/com.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/css/button.css' />" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffff" text="#000000">
<!-- 타이틀 시작 -->
<table width="100%" height="37" border="0" cellpadding="0" cellspacing="0">
</table>
<!-- 타이틀 끝 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td width="747">
		</td>
	</tr>
	<tr>
		<td align="center">
			<table width="500" height="153" border="0" cellpadding="0" cellspacing="0" background="<c:url value='/images/fail.jpg'/>">
				<tr>
					<td height="153">
						<table width="500" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="20">&nbsp;</td>
								<td width="460">
									접근권한이 없습니다.<br/><br/>
									담당자에게 문의하여 주시기 바랍니다.<br/><br/>							
									<%= request.getAttribute(AccessDeniedHandlerImpl.SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY)%>
									<%
									Authentication auth = SecurityContextHolder.getContext().getAuthentication();
									Object principal = auth.getPrincipal();
									if (principal instanceof UserDetails) {
									    String username = ((UserDetails) principal).getUsername();
									 	String password = ((UserDetails) principal).getPassword();%><br/><br/>
									 아이디 : <%= username.toString()%><br/>
									<% } %>
								</td>
								<td width="20">&nbsp;</td>
							</tr>
							<tr>
								<td colspan="3" height="50">
                                	<!-- a href="<c:url value='/'/>" target="_top">확인</a-->
                                	<span class="button"><a href="<c:url value='/'/>" target="_top">확인</a></span>
		                        </td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td align="center"></td>
	</tr>
</table>
<form name="dummyForm"></form> 
</body>
</html>