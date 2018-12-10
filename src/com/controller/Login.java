package com.controller;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.*;
import com.model.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static Logger log = Logger.getLogger(Login.class.getName());
	    @Override
	    public void init() throws ServletException 
	{
	          log.setLevel(Level.FINE);
	          log.addHandler(new ConsoleHandler());
	          try {
	               File dir = new File("D:\\Logs");
	               if(!dir.exists())
	               {
	                    dir.mkdir();
	               }
	               
	               File file = new File(dir,"Login.log");
	               Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);
	               log.addHandler(fileHandler);
	       } catch (SecurityException | IOException e1) {
	           System.out.println("Exception on creating log file");
	          e1.printStackTrace();
	    }
	}
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		System.out.println(username+"====");
		UserDAO dao=new UserDAO();
		
		String userid=Searchuser.search(username);
		
		User a= new User(userid,username, password);
		System.out.println("------------uid"+userid);
		if(userid.startsWith("TRE"))
		{
			System.out.println("traineE");
		}
		try
		{
			System.out.println("123344");
			
			//User u=new UserDAO().search(username);
			HttpSession hs=request.getSession();
			System.out.println("login");
		
			hs.setAttribute("xyz",userid);
			
			//UserDAO.check_id(a)
			if(Searchuser.search(username).equalsIgnoreCase(userid))
			{
				System.out.println("search");
				if(userid.startsWith("TRN"))
				{
					System.out.println("trainer");
					RequestDispatcher rd=request.getRequestDispatcher("index1.jsp");
					rd.forward(request, response);
				}
				else if(userid.startsWith("TRE"))
				{
					System.out.println("trainee");
					RequestDispatcher rd=request.getRequestDispatcher("index2.jsp");
					rd.forward(request, response);
				}
				else
				{
					log.warning("invalid credentials");
					request.setAttribute("err", "<font color='red'>invalid credentials</font>");
					RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}
			else
			{
				log.warning("invalid");
				request.setAttribute("err", "<font color='red'>invalid</font>");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
		}catch(Exception ex)
		{
		System.out.println(ex);
		}

	}


}
