package com.unicorn.korzo.humans;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUser
 */

@WebServlet("/useradd")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
 		String user = "";
		String age  = "";
		String p_name = "";
		//String answer = "";
		
		
		user = request.getParameter("user");
		age  =  request.getParameter("age");
		p_name =  request.getParameter("p_name");
		
//		response.getWriter().write(user+age);
		
		
		try {
			int c = Integer.parseInt(age);
		} catch (Exception e){
			request.setAttribute("answer", "wrong age, must be number");
			request.setAttribute("uid",		"-1");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			
		}
		
		Profession ph = new ProfessionDAOImpl().findByName(p_name);
		
		Human h = new Human(Integer.parseInt(age), user, ph);

		new HumanDAOImpl().add(h);
		
/*
		request.setAttribute("uid",		h.getId());
		request.setAttribute("uname",	h.getName());
		request.setAttribute("uage",	h.getAge());
		*/
		
		
		request.getRequestDispatcher("/userlist?user="+h.getName()).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
