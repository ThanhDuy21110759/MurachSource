package murach.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.User;

@WebServlet("/survey")
public class SurveyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    @Override
    protected void doPost(HttpServletRequest request,
            			  HttpServletResponse response)
            			  throws ServletException, IOException {   	
    	String url = "/index.jsp";
    	
    	String action = request.getParameter("action");
    	if (action == null) url = "/index.jsp";
    	else if (action.equals("add")) {
    		// get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String birth = request.getParameter("birth");
            String heardFrom = request.getParameter("heardFrom");
            String wantsUpdates = request.getParameter("wantsUpdates");    
            String wantsSendMail = request.getParameter("wantsSendmail");
            String contactVia = request.getParameter("contactVia");
            
            // process parameters
            if (heardFrom == null) {
                heardFrom = "NA";
            }
            // process parameters updates
            if (wantsUpdates == null) {
                wantsUpdates = "No";
            } else {
                wantsUpdates = "Yes";
            }               
            // process parameters Send mail
            if (wantsSendMail == null) {
            	wantsSendMail = "No";
            } else {
            	wantsSendMail = "Yes";
            }
            
            // store data in User object
            User user = new User();           
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);     
            user.setBirth(birth);
            user.setHeardFrom(heardFrom);        
            user.setWantsUpdates(wantsUpdates);        
            user.setContactVia(contactVia);
            user.setWantsSendMail(wantsSendMail);

            // store User object in request
            request.setAttribute("user", user);
            url = "/survey.jsp";
    	} else if (action.equals("join")) url = "/index.jsp";
        
        getServletContext()
     		.getRequestDispatcher(url)
     		.forward(request, response); 
	}		     		   	   
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}