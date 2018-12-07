package com.controller;

import java.io.IOException;
import java.util.List;

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
