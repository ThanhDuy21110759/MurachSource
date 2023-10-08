package murach.download;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import murach.business.*;
import murach.data.*;
import murach.util.*;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected String registerUser(HttpServletRequest request, 
			 	HttpServletResponse response) 
					 throws ServletException, IOException {
		// get the user data
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        // store the data in a User object
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        // write the User object to a file
        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.add(user, path);
        
        // store the User object as a session attribute
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // add a cookie that stores the user's email to browser
        Cookie c = new Cookie("emailCookie", email);
        c.setMaxAge(60 * 60 * 24 * 365 * 2); // set age to 2 years
        c.setPath("/");              // allow entire app to access it
        response.addCookie(c);

        // create an return a URL for the appropriate Download page
        String productCode = (String) 
            session.getAttribute("productCode");
        String url = "/" + productCode + "_download.jsp";
        
        return url;
	}
	
	protected String checkUser(HttpServletRequest request, 
			 HttpServletResponse response) 
					 throws ServletException, IOException {
		String productCode = request.getParameter("productCode");
		HttpSession session = request.getSession();
		session.setAttribute("productCode", productCode);
		User user = (User) session.getAttribute("user");
		
		String url;
		if (user == null) {
			Cookie[] cookies = request.getCookies();			
			String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie");
			
			if (emailAddress == null || emailAddress.equals("")) {
				return "/register.jsp";
			} else {
				ServletContext sc = getServletContext();
				String path = sc.getRealPath("/WEB-INF/EmailList.txt");
				user = UserIO.getUser(emailAddress, path);
				session.setAttribute("user", user);
				url = "/" + productCode + "_download.jsp";
			} 
		} else {
			url = "/" + productCode + "_download.jsp";
		}
		return url;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
								 throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if (action == null) {
			action = "viewAlbums";
		}

		//perform action vs URL
		String url = "/index.jsp";
		if (action.equals("viewAlbums") || action.equals("join")) {
            url = "/index.jsp";
        } else if (action.equals("checkUser")) {
            url = checkUser(request, response);
        } else if (action.equals("viewCookies")) {
            url = "/displays.jsp";
        } else if (action.equals("deleteCookies")) {
            url = deleteCookies(request, response);
        } 
		
		getServletContext()
				.getRequestDispatcher(url)
				.forward(request, response);
	}

	protected String deleteCookies(HttpServletRequest request, 
								 HttpServletResponse response) 
											throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0); //delete the cookie
            cookie.setPath("/"); //allow the download application to access it
            response.addCookie(cookie);
        }
        String url = "/delete_cookies.jsp";
        return url;
	}

	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) 
								  throws ServletException, IOException {		
		String action = request.getParameter("action");

		//
		String url = "/index.jsp";
		if (action.equals("registerUser")) {
			url = registerUser(request, response); 
		}
		getServletContext()
				.getRequestDispatcher(url)
				.forward(request, response);
	}	

}
