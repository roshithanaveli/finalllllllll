package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import com.model.Answer;
import com.model.Queans;
import com.model.Question;
public class QuestionDAO {
private static Connection con;
private static Statement stmt;
private static ResultSet rs;
static PreparedStatement ps=null;


	public static int getQId(String tech)
	{
		int qId = 1;
		try{
			
			String url ="jdbc:mysql://localhost:3306/otp";
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection(url,"root","root");
			ps = con.prepareStatement("Select questionid from question where questionid like ? order by 1 desc");
			ps.setString(1, "%-"+tech+"-%");
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				String qStr = rs.getString(1);
				System.out.println("----------> "+qStr);
				String lastNo = qStr.substring(qStr.lastIndexOf("-")+1).trim();
				qId = Integer.parseInt(lastNo)+1;
			}
		}
		catch(Exception ex){
			System.out.println("Open Exception-Question : "+ex);	
		}
		finally
		{

			try{
				con.close();
			}catch(Exception ex)
			{
				System.out.println("Closing Exception-Question");
			}
		}
		return qId;
	}

public static List<Question> getQuestion(String subjId)
{
	List<Question> local = new ArrayList<>();
	try{
		
		String url ="jdbc:mysql://localhost:3306/otp";
		Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection(url,"root","root");
		ps = con.prepareStatement("Select * from question where subjectid=?");
		ps.setString(1, subjId);
		rs = ps.executeQuery();
		while(rs.next())
		{
			 String questionid=rs.getString(1);           
			 String questiondescription=rs.getString(2);      
			 String questiontype=rs.getString(3);       
			 String subjectid=rs.getString(4);         
			 java.sql.Date date=rs.getDate(5);              
			 String trainerid=rs.getString(6);
			 List<Answer> ansList = AnswerDAO.getAnswer(questionid);
			 if(ansList==null||ansList.isEmpty())
			 {
				 ansList=new ArrayList<>();
			 }
			 
			 local.add(new Question(questionid, questiondescription, questiontype, subjectid, date, trainerid,ansList));
		}
	}catch(Exception ex){
		System.out.println(ex);
	}
	finally
	{

		try{
			con.close();
		}catch(Exception ex)
		{
			System.out.println("Closing Exception-Question");
		}
	}
	return local;
}
//List<Answer> answer,List<Queans> queans
public static boolean insertQuestion(Question q)
{
try{
		
		String url ="jdbc:mysql://localhost:3306/otp";
		Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection(url,"root","root");
		stmt= con.createStatement();
		}catch(Exception ex){
		System.out.println("Open Exception-Question");	
		}
	
	String query ="insert into question value(?,?,?,?,?,?)";
	boolean r=true;
	try{
		ps=con.prepareStatement(query);
		ps.setString(1,q.getQuestionid());
		ps.setString(2, q.getQuestiondescription());
		ps.setString(3, q.getQuestiontype());
		ps.setString(4, q.getSubjectid());
		ps.setDate(5,q.getDate());
		ps.setString(6, q.getTrainerid());
		
		
		r=ps.execute();
		
	}catch(Exception ex)
	{
		System.out.println("fedfedfrwef"+ex);
	}
	finally
	{

		try{
			con.close();
		}catch(Exception ex)
		{
			System.out.println("Closing Exception-Question");
		}//AnswerDAO.insertAnswer(answer,queans);
	}
	
	/*QueansDAO.insertQueans(queans);*/
	return r;
}
public static List<String> findTrainer(String technology) {
	// TODO Auto-generated method stub
	
	  List<String> trainers = new ArrayList<>();
      Connection con=null;
      PreparedStatement ps = null;
      ResultSet rs = null;
      String url = "jdbc:mysql://localhost:3306/otp";
      String user="root";
      String pass="root";
      String query = "Select userid,trainername from trainer where technology=?";
      
      try
      {
                      Class.forName("com.mysql.jdbc.Driver");
                      con = DriverManager.getConnection(url,user,pass);
                      ps = con.prepareStatement(query);
                      ps.setString(1,technology);
                      
                      rs = ps.executeQuery();
                      while(rs.next())
                      {
                    	  String val = "{\"trainerid\":\""+rs.getString(1)+"\",";
                          val+="\"trainername\":\""+rs.getString(2)+"\"}";
                                       
                    	  trainers.add(val);
                      }
                      
      }
      catch(Exception ex)
      {
                      System.out.println("Exception at TrainerDAO find user method:in1 "+ex);
      }
      finally
      {
        try
        {
	        if(con!=null)
	        {
	            con.close();
	        }
        }
        catch(Exception ex2)
        {
           System.out.println("Exception while closing conn at find user: in2"+ex2);
        }
      }
      return trainers;
	
}
}
