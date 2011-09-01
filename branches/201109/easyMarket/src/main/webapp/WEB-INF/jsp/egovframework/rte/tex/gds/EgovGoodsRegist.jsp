<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : EgovGoodsRegist.jsp
 * @Description : 상품등록 및 수정 화면
 * @author 이영진
 * @since 2011.06.16
 * @version 1.0
 */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<c:set var="registerFlag" value="${empty goodsVO.goodsId ? '등록' : '수정' }"/>
<title><spring:message code="goods.goods"/> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/egov.css'/>"/>

<!--For Commons Validator Client Side-->
<script type="text/javascript" src="<c:url value='/com/validator.do'/>"></script>
<validator:javascript formName="goodsVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 상품 목록 화면 function */
function fn_egov_cancel(id) {
	if(!confirm("<spring:message code="msg.del" />")) {
		return;
	}
	if(id == ''){ //등록폼이라 id값이 없음
	   	document.insertForm.action = "<c:url value='/gds/selectListGoods.do'/>";
	   	document.insertForm.submit();	
	} else { //수정폼일때
		document.insertForm.selectedId.value = id;
	   	document.insertForm.action = "<c:url value='/gds/getGoodsView.do'/>";
	   	document.insertForm.submit();		
	}
}
	


/* 상품 등록 및 수정 function */
function fn_egov_save() {	

	frm = document.insertForm;
	
	inputImage = document.insertForm.image.value;
	inputDetailImage = document.insertForm.detailImage.value;
	
	registerFlag = "<c:out value="${registerFlag}"/>";
	
	if(registerFlag == '등록'){
		if(!confirm("<spring:message code="msg.insert" />")) {
			return;
		}
		if(inputImage == ''){
			alert("<spring:message code="info.noimage.msg"/>");
			return;
			}
		if(inputDetailImage == ''){
			alert("<spring:message code="info.nodetailimage.msg"/>");
			return;
			}
	}else{
		if(!confirm("<spring:message code="msg.update" />")) {
			return;
		}
	}
	if(!validateGoodsVO(frm)){
		
        return;
    }else{
    	frm.action = "<c:url value="${registerFlag == '등록' ? '/gds/insertGoods.do' : '/gds/updateGoods.do'}"/>";
        frm.submit();
    }
}
function fn_egov_categoryPopup() {	
	window.open('../springrest/cgr.html?name=popup','open','width=700,height=600,top=10,left=10,scrollbars=no');
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
<form:form commandName="goodsVO" name="insertForm" method="post"
	enctype="multipart/form-data">

<input type="hidden" name="selectedId" />
<form:hidden path="categoryVO.ctgryId" id="ctgryId"/>
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images/egovframework/rte/title_dot.gif'/>"/> <spring:message code="goods.goods"/><c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#D3E2EC" bordercolordark="#FFFFFF" style="BORDER-TOP:#C2D0DB 2px solid; BORDER-LEFT:#ffffff 1px solid; BORDER-RIGHT:#ffffff 1px solid; BORDER-BOTTOM:#C2D0DB 1px solid; border-collapse: collapse;">
		<colgroup>
			<col width="150" />
			<col width="" />
		</colgroup>
		<tr>
			<td class="tbtd_caption"><spring:message code="goods.goodsNm"/> </td>
			<td class="tbtd_content">
				<form:input path="goodsNm" maxlength="30" cssClass="txt"/>
				&nbsp;<form:errors path="goodsNm" />
			</td>
		</tr>
			<tr>
			<td class="tbtd_caption"><spring:message code="goods.ctgryNm"/></td>
			<td class="tbtd_content">
				<form:input path="categoryVO.ctgryNm" id="ctgryNm" maxlength="30" cssClass="essentiality" readonly="true"/>
				&nbsp;<form:errors path="categoryVO.ctgryNm" />
				<span class="btn_blue"><a href="javascript:fn_egov_categoryPopup();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;" /></span>
			</td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="goods.goodsImage"/></td>
			<td class="tbtd_content">
				<c:if test="${goodsVO.goodsImageVO.fileNm != null}">
					<c:out value='${goodsVO.goodsImageVO.fileNm}'/><br>
				</c:if>	
				<input type="file" name="image" size="60"/>
			</td>
		</tr>
			<tr>
			<td class="tbtd_caption"><spring:message code="goods.detailInfoImage"/></td>
			<td class="tbtd_content">
				<c:if test="${goodsVO.detailImageVO.fileNm != null}">
					<c:out value='${goodsVO.detailImageVO.fileNm}'/><br>
				</c:if>	
				<input type="file" name="detailImage" size="60" /> 
			</td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="goods.price"/></td>
			<td class="tbtd_content">
				<form:input path="price" maxlength="10" cssClass="txt"  />
				&nbsp;<form:errors path="price" /><spring:message code="cart.won" /></td>
		</tr>
		<tr>
			<td class="tbtd_caption"><spring:message code="goods.makr"/></td>
			<td class="tbtd_content">
				<form:input path="makr" maxlength="10" cssClass="txt"  />
				&nbsp;<form:errors path="makr" /></td>
		</tr>
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_cancel('<c:out value="${goodsVO.goodsId}"/>')"><spring:message code="goods.btn.cancle"/></a><img src="<c:url value='/images/egovframework/rte/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
		</ul>
	</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
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

