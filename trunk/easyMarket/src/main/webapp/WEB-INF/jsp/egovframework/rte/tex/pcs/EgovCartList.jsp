<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : EgovCartList.jsp
  * @Description : 장바구니 화면
  * @author 이영진
  * @since 2011.06.15
  * @version 1.0
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="cart.title"/></title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">
/* 선택된 항목 구매 function */
function fn_egov_purchase() {
	if(!fn_check_frm())
	{
	alert("<spring:message code="info.nocheckdata.msg"/>");	
	return;
	}
	if(!confirm("<spring:message code="msg.purchase" />")) {
		return;
	}
  	document.listForm.action = "<c:url value='/pcs/purchaseFromCart.do'/>";
   	document.listForm.submit();	
}
/* 선택된 항목 삭제 function */
function fn_egov_delete() {
	if(!fn_check_frm())
	{
	alert("<spring:message code="info.nocheckdata.msg"/>");	
	return;
	}

	if(!confirm("<spring:message code="msg.del" />")) {
		return;
	}
  	document.listForm.action = "<c:url value='/pcs/deleteCart.do'/>";
   	document.listForm.submit();		
}

/* 체크박스 체크여부 확인 */
function fn_check_frm() {
  var ok = false;
  var chk_arr = document.getElementsByName("cart_col_check[]");
  var len = chk_arr.length;
  for (var i = 0; i < len; i++) {
    if (chk_arr[i].checked == true) {
      ok = true;
      break;
    }
  }
  return ok;
}

/* 체크박스 전체 체크/해제 */
function fn_check_all() {
	  var chkbox = document.getElementsByName("cart_col_check[]");
	 if(chkbox.length) {  // 여러 개일 경우
	     for(var i = 0; i < chkbox.length;i++) {
	      chkbox[i].checked=document.listForm.allChk.checked;
	     }
	    }
}
	
/* 상품상세 화면 function */
function fn_egov_select(id) {
	document.listForm.selectedId.value = id;
   	document.listForm.action = "<c:url value='/gds/getGoodsView.do'/>";
   	document.listForm.submit();		
}

/* 상품상세 화면 function */
// function fn_egov_selectGoodsList() {
//    	document.listForm.action = "<c:url value='/gds/selectListGoods.do'/>";
//    	document.listForm.submit();		
// }

/* 검색 후 리스트화면 function */
function fn_egov_selectList() {
	document.listForm.action = "<c:url value='/pcs/selectListCart.do'/>";
   	document.listForm.submit();
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.listForm.pageIndex.value = pageNo;
	document.listForm.action = "<c:url value='/pcs/selectListCart.do'/>";
   	document.listForm.submit();
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
<form:form commandName="searchVO" name="listForm" method="post">
<input type="hidden" name="selectedId" />
<input type="hidden" name="searchCondition" value="1"/>
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"/> <spring:message code="cart.title"/> </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="search">
		<ul>
		<li><form:input path="searchKeyword" cssClass="txt"/></li>
		<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li></ul>		
	</div>
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
				<col width="10" />	 			
				<col width="400" />  
				<col width="115" /> 
				<col width="40" /> 
				<col width="115" />
			</colgroup>		  
			<tr>
				<th align="center"><input type="checkbox" name="allChk" onclick="fn_check_all();"/></th>
				<th align="center"><spring:message code="cart.header.goodsNm"/></th>
				<th align="center"><spring:message code="cart.header.price"/></th>
				<th align="center"><spring:message code="cart.header.qy"/></th>
				<th align="center"><spring:message code="cart.header.sum"/></th>
			</tr>
			<c:set var="sum" value="${0}"/>
				<c:forEach var="result" items="${resultList}" varStatus="status">
					<tr>
						<td align="center" class="listtd"><input type="checkbox" name="cart_col_check[]" value='${result.cartId}'/></td>
						<td align="center" class="listtd"> 
							<a href="javascript:fn_egov_select('<c:out value="${result.goodsVO.goodsId}"/>')"><c:out value="${result.goodsVO.goodsNm}"/></a>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.goodsVO.price}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.qy}"/>&nbsp;</td>
						<td align="center" class="listtd"><c:out value="${result.goodsVO.price * result.qy}"/>&nbsp;<spring:message code="cart.won"/></td>
					</tr>
					<c:set var="sum" value="${sum+(result.goodsVO.price * result.qy)}"/>
				</c:forEach>
		</table>
		
	<table border="0" width="100%">
		<tr>
			<th style="text-align:right;margin-right:6px" colspan="2" height="40">&nbsp;&nbsp;&nbsp;<spring:message code="cart.cartSum"/>&nbsp;:&nbsp;${sum}<spring:message code="cart.won"/></th>
		</tr>
	</table>
	</div>
	<!-- /List -->
		<div id="sysbtn">
			<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_purchase();"><spring:message code="cart.btn.purchase"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();"><spring:message code="cart.btn.delete"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			</ul>
		</div> 
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
