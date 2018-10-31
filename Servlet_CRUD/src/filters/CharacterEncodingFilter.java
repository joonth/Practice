package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
	FilterConfig config;
	public void destroy() {
	
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType(config.getInitParameter("contentType"));
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

}
