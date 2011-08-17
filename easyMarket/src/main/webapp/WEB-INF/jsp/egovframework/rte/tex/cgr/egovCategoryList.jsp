<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : egovCategoryList.jsp
  * @Description : CategoryList 화면
  * @Modification Information
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="category.title" /></title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>

<script type="text/javaScript" language="javascript" defer="defer">

function fn_egov_addView() {
   	document.listForm.action = "<c:url value='/springrest/cgr/new.html'/>";
   	document.listForm.submit();		
}

/* 검색 function */
function fn_egov_selectList() {
	document.listForm.action = "<c:url value='/springrest/cgr.html'/>";
   	document.listForm.submit();
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
// 	document.listForm.pageIndex.value = pageNo;
	document.listForm.action = "<c:url value='/springrest/cgr.html;'/>";
   	document.listForm.submit();
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
<form:form name="listForm" method="GET">
<%-- <form:form commandName="searchVO"  name="listForm" method="GET"> --%>
<input type="hidden" name="selectedId" />
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" /><spring:message code="category.title" /></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
<!-- 	<div id="search"> -->
<!-- 		<ul> -->
<!-- 		<li> -->
<%-- 			<spring:message code="cgr.header.nm" /> --%>
<!-- 		</li> -->
<%-- 		<li><form:input path="searchKeyword" cssClass="txt"/></li> --%>
<%-- 		<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>		 --%>
<!-- 	</div> -->
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
				<col width="10" />				
				<col width="100" />				
				<col width="50" />
				<col width="100" />
			</colgroup>		  
			<tr>
				<th align="center"><spring:message code="cgr.header.no" /></th>
				<th align="center"><spring:message code="cgr.header.code" /></th>
				<th align="center"><spring:message code="cgr.header.nm" /></th>
				<th align="center"><spring:message code="cgr.header.dc" /></th>
			</tr>
			<c:forEach var="category" items="${categoryList}" varStatus="status">
			<tr>
				<td align="center" class="listtd"><c:out value="${status.count}"/></td>
				<td align="center" class="listtd">
						<spring:url value="/springrest/cgr/{id}.html" var="categoryUrl" htmlEscape="true">
							<spring:param name="id" value="${category.ctgryId}" />
						</spring:url>
						<a class="linkClass" href="${categoryUrl}"><c:out value="${category.ctgryId}"/></a></td>
				<td align="left" class="listtd"><c:out value="${category.ctgryNm}"/></td>
				<td align="center" class="listtd"><c:out value="${category.dc}"/></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
<!-- 	<div id="paging"> -->
<%-- 		<ui:pagination paginationInfo = "${paginationInfo}" --%>
<!-- 				   type="image" -->
<!-- 				   jsFunction="fn_egov_link_page" -->
<!-- 				   /> -->
<%-- 		<form:hidden path="pageIndex" /> --%>
<!-- 	</div> -->

<!-- 	<div id="sysbtn1"> -->
<!-- 		<ul> -->
		<div id="sysbtn">
			<ul>
				<li><span class="btn_blue_l"><a href="javascript:fn_egov_addView();"><spring:message code="button.add" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span>
				</li>
				<spring:url value="/springrest/cgr.json" var="jsonUrl" htmlEscape="true" />
				<li><span class="btn_blue_l"><a href="${jsonUrl}"><spring:message code="button.json" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			</ul>
		</div>
<!-- 		</ul> -->
<!-- 	</div> -->
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
