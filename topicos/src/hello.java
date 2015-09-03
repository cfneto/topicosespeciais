

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
		/*PrintWriter saida = response.getWriter();
		saida.printf("<h1> Hello World </h1>");
		saida.printf("<p>Esse é um servlet servindo um HTML como respose</p>");
		saida.printf("<h1>Oi eu sou GOKU!</h1>");*/
		
		Connection conexao = null;
		PreparedStatement DeclaracaoSQL;
		
	    String url = "jdbc:mysql://127.0.0.1:3306/dbbiblioteca";
	    String username = "root";
	    String password = "";

	       try {
	         
	         Class.forName("com.mysql.jdbc.Driver").newInstance();	         
	         conexao = DriverManager.getConnection(url, username, password);
	         System.out.println("Conexao ok");
	         
	         String sql="INSERT INTO tblivros VALUES(?,?,?,?)";
	         
	         DeclaracaoSQL = conexao.prepareStatement(sql);
	         
	         DeclaracaoSQL.setString(1, request.getParameter("nmisbn"));
	         DeclaracaoSQL.setString(2, request.getParameter("nmtitulo"));
	         DeclaracaoSQL.setString(3, request.getParameter("nmautor"));
	         DeclaracaoSQL.setString(4, request.getParameter("nmeditor"));
	        
	        
	         /*
	         String sql="INSERT INTO tblivros "
	        		 +"VALUES ('"+request.getParameter("nmisbn")+"',"
     		 		+ "'"+request.getParameter("nmtitulo")+"',"
     		 		+ "'"+request.getParameter("nmautor")+"',"
     		 		+ "'"+request.getParameter("nmeditor")+"')";
	         */
	         System.out.println(sql);
	         
	         boolean retorno = DeclaracaoSQL.execute();
	         
	         

	       } catch (Exception e) {
	          System.out.println("Falha na conexão: " + e.getMessage());
	       }

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request,response);
		
		/*HttpSession sessao = request.getSession();
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
		System.out.println("Acabou de Logar");*/
	}

}
