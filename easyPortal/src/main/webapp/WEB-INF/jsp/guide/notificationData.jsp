<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- 
 /**
  * @Class Name : notificationData.jsp
  * @Description : 정보알림이 표시XML 화면
  * @Modification Information
  * @
  * @  수정일      수정자            수정내용
  * @ -------        --------    ---------------------------
  * @ 2011.01.01   홍길동          최초 생성
  *
  *  @author 개발팀 홍길동
  *  @since 2011.01.01
  *  @version 1.0 
  *  @see
  */
--%>
<root>
<c:forEach var="result" items="${list}" varStatus="status">
	<list>
		<time><c:out value='${result.notificationTime}'/></time>
		<title><c:out value='${result.notificationSubject}'/></title>
		<contents><![CDATA[<c:out value='${result.notificationContents}'/>]]></contents>
	</list>
</c:forEach>
</root>