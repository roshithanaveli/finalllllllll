package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExamDAO;
import com.dao.QueansDAO;
import com.model.Exam;
import com.model.Queans;
import com.model.Question;

import java.util.logging.*;
/**
 * Servlet implementation class Evaluate
 */
@WebServlet("/eval")
public class Evaluate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(Evaluate.class.getName());
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
               
               File file = new File(dir,"Evaluate.log");
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
    public Evaluate() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		/*String type=request.getParameter("comp");
		System.out.println("type"+type);*/
		/*Enumeration<String> params = request.getParameterNames();
		
		        if(params.hasMoreElements())
		        {
		           String p = params.nextElement();
		           String fNo[] = request.getParameterValues(p);
		           for(String x:fNo)
		           { 
		        	   System.out.println(p + " post : " + x);
		   		   }
		         session.setAttribute("subjectid",subjId);
		session.setAttribute("location", location);
		session.setAttribute("tech", tech);
		session.setAttribute("traineeId", traineeId);
		       }*/
		HttpSession ses=request.getSession();
		Date d =  new Date();
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());
		
		String traineeid=(String)ses.getAttribute("traineeId");
		String subjectid=(String)ses.getAttribute("subjectid");
		
			List<Question> qlist=(List<Question>) ses.getAttribute("qus");
		     List<Queans> ca=QueansDAO.getQueans();
			List<String>alist=new ArrayList<>();
			List<String>clist=new ArrayList<>();
			int c=0;
			for(Question x:qlist)
			{
				//System.out.println(x.getQuestionid());
				//alist=null;
				
				for(Queans y:ca)
				{
					if((y.getQuestionid()).equals(x.getQuestionid()))
					{
						clist.add(y.getAnswerid());
					}
				}
				for(String xy:clist)
				{
					System.out.println("correct answers :"+xy);
				}
				
			
				String ans[]=request.getParameterValues(x.getQuestionid());
				for(String a:ans)
				{
					alist.add(a);
				}
				for(String xz:alist)
				{
					System.out.println("giv answers :"+xz);
				}
				
				Collections.sort(clist);
				Collections.sort(alist);
				if(alist.equals(clist))
				{
					c++;
				}
				alist.removeAll(alist);
				clist.removeAll(clist);
				System.out.println("++?+==?+++");
			}
			
			System.out.println(c);
			int result=c*4;
			HttpSession session = request.getSession();
			session.setAttribute("result",result);
			Exam exam=new Exam(subjectid,sqlDate, result, traineeid);
			ExamDAO.insertExam(exam);
	        String obj = (String) session.getAttribute("xyz");        
			if(obj.startsWith("TRE"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
				rd.forward(request, response);
			}
			else if(obj.startsWith("TRN"))
			{
				RequestDispatcher rd = request.getRequestDispatcher("resulttrainer.jsp");
				rd.forward(request, response);
			}
			
			

}
}
