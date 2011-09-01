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
	if(confirm("<spring:message code="msg.del" />")){
		document.detailForm.action = "<c:url value='/brd/deleteBoard.do'/>";
	   	document.detailForm.submit();		
	}
}

/* 글 등록  및 수정 function */
function fn_egov_save() {	
	frm = document.detailForm;
	if(!validateBoardVO(frm)){
		return;
    }else{
    	if("<c:out value="${registerFlag}"/>" == "등록"){
    		if(confirm("<spring:message code="msg.insert" />")){
    			frm.action  = "<c:url value='/brd/insertBoard.do'/>";
    			frm.submit();		
    		}
    	}else{
    		if(confirm("<spring:message code="msg.update" />")){
    			frm.action  = "<c:url value='/brd/updateBoard.do'/>";
    			frm.submit();		
    		}
    	}
    }
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
<form:form commandName="boardVO" name="detailForm">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>" /><spring:message code="board" /> <c:out value="${registerFlag}"/></li>
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
			<td class="tbtd_caption"><spring:message code="board.header.title" /></td>
			<td class="tbtd_content">
				<c:if test="${loginVO.memberNo != boardVO.memberNo && registerFlag !='등록' }">
					<form:input path="title" maxlength="30" cssClass="txt" readonly="true"/>
					&nbsp;<form:errors path="title" />
				</c:if>
				<c:if test="${loginVO.memberNo == boardVO.memberNo || registerFlag =='등록'}">
					<form:input path="title" maxlength="30" cssClass="txt"/>
					&nbsp;<form:errors path="title" />
				</c:if>
			</td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="board.header.contents" /></td>
			<td class="tbtd_content">
			<c:if test="${loginVO.memberNo != boardVO.memberNo && registerFlag !='등록' }">
					<form:textarea path="contents" rows="5" cols="58" readonly="true"/>
					&nbsp;<form:errors path="contents" />
				</c:if>
				<c:if test="${loginVO.memberNo == boardVO.memberNo || registerFlag =='등록'}">
					<form:textarea path="contents" rows="5" cols="58" />
					&nbsp;<form:errors path="contents" />
				</c:if>
			</td>
		</tr>
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();"><spring:message code="button.list" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				<c:if test="${registerFlag == '등록'}">
					<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
					<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();"><spring:message code="button.reset" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				</c:if>
				<c:if test="${registerFlag == '수정'}">
					<c:if test="${loginVO.memberNo == boardVO.memberNo}">
						<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
						<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();"><spring:message code="button.delete" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
						<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();"><spring:message code="button.reset" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
					</c:if>
					<c:if test="${loginVO.mngrSe == 'ROLE_ADMIN'}">
						<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();"><spring:message code="button.delete" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
					</c:if>
				</c:if>
			</ul>
	</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
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

