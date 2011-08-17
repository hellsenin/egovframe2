package egovframework.rte.tex.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.AccessDeniedException;
import org.springframework.security.ui.AccessDeniedHandlerImpl;

public class EgovAccessDeniedHandlerImpl extends AccessDeniedHandlerImpl {
	private String errorPage;

	public void handle(ServletRequest request, ServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		
		System.out.println("========================>");
		
		if (errorPage != null) {
			// Put exception into request scope (perhaps of use to a view)
			((HttpServletRequest) request).setAttribute(
					SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY,
					accessDeniedException);

			// Perform RequestDispatcher "forward"
			//RequestDispatcher rd = request.getRequestDispatcher(errorPage);
			//rd.forward(request, response);
			
			((HttpServletResponse)response).sendRedirect(errorPage);

		}

		if (!response.isCommitted()) {
			// Send 403 (we do this after response has been written)
			((HttpServletResponse) response).sendError(
					HttpServletResponse.SC_FORBIDDEN,
					accessDeniedException.getMessage());
		}
	}

	public void setErrorPage(String errorPage) {
		if ((errorPage != null) && !errorPage.startsWith("/")) {
			throw new IllegalArgumentException("errorPage must begin with '/'");
		}

		this.errorPage = errorPage;
	}

}
