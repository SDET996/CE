package filterPack;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public HashMap<String, String> userData;

	public Login() {
		userData = new HashMap<String, String>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("login.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		String context = req.getContextPath();

		if (path.equals("/register")) {

			String login = req.getParameter("loginParam");
			String passwd = req.getParameter("passwd");

			userData.put(login, passwd);

			resp.sendRedirect(context + "/login.jsp");

		} else if (path.equals("/login")) {

			String login = req.getParameter("loginParam");
			String passwd = req.getParameter("passwd");

			if (passwd.equals(userData.get(login))) {

				getServletContext().setAttribute("isAuthorized", "authorized");
				resp.sendRedirect(context + "/converter.html");

			} else {
				resp.sendRedirect(context + "/register.html");
			}

		}

	}

}
