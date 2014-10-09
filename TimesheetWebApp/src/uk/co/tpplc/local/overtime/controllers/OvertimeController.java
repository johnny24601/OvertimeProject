package uk.co.tpplc.local.overtime.controllers;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.tpplc.local.overtime.service.impl.DefaultManageOvertimeServiceImpl;

@WebServlet("/OvertimeController")
public class OvertimeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger( OvertimeController.class.getName() );
	private static final String SUBMIT_SUCCESS_URL = "/success.jsp";
	private static final String SUBMIT_ERROR_URL = "/submitError.jsp";
	
	DefaultManageOvertimeServiceImpl submit;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWrite(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doWrite(request, response);
	}
	
	private void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		submit = new DefaultManageOvertimeServiceImpl();
		
		Boolean success = submit.writeOvertimeToDB(request);
		
		if (success) {
			RequestDispatcher rd = request.getRequestDispatcher(SUBMIT_SUCCESS_URL);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(SUBMIT_ERROR_URL);
			rd.include(request, response);
			// TODO add exception handling
		}
	}
}
