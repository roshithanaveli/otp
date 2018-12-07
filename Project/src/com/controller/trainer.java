package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.TrainerDAO;
import com.dao.UserDAO;
import com.model.Trainer;
import com.model.User;

/**
 * Servlet implementation class trainer
 */
@WebServlet("/trainer")
public class trainer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public trainer() {
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
		
          
          
		List<Trainer> tlist=TrainerDAO.getTrainer();
          List<User> ulist=UserDAO.getUser();
          List<Integer> idlist=new ArrayList<>();
        
          String trainername=request.getParameter("name");
          String technology=request.getParameter("technology");  
          String location=request.getParameter("location");
          String contact=request.getParameter("cn");
          String email=request.getParameter("email"); 
          String uname=request.getParameter("uname")  ;
          String pass=request.getParameter("pass");
          String cppass=request.getParameter("cpass");
          String userid="TRN-";
        
            int n=1;
            
            if(tlist!=null && tlist.size()>0)
            {
            	for(Trainer x:tlist)
                {
                   idlist.add(Integer.parseInt(x.getUserid().substring(8)));
                   
                 System.out.println(x.getUserid().substring(8));
                }
                            java.util.Collections.sort(idlist);
                            n=idlist.get(idlist.size()-1)+1;
                           
            } System.out.println(n);
            if(technology.equalsIgnoreCase("JAVA"))
            	{
            		userid="TRN-"+"JAV-"+n;
            	}
            else if (technology.equalsIgnoreCase(".NET"))
            	{
            		userid="TRN-"+"NET-"+n;
            	}
            else if(technology.equalsIgnoreCase("SAP"))
            	{
            		userid="TRN-"+"SAP-"+n;
            	}
            else if(technology.equalsIgnoreCase("C"))
            	{
            		userid="TRN-"+"  C-"+n;
            	}
            else if(technology.equalsIgnoreCase("C++"))
            	{
            		userid="TRN-"+"CPP-"+n;
            	}
            System.out.println(userid);
            Trainer e=new Trainer(userid, trainername, technology, location, contact, email);
			User u=new User(userid,uname,pass);
        
          boolean j=UserDAO.insertUser(u,e);
            
            if(!j)
            {
            		HttpSession hs=request.getSession();
            			hs.setMaxInactiveInterval(1);
            			
            			hs.setAttribute("AFTERREG", u);
            			
                    System.out.println("success");
                    
                    RequestDispatcher rd= request.getRequestDispatcher("AfterRegister.jsp");
                    
                    rd.forward(request, response);
            
             }
             else
             {
            	 System.out.println("fail");
            	 
            	 request.setAttribute("err", "<font color='red'>unsuccessful registeration </font>");
            	 RequestDispatcher rd= request.getRequestDispatcher("RegsiterTrainer.jsp");
            	 rd.forward(request, response);
             }
  
            
            
}
}
