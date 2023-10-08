package murach.email;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import murach.business.User;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
								 throws ServletException, IOException {
		String url = "/index.jsp";
		
		// get current action
		String action = request.getParameter("action");
		if (action == null) {
			action = "join"; // default action
		}
		// perform action and set URL to appropriate page
		if (action.equals("join")) {
			url = "/index.jsp"; // the "join" page
		} else if (action.equals("add")) {
			
			// get parameters from the request
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			
			// store data in User object and save User object in database
			User user = new User(firstName, lastName, email);
			
			// set User object in request object and set URL
			request.setAttribute("user", user);		
			url = "/thanks.jsp"; // the "thanks" page
		}
		// forward request and response objects to specified URL
		getServletContext()
			.getRequestDispatcher(url)
			.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,
						  HttpServletResponse response)
								  throws ServletException, IOException {
		doGet(request, response);
	}
}
