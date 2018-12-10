package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

import com.dao.QuestionDAO;
import com.model.Question;

/**
 * Servlet implementation class PrepareQuestion
 */
@WebServlet({ "/PrepareQuestion", "/prepareQues.do" })
public class PrepareQuestion extends HttpServlet {
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
	               
	               File file = new File(dir,"PrepareQuestion.log");
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
    public PrepareQuestion() {
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
		String tech = request.getParameter("technology");
		String subjId = request.getParameter("subject");
		String location = request.getParameter("location");
		String traineeId = request.getParameter("trainee");
		
		List<Question> questions = QuestionDAO.getQuestion(subjId);
		HttpSession session = request.getSession();
		session.setAttribute("subjectid",subjId);
		session.setAttribute("location", location);
		session.setAttribute("tech", tech);
		session.setAttribute("traineeId", traineeId);
		if(questions==null||questions.isEmpty())
		{
			log.warning("No Questions available for the subject");
			request.setAttribute("msg", "<font color='red'>No Questions available for the subject</font>");
			RequestDispatcher rd = request.getRequestDispatcher("AppearExam.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("questions", questions);
			RequestDispatcher rd = request.getRequestDispatcher("QuestionPaper.jsp");
			rd.forward(request, response);
		}
	}

}
