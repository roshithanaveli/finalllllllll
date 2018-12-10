package com.dao;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import com.model.Exam;
import com.model.Trainer;
public class ExamDAO {

	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	static PreparedStatement ps=null;


	public static List<Exam> getExam()
	{
	                try{
	                                
	                                String url ="jdbc:mysql://localhost:3306/otp";
	                                Class.forName("com.mysql.jdbc.Driver");
	                                con =DriverManager.getConnection(url,"root","root");
	                                stmt= con.createStatement();
	                                }
	                                catch(Exception ex){
	                                System.out.println("Open Exception-User");        
	                                }

	                List<Exam>local =new ArrayList<>();
	                try{
	                                String query ="Select * from exam";
	                                rs=stmt.executeQuery(query);
	                                
	                                while(rs.next())
	                                {
	                                	
	                                                 String subjectid=rs.getString(1);      
	                                                 java.sql.Date date=rs.getDate(2);       
	                                                 Integer score=rs.getInt(3);             
	                                                 String traineeid=rs.getString(4);         
	                                                
	                                local.add(new Exam(subjectid, date, score, traineeid));
	                                }
	                }catch(Exception ex){
	                                System.out.println(ex);
	                }
	                finally
	                {

	                                try
	                                {
	                                     con.close();
	                                }
	                                catch(Exception ex)
	                                {
	                                   System.out.println("Closing Exception-User");
	                                }
	                }
	                return local;
	}

	public static boolean insertExam(Exam exam)
	{
	try{
	                                
	                                String url ="jdbc:mysql://localhost:3306/otp";
	                                Class.forName("com.mysql.jdbc.Driver");
	                                con =DriverManager.getConnection(url,"root","root");
	                                stmt= con.createStatement();
	                                }catch(Exception ex){
	                                System.out.println("Open Exception-User");        
	                                }
	                
	                String query ="insert into exam value(?,?,?,?)";
	                boolean r=false;
	                try{
	                                ps=con.prepareStatement(query);
	                                ps.setString(1,exam.getSubjectid());
	                                ps.setDate(2, exam.getDate());
	                                ps.setInt(3, exam.getScore());
	                                ps.setString(4, exam.getTraineeid());
	                                
	                               r= ps.execute();
	                                
	                }catch(Exception ex)
	                {
	                                System.out.println(ex);
	                }
	                finally
	                {

	                                try
	                                {
	                                     con.close();
	                                }
	                                catch(Exception ex)
	                                {
	                                                System.out.println("Closing Exception-User");
	                                }
	                }
	                return r;
	}
}




