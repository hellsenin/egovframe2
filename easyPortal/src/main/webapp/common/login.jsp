<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.lang.String" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>
<%
 /**
  * @Class Name : login.jsp
  * @Description : 사용자 로그인 화면
  * @Modification Information
  * @
  * @  수정일      수정자            수정내용
  * @ -------        --------    ---------------------------
  * @ 2011.01.01   홍길동          최초 생성
  *
  *  @author 개발팀 홍길동
  *  @since 2010.01.01
  *  @version 1.0 
  *  @see
  */
%>
<html>
<head>
<title>Login</title>
<link href="<c:url value='/css/com.css' />" rel="stylesheet" type="text/css">
<link href="<c:url value='/css/button.css' />" rel="stylesheet" type="text/css">
<meta http-equiv="content-type" content="text/html; charset=euc-kr">
<script language="JavaScript">
function init() {
	document.loginForm.j_username.focus();
}

function fncLogin() {
	document.loginForm.action="<c:url value='/j_spring_security_check'/>";
	document.loginForm.submit();
}

</script>

</head>

<body bgcolor="#ffffff" text="#000000" onload="init();">

<form name="loginForm"  action="<c:url value='/j_spring_security_check'/>">
<DIV id="main" style="display:">
<TABLE WITH="100%" HEIGHT="100%" BORDER="0" CELLPADDING="0" CELLSPACING="0">
<TR>
<TD ALIGN="CENTER" VALIGN="MIDDLE">

<!--************************** begin of contents *****************************-->

<table width="650" height="390" border="5" cellpadding="0" cellspacing="0" bordercolor="#D6CDB7">
  <tr> 
    <td width="10" height="5" align="left" valign="top" bordercolor="#D6CDB7">
    <table width="650" height="390" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="445" align="left" valign="top" background="<c:url value='/images/login02.gif'/>">
          <table width="100%" height="220" border="0" cellpadding="0" cellspacing="0">
              <tr> 
                <td width="30" height="100">&nbsp;</td>
                <td width="100" height="100">&nbsp;</td>
                <td width="20" height="100">&nbsp;</td>
              </tr>
              <tr> 
                <td height="60" colspan="3">
								    <c:if test="${not empty param.fail}">
								      <font color="red">
								        &nbsp;&nbsp;&nbsp;Your login attempt was not successful, try again.<BR>
								        &nbsp;&nbsp;&nbsp;Reason: <%= ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
								      </font>
								      <br/>
								    </c:if>	                
                </td>
              </tr>              
              <tr> 
                <td height="30">&nbsp;</td>
                <td height="30" align="right">
                 	 <spring:message code="common.login.id" /> : 
                 	 <input type='text' name='j_username' <c:if test="${not empty param.fail}">value='<c:out value="${SPRING_SECURITY_LAST_USERNAME}"/>'</c:if>
                            style='width:180px; height:19px' required fieldTitle='ID' maxLength='50'>          
                 	 </input>                                       												
        		</td>
                <td height="30">&nbsp;</td>
              </tr>
              <tr> 
                <td  height="30">&nbsp;</td>
                <td height="30" align="right">                    
                   	<spring:message code="common.login.password" /> : 
                   	<input type="password" name="j_password" style="width:180px; height:19px" required fieldTitle="Password" maxLength="50" onKeyPress="if(event.keyCode==13) fncLogin();">                                        
                </td>
                <td height="30">&nbsp;</td>
              </tr>
              <tr> 
                <td height="20">&nbsp;</td>
                <td height="20">&nbsp;</td>
                <td height="20" align="center">
      				    <!--버튼들어가는 테이블-->
      				    <table width="136" height="20" border="0" cellpadding="0" cellspacing="0">
                          <tr> 
                            <td width="56">
                            	<!-- a href="javascript:fncLogin();"><spring:message code="common.login.button" /></a-->
                            	<input type="submit" value="<spring:message code='common.login.button' />" onclick="fncLogin(); return false;">
                            </td>
                            <td width="10">&nbsp;</td>
                          </tr>
                        </table></td>
                    </tr>
                  </table>
                </td>
              </tr>                            
      </table>
      </td>
  </tr>
</table>
</TD></TR>
  
</TABLE>
</div>

</form>
</body>
</html>
