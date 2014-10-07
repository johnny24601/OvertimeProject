package uk.co.tpplc.local.timesheet.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.tpplc.local.timesheet.service.impl.DefaultManageTimesheetServiceImpl;

/**
 * Servlet implementation class Start
 */
@WebServlet("/TimesheetController")
public class TimesheetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger( TimesheetController.class.getName() );
	
    /**
     * Default constructor. 
     */
    public TimesheetController() {
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
		
		DefaultManageTimesheetServiceImpl submit = new DefaultManageTimesheetServiceImpl();
		
		Boolean success = submit.writeTimesheetToDB(request);
		
		if (success) {
			request.setAttribute("success", success);
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
}
