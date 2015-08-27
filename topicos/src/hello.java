

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class hello
 */
@WebServlet({ "/TrataRequisicao","/hello", "/servlets/hello", "/html", "/hello.html" })
public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter saida = response.getWriter();
		saida.printf("<h1> Hello World </h1>");
		saida.printf("<p>Esse é um servlet servindo um HTML como respose</p>");
		saida.printf("<h1>Oi eu sou GOKU!</h1>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessao = request.getSession();
		RequestDispatcher despachante = request.getRequestDispatcher("saida.jsp");
		
		String usuario = request.getParameter("nmusuario");
		String senha = request.getParameter("nmsenha");
		
		if(usuario.equals("joao")  && senha.equals("123")){
			sessao.setAttribute("attrMensagem","Usuario Logado Com Sucesso");
		}else{
			sessao.setAttribute("attrMensagem", "Falha no Login");
		}
		
		despachante.forward(request, response);
		
		System.out.println("O usuario "+ usuario);
		System.out.println("Com senha "+ senha);
		System.out.println("Acabou de Logar");
	}

}
