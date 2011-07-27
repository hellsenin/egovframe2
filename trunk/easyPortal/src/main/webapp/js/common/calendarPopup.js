function fn_NormalCalendar(frm, sDate, vDate) {
	var retVal;

	//var url = frm.cal_url.value;
	var url = "/start/common/normalCalendarPopup.do";	// TODO contextRoot 지정
	
	var varParam = new Object();
	varParam.sDate = sDate.value;		

	// IE
	//var openParam = "dialogWidth:252px;dialogHeight:175px;scroll:no;status:no;center:yes;resizable:yes;";
	// FIREFOX
	var openParam = "dialogWidth:320px;dialogHeight:220px;scroll:no;status:no;center:yes;resizable:yes;";
	
	var isIE  = (navigator.appVersion.indexOf("MSIE") != -1) ? true : false;
	
	if (isIE) {
		openParam = "dialogWidth:252px;dialogHeight:175px;scroll:no;status:no;center:yes;resizable:yes;";
	}
	
	retVal = window.showModalDialog(url, varParam, openParam);

	if(retVal) {
		if(fn_NormalCalendar.arguments.length == 2){
			sDate.value = retVal.vDate;
		}else{
			sDate.value = retVal.sDate; 
			vDate.value = retVal.vDate; 
		}
	}
}
