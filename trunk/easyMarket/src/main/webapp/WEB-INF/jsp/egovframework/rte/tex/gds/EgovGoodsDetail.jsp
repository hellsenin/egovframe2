<%-- <%@page import="java.text.Normalizer.Form"%> --%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : EgovGoodsDetail.jsp
 * @Description : 상품 상세화면
 * @author 이영진
 * @since 2011.06.16
 * @version 1.0
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><spring:message code="goods.title"/></title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>

<!--For Commons Validator Client Side-->
<script type="text/javascript" src="<c:url value='/com/validator.do'/>"></script>
<validator:javascript formName="goodsVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 상품 목록 화면 function */
function fn_egov_selectList() {
   	document.detailForm.action = "<c:url value='/gds/selectListGoods.do'/>";
   	document.detailForm.submit();		
}

/* 상품 삭제 function */
function fn_egov_delete() {
	if(!confirm("<spring:message code="msg.del" />")) {
		return;
	}
   	document.detailForm.action = "<c:url value='/gds/deleteGoods.do'/>";
   	document.detailForm.submit();		
}

/* 상품 수정 화면 function */
function fn_egov_update() {	
   	document.detailForm.action = "<c:url value='/gds/updateGoodsView.do' />";
   	document.detailForm.submit();
}

/* 장바구니 담기 function */
function fn_egov_insertCart() {
	if(!confirm("<spring:message code="msg.cart" />")) {
		return;
	}
   	document.detailForm.action = "<c:url value='/pcs/insertCart.do' />";
   	document.detailForm.submit();
}

/* 바로 구매 function */
function fn_egov_insertPurchase() {
	if(!confirm("<spring:message code="msg.purchase" />")) {
		return;
	}
   	document.detailForm.action = "<c:url value='/pcs/Purchase.do' />";
   	document.detailForm.submit();
}

/* XMLHttpRequest 객체 얻기 */
var xhr = null;
function getXMLHttpRequest() {
    if (window.ActiveXObject) {
        try {
            return new ActiveXObject("Msxml2.XMLHTTP");//IE 상위 버젼
        } catch (e1) {
            try {
                return new ActiveXObject("Microsoft.XMLHTTP");//IE 하위 버젼
            } catch (e2) {
                return null;
            }
        }
    } else if (window.XMLHttpRequest) {
        return new XMLHttpRequest(); //다른 브라우저 일때
    } else {
        return null;
    }
}
function intCheck(f) {
		var pattern = /(^[0-9]+$)/;
		if(!pattern.test(f.value)){
			alert('숫자만 가능합니다.');
			f.value = '';
			f.focus();
			return false;
		}
		return true;
}

/*합계를 요청한다*/
function requestSum(URL,PRICE) {
	param = document.detailForm.qy.value;
	if(!intCheck(document.detailForm.qy)) return;
	URL = "../" + URL + "?qy=" + param + "&price=" + PRICE;//한글 처리
    xhr = getXMLHttpRequest();//XMLHttpRequest 객체 얻기
    xhr.onreadystatechange = responseSum;//콜백 함수  등록
    xhr.open("GET", URL, true);//연결
    xhr.send(null);//전송
}
 
function responseSum() {
    if (xhr.readyState == 4) {//완료
        if (xhr.status == 200) {//오류없이 OK
            var str = xhr.responseText;//서버에서 보낸 내용 받기
            document.getElementById("message").innerHTML = str;//보여주기
        } else {
            alert("Fail : " + xhr.status);
        }
    }
}

window.onload = function(){
	requestSum('sum.jsp','${goodsVO.price}');
}

