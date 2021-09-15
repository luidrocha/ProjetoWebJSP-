package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//Intercepta todas as requisições que vierem do projeto ou mapeamento, nesse caso da pasta principal




@WebFilter(urlPatterns = {"/PRINCIPAL/*", "/principal/*" })
public class LoginFilter implements Filter {

	public LoginFilter() {

	}

	// Encerra os processos quando o servidor e parado
	// Mataria o processo de conexao com o banco por exemplo
	public void destroy() {

	}

	// ntercepta as requisições e as respostas do sistema
	// Tudo que fizer no sistema vai passar por aqui
	// Validar autenticação, Da commite e Rollback nas transações de banco
	// Validar e fazer redirecionamento de pagina
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String usuarioLogado = (String) session.getAttribute("usuario");
		String urlParaAutenticar = req.getServletPath(); // Pega a url pque esta sendo acessada.

		if (usuarioLogado == null 
				&&  !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {

			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=urlParaAutenticar");
			request.setAttribute("msg", "Efetue o login para ter acesso ao Site !!!");
			redireciona.forward(request, response);
			return; // Para a execucao e redireciona para o login
		} else {

			chain.doFilter(request, response);
		}
	}

	// Inicia os processos ou recursos quando o servidor sobre o projeto
	// Conexão com o banco por exemplo.

	
	

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
