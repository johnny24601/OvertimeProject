package uk.co.tpplc.local;

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

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger( Start.class.getName() );
    /**
     * Default constructor. 
     */
    public Start() {
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
		Date startDate = new Date();
		Date endDate = new Date();
		String type = request.getParameter("type");
		try {
			startDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("start"));
			endDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("end"));
		} catch (ParseException e) {
			e.printStackTrace();
			log.log(Level.SEVERE, e.getMessage(), e);
		}
		String description = request.getParameter("desc");
		String resolution = request.getParameter("res");
		System.out.println("Type: " + type);
		System.out.println("Start Date: " + startDate);
		System.out.println("End Date: " + endDate);
		System.out.println("Resolution: " + resolution);
		System.out.println("Description: " + description);
	}

}