-->
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
<form:form commandName="goodsVO" name="detailForm">
<!-- 선택된 goodsId 유지 -->
<input type="hidden" name="selectedId" value="<c:out value='${goodsVO.goodsId}'/>"/>

	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"/> <spring:message code="goods.title" /> </li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	
	
	<br></br>
	<table border='0' width='100%'>
		<colgroup>
						<col width="150" />
						<col width="" />
		</colgroup>
		<tr>
		<td colspan='2'> <c:out value="${goodsVO.categoryVO.ctgryNm}"/></td>
		</tr>
		<tr>
			<td colspan='2' >
				<div id="title" style="border-bottom:0px">
					<ul>
						<li>&nbsp;<c:out value="${goodsVO.goodsNm}"/></li>
					</ul>
				</div>
			</td>
		</tr> 
		<tr>
			<td rowspan='2'><img src="<c:url value='/GoodsImage/${goodsVO.goodsImageVO.goodsImageId}'/>" style="margin-left:6px;margin-right:40px;" height="200" width="200"/>
			</td>
			<td>
				<table width="100%" height="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#D3E2EC" bordercolordark="#FFFFFF" style="BORDER-TOP: #C2D0DB 2px solid; BORDER-LEFT: #ffffff 1px solid; BORDER-RIGHT: #ffffff 1px solid; BORDER-BOTTOM: #C2D0DB 1px solid; border-collapse: collapse;">
					<colgroup>
						<col width="150" />
						<col width="" />
					</colgroup>
					<tr>
						<td class="tbtd_caption"><spring:message code="goods.price"/> </td>
						<td class="tbtd_content">
							<c:out value="${goodsVO.price}"/>원 &nbsp;<form:errors path="price" />
						</td>
					</tr>
					<tr>
						<td class="tbtd_caption"><spring:message code="goods.makr"/></td>
						<td class="tbtd_content">
							<c:out value="${goodsVO.makr}"/> &nbsp;<form:errors path="makr" />
						</td>
					</tr>
					
					<c:if test="${goodsVO.useAt == '1'}">
						<tr>
							<td class="tbtd_caption"><spring:message code="goods.qy"/></td>
							<td class="tbtd_content"><input type="text" name="qy" value="1"	maxlength="3" cssClass="txt" onkeyup="requestSum('sum.jsp','${goodsVO.price}')" 	onchange="requestSum('sum.jsp','${goodsVO.price}')"/></td>
						</tr>
						<tr>
							<td class="tbtd_caption"><spring:message code="goods.sum"/></td>
							<td class="tbtd_content"><div id="message"></div></td>
						</tr>
					</c:if>
				</table>
			</td>
		</tr>
		<tr>
			<td>
			<div id="sysbtn">
				<ul>
				<c:if test="${goodsVO.useAt == '1'}">
					<li><span class="btn_blue_l"><a href="javascript:fn_egov_insertCart();"><spring:message code="goods.btn.insertCart"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
					<li><span class="btn_blue_l"><a href="javascript:fn_egov_insertPurchase();"><spring:message code="goods.btn.buyNow"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				</c:if>
				<c:if test="${goodsVO.useAt == '0'}">
					<li><spring:message code="goods.deleteGoods"/></li>
				</c:if>
					<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();"><spring:message code="goods.btn.list"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				</ul>
			</div>
			</td>
		</tr>
		<tr>
			<td colspan='2'> &nbsp;</td>
		</tr>
		
	</table>
	<table border="0" width="99%" style="margin-left:6px">
		<tr>
			<th style="text-align: left" colspan='2' height="40">&nbsp;&nbsp;&nbsp;<spring:message code="goods.detail"/></th>
		</tr>
		<tr>
			<td colspan='2' class="tbtd_content">
				<img src="<c:url value='/GoodsImage/${goodsVO.detailImageVO.goodsImageId}'/>" width='100%' />
			</td>
		</tr>
	</table>
	
	<c:if test="${loginVO.mngrSe == 'ROLE_ADMIN' && goodsVO.useAt == '1'}">
		<div id="sysbtn" style="margin-top:10px">
			<ul>
				<li><span class="btn_blue_l"><a href="javascript:fn_egov_update();"><spring:message code="goods.btn.update"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
				<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();"><spring:message code="goods.btn.delete"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span></li>
			</ul>
		</div>
	</c:if>
	
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>" />
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>" />
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

