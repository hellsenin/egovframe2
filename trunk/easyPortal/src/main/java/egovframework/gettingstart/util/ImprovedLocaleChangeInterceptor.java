package egovframework.gettingstart.util;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * for static jsp call (from Spring 3.0.5)
 * @author Han
 */
public class ImprovedLocaleChangeInterceptor extends LocaleChangeInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		String newLocale = request.getParameter(this.getParamName());
		if (newLocale != null) {
			LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
			if (localeResolver == null) {
				throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
			}
			LocaleEditor localeEditor = new LocaleEditor();
			localeEditor.setAsText(newLocale);
			localeResolver.setLocale(request, response, (Locale) localeEditor.getValue());
			//request.setAttribute(DispatcherServlet.LOCALE_RESOLVER_ATTRIBUTE, localeResolver);
			Config.set(request.getSession(),Config.FMT_LOCALE, (Locale) localeEditor.getValue());
		}
		
		return true;
	}
}