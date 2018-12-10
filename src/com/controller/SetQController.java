package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AnswerDAO;
import com.dao.QueansDAO;
import com.dao.QuestionDAO;
import com.dao.Search;
import com.dao.SetQPDAO;
import com.model.Answer;
import com.model.Queans;
import com.model.Question;

/**
 * Servlet implementation class page
 */
@WebServlet("/SetQ")
public class SetQController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Logger log = Logger.getLogger(SetQController.class.getName());
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
	               
	               File file = new File(dir,"SetQController.log");
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
    public SetQController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String technology = request.getParameter("technology");
        List<String> res = QuestionDAO.findTrainer(technology);
        System.out.println(">>>>>>>>>>technology: "+technology);
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
        ctx.log("Retrived "+res.size()+" trainers for "+technology);
	}
	
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			// TODO Auto-generated method stub
			//questionscreatinglist
			
			List<Answer> answerList=new ArrayList<>();
			List<Queans> queansList=new ArrayList<>();
			
			//getting parameters from jsp
			// TODO Auto-generated method stub
			String technology=request.getParameter("technology");	//for unique q id
		    String location=request.getParameter("location");		//to fetch trainer
		    String trainerid=request.getParameter("Trainername");	//trainer id
		    String subjectid=request.getParameter("subject");			//
			String questiontype = request.getParameter("qtype");	//1 or 2
			String questiondescription = request.getParameter("aq");	//question
			String questionid="Q-"+technology+"-"+QuestionDAO.getQId(technology);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date d =  new Date();
			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			
			int noOfOpts = Integer.parseInt(request.getParameter("anscnt"));
			String ansopts[]= new String[noOfOpts];
		
			
			for(int i=1;i<=noOfOpts;i++)
			{
				ansopts[i-1] = request.getParameter("anstxt"+i);
			}
			for(int i=0;i<noOfOpts;i++)
			{
				System.out.println(ansopts[i]);
			}
			
			String answer[]=new String[1];
			if(questiontype.equalsIgnoreCase("Single Choice"))
			{
				answer = new String[1];
				answer[0]=request.getParameter("anschk");
				
				
			}
			else if(questiontype.equalsIgnoreCase("Multiple Choice"))
			{
				answer=request.getParameterValues("anschk");
				
			}
			
			System.out.println("Question Id in SetQ Contr: "+questionid);
			System.out.println(trainerid);
			System.out.println(subjectid);
			System.out.println("No of Opts given: "+noOfOpts);
			System.out.println("No of ans selected: "+answer.length);
			System.out.println("Answers are: ");
			for(String x:answer)
			{
				System.out.println(x);
				
			}
			System.out.println("=====================");
			//uniqueanserid
			String answerid[]=new String[noOfOpts];
			//question created
			Question qO=new Question(questionid, questiondescription, questiontype, subjectid, sqlDate, trainerid);
			//question&answer&queans
			boolean j=SetQPDAO.insertAll(qO);
			boolean k=true,l=true;
			for(int c=1;c<=noOfOpts;c++)
			{
				answerid[c-1]=questionid+"-A-"+c;
				Answer answero=new Answer(answerid[c-1], ansopts[c-1], questionid);
				answerList.add(answero);
			}
			// options numbeers selected 
			int optno[]=new int[answer.length];
			List<String> correctanswer=new ArrayList<>();
			for(int length=0;length<answer.length;length++)
			{
				//Queans queans=new Queans(answerid[], questionid);
				//queansList.add(queans);
				optno[length]=Integer.parseInt(answer[length].substring(3));
				
				System.out.println("numbers"+optno[length]);
			}
			for(int length=0;length<answer.length;length++)
			{
				System.out.println("correct answers:\n"+answerid[optno[length]-1]);
				correctanswer.add(answerid[optno[length]-1]);
				
			}
			for(String each:correctanswer)
			{
				Queans queans=new Queans(each, questionid);
				queansList.add(queans);
			}
			
			for(Answer b:answerList)
			{
				k=AnswerDAO.insertAnswer(b);
			}
			for(Queans c:queansList)
			{
				l=QueansDAO.insertQueans(c);
				
			}
			for(Answer a:answerList) 
			{
				System.out.println("ANswer description:"+a.getAnswerdescription()+"\n answerid\n  "+a.getAnswerid()+"\n question id"+a.getQuestionid());
			}
			if(!j&&!k&&!l)
		    {
		        		HttpSession hs=request.getSession();
		        		       			
		        		hs.setAttribute("AFTERREG", qO);        			
		                System.out.println("success");                
		                RequestDispatcher rd= request.getRequestDispatcher("successadd.jsp");                
		                rd.forward(request, response);
		    }
		         else
		         {
		        	 System.out.println("fail");  
		        	 log.warning("unsuccessful registration");
		        	 request.setAttribute("err", "<font color='red'>unsuccessful registertation </font>");
		        	 RequestDispatcher rd= request.getRequestDispatcher("setQP.jsp");
		        	 rd.forward(request, response);
		         }
				
				System.out.println(questiontype); 
				System.out.println(questiondescription);
			
		}
	}


