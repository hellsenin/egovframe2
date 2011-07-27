<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%
/**
 * @Class Name : notificationUpdate.jsp
 * @Description : 정보알림이 수정화면
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
	
	function fn_egov_update_notification(){
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
		
		if (confirm('<spring:message code="common.update.msg" />')) {
			form = document.notification;
			form.action = "<c:url value='/guide/updateNotification.do'/>";

			form.ntfcTime.value = fn_egov_SelectBoxValue('notificationHour') + ":" + fn_egov_SelectBoxValue('notificationMinute');
			
			form.submit();					
		}
	}
	
	function fn_egov_select_notification(){
		var form = document.notification;
		form.action = "<c:url value='/guide/selectNotificationList.do'/>";
		form.submit();	
	}

	function init() {
		onloading();
		
		var form = document.notification;

		var hh = form.notificationTime.value.substr(0, 2);
		var mm = form.notificationTime.value.substr(3, 2);

		if (hh.charAt(0) == '0') {
			hh = hh.charAt(1);
		}

		if (mm.charAt(0) == '0') {
			mm = mm.charAt(1);
		}

		for (var i = 0; i < form.notificationHour.length; i++) {
			if (form.notificationHour[i].value == hh) {
				form.notificationHour[i].selected = true;
			}
		}

		for (var i = 0; i < form.notificationMinute.length; i++) {
			if (form.notificationMinute[i].value == mm) {
				form.notificationMinute[i].selected = true;
			}
		}
	}
</script>

<title><spring:message code="guide.updt.title" /></title>
</head>
<body onload="init()">

<noscript class="PageTitle"><spring:message code="common.noscript.msg" /></noscript>

<form:form commandName="notification" name="notification" method="post" action="${pageContext.request.contextPath}/uss/ion/updateNotification.do">

<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
<input name="notificationId" type="hidden" value="<c:out value='${result.notificationId}'/>" />

<input name="notificationTime" id="notificationTime" type="hidden" value='<c:out value="${fn:substring(result.notificationTime,11,16)}"/>'>

<div id="border" style="width:730px">

	<table width="100%" cellpadding="8" class="table-search" border="0">
	 <tr>
	  <td width="100%"class="title_left">
	   <img src="<c:url value='/images/icon/tit_icon.gif' />" width="16" height="16" hspace="3" align="absmiddle" alt="">&nbsp;<spring:message code="guide.updt.title" /></td>
	 </tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" class="table-register" summary="<spring:message code='guide.updt.summary' />">
	<tbody>
	  <tr> 
	    <th width="20%" height="23" class="required_text" nowrap ><label for="notificationSubject"><spring:message code="guide.notificationSubject" /></label>
	    <img src="<c:url value='/images/icon/required.gif' />" width="15" height="15" alt="required"></th>
	    <td width="80%" nowrap colspan="3">
	    	<input name="notificationSubject" size="25" value='<c:out value="${result.notificationSubject}"/>' style="width:100%" />
	    	<br/><form:errors path="notificationSubject" />
	    </td>
	  </tr>
	  <tr> 
	    <th height="23" class="required_text" ><label for="notificationContents"><spring:message code="guide.notificationContents" /></label>
	    <img src="<c:url value='/images/icon/required.gif' />" width="15" height="15" alt="required"></th>
	    <td colspan="3">
	       <textarea name="notificationContents" class="textarea" cols="75" rows="2" style="width:100%"><c:out value="${result.notificationContents}" escapeXml="true" /></textarea>
	       <br/><form:errors path="notificationContents" />
	    </td>
	  </tr>
	  <tr> 
	    <th width="20%" height="23" class="required_text" nowrap ><label for="notificationDate"><spring:message code="guide.notificationDate" /></label>
	    <img src="<c:url value='/images/icon/required.gif' />" width="15" height="15" alt="required"></th>
	    <td width="30%" nowrap>
			<input name="notificationDate" id="notificationDate" type="text" size="73" value="<c:out value='${fn:substring(result.notificationTime, 0, 10)}'/>" maxlength="10" style="width:80px;" readOnly>
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
	    <c:set var="data">,<c:out value="${result.intervalString}" /></c:set>
			<c:set var="array" value="1,3,5,10,30" />
			<c:forEach var="index" items="${array}">
				<c:set var="test">,<c:out value="${index}" /><spring:message code="guide.minute.label" /></c:set>
				<!-- <c:out value="${test}" /> -->
				${index} <spring:message code="common.header.minute" />:<input id="interval" name="interval" type="checkbox" value="<c:out value='${index}' />" <c:if test="${fn:contains(data, test)}">checked="true"</c:if>/>&nbsp;&nbsp;
			</c:forEach>
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
	  <td><span class="button"><input type="submit" value="<spring:message code="button.update" />" onclick="fn_egov_update_notification(); return false;"></span></td>
      <td width="10"></td>
      <td><span class="button"><a href="<c:url value='/guide/selectNotificationList.do'/>?pageIndex=1" onclick="fn_egov_select_notification(); return false;"><spring:message code="button.list" /></a></span></td>
	</tr>
	</table>
	</div>
</div>
</form:form>
</body>
</html>