package egovframework.rte.tex.com.web;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
public class EgovCommonController {

	@Resource
	LocaleResolver localeResolver;
	
    /**
     * 권한제한 화면 이동
     * @return "cmmn/EgovAccessDenie"
     * @exception Exception
     */
    @RequestMapping("/com/accessDenied.do")
    public String accessDenied() throws Exception {
        return "cmmn/EgovAccessDenied";
    }
    

    /**
     * 국제화 적용
     * @return "main/EgovMain"
     * @exception Exception
     */
	@RequestMapping(value="/com/egovMain.do", method=RequestMethod.GET)
	protected String changeLocale(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Locale locale=new Locale("kr"); //default = kr
		if(request.getParameter("locale") == null){
			locale = localeResolver.resolveLocale(request);
		}
		else{
			locale = new Locale(request.getParameter("locale"));
		}
		// localeResolver에 locale 셋팅
		localeResolver.setLocale(request, response, locale);
		
		return "main/EgovMain";
	}
	
	/**
	 * Ajax + jquery
	 */
	@Resource ResourceBundleMessageSource messageSource;
	@Resource MappingJacksonJsonView ajaxMainView;
	@RequestMapping(value = "/com/ajax.do")
	protected ModelAndView egovMain(String tabName, HttpServletRequest request) throws Exception {

		Locale locale =  localeResolver.resolveLocale(request); //language 
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("divId", "."+tabName);
		model.put("description", messageSource.getMessage(tabName, null, locale));

		return new ModelAndView(ajaxMainView, model);
	}
}
