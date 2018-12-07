package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TraineeDAO;
import com.model.Trainer;

/**
 * Servlet implementation class GetTrainers
 */
@WebServlet("/GetTrainers")
public class GetTrainers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTrainers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String technology = request.getParameter("technology");
        System.out.println(">>>>>>>>>>technology111: "+technology);
        List<String> res = TraineeDAO.findTrainer(technology);
        System.out.println(">>>>>>>>>>technology111: "+technology);
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
	}

}
