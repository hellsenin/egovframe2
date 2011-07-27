<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<% 
 /**
  * @Class Name : notificationList.jsp
  * @Description : 정보알림이 목록화면
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
<!-- 정보알림이 표시를 위한 스크립트  -->
<!-- script language="javaScript" src="<c:url value='/js/guide/notification.js' />"></script-->
<script type="text/javascript">
	function init() {
		if (document.frm.searchCnd.value == '0' && document.frm.searchWrd.value != '') {
			var str = document.frm.searchWrd.value;
			
			document.frm.searchWrd.value = str.substr(0,4) + '-' + str.substr(4,2) + '-' + str.substr(6,2);
		}
	}
	
	function isValidDate(str) {
	   	// var test = /^\d{4}-\d{2}-\d{2}$/;
	    var test = /^\d{4}\d{2}\d{2}$/;

	    if (!test.test(str)) {
		    return false;
	    }
		
	    var y, m, d; 

	    y =  parseInt(str.substr(0,4), 10); 
		m = parseInt(str.substr(4,2), 10) - 1; 
		d = parseInt(str.substr(6,2), 10);

	    var dt = new Date(y, m, d);

	    if (dt.getFullYear() == y && dt.getMonth() == m && dt.getDate() == d) { 
	        return true; 
	    } else { 
	        return false;
	    }
	}
	
	function rawDateString(obj) {
		var intValue = '0123456789';
		
		var result = "";
		var str =  String(obj.value);

	    if (str.length < 1) {
	    	result = "";
	    	return true;
	    }

	    for (var i = 0; i < str.length; i++) {
		    if (intValue.indexOf(str.charAt(i)) >= 0) {	// 숫자
				result += str.charAt(i);
		    }
	    }

	    if (isValidDate(result)) {
		    obj.value = result;
		    return true;
	    }

	    return false;
	}
	
	function press(event) {
		if (event.keyCode==13) {
			fn_egov_select_notification('1');
		}
	}
	
	function fn_egov_insert_notification() {	
		document.frm.action = "<c:url value='/guide/insertNotificationPage.do'/>";
		document.frm.submit();
	}
	
	function fn_egov_select_notification(pageNo) {
		if (document.frm.searchCnd.value == '0' && document.frm.searchWrd.value != '') {
			if (rawDateString(document.frm.searchWrd)) {
				// no-op
			} else {
				<c:set var="argument"><spring:message code="guide.notificationDate" /></c:set>
				alert('<spring:message code="errors.date" arguments="${argument}" />');
				document.frm.searchWrd.focus();
				return;
			}
		}

		document.frm.pageIndex.value = pageNo; 
		document.frm.action = "<c:url value='/guide/selectNotificationList.do'/>";
		document.frm.submit();	
	}
	
	function fn_egov_inqire_notification(notificationId) {
		document.frm.notificationId.value = notificationId;
		document.frm.action = "<c:url value='/guide/selectNotification.do'/>";
		document.frm.submit();			
	}
</script>
<title><spring:message code="guide.list.title" /></title>
</head>
<body onload="init()">

<noscript class="PageTitle"><spring:message code="common.noscript.msg" /></noscript>

<div id="border" style="width:730px">

	<form name="frm" method="post" action="<c:url value='/guide/selectNotificationList.do'/>">
		<input type="hidden" name="notificationId">
		<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
		
	<table width="100%" cellpadding="8" class="table-search" border="0">
	<tbody>
	 <tr>
	  <td width="40%" class="title_left">
	   <img src="<c:url value='/images/icon/tit_icon.gif' />" width="16" height="16" hspace="3" align="absmiddle" alt="">&nbsp;<spring:message code="guide.list.title" /></td>
		<td width="10%" >
	   		<select name="searchCnd" class="select">
			   <!-- option selected value=''>--선택하세요--</option-->
			   <option value="0" <c:if test="${searchVO.searchCnd == '0'}">selected="selected"</c:if> ><spring:message code="guide.notificationDate" /></option>
			   <option value="1" <c:if test="${searchVO.searchCnd == '1'}">selected="selected"</c:if> ><spring:message code="guide.notificationSubject" /></option>	
			   <option value="2" <c:if test="${searchVO.searchCnd == '2'}">selected="selected"</c:if> ><spring:message code="guide.notificationContents" /></option>	
		   </select>
		</td>
	  <td width="35%">
	    <input name="searchWrd" type="text" size="35" value='<c:out value="${searchVO.searchWrd}"/>' maxlength="35" onkeypress="press(event);"> 
	  </td>
	  <th width="10%">
	   <table border="0" cellspacing="0" cellpadding="0">
	    <tr>       
	      <td><span class="button"><input type="submit" value="<spring:message code='button.inquire' />" onclick="fn_egov_select_notification('1'); return false;"></span></td>
	      <td>&nbsp;&nbsp;</td>
	      <td><span class="button"><a href="<c:url value='/guide/insertNotificationPage.do'/>?pageIndex=<c:out value='${searchVO.pageIndex}'/>" onclick="fn_egov_insert_notification(); return false;"><spring:message code="button.create" /></a></span></td>
	    </tr>
	   </table>
	  </th>  
	 </tr>
	</tbody>
	</table>
	</form>
	
	<table width="100%" cellpadding="8" class="table-line" summary="<spring:message code='guide.list.summary' />">
	 <thead>
	  <tr>
	    <th class="title" width="10%" nowrap><spring:message code="common.header.no" /></th>
	    <th class="title" width="45%" nowrap><spring:message code="guide.notificationSubject" /></th>
	    <th class="title" width="15%" nowrap><spring:message code="guide.notificationTime" /></th>
	    <th class="title" width="15%" nowrap><spring:message code="guide.interval" /></th>
	    <th class="title" width="15%" nowrap><spring:message code="common.header.created.date" /></th>       
	  </tr>
	 </thead>    
	 <tbody>
		 <c:forEach var="result" items="${resultList}" varStatus="status">
		  <tr>
		    <!--td class="lt_text3" nowrap><input type="checkbox" name="check1" class="check2"></td-->
		    <td class="lt_text3" nowrap><c:out value="${(searchVO.pageIndex-1) * searchVO.pageSize + status.count}"/></td>		    
		    <td class="lt_text3" nowrap>
			    <form name="item" method="post" action="<c:url value='/guide/selectNotification.do'/>">
			    	<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
					<input type="hidden" name="notificationId" value="<c:out value="${result.notificationId}"/>">
				<span class="link"><input type="submit" value="<c:out value="${result.notificationSubject}"/>" onclick="javascript:fn_egov_inqire_notification('<c:out value="${result.notificationId}"/>'); return false;"></span>
				</form>
			</td>
		    <td class="lt_text3" nowrap><c:out value="${result.notificationTime}"/></td>
		    <td class="lt_text3" nowrap><c:out value="${result.intervalString}"/></td>
		    <td class="lt_text3" nowrap><c:out value="${result.registerDateTime}"/></td> 
		  </tr>
		 </c:forEach>	  
		 <c:if test="${fn:length(resultList) == 0}">
		  <tr>
		    <td class="lt_text3" nowrap colspan="5"><spring:message code="common.nodata.msg" /></td>  
		  </tr>		 
		 </c:if>
	 </tbody>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr> 
	    <td height="10"></td>
	  </tr>
	</table>
	<div align="center">
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_notification" />
	</div>
</div>

</body>
</html>