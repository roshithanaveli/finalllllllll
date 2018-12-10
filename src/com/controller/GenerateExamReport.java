package com.controller;

import java.io.File;
import java.io.IOException;
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

import com.dao.Searchuser;

/**
 * Servlet implementation class GenerateExamReport
 */
@WebServlet("/GenerateExamReport")
public class GenerateExamReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static Logger log = Logger.getLogger(GenerateExamReport.class.getName());
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
	               
	               File file = new File(dir,"Generate.log");
	               Handler fileHandler = new FileHandler(file.getAbsolutePath(), 2000, 5);
	               log.addHandler(fileHandler);
	       } catch (SecurityException | IOException e1) {
	           System.out.println("Exception on creating log file");
	          e1.printStackTrace();
	    }
}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateExamReport() {
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
		
		if(true)
		{
			System.out.println("success");
			
			RequestDispatcher rd=request.getRequestDispatcher("GenerateExamReportlast.jsp");
		}
		else
		{
			log.warning("invalid to generate report");
			request.setAttribute("err", "<font color='red'>invalid to generate report</font>");
			RequestDispatcher rd=request.getRequestDispatcher("Generatejsp.jsp");
			rd.forward(request, response);
		}
	}

}
