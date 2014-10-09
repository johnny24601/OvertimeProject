package uk.co.tpplc.local.overtime.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.co.tpplc.local.overtime.service.AuthenticationService;
import uk.co.tpplc.local.overtime.service.impl.DefaultAuthenticationServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4795009678248298957L;
	private static final Logger log = Logger.getLogger( LoginController.class.getName() );
	
	private static final String LOGIN_USERNAME = "username";
	private static final String LOGIN_PASSWORD = "password";
	private static final String NAME = "name";
	private static final String LOGGED_IN_USER = "loggedInUser";
	private static final String OVERTIME_ENTRIES = "overtimeEntries";
	private static final String SUCCESSFUL_LOGIN_URL = "/jsp/submitOvertime.jsp";
	private static final String LOGIN_ERROR_URL = "/jsp/loginError.jsp";
	
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
		String user = request.getParameter(LOGIN_USERNAME);
        String pwd = request.getParameter(LOGIN_PASSWORD);
        
        authservice = new DefaultAuthenticationServiceImpl();
        
        if(validate(user, pwd)){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(30*60);
            session.setAttribute(NAME,user);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(SUCCESSFUL_LOGIN_URL);
            request.getSession().setAttribute(LOGGED_IN_USER, user);
            ArrayList<String> overtimeEntryType = authservice.fetchEntryType();
            request.getSession().setAttribute(OVERTIME_ENTRIES, overtimeEntryType);
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher(LOGIN_ERROR_URL);
            log.log(Level.WARNING, "Invalid login attempt by: " + user);
            rd.include(request, response);
        }
	}

	private Boolean validate(String user, String pwd) {
		authservice = new DefaultAuthenticationServiceImpl();
		
		Boolean success = authservice.validateLogin(user, pwd);
		return success;
	}
}
