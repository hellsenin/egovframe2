package egovframework.gettingstart.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.gettingstart.web.vo.CalendarInfo;

@Controller
public class CommonController {
    /*
    @Resource(name = "CalendarService")
    private CalendarService calendarService;
    */

    @RequestMapping("/footer.do")
    public String footer() {
	return "common/footer"; // JSP or Tiles definition 처리
    }
    
    /**
     * validato rule dynamic Javascript
     */
    @RequestMapping("/validator.do")
    public String validate() {
	return "common/validator"; // JSP or Tiles definition 처리
    }

    @RequestMapping(value = "/common/normalCalendarPopup.do")
    public String callNormalCalPopup(ModelMap model) throws Exception {
	return "common/normalCalPopup"; // JSP or Tiles definition 처리
    }

    /**
     * 일반달력 팝업 정보를 조회한다.
     * 
     * @param restde
     * @param model
     * @return "/common/normalCalendar"
     * @throws Exception
     */
    @RequestMapping(value = "/common/selectNormalCalendar.do")
    public String selectNormalPopup(CalendarInfo calInfo, ModelMap model) throws Exception {
		Calendar cal = Calendar.getInstance();
	
		if (calInfo.getYear() == null || calInfo.getYear().equals("")) {
		    calInfo.setYear(Integer.toString(cal.get(Calendar.YEAR)));
		}
		if (calInfo.getMonth() == null || calInfo.getMonth().equals("")) {
		    calInfo.setMonth(Integer.toString(cal.get(Calendar.MONTH) + 1));
		}
		int iYear = Integer.parseInt(calInfo.getYear());
		int iMonth = Integer.parseInt(calInfo.getMonth());
	
		if (iMonth < 1) {
		    iYear--;
		    iMonth = 12;
		}
		if (iMonth > 12) {
		    iYear++;
		    iMonth = 1;
		}
		if (iYear < 1) {
		    iYear = 1;
		    iMonth = 1;
		}
		if (iYear > 9999) {
		    iYear = 9999;
		    iMonth = 12;
		}
		
		cal.set(iYear, iMonth - 1, 1);
	
		int firstWeek = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int week = cal.get(Calendar.DAY_OF_WEEK);
	
		String year = Integer.toString(iYear);
		String month = Integer.toString(iMonth);
		@SuppressWarnings("unused")
		String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		
		calInfo.setStartWeekMonth(firstWeek);
		calInfo.setLastDayMonth(lastDay);
		calInfo.setYear(year);
		calInfo.setMonth(month);
		
		List<ListOrderedMap> calInfoList = new ArrayList<ListOrderedMap>();
		String tmpDay = "";
		
		/* 계산... START */
		for (int i = 0; i < 42; i++) {
		    ListOrderedMap map = new ListOrderedMap();
		    int cc = i + 1;
		    int dd = cc - firstWeek + 1;
	
		    if (dd > 0 && dd <= lastDay) {
			tmpDay = Integer.toString(dd);
		    } else {
			tmpDay = "";
		    }
	
		    map.put("year", year);
		    map.put("month", month);
		    map.put("day", tmpDay);
		    map.put("cellNum", cc);
		    map.put("weeks", (cc - 1) / 7 + 1);
		    map.put("week", (week - 1) % 7 + 1);
		    map.put("restAt", ((week - 1) % 7 + 1 == 1) ? "Y" : "N");
	
		    if (dd > 0 && dd <= lastDay) {
			week++;
		    }
		    
		    calInfoList.add(map);
		}
		/* 계산... END */
		
		model.addAttribute("resultList", calInfoList);
		
		return "common/normalCalendar"; // JSP or Tiles definition 처리
    }
}