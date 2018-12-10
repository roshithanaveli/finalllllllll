package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import com.model.Trainer;
public class TrainerDAO {
private static Connection con;
private static Statement stmt;
private static ResultSet rs;
static PreparedStatement ps=null;


public static List<Trainer> getTrainer()
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

                List<Trainer>local =new ArrayList<>();
                try{
                                String query ="Select * from trainer";
                                rs=stmt.executeQuery(query);
                                
                                while(rs.next())
                                {
                                	System.out.println(">>>>>>>>>>>>>>>>>Trainer id: "+rs.getString(1));
                                                String userid=rs.getString(1);           
                                                 String trainername=rs.getString(2);      
                                                 String technology=rs.getString(3);       
                                                 String location=rs.getString(4);             
                                                 String contact=rs.getString(5);         
                                                 String email=rs.getString(6);            
                                                
                                local.add(new Trainer(userid, trainername, technology, location, contact, email));
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

public static boolean insertTrainer(Trainer trainer)
{
try{
                                
                                String url ="jdbc:mysql://localhost:3306/otp";
                                Class.forName("com.mysql.jdbc.Driver");
                                con =DriverManager.getConnection(url,"root","root");
                                stmt= con.createStatement();
                                }catch(Exception ex){
                                System.out.println("Open Exception-User");        
                                }
                
                String query ="insert into trainer value(?,?,?,?,?,?)";
                boolean r=false;
                try{
                                ps=con.prepareStatement(query);
                                ps.setString(1,trainer.getUserid());
                                ps.setString(2, trainer.getTrainername());
                                ps.setString(3, trainer.getTechnology());
                                ps.setString(4, trainer.getLocation());
                                ps.setString(5, trainer.getContact());
                                ps.setString(6, trainer.getEmail());
                                
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




