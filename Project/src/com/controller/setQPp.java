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
@WebServlet("/setQPp")



public class setQPp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setQPp() {
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
		
		String technology=request.getParameter("technology");
	     String location=request.getParameter("location");
	     String trainername=request.getParameter("Trainername");
		String subject=request.getParameter("subject");
		String questiontype = request.getParameter("questiontype");
		String questiondescription = request.getParameter("qd");
		String subjectid=Search.searchSubject(subject);
		String trainerid=Search.searchTrainer(trainername);
		if(questiontype.equalsIgnoreCase("Single Choice"))
		{
			String answerarray[]=request.getParameterValues("qt");
			System.out.println(answerarray.toString());
			System.out.println("dsffsdf");
			
		}
		else if(questiontype.equalsIgnoreCase("Multiple Choice"))
		{
			String answerarray[]=request.getParameterValues("qt");
			System.out.println(answerarray.toString());
			System.out.println("multiplecohice");
		}
		
	}
}

