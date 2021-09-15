package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;

// Controller são as servlets

@WebServlet(urlPatterns = {"/principal/ServletLoginController", "/ServletLoginController"})
public class servletlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletlogin() {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(" Method doPost Funcionando !!");

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");

		if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {

			ModelLogin modellogin = new ModelLogin();
			modellogin.setLogin(login);
			modellogin.setSenha(senha);
			
			if(modellogin.getLogin().equalsIgnoreCase("admin") 
			&& modellogin.getSenha().equalsIgnoreCase("admin")) {
				
		// Registra o usuario na sessão passando o objeto login
				request.getSession().setAttribute("usuario", modellogin.getLogin());
				
				if(url==null || url.equals("null") ) {
					
					url="principal/principal.jsp";
				}
				
				RequestDispatcher redirecionar = request.getRequestDispatcher(url);
				redirecionar.forward(request, response);
				
				
			} else {
				
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Informe o login e senha corretamente");
				redirecionar.forward(request, response);
			}

		} else {

			// Redireciona com a resposta de volta

			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
// seta a mensagem no parametro msg que retornar para o front
			request.setAttribute("msg", "Informe o login e senha corretamente");
			redirecionar.forward(request, response);
		}

	}

}
