<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : EgovBoardList.jsp
 * @Description : 게시판 화면
 * @author 신혜연
 * @since 2011.06.29
 * @version 1.0
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="board.title" /></title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/egov.css'/>" />

<script type="text/javaScript" language="javascript" defer="defer">
	/* 글 수정 화면 function */
	function fn_egov_select(id) {
		document.listForm.selectedId.value = id;
		document.listForm.action = "<c:url value='/brd/updateBoardView.do'/>";
		document.listForm.submit();
	}

	/* 글 등록 화면 function */
	function fn_egov_addView() {
		document.listForm.action = "<c:url value='/brd/insertBoardView.do'/>";
		document.listForm.submit();
	}

	/* 글 목록 화면 function */
	function fn_egov_selectList() {
		document.listForm.action = "<c:url value='/brd/egovBoardList.do'/>";
		document.listForm.submit();
	}

	/* pagination 페이지 링크 function */
	function fn_egov_link_page(pageNo) {
		document.listForm.pageIndex.value = pageNo;
		document.listForm.action = "<c:url value='/brd/egovBoardList.do'/>";
		document.listForm.submit();
	}
</script>
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
	<form:form commandName="searchVO" name="listForm" method="post">
		<input type="hidden" name="selectedId" />
			<!-- 타이틀 -->
			<div id="title">
				<ul>
					<li><img
						src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" />
						<spring:message code="board.title" /></li>
				</ul>
			</div>
			<!-- // 타이틀 -->
			<div id="search">
				<ul>
					<li><form:select path="searchCondition" cssClass="use">
							<form:option value="1" label="title" />
							<form:option value="0" label="writer" />
						</form:select>
					</li>
					<li><form:input path="searchKeyword" cssClass="txt" /></li>
					<li><span class="btn_blue_l"><a
							href="javascript:fn_egov_selectList();"><spring:message
									code="button.search" /> </a><img
							src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>"
							style="margin-left: 6px;" /> </span></li>
				</ul>
			</div>
			<!-- List -->
			<div id="table">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<colgroup>
						<col width="40" />
						<col width="150" />
						<col width="80" />
						<col width="80" />
					</colgroup>
					<tr>
						<th align="center"><spring:message code="board.header.no" />
						</th>
						<th align="center"><spring:message code="board.header.title" />
						</th>
						<th align="center"><spring:message code="board.header.writer" />
						</th>
						<th align="center"><spring:message code="board.header.date" />
						</th>
					</tr>
					<c:forEach var="result" items="${resultList}" varStatus="status">
						<tr>
							<td align="center" class="listtd"><c:out value="${status.count}" /></td>
							<td align="left" class="listtd"><a
								href="javascript:fn_egov_select('<c:out value="${result.no}"/>')"><c:out	value="${result.sj}" /> </a></td>
							<td align="center" class="listtd"><c:out value="${result.mberId}" />&nbsp;</td>
							<td align="center" class="listtd"><c:out value="${result.registDt}" />&nbsp;</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<!-- /List -->
			<div id="paging">
				<ui:pagination paginationInfo="${paginationInfo}" type="image"
					jsFunction="fn_egov_link_page" />
				<form:hidden path="pageIndex" />
			</div>
<!-- 			<div id="sysbtn1"> -->
<!-- 				<ul> -->
					<div id="sysbtn">
						<ul>
							<li><span class="btn_blue_l"><a href="javascript:fn_egov_addView();"><spring:message code="button.add" /> </a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left: 6px;" /> </span></li>
						</ul>
					</div>
<!-- 				</ul> -->
<!-- 			</div> -->
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
