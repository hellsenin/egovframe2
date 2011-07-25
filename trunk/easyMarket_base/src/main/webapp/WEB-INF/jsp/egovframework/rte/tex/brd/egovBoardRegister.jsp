<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : egovBoardRegister.jsp
 * @Description : 게시판 글 등록,수정 화면
 * @author 신혜연
 * @since 2011.06.16
 * @version 1.0
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="registerFlag" value="${empty boardVO.bbscttNo ? '등록' : '수정'}"/>
<title><spring:message code="board" /> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>

<!--For Commons Validator Client Side-->
<script type="text/javascript" src="<c:url value='/com/validator.do'/>"></script>
<validator:javascript formName="boardVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javaScript" language="javascript" defer="defer">

/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.detailForm.action = "<c:url value='/brd/egovBoardList.do'/>";
   	document.detailForm.submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.detailForm.action = "<c:url value='/brd/deleteBoard.do'/>";
   	document.detailForm.submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.detailForm;
	if(!validateBoardVO(frm)){
		return;
    }else{
    	frm.action = "<c:url value="${registerFlag == '등록' ? '/brd/insertBoard.do' : '/brd/updateBoard.do'}"/>";
        frm.submit();
    }
}

</script>
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">

<form:form commandName="boardVO" name="detailForm">
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"><spring:message code="board" /> <c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#D3E2EC" bordercolordark="#FFFFFF" style="BORDER-TOP:#C2D0DB 2px solid; BORDER-LEFT:#ffffff 1px solid; BORDER-RIGHT:#ffffff 1px solid; BORDER-BOTTOM:#C2D0DB 1px solid; border-collapse: collapse;">
		<colgroup>
			<col width="150">
			<col width="">
		</colgroup>
		<tr>
			<td class="tbtd_caption"><spring:message code="header.title" /></td>
			<td class="tbtd_content">
				<form:input path="title" maxlength="30" cssClass="txt"/>
				&nbsp;<form:errors path="title" />
			</td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="header.contents" /></td>
			<td class="tbtd_content">
				<form:textarea path="contents" rows="5" cols="58" />
					&nbsp;<form:errors path="contents" /></td>
		</tr>
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();"><spring:message code="button.list" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();"><spring:message code="button.delete" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
			</c:if>
			<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();"><spring:message code="button.reset" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>
	</div>
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>

