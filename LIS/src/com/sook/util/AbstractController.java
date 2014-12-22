package com.sook.util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class AbstractController  extends HttpServlet{
	public String getURI(HttpServletRequest request){
				String uri = request.getRequestURI();
				String contextPath = request.getContextPath();
				uri = uri.substring(contextPath.length());		
				int idx = uri.indexOf(";");
				if ( idx > -1 ) {
					uri = uri.substring(0, idx);
				}
				return uri;
	}
}
