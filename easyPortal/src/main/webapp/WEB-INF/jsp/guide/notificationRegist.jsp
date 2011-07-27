<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%
/**
 * @Class Name : notificationRegist.jsp
 * @Description : 정보알림이 등록화면
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
<script type="text/javascript" src="<c:url value='/js/common/calendarPopup.js' />"></script>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="notification" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javascript">
	function onloading() {
		if ("<c:out value='${msg}'/>" != "") {
			alert("<c:out value='${msg}'/>");
		}
	}
	
	function fn_egov_SelectBoxValue(sbName) {
		var fValue = "";
		
		for (var i=0; i < document.getElementById(sbName).length; i++) {
			if (document.getElementById(sbName).options[i].selected == true) {
				fValue = document.getElementById(sbName).options[i].value;
			}
		}
		
		return  fValue;
	}
	
	function fn_egov_regist_notification(){
		if (!validateNotification(document.notification)){
			return;
		}

		var checked = false;
		for (var i = 0; i < document.notification.interval.length; i++) {
			if (document.notification.interval[i].checked) {
				checked = true;
				break;
			}
		}

		if (!checked) {
			alert('<spring:message code="guide.interval.msg" />');
			return;
		}
		
		if (confirm('<spring:message code="common.regist.msg" />')) {
			form = document.notification;
			form.action = "<c:url value='/guide/insertNotification.do'/>";

			form.ntfcTime.value = fn_egov_SelectBoxValue('notificationHour') + ":" + fn_egov_SelectBoxValue('notificationMinute');
			
			form.submit();					
		}
	}
	
	function fn_egov_select_notification(){
		form = document.notification;
		form.action = "<c:url value='/guide/selectNotificationList.do'/>";
		form.submit();	
	}
	
</script>

<title><spring:message code="guide.regist.title" /></title>
</head>
<body onload="onloading()">

<noscript class="PageTitle"><spring:message code="common.noscript.msg" /></noscript>

<div id="border" style="width:730px">

<form:form commandName="notification" name="notification" method="post" action="${pageContext.request.contextPath}/guide/insertNotification.do">

	<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input name="notificationTime" id="notificationTime" type="hidden" value="">

	<table width="100%" cellpadding="8" class="table-search" border="0">
	 <tr>
	  <td width="100%"class="title_left">
	   <img src="<c:url value='/images/icon/tit_icon.gif' />" width="16" height="16" hspace="3" align="absmiddle" alt="">&nbsp;<spring:message code="guide.regist.title" /></td>
	 </tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="table-register" summary="<spring:message code='guide.regist.summary' />">
	<tbody>
	  <tr> 
	    <th width="20%" height="23" class="required_text" nowrap ><label for="notificationSubject"><spring:message code="guide.notificationSubject" /></label>
	    <img src="<c:url value='/images/icon/required.gif' />" width="15" height="15" alt="required"></th>
	    <td width="80%" nowrap colspan="3">
	    	<form:input path="notificationSubject" size="25" cssStyle="width:100%" />
	    	<br/><form:errors path="notificationSubject" />
	    </td>
	  </tr>
	  <tr> 
	    <th height="23" class="required_text" ><label for="notificationContents"><spring:message code="guide.notificationContents" /></label>
	    <img src="<c:url value='/images/icon/required.gif' />" width="15" height="15" alt="required"></th>
	    <td colspan="3">
	       <form:textarea path="notificationContents" cols="75" rows="2" cssStyle="width:100%" />
	       <br/><form:errors path="notificationContents" />
	    </td>
	  </tr>
	  <tr> 
	    <th width="20%" height="23" class="required_text" nowrap ><label for="notificationDate"><spring:message code="guide.notificationDate" /></label>
	    <img src="<c:url value='/images/icon/required.gif' />" width="15" height="15" alt="required"></th>
	    <td width="30%" nowrap>
			<input name="notificationDate" id="notificationDate" type="text" size="73" value="" maxlength="10" style="width:80px;" readOnly>
			<a href="#" onClick="javascript:fn_NormalCalendar( document.getElementById('notification'),  document.getElementById('notificationDate') );">  
      		<img src="<c:url value='/images/calendar/bu_icon_carlendar.gif' />"  align="absmiddle" style="border:0px" alt="<spring:message code='common.calendar.msg' />" title="<spring:message code='common.calendar.msg' />">
			</a>
	  	   <br/><form:errors path="notificationDate" />
	    </td>
	    <th width="20%" height="23" class="required_text" nowrap ><label for="notificationHour"><spring:message code="guide.notificationTime" /></label>
	    <img src="<c:url value='/images/icon/required.gif' />" width="15" height="15" alt="required"></th>    
	    <td width="30%" nowrap>
			<select name="notificationHour" id="notificationHour">
				<option value=""><spring:message code="common.header.select" /></option>
				<c:forEach var="h" begin="1" end="24" step="1">
				<option value="${h}">${h} <spring:message code="common.header.hour" /></option>
				</c:forEach>
			</select>
	
			<select name="notificationMinute" id="notificationMinute">
				<option value=""><spring:message code="common.header.select" /></option>
				<option value="0">0 <spring:message code="common.header.minute" /></option>
				<c:forEach var="m" begin="1" end="60" step="1">
				<option value="${m}">${m} <spring:message code="common.header.minute" /></option>
				</c:forEach>
			</select>
	  	    <br/><form:errors path="notificationHour" /><form:errors path="notificationMinute" />
	    </td>    
	  </tr>
	  <tr> 
	    <th width="20%" height="23" class="required_text" ><label for="interval"><spring:message code="guide.interval" /></label>
	    <img src="<c:url value='/images/icon/required.gif' />" width="15" height="15" alt="required"></th>
	    <td width="30%" nowrap colspan="3" >
			1 <spring:message code="common.header.minute" />:<form:checkbox path="interval" value="1"/>&nbsp;&nbsp;
			3 <spring:message code="common.header.minute" />:<form:checkbox path="interval" value="3"/>&nbsp;&nbsp;
			5 <spring:message code="common.header.minute" />:<form:checkbox path="interval" value="5"/>&nbsp;&nbsp;
			10 <spring:message code="common.header.minute" />:<form:checkbox path="interval" value="10"/>&nbsp;&nbsp;
			30 <spring:message code="common.header.minute" />:<form:checkbox path="interval" value="30"/>&nbsp;&nbsp;
	  	   <br/><form:errors path="interval" />
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
	<table border="0" cellspacing="0" cellpadding="0" align="center">
	<tr>      
      <td><span class="button"><input type="submit" value="<spring:message code="button.create" />" onclick="fn_egov_regist_notification(); return false;"></span></td>
      <td width="10"></td>
      <td><span class="button"><a href="<c:url value='/guide/selectNotificationList.do'/>?pageIndex=<c:out value='${searchVO.pageIndex}'/>" onclick="fn_egov_select_notification(); return false;"><spring:message code="button.list" /></a></span></td>
	</tr>
	</table>
	</div>
	</form:form>
	
</div>

</body>
</html>