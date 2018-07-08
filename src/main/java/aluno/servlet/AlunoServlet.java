package aluno.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aluno.domain.Aluno;

@WebServlet(urlPatterns= "/alunoController")
public class AlunoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Metodo Get chamado");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método GET!");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*System.out.println("Metodo Post chamado");
		resp.setCharacterEncoding("UTF-8");*/
		
		
		String nome = req.getParameter("nome");
		String idade = req.getParameter("idade");
		Aluno aln = new Aluno();
		aln.setNome(nome);
		aln.setIdade(Integer.parseInt(idade));
		resp.getWriter().print("Chamou pelo método POST... Nome : " + aln.getNome() + ", Idade: " + aln.getIdade());
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("text/plain");
		//resp.getWriter().print("index.html");
	}
}