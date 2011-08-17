<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : EgovDeliveryList.jsp
  * @Description : 상품목록 화면
  * @author 이영진
  * @since 2011.07.05
  * @version 1.0
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="purchsAll.title"/></title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>
<script type="text/javaScript" language="javascript" defer="defer">

/* 구매목록 xml로 내보내기 function */
function fn_egov_xml() {
   	document.listForm.action = "<c:url value='/dlv/viewXML.do'/>";
   	document.listForm.submit();	
}

/* 배송상태 변경 function */
function fn_egov_changeDlvy(id,sttus) {
	document.listForm.purchaseId.value = id;
	document.listForm.dlvySe.value = sttus;
	
   	document.listForm.action = "<c:url value='/dlv/updateDlvySttus.do'/>";
   	document.listForm.submit();		
}

/* 상품상세 화면 function */
function fn_egov_select(id) {
	document.listForm.selectedId.value = id;
   	document.listForm.action = "<c:url value='/gds/getGoodsView.do'/>";
   	document.listForm.submit();		
}

/* 메인 화면 function */
// function fn_egov_main() {
//    	document.listForm.action = "<c:url value='/gds/selectListGoods.do'/>";
//    	document.listForm.submit();		
// }

/* 검색 후 리스트화면 function */
function fn_egov_selectList() {
	document.listForm.action = "<c:url value='/dlv/selectAllListPurchase.do'/>";
   	document.listForm.submit();
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.listForm.pageIndex.value = pageNo;
	document.listForm.action = "<c:url value='/dlv/selectAllListPurchase.do'/>";
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
<input type="hidden" name="purchaseId" />
<input type="hidden" name="dlvySe" />
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"/> <spring:message code="purchs.title"/> </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="search">
		<ul>
			<li><spring:message code="purchs.header.goodsNm"/>: </li>
			<li><form:input path="searchKeyword" cssClass="txt"/></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();"><spring:message code="button.search" /></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
		</ul>		
	</div>
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
				<col width="40" />	 			
				<col width="100" />	 			
				<col width="250" />  
				<col width="100" /> 
				<col width="40" />  
				<col width="100" />
				<col width="80" />
			</colgroup>		  
			<tr>
				<th align="center"><spring:message code="purchs.header.no"/></th>
				<th align="center"><spring:message code="purchs.header.date"/></th>
				<th align="center"><spring:message code="purchs.header.goodsNm"/></th>
				<th align="center"><spring:message code="purchs.header.price"/></th>
				<th align="center"><spring:message code="purchs.header.qy"/></th>
				<th align="center"><spring:message code="purchs.header.sum"/></th>
				<th align="center"><spring:message code="purchs.header.status"/></th>
			</tr>
<%-- 			<c:set var="sum" value="${0}"/> --%>
				<c:forEach var="result" items="${resultList}" varStatus="status">
					<tr>
						<td align="center" class="listtd"><c:out value="${status.count}"/></td>
						<td align="center" class="listtd"><c:out value="${result.purchsDe}"/></td>
						<td align="center" class="listtd"> 
							<a href="javascript:fn_egov_select('<c:out value="${result.goodsVO.goodsId}"/>')"><c:out value="${result.goodsVO.goodsNm}"/></a></td>
						<td align="center" class="listtd"><c:out value="${result.goodsVO.price}"/></td>
						<td align="center" class="listtd"><c:out value="${result.qy}"/></td>
						<td align="center" class="listtd"><c:out value="${result.goodsVO.price * result.qy}"/><spring:message code="cart.won"/></td>
						<td align="center" class="listtd">
							<select name="${result.purchsId}" onchange="fn_egov_changeDlvy(this.name,this.value)">
								<c:forEach var="dlvyInfo" items="${dlvyList}" varStatus="status2">
										<option value="${dlvyInfo.dlvySe}" ${dlvyInfo.dlvySe == result.dlvySe ? 'selected' : ''}>${dlvyInfo.dlvySttus}</option>	
								</c:forEach>
							</select>
						</td>
					</tr>
<%-- 				<c:set var="sum" value="${sum+(result.goodsVO.price * result.qy)}"/> --%>
				</c:forEach>
		</table>
		
<!-- 	<table border="0" width="99%" style="margin-left:6px"> -->
<!-- 		<tr> -->
<%-- 			<th style="text-align: right;margin-right:5px" colspan='2' height="40">&nbsp;&nbsp;&nbsp;<spring:message code="cart.cartSum"/>&nbsp;:&nbsp;${sum}<spring:message code="cart.won"/></th> --%>
<!-- 		</tr> -->
<!-- 	</table> -->
	</div>
	<!-- /List -->
	<div id="paging">
		<ui:pagination paginationInfo = "${paginationInfo}"
				   type="image"
				   jsFunction="fn_egov_link_page"
				   />
		<form:hidden path="pageIndex" />
	</div>
	
		<div id="sysbtn">
			<ul>
<%-- 				<li><span class="btn_blue_l"><a href="javascript:fn_egov_excel();"><spring:message code="purchs.btn.excel"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li> --%>
				<li><span class="btn_blue_l"><a href="javascript:fn_egov_xml();"><spring:message code="purchs.btn.xml"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
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
