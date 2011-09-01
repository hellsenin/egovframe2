<%@ page contentType="text/plain; charset=euc-kr" %>
<%
 request.setCharacterEncoding("utf-8");
 String qy = request.getParameter("qy");
 String price = request.getParameter("price");
 int sum = Integer.parseInt(qy) *  Integer.parseInt(price);
%>
<%=sum%> ¿ø