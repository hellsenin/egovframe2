<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : egovCategoryRegister.jsp
 * @Description : 카테고리 등록,수정 화면
 * @author 신혜연
 * @since 2011.06.29
 * @version 1.0
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="registerFlag" value="${empty categoryVO.ctgryId ? '등록' : '수정'}"/>
<title><spring:message code="category" /> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>

<!--For Commons Validator Client Side-->
<%-- <script type="text/javascript" src="<c:url value='/com/validator.do'/>"></script> --%>
<%-- <validator:javascript formName="categoryVO" staticJavascript="false" xhtml="true" cdata="false"/> --%>

<script type="text/javaScript" language="javascript" defer="defer">

function fncSubmit(method) {
		if(method != 'post') {
			document.detailForm._method.value=method;
			
			if(method == 'delete') {
				if(!confirm("<spring:message code="msg.del" />")) {
					return;
				}
			}
			if(method == 'put') {
				if(!confirm("<spring:message code="msg.update" />")) {
					return;
				}
			}
		}
		<c:if test="${empty categoryVO.ctgryId}">
			if(!confirm("<spring:message code="msg.insert" />")) {
				return;
			}
			document.detailForm.action = "<c:url value='/springrest/cgr.html'/>";
		</c:if>
		
		document.detailForm.submit();
}

function fn_egov_selectList(method){
	document.detailForm._method.value=method;
	document.detailForm.action = "<c:url value='/springrest/cgr.html'/>";
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
<form:form commandName="categoryVO" name="detailForm">
	<input type="hidden" name="_method" />
		<c:if test="${not empty categoryVO.ctgryId}">
			<form:hidden name="ctgryId" path="ctgryId"/>
		</c:if>
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" /><spring:message code="category" /> <c:out value="${registerFlag}"/></li>
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
			<td class="tbtd_caption"><spring:message code="cgr.header.nm" /></td>
			<td class="tbtd_content">
				<form:input path="ctgryNm" maxlength="10" cssClass="txt" name="ctgryNm"/>
				&nbsp;<form:errors path="ctgryNm" />
			</td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="cgr.header.dc" /></td>
			<td class="tbtd_content">
				<form:textarea path="dc" rows="5" cols="58" maxlength="100" name="dc"/>
					&nbsp;<form:errors path="dc" /></td>
		</tr>
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList('get');">목록</a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			<c:if test="${empty categoryVO.ctgryId}">
				<li><span class="btn_blue_l"><a  href="javascript:fncSubmit('post');"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();"><spring:message code="button.reset" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			</c:if>
			<c:if test="${not empty categoryVO.ctgryId}">
				<li><span class="btn_blue_l"><a href="javascript:fncSubmit('put');"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				<li><span class="btn_blue_l"><a href="javascript:fncSubmit('delete');"><spring:message code="button.delete" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();"><spring:message code="button.reset" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				<spring:url value="/springrest/cgr/{id}.xml" var="xmlUrl" htmlEscape="true" >
					<spring:param name="id" value="${categoryVO.ctgryId}" />
				</spring:url>
				<li><span class="btn_blue_l"><a href="${xmlUrl}"><spring:message code="button.xml" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				<spring:url value="/springrest/cgr/{id}.json" var="jsonUrl" htmlEscape="true" >
					<spring:param name="id" value="${categoryVO.ctgryId}" />
				</spring:url>
				<li><span class="btn_blue_l"><a href="${jsonUrl}"><spring:message code="button.defalutJson" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			</c:if>
		</ul>
	</div>
<!-- 검색조건 유지 -->
<%-- <input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/> --%>
<%-- <input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/> --%>
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

