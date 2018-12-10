package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import com.model.Answer;
import com.model.Queans;
import com.model.Question;
import com.model.Subject;


public class SetQPDAO {
private static Connection con;
private static Statement stmt;
private static ResultSet rs;
static PreparedStatement ps=null;


public static List<Subject> getSubject()
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

                List<Subject>local =new ArrayList<>();
                try{
                                String query ="Select * from subject";
                                rs=stmt.executeQuery(query);
                                
                                while(rs.next())
                                {
                                	//System.out.println(">>>>>>>>>>>>>>>>>Trainer id: "+rs.getString(1));
                                                String subjectid=rs.getString(1);           
                                                 String subjectname=rs.getString(2);      
                                                             
                                                
                                local.add(new Subject(subjectid, subjectname));
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

public static boolean insertAll(Question q)
{
try{
                                
                                String url ="jdbc:mysql://localhost:3306/otp";
                                Class.forName("com.mysql.jdbc.Driver");
                                con =DriverManager.getConnection(url,"root","root");
                                stmt= con.createStatement();
                                }catch(Exception ex){
                                System.out.println("Open Exception-User");        
                                }
                
              /*  String query ="insert into subject value(?,?)";*/
                boolean r=true;
             /*   try{
                                ps=con.prepareStatement(query);
                                ps.setString(1,subject.getSubjectid());
                                ps.setString(2, subject.getSubjectname());
                                
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
                }*/
                r=QuestionDAO.insertQuestion(q);
               // r=QuestionDAO(a,qu);
                return r;
}
}



