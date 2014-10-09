package uk.co.tpplc.local.overtime.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest,
			ServletResponse paramServletResponse, FilterChain paramFilterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) paramServletRequest;
	    HttpServletResponse resp = (HttpServletResponse) paramServletResponse;
	    
		resp.setHeader("Cache-Control", "no-cache");
		resp.addHeader("Cache-Control", "no-store");
		resp.addHeader("Cache-Control", "must-revalidate");
		resp.setDateHeader("Expires", 0);
		resp.setHeader("Pragma","no-cache");
		
		paramFilterChain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
