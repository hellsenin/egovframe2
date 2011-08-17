<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : egovSearchPassword.jsp
 * @Description : 비밀번호 찾기 화면
 * @author 신혜연
 * @since 2011.06.30
 * @version 1.0
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="mbr.login" /> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>


<script type="text/javaScript" language="javascript" defer="defer">

/* 비밀번호 찾기 function */
function fn_egov_searchPass() {	
	document.detailForm.action = "<c:url value='/mbr/sendEmail.do'/>";
   	document.detailForm.submit();
}

</script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
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
<form name="detailForm">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" /><spring:message code="mbr.searchPass" /></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#D3E2EC" bordercolordark="#FFFFFF" style="BORDER-TOP:#C2D0DB 2px solid; BORDER-LEFT:#ffffff 1px solid; BORDER-RIGHT:#ffffff 1px solid; BORDER-BOTTOM:#C2D0DB 1px solid; border-collapse: collapse;">
		<colgroup>
			<col width="150"/>
			<col width="" />
		</colgroup>
		<tr>
			<td class="tbtd_content" colspan=2>* <spring:message code="msg.searchEmail" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="mbr.header.id" /></td>
			<td class="tbtd_content">
					<input name="id" maxlength="10"/>
			</td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="mbr.header.email" /></td>
			<td class="tbtd_content">
				<input name="email"  style="width:250px;"/> </td>
		</tr>
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_searchPass();"><spring:message code="mbr.searchPass" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>
	</div>
</form>
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

