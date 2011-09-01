<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	/**
	 * @Class Name : egovResult.jsp
	 * @Description : 회원결과화면
	 * @author 신혜연
	 * @since 2011.0708
	 * @version 1.0
	 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="mbr.login" /></title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/egov.css'/>" />
</head>
<body
	style="text-align: center; margin: 0 auto; display: inline; padding-top: 100px;">

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
		<c:if test="${resultMsg == 'insertSuccess'}">
			<spring:message code="mbr.insertSuccess.msg" />
		</c:if>
		<c:if test="${resultMsg == 'updateSuccess'}">
			<spring:message code="mbr.updateSuccess.msg" />
		</c:if>
		<c:if test="${resultMsg == 'sendEmailSuccess'}">
			<spring:message code="mbr.sendEmail.msg" />
		</c:if>
		<c:if test="${resultMsg == 'sendEmailFail'}">
			<spring:message code="mbr.sendFail.msg" />
		</c:if>
		<c:if test="${resultMsg == 'deleteSuccess'}">
			<spring:message code="mbr.deleteSuccess.msg" />
			<br />
			<spring:message code="mbr.thanks.msg" />
		</c:if>
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

