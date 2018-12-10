package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import com.dao.TraineeDAO;
import com.dao.TrainerDAO;
import com.dao.UserDAO;
import com.model.Trainee;
import com.model.Trainer;
import com.model.User;

/**
 * Servlet implementation class trainee
 */
@WebServlet("/trainee")
public class RegisterTrainee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static Logger log = Logger.getLogger(RegisterTrainee.class.getName());
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
	               
	               File file = new File(dir,"RegisterTrainee.log");
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
    public RegisterTrainee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String technology = request.getParameter("technology");
	        List<String> res = TraineeDAO.findTrainer(technology);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Trainee> tlist=TraineeDAO.getTrainee();
        List<User> ulist=UserDAO.getUser();
        List<Integer> idlist=new ArrayList<>();
      
        String traineename=request.getParameter("name");
        String technology=request.getParameter("technology");  
        String location=request.getParameter("location");
        String trainername=request.getParameter("Trainername");
        String contact=request.getParameter("cn"); 
        String domain=request.getParameter("domain"); 
        String education=request.getParameter("edu"); 
        Integer passoutyear=Integer.parseInt(request.getParameter("poy")); 
        String uname=request.getParameter("uname")  ;
        String pass=request.getParameter("pass");
        String cppass=request.getParameter("cpass");
        String userid="TRE-";
      
          int n=1;
          
          if(tlist!=null && tlist.size()>0)
          {
          	for(Trainee x:tlist)
              {
                 idlist.add(Integer.parseInt(x.getUserid().substring(8)));
                 
               System.out.println(x.getUserid().substring(8));
              }
                          java.util.Collections.sort(idlist);
                          n=idlist.get(idlist.size()-1)+1;
                         
          } 
          System.out.println(n);
          System.out.println(userid);
          if(technology.equalsIgnoreCase("JAVA"))
          	{
          		userid="TRE-"+"JAV-"+n;
          	}
          else if (technology.equalsIgnoreCase(".NET"))
          	{
          		userid="TRE-"+"NET-"+n;
          	}
          else if(technology.equalsIgnoreCase("SAP"))
          	{
          		userid="TRE-"+"SAP-"+n;
          	}
          else if(technology.equalsIgnoreCase("C"))
          	{
          		userid="TRE-"+"  C-"+n;
          	}
          else if(technology.equalsIgnoreCase("C++"))
          	{
          		userid="TRE-"+"CPP-"+n;
          	}
          System.out.println(userid);
          Trainee e=new Trainee(userid, traineename, technology, location, trainername, contact, domain, education, passoutyear);
			User u=new User(userid,uname,pass);
      
			
			
        boolean j=UserDAO.insertUser(u,e);
          
          if(!j)
          {
          		HttpSession hs=request.getSession();
          			hs.setAttribute("AFTERREGE", u);
          			hs.setAttribute("username", u.getUsername());
          			hs.setAttribute("password", u.getPassword());
          			
                  System.out.println("success");
                  
                  RequestDispatcher rd= request.getRequestDispatcher("successfullyregistered.jsp");
                  
                  rd.forward(request, response);
          
           }
           else
           {
          	 System.out.println("fail");
          	 log.warning("unsuccessful registeration");
          	 request.setAttribute("err", "<font color='red'>unsuccessful registeration</font>");
          	 RequestDispatcher rd= request.getRequestDispatcher("RegisterTrainee.jsp");
          	 rd.forward(request, response);
           }

          
          
	}

}
