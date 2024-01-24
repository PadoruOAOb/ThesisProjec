package com.example.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.entiry.User;

@WebFilter(value = {"/*"})
public class LoginFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String urlString = request.getRequestURL().toString();
		
		// 哪些路徑，不需要先登入，就可以顯示頁面
		if(        urlString.endsWith("login.jsp") 
				|| urlString.endsWith("login") 
				|| urlString.endsWith("register.jsp") 
				|| urlString.endsWith("register") 
				|| urlString.endsWith(".mp4") 
				|| urlString.endsWith("ThesisProjec/") 
				|| urlString.endsWith("index.jsp") 
				|| urlString.indexOf("/images")>=0 
				|| urlString.endsWith(".css")
				|| urlString.endsWith(".png")
				|| urlString.endsWith(".js") ) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null) {
			User user = (User)session.getAttribute("user");
			System.out.println("RequestURI = " + request.getRequestURI());
			if(request.getRequestURI().contains("/index")) {
				if(user.getLevel() == 1) {
					chain.doFilter(request, response);
				} else {
					response.sendRedirect(request.getServletContext().getContextPath() + "/mvc/user/login");
				}
			} 
			chain.doFilter(request, response);
			return;
		}
		// 未登入, 導入到登入頁面
		response.sendRedirect(request.getServletContext().getContextPath() + "/mvc/user/login");
	}

	
}
