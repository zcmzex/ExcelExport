package cn.zhangcm.utils;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseFilter implements Filter {

	
	public void destroy() {

	}

	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		doFilter((HttpServletRequest) req, (HttpServletResponse) resp, chain);
	}

	
	public void init(FilterConfig config) throws ServletException {

	}

	protected abstract void doFilter(HttpServletRequest req,
			HttpServletResponse resp, FilterChain chain) throws IOException,
			ServletException;
}
