<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<% 
/**
 * @Class Name : notificationDetail.jsp
 * @Description : 정보알림이 상세조회
 * @Modification Information
 * @
 * @  수정일      수정자            수정내용
 * @ -------        --------    ---------------------------
 * @ 2011.01.01   홍길동          최초 생성
 *
 *  @author 개발팀 홍길동
 *  @since 2011.01.01
 *  @version 1.0 
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value='/css/com.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/css/button.css' />" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function onloading() {
		if ("<c:out value='${msg}'/>" != "") {
			alert("<c:out value='${msg}'/>");
		}
	}
	
	function fn_egov_select_notificationList(pageNo) {
		document.frm.pageIndex.value = pageNo; 
		document.frm.action = "<c:url value='/guide/selectNotificationList.do'/>";
		document.frm.submit();	
	}
	
	function fn_egov_delete_notification() {		
		if (confirm('<spring:message code="common.delete.msg" />')) {
			document.frm.action = "<c:url value='/guide/deleteNotification.do'/>";
			document.frm.submit();
		}	
	}
	
	function fn_egov_moveUpdt_notification() {
		document.frm.action = "<c:url value='/guide/updateNotificationPage.do'/>";
		document.frm.submit();			
	}
</script>
<title><spring:message code="guide.detail.title" /></title>
</head>
<body onload="onloading();">

<noscript class="PageTitle"><spring:message code="common.noscript.msg" /></noscript>

<form name="frm" method="post" action="">
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="notificationId" value="<c:out value='${result.notificationId}'/>" />
</form>

<div id="border" style="width:730px">

	<table width="100%" cellpadding="8" class="table-search" border="0">
	 <tr>
	  <td width="100%" class="title_left">
	   <img src="<c:url value='/images/icon/tit_icon.gif' />" width="16" height="16" hspace="3" align="absmiddle" alt="">
	   &nbsp;<spring:message code="guide.detail.title" /></td>
	 </tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="table-register" summary="<spring:message code='guide.detail.title' />">
	<tbody>
	  <tr> 
	    <th width="15%" height="23" nowrap class=""><spring:message code="guide.notificationSubject" /></th>
	    <td width="85%" colspan="3" nowrap>
	    	<!-- TODO [Step 5-11] JSP model 사용  -->
	    	<!-- JSP에서는 model 정보를 EL(Expression Language) 방식으로 표시함  -->
	    	<!-- Ex :
	    	<c:out value="${result.notificationSubject}" />
	    	 -->
	    </td>
	  </tr>
	  <tr> 
	    <th height="23" class=""><spring:message code="guide.notificationContents" /></th>
	    <td colspan="3">
			<c:out value="${result.notificationContents}"/>
	    </td>
	  </tr>
	  <tr> 
	    <th width="15%" height="23" nowrap class=""><spring:message code="guide.notificationTime" /></th>
	    <td width="15%" class="listCenter" nowrap>
	   		<c:out value="${result.notificationTime}" />
	    </td>
	    <th width="15%" height="23" nowrap class=""><spring:message code="guide.interval" /></th>
	    <td width="15%" class="listCenter" nowrap><c:out value="${result.intervalString}" />
	    </td>
	  </tr>
	  <tr> 
	    <th width="15%" height="23" nowrap class=""><spring:message code="common.header.writer" /></th>
	    <td width="15%" class="listCenter" nowrap>
	   		<c:out value="${result.registerUserName}" />
	    </td>
	    <th width="15%" height="23" nowrap class=""><spring:message code="common.header.write.time" /></th>
	    <td width="15%" class="listCenter" nowrap><c:out value="${result.registerDateTime}" />
	    </td>
	  </tr>
	</tbody> 
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr> 
	    <td height="10"></td>
	  </tr>
	</table>
	<div align="center">
	<table width="100%"  border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>
	 <td width="100%">
	 <div align="center">
		<table border="0" cellspacing="0" cellpadding="0" align="center">
			<tr> 
		     <c:if test="${result.registerUserId == sessionUniqId}">     
			      <td>  
		  			<form name="modifyFrm" method="post" action="<c:url value='/guide/updateNotificationPage.do'/>">
						<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
						<input type="hidden" name="notificationId" value="<c:out value='${result.notificationId}'/>" />
						<span class="button"><input type="submit" value="<spring:message code='button.update' />" onclick="fn_egov_moveUpdt_notification(); return false;"></span>
		  			</form> 
		 		  </td>
			      <td width="10"></td>
			      <td>  
		  			<form name="deleteFrm" method="post" action="<c:url value='/guide/deleteNotification.do'/>">
						<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
						<input type="hidden" name="notificationId" value="<c:out value='${result.notificationId}'/>" />
						<span class="button"><input type="submit" value="<spring:message code='button.delete' />" onclick="fn_egov_delete_notification(); return false;"></span>
		  			</form> 
		 		  </td>
		 		  <td width="10"></td>
		     </c:if>
		      <td>  
		  		<form name="listFrm" method="post" action="<c:url value='/guide/selectNotificationList.do'/>">
					<input name="pageIndex" type="hidden" value="1" />
					<span class="button"><input type="submit" value="<spring:message code='button.list' />" onclick="fn_egov_select_notificationList('1'); return false;"></span>
		  		</form> 
		 	  </td>
			</tr>
		</table>
		</div>
	 </td>
	</tr>
	</table>
	</div>
</div>

</body>
</html>