<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : egovMemberRegister.jsp
 * @Description : 회원 등록,수정 화면
 * @author 신혜연
 * @since 2011.06.29
 * @version 1.0
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="registerFlag" value="${empty memberVO.memberNo ? '등록' : '수정'}"/>
<title><spring:message code="member" /> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>

<!--For Commons Validator Client Side-->
<%-- <script type="text/javascript" src="<c:url value='/com/validator.do'/>"></script> --%>
<%-- <validator:javascript formName="memberVO" staticJavascript="false" xhtml="true" cdata="false"/> --%>

<script type="text/javaScript" language="javascript" defer="defer">

/* 회원 삭제 function */
function fn_egov_delete() {
   	document.detailForm.action = "<c:url value='/mbr/deleteMember.do'/>";
   	document.detailForm.submit();		
}

/* 회원 등록, 수정 function */
function fn_egov_save() {	
	frm = document.detailForm;
	
// 	if(!validateMemberVO(frm)){
// 		return;
//     }else{
    	frm.action = "<c:url value="${registerFlag == '등록' ? '/mbr/insertMember.do' : '/mbr/updateMember.do'}"/>";
        frm.submit();
//     }
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
<form:form commandName="memberVO" name="detailForm">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" /><spring:message code="member" /> <c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#D3E2EC" bordercolordark="#FFFFFF" style="BORDER-TOP:#C2D0DB 2px solid; BORDER-LEFT:#ffffff 1px solid; BORDER-RIGHT:#ffffff 1px solid; BORDER-BOTTOM:#C2D0DB 1px solid; border-collapse: collapse;">
		<colgroup>
			<col width="150" />
			<col width="" />
		</colgroup>
		<tr>
			<td class="tbtd_caption">*<spring:message code="mbr.header.id" /></td>
			<td class="tbtd_content">
				<c:if test="${registerFlag == '등록'}">
					<form:input path="id" maxlength="10" cssClass="txt"/>
					&nbsp;<form:errors path="id" />
					<c:if test="${resultMsg == 'idDpl'}" ><spring:message code="mbr.idDpl.msg" /></c:if>
				</c:if>
				<c:if test="${registerFlag == '수정'}">
					<form:input path="id" maxlength="10" readonly="true" cssClass="essentiality" />
					&nbsp;<form:errors path="id" />
				</c:if>
				
			</td>
		</tr>
		<tr>
			<td class="tbtd_caption">*<spring:message code="mbr.header.pass" /></td>
			<td class="tbtd_content">
				<form:password path="password" maxlength="20" cssClass="txt"/>
					&nbsp;<form:errors path="password" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption">*<spring:message code="mbr.header.name" /></td>
			<td class="tbtd_content">
				<form:input path="name" maxlength="5" cssClass="txt"/>
					&nbsp;<form:errors path="name" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption">*<spring:message code="mbr.header.email" /></td>
			<td class="tbtd_content">
				<form:input path="email" cssClass="txt" style="width:250px;"/>
				  &nbsp;<form:errors path="email" /></td>
		</tr>
		
		<c:if test="${memberVO.mngrSe == 'ROLE_USER' || memberVO.mngrSe == 'CODE02'}">
			<tr>
				<td class="tbtd_caption">*<spring:message code="mbr.header.auth" /></td>
				<td class="tbtd_content">
					<form:select path="mngrSe">
						<option value="CODE02" label="<spring:message code="mbr.select.user" />"></option>
					</form:select>
					&nbsp;<form:errors path="mngrSe" /></td>
			</tr>
		</c:if>
		<c:if test="${memberVO.mngrSe != 'ROLE_USER' && memberVO.mngrSe != 'CODE02'}">
			<tr>
				<td class="tbtd_caption">*<spring:message code="mbr.header.auth" /></td>
				<td class="tbtd_content">
					<form:select path="mngrSe">
						<option value="CODE01" label="<spring:message code="mbr.select.admin" />"></option>
						<option value="CODE02" label="<spring:message code="mbr.select.user" />"></option>
					</form:select>
					&nbsp;<form:errors path="mngrSe" /></td>
			</tr>
		</c:if>
		<tr>
			<td class="tbtd_caption"><spring:message code="mbr.header.ihid" /></td>
			<td class="tbtd_content">
				<form:password path="ihidnum" maxlength="13" cssClass="txt"/>
				&nbsp;<form:errors path="ihidnum" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="mbr.header.tel" /></td>
			<td class="tbtd_content">
				<form:input path="telno" cssClass="txt"/>
					&nbsp;<form:errors path="telno" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="mbr.header.mobile" /></td>
			<td class="tbtd_content">
				<form:input path="mobile" cssClass="txt"/>
					&nbsp;<form:errors path="mobile" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="mbr.header.zip" /></td>
			<td class="tbtd_content">
				<form:input path="zip" maxlength="6" cssClass="txt"/>
					&nbsp;<form:errors path="zip" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="mbr.header.adres" /></td>
			<td class="tbtd_content">
				<form:input path="adres" cssClass="txt"  cssStyle="width:80%;"/>
					&nbsp;<form:errors path="adres" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="mbr.header.dAdres" /></td>
			<td class="tbtd_content">
				<form:input path="detailAdres"  cssClass="txt"  cssStyle="width:80%;"/>
					&nbsp;<form:errors path="detailAdres" /></td>
		</tr>
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();"><spring:message code="button.delete" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			</c:if>
			<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();"><spring:message code="button.reset" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li></ul>
	</div>
</form:form>
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

