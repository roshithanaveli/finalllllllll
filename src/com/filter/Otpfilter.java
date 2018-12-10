package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.model.User;

/**
 * Servlet Filter implementation class ATSFilter
 */
@WebFilter({ "/Otpfilter", "*.jsp", "*.do" })
public class Otpfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Otpfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpSession ses = hrequest.getSession();
        String obj = (String) ses.getAttribute("xyz");                    
           
        
        String path = hrequest.getRequestURI().substring(hrequest.getContextPath().length()).replaceAll("[/]+$", ""); 
        
        System.out.println("Path: " + path);
        
        if(path.equals("/home.do")) {
        	System.out.println("Carry you home!");
        }        
        System.out.println(obj);
        //||path.equals("/RegisterTraineeafterlogin.jsp")
        //||path.equals("/successfullyregisteredtrainer.jsp")||path.equals("/successfullyregisteredtrainee.jsp")
        if(obj==null && !(path.equals("")||path.equals("/Login.jsp") || path.equals("/register.jsp")|| path.equals("/RegisterTrainer.jsp") || path.equals("/RegisterTrainee.jsp")))
        {
            request.setAttribute("errmsg", "<font color=red>Login to access the features</font>");
            System.err.println("====================================================");
            System.err.println("Unauthorized access recorded: " + new java.util.Date());
            System.err.println("====================================================");
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        }
        
        else
        {
            chain.doFilter(request, response);
        }

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}