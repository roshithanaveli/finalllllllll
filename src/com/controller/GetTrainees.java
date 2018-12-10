package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TraineeDAO;

/**
 * Servlet implementation class GetTrainees
 */
@WebServlet("/GetTrainees")
public class GetTrainees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger log = Logger.getLogger(GetTrainees.class.getName());
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
	               
	               File file = new File(dir,"GetTrainees.log");
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
    public GetTrainees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String location = request.getParameter("location");
		 System.out.println(location);
	        System.out.println(">>>>>>>>>>location: "+location);
	        List<String> res = TraineeDAO.findTrainerr(location);
	        System.out.println(">>>>>>>>>>location: "+location);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("utf-8");
	        PrintWriter out = response.getWriter();
	        out.println("[");
	        for(int i=0;i<res.size();i++)
	        {
	                        System.out.println(res.get(i));
	                        if(i==res.size()-1)
	                                        out.println(res.get(i));
	                        else
	                                        out.println(res.get(i)+",");
	                        
	        }
	        out.println("]");
	        ServletContext ctx = request.getServletContext();
	        ctx.log("Retrived "+res.size()+" trainers for "+location);
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
