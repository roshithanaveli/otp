package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Searchuser;

/**
 * Servlet implementation class GenerateExamReport
 */
@WebServlet("/GenerateExamReport")
public class GenerateExamReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateExamReport() {
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
		
		if(true)
		{
			System.out.println("success");
			
			RequestDispatcher rd=request.getRequestDispatcher("GenerateExamReportlast.jsp");
		}
		else
		{
			request.setAttribute("err", "<font color='red'>invalid</font>");
			RequestDispatcher rd=request.getRequestDispatcher("Generatejsp.jsp");
			rd.forward(request, response);
		}
	}

}
