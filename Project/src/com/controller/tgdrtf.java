package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.dao.TraineeDAO;
import com.model.Answer;
import com.model.Queans;
import com.model.Question;

/**
 * Servlet implementation class setQP
 */
@WebServlet("/tgdrtf")



public class tgdrtf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tgdrtf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Question> qList=null;//QuestionDAO.getQuestion();
		
		
		List<Answer> aList=null;//AnswerDAO.getAnswer();
		
		
		List<Integer> qidList=new ArrayList<>();
		
		List<Integer> aidList=new ArrayList<>();
				
	     String technology=request.getParameter("technology");
	     String location=request.getParameter("location");
	     String trainername=request.getParameter("Trainername");
		String subject=request.getParameter("subject");
		String questiontype = request.getParameter("questiontype");
		String questiondescription = request.getParameter("qd");
		
		String subjectid=Search.searchSubject(subject);
		String trainerid=Search.searchTrainer(trainername);
		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		String a3 = request.getParameter("a3");
		String a4 = request.getParameter("a4");
		
		String ansSet[]=request.getParameterValues("aq");
		System.out.println("============================");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(Arrays.toString(ansSet));
		System.out.println("=============================");
		String questionid="Q-";

		String answerid1="A-";

		String answerid2="A-";

		String answerid3="A-";

		String answerid4="A-";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date d =  new Date();
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());
		//Date date=SimpleDateFormat.parse(d); 
		int n=1;
		if(qList!=null&&qList.size()>0)
		{
			for(Question x:qList)
			{
				qidList.add(Integer.parseInt(x.getQuestionid().substring(8)));
                
                System.out.println(x.getQuestionid().substring(3));
			}
			java.util.Collections.sort(qidList);
            n=qidList.get(qidList.size()-1)+1;
		}
		if(technology.equalsIgnoreCase("Java"))
		{
			questionid="Q-"+"JAV-"+n;
		}
		else if(technology.equalsIgnoreCase(".net"))
		{
			questionid="Q-"+"NET-"+n;
		}
		else if(technology.equalsIgnoreCase("SAP"))
		{
			questionid="Q-"+"SAP-"+n;
		}
		else if(technology.equalsIgnoreCase("C"))
		{
			questionid="Q-"+"  C-"+n;
		}
		else if(technology.equalsIgnoreCase("C++"))
		{
			questionid="Q-"+"CPP-"+n;
		}
		System.out.println(n);
		System.out.println(questionid);
		System.out.println(questiondescription);
		System.out.println(subjectid);
		boolean j=true;
        Question q=new Question(questionid, questiondescription, questiontype, subjectid, sqlDate,trainerid);
       
        QuestionDAO qdao=new QuestionDAO();
        /*qdao.insertQuestion(q);*/
        int ans1=1;
        
        if(aList!=null&&aList.size()>0)
		{
			for(Question x:qList)
			{
				qidList.add(Integer.parseInt(x.getQuestionid().substring(3)));
                
                System.out.println(x.getQuestionid().substring(3));
			}
			java.util.Collections.sort(qidList);
            ans1=qidList.get(qidList.size()-1)+1;
		}
		if(technology.equalsIgnoreCase("Java"))
		{
			answerid1="A-"+"JAV"+ans1;
			answerid2="A-"+"JAV"+(++ans1);
			answerid3="A-"+"JAV"+(++ans1);
			answerid4="A-"+"JAV"+(++ans1);
		}
		else if(technology.equalsIgnoreCase(".net"))
		{
			answerid1="A-"+"NET"+ans1;
			answerid2="A-"+"NET"+(++ans1);
			answerid3="A-"+"NET"+(++ans1);
			answerid4="A-"+"NET"+(++ans1);
		}
		else if(technology.equalsIgnoreCase("SAP"))
		{
			answerid1="A-"+"SAP"+ans1;
			answerid2="A-"+"SAP"+(++ans1);
			answerid3="A-"+"SAP"+(++ans1);
			answerid4="A-"+"SAP"+(++ans1);
		}
		else if(technology.equalsIgnoreCase("C"))
		{
			answerid1="A-"+"  C"+ans1;
			answerid2="A-"+"  C"+(++ans1);
			answerid3="A-"+"  C"+(++ans1);
			answerid4="A-"+"  C"+(++ans1);
		}
		else if(technology.equalsIgnoreCase("C++"))
		{
			answerid1="A-"+"CPP"+ans1;
			answerid2="A-"+"CPP"+(++ans1);
			answerid3="A-"+"CPP"+(++ans1);
			answerid4="A-"+"CPP"+(++ans1);
		}
		System.out.println(ans1);
		System.out.println(answerid1);
		System.out.println(answerid2);
		System.out.println(answerid3);
		System.out.println(answerid4);
		
		
		AnswerDAO ad=new AnswerDAO();
		
		Answer answer=new Answer(answerid1, a1, questionid);
		/*ad.insertAnswer(answer);*/
		answer=new Answer(answerid2, a2, questionid);
		//ad.insertAnswer(answer);
		answer=new Answer(answerid3, a3, questionid);
		//ad.insertAnswer(answer);
		answer=new Answer(answerid4, a4, questionid);
		//ad.insertAnswer(answer);
		
      
        
      /*Iterator iterator = ansSet.iterator();
      while(iterator.hasNext(){
        String element = (String) iterator.next();
      }
      */
      
      Queans queans=new Queans();
      QueansDAO queansdao=new QueansDAO();
      if(questiontype.equalsIgnoreCase("single choice"))
      {
    	 
    	  if(ansSet[0].equalsIgnoreCase("ans1"))
    	  {
    		  queans=new Queans(answerid1, a1);
    		
    	  }
    	  else if(ansSet[0].equalsIgnoreCase("ans2"))
    	  {
    		  queans=new Queans(answerid2, a2);
    		
    	  }
    	  else if(ansSet[0].equalsIgnoreCase("ans3"))
    	  {
    		  queans=new Queans(answerid3, a3);
    		
    	  }
    	  else if(ansSet[0].equalsIgnoreCase("ans4"))
    	  {
    		  queans=new Queans( answerid4, a4);
    		
    	  }
    	  /* j=QuestionDAO.insertQuestion(q);*/
    	   j=false;//SetQPDAO.insertSubject(q,answer,queans);
    	  
      }
      else if(questiontype.equalsIgnoreCase("multiple choice"))
      {
    	  
      }
      
        if(!j)
        {
        		HttpSession hs=request.getSession();
        		hs.setMaxInactiveInterval(1);        			
        		hs.setAttribute("AFTERREG", q);        			
                System.out.println("success");                
                RequestDispatcher rd= request.getRequestDispatcher("AfterRegister.jsp");                
                rd.forward(request, response);
        
         }
         else
         {
        	 System.out.println("fail");        	 
        	 request.setAttribute("err", "<font color='red'>unsuccessful registertation </font>");
        	 RequestDispatcher rd= request.getRequestDispatcher("setQP.jsp");
        	 rd.forward(request, response);
         }
		
		System.out.println(questiontype); 
		System.out.println(questiondescription);
		
	}

}
