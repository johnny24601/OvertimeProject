package uk.co.tpplc.local.timesheet.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.co.tpplc.local.timesheet.service.AuthenticationService;
import uk.co.tpplc.local.timesheet.service.impl.DefaultAuthenticationServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4795009678248298957L;
	AuthenticationService authservice;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
        String pwd = request.getParameter("password");
         
        if(validate(user, pwd)){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30*60);
            session.setAttribute("name",user);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/submitTimesheet.jsp");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/loginError.jsp");
            rd.include(request, response);
        }
	}

	private Boolean validate(String user, String pwd) {
		authservice = new DefaultAuthenticationServiceImpl();
		
		Boolean success = authservice.validateLogin(user, pwd);
		return success;
	}
}
