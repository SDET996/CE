package filterPack;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	private FilterConfig filterConfig = null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (filterConfig == null)

			return;

		String isAuthorized = (String) filterConfig.getServletContext().getAttribute("isAuthorized");

		if (isAuthorized != null && isAuthorized.equals("authorized")) {

			chain.doFilter(request, response);
			return;
		} else {

			filterConfig.getServletContext().getRequestDispatcher("/login").forward(request, response);
		}

	}

	@Override
	public void destroy() {
		
		this.filterConfig = null;
	}

}
